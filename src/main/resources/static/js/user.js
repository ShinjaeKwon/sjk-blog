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

/* 회원가입시 Ajax를 사용하는 2가지 이유
    1. 요청에 대한 응답을 html이 아닌 Data(Json)를 받기 위해서이다.
    2. 비동기 통신을 하기 위해서이다.
    비동기 : 절차적으로 처리하지만 , 순서에 상관없이 처리한다.
 */