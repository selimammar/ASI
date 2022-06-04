import UserService from "../services/auth.service.js";

class LoginComponent {

    constructor(form, userService) {
        this.form = form;
        this.form.onsubmit = this.onFormSubmit.bind(this);
        this.userService = userService;
    }


    async onFormSubmit(e) {
        e.preventDefault();
        const formData = new FormData(this.form);
        var object = {};
        formData.forEach((value, key) => object[key] = value);
        try {
            const response = await this.userService.login(object);
            localStorage.setItem('token', response.id);
            window.location.replace("./cardList.html");
        } catch (e) {
            console.log(e)
            alert(e);
        }
    }
}

new LoginComponent(document.getElementById('form'), new UserService());






