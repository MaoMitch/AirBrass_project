/**
 * @ngdoc function
 * @name airBrassWebAngularApp.controller:CompteClientCtrl
 * @description
 * # CompteClientCtrl
 * Controller of the airBrassWebAngularApp
 */

var app = angular.module('airBrassWebAngularApp');
  app.controller('CompteClientInfoCtrl', ['$scope', function ($scope, serviceProduit) {

    $scope.avisClient = {};
    $scope.user = {
                nom:"",
                prenom:"",
                adresse:"",
                cp:"",
                ville:"",
                tel:""
            };

    $scope.onInit = function() {
        var utilisateur = JSON.parse(localStorage.getItem('user'));
        $scope.user.adresseMail = utilisateur.adresseMail;
        $scope.user.nom = utilisateur.nom;
        $scope.user.prenom = utilisateur.prenom;
        $scope.user.adresse = utilisateur.dtoAdresses[0].numero + " " +utilisateur.dtoAdresses[0].rue;
        $scope.user.cp = utilisateur.dtoAdresses[0].dtoVille.codePostal;
        $scope.user.ville = utilisateur.dtoAdresses[0].dtoVille.nom;
        $scope.user.tel = utilisateur.telephone;
    }

    $scope.saveModif = function() {        
        var utilisateur = JSON.parse(localStorage.getItem('user')); 
    }

  }]);

