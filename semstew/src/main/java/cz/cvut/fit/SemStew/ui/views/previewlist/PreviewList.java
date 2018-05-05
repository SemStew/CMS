package cz.cvut.fit.SemStew.ui.views.previewlist;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.H2;
import cz.cvut.fit.SemStew.ui.MainLayout;
import cz.cvut.fit.SemStew.ui.views.GeneralAdminList;

@Route(value = "admin/preview", layout = MainLayout.class)
@PageTitle("Preview List | Admin")
public class PreviewList extends GeneralAdminList {

    private final H2 header = new H2();

    public PreviewList() {
        init();
        addContent();
    }

    private void init() {
        super.addClassName("preview-list");
        super.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

    private void addContent() {
        VerticalLayout content = new VerticalLayout();
        content.setClassName("content");
        content.setAlignItems(Alignment.STRETCH);

        header.setText("Preview");

        content.add(header);

        add(content);
    }
}