'use strict';

/* Services */

var experiments_runnerServices = angular.module('experiments_runnerServices', ['ngResource']);

experiments_runnerServices.factory('Experiment', ['$resource',
  function($resource){
    return $resource('experiments/:id', {}, {
      query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
    });
  }]);
