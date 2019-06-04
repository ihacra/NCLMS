<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>用户查看</title>
</head>
<body>
<form:form id="inputForm" modelAttribute="userAdmin" action="${ctx}/admin/user/view" method="post" cssClass="sui-form form-horizontal">
    <form:hidden path="id"/>
    <div class="main-con">
        <br/>
        <div class="control-group">
            <div class="controls">姓名：${userAdmin.name}</div>
        </div>
        <div class="control-group">
            <div class="controls">昵称：${userAdmin.nick}</div>
        </div>
        <div class="control-group">
            <div class="controls">密码：${userAdmin.password}</div>
        </div>
        <div class="control-group">
            <div class="controls">性别：${userAdmin.gender}</div>
        </div>
        <div class="control-group">
            <div class="controls">用户类型：${userAdmin.type}</div>
        </div>
        <div class="control-group">
            <div class="controls">出生日期：<fmt:formatDate value="${userAdmin.birth}" pattern="yyyy-MM-dd"/></div>
        </div>
        <div class="control-group">
            <div class="controls">联系方式：${userAdmin.mobile}</div>
        </div>
        <div class="control-group">
            <div class="controls">电子邮箱：${userAdmin.mail}</div>
        </div>
        <div class="control-group">
            <div class="controls">居住地址：${userAdmin.address}</div>
        </div>
    </div>
    <div class="express-code">
        <strong class="express-title" style="background: url(https://www.zto.com/imgs/express/code_icon.png) left center no-repeat;">单号订阅</strong>
        <div class="code-cont">
            <p>想要实时追踪此运单状态？扫码订阅，仅需一步!</p>
            <img src="${ctx}/image/sys/code.png" alt>
            <p>打开微信或支付宝扫描上方二维码即可订阅成功</p>
        </div>
    </div>
</form:form>
</body>
</html>
