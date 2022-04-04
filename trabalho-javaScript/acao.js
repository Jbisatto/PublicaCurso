
var dados=[]
dados.push({"login":nome.value,"cidade":cidade.value})
dados.push({"login":nome.value,"cidade":cidade.value})
dados.push({"login":nome.value,"cidade":cidade.value})


function entrar() {

    var usuario = document.getElementById("usuario").value
    var senha = document.getElementById("senha").value

    if (usuario == "a" && senha == "a") {
        document.getElementById("login").style.display = "none";
        document.getElementById("administrador").style.display = "block";
    } else if (usuario == "g" && senha == "g") {
        document.getElementById("login").style.display = "none";
        document.getElementById("gerente").style.display = "block";
    }else if (usuario == "v" && senha == "v") {
        document.getElementById("login").style.display = "none";
        document.getElementById("vendedor").style.display = "block";
    }else{
        alert("Usuário ou senha incorretos")
    }


}