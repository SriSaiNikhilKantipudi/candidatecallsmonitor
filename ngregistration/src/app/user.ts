export class User {
     id?:number;
     userid: string;
     name:string;
     password:string;
     constructor(id:number,userid: string,name:string,password:string)
     {
        this.id=id;
        this.userid=userid;
        this.name=name;
        this.password=password;
     }
 }
