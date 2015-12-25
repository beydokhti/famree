  
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
  </head>
  <body>

    <div class="body">
      <h1>Authorized Users</h1>

      <table>
        <thead>
          <tr>                          
            <g:sortableColumn property="username" title="Username" />                  
            <g:sortableColumn property="userRealName" title="Full Name" />                  
            <g:sortableColumn property="enabled" title="Enabled" />                  
            <th>Roles</th>
          </tr>
        </thead>
        <tbody>
          <g:each in="${personList}" var="person">
            <tr>                                             
              <td><g:link action="show" id="${person.id}">${person.username?.encodeAsHTML()}</g:link></td>                       
              <td>${person.userRealName?.encodeAsHTML()}</td>                       
              <td>${person.enabled?.encodeAsHTML()}</td>                       
              <td>
                <g:each in="${person.authorities}">${it?.authority?.substring(5)?.toLowerCase()} &nbsp;</g:each>
              </td>                       
            </tr>
          </g:each>
        </tbody>
      </table>
    
      <div class="paginateButtons">
        <g:paginate total="${AuthUser.count()}" />
      </div>

      <p>&nbsp;</p>
            
      <g:form action="create"> 
         <g:actionSubmit value="New User" class="button" action="create" />
      </g:form>
                  
    </div>
  </body>
</html>
