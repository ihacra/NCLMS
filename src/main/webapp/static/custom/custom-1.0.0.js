$(document).ready(function () {
    showInfo();
    activityMenu();
});

function showInfo() {
    console.log("INFO: custom-1.0.0.js is running");
}

function activityMenu() {
    var href = window.location.href;
    var menu = ["/index/index", "/express/search", "/express/form",
        "/freight/search", "/franchise/form", "/about/view"];
    for (var m in menu) {
        if (href.indexOf(menu[m]) !== -1) {
            $("#menu_"+m).addClass("activity");
            break;
        }
    }
}
