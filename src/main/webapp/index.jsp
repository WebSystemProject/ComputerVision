<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script async src="https://www.googletagmanager.com/gtag/js?id=UA-195586879-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-195586879-1');
</script>

<meta charset="UTF-8">
<title>Facebook App</title>
<style>
.container {
   width=1140px;
   margin: 100px auto 20px 100px;
}
#status{
margin: 20px auto 20px 100px;
}
#theinfo
{
margin: 20px auto 20px 100px;
}
.innercontainer
{
margin: 20px auto 20px 100px;
}

</style>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
</head>
<body>

<script>

function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
  //  console.log('statusChangeCallback');
   // console.log(response);                   // The current login status of the person.
    if (response.status === 'connected') {   // Logged into your webpage and Facebook.
	 //   console.log('Token for login: ' + response.authResponse.accessToken);
    	testAPI();  
    }
    else if (response.status === 'not_authorized') {
        // The person is logged into Facebook, but not your app.
        document.getElementById('status').innerHTML = 'Please log ' +  'into this app.';
	}
    else {
        // The person is not logged into Facebook, so we're not sure if
        // they are logged into this app or not.
        document.getElementById('status').innerHTML = 'Please log ' +'into Facebook.';
  	}
  }
  
function checkLoginState() {               // Called when a person is finished with the Login Button.
   
	//FB.getLoginStatus(function(response){
	 FB.login(function(response)		{   // See the onlogin handler
      statusChangeCallback(response);
    });

	 FB.api(
			  '/me',
			  'GET',
			  {"fields":"name, gender, email, friends, albums{photos{images}}"},
			  function(response) {
				  if (response && !response.error_message) {
				   //   alert('Getting photo links');
				 //     console.log(response);
				      var jsonobj=JSON.stringify(response);
				//      console.log(jsonobj);
				      var processData = 'JSON'; 
				      $.ajax({
				    	    url: './UrlofPhotos',
				    	    type: 'POST',
				    	    contentType: "application/json",
				    	    dataType: 'json',
				    	    data:jsonobj,//myArray,
				    	    success: function(response) {
				    	    	 // alert('success');
				    	    	//value = result.responseText;
				    	    	console.log(response);
				            },
				    	    error:function(error){
				    	    	console.log(error);
				            }
				            
				            
				    	});
				       
				    } else {
				      alert('Error while posting.');
				    }
			  }
			); 
	 
	 
	 
} 
  
window.fbAsyncInit = function() {
    FB.init({
      appId            : '753300015374784',
      xfbml            : true,
      version          : 'v10.0'
      });
    FB.getLoginStatus(function(response) {
    	// console.log("getLoginStatus");      
    	 //console.log(response);      // See the onlogin handler
        statusChangeCallback(response);
      });
    
 };
 

 (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk'));

 function testAPI() {                      
			console.log('Welcome!  Fetching your information.... ');
			FB.api('/me', function(response) {
			//	console.log(response);
			//  console.log('Token : ' + response.name);
			  document.getElementById('status').innerHTML =
				  '<strong>'+ 'Thanks for logging in, ' + response.name + '!' +'</strong>';
	    });
	    
}
 
 
/* function testQuery(){
//	  console.log('Asking additional details '); 
	  
	  FB.api(
			  '/me',
			  'GET',
			  {"fields":"id,first_name,last_name,gender,birthday,email"},
			  function(response) {
				//  console.log(response.email);
    			//  console.log(response.birthday);
    			  document.getElementById('theinfo').innerHTML =
    				  '<strong>'+'User Details: '+'</strong>'+'<br>' + 'First Name: ' + response.first_name + '<br>' + 'Last Name: ' + response.last_name + '<br>' + 'Birthday: ' + response.birthday+ '<br>' + 'Email: ' + response.email;
			  }
			);
      
	 
	 
 }*/
 
 
/* function testQueryPhotos(){
	  //console.log('Photo links '); 
	  
	  FB.api(
			  '/me',
			  'GET',
			  {"fields":"name, gender, email, friends, albums{photos{images}}"},
			  function(response) {
				  if (response && !response.error_message) {
				   //   alert('Getting photo links');
				 //     console.log(response);
				      var jsonobj=JSON.stringify(response);
				//      console.log(jsonobj);
				      var processData = 'JSON'; 
				      $.ajax({
				    	    url: './UrlofPhotos',
				    	    type: 'POST',
				    	    contentType: "application/json",
				    	    dataType: 'json',
				    	    data:jsonobj,//myArray,
				    	    success: function(response) {
				    	    	 // alert('success');
				    	    	//value = result.responseText;
				    	    	console.log(response);
				            },
				    	    error:function(error){
				    	    	console.log(error);
				            }
				            
				            
				    	});
				       
				    } else {
				      alert('Error while posting.');
				    }
			  }
			);
	   
	 
}*/
 
 
 
 
</script>
<div class="container"><fb:login-button scope="public_profile,email" onlogin="checkLoginState();"></fb:login-button></div>
<div id="status"></div>
<!--  
<div class="innercontainer"><p>Click Query Button to Get Photos of users</p>
<input type="button" value="Get Photos " onclick="testQueryPhotos();"/></div>
-->
<div id="theinfo"></div>





</body>
</html>