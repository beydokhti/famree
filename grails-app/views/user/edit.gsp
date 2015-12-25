  
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Edit Authorized User</title>
  </head>
  <body>

    <div class="body">
      <h1>Edit Authorized User</h1>

      <g:hasErrors bean="${person}">
        <div class="errors">
          <g:renderErrors bean="${person}" as="list" />
        </div>
      </g:hasErrors>
           
      <g:form controller="user" method="post" >
        <input type="hidden" name="id" value="${person?.id}" />
         <g:render template="user" model="['person':person]" />

        <p>&nbsp;</p>
        
        <g:actionSubmit value="Update" class="button" />
        <g:actionSubmit value="Delete" class="button" />
        <g:actionSubmit class="button" value="Cancel" action="list" />
      </g:form>
      
    </div>
  </body>
</html>
