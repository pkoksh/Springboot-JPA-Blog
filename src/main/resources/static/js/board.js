
let index = {
    init:function(){
        $("#btn-save").on("click",()=>{
            this.save();
        });

    },
    save:function(){
        let data = {
        	title: $('#title').val(),
        	content: $('#content').val(),
        };
        $.ajax({
        	type:"POST",
        	url:"/api/board",
        	data:JSON.stringify(data), //http body 데이터
        	contentType:"application/json;charset=utf-8", //body데이터가 어떤 타입인지  
        	dataType:"json", //서버에서 리턴되는 데이터 타입
        }).done(function(response){
        	//dataType 덕분에 response는 json으로 파싱된다.
        	alert("글쓰기가 완료되었습니다.");
//        	alert(response);
        	location.href = "/"
        }).fail(function(error){
        	alert(error);
        });
    },

};

index.init();