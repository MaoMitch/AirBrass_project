'use strict';

/**
 * @ngdoc service
 * @name airBrassWebAngularApp.serviceComande
 * @description
 * # serviceComande
 * Factory in the airBrassWebAngularApp.
 */
angular.module('airBrassWebAngularApp')
        .factory('serviceComande', function ($http) {
            // Service logic
            // ...

            // Public API here
            return {
                displayCommand: function (id) {

                    return $http.post('http://192.168.102.9:8080/AirBrass_ServiceRest/commandes/byUserID',
                            {id: id})
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function (response) {
                                return response.data;
                            });
                },
                getPrice: function (id) {
                    return $http.post('http://192.168.102.9:8080/AirBrass_ServiceRest/commandes/byCommandeID', {id: id})
                            .then(function (response) {
                                return response.data;
                            });
                }
            };
        });
