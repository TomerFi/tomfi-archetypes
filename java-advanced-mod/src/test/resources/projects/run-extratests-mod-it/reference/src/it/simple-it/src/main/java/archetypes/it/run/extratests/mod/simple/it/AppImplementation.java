package archetypes.it.run.extratests.mod.simple.it;

import archetypes.it.run.extratests.mod.AppInterface;

class AppImplementation implements AppInterface {
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
