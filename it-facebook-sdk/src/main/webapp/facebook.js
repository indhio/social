window.fbAsyncInit = function() {
	FB.init({
		appId : '272554863126631',
		cookie : true, // enable cookies to allow the server to access the
		// session
		xfbml : true, // parse social plugins on this page
		version : 'v2.5' // use graph api version 2.5
	});
};

(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id))
		return;
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

function checkLoginState() {
	FB.getLoginStatus(function(response) {
		if (response.status === 'connected') {
			console.log('Logged in.');
		} else {
			login();
		}
	});
}

function login() {
	FB.login(function() {
		console.log("Login efetuado com sucesso!");
		showBtns(true);
	}, {
		scope : 'public_profile, email, user_friends'
	});
}

function init() {
	showBtns(false);
}

function showBtns(value) {
	document.getElementById("btnLogin").style.display = (value == true ? "none" : "");
	document.getElementById("btnID").style.display = (value == true ? "" : "none");
	document.getElementById("btnName").style.display = (value == true ? "" : "none");
	document.getElementById("btnEmail").style.display = (value == true ? "" : "none");
	document.getElementById("btnPicture").style.display = (value == true ? "" : "none");
}

function getFBName() {
	checkLoginState();
	FB.api('/me?fields=id,name,email,permissions', function(response) {
		console.log(response);
		console.log(response.name);
		document.getElementById("fbName2").innerHTML = response.name;
	});
}

function getFBID() {
	checkLoginState();
	FB.api('/me?fields=id,name,email,permissions', function(response) {
		console.log(response);
		console.log(response.id);
		document.getElementById("fbID").innerHTML = response.id;
	});
}

function getFBEmail() {
	checkLoginState();
	FB.api('/me?fields=id,name,email,permissions', function(response) {
		console.log(response);
		console.log(response.email);
		document.getElementById("fbEmail").innerHTML = response.email;
	});
}

function getFBPicture() {
	checkLoginState();
	FB.api('/me?fields=id,name,email,permissions', function(response) {
		var id = response.id;
		FB.api('/' + id + '/picture', function(response) {
			console.log(response);
			console.log(response.data.url);
			document.getElementById("fbPicture").style.display = "";
			document.getElementById("fbPicture").src = response.data.url;
		});
	});
}
