'use strict';

describe('Service: serviceProduit', function () {

  // load the service's module
  beforeEach(module('airBrassWebAngularApp'));

  // instantiate service
  var serviceProduit;
  beforeEach(inject(function (_serviceProduit_) {
    serviceProduit = _serviceProduit_;
  }));

  it('should do something', function () {
    expect(!!serviceProduit).toBe(true);
  });

});
