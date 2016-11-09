/**
 * Created by root on 08.11.2016.
 */


function filterMeals() {
    var filterForm = $('#filterMeals');
    $.ajax({
        url: 'ajax/profile/meals/filter',
        type: 'POST',
        data: filterForm.serialize(),
        success: function (data) {
            updateTableByData(data);
        }
    });
}