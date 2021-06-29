angular.module("filmorum").controller("userCtrl", function($scope, $http, $window) {
    $scope.film = {};
    $scope.nicknameHeader = "guest";
    $scope.logged = false;

    let token = localStorage.getItem("token");
    if(token){
        let decryptedToken = atob(token);
        $scope.nicknameHeader = decryptedToken.slice(0, decryptedToken.indexOf("|"));
        $scope.logged = true;
    }

    $scope.newUser = function(user){
        $http.post("http://localhost:8080/filmorum/api/user", user).then(function (response){
            if(response.status == 200){
                $window.location.href = 'index.html';
            }
        });
    };

    $scope.login = function(nickname, password){
       $http.get("http://localhost:8080/filmorum/api/user/login/" + nickname + "/" + password + "/")
           .then(function (response){
               if(response.status == 200){
                   localStorage.setItem("token", btoa(nickname + "|" + password));
                   $window.location.href = 'index.html';
               }
           });
    };

    $scope.logout = function(){
        localStorage.removeItem("token");
        $scope.nicknameHeader = "guest";
        $scope.logged = false;
    }
});