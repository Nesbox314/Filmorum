angular.module("filmorum").config(function($routeProvider){
    $routeProvider.when("/new", {
            templateUrl: "view/newFilm.html",
            controller: "newFilmCtrl"
        })
});