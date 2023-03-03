import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListagemDeUsuarioComponent } from './listagem-de-usuario.component';

describe('ListagemDeUsuarioComponent', () => {
  let component: ListagemDeUsuarioComponent;
  let fixture: ComponentFixture<ListagemDeUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListagemDeUsuarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListagemDeUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
