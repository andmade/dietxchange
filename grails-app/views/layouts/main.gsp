<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="dietxChange"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,400i,700,700i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Raleway:500,500i,700,700i,900" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">

    <asset:stylesheet src="application.css"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bootstrap.material-design/4.0.2/bootstrap-material-design.min.css">

    <g:layoutHead/>
</head>
<body>
    <nav id="site-nav" class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">dietXchange</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">HOME</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <sec:ifLoggedIn>
                        <li><a href="/diary">MY LOGS</a></li>
                        <li><a id="logout-button" ><g:form controller="logout" type="POST"><input class="btn btn-link" type="submit" value="LOGOUT"/></g:form></a></li>                                          </sec:ifLoggedIn>
                    <sec:ifNotLoggedIn>
                        <li>
                            <g:link controller="login" action="index">LOGIN</g:link>
                        </li>
                    </sec:ifNotLoggedIn>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>
