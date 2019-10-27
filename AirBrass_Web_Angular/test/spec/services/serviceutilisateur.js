'use strict';

describe('Service: serviceUtilisateur', function () {

  // load the service's module
  beforeEach(module('airBrassWebAngularApp'));

  // instantiate service
  var serviceUtilisateur;
  beforeEach(inject(function (_serviceUtilisateur_) {
    serviceUtilisateur = _serviceUtilisateur_;
  }));

  it('should do something', function () {
    expect(!!serviceUtilisateur).toBe(true);
  });

});
