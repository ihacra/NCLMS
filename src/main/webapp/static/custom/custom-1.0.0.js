$(document).ready(function () {
    mainFill();
});

$(window).resize(function(){
    mainFill();
});

// 页面内容高度填充（不足一屏填充为一屏）
function mainFill() {
    var offset = $(window).height() - $(document.body).outerHeight(true) - 85;
    if (offset > 0) {
        var height = $("#main_fill").height() + offset;
        $("#main_fill").css("height", height + "px");
    }
}
