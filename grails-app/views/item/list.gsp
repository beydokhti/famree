  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
    </head>
    <body>
        <div class="body">
            <h1>Manage Items</h1>
            
            <div class="list">
                <table>
                    <thead>
                        <tr>                                            
                   	        <g:sortableColumn property="subject" title="Subject" />                                       
                            <g:sortableColumn property="startDate" title="Start Date" />                            
                            <g:sortableColumn property="endDate" title="End Date" />                            
                   	        <g:sortableColumn property="active" title="Active" />                        
                   	        <g:sortableColumn property="position" title="Position" />                        
                            <g:sortableColumn property="type" title="Type" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${itemList}" status="i" var="item">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">                               
                            <td><g:link action="show" id="${item.id}">${item.subject?.encodeAsHTML()}</g:link></td>                                         
                            <td nowrap><g:formatDate date="${item.startDate}" format="MMM dd, yyyy" /></td>                            
                            <td nowrap><g:formatDate date="${item.endDate}" format="MMM dd, yyyy" /></td>                            
                            <td>${item.active}</td>                        
                            <td>${item.position}</td>                        
                            <td nowrap>${item.type.name}</td>                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            
            <div class="paginateButtons">
                <g:paginate total="${Item.count()}" />
            </div>
            
            <p>&nbsp;</p>
            
            <g:form action="create">
                <g:actionSubmit value="New Item" class="button" action="create" />
            </g:form>
            
        </div>
    </body>
</html>
