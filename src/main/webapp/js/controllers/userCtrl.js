angular.module("filmorum").controller("userCtrl", function($scope, $http) {
    $scope.film = {};

    $scope.newUser = function(user){
        $http.post("http://localhost:8080/filmorum/api/user", user);
    };

    $scope.login = function(nickname, password){
        $http.get("http://localhost:8080/filmorum/api/user/login/" + nickname + "/" + password + "/");
    };
});