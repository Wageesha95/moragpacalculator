import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SemesterEditorComponent } from './semester-editor.component';

describe('SemesterEditorComponent', () => {
  let component: SemesterEditorComponent;
  let fixture: ComponentFixture<SemesterEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SemesterEditorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SemesterEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
