evaluate(new File(basedir, "tools.groovy"))

verifyTargetFiles([
    "junit-platform/console-launcher.out.log",
    "junit-platform/TEST-junit-jupiter.xml",
    "pit-reports/index.html",
    "pit-reports/linecoverage.xml",
    "site/jacoco/index.html",
    "site/jacoco/jacoco.xml",
    "it/simple-it/build.log",
    "${deployableName}.jar",
    "$deployableName-javadoc.jar",
    "$deployableName-sources.jar"])
