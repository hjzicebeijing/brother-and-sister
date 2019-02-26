$("img.seller_img").click(function(){
    var parent=$(this).parent().parent();
    selectSeller(parent);
});
function selectSeller(parent){
    var sellerName=parent.find("span").eq("0").text();
    var newWindow="/food/main/"+sellerName;
    window.open(newWindow);
}