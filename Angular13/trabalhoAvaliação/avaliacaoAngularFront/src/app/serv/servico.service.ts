import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cidade } from '../modelo/Cidade';
import { Estados } from '../modelo/Estados';

@Injectable({
  providedIn: 'root'
})
export class ServicoService {

  constructor(private http:HttpClient) { }

  listarEstados():Observable<Estados[]>{
    return this.http.get<Estados[]>('https://servicodados.ibge.gov.br/api/v1/localidades/estados?orderBy=nome');
  }
  listarCidades(indice:number):Observable<Cidade[]>{
    return this.http.get<Cidade[]>('https://servicodados.ibge.gov.br/api/v1/localidades/estados/'+indice+'/municipios?orderBy=nome');
  }
}
