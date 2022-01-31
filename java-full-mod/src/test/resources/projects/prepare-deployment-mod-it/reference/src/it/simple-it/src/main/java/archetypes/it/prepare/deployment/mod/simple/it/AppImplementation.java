package archetypes.it.prepare.deployment.mod.simple.it;

import archetypes.it.prepare.deployment.mod.AppInterface;

/** Concrete implementation of the AppInterface. */
final class AppImplementation implements AppInterface {
  private boolean isRunning;

  @Override
  public boolean running() {
    return this.isRunning;
  }

  /** Use to start the application. */
  public void start() {
    isRunning = true;
  }

  /** Use to stop the application. */
  public void stop() {
    isRunning = false;
  }
}
