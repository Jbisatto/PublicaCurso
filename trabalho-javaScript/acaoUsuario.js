
var usuarios = []
    usuarios.push({ "nome": "João", "login": "adm", "senha": "adm", "tipo": 'A' })
    usuarios.push({ "nome": "Maria", "login": "grt", "senha": "grt", "tipo": 'G' })
    usuarios.push({ "nome": "Pedro", "login": "vdd", "senha": "vdd", "tipo": 'V' })


var indiceSelecionado
var usuarioLogado
var nome
var novoLogin
var novaSenha
var tipoUsuario
var alerta
var tipo


window.onload = function () {
    console.log(localStorage.getItem("vetorUsuario"))
    if (localStorage.getItem("vetorUsuario") != null) {
        usuarios = JSON.parse(localStorage.getItem("vetorUsuario"))
    }
}

function salvarUsuarioLocalStorage() {
    localStorage.setItem("vetorUsuario", JSON.stringify(usuarios))
}
function limparForm() {
    document.getElementById("administrador").style.display = "none"
    document.getElementById("gerente").style.display = "none"
    document.getElementById("vendedor").style.display = "none"
    document.getElementById("usuarioForm").style.display = "none"
    document.getElementById("formMarca").style.display = "none"
    document.getElementById("formProduto").style.display = "none"
    document.getElementById("formVendas").style.display = "none"
    document.getElementById("formEstatisticas").style.display = "none"
}


function telaLogin() {
    document.getElementById("usuario").value = ""
    document.getElementById("senha").value = ""
    document.getElementById("login").style.display = "block";
    limparForm();

}

function entrar() {

    var usuario = document.getElementById("usuario").value
    var senha = document.getElementById("senha").value

    console.log(usuario)
    console.log(senha)
    console.table(usuarios)
    var senhaCorreta = false
    for (var i = 0; i < usuarios.length; i++) {
        if (usuario == usuarios[i].login && senha == usuarios[i].senha) {
            localStorage.setItem("usuarioLogado", JSON.stringify(i))
            senhaCorreta = true
            if (usuarios[i].tipo == 'A') {
                document.getElementById("login").style.display = "none"
                document.getElementById("administrador").style.display = "block"
                telaVendas()
                break
            } else if (usuarios[i].tipo == 'G') {
                document.getElementById("login").style.display = "none"
                document.getElementById("gerente").style.display = "block"
                telaVendas()
                break
            } else {
                document.getElementById("login").style.display = "none"
                document.getElementById("vendedor").style.display = "block"
                telaVendas()
                break
            }

        }
    }
    if (!senhaCorreta) {
        alert("Usuário ou senha incorretos")
    }

}

function verificarPreenchimento() {
    nome = document.getElementById("novoNome").value
    novoLogin = document.getElementById("novoLogin").value
    novaSenha = document.getElementById("novaSenha").value
    tipoUsuario = document.getElementById("novoTipo").value
    alerta = document.getElementById("alerta")
    alerta.classList.remove("alert", "alert-danger", "alert-sucess")

    if (nome == "") {
        alerta.innerText = "Favor preencher o campo Nome"
        alerta.classList.add("alert", "alert-danger")
        document.getElementById("novoNome").focus()
    } else
        if (novoLogin == "") {
            alerta.innerText = "Favor preencher o campo Login"
            alerta.classList.add("alert", "alert-danger")
            document.getElementById("novoLogin").focus()
        } else
            if (novaSenha == "") {
                alerta.innerText = "Favor preencher o campo senha"
                alerta.classList.add("alert", "alert-danger")
                document.getElementById("novoSenha").focus()
            } else {
                return true

            }
    return false
}


function cadastrar() {
    console.log(verificarPreenchimento())
    if (verificarPreenchimento()) {
        alerta.innerText = "Cadastro Efetuado"
        alerta.classList.add("alert", "alert-success")
        usuarios.push({ "nome": nome, "login": novoLogin, "senha": novaSenha, "tipo": tipoUsuario })
        salvarUsuarioLocalStorage()
        listarUsuario(tipo)
        limparCampoUsuario()
    }
}
function listarUsuario(tipo) {
    var tabela = document.getElementById("tabela")
    //limpar tabela
    tabela.innerHTML = ""

    for (var i = 0; i < usuarios.length; i++) {
        if (tipo == 'A') {
            var linha = tabela.insertRow(-1)
            var colunaNumero = linha.insertCell(0)
            var colunaNome = linha.insertCell(1)
            var colunaLogin = linha.insertCell(2)
            var colunaSenha = linha.insertCell(3)
            var colunaTipo = linha.insertCell(4)
            var colunaAlterar = linha.insertCell(5)

            colunaNumero.innerHTML = i + 1
            colunaNome.innerHTML = usuarios[i].nome
            colunaLogin.innerHTML = usuarios[i].login
            colunaSenha.innerHTML = usuarios[i].senha
            colunaTipo.innerHTML = usuarios[i].tipo
            if (usuarios[i].tipo == 'A') {
                colunaAlterar.innerHTML = `<button class="btn btn-warning" onClick="selecionarUsuario(${i})">Editar</button>`
            } else {
                colunaAlterar.innerHTML = `<button class="btn btn-warning" onClick="selecionarUsuario(${i})">Editar</button><button class="btn btn-danger" onClick="removerUsuario(${i})">Remover</button>`
            }
        } else {
            if (usuarios[i].tipo == 'V') {
                var linha = tabela.insertRow(-1)
                var colunaNumero = linha.insertCell(0)
                var colunaNome = linha.insertCell(1)
                var colunaLogin = linha.insertCell(2)
                var colunaSenha = linha.insertCell(3)
                var colunaTipo = linha.insertCell(4)
                var colunaAlterar = linha.insertCell(5)

                colunaNumero.innerHTML = i + 1
                colunaNome.innerHTML = usuarios[i].nome
                colunaLogin.innerHTML = usuarios[i].login
                colunaSenha.innerHTML = usuarios[i].senha
                colunaTipo.innerHTML = usuarios[i].tipo
                colunaAlterar.innerHTML = `<button class="btn btn-warning" onClick="selecionarUsuario(${i})">Editar</button><button class="btn btn-danger" onClick="removerUsuario(${i})">Remover</button>`
            }
        }
    }
}

function limparCampoUsuario() {
    document.getElementById("novoNome").value = ""
    document.getElementById("novoLogin").value = ""
    document.getElementById("novaSenha").value = ""
    document.getElementById("novoTipo").value = 'G'

}

function removerUsuario(indice) {
    usuarios.splice(indice, 1)
    salvarUsuarioLocalStorage()
    listarUsuario(tipo)

}

function selecionarUsuario(indice) {
    document.getElementById("tabelaCompleta").style.display = "none"
    document.getElementById("btnCadastrar").style.display = "none"
    document.getElementById("btnAlterar").style.display = "inline-block"
    document.getElementById("btnCancelar").style.display = "inline-block"
    document.getElementById("novoNome").value = usuarios[indice].nome
    document.getElementById("novoLogin").value = usuarios[indice].login
    document.getElementById("novaSenha").value = usuarios[indice].senha
    document.getElementById("novoTipo").value = usuarios[indice].tipo
    indiceSelecionado = indice
}

function cancelarUsuario() {
    document.getElementById("tabelaCompleta").style.display = "inline-table"
    document.getElementById("btnCadastrar").style.display = "inline-block"
    document.getElementById("btnAlterar").style.display = "none"
    document.getElementById("btnCancelar").style.display = "none"
    document.getElementById("novoNome").value = ""
    document.getElementById("novoLogin").value = ""
    document.getElementById("novaSenha").value = ""
    document.getElementById("novoTipo").value = 'V'
}

function alterarUsuario() {
    if (verificarPreenchimento()) {
        alerta.innerText = "Cadastro Alterado"
        alerta.classList.add("alert", "alert-success")
        usuarios[indiceSelecionado] = ({ "nome": nome, "login": novoLogin, "senha": novaSenha, "tipo": tipoUsuario })
        salvarUsuarioLocalStorage()
        listarUsuario(tipo)
        limparCampoUsuario()
        cancelarUsuario()
    }
}


function ocultarAlerta() {
    var alerta = document.getElementById("alerta")
    alerta.classList.remove("alert", "alert-danger", "alert-sucess")
    alerta.innerText = ""
}


function telaUsuario(tp) {
    tipo = tp
    document.getElementById("formEstatisticas").style.display = "none"
    document.getElementById("formVendas").style.display = "none"
    document.getElementById("formProduto").style.display = "none"
    document.getElementById("formMarca").style.display = "none"
    document.getElementById("usuarioForm").style.display = "inline"
    document.getElementById("tabelaCompleta").style.display = "inline-table"
    cancelarUsuario()
    listarUsuario(tipo)
    if (tipo == 'G') {
        document.getElementById("novoTipo").style.display = "none"
    } else {
        document.getElementById("novoTipo").style.display = "inline"
    }
}
