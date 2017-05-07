<h3>Bread</h3>
<ul>
<g:each in="${foodResults.findAll {it.subcategory == "bread"}}" var="food">
<li>${food.name}</li>
</g:each>
</ul>