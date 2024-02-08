$(document).ready(function () {
    getCusIds();
    setCusCmbAction()
    setDate();
});
function getCusIds() {
    $('#cus-id-slt-bx').empty();
    $.ajax({
        url: "http://localhost:8080/thogakade_jakarta/customers",
        method: "GET",
        success: function (resp) {
            console.log("Success: ", resp);
            for (const customer of resp) {
                $('#cus-id-slt-bx').append(`<option value=${customer.name}>${customer.id}</option>`);
            }
        }
    });
}
function setCusCmbAction(){
    $('#cus-id-slt-bx').on('change', function() {
        let selectedValue = $(this).val();
        $('#cus-name-or-txt').val(selectedValue);
    });
}
function setDate(){
    let date = new Date();
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let day = date.getDate();
    let today = year + '-' + month + '-' + day;
    $('#date-txt').val(today);
}