package cz.cvut.fit.SemStew.ui.customerviews.reservationlist;

import JOOQ.tables.records.ReservationConfigRecord;
import JOOQ.tables.records.ReservationRecord;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import cz.cvut.fit.SemStew.backend.CorrectnessController;
import cz.cvut.fit.SemStew.backend.Services.GeneralPageConfig.BranchService;
import cz.cvut.fit.SemStew.backend.Services.GeneralPageConfig.LanguagesService;
import cz.cvut.fit.SemStew.backend.Services.GeneralPageConfig.ReservationConfigService;
import cz.cvut.fit.SemStew.backend.Services.GeneralPageConfig.ReservationService;
import cz.cvut.fit.SemStew.ui.CustomerLayout;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Route(value = "reservations", layout = CustomerLayout.class)
@PageTitle("Reservations | Home")
public class ReservationList extends VerticalLayout {
    private final H2 header = new H2();
    private final DatePicker date = new DatePicker();
    private final TextField time = new TextField();
    private final TextField person = new TextField();
    private final TextField table = new TextField();
    private final TextField email = new TextField();
    private final ComboBox<String> branches = new ComboBox<>();
    private final Button confirm = new Button();
    private final Label infoLabel = new Label();
    private final ReservationConfigService reservationConfigService = new ReservationConfigService();
    private final LanguagesService languagesService = new LanguagesService();
    private final ReservationService reservationService = new ReservationService();
    private final BranchService branchService = new BranchService();

    public ReservationList()
    {
        init();
        addContent();

    }

    private void init()
    {
        setClassName("reservations");
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    }

    private void addContent()
    {
        VerticalLayout content = new VerticalLayout();
        content.addClassName("form");
        content.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

        String name = "English";

        if(VaadinService.getCurrentRequest().getWrappedSession().getAttribute("language") != null) {
            name = VaadinService.getCurrentRequest().getWrappedSession().getAttribute("language").toString();
        }

        int id = languagesService.GetIdByName(name);

        ReservationConfigRecord reservationConfigRecord = reservationConfigService.GetByLanguageId(id);

        List<String> branchAddresses = branchService.GetAllAdresses();

        header.setText(reservationConfigRecord.getHeader());

        date.setLabel("Date:");
        time.setLabel(reservationConfigRecord.getTimeFromDesc());
        person.setLabel("Name and Surname:");
        table.setLabel(reservationConfigRecord.getTableNumber());
        email.setLabel("Email");

        branches.setItems(branchAddresses);
        branches.setValue(branchAddresses.get(0));
        branches.setLabel("Branch");

        confirm.setText("Confirm");
        confirm.addClassName("btn_style");

        branches.addValueChangeListener(valueChangeEvent -> {
            if(branchAddresses.stream().filter(branchAddress -> branchAddress.equals(branches.getValue())).count() == 0){
                branches.setErrorMessage("Select existing branch");
                branches.setInvalid(true);
            }
        });

        confirm.addClickListener(buttonClickEvent -> {
            if(date.isEmpty() || time.isEmpty() || person.isEmpty() || table.isEmpty() || email.isEmpty()){
                infoLabel.setText("Fill all fields");
                return;
            }
            if(!CorrectnessController.ValidEmail(email.getValue())){
                infoLabel.setText("Enter valid email address");
                return;
            }
            if(!CorrectnessController.ValidTime(time.getValue())){
                infoLabel.setText("Enter valid time. Format HH:MM");
                return;
            }
            if(!CorrectnessController.OnlyNumbers(table.getValue())){
                infoLabel.setText("Table must be numbers only");
                return;
            }
            ReservationRecord tmp = new ReservationRecord();
            tmp.setIdBranch(branchService.GetByAddress(branches.getValue()).getIdBranch());
            tmp.setEmail(email.getValue());
            tmp.setNTable(Integer.parseInt(table.getValue()));
            tmp.setStatus("Open");
            tmp.setPerson(person.getValue());
            tmp.setRDate(Date.valueOf(date.getValue()));
            String[] parts = time.getValue().split(":");
            Time fromTime = new Time(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]), 0);
            tmp.setTimeFrom(fromTime);
            reservationService.InsertReservationService(tmp);
            infoLabel.setText("Added");
        });


        content.add(header, date, time, person, table, email, branches, confirm, infoLabel);

        add(content);
    }
}
