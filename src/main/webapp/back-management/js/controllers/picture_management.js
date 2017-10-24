app.controller('PictureManagementCtrl', ['$scope', '$modal','resource','toaster', function ($scope, $modal,resource,toaster) {
    $scope.totalPage = 1;
    $scope.currentPage = 1;
    $scope.pageSize = 10;
    $scope.pictures = {};
    $scope.types = {};
    $scope.type = {};
    $scope.flag = false;

    $scope.loadType = function () {
        resource.get('../public/getCodeByType',{code_type:"pic_type"}).then(function (result) {
            if (result.code) {
                $scope.types = {};
                $scope.types = result.extend.list;
                $scope.selectedType = $scope.types[0];
                $scope.type = $scope.types[0];
                $scope.loadData($scope.type);
            } else {
                $scope.types = [];
                toaster.pop('info', '提示', result.msg);
            }
        })
	   };
    $scope.loadType();
    $scope.loadData = function (type) {
        $scope.flag = false;
        $scope.searchYear = "";
        $scope.searchMonth = "";
        $scope.searchDay = "";
    	if ($scope.type != type){
    		$scope.currentPage = 1;
    	}
    	$scope.type = type;
        resource.post('../back/getPictureByType', {
        	picType:type.codeValue,
        	pn:$scope.currentPage
        }).then(function (result) {
        if (result.code==1) {
            $scope.pictures = result.extend.pageInfo.list;
            $scope.totalPage = result.extend.pageInfo.pages;
        } else {
            toaster.pop('info', '提示', '查找失败');
        }
    });

    };
    //上一页
    $scope.Previous = function () {
        if ($scope.currentPage <= 1) {
            $scope.currentPage = 1;
        } else {
            $scope.currentPage--;
        }
        $scope.loadData($scope.type);
    }
    //下一页
    $scope.Next = function () {
        if ($scope.currentPage >= $scope.totalPage) {
            $scope.currentPage = $scope.totalPage;
        } else {
            $scope.currentPage++;
        }
        $scope.loadData($scope.type);
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
        $scope.loadData($scope.type);

    };
    $scope.search = function (searchYear,searchMonth,searchDay,selectedType) {
        if (selectedType == null){
            resource.post('../back/getPictureByDate', {
                year:searchYear,
                month:searchMonth,
                day:searchDay
            }).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '查询成功');
                    $scope.flag = true;
                    $scope.currentPage = 1;
                    $scope.pictures = result.extend.pageInfo.list;
                    $scope.totalPage = result.extend.pageInfo.pages;
                } else {
                    toaster.pop('info', '提示', '查询失败');
                }
            });
        }else{
            resource.post('../back/getPictureByDateAndType', {
                year:searchYear,
                month:searchMonth,
                day:searchDay,
                picType:selectedType.codeValue
            }).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '查询成功');
                    $scope.flag = true;
                    $scope.currentPage = 1;
                    $scope.pictures = result.extend.pageInfo.list;
                    $scope.totalPage = result.extend.pageInfo.pages;
                } else {
                    toaster.pop('info', '提示', '查询失败');
                }
            });
        }
    }
  //点击图片查看大图
    $scope.display = function (item) {
        $scope.item = item;
        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/display.html',
            controller: 'DisplayModalCtrl',
            backdrop: 'static',
            size: 'lg',
            resolve: {
                data: function () {
                    return item;
                }
            }
        });
    }
    
    $scope.add = function () {
        $scope.picture = {};
        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/picture.html',
            controller: 'PictureCtrl',
            backdrop: 'static',
            size: 'lg',
            resolve: {
            	picture: function () {
                    return $scope.picture;
                },
                type: function(){
                	return $scope.type
                }
            }
        });
        modalInstance.result.then(function (result) {
            $scope.item = result;
            resource.post('../back/picture', $scope.item).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '添加图片成功');
                    $scope.loadData($scope.type);
                } else {
                    toaster.pop('info', '提示',  '添加图片失败');
                }
            });
        });
    };
    $scope.delete = function (picture) {
        $scope.picture = picture;

        var modalInstance = $modal.open({
            templateUrl: 'tpl/modal/delete.html',
            controller: 'DeleteModalCtrl',
            backdrop: 'static',
            resolve: {
                data: function () {
                    return $scope.picture;
                },
                content: function () {
                    return "您确定要删除" + picture.picName + "吗？";
                }
            }
        });
        modalInstance.result.then(function (result) {
            $scope.item = result;
            resource.delete('../back/picture/'+$scope.item.picId).then(function (result) {
                if (result.code==1) {
                    toaster.pop('info', '提示', '删除图片成功');
                    $scope.loadData($scope.type);
                } else {
                    toaster.pop('info', '提示',  '删除图片失败');
                }
            });
        });
    }
}]);

app.controller('PictureCtrl', ['$scope', '$modalInstance', 'picture','type','appService', function ($scope, $modalInstance, picture,type,appService) {
    $scope.picture = picture;
    $scope.type = type;
    appService.codeValue = $scope.type.codeValue;
    
    $scope.picture.picType = $scope.type.codeValue;
    $scope.picture.picName = "?";
    
    $scope.picture.picType = $scope.type.codeValue;
    $scope.$on('picture', function (e, d) {
        $scope.picture.picId = d;
    }); 

    $scope.ok = function () {
        $modalInstance.close($scope.picture);
    };
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
}]);
app.controller('FileUploadCtrl', ['$scope', 'FileUploader', 'toaster', '$http', 'resource','appService', function ($scope, FileUploader, toaster, $http, resource,appService) {
   
	var uploader = $scope.uploader = new FileUploader({
        url: '../up',
        formData: [{'_token': $('[name="_token"]').val()}]
    });
    // FILTERS

    uploader.filters.push({
        name: 'customFilter',
        fn: function (item /*{File|FileLikeObject}*/, options) {
            return this.queue.length < 10;
        }
    });
   
    $scope.uploadImg = function (item) {
    	$scope.codeValue = appService.codeValue;
        var fd = new FormData();
        var file = item._file;
        fd.append('file', file);
        fd.append('picType',$scope.codeValue);  
        console.log($scope.type.codeValue);
        $http({
            method: 'POST',
            url: "../back/addOnlyPicture",
            data: fd,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity,
            enctype:"multipart/form-data"
        }).success(function (result) {
            if (result.code==1) {
                $scope.$emit('picture', result.extend.pic_id);
                toaster.pop('success', '提示', '上传成功, 耗时  '+result.extend.totalTime);
            } else {
                toaster.pop('error', '提示', '上传失败');
            }
        });

    }
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
app.service("appService", [function(){
    this.codeValue="";
  }]);
//图片大图显示弹框
app.controller('DisplayModalCtrl', ['$scope', '$modalInstance', 'data', function ($scope, $modalInstance, data) {
    $scope.item = data;

    $scope.ok = function () {
        $modalInstance.close($scope.data);
    };
}]);


