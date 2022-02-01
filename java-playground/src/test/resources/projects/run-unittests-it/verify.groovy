evaluate(new File(basedir, "tools.groovy"))

verifyTargetFiles([
    "junit-platform/junit-platform-summary.txt",
    "junit-platform/TEST-junit-jupiter.xml"])
