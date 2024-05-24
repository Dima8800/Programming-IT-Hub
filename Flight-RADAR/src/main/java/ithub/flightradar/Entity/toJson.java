package ithub.flightradar.Entity;

public class toJson {
  public String messageToHTTP(AirPlane coordinates, String ID){
    return "{\"xs\":" + coordinates.getxStart()
      + ",\"ys\":" + coordinates.getyStart()
      + ",\"xf\":" + coordinates.getxFinish()
      + ",\"yf\":" + coordinates.getyFinish()
      + ",\"id\":\"" + ID + "\""
      + "}";
  }
  public String messageCoordinate(Coorginate xy, String ID){
    return "{\"x\":" + (int) xy.getX()
      + ",\"y\":" + (int) xy.getY()
      + ",\"id\":\""+ID +"\"}" ;
  }
}
