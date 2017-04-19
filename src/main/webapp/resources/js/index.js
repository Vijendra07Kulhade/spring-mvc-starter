

$("#addBtn").on('click',function(){
    var requestObject = [{"product_Name":"One Product","descripction":"Essentials","category":null,"price":"100.00","mfg_Date":null,"image":null},
    {"product_Name":"two Product","descripction":"Essentials 2","category":null,"price":"120.00","mfg_Date":null,"image":null}];
    $.ajax({
            type : 'POST',
            url : "services/product",
            cache : false,
            contentType:"application/json;charset=utf-8",
            data : JSON.stringify(requestObject),//json-String**
            dataType :"application/json;charset=utf-8",
            success : function(data, textStatus) {
                console.log("POST success"+data);
               /* $("#ajaxContent").html(data);*/
            },
            error : function(request, status, error) {
                console.log("failed" + error);
            }
        });
});