import { environment } from "../environment/environment.js";
import HttpService from "./http.service.js"

export default class CardService {
    constructor(){
        this.http = new HttpService;
    }
    getCards() {
        return this.http.get(`${environment.apiUrl}/cards`)
    }

    getCard(id) {
        return this.http.get(`${environment.apiUrl}/card/` + id)
    }

    getMyCards(){
        return this.http.get(`${environment.apiUrl}/cards/my`);
    }

    getBuyableCards(){
        return this.http.get(`${environment.apiUrl}/cards/buyable`);
    }


    
}