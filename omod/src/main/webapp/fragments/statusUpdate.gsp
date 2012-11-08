<%
    ui.includeCss("social", "statusUpdates.css")
%>

<div class="status-update">
    <div class="user">
        ${ ui.format(config.statusUpdate.user) } says:
    </div>
    <div class="status">
        ${ config.statusUpdate.status }
    </div>
</div>