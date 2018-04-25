<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>AngularJS $http Example</title>
        <style>
            .playername.ng-valid {
              background-color: lightgreen;
            }
            .playername.ng-dirty.ng-invalid-required {
              background-color: red;
            }
            .playername.ng-dirty.ng-invalid-minlength {
              background-color: yellow;
            }
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
    </head>
    <body ng-app="myApp" class="ng-cloak">
        <div class="generic-container col-md-11" ng-controller="PlayerController as ctrl">
            <div class="titleBox">
                <img class="imgSkunkFlip" ng-src="static/img/skunk.png" alt="Skunk image" />
                <span class="title">Skunk Game</span>
                <img class="imgSkunk" ng-src="static/img/skunk.png" alt="Skunk image" />
            </div>
            <div ng-hide="ctrl.hasStarted">
                <div class="panel panel-default">
                    <div class="panel-heading"><span class="lead">Player Registration Form </span></div>
                    <div class="formcontainer">
                        <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                            <input type="hidden" ng-model="ctrl.player.id" />
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label class="col-md-2 control-lable" for="file">Name</label>
                                    <div class="col-md-7">
                                        <input type="text" ng-model="ctrl.player.name" name="pname" class="playername form-control input-sm" placeholder="Enter player name" required ng-minlength="3"/>
                                        <div class="has-error" ng-show="myForm.$dirty">
                                            <span ng-show="myForm.pname.$error.required">This is a required field</span>
                                            <span ng-show="myForm.pname.$error.minlength">Minimum length required is 3</span>
                                            <span ng-show="myForm.pname.$invalid">This field is invalid </span>
                                        </div>
                                    </div>

                                    <div class="form-actions floatRight">
                                        <input type="submit"  value="{{!ctrl.player.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading"><span class="lead">Players</span></div>
                    <div class="tablecontainer">
                        <table class="table table-hover playerTable">
                            <thead class="playersHead">
                                <tr>
                                    <th ng-show="false">ID.</th>
                                    <th>Name</th>
                                    <th>Score</th>
                                    <th>Is Standing</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody class="playerBody">
                                <tr ng-repeat="u in ctrl.players">
                                    <td ng-show="false"><span ng-bind="u.id"></span></td>
                                    <td><span ng-bind="u.name"></span></td>
                                    <td><span ng-bind="u.score"></span></td>
                                    <td><span ng-bind="u.stand"></span></td>
                                    <td>
                                        <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success defaultBtnWidth">Edit</button>
                                        <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger defaultBtnWidth">Remove</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="playBtn">
                    <button type="button" ng-click="ctrl.start()" class="btn btn-success playBtnWidth" ng-disabled="ctrl.players.length < 2">Play!</button>
                </div>
            </div>

            <div ng-show="ctrl.hasStarted">
                <div class="col-md-8">
                    <div ng-show="!ctrl.gameEnded" class="dices">
                        <div class="diceImages">
                            <img class="imgDice" ng-src="{{ctrl.diceImg1}}" alt="{{ctrl.diceImg1}}" />
                            <img class="imgDice" ng-src="{{ctrl.diceImg2}}" alt="{{ctrl.diceImg2}}" />
                        </div>

                        <button type="button" ng-click="ctrl.roll()" class="btn btn-primary">Roll Dices</button>
                    </div>
                    <div ng-show="ctrl.gameEnded" class="winner">
                        <p>{{ctrl.player.name}} win!!!</p>
                        <p>Score: {{ctrl.player.score}}</p>
                        <button type="button" ng-click="ctrl.restart()" class="btn btn-success">Restart</button>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading"><span class="lead">Players</span></div>
                        <table class="table table-hover">
                            <thead class="playersHead">
                                <tr>
                                    <th>Name</th>
                                    <th>Score</th>
                                    <th>Is Standing</th>
                                </tr>
                            </thead>
                            <tbody class="playerBody">
                                <tr ng-repeat="player in ctrl.players">
                                    <td ng-show="false"><span ng-bind="player.id"></span></td>
                                    <td><span ng-bind="player.name"></span></td>
                                    <td><span ng-bind="player.score"></span></td>
                                    <td><span ng-show="false" ng-bind="player.stand"></span>
                                        <button type="button" ng-click="ctrl.sit(player.id)" class="btn btn-info defaultBtnWidth"
                                        ng-disabled="!player.stand || ctrl.gameEnded || ctrl.results.length == 0">
                                            {{player.stand && !ctrl.gameEnded ? 'Stand' : 'Seated'}}
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="panel panel-default">
                        <div class="panel-heading"><span class="lead">{{ctrl.actualRound}}</span></div>
                        <table class="table table-hover">
                            <thead class="diceHead">
                                <tr>
                                    <th>Dice Results</th>
                                </tr>
                            </thead>
                            <tbody id="diceResultsBody" class="diceBody">
                                <tr ng-repeat="diceResult in ctrl.results | orderBy:'$index':true">
                                    <td><span ng-bind="diceResult.result"></span></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="col-md-12 endGameBtn">
                    <button type="button" ng-click="ctrl.endGame()" class="btn btn-danger" ng-disabled="ctrl.gameEnded">End Game</button>
                </div>
            </div>
        </div>

        <script src="<c:url value='/static/js/app.js' />"></script>
        <script src="<c:url value='/static/js/service/player_service.js' />"></script>
        <script src="<c:url value='/static/js/controller/player_controller.js' />"></script>
    </body>
</html>
