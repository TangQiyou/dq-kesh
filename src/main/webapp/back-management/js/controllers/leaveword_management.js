/**
 * Created by 娜 on 2017/5/3.
 */
'use strict';

/* Controllers */

// Form controller
app.controller('LeveWordManagementCtrl', ['$scope', '$modal','resource','toaster', function ($scope, $modal,resource,toaster) {
    $scope.totalPage = 1;
    $scope.currentPage = 1;
    $scope.pageSize = 10;
    $scope.pingluns = {};

    $scope.loadData = function () {
        // ajax请求分页获取列表
        $scope.pingluns = [];
        resource.get('../back/leavewords', {
            pn:$scope.currentPage
        }).then(function (result) {
            if (result.code==1) {
                $scope.pingluns = result.extend.pageInfo.list;
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
    $scope.see = function (pinglun) {
        $scope.pinglun = pinglun;
        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/pinglun.html',
            controller: 'pinglunModalCtrl',
            backdrop: 'static',
            size: 'lg',
            resolve: {
                pinglun: function () {
                    return $scope.pinglun;
                }
            }
        });
    };
    // $scope.updateResponse = function () {
    //     resource.post('../back/response', $scope.item).then(function (result) {
    //         if (result.success) {
    //             toaster.pop('info', '提示', '回复留言成功');
    //             $scope.loadData();
    //         } else {
    //             toaster.pop('info', '提示', result.msg);
    //         }
    //     });
    // }
    //回复留言
    $scope.response = function (liuyan) {
        $scope.liuyan = liuyan;
        $scope.huifu = {};
        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/response.html',
            controller: 'responseModalCtrl',
            backdrop: 'static',
            resolve: {
                liuyan: function () {
                    return $scope.liuyan;
                },
                huifu:function () {
                    return $scope.huifu;
                }
            }
        });
        modalInstance.result.then(function (result) {
            $scope.item = result
            $scope.item.responseContent = UM.getEditor('editor').getContent();
            resource.post('../back/response', $scope.item).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '回复留言成功');
                    $scope.loadData();
                } else {
                    toaster.pop('info', '提示', result.msg);
                }
            });
        });
    }
    $scope.delete = function (pinglun) {
        $scope.pinglun = pinglun;

        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/delete.html',
            controller: 'DeleteModalCtrl',
            backdrop: 'static',
            resolve: {
                data: function () {
                    return $scope.pinglun;
                },
                content: function () {
                    return "您确定要删除该留言吗？";
                }
            }
        });
        modalInstance.result.then(function (result) {
            $scope.item = result;
            resource.delete('../back/leaveword/'+$scope.item.leaveId).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '删除留言成功');
                    $scope.loadData();
                } else {
                    toaster.pop('info', '提示',  '删除留言失败');
                }
            });
        });
    }
}]);

app.controller('pinglunModalCtrl', ['$scope', '$modalInstance', 'pinglun', function ($scope, $modalInstance, pinglun) {
    $scope.pinglun = pinglun;

    $scope.ok = function () {
        $modalInstance.close($scope.pinglun);
    };
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}]);
app.controller('responseModalCtrl', ['$scope', '$modalInstance', 'huifu','liuyan', function ($scope, $modalInstance, huifu,liuyan) {
    $scope.huifu = huifu;
    $scope.liuyan = liuyan;
    $scope.huifu.responseLeaveId = $scope.liuyan.leaveId;

    $scope.ok = function () {
        $modalInstance.close($scope.huifu);
    };
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}]);
app.controller('DeleteModalCtrl', ['$scope', '$modalInstance', 'data', 'content', function ($scope, $modalInstance, data, content) {
    $scope.data = data;
    $scope.content = content;
    $scope.ok = function () {
        $modalInstance.close($scope.data);
    };
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}]);


