var exec = require('cordova/exec');

module.exports = {
    get: function(success, error, options) {
        exec(success, error, "IMSI", "get", [options]);
    }
};