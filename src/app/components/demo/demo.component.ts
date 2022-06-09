import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {
  port?: string;
  targetUrl: string = "http://localhost:";
  
  constructor() { }

  ngOnInit(): void {
    this.port = history.state.data;
    this.targetUrl = this.targetUrl + this.port; 
    console.log(this.port);
  
  }
  goToLink(){
    // this.targetUrl = this.targetUrl + this.port;
    window.open(this.targetUrl, "_blank");
}

}
