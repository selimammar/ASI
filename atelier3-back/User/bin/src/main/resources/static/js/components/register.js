import { environment } from "../environment/environment.js";
import AuthService from "../services/auth.service.js";
class RegisterComponent {
    constructor(form, authService){
        this.form = form; 
        this.form.onsubmit = this.onFormSubmit.bind(this);
        this.authService = authService;
    }


    async onFormSubmit(e){
        e.preventDefault();
        const formData = new FormData(this.form);
        var object = {};
        formData.forEach((value, key) => object[key] = value);
        try{
            const user = await this.authService.register(object);
            localStorage.setItem('token', user.id);
            window.location.replace("./cardList.html");
        }catch(e){
            alert("Une erreur est survenue");
        }
    }
}
new RegisterComponent(document.getElementById('form'), new AuthService());






