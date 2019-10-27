'use strict';

/**
 * @ngdoc function
 * @name airBrassWebAngularApp.controller:GuitareCtrl
 * @description
 * # GuitareCtrl
 * Controller of the airBrassWebAngularApp
 */
 angular.module('airBrassWebAngularApp')
 .controller('GuitareCtrl', ['$scope', '$filter', '$window', 'serviceGuitare', 'serviceProduit','$rootScope',function ($scope,$filter, $window, serviceGuitare, serviceProduit,$rootScope) {
    $scope.verbs = [];
    $scope.listeAllGuitare = [];
    $scope.listeRecherche = [];
    $scope.listeAllMarqueGuitare = [];
    $scope.listeAllSpecsGuitare = [];
    $scope.cbxMarqueGuitare = {};
    $scope.listeMarqueGuitareCochee = [];
    $scope.cbxSpecGuitare = {};
    $scope.listeSpecGuitareCochee = [];
    $scope.q = '';
    var spec = "";
    var marq ="";
    $scope.getlisteAllGuitares = function () {
        serviceGuitare.getAllGuitares().then(function (data) {
            $scope.listeAllGuitare = data;
            $scope.listeRecherche = $scope.listeAllGuitare;
        });
        $scope.cbxSpecGuitareAll = false;
        $scope.cbxMarqueGuitareAll = false;
        serviceGuitare.getAllSpecGuitare().then(function (data) {
            $scope.listeAllSpecsGuitare = data;
            angular.forEach($scope.listeAllSpecsGuitare, function (s) {
                $scope.cbxSpecGuitare[s.intitule] = true;
            });
        });
        serviceGuitare.getAllMarqueGuitare().then(function (data) {
            $scope.listeAllMarqueGuitare = data;
            angular.forEach($scope.listeAllMarqueGuitare, function (m) {
                $scope.cbxMarqueGuitare[m.intitule] = true;
            });
        });

    };
    $scope.getData = function () {
        return $filter('filter')($scope.listeRecherche, $scope.q)

    };

    $scope.numberOfPages=function(){
        return Math.ceil($scope.getData().length/$scope.pageSize);                
    };

    $scope.openSingle = function myfunction(produit) {
        localStorage.setItem('item', produit);
        $window.location.href = '/#!/article';
    };
    $scope.alerteRouge = function(s) {
        serviceGuitare.getProduitBySpec(s.intitule).then(function(data) {
            $scope.listeAllGuitare = data;
            $scope.listeAllMarqueGuitare = [];
            $scope.listeRecherche = $scope.listeAllGuitare;
            for(var x =0; x <$scope.listeRecherche.length;x++) {
                var y = $scope.listeRecherche[x];
                $scope.listeAllMarqueGuitare.push(y.dtoMarque);
            }
            $scope.verbs.splice(0, $scope.verbs.length)
            angular.forEach($scope.listeAllMarqueGuitare, function (m) {
                $scope.cbxMarqueGuitare[m.intitule] = false;
            });
            $scope.cbxMarqueGuitareAll = false;
            $scope.verbs = [];
        })

    };
    $scope.updateListArticle = function (m) {
        var listeGuitareFiltre = [];
        for (var i = 0; i < $scope.verbs.length; i++) {
            var marque = $scope.verbs[i];

            for(var x=0; x<$scope.listeAllGuitare.length;x++) {
                var produit = $scope.listeAllGuitare[x];
                if(produit.dtoMarque.intitule === marque) {
                    listeGuitareFiltre.push(produit);
                }
            }
        }
        $scope.listeRecherche = listeGuitareFiltre;
    };

    $scope.updateListPrix = function(prixBas,prixHaut) {
        var listeGuitareFiltre = [];
        for(var x=0; x<$scope.listeAllGuitare.length; x++) {
            if(prixBas<$scope.listeAllGuitare[x].prix && $scope.listeAllGuitare[x].prix<prixHaut){
                listeGuitareFiltre.push($scope.listeAllGuitare[x]);
            }

        }
        $scope.listeRecherche = listeGuitareFiltre;
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
            if(produit.dtoPromotion != null) {
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
            } else {
                panier.push({id: produit.id, quantite: 1, nom: produit.intitule, prix: produit.prix, photo: produit.photo});
            }


        }

        localStorage.setItem('panier', JSON.stringify(panier));

    };
    $scope.addOne = function myfunction(produit){

        var nbArticles ;
        if("nbArt" in localStorage) {
            nbArticles = localStorage.getItem('nbArt');
            nbArticles++;
            var panier = $rootScope.totalPanier;
            var multiplicateur = 1;
            if(produit.dtoPromotion != null) {
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
            }
           var add = produit.prix*multiplicateur;
           var somme= parseFloat(panier) + add;

           $rootScope.totalPanier = somme;
           localStorage.setItem('cost',somme);

           localStorage.setItem('nbArt',nbArticles)

            } else {
                if(produit.dtoPromotion != null) {
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
                } else {
                    $rootScope.totalPanier =produit.prix;
                    }
                localStorage.setItem('nbArt','1');
                nbArticles =1; 
                }
                $rootScope.nbArticles = nbArticles + "" + (nbArticles <=1? " article" : " articles");
                $scope.saveItem(produit);
                produit.message = "ajouté au panier!";
                }

}])
.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});
