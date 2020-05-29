var intervalFan;
function setIntervals() {
    intervalFan=setInterval(getFanAlerts,20000);
}
var fanAlerts= new Array();



var fanHistoryAlerts=new Array();
function getFanHistoryAlerts() {
    var myURL="http://localhost:8080/fan/getHistoryAlerts/"+localStorage.getItem("sid");
    var xhttp = new XMLHttpRequest();
    // console.log(localStorage.getItem("sid"))
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            var jsonData = JSON.parse(this.responseText);

            for (var i = 0; i < jsonData.length; i++) {
                var alertHistory = jsonData[i];
                fanHistoryAlerts.push(alertHistory);
                // document.getElementById("badge").innerHTML = ownerAlerts.length;
                // localStorage.setItem("lengthOfAlerts",ownerAlerts.length);
            }
            localStorage.setItem("HistoryArrayOfAlertFan",JSON.stringify(fanHistoryAlerts));

        }

    };
    xhttp.open("GET", myURL, false);
    xhttp.send();
}
function getFanAlerts() {

    var myURL="http://localhost:8080/fan/getAlerts/"+localStorage.getItem("sid");
    var xhttp = new XMLHttpRequest();
    // console.log(localStorage.getItem("sid"))
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            // alert("my answer is:" + this.responseText);
            var jsonData = JSON.parse(this.responseText);
            // alert("my json is:" + jsonData);
            if(jsonData.length==0){
                document.getElementById("badge").innerHTML = fanAlerts.length;
                localStorage.setItem("lengthOfAlerts",fanAlerts.length);
                localStorage.setItem("arrayOfAlertFan",JSON.stringify(fanAlerts));
            }
            for (var i = 0; i < jsonData.length; i++) {
                var alert2 = jsonData[i];
                fanAlerts.push(alert2);
                document.getElementById("badge").innerHTML = fanAlerts.length;
                localStorage.setItem("lengthOfAlerts",fanAlerts.length);
                localStorage.setItem("arrayOfAlertFan",JSON.stringify(fanAlerts));


            }
        }

    };
    xhttp.open("GET", myURL, true);
    xhttp.send();
}


function displayalertsOwner() {
    // hideAllDives();

    window.location.href = "alerts.html";
}

// function displayHistoryalertsOwner() {
//     // hideAllDives();
//     window.location.href = "Historyalerts.html";
// }

function displayFanHistoryAlerts(){
    var x = document.getElementById("alerts");
    // var y = document.getElementById("back");
    // var i = localStorage.getItem("lengthOfAlerts")-1;
    var textHistory = localStorage.getItem("HistoryArrayOfAlertFan");
    textHistory=JSON.parse(textHistory);
    // text=text.split(/[ /[/,]+/);
    // clearInterval(intervalOwner);
    var i=textHistory.length-1;
    // while (localStorage.getItem("lengthOfAlerts") > 0) {
    while (textHistory.length> 0) {
        var random = Math.floor(Math.random() * 4) + 1;
        var alerts = document.getElementById("alerts");
        var message = document.createElement("div", "id=message");
        if (random == 1) {
            message.setAttribute("style", "padding: 15px; background-color: #4CAF50; color: white;")
        }
        if (random == 2) {
            message.setAttribute("style", "padding: 15px; background-color: #f44336; color: white;")
        }
        if (random == 3) {
            message.setAttribute("style", "padding: 15px; background-color: #2196F3; color: white;")
        }
        if (random == 4) {
            message.setAttribute("style", "padding: 15px; background-color: #ff9800; color: white;")
        }

        var btn = document.createElement("span");
        btn.setAttribute("class", "closebtn");
        btn.setAttribute("onmouseover", "this.style.color='black'");
        btn.setAttribute("onmouseout", "this.style.color='white'");
        // btn.setAttribute("onclick", "hideDiv()");
        btn.setAttribute("style", "  margin-left: 10px; color: white; font-weight: bold; float: right; font-size: 22px; line-height: 20px; cursor: pointer;transition: 0.3s; ")

        var times = document.createTextNode("X");
        // var text = localStorage.getItem("arrayOfAlert");
        // text = text.split(/[ ","]+/);


        var text2 = document.createTextNode(textHistory[i]);
        // if(text2=="]" || (text2=="[")){
        // }
        // else {
        //     i--;
        // }
        textHistory.splice(i, 1);
        i--;

        // localStorage.setItem("lengthOfAlerts", text.length);


        // localStorage.setItem("arrayOfAlert", text);

        alerts.appendChild(message);
        message.appendChild(btn);
        btn.appendChild(times);
        message.appendChild(text2);
        var newLine = document.createElement('br');
        message.appendChild(newLine)

    }




    var close = document.getElementsByClassName("closebtn");
    var i;

    for (i = 0; i < close.length; i++) {
        close[i].onclick = function () {
            var div = this.parentElement;
            div.style.opacity = "0";
            setTimeout(function () {
                div.style.display = "none";
            }, 600);
        }
    }


}

function displayFanAlerts() {
    var x = document.getElementById("alerts");
    // var y = document.getElementById("back");
    // var i = localStorage.getItem("lengthOfAlerts")-1;
    var text = localStorage.getItem("arrayOfAlertFan");
    text=JSON.parse(text);
    // text=text.split(/[ /[/,]+/);
    clearInterval(intervalOwner);
    var i=text.length-1;
    // while (localStorage.getItem("lengthOfAlerts") > 0) {
    while (text.length> 0) {
        var random = Math.floor(Math.random() * 4) + 1;
        var alerts = document.getElementById("alerts");
        var message = document.createElement("div", "id=message");
        if (random == 1) {
            message.setAttribute("style", "padding: 15px; background-color: #4CAF50; color: white;")
        }
        if (random == 2) {
            message.setAttribute("style", "padding: 15px; background-color: #f44336; color: white;")
        }
        if (random == 3) {
            message.setAttribute("style", "padding: 15px; background-color: #2196F3; color: white;")
        }
        if (random == 4) {
            message.setAttribute("style", "padding: 15px; background-color: #ff9800; color: white;")
        }

        var btn = document.createElement("span");
        btn.setAttribute("class", "closebtn");
        btn.setAttribute("onmouseover", "this.style.color='black'");
        btn.setAttribute("onmouseout", "this.style.color='white'");
        // btn.setAttribute("onclick", "hideDiv()");
        btn.setAttribute("style", "  margin-left: 10px; color: white; font-weight: bold; float: right; font-size: 22px; line-height: 20px; cursor: pointer;transition: 0.3s; ")

        var times = document.createTextNode("X");
        // var text = localStorage.getItem("arrayOfAlert");
        // text = text.split(/[ ","]+/);


        var text2 = document.createTextNode(text[i]);
        // if(text2=="]" || (text2=="[")){
        // }
        // else {
        //     i--;
        // }
        text.splice(i, 1);
        i--;

        // localStorage.setItem("lengthOfAlerts", text.length);


        // localStorage.setItem("arrayOfAlert", text);

        alerts.appendChild(message);
        message.appendChild(btn);
        btn.appendChild(times);
        message.appendChild(text2);
        var newLine = document.createElement('br');
        message.appendChild(newLine)

    }




    var close = document.getElementsByClassName("closebtn");
    var i;

    for (i = 0; i < close.length; i++) {
        close[i].onclick = function () {
            var div = this.parentElement;
            div.style.opacity = "0";
            setTimeout(function () {
                div.style.display = "none";
            }, 600);
        }
    }


}
