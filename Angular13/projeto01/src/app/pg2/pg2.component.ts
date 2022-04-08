import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Pessoa } from '../modelo/Pessoa';

@Component({
  selector: 'app-pg2',
  templateUrl: './pg2.component.html',
  styleUrls: ['./pg2.component.css']
})
export class Pg2Component implements OnInit {

  // campoNome:string='';
  obj: Pessoa = new Pessoa();


  constructor() { }

  formulario = new FormGroup({
    nome: new FormControl(),
    idade: new FormControl()

  });

  enviar = () =>{
    this.formulario.reset();
  }


  ngOnInit(): void {
  }

}
