'use strict';

angular.module('myApp').factory('PlayerService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/Skunk/player/';
    var REST_SERVICE_URI_DICE = 'http://localhost:8080/Skunk/dice/';

    var factory = {
        fetchAllPlayers: fetchAllPlayers,
        createPlayer: createPlayer,
        updatePlayer: updatePlayer,
        deletePlayer: deletePlayer,
        deleteAllPlayers: deleteAllPlayers,
        rollDice: rollDice
    };

    return factory;

    function fetchAllPlayers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Players');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createPlayer(player) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, player)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Player');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updatePlayer(player, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, player)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Player');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deletePlayer(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Player');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteAllPlayers(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting all Players');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function rollDice(){
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI_DICE)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while rolling Dice');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
