package ithub.telemetry;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
class MyWebSocketHandler extends TextWebSocketHandler {

  private int i = 0;
  private int number = 0;
  private List<WebSocketSession> sessions = new ArrayList<>();

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    sessions.add(session);
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    sessions.remove(session);
  }

  @MessageMapping("/send")
  @SendTo("/number")
  public String handleMessage(String message) {
    return "Дурак что ли";
  }

  @Scheduled(fixedRate = 1000 / 60)
  public void sendNumber() {
    Random random = new Random();
    i++;
    if (i == 60){
      number = random.nextInt(3)-1;
      i = 0;
    }
    for (WebSocketSession session : sessions) {
      try {
        session.sendMessage(new TextMessage("{\"data\":" + number + "}"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}