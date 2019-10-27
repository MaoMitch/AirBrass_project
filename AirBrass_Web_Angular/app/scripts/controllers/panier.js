'use strict';

angular.module('airBrassWebAngularApp')
        .controller('PanierCtrl', function ($scope, $window, serviceTransfert,$rootScope) {

            $scope.addOne = function (produit) {
                var nbArticles;
                if ("nbArt" in localStorage) {
                    nbArticles = parseInt(localStorage.getItem('nbArt'));
                    nbArticles += parseInt($scope.nbProduit);
                    //var panier = document.getElementById('recapPanier').innerHTML;
                    var panier = $rootScope.totalPanier;
                    produit = $scope.article;
                    var somme = parseInt(panier) + produit.prix * $scope.nbProduit;
                    $rootScope.totalPanier = somme;
                    localStorage.setItem('cost', somme);
                    localStorage.setItem('nbArt', nbArticles);
                } else {
                    localStorage.setItem('nbArt', $scope.nbProduit);
                    nbArticles = $scope.nbProduit;
                    var newSomme = produit.prix * $scope.nbProduit;
                    $rootScope.totalPanier = newSomme;
                    localStorage.setItem('cost', newSomme);
                }
                $rootScope.nbArticles = nbArticles + "" + (nbArticles <= 1 ? " article" : " articles");
                $scope.saveItem(produit, $scope.nbProduit);
            };

            $scope.saveItem = function (produit, qte) {
                var panier = [];
                if ("panier" in localStorage) {
                    panier = JSON.parse(localStorage.getItem('panier'));
                }
                var leBool =false;
                 for(var x=0;x<panier.length;x++){
                    var y = panier[x];
                    if(produit.intitule ===y.nom){
                        y.quantite = parseInt(y.quantite)+parseInt(qte);
                        leBool = true;
                    }
                    
                }

                if(leBool === false) {
                    panier.push({id: produit.id, quantite: qte, nom: produit.intitule, prix: produit.prix, photo: produit.photo});
                    
                }
                
                localStorage.setItem('panier', JSON.stringify(panier));
            };

            $scope.flush = function () {

                localStorage.removeItem('nbArt');
                localStorage.removeItem('panier');
                localStorage.removeItem('enCoursDeCommande');
                localStorage.setItem('cost', 0);
                $scope.prixLivraison = 0;
                $rootScope.totalPanier=0;
                $rootScope.nbArticles= "Panier vide";
                $scope.total = 0;
                $scope.displayPanier();

            };
            $scope.openSingle = function(x) {
             localStorage.setItem('item', x);
             $window.location.href = '/#!/article';
         };

            $scope.displayPanier = function () {
                $scope.panier = JSON.parse(localStorage.getItem('panier'));
                $scope.user = JSON.parse(localStorage.getItem('user'));
                var panierLocal = JSON.parse(localStorage.getItem('panier'));
                if(panierLocal != null) {
                    var somme = 0;
                    for (var i = 0; i < panierLocal.length; i++) {
                        var panier = panierLocal[i];
                        somme += panier.prix * panier.quantite;
                    }
                    $scope.total=somme;
                }

            };

            $scope.confirmer = function () {
                
                var panier = JSON.parse(localStorage.getItem('panier'));
                var isConnected = localStorage.getItem('IsConnected');
                var commande = {panier: panier};
                serviceTransfert.commande = commande;
                if (isConnected === 'true') {
                    $window.location.href = '/#!/livraison';
                } else {
                    localStorage.setItem('enCoursDeCommande', 'true');
                    $window.location.href = '/#!/connection';
                }
            };

            

        });
