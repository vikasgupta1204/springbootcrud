console.log("This is script file")

const toggleSidebar=()=>{
    if($('.sidebar').is(":visible")){
        //if sidebar visible then close it
        $(".sidebar").css("display","none")
        $(".content").css("margin-left","0%")
    }
    else{
        //if sidebar not visible then show it
        $(".sidebar").css("display","block")
        $(".content").css("margin-left","20%")
    }
}