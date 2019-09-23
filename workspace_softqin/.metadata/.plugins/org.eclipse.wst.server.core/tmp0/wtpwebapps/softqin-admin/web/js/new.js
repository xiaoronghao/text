 baseUrl = "http://47.98.197.158:8080/softqin-admin/";
//const baseUrl = "http://192.168.1.94:8080/softqin-admin/";
$(function () {

    var page;  //分成几页
    $.ajax({
        url:baseUrl+'webNewsInterface/getAllNews',
        dataType:'json',
    }).done(function (data) {
        //console.log(JSON.stringify(data, null,4))
        page=Math.ceil(data.data.length/3);
        $(".new_contBox").css("width",page*1180+"px")
        newList(data);
    })

    //生成新闻列表
    function newList(data) {
        for(var i=0;i<page;i++){
            //console.log(data.data[0].content)


            $bagBox=$("<div>").attr("class","new_itemBox");   //创建大盒子
            //123-----4
            //012-----3
            for(var j=i*3;j<data.data.length;j++){

                var arr=[];
                arr.push(data.data[j])
                var str=JSON.stringify(arr);

                localStorage.setItem(data.data[j].id,str);

                $div=$("<div>").attr("class","new_item").attr("data-id",data.data[j].id);           //新闻列表
                $imgDiv=$("<div>").attr("class","new_itemImg");     //图片盒子
                $img=$("<img>").attr("src",baseUrl+"TP/"+data.data[j].pic).attr("alt","图片");   //图片
                $imgDiv.append($img);
                $contDiv=$("<div>").attr("class","new_itemCont")   //内容盒子
                $titleP=$("<p>").attr("class","new_contTitle").text(data.data[j].title);
                $contSpan=$("<span>").attr("class","new_titleSpan");
                $titleP.append($contSpan);
                $messP=$("<p>").attr("class","new_contMessage").html(data.data[j].introduction);
                $moreSpan=$("<span>").attr("class","new_contMore").text("More");
                $contDiv.append($titleP)
                $contDiv.append($messP);
                $contDiv.append($moreSpan);

                $div.append($imgDiv);
                $div.append($contDiv);
                $bagBox.append($div);
                if((j+1)%3===0){
                    break;
                }
            }
            $(".new_contBox").append($bagBox);
        }
        newItemMove();   //为生成的div添加鼠标滑过事件
        addspan(page);   //根据数据生成底部焦点
    }

    //新闻轮播
    var num=0;     //控制移动多少像素
    $(".new_next").click(function () {               //下一张
        if(num<page-1){
            num+=1;
        }else{
            num=0;
        }
        var movePx=num*-1180+"px";
        $(".new_contBox").animate({"marginLeft":movePx},500);
        $(".new_btn").find("span").eq(num).addClass("new_btnActive").siblings().removeClass("new_btnActive");
    })
    $(".new_pre").click(function () {                   //上一张
        if(num>0){
            num-=1;
        }else{
            num=page-1;
        }
        var movePx=num*-1180+"px";
        $(".new_contBox").animate({"marginLeft":movePx},500);
        $(".new_btn").find("span").eq(num).addClass("new_btnActive").siblings().removeClass("new_btnActive");

    })
    $(".new_btn").on("click","span",function () {           //底部焦点
        var nbSpan=$(".new_btn").find("span");
        //去样式,加样式
        for(var i=0;i<nbSpan.length;i++){
            nbSpan[i].setAttribute("class","new_btnSpan");
        }
        var target=$(event.target);
        target.addClass("new_btnActive");
        //移动
        var ind=nbSpan.index(this);
        num=ind;
        var movePx=ind*-1180+"px";
        $(".new_contBox").animate({"marginLeft":movePx},500);
    })
})

//根据返回数据---创建底部焦点
function addspan(page) {
    for(var i=0;i<page;i++){
        $bspan=$("<span>").attr("class","new_btnSpan");
        $(".new_btn").append($bspan);
    }
    $(".new_btn").find("span").eq(0).addClass("new_btnActive");
}

//鼠标滑过新闻列表事件
function newItemMove() {
    $(".new_itemBox").children().mouseover(function () {
        $(this).find(".new_contTitle").addClass("new_contTitleActive");
        $(this).find(".new_contMore").addClass("newMorActive");
        //跳转页面
        $(this).click(function () {
            var id=$(this).attr("data-id");
            window.location.href="./new_inner.html?ids="+id;
        });
    });
    $(".new_itemBox").children().mouseout(function () {
        $(this).find(".new_contTitle").removeClass("new_contTitleActive");
        $(this).find(".new_contMore").removeClass("newMorActive");
    });
}