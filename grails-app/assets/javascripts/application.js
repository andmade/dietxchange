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

    $("button.approve-button").on("click",function (evt) {
        var blogEntry_id = $(this).data('blogentry-id');
        var comment_id = $(this).data('comment-id');
        console.log(blogEntry_id);
        var request = $.ajax({
            url: "/comment/approve/" + comment_id,
            method: 'POST'
        });

        request.done(function(data) {
            console.log(evt.target.parentNode.parentNode);
            var comment = evt.target.parentNode.parentNode;
            $(comment).removeClass("alert alert-warning").addClass("well well-lg");
            $(evt.target.parentNode).remove();
        })
    });

    $("button.reject-button").on("click",function (evt) {
        var blogEntry_id = $(this).data('blogentry-id');
        var comment_id = $(this).data('comment-id');
        console.log(blogEntry_id);
        var request = $.ajax({
            url: "/comment/reject/" + comment_id,
            method: 'POST'
        });

        request.done(function(data) {
            console.log(evt.target.parentNode.parentNode);
            var comment = evt.target.parentNode.parentNode;
            $(comment).removeClass("alert alert-warning").addClass("alert alert-danger rejected-comment ");
            $(evt.target.parentNode).remove();
        })
    });

    $("#addMealButton").on("click", function (evt) {
       var daylog_id = $(this).data('daylog-id');
       var dieter_id = $(this).data('dieter-id');
       var meal_type = $(this).data('meal-type');

    });

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
            console.log(data);
            var resultsContainer = $('#categoryResultsContainer');
            $(resultsContainer).html(data);
        })


    });

});

