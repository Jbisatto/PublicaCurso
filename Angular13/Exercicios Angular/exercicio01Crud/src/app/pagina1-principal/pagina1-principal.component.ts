import { JsonPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import{Cargo} from '../modelo/cargo';
import{Pessoa} from '../modelo/Pessoa';

@Component({
  selector: 'app-pagina1-principal',
  templateUrl: './pagina1-principal.component.html',
  styleUrls: ['./pagina1-principal.component.css']
})
export class Pagina1PrincipalComponent implements OnInit {
  cargos: Cargo[] = [];
  cargo:Cargo= new Cargo();
  objCargo:Cargo = new Cargo();
  objPessoa:Pessoa = new Pessoa();
 
  

  formulario = new FormGroup({
    selectCargo: new FormControl(),
    selectGenero: new FormControl(),
    

    
  });
  
   
  btnVisivel:boolean=false;

  constructor() { }

  ngOnInit(): void {
    this.formulario.get("selectCargo")?.setValue('A');
    this.formulario.get("selectGenero")?.setValue('N');
      
  }

  cadastrarCargo = () =>{
    console.table(this.cargos);
    let cargo = new Cargo();
    cargo.nomeCargo = this.objCargo.nomeCargo
    cargo.salario = this.objCargo.salario
    this.cargos.push(cargo);
    this.btnVisivel=true;
    
  }

  cadastrarPessoa =() =>{
    let pessoa = new Pessoa();
    if(this.formulario.value.selectCargo!="A"){
    pessoa.cargo= (this.formulario.value.selectCargo);
    }else{
      alert("Selecione um cargo!!!")
    }
  }

}
