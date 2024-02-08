$(document).ready(function () {
    getCusIds();
    setCusCmbAction()
    setDate();
    setItmIds();
    setItmCmbAction();
});

let totalAll = 0;
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
                let optionValue = `${item.code},${item.description},${item.qtyOnHand},${item.unitPrice}`;
                $('#itm-id-slt-bx').append(`<option value=${optionValue}>${item.code}</option>`);
            }
        }
    });
}
function setItmCmbAction(){
    $('#itm-id-slt-bx').on('change', function() {
        let selectedValue = $(this).val();
        let optionValues = selectedValue.split(',');
        let description = optionValues[1];
        let qtyOnHand = optionValues[2];
        let unitPrice = optionValues[3];

        $('#itm-des-or-txt').val(description);
        $('#qoh-or-txt').val(qtyOnHand);
        $('#prz-or-txt').val(unitPrice);
    });
}
$('#add-btn').click(function () {
    let selectedValue = $('#itm-id-slt-bx').val();
    let selectedValues = selectedValue.split(',');
    let code = selectedValues[0];
    let description = selectedValues[1];
    let qty = $('#qty-or-txt').val();
    let unitPrice = $('#prz-or-txt').val();
    let total = qty * unitPrice;

    totalAll += total;

    $('#fl-or-ttl-txt').text(totalAll);

    $('#order-tbl').append(`<tr>
        <td>${code}</td>
        <td>${description}</td>
        <td>${qty}</td>
        <td>${unitPrice}</td>
        <td>${total}</td>
    </tr>`);
});
