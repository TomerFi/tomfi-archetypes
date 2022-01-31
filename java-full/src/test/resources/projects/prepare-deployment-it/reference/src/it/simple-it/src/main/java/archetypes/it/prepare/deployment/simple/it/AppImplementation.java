package archetypes.it.prepare.deployment.simple.it;

import archetypes.it.prepare.deployment.AppInterface;

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
