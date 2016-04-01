(function ($, $document) {
    $document.on('cq-layer-activated', refreshPage);

    function refreshPage(ev){
        if ( (ev.prevLayer === "Preview") && (ev.layer === 'Edit') ) {
			window.location.reload();
        }
        if ( (ev.prevLayer === "Edit") && (ev.layer === 'Preview') ) {
			window.location.reload();
        }

    }
}(jQuery, jQuery(document)));