angular.module("filmorum").controller("reviewCtrl", function($scope, $http, $window, $routeParams) {
    $scope.review = {};

    let token = localStorage.getItem("token");
    if(token){
        let decryptedToken = atob(token);
        $scope.review.userId = decryptedToken.id;
    }
    $scope.review.movie = $routeParams.id;

    console.log($routeParams.id);

    $scope.newReview = function(review){
        $http.post("http://localhost:8080/filmorum/api/analysis/", review).then(function (response){
            if(response.status == 200){
                $window.location.href = 'index.html';
            }
        });
    }

});