(function (document, $) {
    "use strict";

    var FOUNDATION_LAYOUT_LIST = ".foundation-layout-list";
    var SITE_ADMIN_CHILD_PAGES = "cq-siteadmin-admin-childpages";
    var TITLE_SELECTOR = "[data-title='Title']";
    var ARTICLE_TITLE_SELECTOR = ".label .main";

    $(document).on("foundation-mode-change", function(e, mode, group){
        //not on sites list, may be assets, return
        if((group != SITE_ADMIN_CHILD_PAGES) || (mode == "selection") ){
            return;
        }

        //group is cq-siteadmin-admin-childpages for sites
        var $collection = $(".foundation-collection[data-foundation-mode-group=" + group + "]");

        if (!$collection.is(FOUNDATION_LAYOUT_LIST)) {
            return;
        }

        //adjust the width of title column to accommodate Path column
        $(".list .card-page .main").css("width", "33%");

        //get the title element in header.
        var $hTitle = $("." + SITE_ADMIN_CHILD_PAGES).find("header").find(TITLE_SELECTOR);

        //add template column to header after title
        $hTitle.after( $("<div/>").attr('class', 'eaem-path-column')
                    .attr('data-sort-selector', ".label .eaem-path-column h4")
                    .attr('data-title', "Path").html("Template"));

        var $pathElement;

        //iterate on each article or row.
        $("article").each(function(index, article){
            var $article = $(article);

            //get data-template attribute from article element and put in pathelement.
            $pathElement = $("<div/>").attr('class', 'eaem-path-column')
                                .append($("<h4/>").attr("class", "foundation-collection-item-title")
                                            .html($article.data("template")));

            //insert path data after title
            $article.find(ARTICLE_TITLE_SELECTOR).after($pathElement);
        })
    });
})(document, jQuery);