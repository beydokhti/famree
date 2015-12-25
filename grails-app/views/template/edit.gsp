<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>${grailsApplication.config.site.title}::Edit Template</title>
        <resource:dateChooser />
    </head>
    <body>
        <div class="body">
            <h1>Edit Template</h1>
            
            <g:hasErrors bean="${template}">
            <div class="errors">
                <g:renderErrors bean="${template}" as="list" />
            </div>
            </g:hasErrors>
            
            <g:form controller="template" method="post" >
                <input type="hidden" name="id" value="${template?.id}" />
				<div class="dialog">
				    <table>
				        <tbody>                    
				            <tr class='prop'>
				                <td valign='top' class='name'>
				                    <label for='subject'>Template key:</label>
				                </td>
				                <td valign='top' class='value'>
				                    ${template.templateKey}
				                </td>
				            </tr>    
				            <tr class='prop'>
				                <td valign='top' class='name'>
				                    <label for='subject'>Description:</label>
				                </td>
				                <td valign='top' class='value'>
				                    ${template.templateDescription}
				                </td>
				            </tr> 					                                             
				            <tr class='prop'>
				                <td valign='top' class='name'>
				                    <label for='details'>Template value:</label>
				                </td>
				                <td valign='top' class='value ${hasErrors(bean:template,field:'templateValue','errors')}'>
				                    <textarea id='templateValue' name='templateValue' rows="5" cols="80">${template.templateValue}</textarea>
				                    <span class="required">*</span>
				                </td>
				            </tr>                                                                                                                                                
				        </tbody>
				    </table>
				    
				</div>

                 <p>&nbsp;</p>
                <g:actionSubmit value="Update" class="button" />
				<g:actionSubmit value="Cancel" class="button" action="list" />
            </g:form>
            
        </div>
    </body>
</html>
