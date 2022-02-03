```shell
mvn archetype:generate \
-DarchetypeGroupId=info.tomfi.archetypes \
-DarchetypeArtifactId=java-playground-mod \
-DarchetypeVersion=1.0.0
```

???- example "archetype properties"
    | property   | example value     |
    | :--------- | :---------------- |
    | module     | my.module.name    |
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
├── pom.xml
├── README.md
└── src
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

      <groupId>my.group.example</groupId>
      <artifactId>my-artifact-demo</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <!-- TODO set project info -->
      <name>Example name</name>
      <description>Example description.</description>
      <url>https://example.com/</url>

      <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.release>17</maven.compiler.release>
        <!-- Dependencies -->
        <assertj.version>3.22.0</assertj.version>
        <junit-jupiter.version>5.8.2</junit-jupiter.version>
        <mockito.version>4.3.1</mockito.version>
        <!-- Plugins -->
        <maven-clean-plugin.version>3.1.0</maven-clean-plugin.version>
        <maven-compiler-plugin.version>3.9.0</maven-compiler-plugin.version>
        <maven-jar-plugin.version>3.2.2</maven-jar-plugin.version>
        <maven-site-plugin.version>3.10.0</maven-site-plugin.version>
        <junit-platform-maven-plugin.version>1.1.6</junit-platform-maven-plugin.version>
      </properties>

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
          </plugins>
        </pluginManagement>

        <plugins>
          <plugin>
            <groupId>de.sormuras.junit</groupId>
            <artifactId>junit-platform-maven-plugin</artifactId>
            <extensions>true</extensions>
            <configuration>
              <executor>JAVA</executor>
              <parameters>
                <junit.jupiter.execution.parallel.enabled>false</junit.jupiter.execution.parallel.enabled>
                <junit.jupiter.execution.parallel.mode.default>concurrent</junit.jupiter.execution.parallel.mode.default>
                <junit.jupiter.displayname.generator.default>org.junit.jupiter.api.DisplayNameGenerator$ReplaceUnderscores</junit.jupiter.displayname.generator.default><!-- editorconfig-checker-disable-line -->
              </parameters>
            </configuration>
          </plugin>
        </plugins>

      </build>
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
