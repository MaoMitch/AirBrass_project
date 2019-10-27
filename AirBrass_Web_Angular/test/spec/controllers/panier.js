'use strict';

describe('Controller: PanierCtrl', function () {

  // load the controller's module
  beforeEach(module('airBrassWebAngularApp'));

  var PanierCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PanierCtrl = $controller('PanierCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(PanierCtrl.awesomeThings.length).toBe(3);
  });
});
