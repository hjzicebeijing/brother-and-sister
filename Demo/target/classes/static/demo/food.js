var qrCodeUrl;
var payId;
$("#pay").click(function(){
    submitOrder();
});
function submitOrder(){
    var subject=sellerName;
    var total_amount=$("span.total_amount").text();
    $.ajax({
        type:"post",
        url:"/pay/main",
        data:{
            "subject":subject,
            "total_amount":total_amount
        },
        success:function(msg){
            qrCodeUrl=msg.qrCodeUrl;
            payId=msg.payId;
            $("#qrCodeImage").qrcode({
                render: 'canvas',
                width:'256',
                height:'256',
                background:'#FFFFFF',
                foreground:'#000000',
                text:qrCodeUrl
            });
            document.getElementById('light').style.display='block';
            document.getElementById('fade').style.display='block';
            payDisplay();
        }
    });
}
function payDisplay(){
    $.ajax({
        type:"post",
        url:"/pay/notify",
        data:{
            "payId":payId
        },
        success:function(r){
            if(r.code==0){
                $.modal.msg("支付成功");
                successReset();
            }
            else{
                $.modal.msg("支付失败");
            }
        }
    });
}
function successReset(){
    $("div.addOrder").remove();
    $("span.total_amount").text("0");
    list.clear();
    setTimeout(function(){
        document.getElementById('light').style.display='none';
        document.getElementById('fade').style.display='none';
        $("#qrCodeImage").empty();
    },3000);
}
let list=new Set();
$("img.addButton").click(function(){
    var parent=$(this).parent().parent().parent();
    var subject=parent.find("span").eq("0").text();
    var amount=parent.find("span").eq("1").text();
    var text_top="<div class='addOrder'><li>";
    var text_subject="<span class='order_opt_text order_opt_subject'>"+subject+"</span>";
    var text_middle="<button class='order_btn order_btn_left' >+</button>"+
        "<span class='order_opt_text order_opt_num'>1</span>"+
        "<button class='order_btn order_btn_right' >-</button>";
    var text_bottom="<span class='order_opt_text order_opt_amount'>"+amount+"</span></li></div>";
    if(list.has(subject)){
        var parent=$("span.order_opt_subject").filter(function(){return $(this).text()==subject}).parent();
        subjectAdd(parent);
    }
    else{
        $("#total").prepend(text_top+text_subject+text_middle+text_bottom);
        list.add(subject);
        totalAmount();
    }
});
function totalAmount(){
    var amount=0.0;
    list.forEach(function(element,sameElement,set){
        var parent=$("span.order_opt_subject").filter(function(){return $(this).text()==element}).parent();
        var num=parseInt(parent.find("span").eq("1").text());
        var price=parseFloat(parent.find("span").eq("2").text());
        amount=amount+num*price;
    });
    $("span.total_amount").text(amount.toFixed(1));
}
function subjectAdd(parent){
    var temp=parseInt(parent.find("span").eq("1").text())+1;
    parent.find("span").eq("1").text(temp);
    totalAmount();
}
function subjectMinus(parent){
    var temp=parseInt(parent.find("span").eq("1").text())-1;
    if(temp==0){
        var subject=parent.find("span").eq("0").text();
        list.delete(subject);
        parent.parent().remove();
    }
    else{
        parent.find("span").eq("1").text(temp);
    }
    totalAmount();
}
$(document.body).on("click","button.order_btn_left",function(){
    var parent=$(this).parent();
    subjectAdd(parent);
});
$(document.body).on("click","button.order_btn_right",function(){
    var parent=$(this).parent();
    subjectMinus(parent);
});
