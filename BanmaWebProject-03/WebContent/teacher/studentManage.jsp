<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
#manageSubject table  td{
	font-size:12px;
}
-->
</style>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">管理学生</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="53%" valign="top">&nbsp;</td>
        </tr>
      <tr>
        <td valign="middle"><span class="left_txt">
			<div id="manageSubject" align="center"><!--管理试题-->
			<table width="95%" cellspacing="10">
			  <tr align="center">
				<td>学生编号</td>
				<td>所属班级</td>
				<td>学生姓名</td>
				<td>成绩</td>
			  </tr>
			  <s:iterator value="#request.students" var="student">
			  <tr align="center">
				<td>${student.studentID}</td>
				<td>${student.sclass}</td>
				<td>${student.studentName}</td>
				<td>${student.result}</td>
			  </tr>
			  </s:iterator>
			</table>	
			 <s:url id="url_pre" value="studentQuery.action">  
             <s:param name="currentPage" value="currentPage-1"></s:param>  
             </s:url>  
  
             <s:url id="url_next" value="studentQuery.action">  
             <s:param name="currentPage" value="currentPage+1"></s:param>  
             </s:url>    
  
             <s:a href="%{url_pre}">上一页</s:a>  
       
             <s:iterator value="students" status="status">  
             <s:url id="url" value="studentQuery.action">  
             <s:param name="currentPage" value="currentPage"/>  
             </s:url>  
             </s:iterator>  
  
             <s:a href="%{url_next}">下一页</s:a>   

			</div>
		</td>
        </tr>
      
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>





</body>
