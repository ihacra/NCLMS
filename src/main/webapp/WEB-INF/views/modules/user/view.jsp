<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
    <div style="width: 50%; margin-left: 25%">
        <sys:message content="${message}" hide="true" align="center"/>
    </div>
    <h1 style="margin-left: 15%">个人信息</h1>
    <form:form id="inputForm" modelAttribute="user" action="${ctx}/user/save" method="post"
               cssClass="sui-form form-horizontal sui-validate">
        <form:hidden path="id"/>
        <form:hidden path="remarks"/>
        <br/>
        <table class="sui-table table-bordered list" style="width: 70%;margin-left: 15%">
            <tr>
                <td style="text-align: center">姓名</td>
                <td><form:input path="name" maxlength="32" placeholder="请输入姓名" data-rules="required"/></td>
                <td style="text-align: center">昵称</td>
                <td><form:input path="nick" maxlength="32" placeholder="请输入昵称" data-rules="required"/></td>
            </tr>
            <tr>
                <td style="text-align: center">密码</td>
                <td><form:input path="password" maxlength="32" placeholder="请输入密码" data-rules="required"/></td>
                <td style="text-align: center">出生日期</td>
                <td>
                    <div class="input-daterange" data-toggle="datepicker">
                        <form:input path="birth" readonly="true" class="input-medium input-date"/>
                    </div>
                </td>
            </tr>
            <tr style="height: 38px;">
                <td style="text-align: center">用户性别</td>
                <td><form:radiobutton path="gender" value="男"/>男&nbsp;&nbsp;&nbsp;
                    <form:radiobutton path="gender" value="女"/>女</td>
                <td style="text-align: center">类型</td>
                <td><form:radiobutton path="type" value="管理员"/>管理员&nbsp;&nbsp;&nbsp;
                    <form:radiobutton path="type" value="普通用户"/>普通用户</td>
            </tr>
            <tr>
                <td style="text-align: center">联系方式</td>
                <td><form:input path="mobile" maxlength="20" placeholder="请输入联系方式" data-rules="mobile"/></td>
                <td style="text-align: center">电子邮箱</td>
                <td><form:input path="mail" maxlength="32" placeholder="请输入邮箱" data-rules="email"/></td>
            </tr>
            <tr style="height: 43px">
                <td style="text-align: center">居住地址</td>
                <td colspan="3"><form:input path="address" maxlength="96" placeholder="请输入居住地址" class="input-xxlarge"/></td>
            </tr>
        </table>
        <div style="width: 100px;margin: 30px auto">
            <button type="submit" class="sui-btn btn-primary">保存信息</button>
        </div>
    </form:form>
</body>
</html>