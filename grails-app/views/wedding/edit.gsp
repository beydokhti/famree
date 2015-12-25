  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Wedding</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Wedding List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Wedding</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Wedding</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${wedding}">
            <div class="errors">
                <g:renderErrors bean="${wedding}" as="list" />
            </div>
            </g:hasErrors>
      
            <g:render template="edit" model="['wedding':wedding]"/>
        </div>
    </body>
</html>
