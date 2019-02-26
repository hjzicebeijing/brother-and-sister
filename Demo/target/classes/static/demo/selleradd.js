function selleradd(){
    var formData=new FormData($("#sellerAddForm")[0]);
    $.ajax({
        type:"post",
        contentType:false,
        url:"/seller/registe",
        data:formData,
        async:false,
        cache:false,
        processData:false,
        success:function(r) {
            if (r.code == 0) {
                $.modal.msg("注册成功");
                setTimeout(function () {
                    location.href = "/index";
                }, 3500);
            }
            else {
                alert(r.msg);
            }
        },
    });
}
$("#btnSubmit").click(function(){
    selleradd();
})


