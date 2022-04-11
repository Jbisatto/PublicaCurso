import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PgPrincipalComponent } from './pg-principal/pg-principal.component';

const routes: Routes = [
  {path:'pg1', component:PgPrincipalComponent},
  {path:'', redirectTo:'pg1',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
