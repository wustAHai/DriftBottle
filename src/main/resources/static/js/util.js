function checkForm(...args) {
    for (let i = 0; i < args.length; i++) {
        if (args[i]==undefined||args[i].length == 0 || args[i].trim() == '') {
            return false;
        }
    }
    return true;
}