  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
    </head>
    <body>
        <div class="body">
            <h1>Manage Template</h1>
            
            <div class="list">
                <table>
                    <thead>
                        <tr>                                              
                   	        <g:sortableColumn property="templateKey" title="Key" />                        
                   	        <g:sortableColumn property="templateDescription" title="Description" />
                   	        <g:sortableColumn property="templateValue" title="Template" />                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${templateList}" status="i" var="template">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">                           
                            <td><g:link action="edit" id="${template.id}">${template.templateKey?.encodeAsHTML()}</g:link></td>                        
                            <td>${template.templateDescription?.encodeAsHTML()}</td>                              
                            <td>${template.templateValue?.encodeAsHTML()}</td>                                              
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            
            <div class="paginateButtons">
                <g:paginate total="${Template.count()}" />
            </div>
            
            <p>&nbsp;</p>
            
        </div>
    </body>
</html>
