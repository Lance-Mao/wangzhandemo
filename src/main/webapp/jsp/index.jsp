<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/css.css">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="/jQuery/jquery-1.8.0.js"></script>

</head>
<script>
    var url = "/problem"
    var proble = {
            add: function () {
                $(".problem_add").show();

            },
            addChild: function (data) {
                alert(JSON.stringify(data));
                var html = '';
                html += ' <tr>';
                html += ' <td><input type="checkbox" name="" lay-skin="primary"></td>';
                html += ' <td>data.title</td>';
                html += ' <td>data.userId</td>';
                html += ' <td>data.content</td> < / tr > ';
                $("#content").append(html);
            },

            del: function () {
//            $(function(){
//                    $("input[name='']:checked").each(function() { // 遍历选中的checkbox
//                        n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
//                        $("tbody#content").find("tr:eq("+n+")").remove();
//                    });
//                });
                $("#content").find("tr input[type='checkbox']:checked").parents('tr').remove();
            },

            add_Serv: function (rs) {
                var title = rs.title;
                var userId = rs.usernameID;
                var content = rs.content;

                var data =
                    {
                        userId: userId,
                        title: title,
                        content: content,
                        op: "1"
                    }
                proble.addChild(data);
                $.post(url, data, function (data) {
//                    data = toJson(data);
//                    data = JSON.stringify(data);

                })
            },
        }
        ;</script>


<div>
    <blockquote class="layui-elem-quote">欢迎进入直呼系统!个人中心</blockquote>

    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">

        <script src="/layui/layui.js" charset="utf-8"></script>
        <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
        <script>
            var rs;
            layui.use(['form', 'layedit', 'laydate'], function () {
                var form = layui.form()
                    , layer = layui.layer
                    , layedit = layui.layedit
                    , laydate = layui.laydate;

                //创建一个编辑器
                var editIndex = layedit.build('LAY_demo_editor');

                //自定义验证规则
                form.verify({
                    title: function (value) {
                        if (value.length < 1) {
                            return '请输入您的用户名';
                        }
                    }
                    , pass: [/(.+){6,12}$/, '密码必须6到12位']
                    , content: function (value) {
                        layedit.sync(editIndex);
                    }
                });

                //监听指定开关
                form.on('switch(switchTest)', function (data) {
                    layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
                        offset: '6px'
                    });
                    layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
                });

                //监听提交
                form.on('submit(demo1)', function (data) {
//                    layer.alert(JSON.stringify(data.field), {
//                        title: '最终的提交信息'
//                    })
                    rs = data.field;
                    proble.add_Serv(rs);
                });
            });
        </script>
        <div class="problem_add" style="    position: absolute;top:100px;left:40px;background-color: white">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>问题添加</legend>
            </fieldset>

            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">标题</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入用户名"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户ID</label>
                    <div class="layui-input-block">
                        <input type="text" name="usernameID" lay-verify="required" placeholder="请输入标题"
                               autocomplete="off"
                               class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">编辑器</label>
                    <div class="layui-input-block">
            <textarea class="layui-textarea layui-hide" name="content" lay-verify="content"
                      id="LAY_demo_editor"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                </div>
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1" onclick="proble.addChild()">立即提交
                    </button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </form>
        </div>
        <table class="layui-table" lay-skin="line">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>问题管理</legend>
            </fieldset>
            <div class="layui-btn-group" style="padding-left: 10px">
                <button class="layui-btn layui-btn-small" style="padding-left: 10px" onclick="proble.add()"><i
                        class="layui-icon"></i>添加问题
                </button>
                <button class="layui-btn layui-btn-small" id="but_del" style="margin-left: 30px" onclick="proble.del()">
                    <i
                            class="layui-icon"></i>删除问题
                </button>
            </div>
            <div class="layui-form">
                <table class="layui-table" id="pro_del">
                    <colgroup>
                        <col width="50">
                        <col width="150">
                        <col width="150">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
                        <th>提问用户</th>
                        <th>标题</th>
                        <th>提问时间</th>
                        <th>问题描述</th>
                    </tr>
                    </thead>
                    <tbody id="content">
                    <tr>
                        <td><input type="checkbox" name="" lay-skin="primary"></td>
                        <td>贤心</td>
                        <td>汉族</td>
                        <td>1989-10-14</td>
                        <td>人生似修行</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="" lay-skin="primary"></td>
                        <td>张爱玲</td>
                        <td>汉族</td>
                        <td>1920-09-30</td>
                        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="" lay-skin="primary"></td>
                        <td>Helen Keller</td>
                        <td>拉丁美裔</td>
                        <td>1880-06-27</td>
                        <td> Life is either a daring adventure or nothing.</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="" lay-skin="primary"></td>
                        <td>岳飞</td>
                        <td>汉族</td>
                        <td>1103-北宋崇宁二年</td>
                        <td>教科书再滥改，也抹不去“民族英雄”的事实</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="" lay-skin="primary"></td>
                        <td>孟子</td>
                        <td>华夏族（汉族）</td>
                        <td>公元前-372年</td>
                        <td>猿强，则国强。国强，则猿更强！</td>
                    </tr>
                    </tbody>

                </table>
            </div>
        </table>

        <table class="layui-table" lay-skin="line">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                <legend>答案管理</legend>
            </fieldset>

            <div class="layui-btn-group" style="padding-left: 10px">
                <button class="layui-btn layui-btn-small" style="padding-left: 10px"><i class="layui-icon"></i>添加问题
                </button>
                <button class="layui-btn layui-btn-small" style="margin-left: 30px"><i class="layui-icon"></i>删除问题
                </button>
            </div>

            <div class="layui-form">
                <table class="layui-table">
                    <colgroup>
                        <col width="50">
                        <col width="150">
                        <col width="150">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose"></th>
                        <th>回答用户</th>
                        <th>标题</th>
                        <th>回答时间</th>
                        <th>回答内容</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input type="checkbox" name="" lay-skin="primary"></td>
                        <td>贤心</td>
                        <td>汉族</td>
                        <td>1989-10-14</td>
                        <td>人生似修行</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="" lay-skin="primary"></td>
                        <td>张爱玲</td>
                        <td>汉族</td>
                        <td>1920-09-30</td>
                        <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="" lay-skin="primary"></td>
                        <td>Helen Keller</td>
                        <td>拉丁美裔</td>
                        <td>1880-06-27</td>
                        <td> Life is either a daring adventure or nothing.</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="" lay-skin="primary"></td>
                        <td>岳飞</td>
                        <td>汉族</td>
                        <td>1103-北宋崇宁二年</td>
                        <td>教科书再滥改，也抹不去“民族英雄”的事实</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="" lay-skin="primary"></td>
                        <td>孟子</td>
                        <td>华夏族（汉族）</td>
                        <td>公元前-372年</td>
                        <td>猿强，则国强。国强，则猿更强！</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </table>
    </fieldset>
</div>
</html>
