<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>加盟列表</title>
</head>
<body>
    <h1>加盟列表(${fn:length(franchiseList)})</h1>
    <table class="sui-table table-bordered list">
        <thead>
            <tr>
                <th style="text-align: center;width: 5%">序号</th>
                <th style="text-align: center;width: 9%">加盟人姓名</th>
                <th style="text-align: center;width: 17%">户籍所在地</th>
                <th style="text-align: center;width: 9%">联系方式</th>
                <th style="text-align: center;width: 8%">从业经验</th>
                <th style="text-align: center;width: 9%">投资金额</th>
                <th style="text-align: center;width: 17%">加盟地区</th>
                <th style="text-align: center;width: 7%">客户数量</th>
                <th style="text-align: center;width: 9%">日均发件量</th>
                <th style="text-align: center;width: 10%">审核结果</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${franchiseList}" var="franchise" varStatus="vs">
                <tr>
                    <td style="text-align: center">${vs.count}</td>
                    <td style="text-align: center">${franchise.name}</td>
                    <td style="text-align: center">${franchise.address}</td>
                    <td style="text-align: center">${franchise.mobile}</td>
                    <td style="text-align: center">${franchise.experience}</td>
                    <td style="text-align: center">${franchise.amount}</td>
                    <td style="text-align: center">${franchise.area}</td>
                    <td style="text-align: center">${franchise.customer}</td>
                    <td style="text-align: center">${franchise.quantity}</td>
                    <td style="text-align: center">
                        <c:if test="${empty franchise.status}">正在审核</c:if>
                        <c:if test="${not empty franchise.status}">
                            ${franchise.status}<br>
                            <span style="font-size: 13px;color: #777777">${franchise.remarks}</span>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
