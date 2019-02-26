function foodadd(){
    var formData=new FormData($("#foodAddForm")[0]);
    $.ajax({
        type:"post",
        contentType:false,
        url:"/food/add",
        data:formData,
        async:false,
        cache:false,
        processData:false,
        success:function(r) {
            if (r.code == 0) {
                $.modal.msg("添加成功");
                setTimeout(function () {
                    $("#foodAddForm").reset();
                }, 3500);
            }
            else {
                alert(r.msg);
            }
        },
    });
}
$("#btnSubmit").click(function(){
    foodadd();
})
$("#btnBack").click(function(){
    location.href="/index";
})


