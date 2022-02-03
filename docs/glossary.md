`Playground`

:   The *Playground* [archetypes](/#archetypes) configure the [base dependencies list](/dependencies/base-dependencies)
    and [base plugins list](/plugins/base-plugins).</br>
    Choose a *Playground* archetype if you want to test something, hack a bit, play around, or simply quick start a
    project.</br>
    It uses [de.sormuras.junit:junit-platform-maven-plugin][0] for unit testing.

`Advanced`

:   The *Advanced* [archetypes](/#archetypes), adds to the *Playground* [archetypes](/#archetypes), and configures the
    [professional plugins list](/plugins/professional-plugins) and the
    [professional profiles list](/plugins/professional-profiles).</br>
    It introduces integration testing with [org.apache.maven.plugins:maven-invoker-plugin][1], mutation testing with
    [org.pitest:pitest-maven.version][2], and code coverage with [org.jacoco:jacoco-maven-plugin][3].</br>
    It also configure and includes a [MIT License][4].

`Full`

:   The *Full* [archetypes](/#archetypes) adds to the *Playground* and *Advanced* [archetypes](/#archetypes), and
    configures the [complete plugins list](/plugins/complete-plugins) and the
    [complete profiles list](/plugins/complete-profiles).</br>
    It introduces enforcement of the base sources with [org.apache.maven.plugins:maven-enforcer-plugin][5] and
    [com.mycila:license-maven-plugin][6], gpg signing with [org.apache.maven.plugins:maven-gpg-plugin][7], and
    deploying to *Maven Central* using [org.apache.maven.plugins:maven-release-plugin][8] and
    [org.sonatype.plugins:nexus-staging-maven-plugin][9].</br>
    It also configures all the required *pom* elements for maintaining a maven artifact, *developers*,
    *issueManagement*, *scm*, and *ciManagement*. The scm related elements are based on [GitHub][10] as an *SCM*
    prvider.

`Modular`

:   The *Modular* [archetypes](/#archetypes), identfied by the *-mod* prefix, are based on the above the
    [archetypes](/#archetypes), introducing *JPMS*, i.e. *module-info.java* for the main sources, and *module-info.test*
    for the test sources.

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
