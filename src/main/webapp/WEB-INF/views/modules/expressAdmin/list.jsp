<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>快递管理</title>
    <style type="text/css">
        td span {
            font-size: 14px;
            line-height: 24px;
        }
        td a {
            color: #ea6f5a;
        }
        td a:hover {
            text-decoration: none;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function() {
            var userId = "${sessionScope.userid}";
            if (userId === "") {
                $.confirm({
                    body: '快递管理需进行用户登录，是否前往登录？',
                    backdrop: true,
                    bgcolor: 'none',
                    okHide: function(){
                        $(location).attr('href', '${ctx}/login/login');
                    },
                    cancelHide: function(){
                        $(location).attr('href', '${ctx}/admin/index/index');
                    }
                });
            }
        });
        function checkDel(url) {
            $.confirm({
                body: '是否确认删除该快递信息？',
                backdrop: true,
                bgcolor: 'none',
                okHide: function(){
                    $(location).attr('href', url);
                },
                cancelHide: function(){

                }
            });
        }
    </script>
</head>
<body>
<sys:message content="${message}" autoHide="true" fixed="false"/>
<h1 style="margin: 10px 0">快递列表(${fn:length(expressAdminList)})</h1>
<table class="sui-table table-bordered list2">
    <thead>
    <tr>
        <th style="text-align: center;width: 5%">序号</th>
        <th style="text-align: center;width: 18%">订单信息</th>
        <th style="text-align: center;width: 21%">寄件人信息</th>
        <th style="text-align: center;width: 21%">收件人信息</th>
        <th style="text-align: center;width: 24%">物品信息</th>
        <th style="text-align: center;width: 11%">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${expressAdminList}" var="express" varStatus="vs">
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
            <td style="text-align: center">
                <a href="${ctx}/admin/express/view?id=${express.id}">查看</a>&nbsp;
                <a href="${ctx}/admin/express/edit?id=${express.id}">修改</a>&nbsp;
                <a style="cursor: pointer" onclick="checkDel('${ctx}/admin/express/delete?id=${express.id}');">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
