--languages
INSERT INTO LANGUAGES(name) VALUES ('English');
INSERT INTO LANGUAGES(name) VALUES ('Czech');

--admnis
INSERT INTO ADMINS(name, password) VALUES ('Dante', 'heslo123');

--restaurant
INSERT INTO RESTAURANT(id_admin, name, ico, image) VALUES (1, 'Dream Restaurant', 12345678, 'https://image.ibb.co/eu23fd/dream_Team_Logo.png');

--branches
INSERT INTO BRANCH(id_restaurant, address, phone, description, opening_hours) VALUES (1, 'Thákurova 1516', '465123945', 'Cool pobočka', 'Zavřeno nonstop');

--main categories
INSERT INTO MAIN_CATEGORIES DEFAULT VALUES;
INSERT INTO MAIN_CATEGORIES DEFAULT VALUES;

--main categories names
INSERT INTO MAIN_CATEGORIES_NAME(id_main_category, id_language, name) VALUES (1, 1, 'Food');
INSERT INTO MAIN_CATEGORIES_NAME(id_main_category, id_language, name) VALUES (2, 1, 'Beverages');
INSERT INTO MAIN_CATEGORIES_NAME(id_main_category, id_language, name) VALUES (1, 2, 'Jídlo');
INSERT INTO MAIN_CATEGORIES_NAME(id_main_category, id_language, name) VALUES (2, 2, 'Nápoje');

--categories
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (1);
INSERT INTO CATEGORIES(id_main_category) VALUES (2);
INSERT INTO CATEGORIES(id_main_category) VALUES (2);
INSERT INTO CATEGORIES(id_main_category) VALUES (2);
INSERT INTO CATEGORIES(id_main_category) VALUES (2);
INSERT INTO CATEGORIES(id_main_category) VALUES (2);
INSERT INTO CATEGORIES(id_main_category) VALUES (2);
INSERT INTO CATEGORIES(id_main_category) VALUES (2);

--categories in english
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (1, 1, 'Starters');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (2, 1, 'Soups');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (3, 1, 'Salads');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (4, 1, 'Traditional cousine');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (5, 1, 'Pasta');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (6, 1, 'Specialities');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (7, 1, 'Vegetarian');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (8, 1, 'For kids');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (9, 1, 'Desserts');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (10, 1, 'Side dishes');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (11, 1, 'Sauces');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (12, 1, 'Alcohol free');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (13, 1, 'Warm beverages');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (14, 1, 'Apperitives');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (15, 1, 'Wine');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (16, 1, 'Liquers');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (17, 1, 'Destialtes');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (18, 1, 'Drinks');

--categories in czech
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (1, 2, 'Předkrmy');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (2, 2, 'Polévky');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (3, 2, 'Saláty');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (4, 2, 'Tradiční kuchyně');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (5, 2, 'Těstoviny');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (6, 2, 'Speciality');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (7, 2, 'Bezmasá jídla');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (8, 2, 'Pro děti');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (9, 2, 'Dezerty');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (10, 2, 'Přílohy');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (11, 2, 'Omáčky');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (12, 2, 'Nealkoholické nápoje');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (13, 2, 'Teplé nápoje');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (14, 2, 'Aperitivy');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (15, 2, 'Víno');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (16, 2, 'Likéry');
INSERT INTO CATEGORIES_NAME(id_category, id_language, name) VALUES (17, 2, 'Destiláty');

--units
INSERT INTO UNITS(name) VALUES ('g');
INSERT INTO UNITS(name) VALUES ('pcs');
INSERT INTO UNITS(name) VALUES ('ks');
INSERT INTO UNITS(name) VALUES ('l');
INSERT INTO UNITS(name) VALUES ('cl');

--menus
INSERT INTO MENUS(id_branch, url_image) VALUES (1, 'https://weneedfun.com/wp-content/uploads/2015/10/Delicious-Food-Photos-28.jpg');
INSERT INTO MENUS(id_branch, url_image) VALUES (1, 'http://www.chezcora.com/public_upload/images/plat/Dejeuners/Brreuvages/thumbnails/Montage-smoothie_1000x1083-scale_max-600x400.png');

--MENU_ITEM

INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (60, 'http://pivarenbudik.sk/wp-content/uploads/2013/04/utopenec.jpg', 2, 2, 1, 1);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (75, 'https://www.receptyonline.cz/wp-content/uploads/2016/11/185503topinky-pikantni-kureci-smes-indruchova.jpg', 2, 2, 1, 1);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (25, 'http://cdn.milujivareni.cz/image/eyJ0eXBlIjoicmVjaXBlIiwiaW1hZ2VJZCI6IjEwNjciLCJ0aHVtYiI6MH0=/kureci-vyvar-s-masem-a-nudlemi-.jpg?ver=11', 0.25, 4, 2, 1);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (25, 'https://ichef.bbci.co.uk/MENU_ITEM/ic/MENU_ITEM_16x9_832/recipes/beef_goulash_soup_gulyas_16159_16x9.jpg', 0.25, 4, 2, 1);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (120, 'http://bitesofbri.com/wp-content/uploads/2014/04/Chicken-Bruschetta-Caesar-Salad-2-Bites-of-Bri.jpg', 125, 1, 3, 1);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (115, 'http://balkansut.com.tr/wp-content/uploads/2016/09/salata.jpg', 125, 1, 3, 1);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (130, 'https://thumbs.dreamstime.com/z/homemade-hot-czech-goulash-knodel-close-up-horizontal-top-plate-view-above-75573944.jpg', 200, 1, 4, 1);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (150, 'https://realMENU_ITEM.tesco.com/media/images/Sorted-roast-beef-LGH-6d1b1286-a7d3-4096-bff7-20d840716df3-0-1400x919.jpg', 200, 1, 4, 1);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (120, 'https://www.warrennash.co.uk/recipes/carbonara/spaghetticarbonara_xl.jpg', 200, 1, 5, 1);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (135, 'http://media.igurmet.cz/yummy/dc/e9/dce94f79b5912872d1f769debba02180.jpg', 250, 1, 5, 1);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (115, 'http://www.praguemorning.cz/img/2017/10/schermata-2017-10-20-alle-152713_960x540.jpg', 200, 1, 7, 2);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (100, 'https://fthmb.tqn.com/w5CXk2yMylJwBHxvrv13n1Y7Tqw=/960x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/scrambled-eggs-58a701ac5f9b58a3c91cbebd.jpg', 200, 1, 7, 2);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (90, 'https://assets.epicurious.com/photos/5761d0268accf290434553aa/6:4/w_620%2Ch_413/panna-cotta.jpg', 100, 1, 9, 2);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (110, 'http://www.rawforyou.cz/wp-content/uploads/2014/09/61a0305_upr_1.jpg', 100, 1, 9, 2);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (30, 'https://airfryer.cooking/wp-content/uploads/2017/12/Shoestring_fries_large.jpg', 50, 1, 10, 2);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (30, 'https://previews.123rf.com/images/weyo/weyo1611/weyo161100125/65592367-potato-roasted-potatoes-american-potatoes-with-salt-pepper-and-cumin-roasted-potato-wedges-delicious.jpg', 50, 1, 10, 2);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (45, 'http://www.howtomakeorangejuice.com/files/photos/Orange_Juice_Recipes_Copyright_2012.jpg', 0.33, 4, 12, 2);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (45, 'https://www.organicfacts.net/wp-content/uploads/applejuice.jpg', 0.33, 4, 12, 2);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (30, 'http://www.healthywomen.org/sites/default/files/green-tea.jpg', 0.5, 4, 13, 2);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (75, 'https://img.mediacentrum.sk/gallery/nwo/maxwidth/650/775529.jpg', 2, 5, 14, 2);
INSERT INTO MENU_ITEM(price, image_name, amount, id_unit, id_category, id_menu) VALUES (85, 'https://cdn.shopify.com/s/files/1/0343/7389/products/20170303_JBH_0033_2048x.jpg?v=1519243463', 2, 5, 14, 2);

--MENU_ITEM in english
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (1, 1, 'Pickled sausage', 'Sausage pickled in vinegar with pepper and chilli.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (2, 1, 'Spicy toast', 'Toast with spicy sauce and beef.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (3, 1, 'Chicken broth', 'Broth witch chicken meat and pasta.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (4, 1, 'Goulash soup', 'Goulash soup with beef and potatoes.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (5, 1, 'Caeser salad', 'Salad with letuce, chicken meat, cherry tomatoes and dressing.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (6, 1, 'Balkan salad', 'Salad with black olives, paprika, letuce, tomatoes and balkan cheese.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (7, 1, 'Beef goulash', 'Goulash with onion and dumplings.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (8, 1, 'Roast beef with american potatoes', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (9, 1, 'Spaghetti carbonara', 'Spaghetti witch cheese sauce and parmezan.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (10, 1, 'Lasagne', 'Italien MENU_ITEM with beef, tomatoes and mozzarella.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (11, 1, 'Fried cheese', 'Fried eidam with french fries.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (12, 1, 'Scrambled eggs with bread', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (13, 1, 'Panna cotta', 'Whippped cream with fruit.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (14, 1, 'Pancakes', 'Pancakes with fruit and vanilla ice cream.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (15, 1, 'French fries', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (16, 1, 'American potatoes', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (17, 1, 'Orange juice', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (18, 1, 'Apple juice', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (19, 1, 'Green tea', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (20, 1, 'Absinth', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (21, 1, 'Jameson whiskey', NULL);

--MENU_ITEM in czech
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (1, 2, 'Utopenec', 'Utopenec nakládaný v octu s paprikou, cibulí a pepřem.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (2, 2, 'Pikantní topinka', 'Topinka s hovězím a pikantní směsí.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (3, 2, 'Kuřecí vývar', 'Vývar s kuřecím mase, zeleninou a těstovinami.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (4, 2, 'Gulášová polévka', 'Gulášová polévka s hovězím a bramborami.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (5, 2, 'Caeser salát', 'Salát s cherry rajčaty, kuřecím, krutony a dresingem.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (6, 2, 'Balkán salát', 'Salát s černými olivami, paprikou, rajčaty a balkánským sýrem.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (7, 2, 'Hovězí guláš', 'Guláš s hovězím a knedlíky.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (8, 2, 'Roast beef s americkými bramborami', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (9, 2, 'Spaghetti carbonara', 'Spaghetti se sýrovou omáčkou a parmezánem.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (10, 2, 'Lasagne', 'Italský těstovinový pokrm z hovězího masa s rajčaty a mozzarellou.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (11, 2, 'Smažený sýr', 'Smažený eidam s hranolky.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (12, 2, 'Míchaná vajíčka s chlebem', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (13, 2, 'Panna cotta', 'Jemný krém s ovocem.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (14, 2, 'Palačinky', 'Palačinky s ovocem a vanilkovou zmrzlinou.');
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (15, 2, 'Hranolky', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (16, 2, 'Americký brambor', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (17, 2, 'Pomerančový džus', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (18, 2, 'Jablečný džus', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (19, 2, 'Zelený čaj', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (20, 2, 'Absinth', NULL);
INSERT INTO MENU_ITEM_NAME(id_menu_item, id_language, name, description) VALUES (21, 2, 'Jameson whiskey', NULL);

--allergens
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;
INSERT INTO ALLERGENS DEFAULT VALUES;

--allergens in english
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (1, 1, 'Celery');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (2, 1, 'Cereals containing gluten');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (3, 1, 'Crustaceans');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (4, 1, 'Eggs');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (5, 1, 'Fish');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (6, 1, 'Lupin');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (7, 1, 'Milk');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (8, 1, 'Molluscs');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (9, 1, 'Mustard');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (10, 1, 'Nuts');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (11, 1, 'Peanuts');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (12, 1, 'Sesame seeds');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (13, 1, 'Soya');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (14, 1, 'Sulphur dioxyde');

--allergens in czech
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (1, 2, 'Celer');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (2, 2, 'Obiloviny obsahující lepek');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (3, 2, 'Korýši');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (4, 2, 'Vejce');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (5, 2, 'Ryby');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (6, 2, 'Vlčí bob (lupina)');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (7, 2, 'Mléko');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (8, 2, 'Měkkýši');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (9, 2, 'Hořcice');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (10, 2, 'Ořechy');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (11, 2, 'Arašídy');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (12, 2, 'Sezamová semínka');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (13, 2, 'Sója');
INSERT INTO ALLERGENS_NAME(id_allergen, id_language, allergen) VALUES (14, 2, 'Oxid siřičitý');

--allergens in food
INSERT INTO MENU_ITEM_ALLERGEN(id_menu_item, id_allergen) VALUES (6, 7);
INSERT INTO MENU_ITEM_ALLERGEN(id_menu_item, id_allergen) VALUES (9, 7);
INSERT INTO MENU_ITEM_ALLERGEN(id_menu_item, id_allergen) VALUES (10, 7);
INSERT INTO MENU_ITEM_ALLERGEN(id_menu_item, id_allergen) VALUES (11, 7);
INSERT INTO MENU_ITEM_ALLERGEN(id_menu_item, id_allergen) VALUES (12, 4);
INSERT INTO MENU_ITEM_ALLERGEN(id_menu_item, id_allergen) VALUES (13, 7);
INSERT INTO MENU_ITEM_ALLERGEN(id_menu_item, id_allergen) VALUES (14, 7);

--RESERVATIONs
INSERT INTO RESERVATION(id_branch, r_date, time_from, person, n_table) VALUES (1, '2018-4-17', '16:00', 'Dante Frajer', 1);
INSERT INTO RESERVATION(id_branch, r_date, time_from, person, n_table) VALUES (1, '2018-4-19', '14:30', 'Dante Nefrajer', 3);

--RESERVATION site
INSERT INTO RESERVATION_CONFIG(id_language, header, table_number, time_from_desc) VALUES (1, 'RESERVATIONs', 'Table number', 'Time');
INSERT INTO RESERVATION_CONFIG(id_language, header, table_number, time_from_desc) VALUES (1, 'Rezervace', 'Číslo stolu', 'Čas rezervace');

--performace roles
INSERT INTO ROLE(name) VALUES('Majitel');
INSERT INTO ROLE(name) VALUES('Kuchař/ka');
INSERT INTO ROLE(name) VALUES('Obsluha');
INSERT INTO ROLE(name) VALUES('Účetní');

--employees
INSERT INTO EMPLOYEE(role, id_branch, name, surname, phone, mail) VALUES (1, 1, 'Dante', 'Smith', NULL, NULL);
INSERT INTO EMPLOYEE(role, id_branch, name, surname, phone, mail) VALUES (3, 1, 'Angellica', 'Smith', NULL, NULL);

--orders
INSERT INTO ORDERS(id_branch, o_date, person, address) VALUES (1, '2018-4-17', 'Some random guy', 'Petřín 1284');

--order items
INSERT INTO ORDER_ITEM(id_menu_item, id_order) VALUES (9, 1);
INSERT INTO ORDER_ITEM(id_menu_item, id_order) VALUES (13, 1);

--news
INSERT INTO NEWS(id_restaurant, n_date) VALUES (1, '2018-4-17');

--news description
INSERT INTO NEWS_NAME(id_news, id_language, header, description) VALUES (1, 1, 'Birthday action', 'Free drinks for people born in 17.4.');
INSERT INTO NEWS_NAME(id_news, id_language, header, description) VALUES (1, 2, 'Narozenninová akce', 'Nápoj zdarma pro lidi narozené 17.4.');

--main picture
INSERT INTO GENERAL_CONFIG(url_main_image) VALUES ('https://image.ibb.co/eu23fd/dream_Team_Logo.png');

--introduction
INSERT INTO INTRO_CONFIG(id_language, header, short_description, news_header) VALUES (1, 'Introduction', 'Welcome!\nHere are some of recent events:', 'News and events');
INSERT INTO INTRO_CONFIG(id_language, header, short_description, news_header) VALUES (2, 'Úvod', 'Vítejte!\nZde jsou informace o aktuálních akcích:', 'Aktuality a akce');

--menu config
INSERT INTO MENUS_CONFIG(id_language, header) VALUES (1, 'Menu');
INSERT INTO MENUS_CONFIG(id_language, header) VALUES (2, 'Jídelníček');

--menu items
INSERT INTO MENUS_NAME(id_menu, id_language, description) VALUES (1, 1, 'Food');
INSERT INTO MENUS_NAME(id_menu, id_language, description) VALUES (2, 1, 'Beverages');
INSERT INTO MENUS_NAME(id_menu, id_language, description) VALUES (1, 2, 'Jídlo');
INSERT INTO MENUS_NAME(id_menu, id_language, description) VALUES (2, 2, 'Nápoje');

--about us
INSERT INTO ABOUT_US_CONFIG(id_language, header, description, fotogallery_header) VALUES (1, 'About us', 'We are the best', 'Fotogallery');
INSERT INTO ABOUT_US_CONFIG(id_language, header, description, fotogallery_header) VALUES (2, 'O nás', 'Jsme nejlepší', 'Fotogalerie');

--contact
INSERT INTO CONTACT_CONFIG(id_language, header, description, url_image_map, url_image_restaurant) VALUES (1, 'Contact', 'Find us on FIT CVUT CZ!!!', NULL, NULL);
INSERT INTO CONTACT_CONFIG(id_language, header, description, url_image_map, url_image_restaurant) VALUES (2, 'Kontakt', 'Najdete nás na FIT CVUT CZ!!!', NULL, NULL);