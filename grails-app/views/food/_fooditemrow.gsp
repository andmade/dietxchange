<li class="list-group-item list-food-item">
        <g:form controller="meal" action="removeFoodFromMeal" method="DELETE" params="[mealID:mealID,foodID:food.id,date:date]">
            <p><button type="submit" class="btn bmd-btn-fab-mini"><i class="material-icons">delete</i></button>${food.name}</p>
        </g:form>
</li>