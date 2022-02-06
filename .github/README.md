# TomFi's Maven Archetypes</br>[![artifact-version]][0] [![java-version]][1] [![status-build]][2] [![status-pages]][6]

Quickly spin up an updated [Git][8] and [GitHub][5]-ready [Java][3] project with [Maven][4].</br>
Check out the [documentation][7] for anything else you might need to know, i.e. the archetypes [glossray][9].

[Java Playground Archetype](https://archetypes.tomfi.info/archetypes/java-playground/)

```shell
mvn archetype:generate \
-DarchetypeGroupId=info.tomfi.archetypes \
-DarchetypeArtifactId=java-playground \
-DarchetypeVersion=1.0.5
```

[Java Playground Modular Archetype](https://archetypes.tomfi.info/archetypes/java-playground-mod/)

```shell
mvn archetype:generate \
-DarchetypeGroupId=info.tomfi.archetypes \
-DarchetypeArtifactId=java-playground-mod \
-DarchetypeVersion=1.0.5
```

[Java Advanced Archetype](https://archetypes.tomfi.info/archetypes/java-advanced/)

```shell
mvn archetype:generate \
-DarchetypeGroupId=info.tomfi.archetypes \
-DarchetypeArtifactId=java-advanced \
-DarchetypeVersion=1.0.5
```

[Java Advanced Modular Archetype](https://archetypes.tomfi.info/archetypes/java-advanced-mod/)

```shell
mvn archetype:generate \
-DarchetypeGroupId=info.tomfi.archetypes \
-DarchetypeArtifactId=java-advanced-mod \
-DarchetypeVersion=1.0.5
```

[Java Full Archetype](https://archetypes.tomfi.info/archetypes/java-full/)

```shell
mvn archetype:generate \
-DarchetypeGroupId=info.tomfi.archetypes \
-DarchetypeArtifactId=java-full \
-DarchetypeVersion=1.0.5
```

[Java Full Modular Archetype](https://archetypes.tomfi.info/archetypes/java-full-mod/)

```shell
mvn archetype:generate \
-DarchetypeGroupId=info.tomfi.archetypes \
-DarchetypeArtifactId=java-full-mod \
-DarchetypeVersion=1.0.5
```

<!-- editorconfig-checker-disable -->
<!-- Real Links -->
[0]: https://search.maven.org/search?q=info.tomfi.archetypes
[1]: https://openjdk.java.net/projects/jdk/17/
[2]: https://github.com/TomerFi/tomfi-archetypes/actions/workflows/stage.yml
[3]: https://www.oracle.com/java/technologies/downloads/#JDK17
[4]: https://maven.apache.org/docs/3.8.4/release-notes.html
[5]: https://github.com/
[6]: https://github.com/TomerFi/tomfi-archetypes/actions/workflows/pages_deploy.yml
[7]: https://archetypes.tomfi.info/
[8]: https://git-scm.com/
[9]: https://archetypes.tomfi.info/glossary/
<!-- Badges Links -->
[artifact-version]: https://badgen.net/maven/v/maven-central/info.tomfi.archetypes/tomfi-archetypes-parent?icon=maven&label=Maven%20Central
[java-version]: https://badgen.net/badge/Java%20Version/17/5382a1
[status-build]: https://github.com/TomerFi/tomfi-archetypes/actions/workflows/stage.yml/badge.svg
[status-pages]: https://github.com/TomerFi/tomfi-archetypes/actions/workflows/pages_deploy.yml/badge.svg
