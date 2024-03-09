package ge.tbcitacademy.data;

public class Constants {
    // წესით ეს ყველა უნდა იყოს final მაგრამ რადგან პირობაში წერია "public static variables in this class." არ დავწერე
    public static final String DYNAMIC_CONTROLS_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    public static final String AUTOMATION_URL = "https://ultimateqa.com/automation";
    public static final String DRAG_AND_DROP_URL = "http://the-internet.herokuapp.com/drag_and_drop";
    // ##################################

    // unorderedListTest
    public static final String JQUERY_UI_SLIDER_URL = "https://jqueryui.com/slider/";
    public static final String FILTER_KEYWORD = "o";
    public static final String EXCLUDED_URL_KEYWORD = "animate";
    public static final String HREF_ATTRIBUTE = "href";
    public static final String ANCHOR_TAG = "a";
    public static final String ASIDE_XPATH_BASE = ".//aside[h3[text() = 'Effects' and @class='widget-title']]" ;
    // LIST_ITEM_XPATH აქ შეიძლება ასევე დავწეროთ .//child::ul/li თითქმის ნებისმიერ შემთხვევაში იმუშავებდა მაგრამ უარესი performance აქვს.
    public static final String LIST_ITEM_XPATH = ".//following-sibling::ul/li";
    // ##################################
    // buttonsTest
    public static final String ADD_REMOVE_ELEMENTS_URL = "http://the-internet.herokuapp.com/add_remove_elements/";
    public static final String ADD_BUTTON_XPATH = ".//button[@onclick='addElement()']";
    public static final int CLICK_BUTTON_AMOUNT = 3;
    public static final String LAST_DELETE_BTN_CSS_PATH = "button.added-manually:last-of-type";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String ADDED_MANUALLY_CLASS = "added-manually";
    public static final String DELETE_BUTTON_ERROR_MESSAGE = "Last 'Delete' button does not have the 'added-manually' class";
    public static final String DELETE_BTNS_CSS_PATH = "button[class^='added-manually']";
    public static final String DELETE_BUTTON_ONCLICK_ATTRIBUTE = "onClick";
    public static final String EXPECTED_DELETE_BUTTON_ONCLICK = "deleteElement()";
    public static final String DELETE_BUTTON_ONCLICK_ERROR_MESSAGE = "Last 'Delete' button does not have 'onClick' set to deleteElement()";
    public static final long BUTTONS_TEST_SLEEP_MILISEC = 1000L;
    // ##################################
    // challengingDomTest
    public static final String CHALLENGING_DOM_URL = "http://the-internet.herokuapp.com/challenging_dom";
    public static final String LOREM_VALUE_1_XPATH = ".//td[text()='Apeirian9']/preceding-sibling::td";
    public static final String LOREM_VALUE_2_XPATH = ".//tbody/tr[10]/td[1]";
    public static final String TABLE_ROWS_XPATH = ".//table/tbody/tr";
    public static final String CELL_XPATH = "./td";
    public static final String TARGET_CELL_TEXT = "Apeirian9";
    public static final String PRECEDING_SIBLING_TD_XPATH = "./preceding-sibling::td";
    public static final String TARGET_LOREM_TEXT = "Iuvaret9";
    public static final String TARGET_LOREM_TEXT_ERROR_MESSAGE = "Lorem value doesnt equal 'Iuvaret9'.";
}
