angular.module("filmorum").controller("detailsCtrl", function($scope, $http, $routeParams) {
    $scope.film = {};

    $http.get("http://localhost:8080/filmorum/api/film/" + $routeParams.id).then(function (response){
        $scope.film = response.data;
    });
});