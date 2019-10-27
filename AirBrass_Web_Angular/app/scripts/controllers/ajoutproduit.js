'use strict';

/**
 * @ngdoc function
 * @name airBrassWebAngularApp.controller:AjoutproduitCtrl
 * @description
 * # AjoutproduitCtrl
 * Controller of the airBrassWebAngularApp
 */

angular.module('airBrassWebAngularApp')
  .controller('AjoutproduitCtrl', function ($scope, serviceGuitare) {
    $scope.listeMarque = [];
    $scope.listeSpecialisationProduit =[];
    
    $scope.produit = {intitule:"", 
                    description:"", 
                    prix:0, 
                    photo:"", 
                    reference:"REF", 
                    specialisationProduit:{}, 
                    marque:{}
                };

    //INIT
    $scope.initAjoutProduit  = function() {
        serviceGuitare.getAllMarqueGuitare().then(function (data) {
            $scope.listeMarque = data;
        });

        serviceGuitare.getAllSpecGuitare().then(function (data) {
            $scope.listeSpecialisationProduit = data;
        });
    }

    $scope.saveNouveauProduit = function () {
        var newProduit = $scope.produit;

        $scope.produit = {intitule:"", 
                    description:"", 
                    prix:0, 
                    photo:"", 
                    reference:"", 
                    specialisationProduit:{}, 
                    marque:{}
                };
    }

  });