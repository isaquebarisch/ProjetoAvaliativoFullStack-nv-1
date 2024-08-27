import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormArray } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-game-modal',
  templateUrl: './game-modal.component.html',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  styleUrls: ['./game-modal.component.css']
})
export class GameModalComponent implements OnInit {
  gameForm!: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient) { }

  ngOnInit(): void {
    this.gameForm = this.fb.group({
      name: ['', Validators.required],
      images: this.fb.array(['']),
      category: this.fb.array(['']),
      description: [''],
      platform: this.fb.array(['']),
      price: ['', [Validators.required, Validators.min(0)]],
      ageRating: ['', [Validators.required, Validators.min(0)]],
      releaseYear: ['', [Validators.required, Validators.min(1900)]],
      developer: [''],
      publisher: [''],
      rating: ['', [Validators.required, Validators.min(0), Validators.max(10)]]
    });
  }

  get images(): FormArray {
    return this.gameForm.get('images') as FormArray;
  }

  get category(): FormArray {
    return this.gameForm.get('category') as FormArray;
  }

  get platform(): FormArray {
    return this.gameForm.get('platform') as FormArray;
  }

  addImage(): void {
    this.images.push(this.fb.control(''));
  }

  removeImage(index: number): void {
    this.images.removeAt(index);
  }

  addCategory(): void {
    this.category.push(this.fb.control(''));
  }

  removeCategory(index: number): void {
    this.category.removeAt(index);
  }

  addPlatform(): void {
    this.platform.push(this.fb.control(''));
  }

  removePlatform(index: number): void {
    this.platform.removeAt(index);
  }

  onSubmit(): void {
    console.log(this.gameForm.value);
    if (this.gameForm.valid) {
      this.http.post('http://localhost:8080/games', this.gameForm.value)
        .subscribe({
          next: () => alert('Game added successfully'),
          error: (err) => console.error('Error adding game', err)
        });
    }
  }
}
