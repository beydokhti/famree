  
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="layout" content="main" />
      <title>${grailsApplication.config.site.title}::FAQ</title>
   </head>
   <body>
      <div class="body">
      
         <h1>Frequently Asked Questions</h1>
           <g:if test="${!faqList}">
             <div class="faq">There are no FAQs</div>
           </g:if>
         
            <g:each in="${faqList}" status="i" var="faq">
              <div class="faq">
                 <div class="faq_icon"><img src="${createLinkTo(dir:'images',file:'red-bullet.gif')}" alt="FAQ" /></div>
                 <div class="faq_subject">${faq.subject}</div>
                 <div class="faq_details">${faq.details}</div>
              </div>
            </g:each>

            <div style="clear:both">&nbsp;</div>
      </div>
    </body>
</html>
