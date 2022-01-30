import static java.nio.file.Files.isReadable

import java.util.Properties

def basePath = basedir.toPath()
def propsPath = basePath.resolve "archetype.properties"

def archetypeProps = new Properties()
propsPath.withInputStream {
    archetypeProps.load(it)
}

def targetArtifactId = archetypeProps.get "artifactId"
def targetVersion = archetypeProps.get "version"

def targetPath = basePath.resolve "project/$targetArtifactId/target"

isReadable(targetPath.resolve("$targetArtifactId-${targetVersion}.jar")) &&
    isReadable(targetPath.resolve("$targetArtifactId-$targetVersion-javadoc.jar")) &&
    isReadable(targetPath.resolve("$targetArtifactId-$targetVersion-sources.jar"))
