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

  btnVisivel:boolean=true;

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
  }

  selecionarProduto(indice:number){
    this.btnVisivel=false;
    this.obterProdutosId(indice);
  }
  obterProdutosId = (indice:number) => {
    this.servico.listarProdutoId(indice)
      .subscribe(retorno => this.objProduto = retorno);
  }

  alterar = () =>{
    this.servico.alterar(this.objProduto)
    .subscribe(retorno => this.produtos[this.produtos.findIndex((objProduto)=>{
      return objProduto.id==3
    })])
  }
}
