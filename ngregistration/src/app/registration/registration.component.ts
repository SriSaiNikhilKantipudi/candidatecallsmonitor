import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegistrationService } from '../registration.service';

@Component({templateUrl: 'registration.component.html'})
export class RegisterComponent implements OnInit {
    registerForm: FormGroup;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        // private authenticationService: AuthenticationService,
        private userService: RegistrationService,
        // private alertService: AlertService
    ) { 
        // redirect to home if already logged in
        // if (this.authenticationService.currentUserValue) { 
        //     this.router.navigate(['/']);
        // }
        this.registerForm = this.formBuilder.group({
          name: ['', Validators.required],
          userid: ['', Validators.required],
          password: ['', [Validators.required, Validators.minLength(6)]]
      });
    }

    ngOnInit() {

    }

    // convenience getter for easy access to form fields
    get f() { return this.registerForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.registerForm.invalid) {
            return;
        }

        this.loading = true;
        this.userService.register(this.registerForm.value)
            .subscribe((data : any) => {
              console.log(data);
                    this.router.navigate(['/login']);
            })
    }
}
