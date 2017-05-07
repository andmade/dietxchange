<h3>Bread</h3>
<ul class="list-unstyled food-item-list">
    <g:each in="${foodResults}" var="food">
        <li class="col-xs-12 col-md-6">
            <button class="food-item-panel starch-color btn-block btn-raised" type="button" data-toggle="collapse"
            data-food-id="${food.id}" data-food-size="${food.portionSize}" data-food-unit="${food.portionUnit}"
            data-target="#foodDetails" aria-expanded="false">
                ${food.name}
            </button>
        </li>
    </g:each>
</ul>
<div class="collapse" id="foodDetails">
    <div class="well well-sm">
        <p>Serving: <span class="collapse-food-size">#</span> <span class="collapse-food-unit">#</span></p>
        <button id="addMealButton" type="submit" class="btn ok-button" name="foodID" value="null"
                data-daylog-id="${daylog?.id}" data-dieter-id="${dieter?.id}" data-meal-type="breakfast">
            Add To Breakfast
        </button>
    </div>
</div>

