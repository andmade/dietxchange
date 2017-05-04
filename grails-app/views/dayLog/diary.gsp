<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'dayLog.label', default: 'DayLog')}" />
    <title>Logs | dietXchange</title>
</head>
<body>
<div class="container">
    <h1 id="diary-date">${daylog.date}</h1>
</div>

<div class="container  text-center" id="diaryRemainingValuesContainer">
    <h2>Exchanges Remaining</h2>
    <div class="row">
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value starch-color">${daylog.starchRemainder}</p>
            <p class="diary-remainder-category-name starch-color">Starches</p>
        </div>
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value fruit-color">${daylog.fruitRemainder}</p>
            <p class="diary-remainder-category-name fruit-color">Fruits</p>
        </div>
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value milk-color">${daylog.milkRemainder}</p>
            <p class="diary-remainder-category-name milk-color">Milk</p>
        </div>
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value veggie-color">${daylog.veggieRemainder}</p>
            <p class="diary-remainder-category-name veggie-color">Veggies</p>
        </div>
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value protein-color">${daylog.proteinRemainder}</p>
            <p class="diary-remainder-category-name protein-color">Protein</p>
        </div>
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value fats-color">${daylog.fatRemainder}</p>
            <p class="diary-remainder-category-name fats-color">Fats</p>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="panel panel-default meal-panel card">
                <div class="meal-panel-heading panel-heading">
                    <h3 class="panel-title">Breakfast</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <p class="add-food-link">
                            <a href="#" data-toggle="modal" data-target="#addFoodModal">
                            Add food</a>
                        </p>
                    </li>
                    %{--<g:each in="${this.playersPoints}" var="player">--}%
                    %{--<tr>--}%
                    %{--<td><g:link controller="person" action="show" id="${player.id}">--}%
                    %{--<stats:fullname person="${player}"/></g:link></td>--}%
                    %{--<td><stats:average value="${player.gamestats.points}" size="${player.gamestats.size()}"/></td>--}%
                    %{--</tr>--}%
                    %{--</g:each>--}%
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addFoodModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4>Add new food</h4>
            </div>
            <div class="modal-body">
                <g:form controller="Meal" action="save" params="[daylog:daylog.id]">
                    <div>
                        <label for="blogentrytitle">Entry title</label>
                        <input type="text" class="form-control" id="blogentrytitle" name="title"></text>
                    </div>
                    <div class="form-group">
                        <label for="blogentrytext">Entry text</label>
                        <textarea class="form-control" id="blogentrytext" rows="3" name="text"></textarea>
                    </div>
                    <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                    <button id="blogSaveButton" type="submit" class="btn btn-primary" value="false" name="published">Save</button>
                    <button id="blogSavePublishButton" type="submit" class="btn btn-primary" value="true" name="published">Save &amp; Publish</button>
                    </div>
                </g:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>