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
                <label for='member'>Member:</label>
            </td>
            <td valign='top'
                class='value ${hasErrors(bean:person,field:'userRealName','errors')}'>
                %{--<g:select optionKey="id" from="${FamilyMember.list()}" name="member.id" value="${person?.member?.id}" noSelection="['null':'']"></g:select>                <span class="required">*</span>--}%
                <g:select optionKey="id" from="${FamilyMember.list()}" value="${member?.id}" name="member.id" noSelection="['null':'']"></g:select>                <span class="required">*</span>
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

        </tbody>
    </table>
</div>
  