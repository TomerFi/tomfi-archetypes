<!-- markdownlint-disable-file MD033 MD038  MD046  -->
``` shell hl_lines="3"
mvn archetype:generate \
-DarchetypeGroupId=info.tomfi.archetypes \
-DarchetypeArtifactId=java-full \
-DarchetypeVersion=1.1.6
```

???- example "archetype properties"
    | property   | example value     |
    | :---------- | :---------------- |
    | developerId | jdoe              |
    | ownerId     | doeOrganization   |
    | ownerName   | Doe Organization  |
    | year        | 2042              |
    | groupId     | my.group.example  |
    | artifactId  | my-artifact-demo  |
    | version     | 0.0.1-SNAPSHOT    |
    | package     | my.sample.package |

```shell
$ tree -a my-artifact-demo/

my-artifact-demo/
├── .editorconfig
├── .gitattributes
├── .gitignore
├── LICENSE
├── .mvn
│   └── jvm.config
├── pom.xml
├── README.md
└── src
    ├── it
    │   ├── settings.xml
    │   └── simple-it
    │       ├── pom.xml
    │       └── src
    │           ├── main
    │           │   └── java
    │           │       └── my
    │           │           └── sample
    │           │               └── package
    │           │                   └── simple
    │           │                       └── it
    │           │                           └── AppImplementation.java
    │           └── test
    │               └── java
    │                   └── my
    │                       └── sample
    │                           └── package
    │                               └── simple
    │                                   └── it
    │                                       └── Simple_Integration_Test.java
    ├── main
    │   └── java
    │       └── my
    │           └── sample
    │               └── package
    │                   ├── AppInterface.java
    │                   ├── AppRunner.java
    │                   └── package-info.java
    └── test
        └── java
            └── my
                └── sample
                    └── package
                        └── App_Runner_Test.java
```

???- example "my-artifact-demo/pom.xml"
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>

    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>

      <groupId>my.group.example</groupId>
      <artifactId>my-artifact-demo</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <!-- TODO set project info -->
      <name>Example name</name>
      <description>Example description.</description>
      <url>https://example.com/</url>
      <inceptionYear>2042</inceptionYear>

      <properties>
        <code.coverage.threshold>85%</code.coverage.threshold>
        <mutation.coverage.threshold>50</mutation.coverage.threshold>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.release>17</maven.compiler.release>
        <!-- Dependencies -->
        <assertj.version>3.22.0</assertj.version>
        <junit-jupiter.version>5.8.2</junit-jupiter.version>
        <mockito.version>4.3.1</mockito.version>
        <!-- Plugins -->
        <maven-clean-plugin.version>3.1.0</maven-clean-plugin.version>
        <maven-compiler-plugin.version>3.9.0</maven-compiler-plugin.version>
        <maven-dependency-plugin.version>3.2.0</maven-dependency-plugin.version>
        <maven-deploy-plugin.version>3.0.0-M2</maven-deploy-plugin.version>
        <maven-enforcer-plugin.version>3.0.0</maven-enforcer-plugin.version>
        <maven-gpg-plugin.version>3.0.1</maven-gpg-plugin.version>
        <maven-help-plugin.version>3.2.0</maven-help-plugin.version>
        <maven-install-plugin.version>3.0.0-M1</maven-install-plugin.version>
        <maven-invoker-plugin.version>3.2.2</maven-invoker-plugin.version>
        <maven-jar-plugin.version>3.2.2</maven-jar-plugin.version>
        <maven-javadoc-plugin.version>3.3.1</maven-javadoc-plugin.version>
        <maven-release-plugin.version>3.0.0-M5</maven-release-plugin.version>
        <maven-resources-plugin.version>3.2.0</maven-resources-plugin.version>
        <maven-site-plugin.version>3.10.0</maven-site-plugin.version>
        <maven-source-plugin.version>3.2.1</maven-source-plugin.version>
        <maven-surefire-plugin.version>3.0.0-M5</maven-surefire-plugin.version>
        <extra-enforcer-rules.version>1.5.1</extra-enforcer-rules.version>
        <flatten-maven-plugin.version>1.2.7</flatten-maven-plugin.version>
        <jacoco-maven-plugin.version>0.8.7</jacoco-maven-plugin.version>
        <junit-platform-maven-plugin.version>1.1.6</junit-platform-maven-plugin.version>
        <license-maven-plugin.version>4.1</license-maven-plugin.version>
        <nexus-staging-maven-plugin.version>1.6.8</nexus-staging-maven-plugin.version>
        <pitest-maven.version>1.7.3</pitest-maven.version>
        <pitest-junit5-plugin.version>0.15</pitest-junit5-plugin.version>
        <versions-maven-plugin.version>2.9.0</versions-maven-plugin.version>
      </properties>

      <licenses>
        <license>
          <name>MIT License</name>
          <url>https://opensource.org/licenses/MIT</url>
          <distribution>repo</distribution>
        </license>
      </licenses>

      <developers>
        <developer>
          <id>jdoe</id>
          <url>https://github.com/jdoe</url>
        </developer>
      </developers>

      <issueManagement>
        <system>GitHub Issues</system>
        <url>https://github.com/doeOrganization/my-artifact-demo/issues</url>
      </issueManagement>

      <scm>
        <url>https://github.com/doeOrganization/my-artifact-demo</url>
        <connection>scm:git:git@github.com:doeOrganization/my-artifact-demo.git</connection>
        <developerConnection>scm:git:git@github.com:doeOrganization/my-artifact-demo.git</developerConnection>
        <tag>HEAD</tag>
      </scm>

      <ciManagement>
        <system>GitHub Workflows</system>
        <url>https://github.com/doeOrganization/my-artifact-demo/actions</url>
      </ciManagement>

      <dependencyManagement>
        <dependencies>
          <!-- Testing Dependencies -->
          <dependency>
            <groupId>org.assertj</groupId>
            <artifactId>assertj-core</artifactId>
            <version>${assertj.version}</version>
          </dependency>
          <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit-jupiter.version}</version>
          </dependency>
          <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit-jupiter.version}</version>
          </dependency>
          <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>${mockito.version}</version>
          </dependency>
          <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>${mockito.version}</version>
          </dependency>
        </dependencies>
      </dependencyManagement>

      <dependencies>
        <!-- Testing Dependencies -->
        <dependency>
          <groupId>org.assertj</groupId>
          <artifactId>assertj-core</artifactId>
          <scope>test</scope>
        </dependency>
        <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-api</artifactId>
          <scope>test</scope>
        </dependency>
        <dependency>
          <groupId>org.mockito</groupId>
          <artifactId>mockito-core</artifactId>
          <scope>test</scope>
        </dependency>
        <dependency>
          <groupId>org.mockito</groupId>
          <artifactId>mockito-junit-jupiter</artifactId>
          <scope>test</scope>
        </dependency>
      </dependencies>

      <build>
        <pluginManagement>
          <plugins>
            <!-- Apache Plugins -->
            <plugin>
              <artifactId>maven-clean-plugin</artifactId>
              <version>${maven-clean-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-compiler-plugin</artifactId>
              <version>${maven-compiler-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-deploy-plugin</artifactId>
              <version>${maven-deploy-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-dependency-plugin</artifactId>
              <version>${maven-dependency-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-enforcer-plugin</artifactId>
              <version>${maven-enforcer-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-gpg-plugin</artifactId>
              <version>${maven-gpg-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-help-plugin</artifactId>
              <version>${maven-help-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-install-plugin</artifactId>
              <version>${maven-install-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-invoker-plugin</artifactId>
              <version>${maven-invoker-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-jar-plugin</artifactId>
              <version>${maven-jar-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-javadoc-plugin</artifactId>
              <version>${maven-javadoc-plugin.version}</version>
              <configuration>
                <doclint>all,-missing</doclint>
              </configuration>
            </plugin>
            <plugin>
              <artifactId>maven-release-plugin</artifactId>
              <version>${maven-release-plugin.version}</version>
              <configuration>
                <arguments>-Pprepare-deployment,sign-deployment,deploy-ossrh</arguments>
                <scmCommentPrefix>build(release): [skip ci] </scmCommentPrefix>
                <signTag>true</signTag>
              </configuration>
            </plugin>
            <plugin>
              <artifactId>maven-resources-plugin</artifactId>
              <version>${maven-resources-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-site-plugin</artifactId>
              <version>${maven-site-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-source-plugin</artifactId>
              <version>${maven-source-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-surefire-plugin</artifactId>
              <version>${maven-surefire-plugin.version}</version>
            </plugin>
            <!-- Third-Party Plugins -->
            <plugin>
              <groupId>com.mycila</groupId>
              <artifactId>license-maven-plugin</artifactId>
              <version>${license-maven-plugin.version}</version>
              <configuration>
                <excludes>
                  <exclude>**/module-info.java</exclude>
                  <exclude>**/package-info.java</exclude>
                </excludes>
                <includes>
                  <include>src/main/**</include>
                  <include>src/test/**</include>
                  <include>src/it/**/src/main/**</include>
                  <include>src/it/**/src/test/**</include>
                </includes>
                <inlineHeader><![CDATA[Copyright 2042 Doe Organization.

    Use of this source code is governed by an MIT-style
    license that can be found in the LICENSE file or at
    https://opensource.org/licenses/MIT.]]>
                </inlineHeader>
                <skipExistingHeaders>false</skipExistingHeaders>
              </configuration>
            </plugin>
            <plugin>
              <groupId>de.sormuras.junit</groupId>
              <artifactId>junit-platform-maven-plugin</artifactId>
              <version>${junit-platform-maven-plugin.version}</version>
            </plugin>
            <plugin>
              <groupId>org.codehaus.mojo</groupId>
              <artifactId>flatten-maven-plugin</artifactId>
              <version>${flatten-maven-plugin.version}</version>
              <configuration>
                <flattenMode>ossrh</flattenMode>
              </configuration>
            </plugin>
            <plugin>
              <groupId>org.codehaus.mojo</groupId>
              <artifactId>versions-maven-plugin</artifactId>
              <version>${versions-maven-plugin.version}</version>
            </plugin>
            <plugin>
              <groupId>org.jacoco</groupId>
              <artifactId>jacoco-maven-plugin</artifactId>
              <version>${jacoco-maven-plugin.version}</version>
              <configuration>
                <propertyName>jacoco.java.option</propertyName>
                <rules>
                  <rule>
                    <limits>
                      <limit>
                        <minimum>${code.coverage.threshold}</minimum>
                      </limit>
                    </limits>
                  </rule>
                </rules>
              </configuration>
            </plugin>
            <plugin>
              <groupId>org.pitest</groupId>
              <artifactId>pitest-maven</artifactId>
              <version>${pitest-maven.version}</version>
              <dependencies>
                <dependency>
                  <groupId>org.pitest</groupId>
                  <artifactId>pitest-junit5-plugin</artifactId>
                  <version>${pitest-junit5-plugin.version}</version>
                </dependency>
              </dependencies>
              <configuration>
                <exportLineCoverage>true</exportLineCoverage>
                <mutationThreshold>${mutation.coverage.threshold}</mutationThreshold>
                <mutators>
                  <mutator>STRONGER</mutator>
                </mutators>
                <timestampedReports>false</timestampedReports>
              </configuration>
            </plugin>
            <plugin>
              <groupId>org.sonatype.plugins</groupId>
              <artifactId>nexus-staging-maven-plugin</artifactId>
              <version>${nexus-staging-maven-plugin.version}</version>
            </plugin>
          </plugins>
        </pluginManagement>

        <plugins>
          <plugin>
            <groupId>de.sormuras.junit</groupId>
            <artifactId>junit-platform-maven-plugin</artifactId>
            <extensions>true</extensions>
            <configuration>
              <executor>JAVA</executor>
              <javaOptions>
                <additionalOptions>
                  <jacoco>${jacoco.java.option}</jacoco>
                </additionalOptions>
              </javaOptions>
              <parameters>
                <junit.jupiter.execution.parallel.enabled>false</junit.jupiter.execution.parallel.enabled>
                <junit.jupiter.execution.parallel.mode.default>concurrent</junit.jupiter.execution.parallel.mode.default>
                <junit.jupiter.displayname.generator.default>org.junit.jupiter.api.DisplayNameGenerator$ReplaceUnderscores</junit.jupiter.displayname.generator.default><!-- editorconfig-checker-disable-line -->
              </parameters>
            </configuration>
          </plugin>

          <plugin>
            <groupId>org.jacoco</groupId>
            <artifactId>jacoco-maven-plugin</artifactId>
            <executions>
              <execution>
                <goals>
                  <goal>prepare-agent</goal>
                  <goal>check</goal>
                </goals>
              </execution>
            </executions>
          </plugin>

          <plugin>
            <artifactId>maven-help-plugin</artifactId>
            <executions>
              <execution>
                <phase>validate</phase>
                <goals>
                  <goal>active-profiles</goal>
                </goals>
              </execution>
            </executions>
          </plugin>

          <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>flatten-maven-plugin</artifactId>
            <executions>
              <execution>
                <id>flatten.clean</id>
                <phase>clean</phase>
                <goals>
                  <goal>clean</goal>
                </goals>
              </execution>
            </executions>
          </plugin>

          <plugin>
            <artifactId>maven-enforcer-plugin</artifactId>
            <dependencies>
              <dependency>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>extra-enforcer-rules</artifactId>
                <version>${extra-enforcer-rules.version}</version>
              </dependency>
            </dependencies>
            <executions>
              <execution>
                <goals>
                  <goal>enforce</goal>
                </goals>
              </execution>
            </executions>
            <configuration>
              <rules>
                <dependencyConvergence />
                <requireJavaVersion>
                  <version>[17,)</version>
                </requireJavaVersion>
                <requireMavenVersion>
                  <version>[3.8,)</version>
                </requireMavenVersion>
                <banDuplicateClasses />
                <banCircularDependencies />
              </rules>
            </configuration>
          </plugin>

          <plugin>
            <groupId>com.mycila</groupId>
            <artifactId>license-maven-plugin</artifactId>
            <executions>
              <execution>
                <goals>
                  <goal>check</goal>
                </goals>
              </execution>
            </executions>
          </plugin>
        </plugins>
      </build>

      <profiles>
        <!-- use this profile for development stage. -->
        <profile>
          <id>dev</id>
          <properties>
            <code.coverage.threshold>0%</code.coverage.threshold>
            <mutation.coverage.threshold>0</mutation.coverage.threshold>
            <enforcer.skip>true</enforcer.skip>
            <license.skip>true</license.skip>
          </properties>
          <build>
            <plugins>
              <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                  <failOnWarning>false</failOnWarning>
                </configuration>
              </plugin>
            </plugins>
          </build>
        </profile>
        <!-- Use this profile to create jacoco execution report. -->
        <profile>
          <id>cov</id>
          <build>
            <plugins>
              <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <executions>
                  <execution>
                    <id>jacoco-report</id>
                    <goals>
                        <goal>report</goal>
                    </goals>
                  </execution>
                </executions>
              </plugin>
            </plugins>
          </build>
        </profile>
        <!-- Use this profile to execute integration testing. -->
        <profile>
          <id>its</id>
          <build>
            <plugins>
              <plugin>
                <artifactId>maven-invoker-plugin</artifactId>
                <configuration>
                  <cloneProjectsTo>${project.build.directory}/it</cloneProjectsTo>
                  <localRepositoryPath>${project.build.directory}/local-it-repo</localRepositoryPath>
                  <goals>
                    <goal>test</goal>
                  </goals>
                  <settingsFile>src/it/settings.xml</settingsFile>
                  <showErrors>true</showErrors>
                </configuration>
                <executions>
                  <execution>
                    <goals>
                      <goal>install</goal>
                      <goal>run</goal>
                    </goals>
                  </execution>
                </executions>
              </plugin>
            </plugins>
          </build>
        </profile>
        <!-- Use this profile to execute mutation testing. -->
        <profile>
          <id>mut</id>
          <dependencies>
            <dependency>
              <groupId>org.junit.jupiter</groupId>
              <artifactId>junit-jupiter-engine</artifactId>
              <scope>test</scope>
            </dependency>
          </dependencies>
          <build>
            <plugins>
              <plugin>
                <groupId>org.pitest</groupId>
                <artifactId>pitest-maven</artifactId>
                <executions>
                  <execution>
                    <phase>verify</phase>
                    <goals>
                      <!-- REC: modify to scmMutationCoverage once the project starts -->
                      <goal>mutationCoverage</goal>
                    </goals>
                  </execution>
                </executions>
              </plugin>
            </plugins>
          </build>
        </profile>
        <!-- use this profile manually when deploying to ossrh. -->
        <!-- requires credentials set for ossrh in ~/.m2/settings.xml -->
        <profile>
          <id>deploy-ossrh</id>
          <distributionManagement>
            <snapshotRepository>
              <id>ossrh</id>
              <url>https://oss.sonatype.org/content/repositories/snapshots</url>
            </snapshotRepository>
          </distributionManagement>
          <build>
            <plugins>
              <!-- Note that the staging plugin requires jpms instructions, see .mvn/jvm.config -->
              <!-- https://issues.sonatype.org/browse/OSSRH-66257 -->
              <plugin>
                <groupId>org.sonatype.plugins</groupId>
                <artifactId>nexus-staging-maven-plugin</artifactId>
                <extensions>true</extensions>
                <configuration>
                  <serverId>ossrh</serverId>
                  <nexusUrl>https://oss.sonatype.org</nexusUrl>
                  <autoReleaseAfterClose>true</autoReleaseAfterClose>
                </configuration>
              </plugin>
            </plugins>
          </build>
        </profile>
        <!-- use this profile manually for packaging of jars to deploy to artifact repository. -->
        <profile>
          <id>prepare-deployment</id>
          <build>
            <plugins>
              <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>flatten-maven-plugin</artifactId>
                <executions>
                  <execution>
                    <id>flatten</id>
                    <phase>process-resources</phase>
                    <goals>
                      <goal>flatten</goal>
                    </goals>
                  </execution>
                </executions>
              </plugin>
              <plugin>
                <artifactId>maven-source-plugin</artifactId>
                <executions>
                  <execution>
                    <goals>
                      <goal>jar</goal>
                    </goals>
                  </execution>
                </executions>
              </plugin>
              <plugin>
                <artifactId>maven-javadoc-plugin</artifactId>
                <executions>
                  <execution>
                    <goals>
                      <goal>jar</goal>
                    </goals>
                  </execution>
                </executions>
              </plugin>

            </plugins>
          </build>
        </profile>
        <!-- use this profile manually for signing the deployment files prior to deployment. -->
        <!-- requires gpg configured, follow https://maven.apache.org/plugins/maven-gpg-plugin/usage.html -->
        <profile>
          <id>sign-deployment</id>
          <build>
            <plugins>
              <plugin>
                <artifactId>maven-gpg-plugin</artifactId>
                <executions>
                  <execution>
                    <phase>verify</phase>
                    <goals>
                      <goal>sign</goal>
                    </goals>
                  </execution>
                </executions>
                <configuration>
                  <gpgArguments>
                    <arg>--pinentry-mode</arg>
                    <arg>loopback</arg>
                  </gpgArguments>
                </configuration>
              </plugin>
            </plugins>
          </build>
        </profile>
      </profiles>
    </project>
    ```

???- example "my-artifact-demo/src/it/simple-it/pom.xml"
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>

      <groupId>my.group.example.integrationtests</groupId>
      <artifactId>my-artifact-demo-simple-integrationtest</artifactId>
      <version>0.0.1</version>
      <name>my-artifact-demo-simple-integrationtest</name>

      <properties>
        <maven.compiler.release>17</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.deploy.skip>true</maven.deploy.skip>
        <maven.install.skip>true</maven.install.skip>
      </properties>

      <dependencies>
        <dependency>
          <groupId>my.group.example</groupId>
          <artifactId>my-artifact-demo</artifactId>
          <version>@project.version@</version>
        </dependency>
        <dependency>
          <groupId>org.assertj</groupId>
          <artifactId>assertj-core</artifactId>
          <version>3.22.0</version>
          <scope>test</scope>
        </dependency>
        <dependency>
          <groupId>org.junit.jupiter</groupId>
          <artifactId>junit-jupiter-api</artifactId>
          <version>5.8.2</version>
          <scope>test</scope>
        </dependency>
      </dependencies>

      <build>
        <defaultGoal>test</defaultGoal>

        <plugins>
          <plugin>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.9.0</version>
          </plugin>
          <plugin>
            <groupId>de.sormuras.junit</groupId>
            <artifactId>junit-platform-maven-plugin</artifactId>
            <version>1.1.6</version>
            <extensions>true</extensions>
          </plugin>
        </plugins>

      </build>
    </project>
    ```
