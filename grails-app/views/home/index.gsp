<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <resource:timeline/>
    <resource:treeView/>
    <resource:tabView/>
    <resource:autoComplete skin="default"/>
    <g:javascript library="yui/yahoo-dom-event/yahoo-dom-event"/>
    <g:javascript library="yui/element/element-beta"/>
    <g:javascript library="yui/button/button"/>
    <g:javascript library="yui/container/container"/>
    <g:javascript library="yui/dragdrop/dragdrop"/>
    <link rel="stylesheet" href="${createLinkTo(dir: 'js', file: 'yui/fonts/fonts-min.css')}"/>
    <link rel="stylesheet" href="${createLinkTo(dir: 'js', file: 'yui/button/assets/skins/sam/button.css')}"/>
    <link rel="stylesheet" href="${createLinkTo(dir: 'js', file: 'yui/container/assets/skins/sam/container.css')}"/>

</head>

%{--<body onload="initTimeline();">--}%
<body>
%{--<div class="body">--}%

    %{--<div class="site_top">--}%
    %{--<div class="site_info">--}%
    %{--<g:template key="site.info" defaultValue="Information about the site" />--}%
    %{--</div>--}%

    %{--<div class="site_chart">--}%
    %{--<g:if test="${totalMembers > 0}">--}%
    %{--<g:pieChart title='Composition by Gender' colors="${genderColors}" labels="${genderLabels}" type="3d" size="[280,120]" data='${genderValues}' />--}%
    %{--</g:if>--}%
    %{--</div>--}%
    %{--<div class="site_chart">--}%
    %{--<g:if test="${totalMembers > 0}">--}%
    %{--<g:pieChart title='Composition by Age' colors="${ageColors}" labels="${ageLabels}" type="3d" size="[280,120]" data='${ageValues}' />--}%
    %{--</g:if> --}%
    %{--</div>--}%
    <h1>Family Tree</h1>

    <div class="display_tree_home">
        <g:if test="${data}">
            <richui:treeView xml="${data}"/>
        </g:if>
    </div>

    %{--</div>--}%

    %{--<div style="clear:both;"></div>--}%

    %{--<h1>Upcoming Events</h1>--}%
    %{--&nbsp;Click & drag Timeline to scroll--}%
    %{--<richui:timeline class="events_timeline" startDate="${new Date() + 18}"--}%
                     %{--datasource="${createLink(controller: 'home', action: 'eventsAjax')}"/>--}%
    %{--<div style="vertical-align:middle;text-align:right;margin:5px 30px 0 0">Stay informed by subscribing to the feed <a--}%
            %{--href="/famree/home/feed"><img src="${createLinkTo(dir: 'images', file: 'feed-icon.gif')}" alt="RSS Feed"--}%
                                          %{--style="vertical-align:middle;" border="0"></a></div>--}%

    %{--<p>&nbsp;</p>--}%

    %{--<h1>Announcements</h1>--}%
    %{--<g:if test="${!announcements}">Presently, there are no announcements</g:if>--}%

    %{--<g:each in="${announcements}">--}%
        %{--<div class="eventItem announcement">--}%
            %{--<b>${it.subject}</b> <br>--}%
            %{--${it.details}--}%
        %{--</div>--}%
    %{--</g:each>--}%

%{--</div>--}%
</body>
</html>
