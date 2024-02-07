const dash = document.querySelector("#dashboardForm");
const cus = document.querySelector("#customerForm");
const itm = document.querySelector("#itemForm");
const order = document.querySelector("#orderForm");

document.querySelector('#homeBtn').addEventListener("click", function () {
    dash.style.display = "block";
    cus.style.display = "none";
    itm.style.display = "none";
    order.style.display = "none";
});
document.querySelector('#cusBtn').addEventListener("click", function () {
    cus.style.display = "block";
    dash.style.display = "none";
    itm.style.display = "none";
    order.style.display = "none";
});
document.querySelector('#itmBtn').addEventListener("click", function () {
    itm.style.display = "block";
    dash.style.display = "none";
    cus.style.display = "none";
    order.style.display = "none";
});
document.querySelector('#orderBtn').addEventListener("click", function () {
    order.style.display = "block";
    dash.style.display = "none";
    cus.style.display = "none";
    itm.style.display = "none";
});