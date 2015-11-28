'use strict';

/* App Module */

var phonecatApp = angular.module('experiments_runnerApp', [
  'ngRoute',
  'experiments_runner_Controllers',
  'phonecatAnimations',
  'phonecatFilters',
  'phonecatServices'
]);

phonecatApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/experiments', {
        templateUrl: 'partials/experiments-list.html',
        controller: 'ExperimentListCtrl'
      }).
      when('/phones/:phoneId', {
        templateUrl: 'partials/phone-detail.html',
        controller: 'PhoneDetailCtrl'
      }).
      otherwise({
        redirectTo: '/phones'
      });
  }]);
