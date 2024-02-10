$(document).ready(function (){
    getAll();
    setAction();
    validateCustomerInputs();
    cusBtnDis();
});
function cusBtnDis(){
    $('#cus-up-btn').prop('disabled', true);
    $('#cus-dl-btn').prop('disabled', true);
    $('#cus-sv-btn').prop('disabled', false);
}
function cusBtnEn(){
    $('#cus-up-btn').prop('disabled', false);
    $('#cus-dl-btn').prop('disabled', false);
    $('#cus-sv-btn').prop('disabled', true);
}
function validateCustomerInputs(){
    $('#cus-id-txt').on('keyup', function() {
        console.log("fire key event");
        var customerId = $(this).val();
        validateCustomerId(customerId);
    });
}
function getAll() {
    getCusIds();
    setCusCmbAction();

    $('#cus-tbl-body').empty();

    $.ajax({
        url: "http://localhost:8080/thogakade_jakarta/customers",
        method: "GET",
        success: function (resp) {
            console.log("Success: ", resp);
            for (const customer of resp) {
                $('#cus-tbl-body').append(`<tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.address}</td>
                </tr>`);
            }
        }
    });
}
function setAction(){
    $('#cus-tbl-body').on('click', 'tr', function() {
        let id = $(this).find('td:eq(0)').text();
        let name = $(this).find('td:eq(1)').text();
        let address = $(this).find('td:eq(2)').text();

        cusBtnEn();

        $('#cus-id-txt').val(id);
        $('#cus-name-txt').val(name);
        $('#cus-address-txt').val(address);
    });
}
$('#cus-sv-btn').click(function () {
    const cusID = $('#cus-id-txt').val();
    const cusName = $('#cus-name-txt').val();
    const cusAddress = $('#cus-address-txt').val();

    if (validateCustomerId(cusID)&validateTextField($('#cus-name-txt'))&validateTextField($('#cus-address-txt'))) {
        const cusObj = {
            id: cusID,
            name: cusName,
            address: cusAddress
        }

        const jsonObj=JSON.stringify(cusObj);

        $.ajax({
            url: "http://localhost:8080/thogakade_jakarta/customers",
            method: "POST",
            data: jsonObj,
            contentType: "application/json",
            success: function (resp, textStatus, jqxhr) {
                console.log("success: ", resp);
                console.log("success: ", textStatus);
                console.log("success: ", jqxhr);
                if (jqxhr.status == 201)
                    alert(jqxhr.responseText);
                getAll();
                cusClean();
            },
            error: function (jqxhr, textStatus, error) {
                console.log("error: ", jqxhr);
                console.log("error: ", textStatus);
                console.log("error: ", error);
            }
        })
    }
});
$('#cus-up-btn').click(function () {
    const cusID = $('#cus-id-txt').val();
    const cusName = $('#cus-name-txt').val();
    const cusAddress = $('#cus-address-txt').val();

    const cusObj = {
        id: cusID,
        name: cusName,
        address: cusAddress
    }

    const jsonObj=JSON.stringify(cusObj);

    $.ajax({
        url: "http://localhost:8080/thogakade_jakarta/customers",
        method: "PUT",
        data: jsonObj,
        contentType: "application/json",
        success: function (resp, textStatus, jqxhr) {
            console.log("success: ", resp);
            console.log("success: ", textStatus);
            console.log("success: ", jqxhr);
            if (jqxhr.status == 201)
                alert(jqxhr.responseText);
            getAll();
            cusBtnDis();
            cusClean();
        },
        error: function (jqxhr, textStatus, error) {
            console.log("error: ", jqxhr);
            console.log("error: ", textStatus);
            console.log("error: ", error);
        }
    })
});
$('#cus-dl-btn').click(function () {
    const cusID = $('#cus-id-txt').val();

    $.ajax({
        url: "http://localhost:8080/thogakade_jakarta/customers?id=" + cusID,
        method: "DELETE",
        success: function (resp, textStatus, jqxhr) {
            console.log("success: ", resp);
            console.log("success: ", textStatus);
            console.log("success: ", jqxhr);
            getAll();
            cusBtnDis();
            cusClean();
        },
        error: function (jqxhr, textStatus, error) {
            console.log("error: ", jqxhr);
            console.log("error: ", textStatus);
            console.log("error: ", error);
        }
    })
});