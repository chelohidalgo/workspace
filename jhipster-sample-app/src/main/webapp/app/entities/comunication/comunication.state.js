(function() {
    'use strict';

    angular
        .module('jhipsterSampleApplicationApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('comunication', {
            parent: 'entity',
            url: '/comunication?page&sort&search',
            data: {
                authorities: ['ROLE_USER', 'ROLE_SICPA'],
                pageTitle: 'jhipsterSampleApplicationApp.comunication.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/comunication/comunications.html',
                    controller: 'ComunicationController',
                    controllerAs: 'vm'
                }
            },
            params: {
                page: {
                    value: '1',
                    squash: true
                },
                sort: {
                    value: 'id,asc',
                    squash: true
                },
                search: null
            },
            resolve: {
                pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                    return {
                        page: PaginationUtil.parsePage($stateParams.page),
                        sort: $stateParams.sort,
                        predicate: PaginationUtil.parsePredicate($stateParams.sort),
                        ascending: PaginationUtil.parseAscending($stateParams.sort),
                        search: $stateParams.search
                    };
                }],
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('comunication');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('comunication-detail', {
            parent: 'comunication',
            url: '/comunication/{id}',
            data: {
                authorities: ['ROLE_USER', 'ROLE_SICPA'],
                pageTitle: 'jhipsterSampleApplicationApp.comunication.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/comunication/comunication-detail.html',
                    controller: 'ComunicationDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('comunication');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Comunication', function($stateParams, Comunication) {
                    return Comunication.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'comunication',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('comunication-detail.edit', {
            parent: 'comunication-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER', 'ROLE_SICPA']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/comunication/comunication-dialog.html',
                    controller: 'ComunicationDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Comunication', function(Comunication) {
                            return Comunication.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('comunication.new', {
            parent: 'comunication',
            url: '/new',
            data: {
                authorities: ['ROLE_USER', 'ROLE_SICPA']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/comunication/comunication-dialog.html',
                    controller: 'ComunicationDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                protocol: null,
                                producer: null,
                                type: null,
                                status: null,
                                description: null,
                                dateCreated: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('comunication', null, { reload: 'comunication' });
                }, function() {
                    $state.go('comunication');
                });
            }]
        })
        .state('comunication.edit', {
            parent: 'comunication',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER', 'ROLE_SICPA']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/comunication/comunication-dialog.html',
                    controller: 'ComunicationDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Comunication', function(Comunication) {
                            return Comunication.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('comunication', null, { reload: 'comunication' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('comunication.delete', {
            parent: 'comunication',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER', 'ROLE_SICPA']
            },
            params: {
                action: 'CANCEL'
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/comunication/comunication-delete-dialog.html',
                    controller: 'ComunicationDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Comunication', function(Comunication) {
                            return Comunication.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('comunication', null, { reload: 'comunication' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
            .state('comunication.end', {
                parent: 'comunication',
                url: '/{id}/finalize',
                data: {
                    authorities: ['ROLE_SICPA']
                },
                params: {
                    action: 'END'
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/entities/comunication/comunication-delete-dialog.html',
                        controller: 'ComunicationDeleteController',
                        controllerAs: 'vm',
                        size: 'md',
                        resolve: {
                            entity: ['Comunication', function(Comunication) {
                                return Comunication.get({id : $stateParams.id}).$promise;
                            }]
                        }
                    }).result.then(function() {
                        $state.go('comunication', null, { reload: 'comunication' });
                    }, function() {
                        $state.go('^');
                    });
                }]
            });
    }

})();
