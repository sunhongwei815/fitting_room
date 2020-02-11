/**
 * Created by 牟国宏 on 2016/1/29 0029.
 */
$(document).ready(function() {
    //选择购买方式
    $.ajax({
        type: 'post',
        url: 'SourceServletTest?type=queryAllSource',
        success: function(data) {
            var result = JSON.parse(data).root;
            $.each(result,function(i, item){
                $("#input-style").append("<option value='"+ item.source_id +"'>"+ item.source_name +"</option>");
            });
        },
        error: function(error){
            //alert(error);
        }
    });


//验证网址
    $("#input-netAddress").on("blur", function () {
        var url = $.trim($("#input-netAddress").val());
        if (url == "") {
            $(".empty-addr").css('display','block');
            /*$(".empty-addr").css('display', 'none');*/
        } else if(!IsURL(url)){
            $(".empty-addr").css('display', 'none');
            $(".error-addr").css('display', 'block');
        }else{
            $(".empty-addr").css('display', 'none');
            $(".error-addr").css('display', 'none');
            $(".netaddr").css('display', 'none');
        }
    });

//验证描述
    $("#input-discribe").on("blur", function () {
        var dis = $.trim($("#input-discribe").val());
        if (dis == "") {
            $(".error-dis").css('display', 'block');
            /*$(".error-dis").css('display', 'none');*/
        } else {
            $(".error-dis").css('display', 'none');
            $(".pro-dis").css('display', 'none');
        }
    });

    //字数验证
    $("#input-discribe").keyup(function(){

        var text = $("#input-discribe").val();
        var counter = text.length;
        if(counter<100){
            $("#name-word").text(counter);
        }else if(counter>100){
            $(this).val(text.substring(0,100));
            $("#name-word").text($(this).val());
            $("#name-word").text($(this).val().length);
            $("#name-word").css("color","red");
        }

    });

//总体的验证
    $("#btn-submit").on("click", function () {
        var url = $.trim($("#input-netAddress").val());
        dis = $.trim($("#input-discribe").val());
        if (url == "") {
            $(".netaddr").css('display', 'block');
            $("#input-netAddress").focus();
            return false;
        } else if (dis == "") {
            $(".pro-dis").css('display', 'block');
            $("#input-discribe").focus();
            return false;
        }
        $.ajax({
            cache: true,
            type: "POST",
            url:'/WLSYS/Order',
            data:$('#').serialize(),
            success: function(data){
                var result = $(this).eval();
                if(!result){
                    alert("提交成功！");
                }

            }
        });

    });

    function IsURL(urlString)
    {
        regExp = /^((https?|ftp|news):\/\/)?([a-z]([a-z0-9\-]*[\.。])+([a-z]{2}|aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel)|(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))(\/[a-z0-9_\-\.~]+)*(\/([a-z0-9_\-\.]*)(\?[a-z0-9+_\-\.%=&]*)?)?(#[a-z][a-z0-9_]*)?$/
        if (urlString.match(regExp)) {
            return true;
        }
        return false;
    }
});