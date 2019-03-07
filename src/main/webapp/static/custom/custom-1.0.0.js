$(document).ready(function () {
    showInfo();
    mainFill();
    dropdownMenu();
});

$(window).resize(function(){
    mainFill();
});

function showInfo() {
    console.log("INFO: custom-1.0.0.js is running");
}

// 页面内容高度填充（不足一屏填充为一屏）
function mainFill() {
    var offset = $(window).height() - $(document.body).outerHeight(true);
    if (offset > 0) {
        var height = $("#main_fill").height() + offset;
        $("#main_fill").css("height", height + "px");
    }
}

// 鼠标悬浮在菜单上时显示下拉菜单
function dropdownMenu() {
    $("span.link").hover(function () {
        $(this).children("div.cont").css("display", "block");
    }, function () {
        $(this).children("div.cont").css("display", "none");
    });
}
