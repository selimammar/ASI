import UserService from "../services/auth.service.js";

class RegisterComponent {
    constructor(form, userService){
        this.form = form; 
        this.form.onsubmit = this.onFormSubmit.bind(this);
        this.authService = userService;
    }

    async onFormSubmit(e){
        e.preventDefault();
        const formData = new FormData(this.form);
        var object = {};
        formData.forEach((value, key) => object[key] = value);
        try{
            const user = await this.userService.register(object);
            localStorage.setItem('token', user.id);
            console.log("OK")
            //window.location.replace("./cardList.html");
        }catch(e){
            alert("Une erreur est survenue");
        }
    }
}
new RegisterComponent(document.getElementById('form'), new UserService());







