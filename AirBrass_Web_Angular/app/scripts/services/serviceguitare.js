'use strict';

/**
 * @ngdoc service
 * @name airBrassWebAngularApp.serviceGuitare
 * @description
 * # serviceGuitare
 * Factory in the airBrassWebAngularApp.
 */
angular.module('airBrassWebAngularApp')
  .factory('serviceGuitare', function ($http) {
    // Service logic
    // ...

    // Public API here
    return {
      getAllGuitares: function () {
        return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/listeAllGuitares'})
                .then(function (response) {
                    return response.data;
                })
                .catch(function () {
                    return "ErrorListeAllGuitare";
                });
      },
      getAllSpecGuitare:function() {
         return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/listeAllSpecsGuitare'})
                 .then(function (response) {
                    return response.data;
                })
                .catch(function (response) {
                    console.log("ErrorAllSpecs" + response);
                });
      },
      getAllMarqueGuitare: function() {
           return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/listeAllMarquesGuitare'})
                .then(function (response) {
                    return response.data;
                })
                .catch(function (response) {
                    console.log("ErrorAllMarques" + response);
                });
      },
      getProduitBySpec: function(spec) {
        return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/produitsSpec/' + spec})
        .then(function (response) {
          return response.data;
        })
        .catch(function (response) {
                    console.log("ErrorAllMarques" + response);
                })
      },
      getProduitByMarque: function(marq) {
        return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/produitsMarque/' + marq})
        .then(function(response) {
          return response.data;
        })
        .catch(function (response) {
                    console.log("ErrorAllMarques" + response);
                })
      }
    };
  });
