Cookie Monster
==============

A Phonegap plugin to return a cookie value for a given URL and cookie name. This plugin was needed in a project to work around the fact that cookies are not returned for a cross domain XHR request.
 
## Supported Platforms
* Android
* iOS

## Installing
Install with Phonegap CLI
    $ phonegap local plugin add https://github.com/barrettc/phonegap-cookiemonster.git

## Usage
```javascript
cookieMonster.getCookieValue('http://<some host>:<some port>', '<cookie name>', function(data) {
  console.log(data.cookieValue);
}, function(error) {
  if (error) {
    console.log('error: ' + error);
  }
});
```

## Limitations
I have tested with iOS 7.1.1, Android 4.3, 4.4, and Phonegap 3.4. Your mileage may vary on other versions.


                .---. .---. 
               :     : o   :    me want cookie!
           _..-:   o :     :-.._    /
       .-''  '  `---' `---' "   ``-.    
     .'   "   '  "  .    "  . '  "  `.  
    :   '.---.,,.,...,.,.,.,..---.  ' ;
    `. " `.                     .' " .'
     `.  '`.                   .' ' .'
      `.    `-._           _.-' "  .'  .----.
        `. "    '"--...--"'  . ' .'  .'  o   `.
        .'`-._'    " .     " _.-'`. :       o  :
      .'      ```--.....--'''    ' `:_ o       :
    .'    "     '         "     "   ; `.;";";";'
   ;         '       "       '     . ; .' ; ; ;
  ;     '         '       '   "    .'      .-'
  '  "     "   '      "           "    _.-'
