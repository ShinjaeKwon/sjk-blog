let index ={
    init: function (){
        $("#btn-save").on("click",()=>{
            this.save();
        }); /* bnt-save버튼 이벤트가 생기면 실행할 함수 설정 , on("이벤트", 함수명)*/
    },

    save: function () {
        //alert('user의 save 함수 호출됨');
        let data = {
            userId: $("#userId").val(), //id="userId"의 값을 받아와서 userId
            pwd: $("#pwd").val(),
            nickname: $("#nickname").val(),
            email: $("#email").val()
        }

        //console.log(data);

        $.ajax().done().fail(); // ajax 통신을 이용해서 파라미터들을 json으로 변경 후 insert 요청
    }
}

index.init();