<!-- editorconfig-checker-disable -->
<!-- markdownlint-disable -->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Tomfi Maven Archetype Generator</title>
    <link href="https://fonts.googleapis.com/css?family=Inconsolata|Droid+Sans&effect=shadow-multiple" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- relative javascript and css are loaded via mkdocs.yml -->
</head>
<body>
    <p>
        <div id="project_type">
            <select id="project_type" title="project type" class="control_panel">
                <option id="select_project" value="select_project" disabled selected>select project type</option>
                <optgroup label="Non-Modular">
                    <option value="playground">Playground</option>
                    <option value="advanced">Advanced</option>
                    <option value="full">Full</option>
                </optgroup>
                <optgroup label="Modular">
                    <option value="playground_mod">Playground Modular</option>
                    <option value="advanced_mod">Advanced Modular</option>
                    <option value="full_mod">Full Modular</option>
                </optgroup>
            </select>
            <button type="reset" id="reset" style="display: none;" title="reset the form" class="control_panel">Reset</button>
            <button type="submit" id="generate" style="display: none;" title="click to verify and generate project command" class="control_panel base_props advanced_props full_props">Generate</button>
            <button id="copy" type="button" style="display: none;" title="copy the command to the clipboard" class="control_panel command">Copy</button>
            <span id="error" class="error_message"></span>
            <div id="command" style="display: none;" class="command">
                <textarea id="command" class="command_text" autofocus disabled readonly></textarea>
            </div>
        </div>
    </p>
    <p>
        <form id="properties">
        <div id="base" style="display:none;" class="base_props advanced_props full_props">
            <table class="props_table">
                <caption class="props_table_caption">Base Properties</caption>
                <tr>
                    <td class="props_table_head_col">Group ID</td>
                    <td>
                        <input type="text" id="group_id" placeholder="my.group.example" title="group id for your new project" class="props_table_value_input"/>
                    </td>
                </tr>
                <tr>
                    <td class="props_table_head_col">Artifact ID</td>
                    <td>
                        <input type="text" id="artifact_id" placeholder="my-artifact-demo" title="artifact id for your new project" class="props_table_value_input"/>
                    </td>
                </tr>
                <tr>
                    <td class="props_table_head_col">Version</td>
                    <td>
                        <input type="text" id="version" placeholder="0.0.1-SNAPSHOT" title="version of your new project" class="props_table_value_input"/>
                    </td>
                </tr>
                <tr>
                    <td class="props_table_head_col">Package</td>
                    <td>
                        <input type="text" id="package" placeholder="my.sample.package" title="package name to create" class="props_table_value_input"/>
                    </td>
                </tr>
            </table>
        </div>
        <div id="advanced" style="display:none;" class="advanced_props full_props">
            <table class="props_table">
                <caption class="props_table_caption">Advanced Properties (license)</caption>
                <tr>
                    <td class="props_table_head_col">Owner Name</td>
                    <td>
                        <input type="text" id="owner_name" placeholder="Doe Organization" title="owner name for the license file an headers" class="props_table_value_input"/>
                    </td>
                </tr>
                <tr>
                    <td class="props_table_head_col">Year</td>
                    <td>
                        <input type="text" id="year" placeholder="2042" title="year for the license file and headers" class="props_table_value_input"/>
                    </td>
                </tr>
            </table>
        </div>
        <div id="full" style="display:none;" class="full_props">
            <table class="props_table">
                <caption class="props_table_caption">Full Properties (scm)</caption>
                <tr>
                    <td class="props_table_head_col">Owner ID</td>
                    <td>
                        <input type="text" id="owner_id" placeholder="doeOrganization" title="owner id of the github repository" class="props_table_value_input"/>
                    </td>
                </tr>
                <tr>
                    <td class="props_table_head_col">Developer ID</td>
                    <td>
                        <input type="text" id="developer_id" placeholder="jdoe" title="developer id for the scm configuration" class="props_table_value_input"/>
                    </td>
                </tr>
            </table>
        </div>
        <div id="modular" style="display:none;">
            <table class="props_table">
                <caption class="props_table_caption">Modular Properties</caption>
                <tr>
                    <td class="props_table_head_col">Module</td>
                    <td>
                        <input type="text" id="module" placeholder="my.module.name" title="module name to create" class="props_table_value_input"/>
                    </td>
                </tr>
            </table>
        </div>
        </form>
    </p>
</body>
</html>
