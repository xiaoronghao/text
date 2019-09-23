 baseUrl = "http://47.98.197.158:8080/softqin-admin/";
//const baseUrl = "http://192.168.1.94:8080/softqin-admin/";
$(function () {

    //控制项目介绍隐藏list的显示和隐藏
    $("#project_introduce").mouseover (function () {
        $(".list").addClass("displayNone");
        $(".project_list").removeClass("displayNone");
    }).mouseout(function () {
        var timer=setTimeout(function () {
            $(".project_list").addClass("displayNone");
        },300);
        $(".project_list").mouseover(function () {
            clearTimeout(timer);
            $("#project_introduce").addClass("checked");
            $(".project_list").removeClass("displayNone");
        }).mouseout(function () {
            $("#project_introduce").removeClass("checked");
            $(".project_list").addClass("displayNone");
        })
    });

    $.ajax({
        url:baseUrl+"webSeriesInterface/getAllSeries",
        dataType:'json',
    }).done(function (data,status,xhr) {
        //console.log(JSON.stringify(data, null,4)
        listData(data);

    })

})

function listData(data) {
    //console.log(111)
    //console.log(data.data);

    $.each(data.data,function (i,item) {
        //var $dl=$("<dl>").attr("data-id",item.id);
        var $dl=$("<dl>");
        var $h2=$("<h2>");

        var $a=$("<a>").attr("href","project.html").text(item.name);
        $h2.append($a);
        $dl.append($h2);
        if(item.name === "磐邑系列"){
            $.ajax({
                url:baseUrl+'webProjectInterface/getProjectBySeriesId',
                dataType:'json',
                data:{
                    seriesId:item.id
                }
            }).done(function (datas) {
                    var $dt1=$('<dt>');
                    var $dta1=$("<a>").attr("href","bagn.html").text(datas.data[0].name);
                    $dt1.append($dta1);
                    
                    var $dt2=$('<dt>');
                    var $dta2=$("<a>").attr("href","subject.html").text(datas.data[1].name);
                    $dt2.append($dta2);

                    var $dt3=$('<dt>');
                    var $dta3=$("<a>").attr("href","junling.html").text(datas.data[2].name);
                    $dt3.append($dta3);

                    var $dt4=$('<dt>');
                    var $dta4=$("<a>").attr("href","yuandong.html").text(datas.data[3].name);
                    $dt4.append($dta4);

                    $dl.append($dt1);
                    $dl.append($dt2);
                    $dl.append($dt3);
                    $dl.append($dt4);
    
            })
        }else{
            $.ajax({
                url:baseUrl+'webProjectInterface/getProjectBySeriesId',
                dataType:'json',
                data:{
                    seriesId:item.id
                }
            }).done(function (datas) {
                for(var j=0;j<datas.data.length;j++){
                    var arr=[];
                    arr.push(datas.data[j])
                    var str=JSON.stringify(arr);
    
                    localStorage.setItem(datas.data[j].id,str);
    
                    var $dt=$('<dt>');
                    var $dta=$("<a>").attr("href","project_inner.html?ids="+datas.data[j].id).text(datas.data[j].name);
                    $dt.append($dta);
                    $dl.append($dt);
                }
    
            })
        }

        $(".project_list").append($dl)
    })
}