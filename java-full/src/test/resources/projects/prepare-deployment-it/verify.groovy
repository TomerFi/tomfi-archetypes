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

def targets = [
    "junit-platform/console-launcher.out.log",
    "junit-platform/TEST-junit-jupiter.xml",
    "pit-reports/index.html",
    "pit-reports/linecoverage.xml",
    "site/jacoco/index.html",
    "site/jacoco/jacoco.xml",
    "$targetArtifactId-${targetVersion}.jar",
    "$targetArtifactId-$targetVersion-javadoc.jar",
    "$targetArtifactId-$targetVersion-sources.jar"]

targets.every {
    isReadable targetPath.resolve(it)
}
