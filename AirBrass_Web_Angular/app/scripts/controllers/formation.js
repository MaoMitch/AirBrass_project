'use strict';

/**
 * @ngdoc function
 * @name airBrassWebAngularApp.controller:FormationCtrl
 * @description
 * # FormationCtrl
 * Controller of the airBrassWebAngularApp
 */	

angular.module('airBrassWebAngularApp')
  .controller('FormationCtrl', function ($scope, $window, serviceFormation) {

	  $scope.listeAllFormations = [];
	  $scope.listeAllFormateurs = [];
	  $scope.listeTableau = [];
	  $scope.selectedFormateur = null;
	  $scope.selectedNiveau = null;
	  $scope.intitule = null;
	  
	  //INIT
	  $scope.onInit = function() {
		  this.InitTableau();
		  this.getListeAllFormateurs();
	  };
	  
	  //GetFormations by conditions
	  $scope.getListeFormations = function (){
		  serviceFormation.getFormations( $scope.intitule, $scope.selectedFormateur,$scope.selectedNiveau)
		  .then(function(data) {
			  $scope.listeTableau = data;
		  }).catch(function () {

          });
	  };

	  //GetAllFormations
	  $scope.getListeAllFormations = function() {
		  serviceFormation.getAllFormations().then(function(data) {
			  $scope.listeAllFormations = data;
		  }).catch(function () {

          });
	  };
	  
	  //GetAllFormateurs
	  $scope.getListeAllFormateurs = function() {
		  serviceFormation.getAllFormateurs().then(function(data) {
			  $scope.listeAllFormateurs = data;
		  }).catch(function () {

          });
	  };
	  
	  //Réinitialiser le tableau
	  $scope.InitTableau = function() {
		  serviceFormation.getAllFormations().then(function(data) {
			  $scope.listeTableau = data;
		  }).catch(function () {

          });
	  };
	  

	  
	  //Réserver formation
	  $scope.reserverFormation = function(f) {
	  		serviceFormation.reserver(f).then(function(date) {
	  			serviceFormation.getFormations( $scope.intitule, $scope.selectedFormateur,$scope.selectedNiveau)
		  		.then(function(data) {
			 	 $scope.listeTableau = data;
		  }).catch(function () {

          });
	  		});
		  
	  };
	  
	  //Sélection d'un formateur
	  $scope.changeFormateur = function(selectedFormateur) {
		  if(selectedFormateur !== null) {
			  $scope.selectedFormateur = selectedFormateur;
		  }
	  };

	  //Sélection d'un niveau
	  $scope.changeNiveau = function(selectedNiveau) {
		  if(selectedNiveau !== null) {
			  $scope.selectedNiveau = selectedNiveau;
		  }
	  };
	  
	  //Sélection d'un intitulé de formation
	  $scope.changeIntitule = function(intitule) {
		  if(intitule !== null) {
			  $scope.intitule = intitule;
		  }
	  };
  });