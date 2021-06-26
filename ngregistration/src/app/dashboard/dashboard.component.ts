import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  candidateId: any = 0;
  companyForm: FormGroup;
  submitted:boolean = false;
  loading = false;
  callDetails: any =[];
  constructor(private formBuilder: FormBuilder, private userService:RegistrationService, private router:Router) { 
    this.companyForm = this.formBuilder.group({
      name: ['', Validators.required],
    })
  }
  

  ngOnInit(): void {
    this.candidateId =localStorage.getItem("candidateId");
    if(this.candidateId) {
      this.getCallDetails();
    } else {
      this.router.navigate(['/login']);
    }
    
  }

  get f() { return this.companyForm.controls; }

  getCallDetails() {
    this.userService.getCallDetails(this.candidateId).subscribe(data => {
      console.log(data);
      this.callDetails = data;
    })
  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.companyForm.invalid) {
        return;
    }

    this.loading = true;
    this.userService.addCallDetails(this.companyForm.value['name'], this.candidateId)
        .subscribe((data:any) => {
          this.getCallDetails();
          this.loading= false;
    })


}

}
