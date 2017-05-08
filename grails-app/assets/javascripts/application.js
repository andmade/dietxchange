// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}

$(document).ready(function() {

    $(".category-button").on("click", function (evt) {
        evt.preventDefault();
        $('.category-button').css("opacity","0.3");
        $(this).css("opacity","1");
       var category = $(this).data('category-type');
       var request = $.ajax({
           url: "/food/getFoods/?category="+category,
           method: 'POST'
       });

        request.done(function(data) {
            var resultsContainer = $('#categoryResultsContainer');
            $(resultsContainer).html(data);
        })
    });

    $(document).on("click",".food-item-panel", function (evt) {
        var parentNode = evt.target.parentNode;
        $('#foodDetails').detach().appendTo(parentNode);
        $('.collapse-food-size').text($(this).attr("data-food-size"));
        $('.collapse-food-unit').text($(this).attr("data-food-unit"));
        $('#addMealButton').attr("value",$(this).attr("data-food-id"));

    });
    $(document).on("click",".food-item-panel", function (evt) {
        var parentNode = evt.target.parentNode;
        var meal_type = $("input[name='mealtype']").val();
        $('#foodDetails').detach().appendTo(parentNode);
        $('.collapse-food-size').text($(this).attr("data-food-size"));
        $('.collapse-food-unit').text($(this).attr("data-food-unit"));
        $('#addMealButton').attr("value",$(this).attr("data-food-id")).attr("data-meal-type",meal_type);
        $('#addMealButton').text("Add to " + meal_type )

    });

    $('#addFoodModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var meal_type = button.data('meal-type');
        $(this).find("input[name='mealtype']").val(meal_type);
    });

    $('#addFoodModal').on('hide.bs.modal', function (event) {
        $("#foodDetails").removeClass('in');
    });
});

