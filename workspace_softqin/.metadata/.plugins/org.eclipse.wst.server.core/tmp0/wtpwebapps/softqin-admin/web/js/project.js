 baseUrl = "http://47.98.197.158:8080/softqin-admin/";
//const baseUrl = "http://192.168.1.94:8080/softqin-admin/";
$(function () {
    //项目列表菜单选中效果
    $(".project_menu").on("click","span",function (event) {
        var pspan=$(".project_menu").find("span");
        for(var i=0;i<pspan.length;i++){
            pspan[i].setAttribute("class","");
        }
        var target=$(event.target);
        target.addClass("project_menuActive");
    });

    //点击不同系列获取不同的内容
    $(".project_menu").on("click","span",function (event) {
        $(".project_itemBox").empty();  //先清空
        var foo=$(this).attr("data-id");
        //如果是磐邑系列
        if(foo === 'c76c91628a294fadae27836705dacb41'){
            request2(foo);
        }else{
            request(foo);
        }
    })


    var page;   //page用于计算底部焦点的个数
    var num=0;  //num用于控制盒子左边距要移动的距离

    //获取所有系列
    $.ajax({
        url:baseUrl+"webSeriesInterface/getAllSeries",
        type:"get",
        dataType:'json',
    }).done(function (data) {

        for(var i=0;i<data.data.length;i++){
            $span=$("<span>").text(data.data[i].name).attr("data-id",data.data[i].id);

            $(".project_menu").append($span);
            $(".project_menu").find("span").eq(0).addClass("project_menuActive");

        }
        request(data.data[0].id)   //打开页面展示第一个系列
    })


    //获取数据
    function request(ind) {
        $.ajax({
            url:baseUrl+"webProjectInterface/getProjectBySeriesId",
            type:"get",
            dataType:'json',
            data:{
                seriesId:ind
            }
        }).done(function (data) {
            //console.log(JSON.stringify(data, null,4))
            $(".project_itemBox").css("width",data.data.length*399+"px");    //改变内容盒子宽度，保证能容下获取的内容
            $(".project_itemBox").css("margin-left",0);     //将盒子左边距重置为0
            num=0;           //将num重置为0
            project(data);
            page=data.data.length;

        })
    }
    //获取磐邑系列的固定四个项目
    function request2(ind) {
        $.ajax({
            url:baseUrl+"webProjectInterface/getProjectBySeriesId",
            type:"get",
            dataType:'json',
            data:{
                seriesId:ind
            }
        }).done(function (data) {
            //console.log(JSON.stringify(data, null,4))
            $(".project_itemBox").css("width",data.data.length*399+"px");    //改变内容盒子宽度，保证能容下获取的内容
            $(".project_itemBox").css("margin-left",0);     //将盒子左边距重置为0
            num=0;           //将num重置为0
            project2(data.data[0]);
            project2(data.data[1]);
            project2(data.data[2]);
            project2(data.data[3]);
            move2();
            addSpan(data.data.length);
            page=data.data.length;

        })
    }


    //轮播
    $(".project_next").click(function () {          //下一张
        if($(".project_itemBox").is(":animated")){
            return;
        }
        var s=Math.ceil(page/3);
        if(num<s-1){
            num+=1;
        }else{
            num=0;
        }
        var movePx=num*-1197+"px";
        $(".project_itemBox").animate({"marginLeft":movePx},700);
        $(".project_btn").find("span").eq(num).addClass("project_btnActive").siblings().removeClass("project_btnActive");
    })
    $(".project_pre").click(function () {           //上一张
        if($(".project_itemBox").is(":animated")){
            return;
        }
        var s=Math.ceil(page/3);
        if(num>0){
            num-=1;
        }else{
            num=s-1;
        }
        var movePx=num*-1197+"px";
        $(".project_itemBox").animate({"marginLeft":movePx},700);
        $(".project_btn").find("span").eq(num).addClass("project_btnActive").siblings().removeClass("project_btnActive");
    })
    $(".project_btn").on("click","span",function (event) {      //底部焦点
        var pbSpan=$(".project_btn").find("span");
        //去样式
        for(var i=0;i<pbSpan.length;i++){
            pbSpan[i].setAttribute("class","project_btnSpan");
        }
        var target=$(event.target);
        target.addClass("project_btnActive");
        //移动
        var ind=pbSpan.index(this);
        num=ind;
        var movePx=ind*-1197+"px";
        $(".project_itemBox").animate({"marginLeft":movePx},500);
    })
})
// //获取URL携带的参数
// function GetRequest() {
//     var url = location.search; //获取url中"?"符后的字串
//     var theRequest = new Object();
//     if (url.indexOf("?") != -1) {
//         var str = url.substr(1);
//         strs = str.split("&");
//         for(var i = 0; i < strs.length; i ++) {
//             theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
//         }
//     }
//     return theRequest;
// }



//根据返回数据创建项目列表
function project(data) {


    for(var i=0;i<data.data.length;i++){
        var arr=[];
        arr.push(data.data[i])
        var str=JSON.stringify(arr);


        localStorage.setItem(data.data[i].id,str);


        $divBox=$("<div>").attr("class","project_item").attr("data-id",data.data[i].id);
        $divimg=$("<div>").attr("class","project_img");
        $divBox.append($divimg);
        $img=$("<img>").attr("src",baseUrl+"TP/"+data.data[i].pic);
        $divimg.append($img);
        $ptitle=$("<p>").attr("class","project_title").text(data.data[i].name);
        //$pmessage=$("<p>").attr("class","project_message").html(data.data[i].content);
        $divBox.append($ptitle);
        //$divBox.append($pmessage);
        $divhr=$("<div>").attr("class","project_hr");
        $divBox.append($divhr);
        $span=$("<span>").text("more");
        $divBox.append($span);
        $moreimg=$("<img>").attr("src","image/arrows.png").attr("alt","arrows");
        $span.append($moreimg);

        $(".project_itemBox").append($divBox);
    }
    move();
    addSpan(data.data.length);
}

function project2(data) {

        $divBox=$("<div>").attr("class","project_item").attr("data-id",data.id)
        $divimg=$("<div>").attr("class","project_img");
        $divBox.append($divimg);
        $img=$("<img>").attr("src",baseUrl+"TP/"+data.pic);
        $divimg.append($img);
        $ptitle=$("<p>").attr("class","project_title").text(data.name);
        //$pmessage=$("<p>").attr("class","project_message").html(data.data[i].content);
        $divBox.append($ptitle);
        //$divBox.append($pmessage);
        $divhr=$("<div>").attr("class","project_hr");
        $divBox.append($divhr);
        $span=$("<span>").text("more");
        $divBox.append($span);
        $moreimg=$("<img>").attr("src","image/arrows.png").attr("alt","arrows");
        $span.append($moreimg);

        $(".project_itemBox").append($divBox);
   
}
//根据返回的数据  创建底部焦点
function addSpan(page) {
    var s=Math.ceil(page/3);
    $(".project_btn").empty();
    for(var i=0;i<s;i++){
        $bSpan=$("<span>").attr("class","project_btnSpan");
        $(".project_btn").append($bSpan);
    }
    $(".project_btn").find("span").eq(0).addClass("project_btnActive");
}

//鼠标滑过project_item，样式改变
function move() {
    $(".project_itemBox").children().mouseover(function () {
        this.setAttribute("class","project_item itemActive");
        $(this).find(".project_title").addClass("titleActive");
        $(this).find("span").addClass("moreActive");
        //more 跳转页面
        $(this).click(function () {
            //console.log(this);
            var id=$(this).attr("data-id")
            //console.log($(this).attr("data-id"))
            window.location.href="./project_inner.html?ids="+id;
        });
    })
    $(".project_itemBox").children().mouseout(function () {
        this.setAttribute("class","project_item");
        $(this).find(".project_title").removeClass("titleActive");
        $(this).find("span").removeClass("moreActive");
    })
}
function move2() {
    $(".project_itemBox").children().mouseover(function () {
        this.setAttribute("class","project_item itemActive");
        $(this).find(".project_title").addClass("titleActive");
        $(this).find("span").addClass("moreActive");
        //more 跳转页面
        $(this).click(function () {
            //console.log(this);
            var id=$(this).attr("data-id")
            if(id === '93c3112929034ad2949fc29eb542731e'){
                window.location.href="./bagn.html";
            }else if(id === '4866c6f2ff2044b68a35d6fa4c9037e4'){
                window.location.href="./subject.html";
            }else if(id === 'a09929b5d1324cc081b8c8b62b9941dc'){
                window.location.href="./junling.html";
            }else{
                window.location.href="./yuandong.html";
            }
            //console.log($(this).attr("data-id"))
           
        });
    })
    $(".project_itemBox").children().mouseout(function () {
        this.setAttribute("class","project_item");
        $(this).find(".project_title").removeClass("titleActive");
        $(this).find("span").removeClass("moreActive");
    })
}
