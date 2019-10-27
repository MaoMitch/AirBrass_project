'use strict';

/**
 * @ngdoc function
 * @name airBrassWebAngularApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the airBrassWebAngularApp
 */
angular.module('airBrassWebAngularApp')
        .controller('MainCtrl', function ($rootScope, $scope, $window,serviceProduit, affCompteService) {
            $scope.images = [0, 1, 2]; //Carrousel
            $scope.promotion=[];
            $rootScope.totalPanier = 0;
            //$rootScope.nbArticles = "Panier vide";            
            $rootScope.monCompte = affCompteService.getMonCompte();
            $rootScope.isConnected = false;
            $scope.message="";

            $rootScope.initDropDownCompte = function () {

                if (isClientConnected()) {
                    var user = JSON.parse(localStorage.getItem('user'));
                    affCompteService.setMonCompte('Bonjour ' + user.prenom);
                    $rootScope.monCompte = affCompteService.getMonCompte();

                } else {
                    affCompteService.setMonCompte('Mon Compte');
                    $rootScope.monCompte = affCompteService.getMonCompte(); 
                }
            };
            
            $rootScope.showAdmin = function (isConnected) {
                var user = JSON.parse(localStorage.getItem('user'));
                if(isClientConnected() && user != null && user.statut === "Administrateur") 
                    return true;
                else 
                    return false;
            };

            $rootScope.showMonCompte= function (isConnected) {
                var user = JSON.parse(localStorage.getItem('user'));
                if(isClientConnected() && user != null && user.statut !== "Administrateur") 
                    return true;
                else 
                    return false;
            };

            $rootScope.showSeConnecter = function (isConnected) {
                if(isClientConnected()) 
                    return false;
                else 
                    return true;
            };

            $rootScope.showSeDeconnecter = function (isConnected) {
                if(isClientConnected()) 
                    return true;
                else 
                    return false;
            };

            var isClientConnected = function (isConnected) {
                var isItConnected = JSON.parse(localStorage.getItem('IsConnected'));
                $rootScope.isConnected = isItConnected;
                return $rootScope.isConnected;
            }

            $rootScope.disconnect = function () {
                localStorage.setItem('IsConnected', 'false');
                localStorage.removeItem('user');
                 affCompteService.setMonCompte('Mon Compte');
                var y = document.getElementById('btnDeco');
                y.style.display = 'none';
                $window.location.href = '/#!/index.html';
            };

            $rootScope.goToAdmin = function() {
                $window.location.href = '/#!/admin';
            }


            $rootScope.goToCompte = function() {
                $window.location.href = '/#!/compte';
            }


            var init = function () {
                serviceProduit.promotion().then(function(data) {
                    $scope.promotion =data;
                     $scope.promotion.forEach( function(promotion) {
                    });
                    $scope.division = 0.7;
                });
                serviceProduit.promotionAccessoire().then(function(data) {
                    $scope.promotionAccessoire =data;
                    $scope.division = 0.7;
                });

                if ("nbArt" in localStorage) {
                    var panierLocal = JSON.parse(localStorage.getItem('panier'));
                        var somme = 0;
                        if(panierLocal!= null){
                            for (var i = 0; i < panierLocal.length; i++) {
                                var panier = panierLocal[i];
                                somme += panier.prix * panier.quantite;
                            }
                            $rootScope.totalPanier = somme;
                        }
                }
            };
            // and fire it after definition
            init();

            $scope.openSingle = function(x) {
             localStorage.setItem('item', x);
             $window.location.href = '/#!/article';
         };
             $scope.saveItem = function myfunction(produit){
            var panier =[];
            var prodPanier = [];
            var leBool =false;
            if("panier" in localStorage){
                panier = JSON.parse(localStorage.getItem('panier'));
                
                
                if(panier.length!=null) {
                    for(var x=0;x<panier.length;x++){
                        var y = panier[x];
                        if(produit.intitule ===y.nom){
                            y.quantite = parseInt(y.quantite)+1;
                            leBool = true;
                        }
                    }

                    
                }
            }
            if(leBool === false) {
                if(produit.dtoPromotion.dtoEnumPromotion === 'DIX') {
                    panier.push({id: produit.id, quantite: 1, nom: produit.intitule, prix: produit.prix*0.9, photo: produit.photo});

                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'VINGT') {
                    panier.push({id: produit.id, quantite: 1, nom: produit.intitule, prix: produit.prix*0.8, photo: produit.photo});

                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'TRENTE') {
                    panier.push({id: produit.id, quantite: 1, nom: produit.intitule, prix: produit.prix*0.7, photo: produit.photo});

                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'QUARANTE') {
                    panier.push({id: produit.id, quantite: 1, nom: produit.intitule, prix: produit.prix*0.6, photo: produit.photo});

                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'CINQUANTE') {
                    panier.push({id: produit.id, quantite: 1, nom: produit.intitule, prix: produit.prix*0.5, photo: produit.photo});

                }
                
            }

            localStorage.setItem('panier', JSON.stringify(panier));
            
        }


        $scope.addOne = function myfunction(produit){
            var nbArticles ;
            if("nbArt" in localStorage){
                nbArticles = localStorage.getItem('nbArt');
                nbArticles++;
                var panier = $rootScope.totalPanier;
                var multiplicateur = 0;
                if(produit.dtoPromotion.dtoEnumPromotion === 'DIX') {
                    multiplicateur = 0.9;
                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'VINGT') {
                   multiplicateur = 0.8;

                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'TRENTE') {
                    multiplicateur = 0.7;

                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'QUARANTE') {
                    multiplicateur = 0.6;

                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'CINQUANTE') {
                   multiplicateur = 0.5;

                }
                var add = produit.prix*multiplicateur;
                var somme= parseFloat(panier) + add;

                $rootScope.totalPanier = somme;
                localStorage.setItem('cost',somme);

                localStorage.setItem('nbArt',nbArticles)

            } else {

                if(produit.dtoPromotion.dtoEnumPromotion === 'DIX') {
                    $rootScope.totalPanier = produit.prix*0.9;
                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'VINGT') {
                   $rootScope.totalPanier = produit.prix*0.8;

                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'TRENTE') {
                    $rootScope.totalPanier = produit.prix*0.7;

                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'QUARANTE') {
                    $rootScope.totalPanier = produit.prix*0.6;

                }
                if(produit.dtoPromotion.dtoEnumPromotion === 'CINQUANTE') {
                   $rootScope.totalPanier = produit.prix*0.5;

                }
                localStorage.setItem('nbArt','1');
                nbArticles =1; 
            }
            $rootScope.nbArticles = nbArticles + "" + (nbArticles <=1? " article" : " articles");
            $scope.saveItem(produit);
            produit.message = "ajouté au panier!";
        }
        })
        .factory('affCompteService', function() {
          var _monCompte = 'Mon Compte';

        return {
            getMonCompte: function () {
                return _monCompte;
            },
            setMonCompte: function(value) {
                _monCompte = value;
            }
        };
});
