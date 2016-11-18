/*function hide(){
    var cells = document.getElementsByTagName("td");
    for(var i = 0; i<cells.length; i++) alert(cells[i].id);
    for (var i = 0; i < cells.length; i++) {

        var style = cells[i].getAttribute("style");
        if ( style.display == "none" ) {
            style.display = 'inline';
            style.color = 'black';
        }else if (style.display == "inline"){
            style.display = 'none';
        }
    }
};

function checkPasswd(element){
    element.onclick = function(event) {
        event = event || window.event;
    };
    var passwd = document.getElementById("passwd").value;
    var confrm = document.getElementById("confrm").value;
    var position = document.getElementById("position").value;
    var department = document.getElementById("department").value;
    if (passwd == confrm){
        if (position <= 50 || department <=50) {
            this.parentNode.submit();
        }else {
            document.getElementById("error").innerHTML="Превышение максимального числа символов";
        }
    }
    else {
        document.getElementById("error").innerHTML="Не совпадение паролей";

    }

}*/
function hide() {
    alert("Скрипт находится в процессе разработки!");
}
