The *professional profiles* are configured for [archetypes](/#archetypes) of type **Advanced** and **Full**:

- `dev` will turn off code coverage and other validations and enforcments from failing the build, use it manually
  while developing.
- `cov` will create a *Jacoco* coverage report, bound to the verify lifecycle phase.
- `its` will execute the integration tests, bound to the verify lifecycle phase.
- `mut` will execute the mutation test, bound to the verify lifecycle phase.
