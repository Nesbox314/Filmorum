angular.module("filmorum").config(function($routeProvider){
    $routeProvider.when("/new", {
        templateUrl: "view/newFilm.html",
        controller: "newFilmCtrl"
    }),
    $routeProvider.when("/signup", {
        templateUrl: "view/signup.html",
        controller: "userCtrl"
    })
});