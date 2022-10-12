Here are a couple of [Maven][0] build commands to get you started:

```shell
mvn test
```

will compile and perform unit tests on the build for all [archetypes](/#archetypes) types.

```shell
mvn verify -Pcov -Pits -Pmut
```

will compile, perform unit, integration, and mutation tests, as well as enforce source validations for the *Advanced*
and *Full* types [archetypes](/#archetypes).

```shell
mvn package -Pprepare-deployment
```

will compile, perform unit tests, and package all the *jar* archives for the *Full* type [archetypes](/#archetypes).

```shell
mvn install -Pcov -Pits -Pmut -Pprepare-deployment -Psign-deployment
```

will compile, perform unit, integration, and mutation tests, as well as enforce source validations, package all the
*jar* archives and eventually install to the local [Maven][0] repo (*~/.m2/repository*), for [archetypes](/#archetypes)
of type *Full*.

```shell
mvn release:prepare -Dtag=1.2.3 -DreleaseVersion=1.2.3 -DdevelopmentVersion=1.2.4-SNAPSHOT \
&& mvn release:perform
```

will compile, perform unit tests, as well as enfroce source validations, package all the *jar* archives, install them to
the local [Maven][0] repo (*~/.m2/repository*), and eventually deploy them to [Sonatype OSSRH][1] artifact repository
([Maven Central][2]) for [archetypes](/#archetypes) of type *Full*.

[0]: https://maven.apache.org/docs/3.8.6/release-notes.html
[1]: https://central.sonatype.org/publish/publish-guide/
[2]: https://search.maven.org/
