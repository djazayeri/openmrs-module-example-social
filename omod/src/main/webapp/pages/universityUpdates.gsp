<%
    ui.decorateWith("social", "standardSocialPage", [ title: "Updates" ])
%>

Hello,
${ ui.format(context.authenticatedUser) }.

<% if (myStatus) { %>
    Your status is: <br/>
    ${ ui.includeFragment("social", "showStatus", [ status: myStatus ]) }
<% } %>

<fieldset>
    <legend>Post a status update</legend>

    <form method="POST">
        <input type="hidden" name="user" value="${ context.authenticatedUser.id }"/>
        <textarea rows="3" cols="60" name="status"></textarea>
        <br/>
        <input type="submit" value="Post"/>
    </form>

</fieldset>

<script type="text/javascript">
    jq(function() {
        window.alert("Time is up");
    })
</script>