'use strict';

describe('Controller: GuitareCtrl', function () {

  // load the controller's module
  beforeEach(module('airBrassWebAngularApp'));

  var GuitareCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    GuitareCtrl = $controller('GuitareCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(GuitareCtrl.awesomeThings.length).toBe(3);
  });
});
