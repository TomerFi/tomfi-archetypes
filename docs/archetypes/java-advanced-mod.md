```shell
mvn archetype:generate \
-DarchetypeGroupId=info.tomfi.archetypes \
-DarchetypeArtifactId=java-advanced-mod \
-DarchetypeVersion=1.0.0
```

???- example "archetype properties"
    | property   | example value     |
    | :--------- | :---------------- |
    | module     | my.module.name    |
    | ownerName  | John Doe          |
    | year       | 2042              |
    | groupId    | my.group.example  |
    | artifactId | my-artifact-demo  |
    | version    | 0.0.1-SNAPSHOT    |
    | package    | my.sample.package |

```shell
$ tree -a my-artifact-demo/
```

```shell
my-artifact-demo/
├── .editorconfig
├── .gitattributes
├── .gitignore
├── LICENSE
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
    │           │       ├── module-info.java
    │           │       └── my
    │           │           └── sample
    │           │               └── package
    │           │                   └── simple
    │           │                       └── it
    │           │                           └── AppImplementation.java
    │           └── test
    │               └── java
    │                   ├── module-info.test
    │                   └── my
    │                       └── sample
    │                           └── package
    │                               └── simple
    │                                   └── it
    │                                       └── Simple_Integration_Test.java
    ├── main
    │   └── java
    │       ├── module-info.java
    │       └── my
    │           └── sample
    │               └── package
    │                   ├── AppInterface.java
    │                   ├── AppRunner.java
    │                   └── package-info.java
    └── test
        └── java
            ├── module-info.test
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
      <parent>
        <artifactId>tomfi-archetypes-parent</artifactId>
        <groupId>info.tomfi.archetypes</groupId>
        <version>1.0.1-SNAPSHOT</version>
      </parent>

      <groupId>my.group.example</groupId>
      <artifactId>my-artifact-demo</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <!-- TODO set project info -->
      <name>Example name</name>
      <description>Example description.</description>
      <url>https://example.com/</url>
      <inceptionYear>2042</inceptionYear>

      <properties>
        <coverage.threshold>85%</coverage.threshold>
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
        <maven-invoker-plugin.version>3.2.2</maven-invoker-plugin.version>
        <maven-jar-plugin.version>3.2.2</maven-jar-plugin.version>
        <maven-site-plugin.version>3.10.0</maven-site-plugin.version>
        <jacoco-maven-plugin.version>0.8.7</jacoco-maven-plugin.version>
        <junit-platform-maven-plugin.version>1.1.6</junit-platform-maven-plugin.version>
        <pitest-maven.version>1.7.3</pitest-maven.version>
        <pitest-junit5-plugin.version>0.15</pitest-junit5-plugin.version>
      </properties>

      <licenses>
        <license>
          <name>MIT License</name>
          <url>https://opensource.org/licenses/MIT</url>
          <distribution>repo</distribution>
        </license>
      </licenses>

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
              <artifactId>maven-invoker-plugin</artifactId>
              <version>${maven-invoker-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-jar-plugin</artifactId>
              <version>${maven-jar-plugin.version}</version>
            </plugin>
            <plugin>
              <artifactId>maven-site-plugin</artifactId>
              <version>${maven-site-plugin.version}</version>
            </plugin>
            <!-- Third Party Plugins -->
            <plugin>
              <groupId>de.sormuras.junit</groupId>
              <artifactId>junit-platform-maven-plugin</artifactId>
              <version>${junit-platform-maven-plugin.version}</version>
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
                        <minimum>${coverage.threshold}</minimum>
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
        </plugins>
      </build>

      <profiles>
        <!-- use this profile for development stage. -->
        <profile>
          <id>dev</id>
          <properties>
            <coverage.threshold>0%</coverage.threshold>
            <mutation.coverage.threshold>0</mutation.coverage.threshold>
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
      </profiles>

    </project>
    ```

???- example "my-artifact-demo/src/main/java/module-info.java"
    ```java
    module my.module.name {
      exports my.sample.package;
    }
    ```

???- example "my-artifact-demo/src/test/java/module-info.test"
    ```text
    --add-modules
      jdk.unsupported,org.assertj.core,org.mockito,net.bytebuddy

    --add-reads
      my.module.name=org.assertj.core

    --add-opens
      my.module.name/my.sample.package=org.junit.platform.commons
    --add-opens
      my.module.name/my.sample.package=org.mockito
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
            <configuration>
              <executor>JAVA</executor>
            </configuration>
          </plugin>
        </plugins>

      </build>
    </project>
    ```

???- example "my-artifact-demo/src/it/simple-it/src/main/java/module-info.java"
    ```java
    module my.module.name.simple.integrationtest {
      requires my.module.name;
    }
    ```

???- example "my-artifact-demo/src/it/simple-it/src/test/java/module-info.test"
    ```text
    --add-modules
      my.module.name.simple.integrationtest,org.assertj.core

    --add-reads
      my.module.name.simple.integrationtest=org.assertj.core

    --add-opens
      my.module.name.simple.integrationtest/my.sample.package.simple.it=org.junit.platform.commons
    ```
