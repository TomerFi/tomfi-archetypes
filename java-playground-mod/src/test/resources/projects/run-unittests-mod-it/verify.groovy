evaluate(new File(basedir, "tools.groovy"))

verifyTargetFiles([
    "junit-platform/console-launcher.out.log",
    "junit-platform/TEST-junit-jupiter.xml"])
