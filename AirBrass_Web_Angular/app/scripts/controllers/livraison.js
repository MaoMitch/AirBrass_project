'use strict';

angular.module('airBrassWebAngularApp')
.controller('LivraisonCtrl', function ($scope, $window, serviceTransfert) {
   $scope.init = function() {
      $scope.user = JSON.parse(localStorage.getItem('user'));
      $scope.adresse = $scope.user.dtoAdresses;
      var panierLocal = JSON.parse(localStorage.getItem('panier'));
      var somme = 0;
      for (var i = 0; i < panierLocal.length; i++) {
        var panier = panierLocal[i];
        somme += panier.prix * panier.quantite;
        }
        $scope.total=somme;
    };
    $scope.livraison = function() {
        $scope.prixLivraison = 5;
    };
    $scope.livraisonNull=function() {
        $scope.prixLivraison = 0;
    };
    $scope.livraisonNul=function() {
        $scope.prixLivraison = 5;
    };

    $scope.prixLivraison = 0;
    $scope.confirmer = function () {

        var panier = JSON.parse(localStorage.getItem('panier'));
        var isConnected = localStorage.getItem('IsConnected');
        var commande = {panier: panier};
        var radios = document.getElementsByName('livraison');

        for (var i = 0; i < radios.length; i++) {
            if(radios[i].checked) {
                commande.prixLivraison = radios[i].value;
            }

        }
        serviceTransfert.commande = commande;
        if (isConnected === 'true') {
            $window.location.href = '/#!/paiement';
        } else {
            localStorage.setItem('enCoursDeCommande', 'true');
            $window.location.href = '/#!/connection';
        }
    };

});