angular.module("filmorum").controller("homepageCtrl", function($scope, $http) {
    $scope.films = {};

    $http.get("http://localhost:8080/filmorum/api/film").then(function (response){
        $scope.films = response.data;
    });
});