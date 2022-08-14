const currentVersion = "1.0.6";

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
    });

    $("button#generate").click(function() {
        if ($("form#properties").valid()) {
            let command = ["mvn archetype:generate -B",
                "-DarchetypeGroupId=info.tomfi.archetypes",
                "-DarchetypeArtifactId=java-playground",
                `-DarchetypeVersion=${currentVersion}`,
                `-DgroupId=${$("input#group_id").val()}`,
                `-DartifactId=${$("input#artifact_id").val()}`,
                `-Dversion=${$("input#version").val()}`,
                `-Dpackage=${$("input#package").val()}`];

            let selection = $("select#project_type").val();

            if (selection.startsWith("advanced")) {
                command.push(`-DownerName=${$("input#owner_name").val()}`);
                command.push(`-Dyear=${$("input#year").val()}`);
            }

            if (selection.startsWith("full")) {
                command.push(`-DdeveloperId=${$("input#developer_id").val()}`);
                command.push(`-DownerId=${$("input#owner_id").val()}`);
            }

            if (selection.endsWith("_mod")) {
                command.push(`-Dmodule=${$("input#module").val()}`);
            }

            $("textarea#command").text(command.join(" "));
            $(".command").show();
        }
    });

    $("button#copy").click(function() {
        navigator.clipboard.writeText($("textarea#command").val())
            .then(() => alert("maven command copied to clipboard, have fun!"));
    });
});
