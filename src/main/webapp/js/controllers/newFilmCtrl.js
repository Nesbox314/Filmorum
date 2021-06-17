angular.module("filmorum").controller("newFilmCtrl", function($scope, $http) {
    $scope.film = {};

    $scope.newFilm = function(film){
        $http.post("http://localhost:8080/filmorum/api/film", film);
    };
});