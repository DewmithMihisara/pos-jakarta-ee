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
                let optionValue = `${customer.id},${customer.name}`;
                $('#cus-id-slt-bx').append(`<option value=${optionValue}>${customer.id}</option>`);
            }
        }
    });
}
function setCusCmbAction(){
    $('#cus-id-slt-bx').on('change', function() {
        let selectedValue = $(this).val();
        let optionValues = selectedValue.split(',');
        let name = optionValues[1];
        $('#cus-name-or-txt').val(name);
    });
}
function setDate(){
    let today = new Date().toISOString().slice(0, 10);
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

$('#place-or-btn').click(function () {
    let orderId = $('#oid-txt').val();
    let date = $('#date-txt').val();

    let cusBx = $('#cus-id-slt-bx').val();
    let optionValues = cusBx.split(',');
    let customerId = optionValues[0];

    let orderDetails = [];
    $('#order-tbl tr').each(function () {
        let code = $(this).find('td:eq(0)').text();
        let qty = $(this).find('td:eq(2)').text();
        let unitPrice = $(this).find('td:eq(3)').text();
        let orderDetail = {
            orderId: orderId,
            itemCode: code,
            qty: qty,
            unitPrice: unitPrice
        }
        orderDetails.push(orderDetail);
    });
    let order = {
        id: orderId,
        date: date,
        customerId: customerId,
        orderDetaisList: orderDetails
    }
    console.log(order.orderDetaisList);
    console.log(order.date);
    console.log(order.customerId);
    console.log(order.id);

    let jsonObj = JSON.stringify(order);
    $.ajax({
        url: "http://localhost:8080/thogakade_jakarta/order",
        method: "POST",
        data: jsonObj,
        contentType: "application/json",
        success: function (resp, textStatus, jqxhr) {
            console.log("success: ", resp);
            console.log("success: ", textStatus);
            console.log("success: ", jqxhr);
            if (jqxhr.status == 201)
                alert(jqxhr.responseText);
        },
        error: function (jqxhr, textStatus, error) {
            console.log("error: ", jqxhr);
            console.log("error: ", textStatus);
            console.log("error: ", error);
        }
    });
});