<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<br>
<fieldset class="layui-elem-field">
    <br>
    <legend>直呼 - 在线登录</legend>
    <div class="layui-form layui-form-pane">
        <div class="layui-field-box">
            <table class="layui-table" lay-even="" lay-skin="row">
                <thead>
                <tr>
                    <th colspan="2" style="text-align: center">登录</th>
                    <th colspan="2" style="text-align: center">用户注册</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td style="text-align: center">
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline">
                                <input type="text" id="loginUser" lay-verify="required" placeholder="请输入用户名"
                                       autocomplete="off" class="layui-input">

                                <span style="margin-left: 100px;color:red;margin-top: 5px" id="msg_u"></span>
                            </div>
                        </div>
                        <br>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="loginPwd" lay-verify="required" placeholder="请输入密码"
                                       autocomplete="off" class="layui-input">

                                <span style="margin-left: 100px;color:red;margin-top: 5px" id="msg_p"></span>
                            </div>
                        </div>
                        <br>
                        <button class="layui-btn" id="loginBtn" onclick="user.login()"
                                style="float: left;margin-left: 110px">登录
                        </button>

                    </td>
                    <td>

                    </td>
                    <td>
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" id="reguserName" lay-verify="required" placeholder="请输入用户名"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <br>
                        <div class="layui-form-item">
                            <label class="layui-form-label">密码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" id="regPwd" lay-verify="required" placeholder="请输入密码"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <br>
                        <div class="layui-form-item">
                            <label class="layui-form-label">确认密码</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" id="regPwdd" lay-verify="required" placeholder="请确认密码"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <br>
                        <div class="layui-form-item">
                            <label class="layui-form-label">您的地址</label>
                            <div class="layui-input-inline">
                                <input type="text" name="address" id="regAddress" lay-verify="required" placeholder="请输入您的地址"
                                       autocomplete="off" class="layui-input">
                                <br>
                                <br>
                                <span style="margin-left: 100px;color:red;margin-top: 5px" id="msg_r"></span>
                            </div>
                        </div>
                        <br>
                        <button class="layui-btn" style="margin-left: 110px" id="regisyerBtn" onclick="user.register()">点击注册</button>
                    </td>
                    <td>

                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</fieldset>
</body>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script type="text/javascript">
    var url = "/user";
    var user = {
        login: function () {
            var userName = $("#loginUser").val();
            var password = $("#loginPwd").val();
            var data =
                {
                    userName: userName,
                    password: password,
                    op:"1"
                }
            $.post(url, data, function (data) {
                data = toJson(data);
                if (data.success){
                    location.href="jsp/index.jsp";
                }else {

                    $("#msg_p").text(data.msg);

                }

            });
        },
        register: function () {
            var userName = $("#reguserName").val();
            var password = $("#regPwd").val();
            var address = $("#regAddress").val();
            var data = {
                userName: userName,
                password: password,
                address: address,
                op: "2"
            }

            $.post(url,data,function (data) {

                data = toJson(data);
                if (data.success){
                   location.href="jsp/index.jsp";
                }else {
                    $("#msg_r").text(data.msg);
                }
            })

        }
    };
function toJson(data) {
    var reg=/=/g;
    var rs  =data.replace(reg,":");
    var json =JSON.parse(rs);
    return json;
}
</script>

</body>
</html>
