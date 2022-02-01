/** Tools script for verifying the build project. */
import static java.nio.file.Files.isReadable

import java.util.Properties

// load base directory path
def basePath = basedir.toPath()
// serialize the archetype properties
def propsPath = basePath.resolve "archetype.properties"
def archetypeProps = new Properties()
propsPath.withInputStream {
    archetypeProps.load(it)
}
// fetch required properties
def targetArtifactId = archetypeProps.get "artifactId"
def targetVersion = archetypeProps.get "version"
// load target path
def targetPath = basePath.resolve "project/$targetArtifactId/target"
// bind deployable name to script
deployableName = "$targetArtifactId-$targetVersion"
// bind verification closure to script
verifyTargetFiles = {
    targetFiles -> targetFiles.every { isReadable targetPath.resolve(it) }
}
