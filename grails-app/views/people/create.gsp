
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Create AuthUser</title>
</head>
<body>
<div class="body">
    <h1>Create Authorized People</h1>

    <g:hasErrors bean="${person}">
        <div class="errors">
            <g:renderErrors bean="${person}" as="list" />
        </div>
    </g:hasErrors>
    <g:form action="save" method="post" >
        <g:render template="people" model="['person':person]" />

        <p>&nbsp;</p>

        <input type="submit" value="Save" class="button">
        <g:actionSubmit class="button" value="Cancel" action="list" />

    </g:form>
</div>
</body>
</html>
