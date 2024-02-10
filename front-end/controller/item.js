$(document).ready(function () {
    getAllItm();
    setActionItm();
});

function getAllItm() {
    setItmIds();
    setItmCmbAction();

    $('#itm-tbl-bdy').empty();
    $.ajax({
        url: "http://localhost:8080/thogakade_jakarta/item",
        method: "GET",
        success: function (resp) {
            console.log("Success: ", resp);
            for (const item of resp) {
                $('#itm-tbl-bdy').append(`<tr>
                    <td>${item.code}</td>
                    <td>${item.description}</td>
                    <td>${item.qtyOnHand}</td>
                    <td>${item.unitPrice}</td>
                </tr>`);
            }
        }
    });
}

function setActionItm() {
    $('#itm-tbl-bdy').on('click', 'tr', function () {
        let code = $(this).find('td:eq(0)').text();
        let des = $(this).find('td:eq(1)').text();
        let qty = $(this).find('td:eq(2)').text();
        let price = $(this).find('td:eq(3)').text();

        $('#itm-code-txt').val(code);
        $('#itm-des-txt').val(des);
        $('#itm-qty-txt').val(qty);
        $('#itm-prz-txt').val(price);
    });
}
$('#itm-sv-btn').click(function () {
    const code = $('#itm-code-txt').val();
    const des = $('#itm-des-txt').val();
    const qty = $('#itm-qty-txt').val();
    const price = $('#itm-prz-txt').val();

    const itmObj = {
        code: code,
        description: des,
        qtyOnHand: qty,
        unitPrice: price
    }

    const jsonObj = JSON.stringify(itmObj);

    $.ajax({
        url: "http://localhost:8080/thogakade_jakarta/item",
        method: "POST",
        data: jsonObj,
        contentType: "application/json",
        success: function (resp, textStatus, jqxhr) {
            console.log("success: ", resp);
            console.log("success: ", textStatus);
            console.log("success: ", jqxhr);
            if (jqxhr.status == 201)
                alert(jqxhr.responseText);
            getAllItm();
        },
        error: function (jqxhr, textStatus, error) {
            console.log("error: ", jqxhr);
            console.log("error: ", textStatus);
            console.log("error: ", error);
        }
    })
});
$('#itm-up-btn').click(function () {
    const code = $('#itm-code-txt').val();
    const des = $('#itm-des-txt').val();
    const qty = $('#itm-qty-txt').val();
    const price = $('#itm-prz-txt').val();

    const itmObj = {
        code: code,
        description: des,
        qtyOnHand: qty,
        unitPrice: price
    }

    const jsonObj = JSON.stringify(itmObj);

    $.ajax({
        url: "http://localhost:8080/thogakade_jakarta/item",
        method: "PUT",
        data: jsonObj,
        contentType: "application/json",
        success: function (resp, textStatus, jqxhr) {
            console.log("success: ", resp);
            console.log("success: ", textStatus);
            console.log("success: ", jqxhr);
            if (jqxhr.status == 201)
                alert(jqxhr.responseText);
            getAllItm();
        },
        error: function (jqxhr, textStatus, error) {
            console.log("error: ", jqxhr);
            console.log("error: ", textStatus);
            console.log("error: ", error);
        }
    })
});
$('#itm-dl-btn').click(function () {
    const code = $('#itm-code-txt').val();

    $.ajax({
        url: "http://localhost:8080/thogakade_jakarta/item?code=" + code,
        method: "DELETE",
        success: function (resp, textStatus, jqxhr) {
            console.log("success: ", resp);
            console.log("success: ", textStatus);
            console.log("success: ", jqxhr);
            getAllItm();
        },
        error: function (jqxhr, textStatus, error) {
            console.log("error: ", jqxhr);
            console.log("error: ", textStatus);
            console.log("error: ", error);
        }
    })
});