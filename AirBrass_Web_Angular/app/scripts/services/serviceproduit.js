'use strict';

angular.module('airBrassWebAngularApp')
        .factory('serviceProduit', function ($http) {
            // Service logic
            // ...

            // Public API here
            return {
                getProduitByOption: function (listeSpecCochee, listeMarqueCochee) {
                    var path = 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/listeProduitParOptions/';
                    if (listeSpecCochee !== null) {
                        path += listeSpecCochee;
                    }
                    if (listeSpecCochee !== null && listeMarqueCochee !== null) {
                        path += '/';
                    }
                    if (listeMarqueCochee !== null) {
                        path += listeMarqueCochee;
                    }

                    return $http({method: 'GET', url: path})
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function (response) {
                                console.log("erreurProduitByOptions" + response);
                                return [];
                            });
                },
                loadArticle: function (id) {
                    var path = 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/produit/' + id;
                    return $http({method: 'GET', url: path})
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function (response) {
                                console.log("error: " + response.data);
                            });
                },
                avisClient: function (id) {
                    var path = 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/avisProduit/' + id;
                    return $http({method: 'GET', url: path})
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function (response) {
                                console.log("error: " + response.data);
                            });
                },
                promotion: function () {
                    var path = 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/produitPromotion';
                    return $http({method: 'GET', url: path})
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function (response) {
                                console.log("error: " + response.data);
                            });
                },
                promotionAccessoire: function () {
                    var path = 'http://192.168.102.9:8080/AirBrass_ServiceRest/produit/accessoirePromotion';
                    return $http({method: 'GET', url: path})
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function (response) {
                                console.log("error: " + response.data);
                            });
                },
                suggestion: function(id) {
                    var path = 'http://192.168.102.9:8088/similarite/' + id;
                    return $http({method: 'GET', url: path})
                            .then(function (response) {
                                return response.data;
                            })
                            .catch(function (response) {
                                console.log("error: " + response.data);
                            });
                }
            };
        });
