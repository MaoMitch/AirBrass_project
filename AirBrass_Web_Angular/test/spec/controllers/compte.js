'use strict';

describe('Controller: CompteCtrl', function () {

  // load the controller's module
  beforeEach(module('airBrassWebAngularApp'));

  var CompteCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    CompteCtrl = $controller('CompteCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(CompteCtrl.awesomeThings.length).toBe(3);
  });
});
