
var vendas = []
var usuarioLogado

window.onload = function () {
    if (localStorage.getItem("vetorVendas") != null) {
        vendas = JSON.parse(localStorage.getItem("vetorVendas"))
    }
}

function salvarVendaLocalStorage() {
    localStorage.setItem("vetorVendas", JSON.stringify(vendas))
}

function telaVendas() {
    if (localStorage.getItem("usuarioLogado") != null) {
        usuarioLogado = JSON.parse(localStorage.getItem("usuarioLogado"))
    }
    document.getElementById("nomeVendedor").innerText = "Vendendor: " + usuarios[usuarioLogado].nome
    document.getElementById("formEstatisticas").style.display = "none"
    document.getElementById("formProduto").style.display = "none"
    document.getElementById("formMarca").style.display = "none"
    document.getElementById("usuarioForm").style.display = "none"
    document.getElementById("tabelaCompleta").style.display = "none"
    document.getElementById("btnAlterarProduto").style.display = "none"
    document.getElementById("btnCancelarProduto").style.display = "none"
    document.getElementById("formVendas").style.display = "inline"
    document.getElementById("tabelaCompletaVendas").style.display = "inline-table"
    listarProdutosVenda()
    mostrarListaDeVendas()

}

function listarProdutosVenda() {
    var tabelaP = document.getElementById("tabelaVendas")
    //limpar tabela
    tabelaP.innerHTML = ""

    for (var i = 0; i < produtos.length; i++) {
        console.log(produtos[i].nome)
        var linha = tabelaP.insertRow(-1)
        var colunaNumero = linha.insertCell(0)
        var colunaProduto = linha.insertCell(1)
        var colunaMarca = linha.insertCell(2)
        var colunaValor = linha.insertCell(3)
        var colunaAlterar = linha.insertCell(4)

        colunaNumero.innerHTML = i + 1
        colunaProduto.innerHTML = produtos[i].nome
        colunaMarca.innerHTML = marcas[produtos[i].marca].nome
        colunaValor.innerHTML = parseFloat(produtos[i].valor).toLocaleString('pt-br',{style: 'currency', currency: 'BRL'})
        colunaAlterar.innerHTML = `<button class="btn btn-warning" onClick="venderProduto(${i})">Vender</button>`

    }
}

function venderProduto(id_produto) {
    vendas.push({ "id_vendedor": usuarioLogado, "id_produto": id_produto })
    mostrarListaDeVendas()
    salvarVendaLocalStorage()
}

function mostrarListaDeVendas() {
    mostrarListaVendas = document.getElementById("mostrarListaVendas")
    var lista = ""
    for (var i = 0; i < vendas.length; i++) {
        if (vendas[i].id_vendedor == usuarioLogado) {
            lista += produtos[vendas[i].id_produto].nome + "<BR>"
        }
    }
    mostrarListaVendas.innerHTML = lista
}