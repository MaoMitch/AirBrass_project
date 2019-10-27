'use strict';

/**
 * @ngdoc service
 * @name airBrassWebAngularApp.serviceAccessoire
 * @description
 * # serviceAccessoire
 * Factory in the airBrassWebAngularApp.
 */
angular.module('airBrassWebAngularApp')
  .factory('serviceAccessoire', function ($http) {
    // Service logic
    // ...

    // Public API here
    return {
      getAllAccessoires: function () {
        return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/listeAllAccessoires'})
                .then(function (response) {
                    return response.data;
                })
                .catch(function () {
                    return "ErrorListeAllAccessoire";
                });
      },
      getAllSpecAccessoire:function() {
         return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/listeAllSpecsAccessoire'})
                 .then(function (response) {
                    return response.data;
                })
                .catch(function (response) {
                    console.log("ErrorAllSpecs" + response);
                });
      },
      getAllMarqueAccessoire: function() {
           return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/listeAllMarquesAccessoire'})
                .then(function (response) {
                    return response.data;
                })
                .catch(function (response) {
                    console.log("ErrorAllMarques" + response);
                });
      }
    };
  });
