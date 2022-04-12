import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Cidade } from '../modelo/Cidade';
import { Estados } from '../modelo/Estados';
import { ServicoService } from '../serv/servico.service';
import emailMask from 'text-mask-addons/dist/emailMask';
import { Pessoa } from '../modelo/Pessoa';

@Component({
  selector: 'app-pg-principal',
  templateUrl: './pg-principal.component.html',
  styleUrls: ['./pg-principal.component.css']
})
export class PgPrincipalComponent implements OnInit {
  indicePessoa: number = 0;
  emailMask = emailMask;
  btnVisivel: boolean = true;
  estado: Estados = new Estados();
  estados: Estados[] = [];
  cidades: Cidade[] = [];
  pessoas: Pessoa[] = [];
  objPessoa: Pessoa = new Pessoa();

  formulario = new FormGroup({
    cbxEstado: new FormControl(),
    cbxCidade: new FormControl(),
    campoNome: new FormControl(),
    campoEmail: new FormControl(),
    campoTelefone: new FormControl()

  });

  constructor(private servico: ServicoService) { }

  ngOnInit(): void {
    this.limparCombo();
    this.obterPessoas();
    this.obterEstados();
    this.obterCidades(0);
    console.table(this.estados);

  }

  obterEstados = () => {
    this.servico.listarEstados()
      .subscribe(retorno => this.estados = retorno);
  }
  obterPessoas = () => {
    this.servico.listarUsuarios()
      .subscribe(retorno => this.pessoas = retorno);
  }
  obterEstadosId = (indice: number) => {
    this.servico.listarEstadosId(indice)
      .subscribe(retorno => this.estado = retorno);
  }
  obterCidades = (indice: number) => {
    return new Promise((resolve, reject) => {
      this.servico.listarCidades(indice)
        .subscribe(retorno => {
          this.cidades = retorno;
          resolve(retorno);
        });
    })
  }

  selecaoEstado = () => {
    this.obterCidades(this.estados[this.formulario.value.cbxEstado].id);
  }
  cadastrar = () => {
    this.servico.cadastrarPessoa(this.verificaPessoa())
      .subscribe(retorno => this.pessoas.push(retorno));
    this.limparCombo();

  }


  verificaPessoa = () => {
    let pessoa = new Pessoa();
    pessoa.nome = this.formulario.value.campoNome;
    pessoa.email = this.formulario.value.campoEmail;
    pessoa.cidade = this.cidades[this.formulario.value.cbxCidade].nome;
    pessoa.estado = this.estados[this.formulario.value.cbxEstado].nome;
    pessoa.telefone = this.formulario.value.campoTelefone;
    this.objPessoa=pessoa;
    this.objPessoa.id=this.indicePessoa;
    return pessoa;
  }

  async selecionarPessoa(indice: number) {
    this.btnVisivel = false;
    this.indicePessoa = indice;
    this.formulario.get("campoNome")?.setValue(this.pessoas[indice].nome);
    this.formulario.get("campoEmail")?.setValue(this.pessoas[indice].email);
    this.formulario.get("campoTelefone")?.setValue(this.pessoas[indice].telefone);
    this.formulario.get("cbxEstado")?.setValue(this.buscaIndexEstado(this.pessoas[indice].estado));

    await this.obterCidades(this.estados[this.buscaIndexEstado(this.pessoas[indice].estado)].id);

    this.formulario.get("cbxCidade")?.setValue(this.buscaIndexCidade(this.pessoas[indice].cidade));


  }

  cancelar = () => {
    this.btnVisivel = true;
    this.limparCombo();
  }

  limparCombo() {
    this.formulario.reset();
    this.formulario.get("cbxEstado")?.setValue("A");
    this.formulario.get("cbxCidade")?.setValue("B");

  }
  buscaIndexEstado = (nome: string) => {
    for (let i = 0; i < this.estados.length; i++) {
      if (nome == this.estados[i].nome) {
        return i;
      }
    }
    return 0;
  }
  buscaIndexCidade = (nome: string) => {
    for (let i = 0; i < this.cidades.length; i++) {
      if (nome == this.cidades[i].nome) {
        return i;
      }
    }
    return 0;
  }

  removerPessoa = () => {
    this.servico.removerPessoaServico(this.objPessoa.id)
      .subscribe(retorno => {
        let indiceVetor = this.pessoas.findIndex(objVetor => { return objVetor.id == this.objPessoa.id })
        this.pessoas.splice(indiceVetor, 1)
      });
    this.limparCombo();
  }

  alterarPessoa = () => {
    this.servico.alterarPessoaServico(this.verificaPessoa())
      .subscribe(retorno => this.pessoas[this.pessoas.findIndex((p => p.id == this.objPessoa.id))] = retorno);
    this.limparCombo();

  }

}
