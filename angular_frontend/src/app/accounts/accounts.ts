import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-accounts',
  imports: [CommonModule],
  templateUrl: './accounts.html',
  styleUrl: './accounts.css',
})
export class Accounts implements OnInit{
  accounts: any;
  constructor(private http: HttpClient) {}
  ngOnInit(): void {
    this.http.get('http://localhost:8888/ACCOUNT-SERVICE/accounts')
      .subscribe({
        next: (data) => {
          //console.log(data);
          this.accounts = data;
        },
        error: (error) => {
          console.log(error);
        }
      })
  }

}
