let xhr;
let checkFirst = loopSend = false;
let kbs;

function sijak(){
	if(checkFirst === false){
		kbs = setTimeout("sendkeyword()", 800);
		loopSend = true;	
	}
}

function sendkeyword(){
	//let keyWord = document.querySelector("#kbs").value();
	let keyWord = document.frm.keyword.value;
	// console.log(keyWord);
	
	if (keyWord === ""){
		hide();
	}else{
		xhr = new XMLHttpRequest();
		let para = "keyword=" + keyWord;
		xhr.open("get", "jq8.jsp?" + para, true);
		xhr.onreadystatechange = function() {
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					// process();
				}
			}
		}
		xhr.send(null);
	}
	clearTimeout(kbs); // setTimeout 설정 해제 
}

function process(){
	let resultData = xhr.responseText;
	console.log(resultData);
}

function hide(){
	document.querySelector("#suggest").style.display="none";
}

function show(){
	document.querySelector("#suggest").style.display="";
}
