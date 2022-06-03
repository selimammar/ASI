import { environment } from "../environment/environment.js";
import HttpService from "./http.service.js"

export default class TransactionService {
    constructor(){
        this.http = new HttpService;
    }

    sell(card_id, obj) {
        return this.http.post(`${environment.apiUrl}/transaction/sell/${card_id}`, obj)
    }

    cancelSell(id) {
        return this.http.put(`${environment.apiUrl}/transaction/sell/${id}`);
    }

    buy(id){
        return this.http.post(`${environment.apiUrl}/transaction/buy/${id}`);
    }

}