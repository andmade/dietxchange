<g:if test="${foodResults[0]?.category == 'starch'}">
    <h3>Bread</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='bread'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
    <h3>Cereals and Grains</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory == 'cereals_grains'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
    <h3>Starchy Vegetables</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory == 'starchy_veggies'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
    <h3>Crackers and Snacks</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory == 'crackers_snacks'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
</g:if>
<g:if test="${foodResults[0]?.category == 'fruit'}">
    <h3>Fruit</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='fruit'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
    <h3>Juices</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='juices'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
</g:if>
<g:if test="${foodResults[0]?.category == 'milk'}">
    <h3>Milk and Yogurt</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='milk_yogurt'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
</g:if>
<g:if test="${foodResults[0]?.category == 'veggies'}">
    <h3>Vegetables</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='nonstarchy_veggies'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
</g:if>
<g:if test="${foodResults[0]?.category == 'protein'}">
    <h3>Lean Meats</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='lean_meat'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
    <h3>Medium-Fat Meats</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='medium_meat'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
    <h3>High-Fat Meats</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='high_meat'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
</g:if>
<g:if test="${foodResults[0]?.category == 'fats'}">
    <h3>Unsaturated/Monounsaturated Fats</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='unsat_mono'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
    <h3>Polyunsaturated Fats</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='polyunsat'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
    <h3>Saturated Fats</h3>
    <ul class="list-unstyled food-item-list">
        <g:each in="${(foodResults.findAll{it.subcategory =='saturated'})}" var="food">
            <g:render template="/food/foodsearchrow" model="[food:food]"/>
        </g:each>
    </ul>
</g:if>
<div class="collapse" id="foodDetails">
    <div class="well well-sm">
        <p>Serving: <span class="collapse-food-size">#</span> <span class="collapse-food-unit">#</span></p>
        <button id="addMealButton" type="submit" class="btn ok-button" name="foodID" value="null"
                data-daylog-id="${daylog?.id}" data-dieter-id="${dieter?.id}" data-meal-type="breakfast">
            Add To Breakfast
        </button>
    </div>
</div>


