import service from "@/utils/request";

const baseUrl = 'http://101.34.210.253:8081/'


export function GetTaskById(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'task/getTaskById',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}




export function GetDatasetByTask(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'task/getDatasetByTask',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}


export function GetSubmissionByDataset(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'data/getSubmissionByDataset',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}



export function GetPaperByDataset(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'data/getPaperByDataset',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}

export function GetModelByPaperList(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'data/getModelByPaperList',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}




export function GetSubmitBySubmissionList(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'data/getSubmitBySubmissionList',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}


export function SubmitPaper(data) {
    return service.request({
        method: 'post',
        url: baseUrl + 'submit/submitPaper',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}




export function SubmitSubmission(data) {
    return service.request({
        headers: {
            'content-type': 'application/form-data'
        },
        method: 'post',
        url: baseUrl + 'submit/submitSubmission',
        params: data //左边的data是变量名(key)后台接受，右边的data是参数,如果两者名字相同可以只写一个
    })
}