'use strict';

/**
 * @ngdoc function
 * @name airBrassWebAngularApp.controller:PaiementCtrl
 * @description
 * # PaiementCtrl
 * Controller of the airBrassWebAngularApp
 */
angular.module('airBrassWebAngularApp')
        .controller('PaiementCtrl', function ($scope, $window, $filter, $rootScope, $moment, servicePaiement, serviceTransfert) {
            $scope.carte = {identite:'MAX',intitule:'Ma Carte Visa', cle:'123'};
            $scope.cartes = [];
            $scope.mois = $filter('date')(new Date(), 'MM');
            $scope.enregistrerCarte = true;
            $scope.afficheNumero = '1111222233334444';

            var dateToDayAnnee = parseInt($filter('date')(new Date(), 'yy'));
            $scope.annees = [];
            $scope.annee = dateToDayAnnee;
            for (var i = 0; i < 5; i++) {
                $scope.annees.push(dateToDayAnnee + parseInt(i));
            }
            $scope.listMois = [];
            for (var y = 1; y < 13; y++) {
                var x = 0;
                if (y < 10) {
                    var x = '0' + y;
                } else {
                    var x = y;
                }
                $scope.listMois.push(x);
            }

            $scope.flush = function () {

                localStorage.removeItem('nbArt');
                localStorage.removeItem('panier');
                localStorage.removeItem('enCoursDeCommande');
                localStorage.setItem('cost', 0);
                $rootScope.totalPanier=0;
                $rootScope.nbArticles= "Panier vide";

            };

            $scope.validerPaiement = function () {
                var commande = serviceTransfert.commande;
                var date = new Date();
                commande.dateCommande = $moment(date).format('DDMMYYYY');
                var enregistrerCarte = $scope.enregistrerCarte;
                var user = JSON.parse(localStorage.getItem('user'));
                commande.idPers = user.id;
                var dateToString = $scope.mois + '/' + $scope.annee;
                var dateLimite = $moment(dateToString, 'MM/YY', true).format();
                $scope.carte.dateExpiration = dateLimite;
                var numeroCarteEntre = $scope.afficheNumero;
                if (numeroCarteEntre !== ('#### #### #### ' + $filter('limitTo')($scope.carte.numero, 16, 12))) {
                    $scope.carte.numero = $scope.afficheNumero;
                }
                commande.cb = $scope.carte;
                if (enregistrerCarte && commande.cb.id === undefined) {
                    var carteAvecUser = {cb: commande.cb, userId: user.id};
                    servicePaiement.enregistrerCarte(carteAvecUser);
                }
                if (enregistrerCarte && commande.cb.id !== undefined) {
                    servicePaiement.majCarte(commande.cb);
                }
                if (!enregistrerCarte && commande.cb.id !== undefined) {
                    servicePaiement.desenregistrerCarte(commande.cb);
                }
                servicePaiement.confirmerCommande(commande).then(function (response) {
                    if (response.status !== 500) {
                        
                        $window.location.href = '/#!/confirmation';
                        $scope.flush();
                    } else {
                        $window.location.href = '/#!/erreurCommande';
                    }
                }).catch(function () {
                    $window.location.href = '/#!/confirmation';
                });
            };
            $scope.getAllCarteByUser = function () {
                var user = JSON.parse(localStorage.getItem('user'));
                servicePaiement.getCarteByUser(user.id).then(function (cartes) {
                    if (cartes !== undefined) {
                        angular.forEach(cartes, function (carte) {
                            $scope.cartes.push(carte);
                        });
                    }
                });
            };
            $scope.getData = function (carteList) {
                $scope.mois = $filter('date')(carteList.dateExpiration, 'MM');
                $scope.annee = parseInt($filter('date')(carteList.dateExpiration, 'yy'));
                $scope.carte = carteList;
                $scope.afficheNumero = '#### #### #### ' + $filter('limitTo')($scope.carte.numero, 16, 12);
                $scope.carte.cle = undefined;
            };
            $scope.renewCarte = function () {
                $scope.mois = $filter('date')(new Date(), 'MM');
                $scope.annee = parseInt($filter('date')(new Date(), 'yy'));
                $scope.afficheNumero = undefined;
                $scope.carte = {};
            };
        });
