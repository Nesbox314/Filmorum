angular.module("filmorum").controller("detailsCtrl", function($scope, $http, $routeParams) {
    $scope.film = {};
    $scope.reviews = {};
    $scope.numberOfReviews = 0;
    $scope.avgOfReviews = 0;
    $scope.filmId = $routeParams.id;
    $scope.logged = false;

    let token = sessionStorage.getItem("token");
    if(token){
        $scope.logged = true;
    }

    $http.get("http://localhost:8080/filmorum/api/film/" + $scope.filmId).then(function (response){
        $scope.film = response.data;
    });

    $http.get("http://localhost:8080/filmorum/api/analysis/film/" + $scope.filmId).then(function (response){
        $scope.reviews = response.data;
    });

    function avg(review){
        $scope.avgOfReviews = $scope.avgOfReviews + review.avaliation;
    }

});