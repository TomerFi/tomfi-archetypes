The *complete profiles* are added to the existing *professional profiles*, and configured for
[archetypes](/#archetypes) of **Full**:

- `prepare-deployment` will flatten the *poms* at the *process-resources* lifecycle phase, and create a *jar*,
  *javadoc-jar*, and *sources-jar* at the *package* lifecycle phase.
- `sign-deployment` will use your configured gpg environment to sign the artifacts created, bound to the *verify*
  lifecycle phase.
- `deploy-ossrh` will deploy the artifacts to [Sonatype OSSRH][0] artifact repository ([Maven Central][1]), bound to
  the *deploy* lifecycle phase.

[0]: https://central.sonatype.org/publish/publish-guide/
[1]: https://search.maven.org/
