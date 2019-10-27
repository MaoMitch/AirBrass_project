'use strict';
angular.module('airBrassWebAngularApp')
.controller('ArticleCtrl', ['$scope', '$filter', '$rootScope', 'serviceProduit', function ($scope,$filter,$rootScope,serviceProduit) {
	

	$scope.loadArticle = function() {
		var id = localStorage.getItem('item');
		serviceProduit.loadArticle(id).then(function(article){
			$scope.article = article;
			serviceProduit.avisClient($scope.article.id).then(function(data){
				$scope.avisClient = data;
				var addition =0;
				for(var x in $scope.avisClient){
					var y = $scope.avisClient[x];
					addition += y.note;
				}
				$scope.note= Math.round(addition/$scope.avisClient.length);

				for (var i = 0; i <$scope.note; i++) {
					$scope.taille.push(i);
				}
			});
			serviceProduit.suggestion(id).then(function(data){
				$scope.suggestion = data;
				var sug = [];
				$scope.listeSuggestion = [];
				for(var x =0;x<$scope.suggestion.length;x++) {
					sug = $scope.suggestion[x];
					serviceProduit.loadArticle(sug.idProduit).then(function(article){
						var produit = article;
						$scope.listeSuggestion.push(produit);
					});
				}
				
			});
		});

	};
	$scope.nbArticle = [1,2,3,4,5];
	$scope.note= {};
	$scope.avisClient = [];
	$scope.taille = [];
	$scope.currentPage = 0;
    $scope.pageSize = 5;
    $scope.data = [];
    $scope.q = '';

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
    
    $scope.getData = function () {
      // needed for the pagination calc
      // https://docs.angularjs.org/api/ng/filter/filter
      return $filter('filter')($scope.avisClient, $scope.q)
     /* 
       // manual filter
       // if u used this, remove the filter from html, remove above line and replace data with getData()
       
        var arr = [];
        if($scope.q == '') {
            arr = $scope.data;
        } else {
            for(var ea in $scope.data) {
                if($scope.data[ea].indexOf($scope.q) > -1) {
                    arr.push( $scope.data[ea] );
                }
            }
        }
        return arr;
       */
    }
    
    $scope.numberOfPages=function(){
        return Math.ceil($scope.getData().length/$scope.pageSize);                
    }


	
}])
.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});
