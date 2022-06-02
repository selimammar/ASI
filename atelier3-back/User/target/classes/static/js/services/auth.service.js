import { environment } from "../environment/environment.js";
import HttpService from "./http.service.js"

export default class AuthService {
    constructor(){
        this.http = new HttpService;
    }
    login(credentials) {
        return this.http.post(`${environment.apiUrl}/auth/login`, credentials);
    }

    register(form) {
        return this.http.post(`${environment.apiUrl}/auth/register`, form)
    }

    getAuthenticatedUser(){
        return this.http.get(`${environment.apiUrl}/auth/current`);
    }
}