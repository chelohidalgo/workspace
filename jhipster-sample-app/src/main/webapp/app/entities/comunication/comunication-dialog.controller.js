(function() {
    'use strict';

    angular
        .module('jhipsterSampleApplicationApp')
        .controller('ComunicationDialogController', ComunicationDialogController);

    ComunicationDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Comunication'];

    function ComunicationDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Comunication) {
        var vm = this;

        vm.comunication = entity;
        vm.comunication.dateCreated = new Date();
        vm.comunication.status = vm.comunication.id ? vm.comunication.status : 'OPEN';
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.typeOptions = [{id: 'Incident', name: 'Incident'},
            {id: 'Service', name: 'Service'}];
            //,{id: 'Option C', name: 'Option C'}];


        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.comunication.id !== null) {
                vm.comunication.status = 'IN PROCESS';
                Comunication.update(vm.comunication, onSaveSuccess, onSaveError);
            } else {
                Comunication.save(vm.comunication, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('jhipsterSampleApplicationApp:comunicationUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.dateCreated = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
