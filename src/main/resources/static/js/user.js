
let index = {
    init:function(){
        $("#btn-save").on("click",()=>{
            this.save();
        });

    },
    save:function(){
        let data = {
        	username: $('#username').val(),
        	password: $('#password').val(),
        	email: $('#email').val(),
        	
        };
        $.ajax({
        	type:"POST",
        	url:"/auth/joinProc",
        	data:JSON.stringify(data), //http body 데이터
        	contentType:"application/json;charset=utf-8", //body데이터가 어떤 타입인지  
        	dataType:"json", //서버에서 리턴되는 데이터 타입
        }).done(function(response){
        	//dataType 덕분에 response는 json으로 파싱된다.
        	alert("회원가입 완료되었습니다.");
//        	alert(response);
        	location.href = "/"
        }).fail(function(error){
        	alert(error);
        });
    },

};

index.init();