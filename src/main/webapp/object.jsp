<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Computer Vision</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
$( document ).ready(function() {
	  var person = [];
	  var animal = [];
	  var nature = [];
	  var automobile = [];
	  var others = [];
	  function onlyUnique(value, index, self) {
		  return self.indexOf(value) === index;
		}
    console.log( "document loaded" );
    $( ".people" ).click(function() {
      $(".imgs").empty();
  	  let fnl = "";
  	  if(person){
  		person.filter(onlyUnique).forEach(per => {
  			fnl += "<div class=\"column\"><img height=100 width=100 src=\"" + per + "\"/></div>";
  		  });
  		$(".imgs").prepend(fnl);
  	  }
  	});
    $( ".animal" ).click(function() {
    	$(".imgs").empty();
    	let fnl = "";
    	  if(animal){
    		  animal.filter(onlyUnique).forEach(per => {
    			fnl += "<div class=\"column\"><img height=100 width=100 src=\"" + per + "\"/></div>";
    		  });
    		$(".imgs").prepend(fnl);
    	  }
  	});
  $( ".nature" ).click(function() {
	  $(".imgs").empty();
	  let fnl = "";
  	  if(nature){
  		  nature.filter(onlyUnique).forEach(per => {
  			fnl += "<div class=\"column\"><img height=100 width=100 src=\"" + per + "\"/></div>";
  		  });
  		$(".imgs").prepend(fnl);
  	  }
  	});
  $( ".automobile" ).click(function() {
	  $(".imgs").empty();
	  let fnl = "";
  	  if(automobile){
  		automobile.filter(onlyUnique).forEach(per => {
  			fnl += "<div class=\"column\"><img height=100 width=100 src=\"" + per + "\"/></div>";
  		  });
  		$(".imgs").prepend(fnl);
  	  }
  	});
  $( ".others" ).click(function() {
	  $(".imgs").empty();
	  let fnl = "";
  	  if(others){
  		  others.filter(onlyUnique).forEach(per => {
  			fnl += "<div class=\"column\"><img height=100 width=100 src=\"" + per + "\"/></div>";
  		  });
  		$(".imgs").prepend(fnl);
  	  }
  	});
  $.ajax({
	    url: './UrlofPhotos',
	    type: 'GET',
	    success: function(response) {
	    	let category = ['human','person','people','animal','pets','nature','automobile','others'];
	    	let obj = JSON.parse(response);
	    	obj.forEach( vals => {
	    		let ob = vals.split('@');
	    		let lbls = ob[0].toLowerCase();
	    		category.forEach(cats => {
	    			if(lbls.indexOf(cats) > -1){
	    				if(["person","human","people"].includes(cats)){
	    					person.push(ob[1]);
	    				}
	    				else if(["animal","pets"].includes(cats)){
	    					animal.push(ob[1]);
	    				}
	    				else if(["nature"].includes(cats)){
	    					nature.push(ob[1]);
	    				}
	    				else if(["automobile"].includes(cats)){
	    					automobile.push(ob[1]);
	    				}
	    				else {
	    					others.push(ob[1]);
	    				}
	    			}
	    		})
	    	});
	    },
	    error:function(error){
	    	console.log(error);
	    } 
	});
});
</script>
<style>
  .clr {
  color: red;
  }
  .column {
  float: left;
  padding: 5px;
}

/* Clear floats after image containers */
.rw::after {
  content: "";
  clear: both;
  display: table;
}
.bdy {
	background-color: blue;
}
.ctg {
	color: white;
}
</style>
</head>
<body class="bdy">
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
			<center class="clr">
			<h1 class="ctg">Category</h1>
			<h3 class="people">People</h3>
			<h3 class="animal">Animal</h3>
			<h3 class="nature">Nature</h3>
			<h3 class="automobile">Automobiles</h3>
			<h3 class="others">Others</h3>
			</center>
			</div>
			<div class="col-sm-10 imgs">
			</div>
		</div>
	</div>
</body>
</html>