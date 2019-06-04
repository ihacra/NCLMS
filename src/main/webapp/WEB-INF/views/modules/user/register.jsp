<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>用户注册</title>
    <%@ include file="/WEB-INF/views/include/head.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".btn-login").click(function () {
                $("#inputForm").submit();
            })
        })
    </script>
</head>
<body>
<div class="h1-title" style="margin-top: 65px">
    <a href="${ctx}/index/index">全国连锁物流管理系统</a>
</div>
<form:form id="inputForm" modelAttribute="user" action="${ctx}/register/save" method="post" cssClass="sui-validate login">
    <label>姓名</label>
    <form:input path="name" data-rules="required" cssStyle="margin-bottom: 20px"/>
    <label>密码</label>
    <form:password path="password" data-rules="required" cssStyle="margin-bottom: 20px"/>
    <label>类型</label>
    <div style="color: #666666;display: inline-block;margin-left: 20px">
        <form:radiobutton path="type" value="管理员" cssStyle="width: min-content"/>管理员&nbsp;&nbsp;&nbsp;
        <form:radiobutton path="type" value="普通用户" cssStyle="width: min-content;margin-left: 10px" checked="true"/>普通用户
    </div>
    <a class="btn-register" style="margin-left: 0" href="${ctx}/login/login">登录</a>
    <a class="btn-login" style="margin-left: 11px">注册</a>
</form:form>
<div class="bottom-info">Copyright © 2019-2019 NCLMS - Powered By Hacra
    <a href="https://github.com/ihacra/nclms">Graduation project</a>
</div>
</body>
</html>