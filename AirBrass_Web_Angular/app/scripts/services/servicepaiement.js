'use strict';

/**
 * @ngdoc service
 * @name airBrassWebAngularApp.servicePaiement
 * @description
 * # servicePaiement
 * Factory in the airBrassWebAngularApp.
 */
angular.module('airBrassWebAngularApp')
        .factory('servicePaiement', function ($http) {
            // Service logic
            // ...

            // Public API here
            return {

                confirmerCommande: function (commande) {
                    return $http({
                        method: 'POST',
                        url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/commandes/order',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        data: commande
                    })
                            .then(function (response) {
                                return response;
                            })
                            .catch(function (response) {
                                return response;
                            });
                },
                getCarteByUser: function (id) {
                    return $http({
                        method: 'POST',
                        url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/commandes/getCarteByUser',
                        headers: {
                            'Content-Type': 'text/plain'
                        },
                        data: id
                    })
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function () {

                            });
                },
                enregistrerCarte: function(carte) {
                    return $http({
                        method: 'POST',
                        url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/commandes/ajouterCarte',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        data: carte
                    })
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function () {

                            });
                },
                majCarte: function(carte) {
                    return $http({
                        method: 'POST',
                        url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/commandes/majCarte',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        data: carte
                    })
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function () {

                            });
                },
                desenregistrerCarte: function(carteAvecUser) {
                    return $http({
                        method: 'POST',
                        url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/commandes/suprCarte',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        data: carteAvecUser
                    })
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function () {

                            });
                }
            };
        });
