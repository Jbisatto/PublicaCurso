var marcas = []

marcas.push({ "nome": "Acer" })
marcas.push({ "nome": "Dell" })
marcas.push({ "nome": "Asus" })

var produtos = []
produtos.push({ "nome": "Nitro 5", "marca": "0", "valor": "4999" })
produtos.push({ "nome": "Insprion", "marca": "1", "valor": "3999" })
produtos.push({ "nome": "Zen Book", "marca": "2", "valor": "4699" })

var nomeMarca
var nomeProduto
var valorProduto
var alerta
var alertaP
var indiceMarca
var indiceProduto

window.onload = function () {
    if (localStorage.getItem("vetorMarca") != null) {
        marcas = JSON.parse(localStorage.getItem("vetorMarca"))
    }
    if (localStorage.getItem("vetorProduto") != null) {
        produtos = JSON.parse(localStorage.getItem("vetorProduto"))
    }
}

function salvarMarcaLocalStorage() {
    localStorage.setItem("vetorMarca", JSON.stringify(marcas))
}

function salvarProdutoLocalStorage() {
    localStorage.setItem("vetorProduto", JSON.stringify(produtos))
}

function telaMarcas() {
    document.getElementById("formEstatisticas").style.display = "none"
    document.getElementById("formVendas").style.display = "none"
    document.getElementById("formProduto").style.display = "none"
    document.getElementById("usuarioForm").style.display = "none"
    document.getElementById("tabelaCompleta").style.display = "none"
    document.getElementById("btnAlterarMarca").style.display = "none"
    document.getElementById("btnCancelarMarca").style.display = "none"
    document.getElementById("formMarca").style.display = "inline"
    document.getElementById("tabelaCompletaMarca").style.display = "inline-table"
    cancelarMarca()
    listarMarca()

}

function cancelarMarca() {
    document.getElementById("tabelaCompletaMarca").style.display = "inline-table"
    document.getElementById("btnCadastrarMarca").style.display = "inline-block"
    document.getElementById("btnAlterarMarca").style.display = "none"
    document.getElementById("btnCancelarMarca").style.display = "none"
    document.getElementById("nomeMarca").value = ""
}

function verificarPreenchimentoMarca() {
    nomeMarca = document.getElementById("nomeMarca").value
    alerta = document.getElementById("alertaMarca")
    alerta.classList.remove("alert", "alert-danger", "alert-sucess")

    if (nomeMarca == "") {
        alerta.innerText = "Favor preencher o campo Marca"
        alerta.classList.add("alert", "alert-danger")
        document.getElementById("nomeMarca").focus()
    } else {
        return true
    }
    return false
}


function cadastrarMarca() {
    if (verificarPreenchimentoMarca()) {
        alerta.innerText = "Marca Cadastrada"
        alerta.classList.add("alert", "alert-success")
        marcas.push({ "nome": nomeMarca })
        salvarMarcaLocalStorage()
        listarMarca()
        limparCampoMarca()
    }
}

function listarMarca() {
    var tabela = document.getElementById("tabelaMarca")
    //limpar tabela
    tabela.innerHTML = ""

    for (var i = 0; i < marcas.length; i++) {
        var linha = tabela.insertRow(-1)
        var colunaNumero = linha.insertCell(0)
        var colunaNome = linha.insertCell(1)
        var colunaAlterar = linha.insertCell(2)

        colunaNumero.innerHTML = i + 1
        colunaNome.innerHTML = marcas[i].nome
        colunaAlterar.innerHTML = `<button class="btn btn-warning" onClick="selecionarMarca(${i})">Editar</button><button class="btn btn-danger" onClick="removerMarcas(${i})">Remover</button>`

    }
}

function limparCampoMarca() {
    document.getElementById("nomeMarca").value = ""

}
function ocultarAlertaMarca() {
    alerta = document.getElementById("alertaMarca")
    alerta.classList.remove("alert", "alert-danger", "alert-sucess")
    alerta.innerText = ""
}

function selecionarMarca(indice) {
    document.getElementById("tabelaCompletaMarca").style.display = "none"
    document.getElementById("btnCadastrarMarca").style.display = "none"
    document.getElementById("btnAlterarMarca").style.display = "inline-block"
    document.getElementById("btnCancelarMarca").style.display = "inline-block"
    document.getElementById("nomeMarca").value = marcas[indice].nome
    indiceMarca = indice
}

function alterarMarca() {
    if (verificarPreenchimentoMarca()) {
        alerta.innerText = "Marca Alterada"
        alerta.classList.add("alert", "alert-success")
        marcas[indiceMarca] = ({ "nome": nomeMarca })
        salvarMarcaLocalStorage()
        listarMarca()
        limparCampoMarca()
        cancelarMarca()
    }
}
function removerMarcas(indice) {
    let exclui = false
    for (var i = 0; i < produtos.length; i++) {
        if (produtos[i].marca == indice) {
            exclui = true
        }
    }
    if (!exclui) {
        marcas.splice(indice, 1)
        salvarMarcaLocalStorage()
        listarMarca()
    } else {
        alert("Essa Marca não pode ser excluída porque tem um produto vinculado a ela!!!")
    }
}

// Produtos

function telaProdutos() {
    document.getElementById("formEstatisticas").style.display = "none"
    document.getElementById("formVendas").style.display = "none"
    document.getElementById("formMarca").style.display = "none"
    document.getElementById("usuarioForm").style.display = "none"
    document.getElementById("tabelaCompleta").style.display = "none"
    document.getElementById("btnAlterarProduto").style.display = "none"
    document.getElementById("btnCancelarProduto").style.display = "none"
    document.getElementById("formProduto").style.display = "inline"
    document.getElementById("tabelaCompletaProduto").style.display = "inline-table"
    carregarMarcas()
    limparCampoProduto()
    listarProdutos()

}

function carregarMarcas() {
    document.getElementById("marcasProdutos").replaceChildren("")
    for (var i = 0; i < marcas.length; i++) {
        const node = document.createElement("option")
        const textnode = document.createTextNode(marcas[i].nome)
        node.appendChild(textnode)
        node.value = i
        document.getElementById("marcasProdutos").appendChild(node)
    }
}

function listarProdutos() {
    var tabelaP = document.getElementById("tabelaProduto")
    //limpar tabela
    tabelaP.innerHTML = ""

    for (var i = 0; i < produtos.length; i++) {
        var linha = tabelaP.insertRow(-1)
        var colunaNumero = linha.insertCell(0)
        var colunaProduto = linha.insertCell(1)
        var colunaMarca = linha.insertCell(2)
        var colunaValor = linha.insertCell(3)
        var colunaAlterar = linha.insertCell(4)

        colunaNumero.innerHTML = i + 1
        colunaProduto.innerHTML = produtos[i].nome
        colunaMarca.innerHTML = marcas[produtos[i].marca].nome
        colunaValor.innerHTML = parseFloat(produtos[i].valor).toLocaleString('pt-br', { style: 'currency', currency: 'BRL' })
        colunaAlterar.innerHTML = `<button class="btn btn-warning" onClick="selecionarProduto(${i})">Editar</button><button class="btn btn-danger" onClick="removerProduto(${i})">Remover</button>`

    }
}

function cadastrarProduto() {
    if (verificarPreenchimentoProduto()) {
        alertaP.innerText = "Produto Cadastrado"
        alertaP.classList.add("alert", "alert-success")
        produtos.push({ "nome": nomeProduto, "marca": document.getElementById("marcasProdutos").value, "valor": valorProduto })
        salvarProdutoLocalStorage()
        listarProdutos()
        limparCampoProduto()
    }
}

function verificarPreenchimentoProduto() {
    nomeProduto = document.getElementById("nomeProduto").value
    valorProduto = document.getElementById("valorProduto").value
    alertaP = document.getElementById("alertaProduto")
    alertaP.classList.remove("alert", "alert-danger", "alert-sucess")

    if (nomeProduto == "") {
        alertaP.innerText = "Favor preencher o campo Produto"
        alertaP.classList.add("alert", "alert-danger")
        document.getElementById("nomeProduto").focus()
    } else if (valorProduto == "") {
        alertaP.innerText = "Favor preencher o campo Valor"
        alertaP.classList.add("alert", "alert-danger")
        document.getElementById("valorProduto").focus()
    } else {
        return true
    }
    return false
}

function ocultarAlertaProduto() {
    alerta = document.getElementById("alertaProduto")
    alerta.classList.remove("alert", "alert-danger", "alert-sucess")
    alerta.innerText = ""
}

function limparCampoProduto() {
    document.getElementById("nomeProduto").value = ""
    document.getElementById("valorProduto").value = ""
    document.getElementById("marcasProdutos").value = 0
}


function alterarProduto() {
    if (verificarPreenchimentoProduto()) {
        alerta.innerText = "Produto Alterada"
        alerta.classList.add("alert", "alert-success")
        produtos[indiceProduto] = ({ "nome": nomeProduto, "marca": document.getElementById("marcasProdutos").value, "valor": valorProduto })
        salvarProdutoLocalStorage()
        listarProdutos()
        limparCampoProduto()
        cancelarProduto()
    }
}

function selecionarProduto(indice) {
    document.getElementById("tabelaCompletaProduto").style.display = "none"
    document.getElementById("btnCadastrarProduto").style.display = "none"
    document.getElementById("btnAlterarProduto").style.display = "inline-block"
    document.getElementById("btnCancelarProduto").style.display = "inline-block"
    document.getElementById("nomeProduto").value = produtos[indice].nome
    document.getElementById("valorProduto").value = produtos[indice].valor
    document.getElementById("marcasProdutos").value = produtos[indice].marca
    indiceProduto = indice
}

function cancelarProduto() {
    document.getElementById("tabelaCompletaProduto").style.display = "inline-table"
    document.getElementById("btnCadastrarProduto").style.display = "inline-block"
    document.getElementById("btnAlterarProduto").style.display = "none"
    document.getElementById("btnCancelarProduto").style.display = "none"
    limparCampoProduto()
}

function removerProduto(indice) {
    produtos.splice(indice, 1)
    salvarProdutoLocalStorage()
    listarProdutos()
}
