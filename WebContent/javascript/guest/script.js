/**
 * 
 */

// public 반환형 함수명 (파라미터){} --> 자바 기본 함수

function deleteCheck(root, num){ // 자바스크립트 파라미터의 자료형은 모두 var
	var url=root+"/guest/delete.do?num="+num;
	//alert(url); 
	var value = window.confirm("정말 삭제하겠습니까?");
	//alert(value); -->true
	
	if(value==true){
		location.href=url;
	}
}

function updateCheck(root, num){
	var url= root + "/guest/update.do?num="+num;
	//alert(url);
	location.href=url;
}