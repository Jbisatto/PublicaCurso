import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pagina1PrincipalComponent } from './pagina1-principal.component';

describe('Pagina1PrincipalComponent', () => {
  let component: Pagina1PrincipalComponent;
  let fixture: ComponentFixture<Pagina1PrincipalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Pagina1PrincipalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Pagina1PrincipalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
