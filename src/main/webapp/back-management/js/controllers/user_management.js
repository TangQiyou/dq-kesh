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
    
    //定义分页获取用户信息，默认第一页
    $scope.loadData = function () {
    	
    	//每次获取前清空信息
        $scope.users = [];
        
        //ajax请求分页获取列表
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
    
    //左侧点击后自动执行一次
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
        resource.get('../back/user', {id:user.userId}).then(function (result) {
            if (result.code==1) {
            	//extend里面不仅包含了user信息，还包含了相应的list
                $scope.extend = result.extend;
                $scope.see($scope.extend);
            } else {
                toaster.pop('info', '提示', '获取用户信息失败');
            }
        });
    }
    
    //弹出模态框查看用户信息
    $scope.see = function (extend) {
    	$scope.extend = extend;
        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/user.html',
            controller: 'UserModalCtrl',
            backdrop: 'static',
            size: 'lg',
            resolve: {
            	content: function () {
                    return angular.copy(extend);
                }
            }
        });
        modalInstance.result.then(function (result) {
        	$scope.item = result;
            resource.put('../back/user', $scope.item).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '修改用户信息成功');
                    $scope.loadData();
                } else {
                    toaster.pop('info', '提示',  '修改用户信息失败');
                }
            });
        });
    };
    
    //删除用户
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
            resource.delete('../back/user/'+$scope.item.userId).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '删除成功');
                    $scope.loadData();
                } else {
                    toaster.pop('info', '提示','删除失败');
                }
            });
        });
    }
    
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
}]);

app.controller('UserModalCtrl', ['$scope', '$modalInstance', 'content', function ($scope, $modalInstance, content) {
    $scope.content = content;

    $scope.selectedGender = {codeValue:$scope.content.user.gender};
    $scope.selectedStatus = {codeValue:$scope.content.user.status};
    $scope.selectedCollege = {codeValue:$scope.content.user.college};
    console.log($scope.selectedCollege);
    $scope.update = function () {
        $scope.content.user.gender = $scope.selectedGender.codeValue;
        $scope.content.user.status = $scope.selectedStatus.codeValue;
        $scope.content.user.college = $scope.selectedCollege.codeValue;
        console.log($scope.content.user);
        $modalInstance.close($scope.content.user);
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


