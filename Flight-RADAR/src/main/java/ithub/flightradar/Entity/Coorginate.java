package ithub.flightradar.Entity;

public class Coorginate{
  private double x;
  private double y;

  public Coorginate (double x, double y) {
    this.x = x;
    this.y = y;
  }
  public Coorginate getCoordinate(){
    return this;
  }

  public double getX () {
    return x;
  }

  public void setX (double x) {
    this.x = x;
  }

  public double getY () {
    return y;
  }

  public void setY (double y) {
    this.y = y;
  }
}
