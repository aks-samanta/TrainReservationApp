import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErdDialogComponent } from './erd-dialog.component';

describe('ErdDialogComponent', () => {
  let component: ErdDialogComponent;
  let fixture: ComponentFixture<ErdDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ErdDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ErdDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
