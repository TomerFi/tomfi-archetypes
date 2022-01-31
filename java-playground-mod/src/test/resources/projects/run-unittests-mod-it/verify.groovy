import static java.nio.file.Files.isReadable

import java.util.Properties

def basePath = basedir.toPath()
def propsPath = basePath.resolve "archetype.properties"

def archetypeProps = new Properties()
propsPath.withInputStream {
    archetypeProps.load(it)
}

def targetArtifactId = archetypeProps.get "artifactId"
def targetPath = basePath.resolve "project/$targetArtifactId/target"

def targets = [
    "junit-platform/console-launcher.out.log",
    "junit-platform/TEST-junit-jupiter.xml"]

targets.every {
    isReadable targetPath.resolve(it)
}
