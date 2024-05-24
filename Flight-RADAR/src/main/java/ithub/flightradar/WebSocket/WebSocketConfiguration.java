package ithub.flightradar.WebSocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
@EnableScheduling
public class WebSocketConfiguration implements WebSocketConfigurer {

  @Autowired
  private MyWebSocketFlightRadar MyWebSocketFlightRadar;

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(MyWebSocketFlightRadar, "/plane")
      .setAllowedOrigins("*");
  }

}
