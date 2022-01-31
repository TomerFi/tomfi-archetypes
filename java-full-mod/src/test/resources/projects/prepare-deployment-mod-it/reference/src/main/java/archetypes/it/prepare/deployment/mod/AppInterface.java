/*
 * Copyright 2042 Jon Doe.
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */
package archetypes.it.prepare.deployment.mod;

/** Application interface used for contracting applications. */
public interface AppInterface {
  /**
   * Test whether or not the application is running.
   *
   * @return true if the application is running.
   */
  public boolean running();
}
