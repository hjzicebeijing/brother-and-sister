var flag=1;
function check(id){
    var input=document.getElementById(id).value;
    var name=id+"Check";
    var check=document.getElementById(name);
    if(input=="")check.innerHTML="不能为空";
    else{
        $.ajax({
            type:"post",
            url:"/registe/check",
            data:{
                name:name,
                value:input
            },
            success:function(r){
                if(r.code==0){
                    check.innerHTML="ok";
                    flag=1;
                }else{
                    check.innerHTML=r.msg;
                    flag=2;
                }
            }
        });
    }
}
function registe(){
    var formData=new FormData($("#userAddForm")[0]);
    if(flag==1){
        $.ajax({
            type:"post",
            contentType:false,
            url:"/registe/result",
            data:formData,
            async:false,
            cache:false,
            processData:false,
            success:function(r){
                if(r.code==0){
                    $.modal.msg("注册成功");
                    setTimeout(function(){
                        location.href="/login";
                    },3500);
                }
                else{
                    alert(r.msg);
                }
            },
        });
    }
    else{
       alert("attention");
    }
}
function passwordCheck(){
    var password=$.common.trim($("input[name='password']").val());
    var passwordagain=$.common.trim($("input[name='passwordAgain']").val());
    if(password!=passwordagain){
        document.getElementById("passwordCheck").innerHTML="密码不同";
        flag=2;
    }
    else{
        document.getElementById("passwordCheck").innerHTML="ok";
        flag=1;
    }
}
$("#btnSubmit").click(function(){
        registe();
})


