package archetypes.it.prepare.deployment;

/** Application runner for encapsulating the application. */
public final class AppRunner {
  private final AppInterface runningApp;

  /**
   * Constructor that takes the enacpsulated application.
   *
   * @param appToRun {@link AppInterface} impelementation.
   */
  public AppRunner(final AppInterface appToRun) {
    runningApp = appToRun;
  }

  /**
   * Test whether or not the enacpsualted application is running.
   *
   * @return true if the enacpsulated application is running.
   */
  public boolean isAppRunning() {
    return runningApp.running();
  }
}
