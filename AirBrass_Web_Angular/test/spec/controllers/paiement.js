'use strict';

describe('Controller: PaiementCtrl', function () {

  // load the controller's module
  beforeEach(module('airBrassWebAngularApp'));

  var PaiementCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PaiementCtrl = $controller('PaiementCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(PaiementCtrl.awesomeThings.length).toBe(3);
  });
});
