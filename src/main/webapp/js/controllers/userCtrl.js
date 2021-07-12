angular.module("filmorum").controller("userCtrl", function($scope, $http, $window, $cookies) {
    $scope.film = {};
    $scope.nicknameHeader = "guest";
    $scope.logged = false;
    $scope.successCreated = true;

    let token = sessionStorage.getItem("token");
    if(token){
        let decryptedToken = JSON.parse(atob(token));
        $scope.nicknameHeader = decryptedToken.nickname;
        $scope.logged = true;
    }

    $scope.newUser = function(user){
        $http.get("http://localhost:8080/filmorum/api/user/validate/" + user.nickname + "/" + user.email)
            .then(function (response){
                if(response.data.emailExists == true && response.data.nicknameExists == true){
                    $scope.successCreated = false;
                } else {
                    $http.post("http://localhost:8080/filmorum/api/user", user).then(function (response){
                        if(response.status == 200){
                            $window.location.href = 'index.html';
                        }
                    });
                }
        });
    };

    $scope.login = function(nickname, password){
       $http.get("http://localhost:8080/filmorum/api/user/login/" + nickname + "/" + password + "/")
           .then(function (response){
               if(response.status == 200 && response.data != "") {
                   sessionStorage.setItem("token", btoa(JSON.stringify(response.data)));
                   $window.location.href = 'index.html';
               }
           });
    };

    $scope.logout = function(){
        sessionStorage.removeItem("token");
        $scope.nicknameHeader = "guest";
        $scope.logged = false;
    }
});