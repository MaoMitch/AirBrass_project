'use strict';

angular.module('airBrassWebAngularApp')
.controller('AccessoireCtrl', function ($scope, $window, $rootScope, serviceAccessoire, serviceProduit, serviceGuitare) {
    $scope.listeAllAccessoire = [];
    $scope.listeAllMarqueAccessoire = [];
    $scope.listeAllSpecsAccessoire = [];
    $scope.cbxMarqueAccessoire = {};
    $scope.listeMarqueAccessoireCochee = [];
    $scope.cbxSpecAccessoire = {};
    $scope.listeSpecAccessoireCochee = [];
    $scope.verbs = [];
    $scope.listeRecherche = [];

    $scope.getlisteAllAccessoires = function () {
        serviceAccessoire.getAllAccessoires().then(function (data) {
            $scope.listeAllAccessoire = data;
            $scope.listeRecherche = $scope.listeAllAccessoire;
        });
        serviceAccessoire.getAllMarqueAccessoire().then(function (data) {
            $scope.listeAllMarqueAccessoire = data;
        });
        serviceAccessoire.getAllSpecAccessoire().then(function (data) {
            $scope.listeAllSpecsAccessoire = data;
        });

        $scope.cbxSpecAccessoireAll = false;
        $scope.cbxMarqueAccessoireAll = false;
    };
    

    $scope.changeAllCbxMarqueAccessoire = function () {
        if ($scope.cbxMarqueAccessoireAll) {
            $scope.cbxMarqueAccessoireAll = true;
        } else {
            $scope.cbxMarqueAccessoireAll = false;
        }
        angular.forEach($scope.listeAllMarqueAccessoire, function (m) {
            $scope.cbxMarque[m.intitule] = $scope.cbxMarqueAccessoireAll;
        });
        $scope.updateCochesAccessoire();
    };

    $scope.changeAllCbxSpecAccessoire = function () {
        if ($scope.cbxSpecAccessoireAll) {
            $scope.cbxSpecAccessoireAll = true;
        } else {
            $scope.cbxSpecAccessoireAll = false;
        }
        angular.forEach($scope.listeAllSpecsAccessoire, function (m) {
            $scope.cbxSpec[m.intitule] = $scope.cbxSpecAccessoireAll;
        });
        $scope.updateCochesAccessoire();
    };

    $scope.getAccessoiresByOption = function () {
        serviceProduit.getProduitByOption($scope.listeSpecAccessoireCochee, $scope.listeMarqueAccessoireCochee).then(function (data) {
            $scope.listeAllAccessoire = data;
        }).catch(function () {

        });
    };
    
    $scope.updateCochesAccessoire = function () {
        $scope.updateCbxMarqueAccessoire();
        $scope.updateCbxSpecAccessoire();
        $scope.getAccessoiresByOption();
    };

    $scope.updateCbxMarqueAccessoire = function () {
        $scope.listeMarqueAccessoireCochee = [];
        angular.forEach($scope.cbxMarqueAccessoire, function (value, id) {
            if (value) {
                $scope.listeMarqueAccessoireCochee.push(id);
            }
        });
    };

    $scope.updateCbxSpecAccessoire = function () {
        $scope.listeSpecAccessoireCochee = [];
        angular.forEach($scope.cbxSpecAccessoire, function (value, id) {
            if (value) {
                $scope.listeSpecAccessoireCochee.push(id);
            }
        });
    };

    $scope.openSingle = function myfunction(produit) {
        localStorage.setItem('item', produit);
        $window.location.href = '/#!/article';
    };
    $scope.alerteRouge = function(s) {
        serviceGuitare.getProduitBySpec(s.intitule).then(function(data) {
            $scope.listeAllAccessoire = data;
            $scope.listeAllMarqueAccessoire = [];
            $scope.listeRecherche = $scope.listeAllAccessoire;
            for(var x =0; x <$scope.listeRecherche.length;x++) {
                var y = $scope.listeRecherche[x];
                $scope.listeAllMarqueAccessoire.push(y.dtoMarque);
            }
            $scope.verbs.splice(0, $scope.verbs.length)
            angular.forEach($scope.listeAllMarqueAccessoire, function (m) {
                $scope.cbxMarqueAccessoire[m.intitule] = false;
            });
            $scope.cbxMarqueAccessoire = false;
            $scope.verbs = [];
        })
    };

    $scope.updateListArticle = function (m) {
        var listeAccessoireFiltre = [];
        for (var i = 0; i < $scope.verbs.length; i++) {
            var marque = $scope.verbs[i];
            
            for(var x=0; x<$scope.listeAllAccessoire.length;x++) {
                var accesoire = $scope.listeAllAccessoire[x];
                if(accesoire.dtoMarque.intitule === marque) {
                    listeAccessoireFiltre.push(accesoire);
                }
            }
        }
        $scope.listeRecherche = listeAccessoireFiltre;
    };
    $scope.updateListPrix = function(prixBas,prixHaut) {
        var listeGuitareFiltre = [];
        for(var x=0; x<$scope.listeAllAccessoire.length; x++) {
            if(prixBas<$scope.listeAllAccessoire[x].prix && $scope.listeAllAccessoire[x].prix<prixHaut){
                listeGuitareFiltre.push($scope.listeAllAccessoire[x]);
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

});
