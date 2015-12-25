<%@ page import="com.mano.familytree.data.ItemType" %>    

<div class="dialog">
    
    <table>
        <tbody>      
            
            <tr class='prop'>
                <td valign='top' class='name'>
                    <label for='type'>Type:</label>
                </td>
                <td valign='top' class='value ${hasErrors(bean:item,field:'type','errors')}'>
                    <g:select name='type' value="${item.type}" from="${ItemType.values()}" optionValue="name" noSelection="['':'-Choose-']" onchange="checkType(this.value);" />
                    <span class="required">*</span>
                </td>
            </tr>  
                                  
            <tr class='prop'>
                <td valign='top' class='name'>
                    <label for='subject'>Subject:</label>
                </td>
                <td valign='top' class='value ${hasErrors(bean:item,field:'subject','errors')}'>
                    <input type="text" id='subject' name='subject' value="${item.subject}" size="30" />
                    <span class="required">*</span>
                </td>
            </tr>                                     
            <tr class='prop'>
                <td valign='top' class='name'>
                    <label for='details'>Details:</label>
                </td>
                <td valign='top' class='value ${hasErrors(bean:item,field:'details','errors')}'>                    
                    <richui:richTextEditor id="details" name="details" value="${item.details}" width="400" height="100" />
                </td>
            </tr>                                          
            <tr class='prop'>
                <td valign='top' class='name'>
                    <label for='active'>Active:</label>
                </td>
                <td valign='top' class='value ${hasErrors(bean:item,field:'active','errors')}'>
                    <g:checkBox name='active' value="${item?.active}" ></g:checkBox>
                </td>
            </tr> 
    
            <tr class='prop' id="showPosition" style="display:none;">
                <td valign='top' class='name'>
                    <label for='position'>Position:</label>
                </td>
                <td valign='top' class='value ${hasErrors(bean:item,field:'position','errors')}'>
                    <input type="text" id='position' name='position' value="${item.position}" size="2" />
                    <span class="required">*</span>
                    <span class="help" id="help_position" title="Items with lower position will show up before Items with higher position"></span>
                    <richui:tooltip id="help_position" />
                </td>
            </tr>          
            <tr class='prop' id="showStartDate" style="display:none">
                <td valign='top' class='name'>
                    <label for='position'>Start Date:</label>
                </td>
                <td valign='top' class='value ${hasErrors(bean:item,field:'startDate','errors')}'>
                    
                    <richui:dateChooser name="startDate" format="MM/dd/yyyy" value="${item.startDate}" /> 
                    <span class="required">*</span>     
                    <span class="help" id="help_startDate" title="Item will start from this date"></span> 
                    <richui:tooltip id="help_startDate" />                           
                 </td>
            </tr>        
            <tr class='prop' id="showEndDate" style="display:none">
                <td valign='bottom' class='name'>
                    <label for='position'>End Date:</label>
                </td>
                <td valign='bottom' class='value ${hasErrors(bean:item,field:'endDate','errors')}'>
                    
                    <richui:dateChooser name="endDate" format="MM/dd/yyyy" value="${item.endDate}" />
                    <span class="required">*</span>
                    <span class="help" id="help_endDate" title="Item will end on this date"></span>
                    <richui:tooltip id="help_endDate" />
                 </td>
            </tr>                                                                                                        
        </tbody>
    </table>
    
</div>
