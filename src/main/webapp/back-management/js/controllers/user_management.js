/**
 * Created by 娜 on 2017/5/2.
 */
'use strict';

/* Controllers */

// Form controller
app.controller('UserManagementCtrl', ['$scope', '$modal','resource','toaster', function ($scope, $modal,resource,toaster) {
    $scope.totalPage = 1;
    $scope.currentPage = 1;
    $scope.pageSize = 10;
    $scope.users = [];
    $scope.loadData = function () {
        $scope.users = [];
        // ajax请求分页获取列表
        resource.get('../back/users', {
            pn:$scope.currentPage
        }).then(function (result) {
            if (result.code==1) {
                $scope.users = result.extend.pageInfo.list;
                $scope.totalPage = result.extend.pageInfo.pages;

            } else {
                toaster.pop('info', '提示','获取失败');
            }
        });

    };
    $scope.loadData();
    //上一页
    $scope.Previous = function () {
        if ($scope.currentPage <= 1) {
            $scope.currentPage = 1;
        } else {
            $scope.currentPage--;
        }
        $scope.loadData();
    }
    //下一页
    $scope.Next = function () {
        if ($scope.currentPage >= $scope.totalPage) {
            $scope.currentPage = $scope.totalPage;
        } else {
            $scope.currentPage++;
        }
        $scope.loadData();
    };
    //页面跳转
    $scope.goToPage = function () {
        //从input输入框绑定的currentPage变量中获取用户输入的值
        $scope.currentPage = parseInt($scope.currentPage);
        //为了程序的严密和可用性，需要先判断输入是否为空
        if ($scope.currentPage == null || $scope.currentPage == undefined || $scope.currentPage == "") {
            $scope.currentPage = 1;
            toaster.pop('info', '提示', '请填写正确的页码');
        } else if ($scope.currentPage < 1 || $scope.currentPage > $scope.totalPage) {
            $scope.currentPage = 1;
            toaster.pop('info', '提示', '请填写正确的页码');
        }
        $scope.loadData();

    };
    // 查看用户信息
    $scope.loaduser = function(user){
        resource.post('../findOneUserByname', {name:user.name}).then(function (result) {
            if (result.success) {
                $scope.user = result.user;
                $scope.see($scope.user);
            } else {
                toaster.pop('info', '提示', '获取失败');
            }
        });
    }
    $scope.see = function (user) {
    	$scope.user = user;
        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/user.html',
            controller: 'UserModalCtrl',
            backdrop: 'static',
            size: 'lg',
            resolve: {
                user: function () {
                    return $scope.user;
                }
            }
        });
    };
    // 冻结用户
    $scope.stop = function (user) {
        $scope.user = user;
        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/stop.html',
            controller: 'DeleteModalCtrl',
            backdrop: 'static',
            size: 'lg',
            resolve: {
                data: function () {
                    return $scope.user;
                },
                content: function () {
                    $scope.isShow = user.dongjie;
                    if ($scope.isShow == 1) {
                        return "您确定要解冻" + user.name + "吗？";
                    } else {
                        return "您确定要冻结" + user.name + "吗？";
                    }

                }
            }
        });
        modalInstance.result.then(function (result) {
            $scope.item = result;
            if($scope.item.dongjie == 0){
                resource.post('../dongjieOneUser', {id:$scope.item.id}).then(function (result) {
                    if (result.success) {
                        toaster.pop('info', '提示','冻结成功');
                        $scope.loadData();
                    } else {
                        toaster.pop('info', '提示', '冻结失败');
                    }
                });
            }else {
                resource.post('../jiedongOneUser', {id:$scope.item.id}).then(function (result) {
                    if (result.success) {
                        toaster.pop('info', '提示', '解冻成功');
                        $scope.loadData();
                    } else {
                        toaster.pop('info', '提示', '解冻失败');
                    }
                });
            }
        });
    };
    $scope.delete = function (user) {
        $scope.user = user;

        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/delete.html',
            controller: 'DeleteModalCtrl',
            backdrop: 'static',
            resolve: {
                data: function () {
                    return $scope.user;
                },
                content: function () {
                    return "您确定要删除" + user.name + "吗？";
                }
            }
        });
        modalInstance.result.then(function (result) {
            $scope.item = result;
            resource.post('../deleteOneUser', {id:$scope.item.id}).then(function (result) {
                if (result.success) {
                    toaster.pop('info', '提示', '删除成功');
                    $scope.loadData();
                } else {
                    toaster.pop('info', '提示','删除失败');
                }
            });
        });
    }
}]);

app.controller('UserModalCtrl', ['$scope', '$modalInstance', 'user', function ($scope, $modalInstance, user) {
    $scope.user = user;


    $scope.ok = function () {
        $modalInstance.close($scope.user);
    };
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}]);

app.controller('DeleteModalCtrl', ['$scope', '$modalInstance', 'data', 'content', function ($scope, $modalInstance, data, content) {
    $scope.data = data;
    $scope.content = content;
    if ($scope.data.dongjie == 1) {
        $scope.delete_title = "解冻";
    } else {
        $scope.delete_title = "冻结";
    }
    $scope.ok = function () {
        $modalInstance.close($scope.data);
    };
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}]);


