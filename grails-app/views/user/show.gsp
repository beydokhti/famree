  
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
  </head>
  <body>
    <div class="body">
      <h1>${person.userRealName} (${person.username})</h1>

      <div class="dialog">
        <table>
          <tbody>
                   
            <tr class="prop">
              <td valign="top" class="name">Enabled:</td>
              <td valign="top" class="value">
                ${person.enabled?.encodeAsHTML()}
              </td>
            </tr>
                   
            <tr class="prop">
              <td valign="top" class="name">Roles:</td>
              <td valign="top" class="value">
                <ul>
                <g:collect in="${person.authorities}" expr="${it.authority}">
                  <li>${it?.substring(5)?.toLowerCase()}</li>
                </g:collect>
                </ul>
              </td>
            </tr>
                   
          </tbody>
        </table>
      </div>
      
      <p>&nbsp;</p>
      
      <g:form controller="user">
         <input type="hidden" name="id" value="${person?.id}" />
          <g:actionSubmit class="button" value="Edit" action="edit" />
          <g:actionSubmit class="button" value="Delete" onclick="return confirm('Are you sure?');" />
          <g:actionSubmit class="button" value="Cancel" action="list" />
      </g:form>
      
      
    </div>
  </body>
</html>
