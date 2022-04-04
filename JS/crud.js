//vetor
var dados=[]

window.onload=function(){
    if(localStorage.getItem("vetor")!=null){
        dados = JSON.parse(localStorage.getItem("vetor"))
        listar()
    }
}

var indiceSelecionado

//Salvar LocalStorage
function salvarNoLocalStorage(){
    localStorage.setItem("vetor",JSON.stringify(dados))
}

//cadastrar
function cadastrar(){
    var nome = document.getElementById("nome")
    var cidade = document.getElementById("cidade")
    var alerta = document.getElementById("alerta")
    alerta.classList.remove("alert","alert-danger","alert-sucess")

    if(nome.value==""){
        alerta.innerText="Favor preencher o campo nome"
        alerta.classList.add("alert","alert-danger")
        nome.focus()
    }else
    if(cidade.value==""){
        alerta.innerText="Favor preencher o campo cidade"
        alerta.classList.add("alert","alert-danger")
        cidade.focus()
    }else{
        dados.push({"nome":nome.value,"cidade":cidade.value})
        nome.value=""
        cidade.value=""
        nome.focus()
        //console.table(dados)
        alerta.innerText="Cadastro Efetuado"
        alerta.classList.add("alert","alert-success")
        listar();
        salvarNoLocalStorage()
    }

    //alert(nome.value +"\n"+cidade.value)

}
function ocultarAlerta(){
    var alerta = document.getElementById("alerta")
    alerta.classList.remove("alert","alert-danger","alert-sucess")
    alerta.innerText=""
}


function listar(){
    var tabela = document.getElementById("tabela")
    //limpar tabela
    tabela.innerHTML = ""

    for(var i=0;i<dados.length;i++){
        var linha = tabela.insertRow(-1)
        var colunaNumero = linha.insertCell(0)
        var colunaNome = linha.insertCell(1)
        var colunaCidade = linha.insertCell(2)
        var colunaSelecionar = linha.insertCell(3)

        colunaNumero.innerHTML = i+1
        colunaNome.innerHTML = dados[i].nome
        colunaCidade.innerHTML = dados[i].cidade
        colunaSelecionar.innerHTML = `<button class="btn btn-success" onClick="selecionar(${i})">Selecionar</button>`
    }
}

function selecionar(indice){
    document.getElementById("nome").value= dados[indice].nome
    document.getElementById("cidade").value = dados[indice].cidade

    indiceSelecionado = indice

    document.getElementById("btnCadastrar").style.display = "none"
    document.getElementById("btnAlterar").style.display = "inline-block"
    document.getElementById("btnRemover").style.display = "inline-block"
    document.getElementById("btnCancelar").style.display = "inline-block"
}

function remover(){
    dados.splice(indiceSelecionado, 1)
    listar()
    resetarDados()
    salvarNoLocalStorage()

}

function resetarDados(){
    document.getElementById("nome").value=""
    document.getElementById("cidade").value=""
    document.getElementById("btnCadastrar").style.display = "inline-block"
    document.getElementById("btnAlterar").style.display = "none"
    document.getElementById("btnRemover").style.display = "none"
    document.getElementById("btnCancelar").style.display = "none"
    ocultarAlerta()

}

//Aletar
function alterar(){
    var nome = document.getElementById("nome")
    var cidade = document.getElementById("cidade")
    var alerta = document.getElementById("alerta")
    alerta.classList.remove("alert","alert-danger","alert-sucess")

    if(nome.value==""){
        alerta.innerText="Favor preencher o campo nome"
        alerta.classList.add("alert","alert-danger")
        nome.focus()
    }else
    if(cidade.value==""){
        alerta.innerText="Favor preencher o campo cidade"
        alerta.classList.add("alert","alert-danger")
        cidade.focus()
    }else{
        dados[indiceSelecionado]=
        ({"nome":nome.value,"cidade":cidade.value})
        resetarDados()
        nome.focus()
        //console.table(dados)
        alerta.innerText="Alteração Efetuado"
        alerta.classList.add("alert","alert-success")
        listar();
    }
    salvarNoLocalStorage()
}
