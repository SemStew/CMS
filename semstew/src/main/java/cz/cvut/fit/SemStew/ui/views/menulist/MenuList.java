package cz.cvut.fit.SemStew.ui.views.menulist;

import JOOQ.tables.records.LanguagesRecord;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.VaadinService;
import cz.cvut.fit.SemStew.backend.Controllers.MenuController;
import cz.cvut.fit.SemStew.backend.Controllers.MenuRepresentation;
import cz.cvut.fit.SemStew.backend.Services.GeneralPageConfig.BranchService;
import cz.cvut.fit.SemStew.backend.Services.GeneralPageConfig.LanguagesService;
import cz.cvut.fit.SemStew.ui.MainLayout;
import cz.cvut.fit.SemStew.ui.views.GeneralAdminList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Route(value = "admin/dishes", layout = MainLayout.class)
@PageTitle("Dishes List | Admin")
public class MenuList extends GeneralAdminList {
    private final H2 header = new H2();
    private final Grid<MenuRepresentation> menuGrid = new Grid<>();
    private final LanguagesService languagesService = new LanguagesService();
    private final MenuController menuController = new MenuController();
    private final BranchService branchService = new BranchService();
    private List<MenuRepresentation> menuRecords;
    private final Button addButton = new Button();
    private final Dialog editDialog = new Dialog();

    public MenuList() {
        init();
        addContent();
    }

    private void init() {
        addClassName("dishes-list");
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

    private void addContent() {
        VerticalLayout content = new VerticalLayout();
        content.setClassName("content");
        content.setAlignItems(Alignment.STRETCH);

        header.setText("Dishes & Beverages");

        menuRecords = menuController.getItems();

        menuGrid.setItems(menuRecords);
        menuGrid.addColumn(new ComponentRenderer<>(menuRepresentation -> {
            Image tmp = new Image();
            tmp.setClassName("picture_grid");
            tmp.setSrc(menuRepresentation.getImageAddress());
            return tmp;
        }));
        menuGrid.addColumn(MenuRepresentation::getDescription).setComparator(Comparator.comparing(MenuRepresentation::getDescription)).setHeader("Menu name").setSortable(true);
        menuGrid.addColumn(new ComponentRenderer<>(clickedItem ->{
            Button tmp = new Button(new Icon(VaadinIcons.AREA_SELECT));
            tmp.addClickListener(buttonClickEvent -> {
                VaadinService.getCurrentRequest().getWrappedSession().setAttribute("menu_id",clickedItem.getIdMenu().toString());
                this.getUI().ifPresent(ui -> ui.navigate("admin/dishes/selected"));
            });
            return tmp;
        }));
        menuGrid.addColumn(new ComponentRenderer<>(clickedItem ->{
            Button tmp = new Button(new Icon(VaadinIcons.EDIT));
            tmp.addClickListener(buttonClickEvent -> {
                setUpEditDialog(clickedItem);
                editDialog.open();
            });
            return tmp;
        }));
        menuGrid.addColumn(new ComponentRenderer<>(clickedItem ->{
           Button tmp = new Button(new Icon(VaadinIcons.CLOSE));
           tmp.addClickListener(buttonClickEvent -> {
               menuController.Delete(clickedItem);
               RefreshValues();
           });
           return tmp;
        }));


        addButton.setText("Add");

        editDialog.setCloseOnEsc(true);
        editDialog.setCloseOnOutsideClick(false);

        addButton.addClickListener(buttonClickEvent -> {
            setUpAddDialog();
            editDialog.open();
        });

        content.add(header, menuGrid, addButton);

        add(content);
    }

    private void RefreshValues()
    {
        menuRecords = menuController.getItems();
        menuGrid.setItems(menuRecords);
    }

    private void setUpEditDialog(MenuRepresentation input)
    {
        editDialog.removeAll();
        VerticalLayout content = new VerticalLayout();
        HorizontalLayout buttons = new HorizontalLayout();

        List<String> branchAddresses = branchService.GetAllAdresses();

        ComboBox<String> branches = new ComboBox<>();
        branches.setItems(branchAddresses);
        branches.setValue(branchService.GetById(input.getIdBranch()).getAddress());
        branches.setLabel("Branch");

        Label headLabel = new Label("Update");
        TextField pictureUrl = new TextField("Picture url:");
        pictureUrl.setValue(input.getImageAddress());
        TextField name = new TextField("Menu name");
        name.setValue(input.getDescription());
        Label infoLabel = new Label();

        Button insert = new Button("Add");
        Button close = new Button("Close");

        branches.addValueChangeListener(valueChangeEvent -> {
            if(branchAddresses.stream().filter(branchAddress -> branchAddress.equals(branches.getValue())).count() == 0){
                branches.setErrorMessage("Select existing branch");
                branches.setInvalid(true);
            }
        });

        insert.addClickListener(buttonClickEvent -> {
            if(name.isEmpty() || pictureUrl.isEmpty()){
                infoLabel.setText("Fill all fields");
                return;
            }
            input.setImageAddress(pictureUrl.getValue());
            input.setDescription(name.getValue());
            input.setIdBranch(branchService.GetByAddress(branches.getValue()).getIdBranch());
            menuController.Update(input);
            RefreshValues();
            infoLabel.setText("Updated");
        });

        close.addClickListener(buttonClickEvent -> {
            editDialog.close();
        });

        buttons.add(insert, close);

        content.add(headLabel, branches, pictureUrl, name,buttons,infoLabel);

        editDialog.add(content);
    }

    private void setUpAddDialog()
    {
        editDialog.removeAll();
        VerticalLayout content = new VerticalLayout();
        HorizontalLayout buttons = new HorizontalLayout();

        List<MenuRepresentation> menuRepresentations = new ArrayList<>();

        List<LanguagesRecord> languagesRecords = languagesService.getConfigs();

        List<String> branchAddresses = branchService.GetAllAdresses();

        List<String> languageNames = new ArrayList<>();
        for(LanguagesRecord rec : languagesRecords){
            languageNames.add(rec.getName());
        }

        ComboBox<String> language = new ComboBox<>();
        language.setItems(languageNames);
        language.setValue(languageNames.get(0));

        ComboBox<String> branches = new ComboBox<>();
        branches.setItems(branchAddresses);
        branches.setValue(branchAddresses.get(0));
        branches.setLabel("Branch");

        Label headLabel = new Label("Add");
        TextField pictureUrl = new TextField("Picture url:");
        TextField name = new TextField("Menu name");
        Label infoLabel = new Label();

        Button insert = new Button("Add");
        Button close = new Button("Close");

        language.addValueChangeListener(valueChangeEvent -> {
            if(languageNames.stream().filter(nameLang -> nameLang.equals(language.getValue())).count() == 0){
                language.setErrorMessage("Select existing language");
                language.setInvalid(true);
                return;
            }
            if(pictureUrl.isEmpty() || name.isEmpty() ){
                infoLabel.setText("Fill all fields");
                return;
            }
            int languageId = languagesService.GetIdByName(valueChangeEvent.getOldValue());
            if(menuRepresentations.stream().filter(menu -> menu.getIdLanguage().equals(languageId)).count() == 0){
                MenuRepresentation tmp = new MenuRepresentation();
                tmp.setIdBranch(branchService.GetByAddress(branches.getValue()).getIdBranch());
                tmp.setIdLanguage(languageId);
                tmp.setDescription(name.getValue());
                tmp.setImageAddress(pictureUrl.getValue());
                menuRepresentations.add(tmp);
            }
        });

        branches.addValueChangeListener(valueChangeEvent -> {
            if(branchAddresses.stream().filter(branchAddress -> branchAddress.equals(branches.getValue())).count() == 0){
                branches.setErrorMessage("Select existing branch");
                branches.setInvalid(true);
            }
        });

        insert.addClickListener(buttonClickEvent -> {
           if(name.isEmpty() || pictureUrl.isEmpty()){
               infoLabel.setText("Fill all fields");
               return;
           }
           if(menuRepresentations.size() < languageNames.size() - 1){
               infoLabel.setText("Fill all languages");
               return;
           }
           int languageId = languagesService.GetIdByName(language.getValue());
           MenuRepresentation tmp = new MenuRepresentation();
           tmp.setIdBranch(branchService.GetByAddress(branches.getValue()).getIdBranch());
            tmp.setIdLanguage(languageId);
            tmp.setDescription(name.getValue());
            tmp.setImageAddress(pictureUrl.getValue());
            if(menuRepresentations.stream().filter(menu -> menu.getIdLanguage().equals(languageId)).count() != 0){
                if(menuRepresentations.size() == languageNames.size()){
                    menuController.InsertMultiLingual(menuRepresentations);
                    infoLabel.setText("Added");
                    RefreshValues();
                    return;
                }
            } else {
                if(menuRepresentations.size() + 1 == languageNames.size()){
                    menuRepresentations.add(tmp);
                    menuController.InsertMultiLingual(menuRepresentations);
                    infoLabel.setText("Added");
                    RefreshValues();
                    return;
                }
            }
            infoLabel.setText("Fill all languages");
        });

        close.addClickListener(buttonClickEvent -> {
            editDialog.close();
        });

        buttons.add(insert, close);

        content.add(headLabel, language, branches, pictureUrl, name,buttons,infoLabel);

        editDialog.add(content);
    }
}