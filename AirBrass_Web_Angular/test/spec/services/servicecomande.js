'use strict';

describe('Service: serviceComande', function () {

  // load the service's module
  beforeEach(module('airBrassWebAngularApp'));

  // instantiate service
  var serviceComande;
  beforeEach(inject(function (_serviceComande_) {
    serviceComande = _serviceComande_;
  }));

  it('should do something', function () {
    expect(!!serviceComande).toBe(true);
  });

});
