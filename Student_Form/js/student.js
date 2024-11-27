const studentForm = document.getElementById("student-Form")

studentForm.addEventListener('submit', (event) => {
    event.preventDefault();

    let namef = document.getElementById("name").value;
    let emailf = document.getElementById("email").value;
    let levelf = document.getElementById("level").value;

    const studentData = {
        name:namef,
        email:emailf, 
        level:levelf
    };

    console.log(studentData);

    //create Json
     const studentjson = JSON.stringify(studentData)
     console.log(studentjson)

    //Introduce AJAX-native
    // const http = new XMLHttpRequest()
    // http.onreadystatechange = () => {       //callback function
    //     if(http.readyState == 4){
    //         if(http.status == 200){

    //             var responseTextJSON = JSON.stringify(http.responseText)    //stringify - ena type ek mokk unth eka json krnwa (js wl inbuild method 1k) 
    //             console.log(responseTextJSON)

    //         }else{
    //             console.error("Failed")
    //             console.error("Status" +http.status)
    //             console.error("Ready Status" +http.readyState)
    //         }

    //     }else{
    //         console.error("Ready Status" +http.readyState)
    //     }
    // }

    // http.open("POST", "http://localhost:8080/StudentManagement/student", true)

    // http.setRequestHeader("Content-Type", "application/json")   //content type - mime type     json data 1k ywnne kiyl kiynne
    // http.send(studentjson)

    //AJAX with JQuery
    $.ajax({
        url:"http://localhost:8080/StudentManagement/student",
        type:"POST",
        data:studentjson,
        headers:{"Content-Type":"application/json"},
        success:(res) =>{
            console.log(JSON.stringify(res));
        },
        error:(res) =>{
            console.error(res)
        }
    })

});