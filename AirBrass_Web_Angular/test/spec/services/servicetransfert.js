'use strict';

describe('Service: serviceTransfert', function () {

  // load the service's module
  beforeEach(module('airBrassWebAngularApp'));

  // instantiate service
  var serviceTransfert;
  beforeEach(inject(function (_serviceTransfert_) {
    serviceTransfert = _serviceTransfert_;
  }));

  it('should do something', function () {
    expect(!!serviceTransfert).toBe(true);
  });

});
