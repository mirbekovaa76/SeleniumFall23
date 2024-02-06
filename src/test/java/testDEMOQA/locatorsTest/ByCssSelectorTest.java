package testDEMOQA.locatorsTest;
import org.testng.annotations.Test;

import static com.fall23.DEMOQA.WebElementManager.findElementByCssSelector;

public class ByCssSelectorTest { // css - язык на к-м задаются стили для элементов на странице
    // чтобы задавать стиль, нужно определить какому элементу задавать стиль
    // для этого и нужены Css Локаторы (selectors)
    // искать по поиску м.б. неудобно (будет искать все селекторы)
    // лучше на консоли

    // в консоли задают селекторы через $$("")
    // $$("body") -> по тегу
    // $$("# + ID") -> по id
    // $$(". + class name") -> селектор по названию класса
    // $$("[role='main']") -> по атрибуту, "" заменяются на ''
    // $$("[role]")
    // $$("div[role]") можно и так

    @Test
    void test123(){
        findElementByCssSelector("#userName");


    }


}
