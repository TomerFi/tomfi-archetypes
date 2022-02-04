`Playground`

:   The *Playground* [archetypes](/#archetypes) configure the [base dependencies list](/dependencies/base-dependencies)
    and [base plugins list](/plugins/base-plugins).</br>
    [junit-platform-maven-plugin][0] is used for unit testing.</br>
    *Playground* [archetypes](/#archetypes) are mostly suitable if you want hack a bit, play around, or simply quick
    start a project.

`Advanced`

:   The *Advanced* [archetypes](/#archetypes), adds the [professional plugins list](/plugins/professional-plugins) and
    the [professional profiles list](/plugins/professional-profiles) on top of the *Playground*
    [archetypes](/#archetypes).</br>
    It introduces integration testing with [maven-invoker-plugin][1], mutation testing with [pitest-maven.version][2],
    and code coverage with [jacoco-maven-plugin][3]. [MIT License][4] is included.</br>
    *Advanced* [archetypes](/#archetypes) are more suitable for stable projects, projects that are intended to be
    shared.

`Full`

:   The *Full* [archetypes](/#archetypes) adds the [complete plugins list](/plugins/complete-plugins) and the
    [complete profiles list](/plugins/complete-profiles) on top of the *Advanced* [archetypes](/#archetypes).</br>
    It introduces enforcement of the base sources with [maven-enforcer-plugin][5] and [license-maven-plugin][6], gpg
    signing with [maven-gpg-plugin][7], and deploying to [Maven Central][11] using [maven-release-plugin][8] and
    [nexus-staging-maven-plugin][9].</br>
    The [pom][13] elements required for deploying and maintaining a [Maven][14] artifact, i.e. *developers*,
    *issueManagement*, *scm*, and *ciManagement*, are based on [GitHub][10] as a provider, the developer connection
    is ssh flavourd.</br>
    *Full* [archetypes](/#archetypes) are meant to be used for projects that will eventually get deployed to an artifact
    repository, i.e. [Maven Central][11].

`Modular`

:   The *Modular* [archetypes](/#archetypes), identfied by the *-mod* prefix, are build on top of the above the
    [archetypes](/#archetypes), introducing [JPMS (jigsaw)][12] to the project, i.e. *module-info.java* for the main
    sources, and *module-info.test* for the test sources.

[0]: https://github.com/sormuras/junit-platform-maven-plugin
[1]: https://maven.apache.org/plugins/maven-invoker-plugin
[2]: https://pitest.org/quickstart/maven/
[3]: https://www.eclemma.org/jacoco/trunk/doc/maven.html
[4]: https://opensource.org/licenses/MIT
[5]: https://maven.apache.org/plugins/maven-enforcer-plugin
[6]: https://mycila.carbou.me/license-maven-plugin/
[7]: https://maven.apache.org/plugins/maven-gpg-plugin
[8]: https://maven.apache.org/plugins/maven-release-plugin
[9]: https://github.com/sonatype/nexus-maven-plugins/tree/master/staging/maven-plugin
[10]: https://github.com/
[11]: https://search.maven.org/
[12]: https://openjdk.java.net/projects/jigsaw/
[13]: https://maven.apache.org/pom.html
[14]: https://maven.apache.org/
