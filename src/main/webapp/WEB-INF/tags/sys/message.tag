<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="content" type="java.lang.String" required="true" description="消息内容"%>
<%@ attribute name="hide" type="java.lang.String" required="false" description="自动隐藏"%>
<%@ attribute name="align" type="java.lang.String" required="false" description="显示位置"%>
<c:if test="${not empty content}">
    <div id="messageBox" style="margin-right: 30px;background-color: #edffe9;padding: 10px;
    color: #4ab933;margin-bottom: 10px;border: 1px solid #dcf9d6;text-align:${align}">${content}</div>
    <c:if test="${hide eq 'true'}">
        <script type="text/javascript">
            setTimeout(function () {
                var messageBox = document.getElementById("messageBox");
                if (messageBox) messageBox.parentNode.removeChild(messageBox);
            }, 3000);
        </script>
    </c:if>
</c:if>

