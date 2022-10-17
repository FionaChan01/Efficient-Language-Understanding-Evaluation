import cookie from "js-cookie"

export function getToken() {
    return cookie.get("admin");
}