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
        let selectedValue = $(this).val();
        let optionValues = selectedValue.split(',');
        let description = optionValues[0];
        let qtyOnHand = optionValues[1];
        let unitPrice = optionValues[2];

        $('#itm-des-or-txt').val(description);
        $('#qoh-or-txt').val(qtyOnHand);
        $('#prz-or-txt').val(unitPrice);
    });
}
$('#add-btn').click(function () {
    let code = $('#itm-id-slt-bx').val();
    let description = $('#itm-des-or-txt').val();
    let qty = $('#qty-or-txt').val();
    let unitPrice = $('#prz-or-txt').val();
    let total = qty * unitPrice;

    console.log(code);
    console.log(description);
    console.log(qty);
    console.log(unitPrice);
    console.log(total);

    $('#order-tbl').append(`<tr>
        <td>${code}</td>
        <td>${description}</td>
        <td>${qty}</td>
        <td>${unitPrice}</td>
        <td>${total}</td>
    </tr>`);
});