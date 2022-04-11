import { Component, OnInit } from '@angular/core';
import { Produto } from '../modelo/Produto';
import { ProdutosService } from '../servicos/produtos.service';

@Component({
  selector: 'app-pg3',
  templateUrl: './pg3.component.html',
  styleUrls: ['./pg3.component.css']
})
export class Pg3Component implements OnInit {

  produtos: Produto[] = [];

  objProduto: Produto = new Produto();


  btnVisivel: boolean = true;

  constructor(private servico: ProdutosService) { }

  ngOnInit(): void {
    this.obterProdutos();
  }

  obterProdutos = () => {
    this.servico.listar()
      .subscribe(retorno => this.produtos = retorno);
  }

  cadastrar = () => {
    this.servico.cadastrar(this.objProduto)
      .subscribe(retorno => this.produtos.push(retorno))
    this.limparCampo();
  }

  selecionarProduto(indice: number) {
    this.btnVisivel = false;
    this.obterProdutosId(indice);
  }
  obterProdutosId = (indice: number) => {
    this.servico.listarProdutoId(indice)
      .subscribe(retorno => this.objProduto = retorno);
  }

  alterar = () => {
    this.servico.alterar(this.objProduto)
      .subscribe(retorno => this.produtos[this.produtos.findIndex((p => p.id == this.objProduto.id))] = retorno);
    this.limparCampo();
  }

  remover = () => {
    this.servico.removerProduto(this.objProduto.id)
      .subscribe(retorno => {
        let indiceVetor = this.produtos.findIndex(objVetor => { return objVetor.id == this.objProduto.id })
        this.produtos.splice(indiceVetor, 1)
      });
    this.limparCampo();
  }

  cancelar = () => {
    this.limparCampo();
    this.btnVisivel = true;
  }

  limparCampo() {
    this.objProduto.id = 0;
    this.objProduto.produto = "";
    this.objProduto.marca = "";
    this.objProduto.valor = 0;
  }
}
