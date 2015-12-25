  
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>User Profile</title>
  </head>
  <body>

    <div class="body">
      <h1>Your Account</h1>

      <div class="dialog">
        <table>
          <tbody>

            <tr class="prop">
              <td valign="top" class="name">Login Name:</td>
              <td valign="top" class="value">
              	${person.username?.encodeAsHTML()}
              </td>
            </tr>
                   
            <tr class="prop">
              <td valign="top" class="name">Full Name:</td>
              <td valign="top" class="value">
                ${person.userRealName?.encodeAsHTML()}
              </td>
            </tr>
                   
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
      
      <g:form controller="register">
        <input type="hidden" name="id" value="${person?.id}" />
        <g:actionSubmit value="Edit" class="button" />
      </g:form>
      

    </div>
  </body>
</html>
