package ithub.flightradar.WebSocket;

import ithub.flightradar.Entity.*;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class MyWebSocketFlightRadar extends TextWebSocketHandler{
  private String ID = "0";
  toJson json = new toJson();
  Random random = new Random();
  AirPlane coordinates = new AirPlane(random.nextInt(1001),random.nextInt(1001),random.nextInt(1001),random.nextInt(1001),random.nextInt(401)+100);
  Coorginate xy = new Coorginate(coordinates.getxStart(),coordinates.getyStart());
  double distanceX = coordinates.getxFinish() - coordinates.getxStart();
  double distanceY = coordinates.getyFinish() - coordinates.getyStart();
  private List<WebSocketSession> sessions = new ArrayList<>();

  @CrossOrigin(origins = "*")
  @RequestMapping(value = "/getAirplane", method = {RequestMethod.GET, RequestMethod.POST})
  public ResponseEntity<String> helloWorld() {
    System.out.println(json.messageToHTTP(coordinates, ID));
    return ResponseEntity.ok(json.messageToHTTP(coordinates, ID));
  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    System.out.println("new connection");
    sessions.add(session);
    System.out.println(session.getId());
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    sessions.remove(session);
  }

  @Scheduled(fixedRate = 100)
  public void sendCoordinateAirPlane() {
    if (chekFinishAirPlane()){
      GenerateAirPlane();
      distanceX = coordinates.getxFinish() - coordinates.getxStart();
      distanceY = coordinates.getyFinish() - coordinates.getyStart();
    }else {
      double stepSizeX = distanceX / coordinates.getSpeed();
      double stepSizeY = distanceY / coordinates.getSpeed();

      if (xy.getX() + stepSizeX < coordinates.getxFinish() && coordinates.getxStart() < coordinates.getxFinish()) {
        xy.setX(xy.getX() + stepSizeX);
        xy.setY(xy.getY() + stepSizeY);
      } else if (xy.getX() + stepSizeX > coordinates.getxFinish() && coordinates.getxStart() > coordinates.getxFinish()) {
        xy.setX(xy.getX() + stepSizeX);
        xy.setY(xy.getY() + stepSizeY);
      }else {
        xy.setX(coordinates.getxFinish());
        xy.setY(coordinates.getyFinish());
      }
    }
    for (WebSocketSession session : sessions) {
      try {
        System.out.println("ws");
        session.sendMessage(new TextMessage(json.messageCoordinate(xy,ID)));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  private boolean chekFinishAirPlane(){
    if (coordinates.getxFinish() == (int) xy.getX() && coordinates.getyFinish() == (int) xy.getY()){
      return true;
    }
    return false;
  }
  private void GenerateAirPlane(){
    coordinates.setxStart(random.nextInt(1001));
    coordinates.setyStart(random.nextInt(1001));
    coordinates.setxFinish(random.nextInt(1001));
    coordinates.setyFinish(random.nextInt(1001));
    coordinates.setSpeed(random.nextInt(401)+100);
    xy.setX(coordinates.getxStart());
    xy.setY(coordinates.getyStart());
    ID = Integer.toString(Integer.parseInt(ID)+1);
  }
}
