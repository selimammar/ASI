function includeHTML() {
    var z, i, elmnt, file, xhttp;
    z = document.getElementsByTagName("*");
    for (i = 0; i < z.length; i++) {
      elmnt = z[i];
      file = elmnt.getAttribute("include-html");
      if (file) {
        xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
          if (this.readyState == 4) {
            if (this.status == 200) {elmnt.innerHTML = this.responseText;}
            elmnt.removeAttribute("include-html");
            includeHTML();
            Array.from(elmnt.querySelectorAll("script")).forEach( oldScript => {
              const newScript = document.createElement("script");
              Array.from(oldScript.attributes)
                .forEach( attr => newScript.setAttribute(attr.name, attr.value) );
              newScript.appendChild(document.createTextNode(oldScript.innerHTML));
              oldScript.parentNode.replaceChild(newScript, oldScript);
            });
          }
        }
        xhttp.open("GET", file, true);
        xhttp.send();
        return;
      }
    }
  }
  
  includeHTML();
  
  