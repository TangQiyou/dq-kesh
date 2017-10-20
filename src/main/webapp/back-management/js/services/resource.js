'use strict';

angular.module('resource', [])
    .service('resource', ['$http', '$q', 'toaster', '$window', function($http, $q, toaster, $window){
        //resource get
        this.get = function(url, params, headers){
            var deferred = $q.defer();
            $http.get(url, {
                params: params,
                headers: headers
            }).success(function(response, status, headers, config){
                if (response.timeout){
                    toaster.pop('error', '错误', '您的身份已过期，请重新登录！');
                }
                deferred.resolve(response);
            }).error(function(response, status, headers, config){
                toaster.pop('error', "错误", "服务器繁忙，请稍后重试");
                deferred.reject(response);
            });

            return deferred.promise;
        };

        //resource post
        this.post = function(url, data, headers){
            var deferred = $q.defer();
            $http.post(url, data, {
                headers: headers
            }).success(function(response, status, headers, config){
                if (response.timeout){
                    toaster.pop('error', '错误', '您的身份已过期，请重新登录！');
                }
                deferred.resolve(response);
            }).error(function(response, status, headers, config){
                toaster.pop('error', "错误", "服务器繁忙，请稍后重试");
                deferred.reject(response);
            });

            return deferred.promise;
        };

        //resource delete
        this.delete = function(url, params, headers){
            var deferred = $q.defer();
            $http.delete(url, {
                params: params,
                headers: headers
            }).success(function(response, status, headers, config){
                if (response.timeout){
                    toaster.pop('error', '错误', '您的身份已过期，请重新登录！');
                }
                deferred.resolve(response);
            }).error(function(response, status, headers, config){
                toaster.pop('error', "错误", "服务器繁忙，请稍后重试");
                deferred.reject(response);
            });

            return deferred.promise;
        };

        //resource put
        this.put = function(url, data, headers){
            var deferred = $q.defer();
            $http.put(url, data, {
                headers: headers
            }).success(function(response, status, headers, config){
                if (response.timeout){
                    toaster.pop('error', '错误', '您的身份已过期，请重新登录！');
                }
                deferred.resolve(response);
            }).error(function(response, status, headers, config){
                toaster.pop('error', "错误", "服务器繁忙，请稍后重试");
                deferred.reject(response);
            });

            return deferred.promise;
        };

        //resource patch
        this.patch = function(url, data, headers){
            var deferred = $q.defer();
            $http.patch(url, data, {
                headers: headers
            }).success(function(response, status, headers, config){
                if (response.timeout){
                    toaster.pop('error', '错误', '您的身份已过期，请重新登录！');
                }
                deferred.resolve(response);
            }).error(function(response, status, headers, config){
                toaster.pop('error', "错误", "服务器繁忙，请稍后重试");
                deferred.reject(response);
            });

            return deferred.promise;
        };
    }]);