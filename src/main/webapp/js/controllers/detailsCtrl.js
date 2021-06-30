angular.module("filmorum").controller("detailsCtrl", function($scope, $http, $routeParams) {
    $scope.film = {};
    $scope.reviews = {};
    $scope.numberOfReviews = 0;
    $scope.avgOfReviews = 0;
    $scope.filmId = $routeParams.id;

    $http.get("http://localhost:8080/filmorum/api/film/" + $scope.filmId).then(function (response){
        $scope.film = response.data;
    });

    $http.get("http://localhost:8080/filmorum/api/analysis/film/" + $scope.filmId).then(function (response){
        $scope.reviews = response.data;
        $scope.numberOfReviews = response.data.length;
        $scope.reviews.forEach(avg);
    });

    function avg(review){
        $scope.avgOfReviews = $scope.avgOfReviews + review.avaliation;
    }

});