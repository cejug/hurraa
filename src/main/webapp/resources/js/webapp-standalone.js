/**
 * 
 */

function webAppStandalone_converter() {
    var standalone = 'standalone';
    if ((standalone in navigator) && navigator[standalone]) {
        var a=$("a");
        for(var i=0;i<a.length;i++) {
            if(!a[i].onclick && a[i].getAttribute("target") != "_blank") {
                a[i].onclick = function() {
                        window.location=this.getAttribute("href");
                        return false; 
                };
            }
        }
    }
}

$('body').load(webAppStandalone_converter());