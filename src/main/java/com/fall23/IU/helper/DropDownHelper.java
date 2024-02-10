package com.fall23.IU.helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class DropDownHelper {

    Select select;

    // Для выбора из дропдаунов:

    // выбирает из дропдауна по тексту
    public DropDownHelper selectByText(WebElement element, String txt){
        select = new Select(element);
        select.selectByVisibleText(txt);
        return this;
    }

    // выбирает по индексу
    public DropDownHelper selectByIndex(WebElement element, int index){
        select = new Select(element);
        select.selectByIndex(index);
        return this;
    }

    // выбирает по значению
    public DropDownHelper selectByValue(WebElement element, String value){
        select = new Select(element);
        select.selectByValue(value);
        return this;
    }

    // чтобы вернуть список всех значений из списка дропдауна
    public List<String> getAllDropdownValue(WebElement element){
        select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<>();

        for (WebElement element1 : elementList){
            valueList.add(element1.getText());
        }
        return valueList;
    }
}
