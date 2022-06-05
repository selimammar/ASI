import AuthService from "../services/auth.service.js";

class HeaderComponent {

    constructor(authService) {
        this.authService = authService;
    }


    async onInit() {
        let user = await this.authService.getAuthenticatedUser();
        let template = document.querySelector("#template");

        let clone = document.importNode(template.content, true);
        let newContent = clone.firstElementChild.innerHTML
            .replace(/{{firstname}}/g, user.firstname)
            .replace(/{{lastname}}/g, user.lastname)
            .replace(/{{balance}}/g, user.sold)
        clone.firstElementChild.innerHTML = newContent;

        let cardContainer = document.querySelector("#user-info");
        cardContainer.appendChild(clone);
    }

    goShop() {
        window.location.replace("./shop.html");
    }
    goMyCard() {
        window.location.replace("./cardList.html");
    }
    disconnect() {
        localStorage.removeItem('token');
        window.location.replace("./login.html");
    }

}

export const header = new HeaderComponent(new AuthService());

header.onInit()

window.header = header;

