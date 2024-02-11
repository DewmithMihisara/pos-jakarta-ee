function validateCustomerId(customerId) {
    let regex = /^C-\d{4}$/;
    let isValid = regex.test(customerId);
    if (isValid) {
        $('#cus-id-txt').removeClass('invalid');
    } else {
        $('#cus-id-txt').addClass('invalid');
    }

    return isValid;
}
function cusClean() {
    $('#cus-id-txt').val('');
    $('#cus-name-txt').val('');
    $('#cus-address-txt').val('');
}

// -------------------------------------
function validateItmId(ItemId) {
    let regex = /^I-\d{4}$/;
    let isValid = regex.test(ItemId);
    if (isValid) {
        $('#itm-code-txt').removeClass('invalid');
    } else {
        $('#itm-code-txt').addClass('invalid');
    }

    return isValid;
}

function validateQty(){
    let isTrue= true;
    $('#itm-qty-txt').on('keyup', function(event) {
        let charCode = event.which;
        if (charCode < 48 || charCode > 57) {
            $(this).addClass('invalid');
            isTrue= false;
        } else {
            $(this).removeClass('invalid');
            isTrue= true;
        }
    });
    return isTrue;
}

function valiedPrice(){
    let isTrue= true;
    $('#itm-price-txt').on('keyup', function(event) {
        let charCode = event.which;
        if (charCode < 48 || charCode > 57) {
            $(this).addClass('invalid');
            isTrue= false;
        } else {
            $(this).removeClass('invalid');
            isTrue= true;
        }
    });
    return isTrue;
}

// -------------------------------------
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

