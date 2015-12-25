  
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Edit Role</title>
  </head>
  <body>
    <div class="body">
      <h1>Edit Role</h1>

      <g:hasErrors bean="${authority}">
        <div class="errors">
          <g:renderErrors bean="${authority}" as="list" />
        </div>
      </g:hasErrors>
        
      <g:form controller="role" method="post" >
        <input type="hidden" name="id" value="${authority?.id}" />
        <div class="dialog">
          <table>
            <tbody>     
			  <tr class='prop'>
			    <td valign='top' class='name'>
			    	<label for='authority'>Role Name:</label>
			    </td>
				<td valign='top' 
					class='value ${hasErrors(bean:authority,field:'authority','errors')}'>
				  <input type="text" name='authority' 
						 value="${authority?.authority?.substring(5)?.toLowerCase()?.encodeAsHTML()}"/>
				</td>
			  </tr>
						
              <tr class='prop'>
                <td valign='top' class='name'>
                	<label for='description'>Description:</label>
                </td>
                <td valign='top' 
                    class='value ${hasErrors(bean:authority,field:'description','errors')}'>
                  <input type="text" name='description' 
                         value="${authority?.description?.encodeAsHTML()}"/>
                </td>
              </tr>
                        
			  <tr class='prop'>
			    <td valign='top' class='name'>
			      <label for='people'>People:</label>
			    </td>
				<td valign='top' 
				    class='value ${hasErrors(bean:authority,field:'people','errors')}'>
				  <ul>
    			    <g:each var='p' in='${authority?.people?}'>
        			  <li>${p}</li>
    				</g:each>
				  </ul>
				</td>
			  </tr>
            </tbody>
          </table>
        </div>

        <p>&nbsp;</p>
        
        <g:actionSubmit value="Update" class="button" />
        <g:actionSubmit value="Delete" class="button" onclick="return confirm('Are you sure?');" />
        
      </g:form>
    </div>
  </body>
</html>
