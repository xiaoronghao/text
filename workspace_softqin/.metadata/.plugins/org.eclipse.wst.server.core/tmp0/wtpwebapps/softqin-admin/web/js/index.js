 baseUrl = "http://47.98.197.158:8080/softqin-admin/";
$(function () {

    $(".index_projectItemBox").children().mouseenter(function () {
        this.setAttribute("class","index_projectItem index_pItemActive");
    })
    $(".index_projectItemBox").children().mouseleave(function () {
        this.setAttribute("class","index_projectItem");
    })

    $.ajax({
        url:baseUrl+'webPictureInterface/getPictureByType',
        dataType:'json',
         data:{
             type:0
         }
    }).done(function(data){
        bannerImg(data);
        //ruanQin(data);

    })
    //轮播图片
    function bannerImg(data){
        for(var i=0;i<data.data.length;i++){
            //console.log(data.data[i].pic)
            $itemdiv=$("<div>");
            $itemimg=$("<img>").attr("src",baseUrl+"TP/"+data.data[i].pic);
            $itemdiv.append($itemimg);
            $(".banner_item").append($itemdiv);
        }
        bannerMove();
    }
    //软秦系列   ！！！！
    function ruanQin(data) {
    	//console.log(data.data);
        var str="";
        for(var i=0;i<data.data.length;i++){
            if(i%2===0){
                str+='<div class="itemBox" data-id="'+data.data[i].id+'">'
                str += '<div class="index_projectItem" >';
                str += '<p class="index_itemTitle index_locTop">' + data.data[i].name + '</p>';
                str+='<p class="index_itemExplain"></p>';
                str+='<p class="index_itemExplain"></p>';
                str+='<img src="'+baseUrl+'TP/'+data.data[i].pic+'" alt="item">';
                str += '</div>';
                str+= '</div>';
            }else {http://192.168.1.94:8080/softqin-admin/web/new.html
                str+='<div class="itemBox" data-id="'+data.data[i].id+'">'
                str+= '<div class="index_projectItem">';
                str+='<img src="'+baseUrl+'TP/'+data.data[i].pic+'" alt="item">';
                str+='<p class="index_itemExplain"></p>';
                str+='<p class="index_itemExplain"></p>';
                str+='<p class="index_itemTitle index_locTop">'+data.data[i].name+'</p>';
                str+= '</div>';
                str+= '</div>';
            }
        }
        $(".index_projectItemBox").html(str);
        move();
    }
    function move() {
        $(".index_projectItemBox").children().mouseenter(function () {
            //var that=this;
            $(this).find("div").attr("class","index_projectItem index_pItemActive layui-anim layui-anim-scale");
           // this.setAttribute("class","index_projectItem index_pItemActive layui-anim layui-anim-scale");
            var ids=$(this).attr("data-id");
             request(ids);
        })
        $(".index_projectItemBox").children().mouseleave(function () {
            $(this).find("div").attr("class","index_projectItem");

            // this.setAttribute("class", "index_projectItem");
        })

    }
    //根据id获取系列
    function request(ind) {
        $.ajax({
            url:baseUrl+"webSeriesInterface/getSeriesById",
            type:"get",
            dataType:'json',
            data:{
                seriesId:ind
            }
        }).done(function (data) {
            console.log(data);
            onmove(data);
        })
    }
    function onmove(data) {
        $(".iContent").html(data.data[0].content);
    }

    $.ajax({
        url:baseUrl+"webSeriesInterface/getAllSeries",
        type:"get",
        dataType:'json',
    }).done(function (data) {
        //console.log(data);
        //for(var i=0;i<data.data.length;i++){
            //ruanQin(data);
        //}
        ruanQin(data);
    })

    $.ajax({
        url:baseUrl+'webPictureInterface/getPictureByType',
        dataType:'json',
        data:{
            type:1
        }
    }).done(function(data,status,xhr){

       $(".iAbout_img").attr("src",baseUrl+"/TP/"+data.data[0].pic)

    })

    function bannerMove() {
        layui.use('carousel', function(){
            var carousel = layui.carousel;
            //建造实例
            carousel.render({
                elem: '#test1'
                ,width: '100%' //设置容器宽度
                ,height:'750px'
                ,arrow: 'always' //始终显示箭头
                //,anim: 'updown' //切换动画方式
            });
        });
    }

})