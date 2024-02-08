$(document).ready(function (){
    getAllItm();

});
function getAllItm() {
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
