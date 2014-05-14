README
======

A Phonegap plugin to return a cookie value for a given URL and cookie name. This is essentially a workaround for cross domain request issues using XHR. Android only at the moment but iOS is coming.

```javascript
cookieMonster.getCookieValue('http://localhost:3000', 'connect.sid', function(data) {
  console.log(data.cookieValue);
}, function(error) {
  if (error) {
    console.log('err ' + error);
  }
});
```

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
