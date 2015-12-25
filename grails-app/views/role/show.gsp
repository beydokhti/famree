  
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Show Role</title>
  </head>
  
  <body>
    
    <div class="body">
      <h1>Show Role</h1>

      <div class="dialog">
        <table>
                   
          <tbody>
                   
            <tr class="prop">
              <td valign="top" class="name">Id:</td>
              <td valign="top" class="value">${authority.id}</td>
            </tr>
                   
            <tr class="prop">
              <td valign="top" class="name">Role Name:</td>
              <td valign="top" class="value">${authority.authority.substring(5).toLowerCase()}</td>
            </tr>
                   
            <tr class="prop">
              <td valign="top" class="name">Description:</td>
              <td valign="top" class="value">${authority.description}</td>
            </tr>
                   
            <tr class="prop">
              <td valign="top" class="name">People:</td>
              <td valign="top" class="value">${authority.people}</td>
            </tr>
                   
          </tbody>
        </table>
      </div>
    
      <p>&nbsp;</p>
    
      <g:form controller="role">
          <input type="hidden" name="id" value="${authority?.id}" />
          <g:actionSubmit class="button" value="Edit" />
          <g:actionSubmit class="button" onclick="return confirm('Are you sure?');" value="Delete" />          
      </g:form>

    </div>
    
  </body>
</html>
