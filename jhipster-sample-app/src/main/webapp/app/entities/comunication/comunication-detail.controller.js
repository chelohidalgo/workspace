(function() {
    'use strict';

    angular
        .module('jhipsterSampleApplicationApp')
        .controller('ComunicationDetailController', ComunicationDetailController);

    ComunicationDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Comunication'];

    function ComunicationDetailController($scope, $rootScope, $stateParams, previousState, entity, Comunication) {
        var vm = this;

        vm.comunication = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('jhipsterSampleApplicationApp:comunicationUpdate', function(event, result) {
            vm.comunication = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
