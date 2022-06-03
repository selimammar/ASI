
export default class AbstractCardListComponent {
    cards;
    constructor(cardService, transactionService) {
        this.cardService = cardService;
        this.transactionService = transactionService;
        this.currentCardId = null;
    }

    async onInit() {
        this.cards = await this.getCards();
        let template = document.querySelector("#row");

        for (const card of this.cards) {
            let clone = document.importNode(template.content, true);
            let newContent = clone.firstElementChild.innerHTML
                .replace(/{{id}}/g, card.id)
                .replace(/{{family_src}}/g, card.imgUrl)
                .replace(/{{family_name}}/g, card.family)
                .replace(/{{img_src}}/g, card.imgUrl)
                .replace(/{{name}}/g, card.name)
                .replace(/{{description}}/g, card.description)
                .replace(/{{hp}}/g, card.hp)
                .replace(/{{energy}}/g, card.energy)
                .replace(/{{attack}}/g, card.attack)
                .replace(/{{defense}}/g, card.defense)
                .replace(/{{price}}/g, card.price);
            
            clone.firstElementChild.innerHTML = newContent;
            clone.firstElementChild.setAttribute("onClick", `cardList.displayCardData(${card.id})`)
            if(card.isToSell)
                clone.firstElementChild.classList.add('negative')
                // clone.firstElementChild.style.backgroundColor = '#eb8686';
            
            let cardContainer = document.querySelector("#tableContent");
            cardContainer.appendChild(clone);
        }
        if (this.cards.length){
            this.currentCardId = this.cards[0].id
            this.displayCardData(this.currentCardId);
        }
    }

    async displayCardData(id) {
        let card = this.cards.find(el => el.id == id);
        if (!this.template)
            this.template = document.querySelector("#card-selected");

        let clone = document.importNode(this.template.content, true);
        let newContent = clone.firstElementChild.innerHTML
            .replace(/{{id}}/g, card.id)
            .replace(/{{family_src}}/g, card.imgUrl)
            .replace(/{{family_name}}/g, card.family)
            .replace(/{{img_src}}/g, card.imgUrl)
            .replace(/{{name}}/g, card.name)
            .replace(/{{description}}/g, card.description)
            .replace(/{{hp}}/g, card.hp)
            .replace(/{{energy}}/g, card.energy)
            .replace(/{{attack}}/g, card.attack)
            .replace(/{{defense}}/g, card.defense)
            .replace(/{{price}}/g, card.price);
        clone.firstElementChild.innerHTML = newContent;
        
        this.currentCardId = id;
        let cardContainer = document.querySelector("#content");
        while (cardContainer.firstChild) {
            cardContainer.removeChild(cardContainer.lastChild);
        }
        cardContainer.appendChild(clone);
    }

}