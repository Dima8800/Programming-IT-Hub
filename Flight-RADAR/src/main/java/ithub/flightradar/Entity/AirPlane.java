package ithub.flightradar.Entity;

public class AirPlane {
  private int xStart;
  private int yStart;
  private int xFinish;
  private int yFinish;
  private int speed;

  public AirPlane (int xStart, int yStart, int xFinish, int yFinish, int speed) {
    this.xStart = xStart;
    this.yStart = yStart;
    this.xFinish = xFinish;
    this.yFinish = yFinish;
    this.speed = speed;
  }

  public int getSpeed () {
    return speed;
  }

  public void setSpeed (int speed) {
    this.speed = speed;
  }

  public Coorginate getStart(){
    return new Coorginate(xStart,yStart);
  }
  public Coorginate getFinish(){
    return new Coorginate(xFinish,yFinish);
  }
  public int getxStart () {
    return xStart;
  }

  public void setxStart (int xStart) {
    this.xStart = xStart;
  }

  public int getyStart () {
    return yStart;
  }

  public void setyStart (int yStart) {
    this.yStart = yStart;
  }

  public int getxFinish () {
    return xFinish;
  }

  public void setxFinish (int xFinish) {
    this.xFinish = xFinish;
  }

  public int getyFinish () {
    return yFinish;
  }

  public void setyFinish (int yFinish) {
    this.yFinish = yFinish;
  }
}
