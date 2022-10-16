//过滤特殊字符
export function stripscript(str) {
    var pattern = new RegExp("[`~!#$^&*()=|{ }':;'\\[\\]<>/?~！#￥……&*（）&;—|{}【】‘；：”“'。，、？]")
    var rs = "";
    for (var i = 0; i < str.length; i++) {
        rs = rs + str.substr(i, 1).replace(pattern, '');
    }
    return rs;
}

//验证用户名是否符合规范
export function validateUsernameZhengZe(value) {
    let reg = /^[a-zA-Z0-9_@.]{2,30}$/;
    return reg.test(value) ? true : false;
}

//验证密码是否符合规范
export function validatePassPasswordZhengZe(value) {
    return true;
}

