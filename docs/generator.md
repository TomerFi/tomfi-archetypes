<!-- editorconfig-checker-disable -->
<!-- markdownlint-disable -->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Tomfi Maven Archetype Generator</title>
    <style type="text/css">
        input {
            font-size: medium;
        }
        th, td {
            padding: 10px;
        }
        td:first-child {
            width: 125px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- <script src="generator.js"></script> --><!-- this is loaded via mkdocs.yml -->
</head>
<body>
    <p>
        <div id="project_type">
            <select id="project_type" title="project type" style="height: 30px; font-size: medium;">
                <option id="select_project" value="select_project" disabled selected>select project type</option>
                <optgroup label="Non-Modular">
                    <option value="playground">Playground</option>
                    <option value="advanced">Advanced</option>
                    <option value="full">Full</option>
                </optgroup>
                <optgroup label="Modular">
                    <option value="playground_mod">Playground</option>
                    <option value="advanced_mod">Advanced</option>
                    <option value="full_mod">Full</option>
                </optgroup>
            </select>
            <button id="reset" type="reset" style="display: none;" title="reset the form">Reset</button>
            <button type="submit" id="generate" form="properties" class="base_props advanced_props full_props" style="display: none;" title="click to verify and generate project command">Generate</button>
            <button id="copy" type="button" style="display: none;" title="copy the command to the clipboard" class="command">Copy</button>
            <div id="command" style="display: none;" class="command">
                <textarea id="command" name="command" cols="75" rows="5" style="font-size: large; resize: none;" autofocus disabled readonly ></textarea>
            </div>
        </div>
    </p>
    <p>
        <form id="properties">
            <div id="base" style="display:none;" class="base_props advanced_props full_props">
                <table>
                    <caption style="font-size: large;"><em>Base Properties</em></caption>
                    <tr>
                        <td>Group ID</td>
                        <td><input type="text" id="group_id" placeholder="my.group.example" title="group id for your new project" pattern="^[a-z][a-z0-9_]*(\.[a-z0-9_]+)+[0-9a-z_]$"/></td>
                    </tr>
                    <tr>
                        <td>Artifact ID</td>
                        <td><input type="text" id="artifact_id" placeholder="my-artifact-demo" title="artifact id for your new project" pattern="^.*[a-zA-Z0-9]+.*$"/></td>
                    </tr>
                    <tr>
                        <td>Version</td>
                        <td><input type="text" id="version" placeholder="0.0.1-SNAPSHOT" title="version of your new project" pattern="^([0-9]+)\.([0-9]+)\.([0-9]+)(?:-SNAPSHOT)?$"/></td>
                    </tr>
                    <tr>
                        <td>Package</td>
                        <td><input type="text" id="package" placeholder="my.sample.package" title="package name to create" pattern="^[a-z][a-z0-9_]*(\.[a-z0-9_]+)+[0-9a-z_]$"/></td>
                    </tr>
                </table>
            </div>
            <div id="advanced" style="display:none;" class="advanced_props full_props">
                <table>
                    <caption style="font-size: large;"><em>Advanced Properties</em></caption>
                    <tr>
                        <td>Owner Name</td>
                        <td><input type="text" id="owner_name" placeholder="Doe Organization" title="owner name for the license file an headers"/></td>
                    </tr>
                    <tr>
                        <td>Year</td>
                        <td><input type="text" id="year" placeholder="2042" title="year for the license file and headers" pattern="^\d{4}$"/></td>
                    </tr>
                </table>
            </div>
            <div id="full" style="display:none;" class="full_props">
                <table>
                    <caption style="font-size: large;"><em>Full Properties</em></caption>
                    <tr>
                        <td>Owner ID</td>
                        <td><input type="text" id="owner_id" placeholder="doeOrganization" title="owner id of the github repository" pattern="^.*[a-zA-Z0-9]+.*$"/></td>
                    </tr>
                    <tr>
                        <td>Developer ID</td>
                        <td><input type="text" id="developer_id" placeholder="jdoe" title="developer id for the scm configuration" pattern="^.*[a-zA-Z0-9]+.*$"/></td>
                    </tr>
                </table>
            </div>
            <div id="modular" style="display:none;">
                <table>
                    <caption style="font-size: large;"><em>Modular Properties</em></caption>
                    <tr>
                        <td>Module</td>
                        <td><input type="text" id="module" placeholder="my.module.name" title="module name to create" pattern="^[a-z][a-z0-9_]*(\.[a-z0-9_]+)+[0-9a-z_]$"/></td>
                    </tr>
                </table>
            </div>
        </form>
    </p>
</body>
</html>
