package ge.tbcitacademy.data;

public class Constants {
    // EXCEPTIONS MESSAGES
    public static final String UNSUPPORTED_ELEMENT_TYPE_MESSAGE = "Unsupported element type. Expected Select or WebElement";
    // ##################################
    // TEST URL's
    public static final String DYNAMIC_CONTROLS_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    public static final String DYNAMIC_LOADING_URL = "https://the-internet.herokuapp.com/dynamic_loading";
    public static final String JOBS_GE_URL = "https://jobs.ge";
    public static final String SELENIUM_CLICK_IN_IFRAME_URL = "https://www.selenium.dev/selenium/web/click_tests/click_in_iframe.html";
    public static final String SELENIUM_DYNAMIC_URL = "https://www.selenium.dev/selenium/web/dynamic.html";
    public static final String SMASHING_MAGAZINE_LONG_SCROLLING_URL = "https://www.smashingmagazine.com/2017/05/long-scrolling/";
    public static final String DEMOQA_BROWSER_WINDOWS_URL = "https://demoqa.com/browser-windows";
    public static final String BATUMI_GOV_URL = "https://batumi.gov.ge";
    public static final String GOOGLE_URL = "https://www.google.com/";
    public static final String AUTOMATION_URL = "https://ultimateqa.com/automation";
    public static final String DRAG_AND_DROP_URL = "http://the-internet.herokuapp.com/drag_and_drop";
    public static final String JQUERY_UI_SLIDER_URL = "https://jqueryui.com/slider/";
    public static final String ADD_REMOVE_ELEMENTS_URL = "http://the-internet.herokuapp.com/add_remove_elements/";
    public static final String CHALLENGING_DOM_URL = "http://the-internet.herokuapp.com/challenging_dom";
    public static final String CUSTOM_DROP_DOWN_TEST_URL = "https://tympanus.net/Tutorials/CustomDropDownListStyling/";
    public static final String CANVAS_REGISTER_URL = "https://techcanvass.com/examples/register.html";
    public static final String PROGRESS_BAR_URL = "https://demoqa.com/progress-bar";
    public static final String I_FRAMES_URL = "http://the-internet.herokuapp.com/iframe";
    public static final String DEMO_QA_ALERTS_URL = "https://demoqa.com/alerts";
    public static final String TECHLISTIC_TABLE_URL = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
    public static final String TECH_CANVAS_TABLE_URL = "https://techcanvass.com/Examples/webtable.html";
    public static final String HARD_DOM_TABLE_URL = "http://the-internet.herokuapp.com/challenging_dom#delete";
    public static final String DEPRESSION_IS_REAL_TABLE_URL = "https://www.healthline.com/health/depression/facts-statistics-infographic#how-common-is-it";
    public static final String WIKIPEDIA_TABLE_URL = "https://en.wikipedia.org/wiki/Help:Table";
    public static final String TODO_LIST_URL = "http://webdriveruniversity.com/To-Do-List/index.html";
    public static final String SCROLLING_PRACTICE_URL = "http://webdriveruniversity.com/Scrolling/index.html";
    // WAIT TIMEOUTS
    public static final int DEFAULT_TIMEOUT_SECONDS_MEDIUM = 10;
    public static final int DEFAULT_TIMEOUT_SECONDS_SHORT = 5;
    public static final int DEFAULT_TIMEOUT_SECONDS_LONG = 15;
    public static final int DEFAULT_TIMEOUT_MILISEC_MEDIUM = 500;
    // ##################################
    // unorderedListTest
    public static final String FILTER_KEYWORD = "o";
    public static final String EXCLUDED_URL_KEYWORD = "animate";
    public static final String HREF_ATTRIBUTE = "href";
    public static final String ANCHOR_TAG = "a";
    public static final String ASIDE_XPATH_BASE = ".//aside[h3[text() = 'Effects' and @class='widget-title']]" ;
    // LIST_ITEM_XPATH აქ შეიძლება ასევე დავწეროთ .//child::ul/li თითქმის ნებისმიერ შემთხვევაში იმუშავებდა მაგრამ უარესი performance აქვს.
    public static final String LIST_ITEM_XPATH = ".//following-sibling::ul/li";
    // ##################################
    // buttonsTest
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
    public static final String LOREM_VALUE_1_XPATH = ".//td[text()='Apeirian9']/preceding-sibling::td";
    public static final String LOREM_VALUE_2_XPATH = ".//tbody/tr[10]/td[1]";
    public static final String TABLE_ROWS_XPATH = ".//table/tbody/tr";
    public static final String CELL_XPATH = "./td";
    public static final String TARGET_CELL_TEXT = "Apeirian9";
    public static final String PRECEDING_SIBLING_TD_XPATH = "./preceding-sibling::td";
    public static final String TARGET_LOREM_TEXT = "Iuvaret9";
    public static final String TARGET_LOREM_TEXT_ERROR_MESSAGE = "Lorem value doesnt equal 'Iuvaret9'.";
    // ##################################
    // customDropDownTest
    public static final String GITHUB_OPTION = "Github";
    // ##################################
    // nativeDropDownTest
    public static final String MEGA_MEDIUM_OPTION = "Mega 123 Medium screen";
    public static final String FIRST_NAME = "Luka";
    public static final String LAST_NAME = "Tsinaridze";
    public static final String ADDRESS_1 = "Shandor petefi";
    public static final String ADDRESS_2 = "Selim khimshiashvili";
    public static final String CITY = "Tbilisi";
    public static final String CONTACT_1 = "579020004";
    public static final String CONTACT_2 = "588887143";


    // waitForDisappearance
    public static final String EXPECTED_BUTTON_TEXT = "Disable";
    public static final String BUTTON_MISMATCH_MESSAGE = "Button value isn't 'Disabled'";
    public static final String SELECT_MISMATCH_MESSAGE = "Selected option is Incorrect.";
    public static final String ACCESS_GRANTED_MESSAGE = "ACCESS GRANTED";
    // ##################################
    // waitForText
    public static final String EXPECTED_PROGRESS_TEXT = "100%";
    // iFrameTest
    public static final String TEXT_TO_SEND = "Here Goes";
    // TECHLISTIC_TABLE
    public static final String TABLE1_ROW = "Austria";
    public static final String TABLE1_COLUMN_HEADER = "Country";
    public static final String TABLE2_ROW = "Taipei 101";
    public static final String TABLE2_COLUMN_HEADER = "Built";
    public static final String EXPECTED_TABLE1_COUNTRY = "Austria";
    public static final String TABLE1_NAME_MISMATCH_MESSAGE = "Expected to find '" + EXPECTED_TABLE1_COUNTRY + "' in the table, but the content didn't match.";
    public static final String EXPECTED_TABLE2_YEAR = "2004";
    public static final String TABLE2_YEAR_MISMATCH_MESSAGE = "Expected to find '" + EXPECTED_TABLE2_YEAR + "' in the table, but the content didn't match.";
    // TECH_CANVAS_TABLE
    public static final String TABLE3_ROW = "Honda";
    public static final String TABLE3_COLUMN_HEADER = "Make";
    public static final String EXPECTED_TABLE_MAKE = "Jazz";
    public static final String TABLE_MAKE_MISMATCH_MESSAGE = "Expected to find '" + EXPECTED_TABLE_MAKE + "' in the table, but the content didn't match.";
    // HARD DOM TABLE
    public static final String TABLE4_ROW = "Iuvaret1";
    public static final String TABLE4_COLUMN_HEADER = "Amet";
    public static final String EXPECTED_TABLE_CONSEQUUNTUR = "Consequuntur1";
    public static final String TABLE_CONSEQUUNTUR_MISMATCH_MESSAGE = "Expected to find '" + EXPECTED_TABLE_CONSEQUUNTUR + "' in the table, but the content didn't match.";
    // DEPRESSION TABLE
    public static final String TABLE5_ROW = "18–25";
    public static final String TABLE5_COLUMN_HEADER = "2020";
    public static final String EXPECTED_TABLE_PERC = "17.2%";
    public static final String TABLE_PERC_MISMATCH_MESSAGE = "Expected to find '" + EXPECTED_TABLE_PERC + "' in the table, but the content didn't match.";
    // WIKIPEDIA
    public static final String TABLE6_ROW = "Table header cell";
    public static final String TABLE6_COLUMN_HEADER = "Usage notes";
    public static final String EXPECTED_TABLE_NOTE = "Consecutive table header cells may be added on the same line separated by double marks (!!); or start on new lines, each with its own single mark (!).";
    public static final String TABLE_NOTE_MISMATCH_MESSAGE = "Expected to find '" + EXPECTED_TABLE_NOTE + "' in the table, but the content didn't match.";
    // JSexecutor
    public static final String ELEMENT_UNEXPECTEDLY_FOUND_MSG = "Element should not be found in DOM!";
    public static final String ELEMENT_DELETED_SUCCESS_MSG = "Element was deleted as expected.\n";
    public static final int EXPECTED_CODE_PAIR_COUNT = 8;
    public static final String SCROLL_TO_ELEMENT = "arguments[0].scrollIntoView();";
    public static final String CLICK_THE_ELEMENT = "arguments[0].click();";
    public static final String GET_ELEMENT_INNER_TEXT = "return arguments[0].innerText";
    public static final String SCROLL_TO_ELEMENT_CUSTOM = "window.scrollTo(0, document.body.scrollHeight)";
    public static final String EXPECTED_ENTRIES_TEXT = "0 Entries";
    // Exceptions
    public static final int X_OFFSET = 0;
    public static final int Y_OFFSET = 1000;
    public static final int FRAME_INDEX_1 = 1;
    public static final String WINDOW_HANDLE_2 = "windowNumber2";
}
