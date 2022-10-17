# Contributing to `tomfi-archetypes`

:clap: First off, thank you for taking the time to contribute. :clap:

Contributing is pretty straight-forward:

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

