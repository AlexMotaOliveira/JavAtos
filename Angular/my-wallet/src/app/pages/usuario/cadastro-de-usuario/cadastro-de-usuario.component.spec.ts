import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroDeUsuarioComponent } from './cadastro-de-usuario.component';

describe('CadastroDeUsuarioComponent', () => {
  let component: CadastroDeUsuarioComponent;
  let fixture: ComponentFixture<CadastroDeUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroDeUsuarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroDeUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
