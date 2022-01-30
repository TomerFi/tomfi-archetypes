package archetypes.it.run.extratests;

/** Application interface used for contracting applications. */
interface AppInterface {
  /**
   * Test whether or not the application is running.
   *
   * @return true if the application is running.
   */
  boolean running();
}
