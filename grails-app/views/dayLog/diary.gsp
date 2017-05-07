<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'dayLog.label', default: 'DayLog')}" />
    <title>Logs | dietXchange</title>
</head>
<body>
<div class="container">
    <h1 id="diary-date"><g:formatDate format='EEEE, MMMM dd, yyyy' date='${date}'/></h1>
</div>

<div class="container  text-center" id="diaryRemainingValuesContainer">
    <h2>Exchanges Remaining</h2>
    <div class="row">
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle starch-color">
                <span class="diary-remaining-value">${daylog?.starchRemainder ?: dieter.starchCount}</span> <br/>
                <span class="diary-remainder-category-name">Starch</span>
            </p>
        </div>
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab btn-default btn-raised category-circle fruit-color">
                <span class="diary-remaining-value">${daylog?.fruitRemainder ?: dieter.fruitCount}</span> <br/>
                <span class="diary-remainder-category-name">Fruit</span>
            </p>
        </div>
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle milk-color">
                <span class="diary-remaining-value">${daylog?.milkRemainder ?: dieter.milkCount}</span> <br/>
                <span class="diary-remainder-category-name">Milk</span>
            </p>
        </div>
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle veggie-color">
                <span class="diary-remaining-value">${daylog?.veggieRemainder ?: dieter.veggieCount}</span> <br/>
                <span class="diary-remainder-category-name">Veggie</span>
            </p>
        </div>
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle protein-color">
                <span class="diary-remaining-value">${daylog?.proteinRemainder ?: dieter.proteinCount}</span> <br/>
                <span class="diary-remainder-category-name">Protein</span>
            </p>
        </div>
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle fats-color">
                <span class="diary-remaining-value">${daylog?.fatRemainder ?: dieter.fatCount}</span> <br/>
                <span class="diary-remainder-category-name">Fats</span>
            </p>
        </div>

    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel">
                <div class="meal-panel-heading panel-heading">
                    <h3 class="panel-title">Breakfast</h3>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <g:each in="${this.daylog?.breakfast}" var="food">

                        </g:each>
                        <a class="add-food-link" href="#" data-toggle="modal" data-target="#addBreakfastFoodModal">
                            <i class="material-icons">add_circle</i> Add food</a>
                    </li>
                    %{--<g:each in="${this.playersPoints}" var="player">--}%
                    %{--<tr>--}%
                    %{--<td><g:link controller="person" action="show" id="${player.id}">--}%
                    %{--<stats:fullname person="${player}"/></g:link></td>--}%
                    %{--<td><stats:average value="${player.gamestats.points}" size="${player.gamestats.size()}"/></td>--}%
                    %{--</tr>--}%
                    %{--</g:each>--}%
            </div>
        </ul>
        </div>
    </div>
</div>

<div class="modal fade" id="addBreakfastFoodModal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4>Choose a Food</h4>
            </div>
            <div class="modal-body">
                <g:form name="mealSubmitForm" method="POST" controller="Meal" action="addFoodToMeal">
                    <input type="hidden" name="date" value="${formatDate(format:'yyyy-MM-dd',date:date)}">
                    <input type="hidden" name="dieterID" value="${dieter.id}">
                    <input type="hidden" name="daylogID" value="${daylog?.id}">
                    <input type="hidden" name="mealtype" value="breakfast">
                    <div id="modalCategoryButtonsContainer" class="text-center">
                        <button data-category-type="starch" class="btn btn-raised category-button starch-color">Starches</button>
                        <button data-category-type="fruit" class="btn btn-raised category-button fruit-color">Fruits</button>
                        <button data-category-type="milk" id="milkButton" class="btn btn-raised category-button milk-color">Milk</button>
                        <button data-category-type="veggie" id="veggieButton" class="btn btn-raised category-button veggie-color">Veggies</button>
                        <button data-category-type="protein" id="proteinButton" class="btn btn-raised category-button protein-color">Proteins</button>
                        <button data-category-type="fats" id="fatsButton" class="btn btn-raised category-button fats-color">Fats</button>
                    </div>
                    <div id="categoryResultsContainer">
                        %{--Search results go here--}%
                    </div>
                    <div class="modal-footer">
                    <button type="button" class="btn btn-primary cancel-button" data-dismiss="modal">Cancel</button>

                    </div>
                </g:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>