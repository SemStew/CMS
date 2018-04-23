package com.vaadin.starter.SemStew.ui.views.articlelist;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.starter.SemStew.backend.IntroConfig;
import com.vaadin.starter.SemStew.ui.MainLayout;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;
import com.vaadin.starter.SemStew.ui.views.appearancelist.AppearanceList;
import com.vaadin.starter.SemStew.ui.views.articlelist.ArticleList;
import com.vaadin.starter.SemStew.ui.views.gallerylist.GalleryList;
import com.vaadin.starter.SemStew.ui.views.introlist.IntroList;
import com.vaadin.starter.SemStew.ui.views.menulist.MenuList;
import com.vaadin.starter.SemStew.ui.views.previewlist.PreviewList;
import com.vaadin.starter.SemStew.ui.views.reservationslist.ReservationsList;
import com.vaadin.starter.SemStew.ui.views.settingslist.SettingsList;
import com.vaadin.starter.SemStew.ui.views.statisticslist.StatisticsList;

import java.util.Collection;

@Route(value = "articles", layout = MainLayout.class)
@PageTitle("Article List")
public class ArticleList extends VerticalLayout
    implements AfterNavigationObserver {

    private static final String ACTIVE_ITEM_STYLE = "main-layout__nav-item--selected";
    private RouterLink home;
    private RouterLink preview;
    private RouterLink dishes;
    private RouterLink articles;
    private RouterLink gallery;
    private RouterLink reservations;
    private RouterLink statistics;
    private RouterLink appearance;
    private RouterLink settings;

    private final H2 header = new H2();
    private final Grid<IntroConfig> actualities = new Grid<>();

    public ArticleList() {
        init();
        addContent();
        addMenu();
        addFoot();
    }

    private void init() {
        addClassName("article-list");
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

    private void addContent() {
        VerticalLayout content = new VerticalLayout();
        content.setClassName("content");
        content.setAlignItems(Alignment.STRETCH);

        header.setText("Articles");

        actualities.setSelectionMode(Grid.SelectionMode.NONE);

        content.add(header);

        add(content);
    }

    private void addMenu() {
        H2 title = new H2("SemStew CMS");
        title.addClassName("title");

        Div navigation = new Div(title);
        navigation.addClassName("nav");

        home = new RouterLink(null,IntroList.class);
        home.add(new Icon(VaadinIcons.HOME), new Text("Home"));
        home.addClassName("nav-item");

        preview = new RouterLink(null, PreviewList.class);
        preview.add(new Icon(VaadinIcons.BROWSER), new Text("Preview"));
        preview.addClassName("nav-item");

        dishes = new RouterLink(null, MenuList.class);
        dishes.add(new Icon(VaadinIcons.CROSS_CUTLERY), new Text("Dishes"));
        dishes.addClassName("nav-item");

        articles = new RouterLink(null, ArticleList.class);
        articles.add(new Icon(VaadinIcons.PAPERCLIP), new Text("Articles"));
        articles.addClassName("nav-item");

        gallery = new RouterLink(null, GalleryList.class);
        gallery.add(new Icon(VaadinIcons.PICTURE), new Text("Gallery"));
        gallery.addClassName("nav-item");

        reservations = new RouterLink(null, ReservationsList.class);
        reservations.add(new Icon(VaadinIcons.NOTEBOOK), new Text("Reservations & Orders"));
        reservations.addClassName("nav-item");

        statistics = new RouterLink(null, StatisticsList.class);
        statistics.add(new Icon(VaadinIcons.SPLINE_AREA_CHART), new Text("Statistics"));
        statistics.addClassName("nav-item");

        appearance = new RouterLink(null, AppearanceList.class);
        appearance.add(new Icon(VaadinIcons.VIEWPORT), new Text("Appearance"));
        appearance.addClassName("nav-item");

        settings = new RouterLink(null, SettingsList.class);
        settings.add(new Icon(VaadinIcons.TOOLS), new Text("Settings"));
        settings.addClassName("nav-item");

        navigation.add(home, preview, dishes, articles, gallery, reservations, statistics, appearance, settings);

        add(navigation);
    }

    private void addFoot () {
        HorizontalLayout bottom = new HorizontalLayout();
        bottom.addClassName("main-layout__bottom");
        Div foot = new Div ();
        foot.addClassName("foot");

        Text foot__text = new Text("Design and developed by DreamTeam © SemStew CMS");
        foot.add(foot__text);
        bottom.add(foot);

        add(bottom);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        // updating the active menu item based on if either of views is active
        // (note that this is triggered even for the error view)

        String segment = event.getLocation().getFirstSegment();
        boolean homeActive = segment.equals(home.getHref());
        boolean previewActive = segment.equals(preview.getHref());
        boolean dishesActive = segment.equals(dishes.getHref());
        boolean articlesActive = segment.equals(articles.getHref());
        boolean galleryActive = segment.equals(gallery.getHref());
        boolean reservationsActive = segment.equals(reservations.getHref());
        boolean statisticsActive = segment.equals(statistics.getHref());
        boolean appearanceActive = segment.equals(appearance.getHref());
        boolean settingsActive = segment.equals(settings.getHref());

        home.setClassName(ACTIVE_ITEM_STYLE, homeActive);
        preview.setClassName(ACTIVE_ITEM_STYLE, previewActive);
        dishes.setClassName(ACTIVE_ITEM_STYLE, dishesActive);
        articles.setClassName(ACTIVE_ITEM_STYLE, articlesActive);
        gallery.setClassName(ACTIVE_ITEM_STYLE, galleryActive);
        reservations.setClassName(ACTIVE_ITEM_STYLE, reservationsActive);
        statistics.setClassName(ACTIVE_ITEM_STYLE, statisticsActive);
        appearance.setClassName(ACTIVE_ITEM_STYLE, appearanceActive);
        settings.setClassName(ACTIVE_ITEM_STYLE, settingsActive);
    }
}