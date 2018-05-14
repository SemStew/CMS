package cz.cvut.fit.SemStew.backend.Services.GeneralPageConfig;

import JOOQ.tables.Reservation;
import JOOQ.tables.records.ReservationRecord;
import cz.cvut.fit.SemStew.backend.PostgreSQLConnection;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private DSLContext ctx;

    public ReservationService() {}

    //select
    public List<ReservationRecord> SelectReservationService(){
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        List<ReservationRecord> configs = new ArrayList<ReservationRecord>();
        Reservation a = new Reservation();
        for (ReservationRecord rec : ctx.selectFrom(a)) {
            configs.add(rec);
        }

        return configs;
    }

    //update
    public void UpdateReservationService(ReservationRecord a){
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        Reservation tmp = new Reservation();
        ctx.update(tmp).set(tmp.STATUS, a.getStatus()).set(tmp.PERSON, a.getPerson()).set(tmp.EMAIL, a.getEmail()).
                where(tmp.ID_RESERVATION.eq(a.getIdReservation())).execute();
    }

    //insert
    public void InsertReservationService(ReservationRecord a){
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        Reservation tmp = new Reservation();
        ctx.insertInto(tmp).columns(tmp.ID_BRANCH, tmp.N_TABLE, tmp.PERSON, tmp.R_DATE, tmp.TIME_FROM, tmp.EMAIL, tmp.STATUS).
                values(a.getIdBranch(), a.getNTable(), a.getPerson(), a.getRDate(), a.getTimeFrom(), a.getEmail(), a.getStatus()).execute();
    }

    // delete
    public void DeleteReservationService(ReservationRecord a){
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        Reservation tmp = new Reservation();
        ctx.delete(tmp).where(tmp.ID_RESERVATION.eq(a.getIdReservation())).execute();
    }

    // get by id
    public ReservationRecord GetById(int id){
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        Reservation tmp = new Reservation();
        return ctx.fetchOne(tmp, tmp.ID_RESERVATION.eq(id));
    }

    public List<ReservationRecord> getConfigs() {
        return SelectReservationService();
    }
}
