import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AmigoCardComponent } from './amigo-card.component';

describe('AmigoCardComponent', () => {
  let component: AmigoCardComponent;
  let fixture: ComponentFixture<AmigoCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AmigoCardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AmigoCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
