

function telaEstatisticas() {
    document.getElementById("formVendas").style.display = "none"
    document.getElementById("formProduto").style.display = "none"
    document.getElementById("formMarca").style.display = "none"
    document.getElementById("usuarioForm").style.display = "none"
    document.getElementById("tabelaCompleta").style.display = "none"
    document.getElementById("btnAlterarProduto").style.display = "none"
    document.getElementById("btnCancelarProduto").style.display = "none"
    document.getElementById("formEstatisticas").style.display = "inline"
    document.getElementById("tabelaCompletaEstatisticas").style.display = "inline-table"
    // listarProdutosVenda()
    // mostrarListaDeVendas()
    listarEstatisticas()

}

function listarEstatisticas() {
    var tabelaP = document.getElementById("tabelaEstatisticas")
    var total
    var estruturaModal = ""
    tabelaP.innerHTML = ""
    for (var i = 0; i < usuarios.length; i++) {
        total = 0
        for (var j = 0; j < vendas.length; j++) {
            if (i == vendas[j].id_vendedor) {
                total += parseFloat(produtos[vendas[j].id_produto].valor)
            }
        }
        var linha = tabelaP.insertRow(-1)
        var colunaVendedor = linha.insertCell(0)
        var colunaTotal = linha.insertCell(1)
        var colunaVisualizar = linha.insertCell(2)

        colunaVendedor.innerHTML = usuarios[i].nome
        colunaTotal.innerHTML = total.toLocaleString('pt-br',{style: 'currency', currency: 'BRL'})
        colunaVisualizar.innerHTML=`<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal${i}">Visualizar Vendas</button>`
        estruturaModal += `
        <div class="modal fade" id="exampleModal${i}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">${usuarios[i].nome}</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table class="table" id="tabelaCompletaEstatisticas">
                        <thead>
                            <tr>
                               <th>Produto</th>
                                <th>Valor(R$)</th>
                            </tr>
                        </thead>
                        <tbody>${mostrarVendaVendendor(i)}</tbody>
                    </table>                
                </div>
                <div class="teste32">
                    <h4 id="totalVendendor">Total: ${total.toLocaleString('pt-br',{style: 'currency', currency: 'BRL'})}</h4>
                </div>
                <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
                </div>
            </div>
            </div>
        `

    }
    document.getElementById("modais").innerHTML = estruturaModal
}
function mostrarVendaVendendor(vendedor) {
    var lista = ""
    for (var i = 0; i < vendas.length; i++) {
        if (vendas[i].id_vendedor == vendedor) {
            lista+="<tr><th>"+produtos[vendas[i].id_produto].nome+"</th><th>"+parseFloat(produtos[vendas[i].id_produto].valor).toLocaleString('pt-br',{style: 'currency', currency: 'BRL'})+"</th></tr>"
        }
    }
    return lista
}