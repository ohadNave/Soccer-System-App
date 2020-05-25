var scorePolicy_leagueName;
var scorePolicy_year;
var scorePolicy_policy="scorePolicyA";
var placementPolicy_leagueName;
var placementPolicy_year;
var placementPolicy_policy="scorePolicyA";
var dict_leagueName_leagueID = {};
var dict_leagueName_leagueID_placementPolicy = {};
var teamRequest_TeamName;
var teamRequest_OwnerName;
var teamRequest_OwnerID;
var teamRequest_RegistrationID;
var globalVariable={
    ownerAlerts: new Array()
};
function getID() {
    return globalVariable.sid;
}
function displayAddScorePolicy() {
    hideAllDives();
    var x = document.getElementById("addScorePolicy");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    addScorePolicy_showLeague();
}

function displayAddPlacementPolicy() {
    hideAllDives();
    var x = document.getElementById("addPlacementPolicy");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    addPlacementPolicy_showLeague()
}

function displayCheckTeamsRequest() {
    hideAllDives();
    var x = document.getElementById("checkTeamRequestPage");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    checkTeamsRequest_showRequest()
}
function displayMainFarPage() {
    hideAllDives();
    var x = document.getElementById("mainPageFAR");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function hideAllDives() {
    var placementPage = document.getElementById("addPlacementPolicy");
    var scorePage = document.getElementById("addScorePolicy");
    var mainPage = document.getElementById("mainPageFAR");
    var checkTeamsRequestPage = document.getElementById("checkTeamRequestPage");
    placementPage.style.display = "none";
    scorePage.style.display = "none";
    mainPage.style.display = "none";
    checkTeamsRequestPage.style.display = "none";
}

function addScorePolicy_showLeague() {
    //alert("i enter to get function")
    var theurl = "http://localhost:8080/addScorePolicy/getLeagueNames";
    var client = new HttpClient();
    client.get(theurl, function (response) {
        var jsonData = JSON.parse(response);
        if(!document.getElementById("LeagueOptions_scorePolicy0")) {
            for (var i = 0; i < jsonData.length; i++) {
                var counter = jsonData[i];
                dict_leagueName_leagueID[jsonData[i].name] = jsonData[i].lid;
                //alert(counter.name);
                var x = document.getElementById("leagues");
                var option = document.createElement("option");
                option.setAttribute("id", "LeagueOptions_scorePolicy"+i);
                option.text = counter.name;
                if (i === 0) {
                    scorePolicy_leagueName = counter.name;
                }
                x.add(option);
            }
        }
        alert("my dictionary is:"+dict_leagueName_leagueID);
    });
}

function addPlacementPolicy_showLeague() {
    //alert("i enter to get function")
    var theurl = "http://localhost:8080/addPlacementPolicy/getLeagueNames";
    var client = new HttpClient();
    client.get(theurl, function (response) {
        var jsonData = JSON.parse(response);
        if(!document.getElementById("LeagueOptions_placementPolicy0")){
            for (var i = 0; i < jsonData.length; i++) {
                var counter = jsonData[i];
                dict_leagueName_leagueID_placementPolicy[jsonData[i].name]=jsonData[i].lid;
                //alert(counter.name);
                var x = document.getElementById("leagues1");
                var option = document.createElement("option");
                option.setAttribute("id", "LeagueOptions_placementPolicy"+i);
                option.text = counter.name;
                if(i===0){
                    placementPolicy_leagueName=counter.name;
                }
                x.add(option);
            }
        }
        alert("my dictionary is:"+dict_leagueName_leagueID);
    });
}
var HttpClient = function() {
    this.get = function(aUrl, aCallback) {
        var anHttpRequest = new XMLHttpRequest();
        anHttpRequest.onreadystatechange = function() {
            if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
                aCallback(anHttpRequest.responseText);
        }
        anHttpRequest.open( "GET", aUrl, true );
        anHttpRequest.send( null );
    }
}

function updateScorePolicy_leagueName() {
    var e = document.getElementById("leagues");
    var leagueName = e.options[e.selectedIndex].value;
    scorePolicy_leagueName=leagueName;
}
function updatePlacementPolicy_leagueName() {
    var e = document.getElementById("leagues1");
    var leagueName = e.options[e.selectedIndex].value;
    placementPolicy_leagueName=leagueName;
}

function moveFromChooseLeagueToChooseYear() {
    var y = document.getElementById("addScorePolicy_chooseLeague");
    y.style.display = "none";
    var x = document.getElementById("addScorePolicy_chooseYearAndPolicy");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    addScorePolicy_getPossibleYearsOfLeague();
}
function moveFromChooseLeagueToChooseYear_PlacementPolicy() {
    var y = document.getElementById("addPlacementPolicy_chooseLeague");
    y.style.display = "none";
    var x = document.getElementById("addPlacementPolicy_chooseYearAndPolicy");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    addPlacementPolicy_getPossibleYearsOfLeague();
}

function moveBackToChooseLeague_fromChooseYear() {
    var y = document.getElementById("addScorePolicy_chooseYearAndPolicy");
    y.style.display = "none";
    var x = document.getElementById("addScorePolicy_chooseLeague");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
function moveBackToChooseLeague_fromChooseYear_PlacementPolicy() {
    var y = document.getElementById("addPlacementPolicy_chooseYearAndPolicy");
    y.style.display = "none";
    var x = document.getElementById("addPlacementPolicy_chooseLeague");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
function addScorePolicy_getPossibleYearsOfLeague() {
    updateScorePolicy_leagueName();
    var myURL="http://localhost:8080/addScorePolicy/getPossibleYears/"+dict_leagueName_leagueID[scorePolicy_leagueName];
    alert("i'm in addScorePolicy_getPossibleYearsOfLeague, my url is:"+myURL);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            // var jsonData = JSON.parse(this);
            // var jsonData = JSON.parse(this.responseText);
            // if(!document.getElementById("yearOptions_scorePolicy0")){
            //     for (var i = 0; i < jsonData.length; i++) {
            //         var counter = jsonData[i];
            //         var x = document.getElementById("years");
            //         var option = document.createElement("option");
            //         option.setAttribute("id", "yearOptions_scorePolicy"+i);
            //         option.text = counter;
            //         if(i===0){
            //             scorePolicy_year=counter;
            //             scorePolicy_policy="policyA";
            //         }
            //         x.add(option);
            //     }
            // }
        }
    };
    xhttp.open("GET", myURL, true);
    xhttp.send();
}

function addPlacementPolicy_getPossibleYearsOfLeague() {
    updatePlacementPolicy_leagueName();
    var myURL="http://localhost:8080/addPlacementPolicy/getPossibleYears/"+dict_leagueName_leagueID_placementPolicy[placementPolicy_leagueName];
    alert("i'm in addPlacementPolicy_getPossibleYearsOfLeague, my url is:"+myURL);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            // var jsonData = JSON.parse(this);
            // var jsonData = JSON.parse(this.responseText);
            // if(!document.getElementById("yearOptions_placementPolicy0")){
            //     for (var i = 0; i < jsonData.length; i++) {
            //         var counter = jsonData[i];
            //         var x = document.getElementById("years1");
            //         var option = document.createElement("option");
            //         option.setAttribute("id", "yearOptions_placementPolicy"+i);
            //         option.text = counter;
            //         if(i===0){
            //             placementPolicy_year=counter;
            //             placementPolicy_policy="policyA";
            //         }
            //         x.add(option);
            //     }
            // }
        }

    };
    xhttp.open("GET", myURL, true);
    xhttp.send();
}
function updateYearAndPolicy() {
    // var e1 = document.getElementById("years");
    // var years = e1.options[e1.selectedIndex].value;
    // scorePolicy_year=years;
    var e2 = document.getElementById("scorePolicy");
    var scorePolicy = e2.options[e2.selectedIndex].value;
    scorePolicy_policy=scorePolicy;
}
function updateYearAndPolicy_PlacementPolicy() {
    // var e1 = document.getElementById("years1");
    // var years = e1.options[e1.selectedIndex].value;
    // placementPolicy_year=years;
    var e2 = document.getElementById("scorePolicy1");
    var scorePolicy = e2.options[e2.selectedIndex].value;
    placementPolicy_policy=scorePolicy;
}
function updateScorePolicyInDB() {
    updateYearAndPolicy();
    // Post a user
    var url = "http://localhost:8080/addScorePolicy";
    var data = {};
    data.sid = getID();
    data.leagueID  = dict_leagueName_leagueID[scorePolicy_leagueName];
    // data.year = scorePolicy_year;
    data.scorePolicy = scorePolicy_policy;
    var json = JSON.stringify(data);
    alert("check id:"+json);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            if (xhr.responseText == "true") {
                alert("updated score policy successfully!");
                displayMainFarPage();
            } else {
                alert("error:" + xhr.responseText);
            }
        }
    };
    xhr.send(json);
}
function updatePlacementPolicyInDB() {
    updateYearAndPolicy_PlacementPolicy();
    // Post a user
    var url = "http://localhost:8080/addPlacementPolicy";
    var data = {};
    data.sid = getID();
    data.leagueID  = dict_leagueName_leagueID_placementPolicy[placementPolicy_leagueName];
    // data.year = placementPolicy_year;
    data.scorePolicy = placementPolicy_policy;
    var json = JSON.stringify(data);
    alert("data i sent is:"+json);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            if (xhr.responseText == "true") {
                alert("updated placement policy successfully!");
                displayMainFarPage();
            } else {
                alert("error:" + xhr.responseText);
            }
        }
    };
    xhr.send(json);
}

function checkTeamsRequest_showRequest() {
    var myURL="http://localhost:8080/nextTeamRequest";
    alert("i'm in addPlacementPolicy_getPossibleYearsOfLeague, my url is:"+myURL);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            // var jsonData = JSON.parse(this);
            var jsonData = JSON.parse(this.responseText);
            teamRequest_TeamName = jsonData[0];
            teamRequest_OwnerName = jsonData[2];
            teamRequest_OwnerID = jsonData[1];
            teamRequest_RegistrationID = jsonData[3];
            if(!document.getElementById("teamRequestDiv")){
                var gameDetails = document.getElementById("RequestDetails");
                var div = document.createElement("dir");
                div.setAttribute("id","teamRequestDiv");
                var t1 = document.createTextNode("team name is: "+teamRequest_TeamName);
                var t2 = document.createTextNode("owner name is: "+teamRequest_OwnerName);
                var br1 = document.createElement("br");
                var br2 = document.createElement("br");
                div.appendChild(t1);
                div.appendChild(br1);
                div.appendChild(br2);
                div.appendChild(t2);
                gameDetails.appendChild(div);
            }
        }

    };
    xhttp.open("GET", myURL, true);
    xhttp.send();
}

function approveTeamRequest() {
    var url = "http://localhost:8080/approveRequest";
    var data = {};
    data.sid = getID();
    data.booleanVar  = true;
    data.regID= teamRequest_RegistrationID;

    var json = JSON.stringify(data);
    alert("data i sent is:"+json);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            if (xhr.responseText == "true") {
                alert("team request was approved successfully!");
                displayMainFarPage();
            } else {
                alert("error:" + xhr.responseText);
            }
        }
    };
    xhr.send(json);
}

function rejectTeamRequest(){
    var url = "http://localhost:8080/rejectRequest";
    var data = {};
    data.sid = getID();
    data.booleanVar  = false;
    data.regID= teamRequest_RegistrationID;

    var json = JSON.stringify(data);
    alert("data i sent is:"+json);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            if (xhr.responseText == "true") {
                alert("team request was rejected successfully!");
                displayMainFarPage();
            } else {
                alert("error:" + xhr.responseText);
            }
        }
    };
    xhr.send(json);
}
function getOwnerAlerts() {
    var myURL="http://localhost:8080/owner/getAlerts/"+globalVariable.sid;
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

function displayalertsOwner(){
    hideAllDives();
    var x = document.getElementById("alerts");


    while (globalVariable.ownerAlerts.length > 0) {
        var random = Math.floor(Math.random() * 4) + 1;
        var alerts = document.getElementById("alerts");
        var message = document.createElement("div", "id=message");
        if(random==1){
            message.setAttribute("style", "padding: 15px; background-color: #4CAF50; color: white;")
        }
        if(random==2){
            message.setAttribute("style", "padding: 15px; background-color: #f44336; color: white;")
        }
        if(random==3){
            message.setAttribute("style", "padding: 15px; background-color: #2196F3; color: white;")
        }
        if(random==4){
            message.setAttribute("style", "padding: 15px; background-color: #ff9800; color: white;")
        }

        var btn = document.createElement("span");
        btn.setAttribute("class", "closebtn");
        btn.setAttribute("onmouseover", "this.style.color='black'");
        btn.setAttribute("onmouseout", "this.style.color='white'");
        // btn.setAttribute("onclick", "hideDiv()");
        btn.setAttribute("style", "  margin-left: 10px; color: white; font-weight: bold; float: right; font-size: 22px; line-height: 20px; cursor: pointer;transition: 0.3s; ")

        var times = document.createTextNode("X");
        var text = document.createTextNode(globalVariable.ownerAlerts.pop());
        alerts.appendChild(message);
        message.appendChild(btn);
        btn.appendChild(times);
        message.appendChild(text);
        var newLine = document.createElement('br');
        message.appendChild(newLine)




    }
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }


    var close = document.getElementsByClassName("closebtn");
    var i;

    for (i = 0; i < close.length; i++) {
        close[i].onclick = function(){
            var div = this.parentElement;
            div.style.opacity = "0";
            setTimeout(function(){ div.style.display = "none"; }, 600);
        }
    }

}