import CardService from "../services/card.service.js";
import TransactionService from "../services/transaction.service.js";
import AbstractCardListComponent from "./AbstractCardList.js";

class ShopComponent extends AbstractCardListComponent {

    constructor(cardService, transactionService) {
        super(cardService, transactionService);
    }

    getCards() {
        return this.cardService.getBuyableCards();
    }

    async buyCard(tpl) {
        const id = tpl.getAttribute("data-id");
        let card = this.cards.find(el => el.id == id);
        const confirm = window.confirm("Souhaitez vous vraiment acheter cette card ? ");
        if (confirm)
            await this.transactionService.buy(id)
                .then(res => {
                    window.location.replace("./cardList.html")
                })
                .catch(e => alert(e));
    }
}

export const cardList = new ShopComponent(new CardService, new TransactionService);
cardList.onInit();

window.cardList = cardList;


