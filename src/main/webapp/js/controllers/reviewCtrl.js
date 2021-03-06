angular.module("filmorum").controller("reviewCtrl", function($scope, $http, $window, $routeParams) {
    $scope.review = {};

    let token = sessionStorage.getItem("token");
    if(token){
        $scope.review.users = JSON.parse(atob(token)).id;
    }
    $scope.review.movie = $routeParams.id;

    $scope.newReview = function(review){
        $http.post("http://localhost:8080/filmorum/api/analysis/", review).then(function (response){
            if(response.status == 200){
                $window.location.href = '/filmorum/#!/details/' + $routeParams.id;
            }
        });
    }

});