$(document).ready(function (){
    getAllItm();
    setActionItm();
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
function setActionItm(){
    $('#itm-tbl-bdy').on('click', 'tr', function() {
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