<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <resource:dateChooser />
        <resource:richTextEditor />
    </head>
    <body onload="checkType($('type').value);">
        <div class="body">
            <h1>Edit Item</h1>
            
            <g:hasErrors bean="${item}">
            <div class="errors">
                <g:renderErrors bean="${item}" as="list" />
            </div>
            </g:hasErrors>
            
            <g:form controller="item" method="post" >
                <input type="hidden" name="id" value="${item?.id}" />
                <g:render template="item"/>
                 <p>&nbsp;</p>
                <g:actionSubmit value="Update" class="button" />
                <g:actionSubmit value="Delete" class="button" onclick="return confirm('Are you sure?');" />
                <g:actionSubmit class="button" value="Cancel" action="list" />
            </g:form>
            
        </div>
    </body>
</html>
