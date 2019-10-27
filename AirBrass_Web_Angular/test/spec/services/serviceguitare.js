'use strict';

describe('Service: serviceGuitare', function () {

  // load the service's module
  beforeEach(module('airBrassWebAngularApp'));

  // instantiate service
  var serviceGuitare;
  beforeEach(inject(function (_serviceGuitare_) {
    serviceGuitare = _serviceGuitare_;
  }));

  it('should do something', function () {
    expect(!!serviceGuitare).toBe(true);
  });

});
