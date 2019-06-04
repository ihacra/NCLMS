<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>在线寄件</title>
    <script type="text/javascript">
        $(document).ready(function() {
            var userId = "${sessionScope.userid}";
            if (userId === "") {
                $.confirm({
                    body: '在线寄件需进行用户登录，是否前往登录？',
                    backdrop: true,
                    bgcolor: 'none',
                    okHide: function(){
                        $(location).attr('href', '${ctx}/login/login');
                    },
                    cancelHide: function(){
                        $(location).attr('href', '${ctx}/index/index');
                    }
                });
            }
            $("#submitBtn").click(function() {
                $.confirm({
                    body: '是否提交快递订单信息？',
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
<form:form id="inputForm" modelAttribute="express" action="${ctx}/express/pay" method="post" cssClass="sui-form form-horizontal sui-validate">
    <form:hidden path="id"/>
    <div class="main-con">
        <br/><br/>
        <div class="control-group">
            <label for="senderName" class="control-label req">发件人姓名：</label>
            <div class="controls">
                <form:input path="senderName" maxlength="32" placeholder="请输入发件人姓名" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="senderMobile" class="control-label req">联系方式：</label>
            <div class="controls">
                <form:input path="senderMobile" maxlength="20" placeholder="请输入联系手机号" data-rules="required|mobile"/>
            </div>
        </div>
        <div class="control-group">
            <label for="senderAddress" class="control-label req">详细地址：</label>
            <div class="controls">
                <form:input path="senderAddress" maxlength="96" placeholder="请输入详细地址" class="input-xlarge" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="consigneeName" class="control-label req">收件人姓名：</label>
            <div class="controls">
                <form:input path="consigneeName" maxlength="32" placeholder="请输入收件人姓名" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="consigneeMobile" class="control-label req">联系方式：</label>
            <div class="controls">
                <form:input path="consigneeMobile" maxlength="20" placeholder="请输入联系手机号" data-rules="required|mobile"/>
            </div>
        </div>
        <div class="control-group">
            <label for="consigneeAddress" class="control-label req">详细地址：</label>
            <div class="controls">
                <form:input path="consigneeAddress" maxlength="96" placeholder="请输入详细地址" class="input-xlarge" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="goodsName" class="control-label req">物品名称：</label>
            <div class="controls">
                <form:input path="goodsName" maxlength="32" placeholder="请输入物品名称" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="goodsWeight" class="control-label req">物品重量：</label>
            <div class="controls">
                <form:input path="goodsWeight" maxlength="2" placeholder="请输入物品重量" data-rules="required|number|lt=20" style="margin-right:-30px"/>
                <span style="color:#999;margin-right:13px">KG</span>
            </div>
        </div>
        <div class="control-group">
            <label for="goodsRemarks" class="control-label">备注信息：</label>
            <div class="controls">
                <form:input path="goodsRemarks" maxlength="96" placeholder="请输入备注信息" class="input-xxlarge"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label"></label>
            <div class="controls">
                <button id="submitBtn" type="button" class="sui-btn btn-primary">提交订单</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="reset" class="sui-btn btn-primary">重置订单</button>
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
