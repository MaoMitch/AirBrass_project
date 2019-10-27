'use strict';

describe('Controller: NouveauCompteCtrl', function () {

  // load the controller's module
  beforeEach(module('airBrassWebAngularApp'));

  var NouveauCompteCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    NouveauCompteCtrl = $controller('NouveauCompteCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(NouveauCompteCtrl.awesomeThings.length).toBe(3);
  });
});
