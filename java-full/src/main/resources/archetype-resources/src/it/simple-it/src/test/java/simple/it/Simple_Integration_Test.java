package ${package}.simple.it;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ${package}.AppRunner;

/** Simple Integration Test. */
class Simple_Integration_Test {
  private AppImplementation appImpl;
  private AppRunner runner;

  @BeforeEach
  void initialize() {
    appImpl = new AppImplementation();
    runner = new AppRunner(appImpl);
  }

  @Test
  void an_enacpsulated_running_application_should_be_registered_as_running() {
    appImpl.start();
    assertThat(runner.isAppRunning()).isTrue();
  }

  @Test
  void an_enacpsulated_stopped_application_should_not_be_registered_as_running() {
    appImpl.stop();
    assertThat(runner.isAppRunning()).isFalse();
  }
}
