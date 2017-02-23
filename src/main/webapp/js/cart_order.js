/**
 * Created by Zeit on 30.01.2017.
 */
$(document).ready(function () {
    var $phone = '';
    var $name = '';
    var $address = '';

    $('#submit_order').click(function () {
        $phone = $('#phonePP').val().trim();
        $name = $('#namePP').val().trim();
        $address = $('#addressPP').val().trim();

        var $error = 0;
        var $error_text = "";


        if ($name.length < 2 || $name.length > 45) {
            $error++;
            $error_text += "Имя должно быть от 2 до 45 символов <br>";

        }

        if ($address.length < 5 || $address.length > 70) {
            $error++;
            $error_text += "Адрес должен быть от 5 до 70 символов <br>";
        }

        if (!$phone.match(/^\+?\d{11,12}$/)) {
            $error++;
            $error_text += "Не валидный телефонный номер <br> Введите номер в формате: +375001112233 или 80001112233<br>";

        }

        if ($error > 0) {
            $('#err').text('');
            $('#err').html($error_text);
            return false;
        }

    });
});
