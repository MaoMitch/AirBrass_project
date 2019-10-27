'use strict';

angular.module('airBrassWebAngularApp')
        .controller('NouveauCompteCtrl', function ($scope, $window, serviceUtilisateur) {
            $scope.prenom = 'Max';
            $scope.nom = 'Michel';
            $scope.dateNaissance = '17/04/1991';
            $scope.numero = '60';
            $scope.rue = 'Sadi Carnot';
            $scope.complement = '';
            $scope.email = 'mao-mitch@hotmail.fr';
            $scope.mdp = 'Azerty12';
            $scope.mdpConfirm = 'Azerty12';
            $scope.telephone = '0649388804';
            $scope.codePostal = '93300';
            $scope.ville = 'Aubervilliers';
            $scope.newUser = function () {
                var newUser = {'prenom': $scope.prenom,
                    'nom': $scope.nom,
                    'dateNaissance': $scope.dateNaissance,
                    'numRue': $scope.numero,
                    'rue': $scope.rue,
                    'complement': $scope.complement,
                    'email': $scope.email,
                    'mdp': $scope.mdp,
                    'mdpConfirm': $scope.mdpConfirm,
                    'telephone': $scope.telephone,
                    'cp': $scope.codePostal,
                    'ville': $scope.ville};
                serviceUtilisateur.newUser(newUser).then(function (user) {
                    if (user !== null) {
                        localStorage.setItem('user', user);
                        localStorage.setItem('IsConnected', 'true');
                        $scope.switchBtn2();
                        if (localStorage.getItem('panierEnCours') === 'true') {
                            $window.location.href = '#/paiement';
                        } else {
                            $window.location.href = '#/compe';
                        }
                    }
                }).catch(function () {

                });
            };
            $scope.switchBtn2 = function () {
                var x = document.getElementById('btnConnect');
                var y = document.getElementById('btnCompte');
                var isConnected = localStorage.getItem('IsConnected');

                if (isConnected === 'true') {
                    x.style.display = 'none';
                    y.style.display = 'inline';
                    var user = JSON.parse(localStorage.getItem('user'));
                    y.innerHTML = 'bonjour ' + user.prenom;

                } else {
                    x.style.display = 'initial';
                    y.style.display = 'none';
                }
            };
        });
