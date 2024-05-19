<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>用户注册</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8"><LINK 
href="../../images/syscome.files/Admin.css" rel=stylesheet>
<SCRIPT language=javascript src="../../images/syscome.files/Admin.js"></SCRIPT>

<STYLE type=text/css>.STYLE1 {
	FONT-WEIGHT: bold; COLOR: #0099ff
}
</STYLE>

<META content="MSHTML 6.00.2900.5726" name=GENERATOR></HEAD>
<BODY><BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
<form name="form1" method="post" action="register">
<TABLE cellSpacing=1 cellPadding=3 width="95%" align=center bgColor=#6ab6b6 
border=0>
  <TBODY>
  <TR>
    <TH colSpan=9 height=24>【用户注册】
    
  </TR>
  <TR>
    <TD class=forumrow><div align="right">用户名：</div></TD>
    <TD colspan="8" class=forumrowhighlight>
      <input type="text" name="username">    </TD>
    </TR>
    <TR>
    <TD class=forumrow><div align="right">密码：</div></TD>
    <TD colspan="8" class=forumrowhighlight>
      <input type="text" name="password"></TD>
    </TR>
    <font color="red">${requestScope.error}</font>
   
  <TR>
    <TD class=forumrow><div align="right">姓名：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="name"></TD>
  </TR>
  <TR>
    <TD class=forumrow><div align="right">性别：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="sex"></TD>
  </TR>
  <TR>
    <TD class=forumrow><div align="right">住址：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="address"></TD>
  </TR>
  <TR>
    <TD class=forumrow><div align="right">联系电话：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="phone"></TD>
  </TR>
  <TR>
    <TD class=forumrow><div align="right">邮寄地址：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="post"></TD>
  </TR>
  <TR>
    <TD class=forumrow><div align="right">邮箱：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="email"></TD>
  </TR>
  <TR>
    <TD class=forumrow><div align="right">注册时间：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="regTime"></TD>
  </TR>
  <TR>
    <TD class=forumrow><div align="right">注册IP地址：</div></TD>
    <TD colspan="8" class=forumrowhighlight><input type="text" name="regIpAddress"></TD>
  </TR>
  <TR>
    <TD class=forumrow>&nbsp;</TD>
    <TD colspan="8" class=forumrowhighlight><input type="submit" name="Submit" value="提交">
      <input type="reset" name="Submit2" value="重置"></TD>
  </TR>
  </TBODY></TABLE>
</form>  
<BR>
<TABLE class=tableborder cellSpacing=1 cellPadding=3 width="95%" align=center 
border=0>
</TABLE><BR>
</BODY></HTML>
