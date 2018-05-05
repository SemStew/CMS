package cz.cvut.fit.SemStew.ui;

import JOOQ.tables.records.AdminsRecord;
import JOOQ.tables.records.RestaurantRecord;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import cz.cvut.fit.SemStew.backend.Services.GeneralPageConfig.AdminsService;
import cz.cvut.fit.SemStew.backend.Services.GeneralPageConfig.RestaurantService;

import java.math.BigDecimal;
import java.util.List;


@Route(value = "registration", layout = MainLayout.class)
@PageTitle("Registration")
public class Registration extends VerticalLayout
    implements RouterLayout {
    private RouterLink login;

    private final H2 header = new H2();
    private final TextField userName = new TextField();
    private final PasswordField password = new PasswordField();
    private final PasswordField passwordRepeat = new PasswordField();
    private final TextField forname = new TextField();
    private final TextField surname = new TextField();
    private final TextField ico = new TextField();
    private final TextField email = new TextField();
    private final TextField restaurantName = new TextField();
    private final Button registrationButton = new Button();
    private final Label infoLabel = new Label();
    private AdminsService admin = new AdminsService();
    private RestaurantService rest = new RestaurantService();

    public Registration()
    {
        init();
        addContent();
        addFoot();
    }

    private void init()
    {
        addClassName("register");
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

    private void addContent()
    {
        VerticalLayout content = new VerticalLayout();
        content.setAlignItems(Alignment.STRETCH);
        content.addClassName("logreg_style");

        HorizontalLayout passwords = new HorizontalLayout();
        passwords.setAlignItems(Alignment.STRETCH);

        HorizontalLayout names = new HorizontalLayout();
        names.setAlignItems(Alignment.STRETCH);

        header.setText("Registration");
        userName.setLabel("Username:");
        password.setLabel("Password:");
        passwordRepeat.setLabel("Confirm password:");
        forname.setLabel("Forename:");
        surname.setLabel("Surname:");
        ico.setLabel("ICO:");
        email.setLabel("Email:");
        email.setPrefixComponent(new Icon(VaadinIcons.AT));
        restaurantName.setLabel("Restaurant name:");
        registrationButton.setText("Register");

        login = new RouterLink(null, Login.class);
        login.add(registrationButton);

        Div buttons = new Div ();
        buttons.addClassName("buttons");
        buttons.add(login);

        registrationButton.addClickListener(buttonClickEvent -> {
            if(!password.getValue().equals(passwordRepeat.getValue()))
            {
                infoLabel.setText("Passwords are different");
                return;
            }
            AdminsRecord tmp = new AdminsRecord();
            tmp.setName(userName.getValue());
            tmp.setPassword(password.getValue());
            tmp.setIdAdmin(2);
            admin.InsertAdminsService(tmp);
            RestaurantRecord tmp2 = new RestaurantRecord();
            tmp2.setIco(new BigDecimal(ico.getValue()));
            tmp2.setName(restaurantName.getValue());
            tmp2.setImage("none");
            tmp2.setIdRestaurant(2);
            List<AdminsRecord> admins = admin.getConfigs();
            for(AdminsRecord it : admins) {
                if (it.getName().equals(tmp.getName()) && it.getPassword().equals(tmp.getPassword())) {
                    tmp2.setIdAdmin(it.getIdAdmin());
                    break;
                }
            }
        });

        passwords.add(password, passwordRepeat);

        names.add(forname, surname);

        content.add(header, userName, passwords, names, ico, email, restaurantName, buttons,infoLabel);
        add(content);
    }

    private void addFoot () {
        HorizontalLayout bottom = new HorizontalLayout();
        bottom.addClassName("main-layout__bottom");
        Div foot = new Div();
        foot.addClassName("foot");

        Text foot__text = new Text("Design and developed by DreamTeam © SemStew CMS");
        foot.add(foot__text);
        bottom.add(foot);

        add(bottom);
    }
}
