import { environment } from "../environment/environment.js";
import AuthService from "../services/auth.service.js";
class LoginComponent {

    constructor(form, authService) {
        this.form = form;
        this.form.onsubmit = this.onFormSubmit.bind(this);
        this.authService = authService;
    }


    async onFormSubmit(e) {
        e.preventDefault();
        const formData = new FormData(this.form);
        var object = {};
        formData.forEach((value, key) => object[key] = value);
        try {
            const response = await this.authService.login(object);
            localStorage.setItem('token', response.id);
            window.location.replace("./cardList.html");
        } catch (e) {
            console.log(e)
            alert(e);
        }
    }
}

new LoginComponent(document.getElementById('form'), new AuthService());






