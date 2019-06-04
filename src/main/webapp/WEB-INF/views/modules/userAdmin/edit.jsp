<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>用户修改</title>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#submitBtn").click(function() {
                $.confirm({
                    body: '是否保存修改信息？',
                    backdrop: true,
                    bgcolor: 'none',
                    okHide: function(){
                        $("#inputForm").submit();
                    },
                    cancelHide: function(){

                    }
                })
            });
        });
    </script>
</head>
<body>
<form:form id="inputForm" modelAttribute="userAdmin" action="${ctx}/admin/user/save" method="post" cssClass="sui-form form-horizontal sui-validate">
    <form:hidden path="id"/>
    <form:hidden path="password"/>
    <form:hidden path="type"/>
    <form:hidden path="remarks"/>
    <div class="main-con">
        <br/>
        <div class="control-group">
            <label for="name" class="control-label">姓名：</label>
            <div class="controls">
                <form:input path="name" maxlength="32" placeholder="请输入姓名" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="nick" class="control-label">昵称：</label>
            <div class="controls">
                <form:input path="nick" maxlength="32" placeholder="请输入昵称" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">性别：</label>
            <div class="controls">
                <form:radiobutton path="gender" value="男"/>男&nbsp;&nbsp;&nbsp;
                <form:radiobutton path="gender" value="女"/>女
            </div>
        </div>
        <div class="control-group">
            <label for="birth" class="control-label">出生日期：</label>
            <div class="controls">
                <div class="input-daterange" data-toggle="datepicker">
                    <form:input path="birth" readonly="true" class="input-medium input-date"/>
                </div>
            </div>
        </div>
        <div class="control-group">
            <label for="mobile" class="control-label">联系方式：</label>
            <div class="controls">
                <form:input path="mobile" maxlength="20" placeholder="请输入联系方式" data-rules="mobile"/>
            </div>
        </div>
        <div class="control-group">
            <label for="mail" class="control-label">电子邮箱：</label>
            <div class="controls">
                <form:input path="mail" maxlength="32" placeholder="请输入邮箱" data-rules="email"/>
            </div>
        </div>
        <div class="control-group">
            <label for="address" class="control-label">居住地址：</label>
            <div class="controls">
                <form:input path="address" maxlength="96" placeholder="请输入居住地址" class="input-xxlarge"/>
            </div>
        </div>
        <div class="control-group" style="margin-left: 55px">
            <div class="controls">
                <button id="submitBtn" type="button" class="sui-btn btn-primary">保存修改</button>
            </div>
        </div>
        <hr/>
        <div class="control-group">
            <div class="controls">
                1、以上时效为预计到达时间，仅供参考，精准时效以运单追踪中的“签收时间”为准<br/>
                2、以上价格仅供参考，具体以寄件地市场价格为准，到付件价格请咨询当地网点<br/>
                3、快件限重20KG，超重快件会影响派送时效
            </div>
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
