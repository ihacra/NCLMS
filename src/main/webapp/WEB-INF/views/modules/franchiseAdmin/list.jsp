<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>加盟管理</title>
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
                    body: '加盟管理需进行用户登录，是否前往登录？',
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
                body: '是否确认删除该加盟信息？',
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
<h1 style="margin: 10px 0">加盟管理(${fn:length(franchiseAdminList)})</h1>
<table class="sui-table table-bordered list2">
    <thead>
    <tr>
        <th style="text-align: center;width: 5%">序号</th>
        <th style="text-align: center;width: 8%">加盟人姓名</th>
        <th style="text-align: center;width: 17%">户籍所在地</th>
        <th style="text-align: center;width: 10%">联系方式</th>
        <th style="text-align: center;width: 7%">从业经验</th>
        <th style="text-align: center;width: 8%">投资金额</th>
        <th style="text-align: center;width: 17%">加盟地区</th>
        <th style="text-align: center;width: 7%">客户数量</th>
        <th style="text-align: center;width: 9%">日均发件量</th>
        <th style="text-align: center;width: 12%">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${franchiseAdminList}" var="franchise" varStatus="vs">
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
                <a href="${ctx}/admin/franchise/view?id=${franchise.id}">查看</a>&nbsp;
                <c:if test="${empty franchise.status}">
                    <a href="${ctx}/admin/franchise/audit?id=${franchise.id}">审核</a>
                </c:if>
                <c:if test="${not empty franchise.status}">${franchise.status}</c:if>&nbsp;
                <a style="cursor: pointer" onclick="checkDel('${ctx}/admin/franchise/delete?id=${franchise.id}');">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
