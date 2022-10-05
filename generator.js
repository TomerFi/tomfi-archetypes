const PATTERN_PACKAGE = /^[a-z][a-z0-9_]*(\.[a-z0-9_]+)+[0-9a-z_]$/;
const PATTERN_ARTIFACT = /^.*[a-zA-Z0-9]+.*$/;
const PATTERN_VERSION = /^(\d+)\.(\d+)\.(\d+)(?:-SNAPSHOT)?$/;
const PATTERN_YEAR = /^\d{4}$/;

const currentVersion = "1.1.6"

$(document).ready(function() {
    function showProps(className, isModular) {
        $("option#select_project").hide();
        $("button#reset").show();
        if ("full_props" !== className) {
            $(".full_props").hide();
        }
        $(`.${className}`).show();
        if (isModular) {
            $("div#modular").show();
        } else {
            $("div#modular").hide();
        }
    }

    $("select#project_type").change(function() {
        $(".command").hide();
        let selection = $(this).val();
        switch (selection) {
            case "playground":
                showProps("base_props", false);
                break;
            case "playground_mod":
                showProps("base_props", true);
                break;
            case "advanced":
                showProps("advanced_props", false);
                break;
            case "advanced_mod":
                showProps("advanced_props", true);
                break;
            case "full":
                showProps("full_props", false);
                break;
            case "full_mod":
                showProps("full_props", true);
                break;
            default:
                $("option#select_project").show();
                $("button#reset").hide();
                $(".full_props").hide();
                $("div#modular").hide();
                break;
        }
    });

    $("button#reset").click(function() {
        $("input*").val("");
        $("select#project_type").prop('selectedIndex',0);
        $("select#project_type").change();
        $("textarea#command").val("");
        $(".command").hide();
        $("span#error").text("");
        $("span#error").hide();
    });

    $("button#generate").click(function() {
        $("span#error").text("");
        $("span#error").hide();

        let groupId = $("input#group_id").val();
        if (!groupId.match(PATTERN_PACKAGE)) {
            $("span#error").text("verify group id");
            $("span#error").show();
            return;
        }

        let artifactId = $("input#artifact_id").val();
        if (!artifactId.match(PATTERN_ARTIFACT)) {
            $("span#error").text("verify artifact id");
            $("span#error").show();
            return;
        }

        let version = $("input#version").val();
        if (!version.match(PATTERN_VERSION)) {
            $("span#error").text("verify version");
            $("span#error").show();
            return;
        }

        let packag = $("input#package").val();
        if (!packag.match(PATTERN_PACKAGE)) {
            $("span#error").text("verify package");
            $("span#error").show();
            return;
        }


        let archetypeArtifact = "java-playground"
        let command = ["mvn archetype:generate -B",
            "-DarchetypeGroupId=info.tomfi.archetypes",
            "-DarchetypeArtifactId=%placeholder",
            `-DarchetypeVersion=${currentVersion}`,
            `-DgroupId=${groupId}`,
            `-DartifactId=${artifactId}`,
            `-Dversion=${version}`,
            `-Dpackage=${packag}`];

        let selection = $("select#project_type").val();

        if (selection.startsWith("advanced") || selection.startsWith("full")) {
            if (selection.startsWith("advanced")) {
                archetypeArtifact = "java-advanced";
            }
            let ownerName = $("input#owner_name").val();
            if (!ownerName.match(PATTERN_ARTIFACT)) {
                $("span#error").text("verify owner name");
                $("span#error").show();
                return;
            }

            let year = $("input#year").val();
            if (!year.match(PATTERN_YEAR)) {
                $("span#error").text("verify year");
                $("span#error").show();
                return;
            }

            command.push(`-DownerName=${ownerName}`);
            command.push(`-Dyear=${year}`);
        }

        if (selection.startsWith("full")) {
            archetypeArtifact = "java-full";
            let ownerId = $("input#owner_id").val();
            if (!ownerId.match(PATTERN_ARTIFACT)) {
                $("span#error").text("verify owner id");
                $("span#error").show();
                return;
            }

            let developerId = $("input#developer_id").val();
            if (!developerId.match(PATTERN_ARTIFACT)) {
                $("span#error").text("verify developer id");
                $("span#error").show();
                return;
            }

            command.push(`-DdeveloperId=${developerId}`);
            command.push(`-DownerId=${ownerId}`);
        }

        if (selection.endsWith("_mod")) {
            archetypeArtifact = archetypeArtifact + "-mod";
            let module = $("input#module").val();
            if (!module.match(PATTERN_PACKAGE)) {
                $("span#error").text("verify module");
                $("span#error").show();
                return;
            }

            command.push(`-Dmodule=${module}`);
        }

        $("textarea#command").text(command.join("\r").replace("%placeholder", archetypeArtifact));
        $(".command").show();
    });

    $("button#copy").click(function() {
        navigator.clipboard.writeText($("textarea#command").val().replace(/\n/g, " "))
            .then(() => alert("maven command copied to clipboard, have fun!"));
    });
});
