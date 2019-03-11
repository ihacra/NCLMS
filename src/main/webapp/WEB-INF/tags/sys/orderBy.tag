<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="id" type="java.lang.String" required="true" %>
<%@ attribute name="value" type="java.lang.String" required="true" %>
<input id="${id}" name="${id}" type="hidden" value="${value}">
<script type="text/javascript">
    $(document).ready(function () {
        var asc = $("<span></span>").css({
            "width": "0", "margin-left": "5px",
            "height": "0", "display": "inline-block",
            "border-width": "0 8px 10px", "border-style": "solid",
            "border-color": "transparent transparent #ea6f5a"
        });
        var desc = $("<sapn></sapn>").css({
            "width": "0", "margin-left": "5px",
            "height": "0", "display": "inline-block",
            "border-width": "10px 8px 0", "border-style": "solid",
            "border-color": "#ea6f5a transparent transparent"
        });
        // 设置排序升降样式
        var orderBy = $("#${id}").val().split(" ");
        $(".sort").each(function () {
            if (orderBy.length > 0 && orderBy[0] === $(this).attr("data-sort")) {
                $(this).css("color", "#ea6f5a");
                if (orderBy.length === 2 && orderBy[1].toLowerCase() === "desc") {
                    $(this).append(desc);
                } else if (orderBy.length === 2 && orderBy[1].toLowerCase() === "asc") {
                    $(this).append(asc);
                }
            }
        });
        // 设置点击排序事件
        $(".sort").click(function () {
            var sort = $("#${id}").val().split(" ");
            var orderBy = $(this).attr("data-sort") + " ";
            if (sort.length === 1 && sort[0] !== "") sort = "asc";
            else if (sort.length === 2) sort = sort[1].toLowerCase();
            else sort = "";
            if (sort === "asc") orderBy = orderBy + "desc";
            else if (sort === "desc") orderBy = " ";
            else orderBy = orderBy + "asc";
            $("#${id}").val(orderBy);
            if (orderBy === " ") window.location.href = window.location.origin + window.location.pathname;
            else window.location.href = window.location.origin + window.location.pathname + "?orderBy=" + orderBy;
        });
    })
</script>
