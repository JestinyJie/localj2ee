<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工修改</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="employee_update" method="post" theme="simple" id="saveForm" namespace="/">
 <s:hidden name="eid" value="%{model.eid}"></s:hidden>
  <s:hidden name="username" value="%{model.username}"></s:hidden>
<table border='0' cellpadding="0"  cellspacing="10">

<tr>

<td>姓名<span style="color:red">*</span>：</td>
<td><s:textfield name="ename" value="%{model.ename}"></s:textfield></td>
<td>性别<span style="color:red">*</span>：</td>
<td><s:radio name="sex" list="{'男','女'}" value="%{model.sex}"></s:radio></td>
</tr>

<tr>
<td>用户名<span style="color:red">*</span>：</td>
<td><s:textfield name="username" value="%{model.username}" disabled="true" ></s:textfield></td>
<td>密码<span style="color:red">*</span>：</td>
<td><s:password name="password"></s:password></td>
</tr>

<tr>
<td>出生日期<span style="color:red">*</span>：</td>
<td><input name="birthday" type="text" value="<s:date name='model.birthday' format='yyyy-MM-dd' />" /></td>
<td>入职时间<span style="color:red">*</span>：</td>
<td><input name="joinDate" type="text" value="<s:date name='model.joinDate' format='yyyy-MM-dd' />" /></td>
</tr>

<tr>
<td>所属部门<span style="color:red">*</span>：</td>
<td><s:select name="department.did" list="list" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--"></s:select></td>
<td>编号<span style="color:red">*</span>：</td>
<td><s:textfield name="eno" value="%{model.eno}"></s:textfield></td>
</tr>
<tr><td><span style="color:red"><s:property value="#request.errorMsg"/></span></td></tr>
</table>
</s:form>

</body>
</html>