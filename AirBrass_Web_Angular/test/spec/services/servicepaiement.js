'use strict';

describe('Service: servicePaiement', function () {

  // load the service's module
  beforeEach(module('airBrassWebAngularApp'));

  // instantiate service
  var servicePaiement;
  beforeEach(inject(function (_servicePaiement_) {
    servicePaiement = _servicePaiement_;
  }));

  it('should do something', function () {
    expect(!!servicePaiement).toBe(true);
  });

});
