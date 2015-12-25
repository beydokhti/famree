  
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="layout" content="main" />
      <title>${grailsApplication.config.site.title}</title>
   </head>
   <body>
      <div class="body">
        <h1>Administration</h1>

        <div class="admin_tool">
            <div class="admin_title">Upcoming Events</div>
            <div class="admin_details">
             <g:remoteLink action="refreshUpcomingEventsAjax" update="[success:'upcomingEventsResult',failure:'upcomingEventsResult']">Refresh Upcoming Events!</g:remoteLink>
             <span id="upcomingEventsResult"></span>
            </div>
        </div>


        <div class="admin_tool">
            <div class="admin_title">User Management</div>
            <div class="admin_details">
              Manage users who can login and administer authorization roles 
              <p>&nbsp;</p>
             <g:link controller="user">Manage Users</g:link>
            </div>
        </div>
                
        <div class="admin_tool">
            <div class="admin_title">Item Management</div>
            <div class="admin_details">
              Manage FAQ, Events, and Announcements. 
              <p>&nbsp;</p>
              <g:link controller="item">Item Management</g:link>
            </div>
        </div>

        <div class="admin_tool">
            <div class="admin_title">Member Management</div>
            <div class="admin_details">
              View, Add, Update, Delete family members 
              <p>&nbsp;</p>
              <g:link controller="member">View All Members</g:link>
            </div>
        </div>                                  

        <div class="admin_tool">
            <div class="admin_title">Template Management</div>
            <div class="admin_details">
              Configure site templates. Some of the templates have 'Velocity' code.
              If you are attempting to change them, make sure you know what you are doing.
              <p>&nbsp;</p>
              <g:link controller="template">Configure templates</g:link>
            </div>
        </div>   
                
      </div>
    </body>
</html>
