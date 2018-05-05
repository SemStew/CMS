package cz.cvut.fit.SemStew.ui.views.statisticslist;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.H2;
import cz.cvut.fit.SemStew.ui.MainLayout;
import cz.cvut.fit.SemStew.ui.views.GeneralAdminList;

@Route(value = "admin/statistics", layout = MainLayout.class)
@PageTitle("Statistics List | Admin")
public class StatisticsList extends GeneralAdminList {

    private final H2 header = new H2();

    public StatisticsList() {
        init();
        addContent();
    }

    private void init() {
        super.addClassName("statistics-list");
        super.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

    private void addContent() {
        VerticalLayout content = new VerticalLayout();
        content.setClassName("content");
        content.setAlignItems(Alignment.STRETCH);

        header.setText("Statistics");

        content.add(header);

        super.add(content);
    }
}