import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewResultHistoryComponent } from './view-result-history.component';

describe('ViewResultHistoryComponent', () => {
  let component: ViewResultHistoryComponent;
  let fixture: ComponentFixture<ViewResultHistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewResultHistoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewResultHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
