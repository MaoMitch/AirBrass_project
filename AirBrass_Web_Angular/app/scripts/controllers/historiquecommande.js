'use strict';

angular.module('airBrassWebAngularApp')
.controller('HistoriqueCommandeCtrl', function ($scope, $window, serviceComande) {
    $scope.listCommand = [];
    $scope.message = '';
    $scope.prix = '';
    $scope.listLigne = [];
    $scope.command = {};
    var isConnected = localStorage.getItem('IsConnected');

    if (isConnected !== 'true') {
        $window.location.href = 'account.html';
    }
    $scope.displayCommand = function () {
        var user = JSON.parse(localStorage.getItem('user'));
        if(user.statut === "Administrateur") {
            $window.location.href = '/#!/error404';
        }
        serviceComande.displayCommand(user.id).then(function (data) {
            $scope.listCommand = data;
        }).catch(function (data) {
            $scope.message = data;
        });
    };
    $scope.getPrice = function (Commande) {
        serviceComande.getPrice(Commande.id).then(function (data) {
            Commande.prix = data + Commande.prixLivraison;
            return data;
        });
    };

    $scope.openSingle = function(x) {
             localStorage.setItem('item', x);
             $window.location.href = '/#!/article';
    };

    $scope.tableRowExpanded = false;
    $scope.tableRowIndexExpandedCurr = "";
    $scope.tableRowIndexExpandedPrev = "";
    $scope.storeIdExpanded = "";
    
    $scope.dayDataCollapseFn = function () {
        $scope.dayDataCollapse = [];
        for (var i = 0; i < $scope.listCommand.length; i += 1) {
            $scope.dayDataCollapse.push(false);
        }
    };
    
       
    $scope.selectTableRow = function (index, id) {
        if (typeof $scope.dayDataCollapse === 'undefined') {
            $scope.dayDataCollapseFn();
        }

        if ($scope.tableRowExpanded === false && $scope.tableRowIndexExpandedCurr === "" && $scope.storeIdExpanded === "") {
            $scope.tableRowIndexExpandedPrev = "";
            $scope.tableRowExpanded = true;
            $scope.tableRowIndexExpandedCurr = index;
            $scope.storeIdExpanded = id;
            $scope.dayDataCollapse[index] = true;
        } else if ($scope.tableRowExpanded === true) {
            if ($scope.tableRowIndexExpandedCurr === index && $scope.storeIdExpanded === id) {
                $scope.tableRowExpanded = false;
                $scope.tableRowIndexExpandedCurr = "";
                $scope.storeIdExpanded = "";
                $scope.dayDataCollapse[index] = false;
            } else {
                $scope.tableRowIndexExpandedPrev = $scope.tableRowIndexExpandedCurr;
                $scope.tableRowIndexExpandedCurr = index;
                $scope.storeIdExpanded = id;
                $scope.dayDataCollapse[$scope.tableRowIndexExpandedPrev] = false;
                $scope.dayDataCollapse[$scope.tableRowIndexExpandedCurr] = true;
            }
        }

    };

});