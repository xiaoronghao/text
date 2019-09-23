 baseUrl = "http://47.98.197.158:8080/softqin-admin/";
//const baseUrl = "http://192.168.1.94:8080/softqin-admin/";
$(function () {
        var ids=GetRequest();
        var proObjStr = localStorage.getItem(ids.ids);
        var proObj = JSON.parse(proObjStr);
        var times = timestampToTime(proObj[0].publish_date);
        $(".newInner_title").find("span").text(proObj[0].title);
        $(".newInner_cont").find("h2").text(proObj[0].title);
        $(".newInner_cont").find("p").html(proObj[0].content);
        $(".newInner_contImg").find("img").attr("src",baseUrl+"TP/"+proObj[0].pic);
        $(".span_timer").text(times);


})


 function GetRequest() {
        var url = location.search; //获取url中"?"符后的字串
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            strs = str.split("&");
            for(var i = 0; i < strs.length; i ++) {
                theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }
    function timestampToTime(timestamp) {
        var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate() + ' ';

        return Y+M+D;
    }