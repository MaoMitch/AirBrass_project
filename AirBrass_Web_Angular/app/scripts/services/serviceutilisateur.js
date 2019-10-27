'use strict';

angular.module('airBrassWebAngularApp')
        .factory('serviceUtilisateur', function ($http) {
            // Service logic
            // ...

            var utilisateur = null;

            // Public API here
            return {
                connect: function (credentials) {
                    return $http.post('http://192.168.102.9:8080/AirBrass_ServiceRest/clients/connect', credentials)
                            .then(function (response) {
                                if (response.statusCode !== '500') {
                                    utilisateur = JSON.stringify(response.data);
                                }
                                return utilisateur;
                            })
                            .catch(function () {
                                return null;
                            });
                },
                newUser: function (newUser) {
                    return $http.post('http://192.168.102.9:8080/AirBrass_ServiceRest/clients/newUser', newUser)
                            .then(function (response) {
                                if (response.data !== null) {
                                    utilisateur = JSON.stringify(response.data);
                                }
                                return utilisateur;
                            })
                            .catch(function () {
                                return null;
                            });
                }
            };
        });
