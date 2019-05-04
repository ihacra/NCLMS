<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>运费查询</title>
</head>
<body>
<form:form id="inputForm" modelAttribute="freight" action="${ctx}/freight/search" method="post" cssClass="sui-form form-horizontal sui-validate">
    <div class="main-con">
        <br/><br/>
        <div class="control-group">
            <label for="senderAddress" class="control-label">寄件地址：</label>
            <div class="controls">
                <form:input path="senderAddress" maxlength="32" placeholder="请输入寄件地址" class="input-xxlarge" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="consigneeAddress" class="control-label">收件地址：</label>
            <div class="controls">
                <form:input path="consigneeAddress" maxlength="32" placeholder="请输入收件地址" class="input-xxlarge" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="goodsWeight" class="control-label">物品重量：</label>
            <div class="controls">
                <form:input path="goodsWeight" maxlength="2" placeholder="请输入物品重量" data-rules="required|number|lt=20" style="margin-right:-30px"/>
                <span style="color:#999;margin-right:13px">KG</span>
            </div>
        </div>
        <div class="control-group input-daterange" data-toggle="datepicker">
            <label for="orderTime" class="control-label">寄件时间：</label>
            <div class="controls">
                <form:input path="orderTime" data-rules="required" readonly="true" class="input-medium input-date"/>
            </div>
        </div>
        <c:if test="${freight.price > 0}">
            <div class="control-group input-daterange" data-toggle="datepicker">
                <label class="control-label">预计运费：</label>
                <label class="control-label" style="width: auto; color: #d72708">
                    &nbsp;<fmt:formatNumber value="${freight.price}" pattern="0.00"/>元
                </label>
            </div>
        </c:if>
        <div class="control-group">
            <label class="control-label"></label>
            <div class="controls">
                <button type="submit" class="sui-btn btn-primary">查询</button>
            </div>
        </div>
        <hr/>
        <div class="control-group">
            <div class="controls">
                <p class="sui-text-large"><b>一、 体积重量计算方法</b></p>
                托寄物的计费重量取体积重量与实际重量两者之间的较大值，体积重量的计算方法为：<br/>
                1、同城、省内件以及经济区域内互寄，体积重量=长(CM)×宽(CM)×高(CM)÷12000；<br/>
                2、省外跨经济区域互寄，体积重量=长(CM)×宽(CM)×高(CM)÷6000；<br/>
                <p class="sui-text-large"><b>二. 计费重量小数点进位处理方式</b></p>
                1、20KG以下, 续重以0.5KG为计重单位，不足0.5kg，按0.5kg计；20KG及以上，以1KG为计重单位，小数点后尾数大于零的，向上进位至下一个1KG<br/>
                <p class="sui-text-large"><b>三. 运费计算结果处理方式</b></p>
                1、运费计算结果按四舍五入取整数值；<br/>
                2、不同产品起始重量各有差异，不足起重的快件将按起重计费并显示。<br/>
                以上计费规则可能因服务（产品）或所在地区不同而有所差异，详情与当地收派员进行咨询。
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
