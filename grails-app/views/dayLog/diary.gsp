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
        <div class="col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle starch-color">
                <span class="diary-remaining-value">${daylog.starchRemainder}</span> <br/>
                <span class="diary-remainder-category-name">Starch</span>
            </p>
        </div>
        <div class="col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab btn-default btn-raised category-circle fruit-color">
                <span class="diary-remaining-value">${daylog.fruitRemainder}</span> <br/>
                <span class="diary-remainder-category-name">Fruit</span>
            </p>
        </div>
        <div class="col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle milk-color">
                <span class="diary-remaining-value">${daylog.milkRemainder}</span> <br/>
                <span class="diary-remainder-category-name">Milk</span>
            </p>
        </div>
        <div class="col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle veggie-color">
                <span class="diary-remaining-value">${daylog.veggieRemainder}</span> <br/>
                <span class="diary-remainder-category-name">Veggie</span>
            </p>
        </div>
        <div class="col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle protein-color">
                <span class="diary-remaining-value">${daylog.proteinRemainder}</span> <br/>
                <span class="diary-remainder-category-name">Protein</span>
            </p>
        </div>
        <div class="col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle fats-color">
                <span class="diary-remaining-value">${daylog.fatRemainder}</span> <br/>
                <span class="diary-remainder-category-name">Fats</span>
            </p>
        </div>

    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <div class="panel">
                <div class="meal-panel-heading panel-heading">
                    <h3 class="panel-title">Breakfast</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <i class="material-icons">add_circle</i>
                        <a class="add-food-link" href="#" data-toggle="modal" data-target="#addFoodModal">
                        Add food</a>
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