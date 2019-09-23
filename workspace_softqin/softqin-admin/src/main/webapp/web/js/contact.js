 baseUrl = "http://47.98.197.158:8080/softqin-admin/";
//const baseUrl = "http://192.168.1.94:8080/softqin-admin/";
$(function () {
    var map=new BMap.Map('contact_map');
    var point= new BMap.Point(121.388825,31.22929);
    map.enableScrollWheelZoom();   //启动鼠标中键控制地图缩放
    map.centerAndZoom(point, 15); // 初始化地图，设置中心点坐标和地图级别
    map.enableContinuousZoom();    // 开启连续缩放效果
    map.enableInertialDragging(); // 开启惯性拖拽效果
    map.addControl(new BMap.NavigationControl()); //添加缩放平移控件
    map.addControl(new BMap.ScaleControl());//添加比例尺控件
    map.addControl(new BMap.OverviewMapControl());//添加缩略图控件
    //设置标注的图标
    var icon = new BMap.Icon('image/icon.jpg', new BMap.Size(24, 32), {
        anchor: new BMap.Size(10, 10),

    });
    //设置标注的经纬度出现图标的地方
    var mkr = new BMap.Marker(new BMap.Point(121.388825,31.22929), {
        icon: icon
    });
    //把标注添加到地图上
   map.addOverlay(mkr);
    //点击标注，显示信息
    var content = "<table>";
    content = content + "<tr><td> 地点：上海市普陀区云岭东路651号</td></tr>";
    content += "</table>";
    var infowindow = new BMap.InfoWindow(content);
    mkr.addEventListener("click",function(){
        this.openInfoWindow(infowindow);
    });

    $(".submit").on("click",function () {
        var $name=$(".input_name").val();
        var $phone=$(".input_phone").val();
        var email=$(".input_email").val();
        var textbox=$(".textbox").val();
        if(!$name){
            layer.tips('请输入名字', '.input_name', {
                tips: [1, '#3595CC'],
            });
            return;
        }
        if(!$phone){
            layer.tips('请输入电话', '.input_phone', {
                tips: [1, '#3595CC'],
            });
            return;
        }else if(!isPhone($phone)){
            layer.tips('电话格式不正确', '.input_phone', {
                tips: [1, '#3595CC'],
            });
            return;
        }
        if(!email){
            layer.tips('请输入邮箱', '.input_email', {
                tips: [1, '#3595CC'],
            });
            return;
        }else if(!isEmail(email)){
            layer.tips('邮箱格式不正确', '.input_email', {
                tips: [1, '#3595CC'],
            });
            return;
        }
        if(!textbox){
            layer.tips('请输入内容', '.textbox', {
                tips: [1, '#3595CC'],
            });
            return;
        }
        $.ajax({
           url:baseUrl+"webCustomerInterface/addCustomer",
            dataType:"json",
            data:{
                name:$name,
                phone:$phone,
                mail:email,
                content:textbox,
            }
        }).done(function (data) {
            //console.log(data);
            if(data.success){
                $(".input_name").val("");
                $(".input_phone").val("");
                $(".input_email").val("");
                $(".textbox").val("");
                layer.msg('提交成功');
            }
        })
    })
})
//匹配电话正则
function isPhone($poneInput) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    return myreg.test($poneInput);
}
//检查email邮箱
function isEmail(str){
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    return reg.test(str);
}