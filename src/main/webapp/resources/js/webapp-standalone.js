/**
 * Link conversion exclusive for mobile browser when executing the web app as a standalone. 
 * Converts all links to javascript instead of the direct browser call, so the standalone web app 
 * won't open the default browser as it navigates on the internal pages of the app.
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
