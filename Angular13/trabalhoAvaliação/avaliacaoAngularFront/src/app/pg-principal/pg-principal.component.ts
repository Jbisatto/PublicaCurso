import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Cidade } from '../modelo/Cidade';
import { Estados } from '../modelo/Estados';
import { ServicoService } from '../serv/servico.service';

@Component({
  selector: 'app-pg-principal',
  templateUrl: './pg-principal.component.html',
  styleUrls: ['./pg-principal.component.css']
})
export class PgPrincipalComponent implements OnInit {

  btnVisivel:boolean=true;
  estado:Estados = new Estados();
  estados:Estados[] = [];
  cidades:Cidade[] = [];

  formulario = new FormGroup({
    cbxEstado: new FormControl(),
    cbxCidade: new FormControl()
   
  });

  constructor(private servico: ServicoService) { }

  ngOnInit(): void {
    this.obterEstados();
    this.obterCidades(0);
    console.table(this.estados);
 
  }

  obterEstados = () => {
    this.servico.listarEstados()
      .subscribe(retorno => this.estados = retorno);
  }
  obterCidades = (indice:number) => {
    this.servico.listarCidades(indice)
      .subscribe(retorno => this.cidades = retorno);
  }

  selecaoEstado = () =>{
    this.obterCidades(this.estados[this.formulario.value.cbxEstado].id);
  }

}
