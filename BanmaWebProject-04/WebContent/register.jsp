<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>新博客系统注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/main.css" media="all" />
<!--[if IE 6]><link type="text/css" rel="stylesheet" href="css/ie6.css" media="all" /><![endif]-->
<script type="text/javascript" src="js/mootools.js"></script>
<script type="text/javascript" src="js/site.js"></script>

</head>
<body>
<div id="wrapper">
  <div id="container">
    <div id="scene"> <img src="images/scene.jpg" alt="" />
      <h1>博客网站系统</h1>
      <div id="scale_area">
        <div id="scale_knob">&raquo; Font Size &laquo;</div>
      </div>
      <div id="menu">
        <div class="holder"> <a href="showAllArticle.action">博客首页</a> </div>
        <div class="holder"> <a href="register.jsp">新博客注册</a> </div>
        <div class="holder"> <a href="login.jsp">博客登录</a> </div>
      </div>
    </div>
    <div id="content">
      <div id="col_left">
        <div class="post">
          <div class="meta"></div>
          <div class="comments"><div class="comment"></div>
            <h2>新博客注册</h2>
          
            
            
            <s:form action="register" method="post">
            
              <div>
               
                <!-- <input type="text" name="username" value="%{username}" />* -->
                 <s:textfield label="帐号" name="username" value="%{username}" /> 
                 <s:fielderror><s:param> <label>帐号:</label></s:param></s:fielderror>
                
              </div>
              <div>
                
               <!-- <input type="password" name="password" value="%{password}" />* -->
               <s:textfield label="密码" name="password" value="%{password}" /> 
               <s:fielderror><s:param><label>密码:</label></s:param></s:fielderror>
              </div>
			   
			   <div>
                
                <!-- <input type="password" name="repassword" value="%{repassword}" />* -->
                <s:textfield label="确认密码" name="repassword" value="%{repassword}" /> 
                
                <s:fielderror><s:param><label>确认密码:</label></s:param></s:fielderror>
              </div>
			   <div>
                
                <!-- <input type="text" name="nickname" value="%{nickname}" />* -->
                <s:textfield label="昵称" name="nickname" value="%{nickname}" /> 
   
                <s:fielderror><s:param><label>昵称:</label></s:param></s:fielderror>
              </div>
			   <div>
                
                <!-- <input type="text" name="question" value="%{question}" />* -->
                <s:textfield label="密码保护问题" name="question" value="%{question}" /> 
                
				<s:fielderror><s:param><label>密码保护问题:</label></s:param></s:fielderror>
              </div>
			   <div>
                
                <!-- <input type="text" name="answer" value="%{answer}" />* -->
                <s:textfield label="密码保护的答案" name="answer" value="%{answer}" /> 
                
                <s:fielderror><s:param><label>密码保护的答案:</label></s:param></s:fielderror>
              </div>
              <div>
                <label></label>
                <div class="clear"> </div>
              </div>
              <div class="button_wrapper">
                <!-- <input name="提交" type="submit" class="button" value="注册" /> -->
              </div>
              <s:submit value="Submit" />
            </s:form>
          </div>
        </div>
      </div>
      <div id="col_right">
        <div id="search_box">
          <form action="" method="post">
            <div>
              <input type="text" name="search" />
            </div>
            <div class="button_wrapper">
              <input type="submit" value="Search" class="button" />
            </div>
            <div class="clear"> </div>
          </form>
        </div>
        <div id="sidebar">
          <h2>页面导航</h2>
          <ul>
            <li><a href="showAllArticle.action">博客首页</a></li>
            <li><a href="register.jsp">新博客注册</a></li>
            <li><a href="login.jsp">博客登录</a></li>
          </ul>
        </div>
      </div>
      <div class="clear"> </div>
    </div>
    <div id="footer">
      <div class="clear"> </div>
      <hr />
      <p class="credit">博客网站系统</p>
    </div>
  </div>
</div>
</body>
</html>
