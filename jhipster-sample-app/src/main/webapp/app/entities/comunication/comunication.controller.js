(function() {
    'use strict';

    angular
        .module('jhipsterSampleApplicationApp')
        .controller('ComunicationController', ComunicationController);

    ComunicationController.$inject = ['Principal', '$state', 'Comunication', 'ParseLinks', 'AlertService', 'paginationConstants', 'pagingParams', 'DateUtils'];

    function ComunicationController(Principal, $state, Comunication, ParseLinks, AlertService, paginationConstants, pagingParams, DateUtils) {

        var vm = this;

        vm.loadPage = loadPage;
        vm.currentAccount = null;
        vm.predicate = pagingParams.predicate;
        vm.reverse = pagingParams.ascending;
        vm.transition = transition;
        vm.itemsPerPage = paginationConstants.itemsPerPage;
        vm.datePickerOpenStatus = {};
        vm.statusOptions = [{id: 'OPEN', name: 'OPEN'},
            {id: 'IN PROCESS', name: 'IN PROCESS'},
            {id: 'PENDING PRODUCT', name: 'PENDING PRODUCT'},
            {id: 'CANCELED', name: 'CANCELED'},
            {id: 'ENDED', name: 'ENDED'}];
        vm.openCalendar = openCalendar;
        vm.filters = {};
        vm.search = search;
        vm.clear = clear;
        vm.showFinalize;

        loadAll();
        Principal.identity().then(function(account) {
            vm.currentAccount = account;
            if(vm.currentAccount){
                vm.currentAccount.authorities.forEach(function (currentValue) {
                    if(currentValue === 'ROLE_SICPA'){
                        vm.showFinalize = true;
                        return;
                    }
                });
            }
        });

        function loadAll () {
            Comunication.query({
                page: pagingParams.page - 1,
                size: vm.itemsPerPage,
                sort: sort()
            }, onSuccess, onError);
            function sort() {
                var result = [vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc')];
                if (vm.predicate !== 'id') {
                    result.push('id');
                }
                return result;
            }
            function onSuccess(data, headers) {
                vm.links = ParseLinks.parse(headers('link'));
                vm.totalItems = headers('X-Total-Count');
                vm.queryCount = vm.totalItems;
                vm.comunications = data;
                vm.page = pagingParams.page;
            }
            function onError(error) {
                AlertService.error(error.data.message);
            }
        }

        function loadPage(page) {
            vm.page = page;
            vm.transition();
        }

        function transition() {
            $state.transitionTo($state.$current, {
                page: vm.page,
                sort: vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc'),
                search: vm.currentSearch
            });
        }

        function search() {
            vm.filters.startDate = DateUtils.convertLocalDateToServer(vm.filters.startDate);
            vm.filters.endDate = DateUtils.convertLocalDateToServer(vm.filters.endDate);
            Comunication.findByFilters({
                page: pagingParams.page - 1,
                size: vm.itemsPerPage,
                sort: sort(),
                filters : vm.filters
            }, onSuccess, onError);
            function sort() {
                var result = [vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc')];
                if (vm.predicate !== 'id') {
                    result.push('id');
                }
                return result;
            }
            function onSuccess(data, headers) {
                vm.links = ParseLinks.parse(headers('link'));
                vm.totalItems = headers('X-Total-Count');
                vm.queryCount = vm.totalItems;
                vm.comunications = data;
                vm.page = pagingParams.page;
                vm.filters.startDate = DateUtils.convertLocalDateFromServer(vm.filters.startDate);
                vm.filters.endDate = DateUtils.convertLocalDateFromServer(vm.filters.endDate);
            }
            function onError(error) {
                AlertService.error(error.data.message);
            }
        }

        vm.datePickerOpenStatus.startDate = false;
        vm.datePickerOpenStatus.endDate = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }

        function clear() {
            vm.filters = {};
        }
    }
})();
