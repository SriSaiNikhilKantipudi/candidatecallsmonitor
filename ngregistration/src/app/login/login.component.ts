import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { RegistrationService } from '../registration.service';
import { User } from '../user';



@Component({templateUrl: 'login.component.html'})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string = '/loginsuccess';

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private userService: RegistrationService,      
    ) {
      this.loginForm = this.formBuilder.group({
        userid: ['', Validators.required],
        password: ['', Validators.required]
    });
    }

    ngOnInit() {
      localStorage.removeItem('candidateId');
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        const user = new User(0,this.f.userid.value,'', this.f.password.value);
        this.userService.login(user)
            .subscribe((data:any) => {
              console.log(data)
              localStorage.setItem("candidateId", data)
              this.router.navigate(['/dashboard']);
                })
    }
}
