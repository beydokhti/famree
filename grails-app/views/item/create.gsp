<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <resource:dateChooser />   
        <resource:richTextEditor />
    </head>
    <body onload="checkType($('type').value);">
        <div class="body">
            <h1>Create Item</h1>
            
            <g:hasErrors bean="${item}">
            <div class="errors">
                <g:renderErrors bean="${item}" as="list" />
            </div>
            </g:hasErrors>
            
            <g:form action="save" method="post">
                <g:render template="item"/>
                 <p>&nbsp;</p>
                <g:actionSubmit value="Save" class="button" />
                <g:actionSubmit class="button" value="Cancel" action="list" />
            </g:form>
        
        </div>
    </body>
</html>
