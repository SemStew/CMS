package cz.cvut.fit.SemStew.backend.Services.MenuServices;

import JOOQ.tables.MenuItemName;
import JOOQ.tables.records.MenuItemNameRecord;
import cz.cvut.fit.SemStew.backend.PostgreSQLConnection;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

public class MenuItemNameService {
    private DSLContext ctx;

    public MenuItemNameService() {}

    //select
    public List<MenuItemNameRecord> SelectMenuItemNameService(){
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        List<MenuItemNameRecord> configs = new ArrayList<MenuItemNameRecord>();
        MenuItemName a = new MenuItemName();
        for (MenuItemNameRecord rec : ctx.selectFrom(a)) {
            configs.add(rec);
        }

        return configs;
    }

    //update
    public void UpdateMenuItemNameService(MenuItemNameRecord a){
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        MenuItemName tmp = new MenuItemName();
        ctx.update(tmp).set(tmp.DESCRIPTION, a.getDescription()).set(tmp.NAME, a.getName()).
                where(tmp.ID_LANGUAGE.eq(a.getIdLanguage())).and(tmp.ID_MENU_ITEM.eq(a.getIdMenuItem())).execute();
    }

    //insert
    public void InsertMenuItemNameService(MenuItemNameRecord a){
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        MenuItemName tmp = new MenuItemName();
        ctx.insertInto(tmp).columns(tmp.ID_MENU_ITEM, tmp.ID_LANGUAGE, tmp.NAME, tmp.DESCRIPTION).
                            values(a.getIdMenuItem(), a.getIdLanguage(), a.getName(), a.getDescription()).execute();
    }

    //delete
    public void DeleteMenuItemNameService(MenuItemNameRecord a){
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        MenuItemName tmp = new MenuItemName();
        ctx.delete(tmp).where(tmp.ID_LANGUAGE.eq(a.getIdLanguage())).and(tmp.ID_MENU_ITEM.eq(a.getIdMenuItem())).execute();
    }

    // Item by id and Language
    public MenuItemNameRecord ItemNameById(Integer id, int language)
    {
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        MenuItemName tmp = new MenuItemName();
        for(MenuItemNameRecord res : ctx.selectFrom(tmp).where(tmp.ID_MENU_ITEM.eq(id)).and(tmp.ID_LANGUAGE.eq(language)))
            return res;
        return null;
    }

    // delete by menu item id
    public void DeleteByMenuItemId(int menuItemId){
        ctx = DSL.using(PostgreSQLConnection.getConnection(), SQLDialect.POSTGRES);
        MenuItemName tmp = new MenuItemName();
        ctx.delete(tmp).where(tmp.ID_MENU_ITEM.eq(menuItemId)).execute();
    }

    public List<MenuItemNameRecord> getConfigs() {
        return SelectMenuItemNameService();
    }
}
