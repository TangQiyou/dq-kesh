'use strict';

/**
 * Config for the router
 */
angular.module('app')
    .run(
        ['$rootScope', '$state', '$stateParams',
            function ($rootScope, $state, $stateParams) {
                $rootScope.$state = $state;
                $rootScope.$stateParams = $stateParams;
            }
        ]
    )
    .config(
        ['$stateProvider', '$urlRouterProvider',
            function ($stateProvider, $urlRouterProvider) {

                $urlRouterProvider
                    .otherwise('/app/announcement_management');
                $stateProvider
                    .state('app', {
                        abstract: true,
                        url: '/app',
                        templateUrl: 'tpl/app.html'
                    })
                    //公告管理
                    .state('app.announcement_management', {
                        url: '/announcement_management',
                        templateUrl: 'tpl/announcement_management.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(['toaster','js/controllers/announcement_management.js','js/directives/editor.js']);
                                }]
                        }
                    })
                    //图片面板管理
                    .state('app.picture_management', {
                        url: '/picture_management',
                        templateUrl: 'tpl/picture_management.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(['toaster','angularFileUpload', 'js/controllers/picture_management.js']);
                                }]
                        }
                    })
                    //用户管理
                    .state('app.user_management', {
                        url: '/user_management',
                        templateUrl: 'tpl/user_management.html',
                        resolve: {
                            deps: ['$ocLazyLoad',
                                function ($ocLazyLoad) {
                                    return $ocLazyLoad.load(['toaster','js/controllers/user_management.js']);
                                }]
                        }
                    })
            }
        ]
    );