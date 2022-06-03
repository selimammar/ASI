import HttpService from "./http.service.js"

export default class UserService {
    constructor(){
        this.http = new HttpService;
    }
    login(credentials) {
        return this.http.post(`http://localhost:8082/auth/login`, credentials);
    }

    register(form) {
        return this.http.post(`http://localhost:8082/auth/register`, form)
    }

    getAuthenticatedUser(){
        return this.http.get(`http://localhost:8082/auth/current`);
    }
}