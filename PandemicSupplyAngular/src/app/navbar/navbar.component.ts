import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  buttonVal : String;

  constructor() { }

  ngOnInit() {
    this.buttonVal = 'Log-in';
  }

  userInfo(){
    this.buttonVal = 'Log-out';
    document.getElementById('close-modal').click();
  }

  modelButtonResponse(){
    if(this.buttonVal == 'Log-in'){
      document.getElementById('open-modal').click();
    } else {
      this.buttonVal = 'Log-in';
    }
  }
}
