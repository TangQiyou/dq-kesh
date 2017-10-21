app.controller('AnnouncementManagementCtrl', ['$scope', '$modal','resource','toaster', function ($scope, $modal,resource,toaster) {
    $scope.totalPage = 1;
    $scope.currentPage = 1;
    $scope.pageSize = 10;
    $scope.announcements = {};

    $scope.loadData = function () {
        // ajax请求分页获取列表
        $scope.announcements = {};
        resource.get('../back/announcements', {
        	pn:$scope.currentPage
        }).then(function (result) {
            if (result.code==1) {
                $scope.announcements = result.extend.pageInfo.list;
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
    $scope.add = function () {
        $scope.announcement = {};
        $scope.announcement.annContent = '';
        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/announcement.html',
            controller: 'AnnouncementCtrl',
            backdrop: 'static',
            size: 'lg',
            resolve: {
            	announcement: function () {
                    return $scope.announcement;
                },
                tag:function () {
                    return 0;
                }
            }
        });
        modalInstance.result.then(function (result) {
            $scope.item = result;
            $scope.item.annContent = UM.getEditor('editor').getContent();
            resource.post('../back/announcement', $scope.item).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '添加公告成功');
                    $scope.loadData();
                } else {
                    toaster.pop('info', '提示',  '添加公告失败');
                }
            });
        });
    };
    
    //修改公告
    $scope.update = function (announcement) {
        $scope.announcement = announcement;
        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/announcement.html',
            controller: 'AnnouncementCtrl',
            backdrop: 'static',
            size: 'lg',
            resolve: {
            	announcement: function () {
                    return $scope.announcement;
                },
                tag:function () {
                    return 1;
                }
            }
        });
        modalInstance.result.then(function (result) {
            $scope.item = result;
            $scope.item.annContent = UM.getEditor('editor').getContent();
            // ajax 更新用户信息
            resource.put('../back/announcement', $scope.item).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '更新公告成功');
                    $scope.loadData();
                } else {
                    toaster.pop('info', '提示', '更新公告失败');
                }
            });

        });
    };
    $scope.delete = function (announcement) {
        $scope.announcement = announcement;

        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/delete.html',
            controller: 'DeleteModalCtrl',
            backdrop: 'static',
            resolve: {
                data: function () {
                    return $scope.announcement;
                },
                content: function () {
                    return "您确定要删除" + announcement.annTitle + "吗？";
                }
            }
        });
        modalInstance.result.then(function (result) {
            $scope.item = result;
            resource.delete('../back/announcement/'+$scope.item.annId).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '删除公告成功');
                    $scope.loadData();
                } else {
                    toaster.pop('info', '提示',  '删除公告失败');
                }
            });
        });
    }
}]);

app.controller('AnnouncementCtrl', ['$scope', '$modalInstance', 'announcement','tag', function ($scope, $modalInstance, announcement,tag) {
    $scope.announcement = announcement;
    if (tag == 0){
        $scope.title = '添加';
    }else{
        $scope.title = '修改';
    }

    $scope.ok = function () {
        $modalInstance.close($scope.announcement);
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


