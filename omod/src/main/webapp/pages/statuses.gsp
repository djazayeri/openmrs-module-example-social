<fieldset>
    <legend>Post My Status</legend>
    <form method="post">
        <input type="hidden" name="user" value="${ context.authenticatedUser.userId }"/>
        <textarea name="status" rows="2" cols="60"></textarea>
        <br/>
        <input type="submit" value="Post"/>
    </form>
</fieldset>

<fieldset>
    <legend>Status Updates</legend>
    <% statusUpdates.each { statusUpdate -> %>
        ${ ui.includeFragment("social", "statusUpdate", [ statusUpdate: statusUpdate ]) }
    <% } %>

</fieldset>