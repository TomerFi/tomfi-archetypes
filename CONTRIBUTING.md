# Contributing to *tomfi-archetypes*

:clap: First off, thank you for taking the time to contribute. :clap:

- Fork the repository
- Create a new branch
- Commit your changes
- Create a pull request against the `main` branch

## Run Superlinter Locally

```shell
docker run --rm -e RUN_LOCAL=true -e IGNORE_GITIGNORED_FILES=true -e IGNORE_GENERATED_FILES=true \
-e VALIDATE_EDITORCONFIG=true -e VALIDATE_GITHUB_ACTIONS=true -e VALIDATE_GROOVY=true -e VALIDATE_JSON=true \
-e VALIDATE_MARKDOWN=true -e VALIDATE_XML=true -e VALIDATE_YAML=true \
-v ${PWD}:/tmp/lint ghcr.io/github/super-linter:slim-v4
```

> Deliberately not linting *Java* sources as most of them are filled with templates.

## Documentation Site

The documentation site is built with [Python](https://www.python.org/)'s [MkDocs](https://www.mkdocs.org/).<br/>
The sources are in [docs/](https://github.com/TomerFi/auto-me-bot/tree/main/docs), and the configuration file is [mkdocs.yml](https://github.com/TomerFi/auto-me-bot/blob/main/mkdocs.yml).

Useful commands:

- `pip install -r requirements.txt` install dependencies required for building/serving the documentation site
- `mkdocs build` build the documentation site in a folder named *site* (gitignored)
- `mkdocs serve` serve the documentation site locally while watching the sources and auto loading for modifications

> Using [venv](https://docs.python.org/3/tutorial/venv.html) is highly recommended.

## Project walkthrough

Before going over this section, it's recommended get familiar with the following:

- [Creating Maven Archetypes](https://maven.apache.org/guides/mini/guide-creating-archetypes.html)
- [Working with Maven Modules](https://maven.apache.org/guides/mini/guide-multiple-modules.html)
- [Java Modules](https://www.oracle.com/corporate/features/understanding-java-9-modules.html)
- [Testing in the Modular World](https://sormuras.github.io/blog/2018-09-11-testing-in-the-modular-world.html)
- [Maven Invoker Plugin](https://maven.apache.org/shared/maven-invoker/)
- [Pitest Mutation Testing](https://pitest.org/)

This is a *Maven Reactor* project, the [parent pom](https://github.com/TomerFi/tomfi-archetypes/blob/main/pom.xml), besides
declaring the various archetypes as submodules it also managed dependencies for both the archetypes, and the target projects.

Each archetype, i.e. *java-playground*, is complemented with a *-mod* version, i.e. *java-playground-mod*, which is used
for creating modular projects.

> The following is based on the *java-playground* archetype, but is applicable for all archetypes submodules.

For creating the archetypes, we have:

- [src/main/resources/META-INF/maven/archetype-metadata.xml](https://github.com/TomerFi/tomfi-archetypes/blob/main/java-playground/src/main/resources/META-INF/maven/archetype-metadata.xml)
    holds the instructions for creating a project, note the `${}` syntax for populating values from the parent pom, i.e.
    `name="${artifactId}"`.

- [src/main/resources/archetype-resources](https://github.com/TomerFi/tomfi-archetypes/tree/main/java-playground/src/main/resources/archetype-resources)
    it the target project layout, not the `$x` syntax for populating values based on the user input, i.e. `$package`

- [src/test/resources/projects](https://github.com/TomerFi/tomfi-archetypes/tree/main/java-playground/src/test/resources/projects)
    is the sources for integration tests, the [reference folder](https://github.com/TomerFi/tomfi-archetypes/tree/main/java-playground/src/test/resources/projects/run-unittests-it/reference)
    is the expected target project, [archetype.properties](https://github.com/TomerFi/tomfi-archetypes/blob/main/java-playground/src/test/resources/projects/run-unittests-it/archetype.properties),
    is used to configure a new project, [goal.txt], is the goal to run the integration tests with, and [verify.groovy](https://github.com/TomerFi/tomfi-archetypes/blob/main/java-playground/src/test/resources/projects/run-unittests-it/verify.groovy),
    which uses [tools.groovy](https://github.com/TomerFi/tomfi-archetypes/blob/main/java-playground/src/test/resources/projects/run-unittests-it/tools.groovy)
    to evaluate the target project created from the archetype.

- [common](https://github.com/TomerFi/tomfi-archetypes/tree/main/common) hold resources that will be included in all archetypes.

> Development TIP: Run `mvn install` to install the project to your local repository with the current snapshot version
    which is stated in the [parent pom](https://github.com/TomerFi/tomfi-archetypes/blob/main/pom.xml), i.e. `<version>1.1.8-SNAPSHOT</version>`,
    you can use the start command generator to create a generate command, and replace the version with the installed
    snapshot one.
