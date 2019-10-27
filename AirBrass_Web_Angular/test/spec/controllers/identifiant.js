'use strict';

describe('Controller: IdentifiantCtrl', function () {

  // load the controller's module
  beforeEach(module('airBrassWebAngularApp'));

  var IdentifiantCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    IdentifiantCtrl = $controller('IdentifiantCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(IdentifiantCtrl.awesomeThings.length).toBe(3);
  });
});
