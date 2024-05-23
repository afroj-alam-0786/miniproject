/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
    let caller=function(i,si){
        let data=document.getElementById(i).value;
        //alert("function called");
    let xhr=new XMLHttpRequest(); //isi ke through data asynchronous ata jata hai
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4){
                if((xhr.status>=200 && xhr.status < 300)||xhr.status==304){
                    //alert(xhr.responseText);
                    document.getElementById(si).innerHTML=xhr.responseText;
                }else{
                    //alert("Request was unsuccesful");
                     document.getElementById(si).innerHTML="";
                }
            }
        };
        xhr.open("get",`fc?type=model&page=AsyncCheck&email=${data}`,true);
        xhr.send(null);
    
};
//let getStates=function(country_id,state_id){
     /*   let countryObj = document.getElementById("countryId");
        let data=countryObj.value;
        let statecode=document.getElementById("stateId");
       // statecode.innerHTML="";
       countryObj.addEventListener("click",event=>{
          statecode.innerHTML="";
        //alert(statecode);
       let xhr=new XMLHttpRequest(); //isi ke through data asynchronous ata jata hai
        xhr.onreadystatechange=function(){
            if(xhr.readyState===4){
                if((xhr.status>=200 && xhr.status < 300)||xhr.status===304){
                      let jsonObj = JSON.parse(xhr.responseText);
                    jsonObj.states.forEach(function(stateObject) {
                        let stateCode = parseInt(Object.keys(stateObject)[0]); // Convert to integer
                        let stateName = stateObject[stateCode];
                        let option = document.createElement("option");
                        option.value = stateCode;
                        option.text = stateName;

                        statecode.add(option);
                });
            }
        }
    }
      //  });
        xhr.open("get",`fc?type=model&page=GetState&country_code=${data}`,true);
        xhr.send(null);
        
});*/


