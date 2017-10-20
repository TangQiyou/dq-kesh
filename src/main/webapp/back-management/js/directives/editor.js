/**
 * Created by sailwish002 on 2016/8/2.
 */
app.directive('editor', function () {
    return {
        restrict: 'AE',
        replace: true,
        template: '<script name="content" type="text/plain">',
        link: function (scope, el, attr) {
            var id = attr.id;
            UM.delEditor(id);

            var ue = UM.getEditor(id, {
                initialFrameWidth: '100%',
                initialFrameHeight: 300,
                autoHeightEnabled: false
            });
            ue.ready(function () {
                if (attr.config == 'announcement'){
                    ue.setContent(scope.announcement.annContent);
                }
            });
        }

    }
})