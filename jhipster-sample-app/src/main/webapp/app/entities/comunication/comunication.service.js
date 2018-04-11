(function() {
    'use strict';
    angular
        .module('jhipsterSampleApplicationApp')
        .factory('Comunication', Comunication);

    Comunication.$inject = ['$resource', 'DateUtils'];

    function Comunication ($resource, DateUtils) {
        var resourceUrl =  'api/comunications/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.dateCreated = DateUtils.convertLocalDateFromServer(data.dateCreated);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateCreated = DateUtils.convertLocalDateToServer(new Date());
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateCreated = DateUtils.convertLocalDateToServer(copy.dateCreated);
                    return angular.toJson(copy);
                }
            },
            'findByFilters': {
                method: 'GET',
                isArray: true,
                url: 'api/comunications/filters',
                params: {filters: null},
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.dateCreated = DateUtils.convertLocalDateFromServer(data.dateCreated);
                    }
                    return data;
                }
            }
            /*,
            'saveResponse': {
                method: 'POST',
                url: 'api/comunications/response',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateCreated = DateUtils.convertLocalDateToServer(new Date());
                    return angular.toJson(copy);
                }
            },
            'cancel': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateCreated = DateUtils.convertLocalDateToServer(new Date());
                    return angular.toJson(copy);
                }
            }
            */
        });
    }
})();
