<div class="nav">
    <span class="menuButton"><g:link controller="home">Home</g:link></span>
    %{--<span class="menuButton"><g:link controller="home" action="faq">FAQ</g:link></span>--}%
    <span class="menuButton"><g:link controller="member" action="display">Browse Members</g:link></span>
    <g:isLoggedIn>
        <span class="menuButton"><g:link controller="register" action="show">Account</g:link></span>
    </g:isLoggedIn>
    <g:ifAnyGranted role="ROLE_MANAGER">
        <span class="menuButton"><g:link controller="people" action="list">Create User</g:link></span>
    </g:ifAnyGranted>
    <g:ifAnyGranted role="ROLE_USER">
        <span class="menuButton"><g:link controller="member" action="profile">Profile</g:link></span>
    </g:ifAnyGranted>
    <g:ifAnyGranted role="ROLE_ADMIN">
        <span class="menuButton"><g:link controller="admin">Administration</g:link></span>
    </g:ifAnyGranted>

</div>
 