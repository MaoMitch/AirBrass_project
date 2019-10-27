/**
 * @ngdoc function
 * @name airBrassWebAngularApp.controller:CompteClientAvisCtrl
 * @description
 * # CompteClientAvisCtrl
 * Controller of the airBrassWebAngularApp
 */

angular.module('airBrassWebAngularApp')
  .controller('CompteClientAvisCtrl', ['$scope', function ($scope, serviceProduit) {

    $scope.avisClient = {};

    $scope.onInit = function() {
        var user = JSON.parse(localStorage.getItem('user'));
        $scope.avisClient = user.dtoAvisClients;
    }

  }]);

