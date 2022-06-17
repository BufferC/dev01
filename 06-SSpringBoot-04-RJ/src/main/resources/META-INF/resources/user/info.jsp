<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title"><span class="glyphicon glyphicon-edit"></span>&nbsp;个人中心</div>
        <div class="container-fluid">
            <div class="row" style="padding-top: 20px;">
                <div class="col-md-8">
                    <%--
                        表单类型  enctype="multipart/form-data"
                        提交方式  method="post"
                    --%>
                    <form class="form-horizontal" method="post" action="/user/update" enctype="multipart/form-data">
                        <%--隐藏id属性框--%>
                        <input type="hidden" name="id" id="id" value="${user.id}">

                        <div class="form-group">
                            <label for="nickname" class="col-sm-2 control-label">昵称:</label>
                            <div class="col-sm-3">
                                <input class="form-control" name="nick" id="nickname" placeholder="昵称"
                                       value="${user.nick}">
                            </div>
                            <label for="img" class="col-sm-2 control-label">头像:</label>
                            <div class="col-sm-5">
                                <input type="file" id="img" name="img">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="mood" class="col-sm-2 control-label">心情:</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" name="mood" id="mood" rows="3">${user.mood}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" id="btn" class="btn btn-success" onclick="return updateUser();">
                                    修改
                                </button>&nbsp;&nbsp;
                                <span style="color:red; font-size: 12px;" id="msg"></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-4">
                    <div class="userimg">
                        <img src="${user.head}">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    /**
     * 验证昵称的唯一性
     昵称文本框的失焦事件  blur
     1. 获取昵称文本框的值
     2. 判断值是否为空
     如果为空，提示用户，禁用按钮，并return
     3. 判断昵称是否做了修改
     从session作用域中获取用户昵称 （如果在js中想要使用el表达式获取域对象，js需要写在JSP页面中，无法在js文件中获取）
     如果用户昵称与session中的昵称一致，则return
     4. 如果昵称做了修改
     发送ajax请求后台，验证昵称是否可用
     如果不可用，提示用户，并禁用按钮
     如果可用，清空提示信息，按钮可用

     昵称文本框的聚焦事件  focus
     1. 清空提示信息
     2. 按钮可用
     */
    $("#nickname").blur(function () {
        // 1. 获取昵称文本框的值
        var nickname = $("#nickname").val();
        // 2. 判断值是否为空
        if (isEmpty(nickname)) {
            //  如果为空，提示用户，禁用按钮，并return
            $("#msg").html("用户昵称不能为空！")
            $("#btn").prop("disabled", true);
            return;
        }
        // 3. 判断昵称是否做了修改
        // 从session作用域中获取用户昵称
        var nick = '${user.nick}';
        // 如果用户昵称与session中的昵称一致，则return
        if (nickname === nick) {
            return;
        }
        // 4. 如果昵称做了修改
        // 发送ajax请求后台，验证昵称是否可用
        $.ajax({
            type: "get",
            url: "/user/checkNick",
            data: {
                nick: nickname
            },
            success: function (code) {
                // 如果可用，清空提示信息，按钮可用
                if (code === 0) {
                    // 1. 清空提示信息
                    $("#msg").html("")
                    // 2. 按钮可用
                    $("#btn").prop("disabled", false);
                } else { // 如果不可用，提示用户，并禁用按钮
                    // 1. 清空提示信息
                    $("#msg").html("该昵称已存在，请重新输入！")
                    // 2. 按钮可用
                    $("#btn").prop("disabled", true);
                }
            }
        });
    }).focus(function () {
        // 1. 清空提示信息
        $("#msg").html("")
        // 2. 按钮可用
        $("#btn").prop("disabled", false);
    });

    /**
     * 表单提交校验
     *      满足条件，返回true，表示提交表单
     *      不满足条件，返回false，表示不提交表单
     * @returns {boolean}
     */
    function updateUser() {

        // 获取昵称文本框的值
        var nickname = $("#nickname").val();
        // 判断值是否为空
        if (isEmpty(nickname)) {
            //  如果为空，提示用户，禁用按钮，并return
            $("#msg").html("用户昵称不能为空！")
            $("#btn").prop("disabled", true);
            return false;
        }

        // 唯一性 TODO

        return true;
    }

</script>
