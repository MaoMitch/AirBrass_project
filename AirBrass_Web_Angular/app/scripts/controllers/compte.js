/**
 * @ngdoc function
 * @name airBrassWebAngularApp.controller:CompteCtrl
 * @description
 * # CompteCtrl
 * Controller of the airBrassWebAngularApp
 */

angular.module('airBrassWebAngularApp')
  .controller('CompteCtrl', ['$scope', function ($scope) {

    $scope.onInit = function () {
      var user = JSON.parse(localStorage.getItem('user'));
      if(user.statut === "Administrateur") {
        $window.location.href = '/#!/error404';
      }
    }

  $scope.contenus =
    [
     { id : 0, name: 'Commandes', url: 'views/compte/historiquecommande.html'},
     { id : 1, name: 'Avis client', url: 'views/compte/compteclientavis.html'},
     { id : 2, name: 'Compte client', url: 'views/compte/compteclient.html'},
     { id : 3, name: 'Infos du compte', url: 'views/compte/infoscompte.html'}
     ];
  $scope.contenu = $scope.contenus[0];


  $scope.openContent = function (c) {
    $scope.contenu = $scope.contenus[c.id];
  }


  }]);

