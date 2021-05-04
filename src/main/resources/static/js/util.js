function checkForm(...args) {
    for (let i = 0; i < args.length; i++) {
        if (args[i]==undefined||args[i].length == 0 || args[i].trim() == '') {
            return false;
        }
    }
    return true;
}

function showDot(){
    $.ajax({
        url: "/getNum",
        type: "get",
        dataType: "json",
        data: {
            id:localStorage.getItem("id"),
        },
        success: function (data) {
            switch (data.code) {
                case 0:
                    if (data.data==0){
                        $("#dot").css("background","#ffffff");
                    }else {
                        $("#dot").css("background","#FA5A57");
                    }
                    break;
            }
        },
        err: function (e) {
            console.log(e.status);
            console.log(e.statusText);
        }
    });
}