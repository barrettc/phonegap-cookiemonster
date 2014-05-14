var responseHeader = {
  getCookieValue: function(url, cookieName, successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, 'CookieMonster', 'getCookieValue', [url, cookieName]);
  }  
};
module.exports = responseHeader;
