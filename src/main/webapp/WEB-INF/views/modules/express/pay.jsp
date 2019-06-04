<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>支付订单</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#submitBtn").click(function () {
                $.confirm({
                    body: '是否确认支付订单？',
                    backdrop: true,
                    bgcolor: 'none',
                    okHide: function(){
                        $("#inputForm").submit();
                    },
                    cancelHide: function(){

                    }
                });
            });
            $("#cancelBtn").click(function () {
                $("#inputForm").attr("action", "${ctx}/express/view").submit();
            });
        })
    </script>
</head>
<body>
<form:form id="inputForm" modelAttribute="express" action="${ctx}/express/save" method="post" cssClass="sui-form form-horizontal sui-validate">
    <form:hidden path="id"/>
    <form:hidden path="orderTime"/>
    <form:hidden path="senderName"/>
    <form:hidden path="senderMobile"/>
    <form:hidden path="senderAddress"/>
    <form:hidden path="consigneeName"/>
    <form:hidden path="consigneeMobile"/>
    <form:hidden path="consigneeAddress"/>
    <form:hidden path="goodsName"/>
    <form:hidden path="goodsWeight"/>
    <form:hidden path="price"/>
    <form:hidden path="goodsRemarks"/>
    <br/>
    <div class="control-group">
        <div class="controls">
            支付金额：
            <c:if test="${express.price > 0}"><span style="color: rgba(224,23,18,0.86);font-size: 18px">${express.price}</span>元</c:if>
        </div>
    </div>
    <div class="main-con">
        <div class="control-group">
            <div class="controls">寄件时间：<fmt:formatDate value="${express.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
        </div>
        <div class="control-group">
            <div class="controls">发件人姓名：${express.senderName}</div>
        </div>
        <div class="control-group">
            <div class="controls">联系方式：${express.senderMobile}</div>
        </div>
        <div class="control-group">
            <div class="controls">详细地址：${express.senderAddress}</div>
        </div>
        <div class="control-group">
            <div class="controls">收件人姓名：${express.consigneeName}</div>
        </div>
        <div class="control-group">
            <div class="controls">联系方式：${express.consigneeMobile}</div>
        </div>
        <div class="control-group">
            <div class="controls">详细地址：${express.consigneeAddress}</div>
        </div>
        <div class="control-group">
            <div class="controls">物品名称：${express.goodsName}</div>
        </div>
        <div class="control-group">
            <div class="controls">
                物品重量：
                <c:if test="${express.goodsWeight > 0}">${express.goodsWeight}KG</c:if>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">备注信息：${express.goodsRemarks}</div>
        </div>
        <div class="control-group">
            <label class="control-label"></label>
            <div class="controls">
                <button id="submitBtn" type="button" class="sui-btn btn-primary">支付订单</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button id="cancelBtn" type="button" class="sui-btn btn-primary">取消订单</button>
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
