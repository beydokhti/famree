  
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Role List</title>
  </head>
  <body>

    <div class="body">
      <h1>Role List</h1>
      
      <table>      
        <thead>
          <tr>               
            <g:sortableColumn property="id" title="Id" />                  
            <g:sortableColumn property="authority" title="Role Name" />                  
            <g:sortableColumn property="description" title="Description" />                  
          </tr>
        </thead>
        
        <tbody>
          <g:each in="${authorityList}" var="authority">
            <tr>                     
              <td><g:link action="show" id="${authority.id}">${authority.id?.encodeAsHTML()}</g:link></td>                       
              <td>${authority.authority?.substring(5)?.toLowerCase()?.encodeAsHTML()}</td>                       
              <td>${authority.description?.encodeAsHTML()}</td>                       
            </tr>
          </g:each>
        </tbody>
        
      </table>
      
      <div class="paginateButtons">
        <g:paginate total="${Role.count()}" />
      </div>

      <p>&nbsp;</p>
            
      <g:form action="create">
         <g:actionSubmit value="New Role" class="button" />
      </g:form>
                  
    </div>
  </body>
</html>
