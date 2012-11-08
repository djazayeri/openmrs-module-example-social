<%
    ui.includeCss("social", "statusUpdates.css")
%>

<div class="status-update">
    <div class="user">${ ui.format(config.status.user) }</div>
    <div class="status">${ ui.escapeHtml(config.status.status) }</div>
</div>