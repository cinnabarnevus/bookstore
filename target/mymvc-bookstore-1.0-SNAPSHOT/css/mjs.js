window.onload = function() {
    var userMessageElt = document.getElementById("userMessage");
    //获取用户名文本框对象
    var usernameElt = document.getElementById("username");

    usernameElt.onblur = function() {
        //验证用户名长度是否合法
        //获取用户名字符串并去除两侧空白
        var username = usernameElt.value.trim();
        if(username.length == 0) {
            userMessageElt.innerText = "请输入用户名!";
        } else {
            if(username.length < 6 || username.length > 14) {
                userMessageElt.innerText = "用户名长度必须为6-14!";
            } else {
                //验证用户名是否符合标准格式
                //创建用户名对应的正则表达式对象
                var userRegExp = /^[A-Za-z0-9]+$/;
                var isOk = userRegExp.test(username);
                if(!isOk) {
                    userMessageElt.innerText = "用户名输入不合法!";
                }
            }
        }
        //清除提示信息和不合法字符串
        back(usernameElt,userMessageElt);
    }

    var pwdMessage = document.getElementById("pwdMessage");
    //获取密码文本框对象
    var passwordElt = document.getElementById("password");
    passwordElt.onblur = function() {
        //获取密码并去除左右空白
        var password = passwordElt.value.trim();
        //密码不能为空
        if(password.length == 0) {
            pwdMessage.innerText = "请输入密码!";
        } else if(password.length <6 || password.length > 12){
            pwdMessage.innerText = "密码长度必须为6-12!";
        }
        //光标回到文本框时清除提示信息及不合法的密码
        back(passwordElt,pwdMessage);
    }

    var conPwdMessage = document.getElementById("conPwdMessage");
    //获取确认密码文本框对象
    var confirmPasswordElt = document.getElementById("confirmPassword");
    confirmPasswordElt.onblur = function() {
        //获取密码文本框对象
        var passwordElt = document.getElementById("password");
        //获取密码并去除左右空白
        var password = passwordElt.value.trim();
        //获取重复输入的密码并去除空白
        var confirmPassword = confirmPasswordElt.value.trim();
        //密码不能为空
        if(password.length == 0 ) {
            conPwdMessage.innerText = "请输入密码!";
        } else if(confirmPassword.length == 0) {
            conPwdMessage.innerText = "请输入确认密码!";
        } else {
            if(password.length <6 || password.length > 20) {
                conPwdMessage.innerText = "密码长度必须为6-20!";
            } else if(password != confirmPassword) {
                conPwdMessage.innerText = "前后输入密码不一致!";
            }
        }
        //光标回到文本框时清楚提示信息及不合法的密码
        back(confirmPasswordElt,conPwdMessage);
    }

    var emailMessageElt = document.getElementById("emailMessage");
    //获取邮箱地址文本框对象
    var emailElt = document.getElementById("email");
    emailElt.onblur = function() {
        //获取用户在文本框中输入的字符串，并去除两侧空白
        var email = document.getElementById("email").value.trim();
        //邮箱地址不能为空
        if(email.length == 0) {
            emailMessageElt.innerText = "请输入邮箱地址!"
        } else {
            //创建邮箱对应的正则表达式对象
            var emailRegExp = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            //调用test方法验证用户输入的邮箱字符串格式，返回一个boolean值
            var isOk = emailRegExp.test(email);
            if(!isOk) {
                emailMessageElt.innerText = "邮箱格式不合法!";
            }
        }
        //文本框获得焦点时，清除提示信息和不合法value
        back(emailElt,emailMessageElt);
    }

    var idnubMessageElt = document.getElementById("idnubMessage");
    //获取身份证号文本框对象
    var idnubElt = document.getElementById("idnub");
    idnubElt.onblur = function() {
        //获取用户在文本框中输入的字符串，并去除两侧空白
        var idnub = document.getElementById("idnub").value.trim();
        //身份证号不能为空
        if(idnub.length == 0) {
            idnubMessageElt.innerText = "请输入身份证号!"
        } else {
            //创建身份证号对应的正则表达式对象
            var idRegExp = /^\d{15}$|^\d{18}$|^\d{17}[xX]$/;
            //调用test方法验证用户输入的身份证号格式，返回一个boolean值
            var isOk = idRegExp.test(idnub);
            if(!isOk) {
                idnubMessageElt.innerText = "身份证号格式不合法!";
            }
        }
        //文本框获得焦点时，清除提示信息和不合法value
        back(idnubElt,idnubMessageElt);
    }

    var back = function(textElt,messageElt) {
        textElt.onfocus = function() {
            //判断文本框value是否合法
            if(messageElt.innerHTML != "") {
                this.value = "";
            }
            //清空提示信息
            messageElt.innerHTML = "";
        }
    }
}
// var subBtnElt = document.getElementById("subBtn");
//     subBtnElt.onclick = function() {
//         //在提交前，手动触发一次所有项的blur事件
//         //触发用户名文本框的blur事件
//         usernameElt.focus();
//         usernameElt.blur();
//         //触发密码文本框的blur事件
//         passwordElt.focus();
//         passwordElt.blur();
//         //触发确认密码文本框的blur事件
//         confirmPasswordElt.focus();
//         confirmPasswordElt.blur();
//         //触发邮箱地址文本框的blur事件
//         emailElt.focus();
//         emailElt.blur();
//         //判断所有项是否合法，如果都合法，才能提交表单
//         if(userMessageElt.innerText.length == 0 && pwdMessage.innerText.length == 0 && conPwdMessage.innerText.length == 0 && emailMessageElt.innerText.length == 0) {
//             //获取表单对象
//             var formElt = document.getElementById("userForm");
//             //提交表单
//             formElt.submit();
//         }
// }
// function verify() {
//     /*E-mail验证*/
//     exp = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
//     if (!exp.test(document.forms[0].email.value)) {
//         document.getElementById("email0").innerHTML="E-mail格式错误";
//     } else {
//         document.getElementById("email0").innerHTML="E-mail格式正确";
//     }
//     /*身份证号验证*/
//     exp1 = /^\d{15}$|^\d{18}$|^\d{17}[xX]$/;
//     if(!exp1.test(document.forms[0].shen.value)){
//         document.getElementById("shen0").innerHTML="身份证号无效";
//     }else{
//         document.getElementById("shen0").innerHTML="身份证号有效";
//     }
//     /*输入密码验证*/
//     if(document.forms[0].pwd.value.length>=6&&document.forms[0].pwd.value.length<=12){
//         document.getElementById("pwd00").innerHTML="密码符合规范";
//     }else{
//         document.getElementById("pwd00").innerHTML="密码不符合规范";
//     }
//     /*确认密码验证*/
//     /*
//     if(document.forms[0].pwd1.value!=document.forms[0].pwd.value){
//         document.getElementById("pwd0").innerHTML="两次输入密码不一致,请重新输入！";
//         /*alert("两次输入密码不一致,请重新输入！");*/
// }
        
    