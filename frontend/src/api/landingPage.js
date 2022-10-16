import service from "@/utils/request";

const baseUrl = 'http://101.34.210.253:8081/'


export function Login(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'login/login',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function Signup(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'login/signup',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function GetTokenTask(data) {
    return service.request({
        method: 'get',
        url: baseUrl + 'task/tokenAll',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function GetSentenceTask(data) {
    return service.request({
        method: 'get',
        url: baseUrl + 'task/sentenceAll',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}