let index = {
	init : function() {
		$("#btn-save").on("click", () => {
			this.save();
		})
	},
	save : function() {
		let data = {
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val(),
		}

		$.ajax({
			type: "POST",
			url : "/blog/api/user",
			data: JSON.stringify(data),
			contentType : "application/json;charset=utf-8", //body데이터가 어떤타입인지
			dataType : "json" //서버에서 응답이 json이라면 Object로 바꿔줌
		}).done(function(resp){
			alert("회원가입이 완료되었습니다.");
			console.log(resp);			
			//location.href = "/blog";
		}).fail(function(error){
			alert("error");			
			alert(JSON.stringify(error));			
		});
	}
}

index.init();