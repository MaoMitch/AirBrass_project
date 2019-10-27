'use strict';

/**
 * @ngdoc overview
 * @name airBrassWebAngularApp
 * @description
 * # airBrassWebAngularApp
 *
 * Main module of the application.
 */

 angular
 .module('airBrassWebAngularApp', [
    "ui.router", 'ngRoute', 'angular-momentjs', 'ui.bootstrap', 'checklist-model', 
    'ui.config', 'ui.filters', 'ngMaterial','ngMessages'
    ])
 .config(function ($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
    })
    .when('/accessoire', {
        templateUrl: 'views/accessoire.html',
        controller: 'AccessoireCtrl',
        controllerAs: 'accessoire'
    })
    .when('/compte', {
        templateUrl: 'views/compte.html',
        controller: 'CompteCtrl',
        controllerAs: 'compte'
    })
    .when('/historiquecommande', {
        templateUrl: 'views/compte/historiquecommande.html',
        controller: 'HistoriqueCommandeCtrl',
        controllerAs: 'historiquecommande'
    })
    .when('/compteclient', {
        templateUrl: 'views/compte/compteclient.html',
        controller: 'CompteClientCtrl',
        controllerAs: 'compteclient'
    })
    .when('/compteclientinfo', {
        templateUrl: 'views/compte/infoscompte.html',
        controller: 'CompteClientInfoCtrl',
        controllerAs: 'compteclientinfo'
    })
    .when('/compteclientavis', {
        templateUrl: 'views/compte/compteclientavis.html',
        controller: 'CompteClientAvisCtrl',
        controllerAs: 'compteclientavis'
    })
    .when('/panier', {
        templateUrl: 'views/panier.html',
        controller: 'PanierCtrl',
        controllerAs: 'panier'
    })
    .when('/connection', {
        templateUrl: 'views/connection.html',
        controller: 'ConnectionCtrl',
        controllerAs: 'connection'
    })
    .when('/confirmation', {
        templateUrl: 'views/confirmation.html',
        controller: 'ConfirmationCtrl',
        controllerAs: 'confirmation'
    })
    .when('/contact', {
        templateUrl: 'views/contact.html',
        controller: 'ContactCtrl',
        controllerAs: 'contact'
    })
    .when('/identifiant', {
        templateUrl: 'views/identifiant.html',
        controller: 'IdentifiantCtrl',
        controllerAs: 'identifiant'
    })
    .when('/formation', {
        templateUrl: 'views/formation.html',
        controller: 'FormationCtrl',
        controllerAs: 'formation'
    })
    .when('/guitare', {
        templateUrl: 'views/guitare.html',
        controller: 'GuitareCtrl',
        controllerAs: 'guitare'
    })
    .when('/nouveau-compte', {
        templateUrl: 'views/nouveau-compte.html',
        controller: 'NouveauCompteCtrl',
        controllerAs: 'nouveauCompte'
    })
    .when('/article', {
        templateUrl: 'views/article.html',
        controller: 'ArticleCtrl',
        controllerAs: 'article'
    })
    .when('/paiement', {
        templateUrl: 'views/paiement.html',
        controller: 'PaiementCtrl',
        controllerAs: 'paiement'
    })
    .when('/erreurCommande', {
        templateUrl: 'views/erreurcommande.html',
        controller: 'ErreurcommandeCtrl',
        controllerAs: 'erreurCommande'
    })
    .when('/admin', {
        templateUrl: 'views/admin.html',
        controller: 'AdminCtrl',
        controllerAs: 'admin'
    })
    .when('/ajoutproduit', {
        templateUrl: 'views/admin/ajoutproduit.html',
        controller: 'AjoutproduitCtrl',
        controllerAs: 'ajoutproduit'
    })
    .when('/livraison', {
        templateUrl: 'views/livraison.html',
        controller: 'LivraisonCtrl',
        controllerAs: 'livraison'
    })
    .when('/error404', {
        templateUrl: '404.html'
    })
    .otherwise({
        redirectTo: '/'
    })
});
