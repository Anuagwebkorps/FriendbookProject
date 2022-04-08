function Myfun()
	{
		const cars = ["HmtQo2R", "PtA8Eb", "SrYQ9ORT","Rx6TNR","ORTSrYQ9","TSrtA8Eb"];

var v1=document.getElementById('kep1').value;		
 var v2=document.getElementById('kep2').value;
 if(v1==v2)
 	 {
        document.getElementById('msg').innerHTML="correct";
 	 }
 	 else
 	 {
 	 	let x = Math.floor((Math.random() * 5) + 1);
 	 	console.log(x);
        document.getElementById('kep1').value=cars[x];	
 	 	document.getElementById('msg').innerHTML="incorrect Kepcha";
 	 }	
}