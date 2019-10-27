'use strict';

describe('Controller: AccessoireCtrl', function () {

  // load the controller's module
  beforeEach(module('airBrassWebAngularApp'));

  var AccessoireCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AccessoireCtrl = $controller('AccessoireCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AccessoireCtrl.awesomeThings.length).toBe(3);
  });
});
