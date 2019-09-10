function valid()
{
	var n,p,f3=0,f1=0,f2=0,name,passw;
	var stdate = document.editMovie.dateOfLaunch.value;
	name=document.editMovie.title.value;
	passw=document.editMovie.price.value;
	n=name.trim();
	p=passw.trim();
	if(n=="")
	alert("Title cannot be empty");
	else if(n.length<2 || n.length>65)
	alert("Title length should be between 2-65");
	else
	f1=1;
	if(p=="")
	alert("Gross($) cannot be empty");
	 else if(/^[0-9]*$/.test(p)==false)
	alert("Gross($) should be number");
	else
	f2=1;
	if(stdate=="")
	alert("Date of launch is required");
	else
	f3=1;
	if(f1&&f2&&f3)
	window.location.href = "edit-movie-status.html";
}