'use strict';

describe('Service: serviceAccessoire', function () {

  // load the service's module
  beforeEach(module('airBrassWebAngularApp'));

  // instantiate service
  var serviceAccessoire;
  beforeEach(inject(function (_serviceAccessoire_) {
    serviceAccessoire = _serviceAccessoire_;
  }));

  it('should do something', function () {
    expect(!!serviceAccessoire).toBe(true);
  });

});
