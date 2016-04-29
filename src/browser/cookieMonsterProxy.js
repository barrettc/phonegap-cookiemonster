var browser = require('cordova/platform');
var cordova = require('cordova');
module.exports = {
  getCookieValue : function (success, error, opts) {
    var url = opts[0];
    var cookieName = opts[0];
    success("",null);
  },

};

require("cordova/exec/proxy").add("CookieMonster", module.exports);