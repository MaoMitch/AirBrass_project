'use strict';

/**
 * @ngdoc service
 * @name airBrassWebAngularApp.serviceformation
 * @description
 * # serviceFormation
 * Factory in the airBrassWebAngularApp.
 */
angular.module('airBrassWebAngularApp')
.factory('serviceFormation', function ($http) {
    // Service logic
    // ...

    // Public API here
    return {
    	getAllFormateurs: function () {
        return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/businessFormation/listeAllFormateurs'})
                .then(function (response) {
                    return response.data;
                })
                .catch(function () {
                    return "ErrorListeAllFormateurs";
                });
      },
      
      	getAllFormations : function () {
            return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/businessFormation/listeAllFormations'})
            .then(function (response) {
                return response.data;
            })
            .catch(function () {
                return "ErrorListeAllFormations";
            });
      },
      	
      	getFormations: function (intitule, selectedFormateur, selectedNiveau) {

            console.log("getFormation : "+ intitule+"/"+selectedFormateur+"/"+selectedNiveau);
            
      		if((intitule == null || intitule == "") 
      				&& (selectedFormateur == null  || selectedFormateur == "") 
      				&& (selectedNiveau == null || selectedNiveau == "")) {
      			 console.log("getFormation = getAll");
                
      			return $http({method: 'GET', url: 'http://192.168.102.9:8080/AirBrass_ServiceRest/businessFormation/listeAllFormations'})
                .then(function (response) {
                    return response.data;
                })
                .catch(function () {
                    return "Aucune selection : getAllFormations";
                });
      		}
      		
            var path = 'http://192.168.102.9:8080/AirBrass_ServiceRest/businessFormation/listeFormations/';
            
            if (intitule !== null && intitule !== "") {
                path += intitule;
            } else {
            	path += "-";
            }
            path+= '/';
            if (selectedFormateur !== null && selectedFormateur !== "") {
                path += selectedFormateur.nom;
            } else {
            	path += "-";
            }
            path+= '/';
            if (selectedNiveau !== null && selectedNiveau !== "") {
                path += selectedNiveau;
            } else {
            	path += "TOUTNIVEAU";
            }
            console.log("path:  "+path);
            return $http({method: 'GET', url: path})
                    .then(function (response) {
                    	console.log("get");
                    	console.log(response.data);
                        return response.data;
                    })
                    .catch(function (response) {
                        console.log("erreur Formations" + response);
                        return [];
                    });
        },

        reserver : function(id) {
            return $http.post('http://192.168.102.9:8080/AirBrass_ServiceRest/businessFormation/reserver', {id:id})
            .then(function (response) {
                                return response.data;
                            });
        }

    }
});