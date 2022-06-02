export default class HttpService {
    constructor(headers = null) {
        const header = new Headers();
        const auth = localStorage.getItem('token')
        header.append("Authorisation", auth);
        header.append("X-Auth-Id", auth);
        header.append("cors", "no-cors");
        header.append("Content-Type", "application/json");
        this.headers = {
            headers: header,
            redirect: 'follow',
            cors : "no-cors"
        };
        if (headers) {
            this.headers = header
        }
    }


    get(url, options = null) {
        return fetch(url, options ? options : this.headers).then(res => res.json());
    }

    post(url, body, options = null) {
        this.headers.method = "POST";
        this.headers.body = JSON.stringify(body);
        this.headers.options = options;
        return fetch(url, options ? options : this.headers).then(res => res.json());
    }
}