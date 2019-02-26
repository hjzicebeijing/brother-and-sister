
$("#code").qrcode({
    render: 'canvas',
    width:'256',
    height:'256',
    background:'#FFFFFF',
    foreground:'#000000',
    text:qrCodeUrl
});
$.ajax({
    type:"post",
    url:"/pay/notify",
    data:{
        "payId":payId
    },
    success:function(r){
        if(r.code==0){
            alert("支付成功");
        }
        else{
            alert("支付失败");
        }
    }
});

