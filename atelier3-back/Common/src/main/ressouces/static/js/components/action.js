import { environment } from "../environment/environment.js";

let icon = document.getElementById("icon-profil");
let shop = document.getElementById("icon-shop");
let sell = document.getElementById("icon-sell");

let urls = {
    cardlist : 'cardList.html',
    shop: 'shop.html'
}

function redirect(url) {
    window.location = `${environment.url}/atelierII/` + url
}

icon.addEventListener('click', function(e) {    
    redirect(urls.cardlist)
}) 
shop.addEventListener('click', function(e) {    
    redirect(urls.shop)
}) 
sell.addEventListener('click', function(e) {    
    redirect(urls.cardlist)
}) 