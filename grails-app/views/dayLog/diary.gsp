<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'dayLog.label', default: 'DayLog')}" />
    <title>Logs | dietXchange</title>
</head>
<body>
<div class="container">
    <h1 id="diary-date">Wednesday, May 3, 2017</h1>
</div>

<div class="container  text-center" id="diaryRemainingValuesContainer">
    <h2>Remaining Values</h2>
    <div class="row">
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value">#</p>
            <p class="diary-remainder-category-name">Starches</p>
        </div>
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value">#</p>
            <p class="diary-remainder-category-name">Fruits</p>
        </div>
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value">#</p>
            <p class="diary-remainder-category-name">Milk</p>
        </div>
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value">#</p>
            <p class="diary-remainder-category-name">Veggies</p>
        </div>
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value">#</p>
            <p class="diary-remainder-category-name">Protein</p>
        </div>
        <div class="col-md-2 diary-remainder-group">
            <p class="diary-remaining-value">#</p>
            <p class="diary-remainder-category-name">Fats</p>
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
                    <li class="list-group-item">Placeholder text</li>
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

</body>
</html>