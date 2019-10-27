'use strict';

angular.module('airBrassWebAngularApp')
    .controller('ConnectionCtrl', function ($scope, $window, serviceUtilisateur, $rootScope) {
        $scope.connect = function () {
            var credentials = {'login':$scope.userLogin,'password':$scope.userPassword};
            serviceUtilisateur.connect(credentials).then(function (user) {
                if (user !== null) {
                    localStorage.setItem('user', user);
                    localStorage.setItem('IsConnected', 'true');
                    $scope.switchBtn2();
                    if (localStorage.getItem('enCoursDeCommande') === 'true') {
                        $window.location.href = '/#!/livraison';
                    } else {                            
                        var user = JSON.parse(localStorage.getItem('user'));

                        if(user.statut === "Administrateur")
                            $window.location.href = '/#!/admin';
                        else                                
                            $window.location.href = '/#!/compte';
                    }
                }
            }).catch(function () {

            });
        };
        $scope.switchBtn2 = function () {
            var isConnected = localStorage.getItem('IsConnected');

            if (isConnected === 'true') {
                var user = JSON.parse(localStorage.getItem('user'));
                $rootScope.monCompte = 'Bonjour ' + user.prenom;

            } else {
                $rootScope.monCompte = "Mon Compte";
            }
        };
       
        
    });
