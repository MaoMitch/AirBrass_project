'use strict';

/**
 * @ngdoc function
 * @name airBrassWebAngularApp.controller:AdminCtrl
 * @description
 * # AdminCtrl
 * Controller of the airBrassWebAngularApp
 */

angular.module('airBrassWebAngularApp')
  .controller('AdminCtrl', ['$scope', function ($scope) {

    $scope.onInit = function () {
      var user = JSON.parse(localStorage.getItem('user'));
      if(user.statut !== "Administrateur") {
        $window.location.href = '/#!/error404';
      }
    }

  $scope.contenus =
    [
     { id : 0, name: 'Dashboard AirBrass', url: 'views/admin/dashboardairbrass.html'},
     { id : 1, name: 'Dashboard Produits', url: 'views/admin/dashboardproduits.html'},
     { id : 2, name: 'Gérer Promotions', url: 'views/admin/gererpromo.html'},
     { id : 3, name: 'Ajouter un produit', url: 'views/admin/ajoutproduit.html'}
     ];
  $scope.contenu = $scope.contenus[0];


  $scope.openContent = function (c) {
    $scope.contenu = $scope.contenus[c.id];
  }


  }]);
