<%
    ui.includeJavascript("uilibrary", "jquery.js")
    def title = config.title ?: "Social Networking in OpenMRS"
%>

<script type="text/javascript">
    var jq = jQuery;
</script>

<h1>${ title }</h1>

${ config.content }

