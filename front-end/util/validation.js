function validateCustomerId(customerId) {
    console.log("in validation class")
    console.log(customerId);
    var regex = /^C-\d{4}$/;
    var isValid = regex.test(customerId);
    if (isValid) {
        $('#cus-id-txt').removeClass('invalid');
    } else {
        $('#cus-id-txt').addClass('invalid');
    }

    return isValid;
}
function validateTextField(field) {
    let fieldValue = field.val();
    if (!fieldValue || fieldValue.trim() === '') {
        field.addClass('invalid');
        return false;
    } else {
        field.removeClass('invalid');
        return true;
    }
}
function cusClean() {
    $('#cus-id-txt').val('');
    $('#cus-name-txt').val('');
    $('#cus-address-txt').val('');
}
