import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroDeLancamentosComponent } from './cadastro-de-lancamentos.component';

describe('CadastroDeLancamentosComponent', () => {
  let component: CadastroDeLancamentosComponent;
  let fixture: ComponentFixture<CadastroDeLancamentosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroDeLancamentosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroDeLancamentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
