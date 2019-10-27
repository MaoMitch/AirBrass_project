'use strict';

describe('Controller: ErreurcommandeCtrl', function () {

  // load the controller's module
  beforeEach(module('airBrassWebAngularApp'));

  var ErreurcommandeCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ErreurcommandeCtrl = $controller('ErreurcommandeCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ErreurcommandeCtrl.awesomeThings.length).toBe(3);
  });
});
