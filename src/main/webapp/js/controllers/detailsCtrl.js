angular.module("filmorum").controller("detailsCtrl", function($scope, $http, $routeParams) {
    $scope.film = {};
    $scope.reviews = {};
    $scope.filmId = $routeParams.id;

    $http.get("http://localhost:8080/filmorum/api/film/" + $scope.filmId).then(function (response){
        $scope.film = response.data;
    });

    $http.get("http://localhost:8080/filmorum/api/analysis/film/" + $scope.filmId).then(function (response){
        $scope.reviews = response.data;
    });

});