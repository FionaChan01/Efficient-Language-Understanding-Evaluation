import service from "@/utils/request";

const baseUrl = 'http://101.34.210.253:8081/'



export function GetDatasetByTaskList(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'task/getDatasetByTaskList',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function GetModelPerformance(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'data/getModelPerformance',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function GetSubmitPerformance(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'data/getSubmitPerformance',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}