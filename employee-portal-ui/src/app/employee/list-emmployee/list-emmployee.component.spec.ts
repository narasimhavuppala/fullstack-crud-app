import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListEmmployeeComponent } from './list-emmployee.component';

describe('ListEmmployeeComponent', () => {
  let component: ListEmmployeeComponent;
  let fixture: ComponentFixture<ListEmmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListEmmployeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListEmmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
