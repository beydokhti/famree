        <div class="dialog">
          <table>
            <tbody>

              <tr class='prop'>
                <td valign='top' class='name'>
                  <label for='username'>Username:</label>
                </td>
                <td valign='top' 
                	class='value ${hasErrors(bean:person,field:'username','errors')}'>
                  <input type="text" name='username' 
                  		 value="${person?.username?.encodeAsHTML()}"/>
                  <span class="required">*</span>
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
                  <span class="required">*</span>
                </td>
              </tr>
                       
              <tr class='prop'>
                <td valign='top' class='name'>
                  <label for='passwd'>Password:</label>
                </td>
                <td valign='top' 
                    class='value ${hasErrors(bean:person,field:'passwd','errors')}'>
                  <input type="password" name='passwd' 
                         value="${person?.passwd?.encodeAsHTML()}"/>
                  <span class="required">*</span>
                </td>
              </tr>
                       
              <tr class='prop'>
                <td valign='top' class='name'>
                  <label for='enabled'>Enabled:</label>
                </td>
                <td valign='top' 
                	class='value ${hasErrors(bean:person,field:'enabled','errors')}'>
                  <g:checkBox name='enabled' value="${person?.enabled}" ></g:checkBox>
                </td>
              </tr>
                        
              <tr class='prop'>
                <td valign='top' class='name' align="left">Assign Roles:</td>
              </tr>
            
              <g:each in="${authorityList}">
	    	  <tr>
	     	    <td valign='top' class='name' align="right">
	     	      ${it.authority?.substring(5)?.toLowerCase()?.encodeAsHTML()}
	     	    </td>
	     	    <td align="left">
	     	      <g:checkBox name='${it.authority}' value="${person?.authorities?.contains(it)? true: false}" ></g:checkBox>
	     	    </td>
	    	  </tr>
	          </g:each>
	    				
            </tbody>
          </table>
        </div>
  