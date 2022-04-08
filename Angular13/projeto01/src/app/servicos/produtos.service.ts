import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../modelo/Produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {

  constructor(private http:HttpClient) { }

  listar():Observable<Produto[]>{
    return this.http.get<Produto[]>('http://localhost:3000/produtos');
  }

  listarProdutoId(indice:number):Observable<Produto>{
    return this.http.get<Produto>('http://localhost:3000/produtos/'+indice);
  }

  cadastrar(p:Produto):Observable<Produto>{
    return this.http.post<Produto>('http://localhost:3000/produtos',p);
  }
  alterar(p:Produto):Observable<Produto>{
    return this.http.put<Produto>('http://localhost:3000/produtos',p);
  }

}
