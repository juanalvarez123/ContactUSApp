function validationForm(){
	var nombre = document.getElementById("name").value;	
	var apellido = document.getElementById("lastName").value;
	var correoElectronico = document.getElementById("email").value;
	var pais = document.getElementById("country").value;
	var comentarios = document.getElementById("message").value;
	
	if( nombre == ""){
		alert("Please, write your name.");
		return false;
	}
	if( apellido == ""){
		alert("Please, write your last name.");
		return false;
	}
	if( !(/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)/.test(correoElectronico))){
		alert("Please, write your e-mail.");
		return false;
	}
	if( pais == ""){
		alert("Please, write your country.");
		return false;
	}
	if(comentarios == "" || comentarios.length == 0 || /^\s+$/.test(comentarios)){
		alert("Please, write your comments.");
		return false;		
	}
}