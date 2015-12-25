 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
    </head>
    <body>
        <div class="body">
            <h1>Show Item</h1>
            <div class="dialog">
                <table>
                    <tbody>                                     
                        <tr class="prop">
                            <td valign="top" class="name">Subject:</td>                            
                            <td valign="top" class="value">${item.subject}</td>                            
                        </tr>                                            
                        <tr class="prop">
                            <td valign="top" class="name">Details:</td>                            
                            <td valign="top" class="value">${item.details}</td>                            
                        </tr>                                        
                        <tr class="prop">
                            <td valign="top" class="name">Start Date:</td>                            
                            <td valign="top" class="value"><g:formatDate date="${item.startDate}" format="MMM dd, yyyy" /></td>                            
                        </tr>                                        
                        <tr class="prop">
                            <td valign="top" class="name">End Date:</td>                            
                            <td valign="top" class="value"><g:formatDate date="${item.endDate}" format="MMM dd, yyyy" /></td>                            
                        </tr>                                        
                        <tr class="prop">
                            <td valign="top" class="name">Active:</td>                            
                            <td valign="top" class="value">${item.active}</td>                            
                        </tr>                    
                        <tr class="prop">
                            <td valign="top" class="name">Position:</td>
                            <td valign="top" class="value">${item.position}</td>                            
                        </tr>                        
                        <tr class="prop">
                            <td valign="top" class="name">Type:</td>                            
                            <td valign="top" class="value">${item.type.name}</td>                            
                        </tr>                   
                    </tbody>
                </table>
            </div>
            
             <p>&nbsp;</p>
             
                <g:form controller="item">
                    <input type="hidden" name="id" value="${item?.id}" />
                    <g:actionSubmit value="New Item" class="button" action="create" />
                    <g:actionSubmit class="button" value="Edit" />
                    <g:actionSubmit class="button" onclick="return confirm('Are you sure?');" value="Delete" />
                    <g:actionSubmit class="button" value="Cancel" action="list" />
                </g:form>
           
        
        </div>
    </body>
</html>
