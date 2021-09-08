let index ={
    //여기 this값과
    init: function (){
        $("#btn-save").on("click",()=>{ //function(){}, () => {} this를 바인딩 , function을 사용하면 직접 바인딩 해줘야 한다.
            this.save(); //this값을 맞추기위해 바인딩 하였다.
        }); /* bnt-save버튼 이벤트가 생기면 실행할 함수 설정 , on("이벤트", 함수명)*/
        /*$("#btn-login").on("click",()=>{ //function(){}, () => {} this를 바인딩 , function을 사용하면 직접 바인딩 해줘야 한다.
            this.login(); //this값을 맞추기위해 바인딩 하였다.
        });*/
    },

    save: function () {
        //alert('user의 save 함수 호출됨');
        let data = {
            userId: $("#userId").val(), //id="userId"의 값을 받아와서 userId
            password: $("#password").val(),
            nickname: $("#nickname").val(),
            email: $("#email").val()
        };
        //console.log(data);
        //ajax 호출시 default가 비동기 호출
        //ajax 통신을 이용해서 파라미터들을 json으로 변경 후 insert 요청
        //ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오즈젝트로 변환해준다.
        $.ajax({ //회원가입 수행 요청
            type: "POST",
            url: "/auth/joinProc",
            data: JSON.stringify(data), // 위에 data를 JSON 타입으로 변경(자바는 자바스크립트 코드를 이해하지 못한다.)
            contentType: "application/json; charset=utf-8", //자바에게 Json 데이터이라고 알려준다. (body 데이터가 어떤 타입인지 (MIME))
            dataType: "json"//요청을 서버로 해서 응답이 왔을때 , 디폴트값은 문자열(생긴게 json 이라면 => javascript 오브젝토로 변경해줌, 즉 응답의 결과 : JSON 타입
        }).done(function (resp){ //정상일 시 실행, resp = UserApiController에서 결과값
            alert("회원가입이 완료되었습니다.");
            console.log(resp);
            location.href="/";
        }).fail(function (){ //실패할 시 실행
            alert(JSON.stringify(error));
        });
    },

    /*login: function () {
        //alert('user의 save 함수 호출됨');
        let data = {
            userId: $("#userId").val(),
            password: $("#password").val()
        };

        $.ajax({
            type: "POST",
            url: "/api/user/login",
            data: JSON.stringify(data), // 위에 data를 JSON 타입으로 변경(자바는 자바스크립트 코드를 이해하지 못한다.)
            contentType: "application/json; charset=utf-8", //자바에게 Json 데이터이라고 알려준다. (body 데이터가 어떤 타입인지 (MIME))
            dataType: "json"//요청을 서버로 해서 응답이 왔을때 , 디폴트값은 문자열(생긴게 json 이라면 => javascript 오브젝토로 변경해줌, 즉 응답의 결과 : JSON 타입
        }).done(function (resp){ //정상일 시 실행, resp = UserApiController에서 결과값
            alert("로그인이 완료되었습니다.");
            console.log(resp);
            location.href="/";
        }).fail(function (){ //실패할 시 실행
            alert(JSON.stringify(error));
        });
    }*/
}

index.init();

/* 회원가입시 Ajax를 사용하는 2가지 이유
    1. 요청에 대한 응답을 html이 아닌 Data(Json)를 받기 위해서이다.
    2. 비동기 통신을 하기 위해서이다.
    비동기 : 절차적으로 처리하지만 , 순서에 상관없이 처리한다.
 */