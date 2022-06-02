import CardService from "../services/card.service.js";
import TransactionService from "../services/transaction.service.js";
import AbstractCardListComponent from "./AbstractCardList.js";
class CardListComponent extends AbstractCardListComponent{

    constructor(cardService, transactionService) {
        super(cardService, transactionService);
    }

    getCards(){
        console.log(this.transactionService);
        return this.cardService.getMyCards();
    }
    
    async sellCard(tpl) {
        const id = tpl.getAttribute("data-id");
        let card = this.cards.find(el => el.id == id);
        const price = window.prompt("Quel prix souhaitez vous obtenir pour cette carte ?", card.price);
        card = await this.transactionService.sell(this.currentCardId, {price : parseInt(price)});
        window.location.reload();
    }
}

export const cardList = new CardListComponent(new CardService, new TransactionService);
cardList.onInit();

window.cardList = cardList;


