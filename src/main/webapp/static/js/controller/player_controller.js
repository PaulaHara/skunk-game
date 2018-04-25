'use strict';

angular.module('myApp').controller('PlayerController', ['$scope', 'PlayerService', function($scope, PlayerService) {
    var self = this;
    self.player = {id:null, name:'', score:'', stand:true};
    self.players = [];

    self.dices = [];
    self.results = [];
    self.countDice = 0;
    self.diceResult;
    self.scoreInThisRound;

    self.diceRoot = "static/img/";
    self.diceImg1 = "static/img/dice6.png";
    self.diceImg2 = "static/img/dice6.png";

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.start = start;
    self.restart = restart;
    self.round = round;
    self.sit = sit;
    self.roll = roll;
    self.endGame = endGame;

    self.hasStarted = false;
    self.skunkRounds;
    self.countRound;
    self.actualRound;
    self.gameEnded = false;
    self.winner;

    fetchAllPlayers();

    function fetchAllPlayers(){
        PlayerService.fetchAllPlayers()
            .then(
            function(d) {
                self.players = d;
            },
            function(errResponse){
                console.error('Error while fetching Players');
            }
        );
    }

    function createPlayer(player){
        PlayerService.createPlayer(player)
            .then(
            fetchAllPlayers,
            function(errResponse){
                console.error('Error while creating Player');
            }
        );
    }

    function updatePlayer(player, id){
        PlayerService.updatePlayer(player, id)
            .then(
            fetchAllPlayers,
            function(errResponse){
                console.error('Error while updating Player');
            }
        );
    }

    function deletePlayer(id){
        PlayerService.deletePlayer(id)
            .then(
            fetchAllPlayers,
            function(errResponse){
                console.error('Error while deleting Player');
            }
        );
    }

    function deleteAllPlayers(){
        PlayerService.deleteAllPlayers()
            .then(
            fetchAllPlayers,
            function(errResponse){
                console.error('Error while deleting all Players');
            }
        );
    }

    function submit() {
        if(self.player.id===null){
            console.log('Saving New Player', self.player);
            createPlayer(self.player);
        }else{
            updatePlayer(self.player, self.player.id);
            console.log('Player updated with id ', self.player.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.players.length; i++){
            if(self.players[i].id === id) {
                self.player = angular.copy(self.players[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.player.id === id) {//clean form if the player to be deleted is shown there.
            reset();
        }
        deletePlayer(id);
    }


    function reset(){
        self.player = {id:null, name:'', score:0, stand:true};
        $scope.myForm.$setPristine(); //reset Form
    }

    function start(){
        self.hasStarted = true;
        initialize();
        roll();
    }

    function initialize(){
        self.skunkRounds = ['S', 'K', 'U', 'N', 'K'];
        self.countRound = 0;
        round();
        self.results = [];
        self.countDice = 0;
        self.players = [];
        self.dices = [];
    }

    function restart(){
        self.hasStarted = false;
        self.gameEnded = false;
        initialize();
        reset();
        deleteAllPlayers();
    }

    function endGame(){
        var bigScore = 0;
        for(var i = 0; i < self.players.length; i++){
            if(bigScore < self.players[i].score) {
                self.player = angular.copy(self.players[i]);
                bigScore = self.players[i].score;
            }
        }
        self.gameEnded = true;
    }

    function round(){
        self.actualRound = self.skunkRounds[self.countRound];
        self.scoreInThisRound = 0;
        self.results = [];
        standAllPlayers();

        if(self.countRound < 5){
            self.countRound++;
        }else{
            endGame();
        }
    }

    function sit(id){
        var isAllPlayersSat = true;

        for(var i = 0; i < self.players.length; i++){
            if(self.players[i].id === id) {
                self.players[i].stand = false;
                self.player = angular.copy(self.players[i]);

                updatePlayer(self.player, self.player.id);
            }
            if(self.players[i].stand){
                isAllPlayersSat = false;
            }
        }

        if(isAllPlayersSat) {
            round();
        }
    }

    function standAllPlayers(){
        for(var i = 0; i < self.players.length; i++){
            self.players[i].stand = true;
            self.player = angular.copy(self.players[i]);

            updatePlayer(self.player, self.player.id);
        }
    }

    function rollDice(){
        PlayerService.rollDice()
            .then(
            function(d) {
                self.dices = d;
            },
            function(errResponse){
                console.error('Error while rolling dices');
            }
        );
    }

    function generateDiceResultAndDiceImg() {
        var dice = {id:null, result:0};

        if(self.dices.length > 0){
            var itsOne = false;
            self.diceResult = 0;

            for(var i = 0; i < self.dices.length; i++){
                var number;
                var size = self.dices[i].results.length;

                if(size > 0){
                    number = self.dices[i].results[size-1];

                    if(number == 1){
                        if(itsOne){
                            self.diceResult = -1;
                        }else{
                            self.diceResult = 0;
                        }
                        itsOne = true;
                    }else if(!itsOne){
                        self.diceResult += number;
                    }
                }

                if(self.dices[i].id == 1) {
                    self.diceImg1 = self.diceRoot + "dice" + number + '.png';
                }
                if(self.dices[i].id == 2) {
                    self.diceImg2 = self.diceRoot + "dice" + number + '.png';
                }
            }

            if(!itsOne){
                self.scoreInThisRound += self.diceResult;
            }

            if(!itsOne){
                dice.id = self.countDice;
                dice.result = self.diceResult;
                self.results.push(dice);

                self.countDice++;
            }
        }
    }

    function roll() {
        rollDice();
        generateDiceResultAndDiceImg();
        goToTop();

        if(self.diceResult <= 0 && !isAllPlayersStanding()){
            analyzeResults();
            round();
        }else if(self.diceResult > 0){
            analyzeResults();
        }
    }

    function goToTop(){
       var element = document.getElementById("diceResultsBody");
       element.scrollTop = 0;
    }

    function analyzeResults(){
        for(var i = 0; i < self.players.length; i++){
            if(self.players[i].stand) {
                if(self.diceResult == 0){
                    self.players[i].score -= self.scoreInThisRound;
                }else if(self.diceResult == -1){
                    self.players[i].score = 0;
                }else if(self.diceResult > 0){
                    self.players[i].score += self.diceResult;
                }

                updatePlayer(self.players[i], self.players[i].id);
            }
        }
    }

    function isAllPlayersStanding() {
        for(var i = 0; i < self.players.length; i++){
            if(!self.players[i].stand) {
                return false;
            }
        }
        return true;
    }
}]);
