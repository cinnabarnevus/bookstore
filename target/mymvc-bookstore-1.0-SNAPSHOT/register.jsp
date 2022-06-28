<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/style.css" type="text/css"/>
    <script type="text/javascript" src="css/mjs.js" charset="UTF-8">
    </script>
    <script type="text/javascript">
        function validate(){
            if(registerForm.username.value==""){
                alert("账号不能为空！");
                return;
            }
            if(registerForm.password.value==""){
                alert("密码不能为空！");
                return;
            }
            if(registerForm.confirmPassword.value==""){
                alert("确认密码不能为空！");
                return;
            }
            registerForm.submit();
        }
    </script>
    <script type="text/javascript">
        function refresh(){
            var d = new Date();
            registerForm.imgValidate.src = 'CodeServlet?t='+d.toString(38);
        }
    </script>
</head>
<body>
    <div id="container">
        <div id="left">
            <div id="up">新用户注册</div>
            <div id="down">USER REGISTER</div> 
        </div>
        <div id="center">
            <form name="registerForm" action="AddUser" id="userForm">
                用户名  <input type="text" style="width: 250px" class="border" placeholder="请输入用户名(英文字符或数字)" value="" name ="username"/><span id="userMessage"></span><br>
                密码    <input type="password" class="border" style="width: 250px" placeholder="请输入密码(长度在6-12位之间)" value="" name ="password"/><span id="pwdMessage"></span><br>
                确认密码<input type="password" class="border"  placeholder="请确认密码" value="" id ="confirmPassword"/><span id="conPwdMessage"></span><br>
               <!-- Email   <input type="text" class="border"  placeholder="请输入Email" value="" id="email"><span id="emailMessage"></span><br>
                姓名    <input type="text" class="border"  placeholder="请输入真实姓名(中文姓名)" value="" name="name"><br>
                手机号  <input type="text" class="border"  placeholder="请输入你的手机号" value="" id="number"><br>
                身份证号    <input type="text" class="border"  placeholder="请输入你的真实身份证号" value="" id="idnub"><span id="idnubMessage"></span><br>
                性别    <input type="radio" value="male" name="sex" checked/>男
                    <input type="radio"  value="female" name="sex" checked/>女<br>
                出生日期    <input type="text" class="border"  placeholder="   年 / 月 / 日" value="" name="date"><br>-->
                验证码   <input name="code" type="text" class="border"  placeholder="Please enter validate code" length="4" id="code">
                        <img name="imgValidate" src="CodeServlet" border=0 onclick="refresh()" style="vertical-align: middle"><br>
                        <!--<img src="img/valid.png" height="30px" style="vertical-align: middle"> <!设置图片与文本框对齐> <br>-->
                        <input type="button" class="border" id="register" onClick="validate()" value="注册">
                </form>
        </div>
        <div id="right">
            已有账号?<a href="login.jsp" style="color:red">立即登录</a>
        </div>
    </div>
</body>
</html>