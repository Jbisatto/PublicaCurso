import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Pagina1PrincipalComponent } from './pagina1-principal/pagina1-principal.component';

const routes: Routes = [
  {path:'pg1', component:Pagina1PrincipalComponent},
  {path:'', redirectTo:'pg1',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
