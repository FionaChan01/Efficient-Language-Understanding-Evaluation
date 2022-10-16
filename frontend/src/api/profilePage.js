import service from "@/utils/request";

const baseUrl = 'http://101.34.210.253:8081/'


export function GetModelByToken(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'data/getModelByToken',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function DeleteModelById(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'data/deleteModelById',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function DeleteModelsByIdList(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'data/deleteModelsByIdList',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}