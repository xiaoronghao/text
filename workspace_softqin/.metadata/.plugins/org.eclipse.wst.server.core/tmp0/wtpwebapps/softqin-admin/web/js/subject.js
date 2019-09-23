$(function(){
    //addmap();

    $('.slider_four_in_line').EasySlides({
        'autoplay': true,
        'show': 5
    })


    //轮播
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
          elem: '#top_banner'
          ,width: '100%' //设置容器宽度
          ,height:'785px'
          ,arrow: 'none' //始终显示箭头
          ,anim: 'updown' //切换动画方式
        });
      });




})

// function addmap(){
    
// }