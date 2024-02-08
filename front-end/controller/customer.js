$('#cus-sv-btn').click(function () {
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
    })
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
        },
        error: function (jqxhr, textStatus, error) {
            console.log("error: ", jqxhr);
            console.log("error: ", textStatus);
            console.log("error: ", error);
        }
    })
});