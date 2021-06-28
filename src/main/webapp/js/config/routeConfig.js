angular.module("filmorum").config(function($routeProvider){
    $routeProvider.when("/", {
        templateUrl: "view/homepage.html",
        controller: "homepageCtrl"
    }),
    $routeProvider.when("/new", {
        templateUrl: "view/newFilm.html",
        controller: "newFilmCtrl"
    }),
    $routeProvider.when("/signup", {
        templateUrl: "view/signup.html",
        controller: "userCtrl"
    }),
    $routeProvider.when("/login", {
        templateUrl: "view/login.html",
        controller: "userCtrl"
    })
});