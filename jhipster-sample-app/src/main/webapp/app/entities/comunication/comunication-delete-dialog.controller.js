(function() {
    'use strict';

    angular
        .module('jhipsterSampleApplicationApp')
        .controller('ComunicationDeleteController',ComunicationDeleteController);

    ComunicationDeleteController.$inject = ['$uibModalInstance','$stateParams', 'entity', 'Comunication'];

    function ComunicationDeleteController($uibModalInstance,$stateParams, entity, Comunication) {
        var vm = this;

        vm.comunication = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;
        vm.confirmCancel = confirmCancel;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Comunication.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }

        function confirmCancel () {
            vm.comunication.status = $stateParams.action === 'CANCEL' ? 'CANCELED' : 'ENDED';
            Comunication.update(vm.comunication, function () {
                $uibModalInstance.close(true);
            });

        }
    }
})();
