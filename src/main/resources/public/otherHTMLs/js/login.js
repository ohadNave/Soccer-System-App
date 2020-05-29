var username;
var password;
var connected;

// var globalVariable={
//     sid: "123"
// };
var globalVariable={
    FAR: false
};
var name;
var globalVariable={
    lineReferee: false
};
var globalVariable={
    mainReferee: false
};
var globalVariable={
    owner: false
};







// function getName() {
//     return name;
//
// }
function hideAllDives() {
    var choosing = document.getElementById("choosing");
    // var ownerpage = document.getElementById("ownerPage");
    // var loginpage = document.getElementById("Login");
    var main=document.getElementById("main");
    // var alert=document.getElementById("alerts");
    var backSubscriberPage=document.getElementById("backToChoosePage");
    var buttonAlert=document.getElementById("alertButton");
    var backOwnerPage=document.getElementById("back");
    choosing.style.display = "none";
    // ownerpage.style.display = "none";
    // loginpage.style.display = "none";
    main.style.display="none";
    // alert.style.display="none";
    backSubscriberPage.style.display="none";
    buttonAlert.style.display="none";
    backOwnerPage.style.display="none";


}


function displayLoginPage() {
    hideAllDives();
    window.location.href="otherHTMLs/login.html";
    // var x = document.getElementById("Login");
    // if (x.style.display === "none") {
    //     x.style.display = "block";
    // } else {
    //     x.style.display = "none";
    // }
}
function displayLoginPage_OtherHTMLs() {
    hideAllDives();
    window.location.href="login.html";
    // var x = document.getElementById("Login");
    // if (x.style.display === "none") {
    //     x.style.display = "block";
    // } else {
    //     x.style.display = "none";
    // }
}


function loginButton() {

    var url = "http://localhost:8080/login";
    username = document.getElementById("username");
    password = document.getElementById("pwd");
    var data = {};
    // data.sid = "1";
    data.username = username.value;
    data.password = password.value;
    // alert("my data is: " + data);
    var json = JSON.stringify(data);
    // alert("my json is:"+json);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.onload = function () {
        // alert("i get a response")

        if (xhr.readyState == 4 && xhr.status == "200") {
            // alert("i have a response:"+this.responseText);
            var jsonData = JSON.parse(this.responseText);
            // alert("my parsed response is:"+jsonData);
            // alert("jsonData[0]:"+jsonData[0]);
            // alert("jsonData[0]:"+jsonData[4]);

            if ((jsonData[0]).localeCompare("-1") == !0) {
               localStorage.setItem("sid",jsonData[0]);
                name = jsonData[1];
                connected="true";
                // alert("name");

                if ((jsonData[3]).localeCompare("1") == 0) {//Fan
                    // alert("i am in FAR if")
                    localStorage.setItem("fan", true);
                    // displaySubscriberPage();
                    // alert("far");



                }
                if ((jsonData[4]).localeCompare("1") == 0) {//FAR
                    // alert("i am in FAR if")
                    localStorage.setItem("far", true);
                    // displaySubscriberPage();
                    // alert("far");



                } if ((jsonData[5]).localeCompare("1") == 0) {//lineReferee
                    localStorage.setItem("lineReferee", true);
                    // displaySubscriberPage();
                    // alert("lineReferee");



                }
                if ((jsonData[6]).localeCompare("1") == 0) {//mainReferee
                    localStorage.setItem("mainReferee", true);
                    // displaySubscriberPage();
                    // alert("mainReferee");


                }
                if ((jsonData[7]).localeCompare("1") == 0) {//owner
                    localStorage.setItem("owner", true);                     // displaySubscriberPage();
                    // alert("owner");



                }
                directSubscriberChoose();

            } else {
                alert("Incorrect username and password! please fill user nameand password again")
            }
        } else {
            alert("i have an error");
        }
        ;

    }
    xhr.send(json);
}


function directSubscriberChoose() {
    window.location.href="chooseSubscriber.html"
}

function displaySubscriberPage() {
     // hideAllDives();
   // window.location.href="otherHTMLs/chooseSubscriber.html";
   //  var y=document.getElementById("Login");

    var x = document.getElementById("choosing");
    var para = document.createElement("span");
    var node = document.createTextNode(name);
    para.appendChild(node);
    var element = document.getElementById("hello");
    element.appendChild(para);
    if(localStorage.getItem("far")=="true"){
        var choos=document.getElementById("chooseSub");
        var option = document.createElement("option");
        option.setAttribute("style", "display: inline-block");
        option.setAttribute("value","FAR");
        option.setAttribute("id","FAR");
        var node = document.createTextNode("FAR");
        option.appendChild(node);
        choos.appendChild(option);

    }
    if(localStorage.getItem("owner")=="true"){
        var choos=document.getElementById("chooseSub");
        var option = document.createElement("option");
        option.setAttribute("style", "display: inline-block");
        option.setAttribute("value","owner");
        option.setAttribute("id","owner");
        var node = document.createTextNode("owner");
        option.appendChild(node);
        choos.appendChild(option);
    }
    if(localStorage.getItem("lineReferee")=="true"){
        var choos=document.getElementById("chooseSub");
        var option = document.createElement("option");
        option.setAttribute("style", "display: inline-block");
        option.setAttribute("value","lineReferee")
        option.setAttribute("id","lineReferee")
        var node = document.createTextNode("lineReferee");
        option.appendChild(node);
        choos.appendChild(option);
    }
    if(localStorage.getItem("mainReferee")=="true"){
        var choos=document.getElementById("chooseSub");
        var option = document.createElement("option");
        option.setAttribute("style", "display: inline-block");
        option.setAttribute("value","mainReferee");
        option.setAttribute("id","mainReferee")
        var node = document.createTextNode("mainReferee");
        option.appendChild(node);
        choos.appendChild(option);
    }
    if(localStorage.getItem("fan")=="true"){
        var choos=document.getElementById("chooseSub");
        var option = document.createElement("option");
        option.setAttribute("style", "display: inline-block");
        option.setAttribute("value","fan");
        option.setAttribute("id","fan")
        var node = document.createTextNode("Fan");
        option.appendChild(node);
        choos.appendChild(option);
    }
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    // if (y.style.display === "none") {
    //     y.style.display = "block";
    // } else {
    //     y.style.display = "none";
    // }
}

function back() {
    clearInterval(getOwnerAlerts);
    displayOwnerPage()

}
var ownerInterval;
var clicked=false;
function displayOwnerPage() {
    hideAllDives();
    var x = document.getElementById("ownerPage");
    var y= document.getElementById("alertButton");
    var z=document.getElementById("backToChoosePage");

    // document.getElementById("badge").innerHTML = globalVariable.ownerAlerts.length;
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    if (y.style.display === "none") {
        y.style.display = "block";
    } else {
        y.style.display = "block";
    }
    if (z.style.display === "none") {
        z.style.display = "block";
    } else {
        z.style.display = "block";
    }
    // if(document.getElementById('alertButton').clicked==true){
    //     var clicked=true;
    // }

    // setInterval(displayalertsOwner,400,clicked==true);
    // ownerInterval=setInterval(getOwnerAlerts,1000);


}

function chooseHistoryAlerts(){
    if(localStorage.getItem("choice")=="owner"){
        displayOwnerHistoryAlerts();
    }
    else if(localStorage.getItem("choice")=="lineReferee"){
        displayHistoryAlertsLineReferee();
    }
    else if(localStorage.getItem("choice")=="mainReferee"){
        getHistoryMainRefereeAlerts();
        displayHistoryAlertsMainReferee();
    }
    else if(localStorage.getItem("choice")=="fan"){
        getFanHistoryAlerts();
        displayFanHistoryAlerts();
    }
}

function chooseAlerts() {
    if(localStorage.getItem("choice")=="owner"){
        displayOwnerAlerts();
    }
    else if(localStorage.getItem("choice")=="lineReferee"){
        displayalertsLineReferee();
    }
    else if(localStorage.getItem("choice")=="mainReferee"){
        displayalertsMainReferee();
    }
    else if(localStorage.getItem("choice")=="fan"){
        displayFanAlerts();
    }

}
function displayHistoryAlerts() {

    window.location.href="Historyalerts.html";


}


function displayAlerts() {

    document.location.href="alerts.html";


}
function subscriberChoose() {

    var e1 = document.getElementById("chooseSub");
    var choice = e1.options[e1.selectedIndex].value;
    localStorage.setItem("choice",choice);
              if(choice=="FAR"){
                  window.location.href="FAR.html";
             }
              else if(choice=="owner"){
                  window.location.href="owner.html";
              }
              else if (choice=="mainReferee"){
                   window.location.href="mainReferee.html";
              }
              else if (choice=="lineReferee"){
                  window.location.href="lineReferee.html";
              }
              else if (choice=="fan"){
                  window.location.href="Fan.html";
              }



}

