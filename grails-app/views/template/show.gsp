 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>${grailsApplication.config.site.title}::Show Template</title>
    </head>
    <body>
        <div class="body">
            <h1>Show Template</h1>
            <div class="dialog">
                <table>
                    <tbody>                                      
                        <tr class="prop">
                            <td valign="top" class="name">Key:</td>                            
                            <td valign="top" class="value">${template.templateKey}</td>                            
                        </tr>   
                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>                            
                            <td valign="top" class="value">${template.templateDescription}</td>                            
                        </tr>                                                                   
                        <tr class="prop">
                            <td valign="top" class="name">template value:</td>                            
                            <td valign="top" class="value">${template.templateValue}</td>                            
                        </tr>                                          
                    </tbody>
                </table>
            </div>
            
             <p>&nbsp;</p>
             
                <g:form controller="template">
                    <input type="hidden" name="id" value="${template?.id}" />
                    <g:actionSubmit class="button" value="List" />
                    <g:actionSubmit class="button" value="Edit" />
                </g:form>
           
        
        </div>
    </body>
</html>
