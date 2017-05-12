<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'dayLog.label', default: 'DayLog')}" />
    <title>Logs | dietXchange</title>
</head>
<body>
<div class="container">
    <h1 id="diary-date">
        <a href="/diary?date=${formatDate(format:'yyyy-MM-dd',date:date-1)}"><i class="material-icons">keyboard_arrow_left</i></a>
        <g:formatDate format='EEEE, MMMM dd, yyyy' date='${date}'/>
        <a href="/diary?date=${formatDate(format:'yyyy-MM-dd',date:date+1)}"><i class="material-icons">keyboard_arrow_right</i></a>
    </h1>
</div>


<div class="container  text-center" id="diaryRemainingValuesContainer">
    <h2>Exchanges Remaining</h2>
    <div class="row">
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle starch-color">
                <span class="diary-remaining-value">
                    ${(daylog?.starchRemainder != null) ? daylog.starchRemainder : dieter.starchCount}</span> <br/>
                <span class="diary-remainder-category-name">Starch</span>
            </p>
        </div>
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab btn-default btn-raised category-circle fruit-color">
                <span class="diary-remaining-value">
                    ${(daylog?.fruitRemainder != null) ? daylog.fruitRemainder : dieter.fruitCount}</span> <br/>
                <span class="diary-remainder-category-name">Fruit</span>
            </p>
        </div>
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle milk-color">
                <span class="diary-remaining-value">
                    ${(daylog?.milkRemainder != null) ? daylog.milkRemainder : dieter.milkCount}</span> <br/>
                <span class="diary-remainder-category-name">Milk</span>
            </p>
        </div>
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle veggies-color">
                <span class="diary-remaining-value">
                    ${(daylog?.veggieRemainder != null) ? daylog.veggieRemainder : dieter.veggieCount}</span> <br/>
                <span class="diary-remainder-category-name">Veggie</span>
            </p>
        </div>
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle protein-color">
                <span class="diary-remaining-value">${(daylog?.proteinRemainder != null) ? daylog.proteinRemainder : dieter.proteinCount}</span> <br/>
                <span class="diary-remainder-category-name">Protein</span>
            </p>
        </div>
        <div class="col-xs-4 col-md-2 diary-remainder-group ">
            <p class="btn bmd-btn-fab bmd-btn-icon category-circle fats-color">
                <span class="diary-remaining-value">${(daylog?.fatRemainder != null) ? daylog.fatRemainder : dieter.fatCount}</span> <br/>
                <span class="diary-remainder-category-name">Fats</span>
            </p>
        </div>

    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel">
                <div class="meal-panel-heading panel-heading">
                    <h3 class="panel-title">Breakfast</h3>
                </div>
                <ul class="list-group">
                    <g:each in="${this.daylog?.breakfast?.foods}" var="food">
                        <g:render template="/food/fooditemrow" model="[food:food,mealID:this.daylog?.breakfast?.id,date:formatDate(format:'yyyy-MM-dd',date:date)]"/>
                    </g:each>
                    <li class="list-group-item">
                        <a class="add-food-link" href="#" data-toggle="modal" data-target="#addFoodModal"
                           data-meal-type="breakfast">
                            <i class="material-icons">add_circle</i> Add food</a>
                    </li>

                </ul>
            </div>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel">
                <div class="meal-panel-heading panel-heading">
                    <h3 class="panel-title">Lunch</h3>
                </div>
                <ul class="list-group">
                    <g:each in="${this.daylog?.lunch?.foods}" var="food">
                        <g:render template="/food/fooditemrow" model="[food:food,mealID:this.daylog?.lunch?.id,date:formatDate(format:'yyyy-MM-dd',date:date)]"/>
                    </g:each>
                    <li class="list-group-item">
                        <a class="add-food-link" href="#" data-toggle="modal" data-target="#addFoodModal"
                           data-meal-type="lunch">
                            <i class="material-icons">add_circle</i> Add food</a>
                    </li>

                </ul>
            </div>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel">
                <div class="meal-panel-heading panel-heading">
                    <h3 class="panel-title">Dinner</h3>
                </div>
                <ul class="list-group">
                    <g:each in="${this.daylog?.dinner?.foods}" var="food">
                        <g:render template="/food/fooditemrow" model="[food:food,mealID:this.daylog?.dinner?.id,date:formatDate(format:'yyyy-MM-dd',date:date)]"/>
                    </g:each>
                    <li class="list-group-item">
                        <a class="add-food-link" href="#" data-toggle="modal" data-target="#addFoodModal"
                           data-meal-type="dinner">
                            <i class="material-icons">add_circle</i> Add food</a>
                    </li>

                </ul>
            </div>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel">
                <div class="meal-panel-heading panel-heading">
                    <h3 class="panel-title">Snacks</h3>
                </div>
                <ul class="list-group">
                    <g:each in="${this.daylog?.snack?.foods}" var="food">
                        <g:render template="/food/fooditemrow" model="[food:food,mealID:this.daylog?.snack?.id,date:formatDate(format:'yyyy-MM-dd',date:date)]"/>
                    </g:each>
                    <li class="list-group-item">
                        <a class="add-food-link" href="#" data-toggle="modal" data-target="#addFoodModal"
                           data-meal-type="snack">
                            <i class="material-icons">add_circle</i> Add food</a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addFoodModal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h3>Add Food</h3>
            </div>
            <div class="modal-body">
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#databaseFoods"role="tab" data-toggle="tab"><h4>Choose from Database</h4></a></li>
                    <li role="presentation"><a href="#favoriteFoods" role="tab" data-toggle="tab"><h4>Choose From Favorites</h4></a></li>
                </ul>

                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active" id="databaseFoods">
                        <g:form name="mealSubmitForm" method="POST" controller="Meal" action="addFoodToMeal">
                            <input type="hidden" name="date" value="${formatDate(format:'yyyy-MM-dd',date:date)}">
                            <input type="hidden" name="dieterID" value="${dieter.id}">
                            <input type="hidden" name="daylogID" value="${daylog?.id}">
                            <input type="hidden" name="mealtype" value="breakfast">
                            <div id="modalCategoryButtonsContainer container-fluid" class="text-center">
                                <div class="row">
                                    <div class="col-xs-6 col-md-2">
                                        <button data-category-type="starch" class="btn btn-raised btn-block category-button starch-color">Starches</button></div>
                                    <div class="col-xs-6 col-md-2"><button data-category-type="fruit" class="btn btn-raised btn-block category-button fruit-color">Fruits</button></div>
                                    <div class="col-xs-6 col-md-2"><button data-category-type="milk" id="milkButton" class="btn btn-block btn-raised category-button milk-color">Milk</button></div>
                                    <div class="col-xs-6 col-md-2"><button data-category-type="veggies" id="veggieButton" class="btn btn-block btn-raised category-button veggies-color">Veggies</button></div>
                                    <div class="col-xs-6 col-md-2"><button data-category-type="protein" id="proteinButton" class="btn btn-block btn-raised category-button protein-color">Proteins</button></div>
                                    <div class="col-xs-6 col-md-2"><button data-category-type="fats" id="fatsButton" class="btn btn-block btn-raised category-button fats-color">Fats</button></div>
                                </div>
                            </div>
                            <div id="categoryResultsContainer">
                                %{--Search results go here--}%
                            </div>
                        </g:form>
                    </div>

                    <div role="tabpanel" class="tab-pane fade" id="favoriteFoods">
                        <g:form name="favoriteFoodSubmitForm" method="POST" controller="Meal" action="addFoodToMeal">

                            <div id="favoriteResultsContainer">
                                <g:each in="${dieter.favoriteFoods}" var="food">
                                    <g:render template="/food/foodsearchrow" model="[food:food]"/>
                                </g:each>
                            </div>
                        </g:form>
                    </div>
                </div>

            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-primary cancel-button" data-dismiss="modal">Cancel</button>
            </div>

        </div>
    </div>
</div>
</div>

</body>
</html>