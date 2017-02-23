/**
 * Created by Zeit on 17.01.2017.
 */

$(document).ready(function () {

    var $url = location.href.match(/edit/ig);
    if ($url) {
        $('.nav-tabs a[href="#PizzaAdd"]').tab('show');
    }

    $('#add_redo_redoSubmit, #add_redo_addSubmit').click(function () {

        var $errors = 0;
        var $message = '';

        var $url = $('#urlPizza').val().trim();
        var $title = $('#namePizza').val().trim();
        var $desc = $('#titlPizza').val().trim();
        var $price = $('#pricePizza').val().trim();


        if ($url.length < 5) {
            $errors++;
            $message += ' Заполните путь к фотографии! <br>';
        }

        if ($title.length < 3 || $title.length > 40) {
            $errors++;
            $message += 'Название пиццы от3 до 40 символов!<br>';
        }

        if ($desc.length < 5 || $desc.length > 255) {
            $errors++;
            $message += 'Описание пиццы от 5 до 255 символов!<br>';
        }

        if (!($price.match(/\d+/))) {


            $errors++;
            $message += 'Корректно заполните стоимость! <br>';
        }


        if ($errors > 0) {

            $('#add_redo_answer').html($message);
            return false;
        }
    });
});