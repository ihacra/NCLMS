<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>寄件列表</title>
</head>
<body>
    <h1>寄件列表(${fn:length(expressList)})</h1>
    <table class="sui-table table-bordered list">
        <thead>
            <tr>
                <th style="text-align: center;width: 6%">序号</th>
                <th style="text-align: center;width: 21%">订单信息</th>
                <th style="text-align: center;width: 23%">寄件人信息</th>
                <th style="text-align: center;width: 23%">收件人信息</th>
                <th style="text-align: center;width: 27%">物品信息</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${expressList}" var="express" varStatus="vs">
                <tr>
                    <td style="text-align: center">${vs.count}</td>
                    <td>
                        <span>${express.price}</span>元
                        <span style="margin-left: 15px">${express.code}</span><br>
                        <span><fmt:formatDate value="${express.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                    </td>
                    <td>
                        <span>${express.senderName}</span>
                        <span style="margin-left: 15px">${express.senderMobile}</span><br>
                        <span>${express.senderAddress}</span>
                    </td>
                    <td>
                        <span>${express.consigneeName}</span>
                        <span style="margin-left: 15px">${express.consigneeMobile}</span><br>
                        <span>${express.consigneeAddress}</span>
                    </td>
                    <td>
                        <span>${express.goodsName}</span>
                        <span style="margin-left: 15px">${express.goodsWeight}</span>KG<br>
                        <span>${express.goodsRemarks}</span>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
