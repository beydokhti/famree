<html>
    <head>
        <title><g:template key="site.title" defaultValue="My Family Tree" /></title>
        <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
        <g:javascript library="prototype/prototype" />
        <g:javascript library="prototype/scriptaculous" />
        <resource:tooltip />
    </head>
    <body onload="${pageProperty(name:'body.onload')}" >
      <div id="wrapper">
        <div class="logo">
          %{--<g:link controller="home">--}%
              %{--<img src="${createLinkTo(dir:'images',file:'pedigree_logo.png')}" alt="Family Tree Home" border="0" style="vertical-align:middle;margin:0 10px 0 0;"/>--}%
          %{--</g:link>--}%
          %{--<g:template key="site.title" defaultValue="My Family Tree" />--}%
          <div class="loginInfo">
            <g:isLoggedIn>
              Welcome <g:loggedInUserInfo field="username" />, <g:link controller="logout">Logout</g:link>
            </g:isLoggedIn>
            <g:isNotLoggedIn><g:link controller="login">Login</g:link></g:isNotLoggedIn>
          </div>
        </div>	
        <g:render template="/menu"/>        
        <g:render template="/message"/>
        <g:layoutBody />
        %{--<div class="footer">--}%
          %{--<g:template key="site.title" defaultValue="Family Tree" /> MTB ${grailsApplication.metadata['app.version']}</a>--}%
        %{--</div>--}%
      </div>		
    </body>	
</html>