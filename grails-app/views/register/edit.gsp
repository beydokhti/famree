
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Edit Profile</title>
  </head>
  <body>

    <div class="body">
      <h1>Edit Account</h1>

      <g:hasErrors bean="${person}">
        <div class="errors">
          <g:renderErrors bean="${person}" as="list" />
        </div>
      </g:hasErrors>

      <g:form controller="register" method="post" >
        <input type="hidden" name="id" value="${person?.id}" />
        <div class="dialog">
          <table>
            <tbody>

        <tr class='prop'>
          <td valign='top' class='name'>
            <label for='username'>Login Name:</label>
          </td>
          <td valign='top'
            class='value ${hasErrors(bean:person,field:'username','errors')}'>
          <input type="hidden" name='username'
            value="${person?.username?.encodeAsHTML()}"/>
            <div style="margin:3px">${person?.username?.encodeAsHTML()}</div>
          </td>
        </tr>

			  <tr class='prop'>
			    <td valign='top' class='name'>
			      <label for='userRealName'>Full Name:</label>
			    </td>
				<td valign='top'
				    class='value ${hasErrors(bean:person,field:'userRealName','errors')}'>
				  <input type="text" name='userRealName'
				         value="${person?.userRealName?.encodeAsHTML()}"/>
				</td>
			  </tr>

        <tr class='prop'>
          <td valign='top' class='name'>
            <label for='passwd'>Password:</label>
          </td>
          <td valign='top'
            class='value ${hasErrors(bean:person,field:'passwd','errors')}'>
            <input type="password" name='passwd' value=""/>
          </td>
        </tr>

        <tr class='prop'>
          <td valign='top' class='name'>
            <label for='enabled'>Confirm Password:</label>
          </td>
          <td valign='top'
            class='value ${hasErrors(bean:person,field:'passwd','errors')}'>
            <input type="password" name='repasswd'
              value=""/>
          </td>
        </tr>


            </tbody>
          </table>
        </div>

        <g:actionSubmit value="Update" class="button" />

      </g:form>

    </div>
  </body>
</html>
