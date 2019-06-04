<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="content" type="java.lang.String" required="true" description="消息内容"%>
<%@ attribute name="autoHide" type="java.lang.String" required="false" description="自动隐藏"%>
<%@ attribute name="fixed" type="java.lang.String" required="false" description="提示框固定位置"%>

<c:if test="${not empty content}">
    <%-- 居中悬浮显示 --%>
    <c:if test="${fixed eq 'false'}">
        <div id="messageBox" style="width: 36%;padding: 11px;color: #4ab933;background-color: #edffe9;
            border: 1px solid #dcf9d6;text-align: center;position: fixed;left: 32%;">${content}</div>
    </c:if>
    <%-- 居左固定显示 --%>
    <c:if test="${fixed ne 'false'}">
        <div id="messageBox" style="padding: 11px;color: #4ab933;margin-bottom: 10px;
            background-color: #edffe9;border: 1px solid #dcf9d6;">${content}</div>
    </c:if>
    <c:if test="${autoHide eq 'true'}">
        <script type="text/javascript">
            setTimeout(function () {
                var messageBox = document.getElementById("messageBox");
                if (messageBox) messageBox.parentNode.removeChild(messageBox);
            }, 3000);
        </script>
    </c:if>
</c:if>

