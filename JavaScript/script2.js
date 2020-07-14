function fnChangeData(){
	var element = document.getElementById("para1");
	element.innerHTML = element.innerHTML+"<span>Hello From Script</span>";
}

function something(){
	document.getElementById("txtName").style.color = "Blue";
	console.log(document.getElementById("txtName").value);
}