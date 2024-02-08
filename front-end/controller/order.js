$(document).ready(function () {
    getCusIds();
    setCusCmbAction()
    setDate();
    setItmIds();
    setItmCmbAction();
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
function setItmIds(){
    $('#itm-id-slt-bx').empty();
    $.ajax({
        url: "http://localhost:8080/thogakade_jakarta/item",
        method: "GET",
        success: function (resp) {
            console.log("Success: ", resp);
            for (const item of resp) {
                let optionValue = `${item.description},${item.qtyOnHand},${item.unitPrice}`;
                $('#itm-id-slt-bx').append(`<option value=${optionValue}>${item.code}</option>`);
            }
        }
    });
}
function setItmCmbAction(){
    $('#itm-id-slt-bx').on('change', function() {
        var selectedValue = $(this).val();
        var optionValues = selectedValue.split(',');
        var description = optionValues[0];
        var qtyOnHand = optionValues[1];
        var unitPrice = optionValues[2];

        console.log("Description: " + description);
        console.log("Quantity on Hand: " + qtyOnHand);
        console.log("Unit Price: " + unitPrice);

        $('#itm-des-or-txt').val(description);
        $('#qoh-or-txt').val(qtyOnHand);
        $('#prz-or-txt').val(unitPrice);

    });
}