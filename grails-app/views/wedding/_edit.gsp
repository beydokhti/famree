<g:formRemote name="wedding_form" url="${[controller:'wedding', action:'update']}" method="post" onComplete="done(e)">
  <input type="hidden" name="id" value="${wedding?.id}" />
  <div class="edit_wedding">

    <div class="title">${wedding.mainMember.nickname} &amp; ${wedding.spouseMember.nickname}</div>
  
    <div class="name">Married on:</div>
    <div class="value"><g:datePicker name="weddingDate" precision="day" value="${wedding?.weddingDate}"/></div> 
  
    <div class="name">Still married?:</div>
    <div class="value"><input type="checkbox" name="active" id="active" value="true" ${wedding.active? 'checked':''}></div> 
    <g:actionSubmit class="button" id="wedding_save_button" value="Save" action="update" />
    <div id="edit_wedding_result" style="font-weight:bold;margin-top:10px;">
      
    </div>
   </div>


 </g:formRemote>