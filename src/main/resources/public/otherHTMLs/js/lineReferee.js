var selectedGame;
var makeReport_selectedGame;
var makeReport_TeamA;
var makeReport_TeamB;
var dict_teamName_teamID={};
var dict_date_matchID={};
var globalVariable={
    ownerAlerts: new Array()
};
function getID() {
    return localStorage.getItem("sid");
}
function displayAddEvent() {
    hideAllDives();
    var x = document.getElementById("addEventPage");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    getAllRelatedGames();
}
function displayMainRefereePage() {
    hideAllDives();
    var x = document.getElementById("mainRefereePage");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
function displayMakeReportPage() {
    hideAllDives();
    var x = document.getElementById("makeReportPage");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    getAllRelatedGames_makeReport();
}
function hideAllDives() {
    var mainRefereePage = document.getElementById("mainRefereePage");
    var addEventPage = document.getElementById("addEventPage");
    var makeReportPage = document.getElementById("makeReportPage");
    mainRefereePage.style.display = "none";
    addEventPage.style.display = "none";
    makeReportPage.style.display = "none";
}


// *****ADD EVENT*****
function getAllRelatedGames() {
    var myURL="http://localhost:8080/getListOfGames/"+getID();
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            // var jsonData = JSON.parse(this);
            var jsonData = (JSON.parse(this.response));
            if(!document.getElementById("relatedGames0")){
                for (var i = 0; i < jsonData.length; i++) {
                    var gameDate = (jsonData[i].date).substring(0,(jsonData[i].date).length-19);
                    var counter = gameDate;
                    dict_date_matchID[gameDate]=jsonData[i].matchId;
                    alert("match ID in dictionary is:"+jsonData[i].matchId);
                    var x = document.getElementById("optionalGames");
                    var option = document.createElement("option");
                    option.setAttribute("id", "relatedGames"+i);
                    option.text = counter;
                    if(i===0){
                        selectedGame=counter;
                    }
                    x.add(option);
                }
            }
        }

    };
    xhttp.open("GET", myURL, true);
    xhttp.send();
}

function addEvent() {
    // Post a user
    var url = "http://localhost:8080/addEvent";

    var data = {};

    data.sid = getID();

    var e1 = document.getElementById("optionalGames");
    var game = e1.options[e1.selectedIndex].value;
    data.matchId  = dict_date_matchID[game];
    alert("matchID is:"+data.matchId);
    data.minuteInGame =document.getElementById("MGame").value;

    data.description = document.getElementById("description").value;

    var e2 = document.getElementById("eventType");
    var eventType = e2.options[e2.selectedIndex].value;
    data.eventType = eventType;

    data.relatedPlayer = document.getElementById("relatedPlayer").value;

    var json = JSON.stringify(data);
    alert("all data is:"+json);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            if (xhr.responseText == "true") {
                alert("event was added successfully!");
                displayMainRefereePage();
            } else {
                alert("error:" + xhr.responseText);
            }
        }
    };
    xhr.send(json);
}

// ****MAKE REPORT****
function getAllRelatedGames_makeReport() {
    var myURL="http://localhost:8080/getListOfGames/"+getID();
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            // var jsonData = JSON.parse(this);
            var jsonData = (JSON.parse(this.response));
            if(!document.getElementById("relatedGames_makeReport0")){
                for (var i = 0; i < jsonData.length; i++) {
                    var gameDate = (jsonData[i].date).substring(0,(jsonData[i].date).length-19);
                    var counter = gameDate;
                    dict_date_matchID[gameDate]=jsonData[i].matchId;
                    var x = document.getElementById("matches");
                    var option = document.createElement("option");
                    option.setAttribute("id", "relatedGames_makeReport"+i);
                    option.text = counter;
                    if(i===0){
                        makeReport_selectedGame=jsonData[i].matchId;
                    }
                    x.add(option);
                }
            }
        }

    };
    xhttp.open("GET", myURL, true);
    xhttp.send();
}

function makeReport_moveFromChooseGameToChooseTeams() {
    var y = document.getElementById("makeReport_chooseSpecificMatch");
    y.style.display = "none";
    var x = document.getElementById("makeReport_chooseTeams");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    getTeamsOfGame();
}

function getTeamsOfGame(){
    var e1 = document.getElementById("matches");
    var game = e1.options[e1.selectedIndex].value;
    makeReport_selectedGame = dict_date_matchID[game];
    alert("the user chose:"+makeReport_selectedGame);
    var myURL="http://localhost:8080/getTeamsInGame/"+makeReport_selectedGame;
    alert("mu url is:"+myURL);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            // var jsonData = JSON.parse(this);
            var jsonData = JSON.parse(this.responseText);
            var firstTeam = jsonData[0];
            makeReport_TeamA=firstTeam;
            var secondTeam = jsonData[1];
            makeReport_TeamB=secondTeam;
            dict_teamName_teamID[firstTeam]=jsonData[2];
            dict_teamName_teamID[secondTeam]=jsonData[3];
            if(!document.getElementById("teamsOfGameDiv")){
                var x = document.getElementById("scoreOfTeams");
                var div = document.getElementById("teamsOfGameDiv");
                var label1 = document.createElement("label1");
                var t1 = document.createTextNode("score of "+firstTeam+":");
                label1.setAttribute("for","scoreTeamA");
                label1.appendChild(t1);
                var input1 = document.createElement("INPUT");
                input1.setAttribute("type", "text");
                input1.setAttribute("id", "scoreTeamA");

                var label2 = document.createElement("label2");
                var t2 = document.createTextNode("score of "+secondTeam+":");
                label2.setAttribute("for","scoreTeamB");
                label2.appendChild(t2);
                var input2 = document.createElement("INPUT");
                input2.setAttribute("type", "text");
                input2.setAttribute("id", "scoreTeamB");

                var br1 = document.createElement("br");
                var br2 = document.createElement("br");
                var br3 = document.createElement("br");
                var br4 = document.createElement("br");

                div.appendChild(label1);
                div.appendChild(input1);
                div.appendChild(br1);
                div.appendChild(br2);
                div.appendChild(label2);
                div.appendChild(input2);
                div.appendChild(br3);
                div.appendChild(br4);
                x.appendChild(div);
            }
        }

    };
    xhttp.open("GET", myURL, true);
    xhttp.send();
}

function makeReport_moveBackFromChoosingTeamsToChoosingGame(){
    var y = document.getElementById("makeReport_chooseTeams");
    y.style.display = "none";
    var x = document.getElementById("makeReport_chooseSpecificMatch");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function makeReport(){
    // Post a user
    var url = "http://localhost:8080/makeReport";

    var data = {};

    data.sid = getID();

    data.mid = makeReport_selectedGame;

    var scoreTeamA = document.getElementById("scoreTeamA").value;
    var scoreTeamB = document.getElementById("scoreTeamB").value;

    if(scoreTeamA>scoreTeamB){
        data.winnerTeamID =dict_teamName_teamID[makeReport_TeamA];
        data.loosingTeamID = dict_teamName_teamID[makeReport_TeamB];
        data.scoreWinnerTeam=scoreTeamA;
        data.scoreLoosingTeam=scoreTeamB;
    } else if(scoreTeamA<scoreTeamB){
        data.winnerTeamID=dict_teamName_teamID[makeReport_TeamB];
        data.loosingTeamID=dict_teamName_teamID[makeReport_TeamA];
        data.scoreWinnerTeam=scoreTeamB;
        data.scoreLoosingTeam=scoreTeamA;
    }
    var json = JSON.stringify(data);
    alert("details of report are:"+json);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            if (xhr.responseText == "true") {
                alert("report was added successfully!");
                displayMainRefereePage();
            } else {
                alert("error:" + xhr.responseText);
            }
        }
    };
    xhr.send(json);
}

function getLineRefereeAlerts() {
    var myURL="http://localhost:8080/lineReferee/getAlerts/"+globalVariable.sid;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            var jsonData = JSON.parse(this.responseText);
            for (var i = 0; i < jsonData.length; i++) {
                var alert2 = jsonData[i];
                globalVariable.ownerAlerts.push(alert2);
                document.getElementById("badge").innerHTML = globalVariable.ownerAlerts.length;

            }
        }

    };
    xhttp.open("GET", myURL, true);
    xhttp.send();
}


var intervalLineReferee;
function setIntervals() {
    intervalLineReferee=setInterval(getLineRefereeAlerts,1000);

}

function displayHistoryAlertsLineReferee() {
    var x = document.getElementById("alerts");
    // var y = document.getElementById("back");
    // var i = localStorage.getItem("lengthOfAlerts")-1;
    var text = localStorage.getItem("HistoryArrayOfAlert");
    text=JSON.parse(text);
    // text=text.split(/[ /[/,]+/);
    // clearInterval(intervalOwner);
    var i=text.length-1;
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


        // localStorage.setItem("lengthOfAlerts", text.length);
        //
        //
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

function displayalertsLineReferee() {
    var x = document.getElementById("alerts");
    // var y = document.getElementById("back");
    // var i = localStorage.getItem("lengthOfAlerts")-1;
    var text = localStorage.getItem("arrayOfAlert");
    text=JSON.parse(text);
    // text=text.split(/[ /[/,]+/);
    clearInterval(intervalOwner);
    var i=text.length-1;
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
        text = text.split(/[ ","]+/);


        var text2 = document.createTextNode(text[i]);
        if(text2=="]" || (text2=="[")){
        }
        else {
            i--;
        }
        text.splice(i, 1);


        localStorage.setItem("lengthOfAlerts", text.length);


        localStorage.setItem("arrayOfAlert", text);

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