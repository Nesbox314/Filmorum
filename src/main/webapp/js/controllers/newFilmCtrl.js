angular.module("filmorum").controller("newFilmCtrl", function($scope, $http, $window) {
    $scope.film = {};

    $scope.newFilm = function(film){
        $http.post("http://localhost:8080/filmorum/api/film", film).then(function (response){
            if(response.status == 200){
                $window.location.href = 'index.html';
            }
        });
    };
});