package ${package}.simple.it;

import ${package}.AppInterface;

public class AppImplementation implements AppInterface {
  private boolean isRunning;

  @Override
  public boolean running() {
    return this.isRunning;
  }

  public void start() {
    isRunning = true;
  }

  public void stop() {
    isRunning = false;
  }
}
