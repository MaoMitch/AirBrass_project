/**
 * @ngdoc function
 * @name airBrassWebAngularApp.controller:CompteClientCtrl
 * @description
 * # CompteClientCtrl
 * Controller of the airBrassWebAngularApp
 */

var app = angular.module('airBrassWebAngularApp');
  app.controller('CompteClientCtrl', ['$scope', function ($scope, serviceProduit) {

    $scope.avisClient = {};
    $scope.user = {
                adresseMail:"", 
                password:"",
                newAdresseMail:"",
                newPassword:"",
                newPassword2:""
            };

    $scope.onInit = function() {
        var utilisateur = JSON.parse(localStorage.getItem('user'));
        $scope.user.adresseMail = utilisateur.adresseMail;
    }

    $scope.saveModif = function() {        
        var utilisateur = JSON.parse(localStorage.getItem('user'));    
        $scope.user = {
                    adresseMail:"", 
                    password:"",
                    newAdresseMail:"",
                    newPassword:"",
                    newPassword2:""
        };
        $scope.user.adresseMail = utilisateur.adresseMail;
    }

  }]);

  app.directive("matcher", function($timeout) {
        return {
            restrict : "A",

            require : "ngModel",

            link : function(scope, element, attributes, ngModel) {
                ngModel.$validators.matcher = function(modelValue) {
                    return attributes.matcher === modelValue;
                };
            }
        };
  });

