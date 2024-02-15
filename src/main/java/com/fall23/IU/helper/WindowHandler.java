package com.fall23.IU.helper;

import com.fall23.IU.drivers.Driver;
import org.openqa.selenium.WebDriver;
import java.util.LinkedList;
import java.util.Set;

public class WindowHandler {

    // этот класс для управления вкладками в браузере

    private WebDriver driver;


    // set чтобы вкладки уникальные
    public Set<String> getWindowHandles() {
        return Driver.getDriver().getWindowHandles();
    }

    public void switchToWindow(int index) {
        LinkedList<String> windowsID = new LinkedList<>(   //LinkedList -> возвращает элемент в том порядке в каком указали
                getWindowHandles()
        );
        if (index < 0 || index > windowsID.size()) {       // если индекс меньше нуля либо колич.открытых вкладок больше указан.индекса
            throw new IllegalArgumentException("You provide wrong Index" + index);
        }
        Driver.getDriver().switchTo().window(windowsID.get(index));
    }

    public void switchToParent() {
        LinkedList<String> windowsID = new LinkedList<>(getWindowHandles());
        Driver.getDriver().switchTo().window(windowsID.get(0));
    }

    public void switchToParentWithChildClose() {
        switchToParent();
        LinkedList<String> windowsID = new LinkedList<>(
                getWindowHandles()
        );
        for (int i = 1; i < windowsID.size(); i++) {
            Driver.getDriver().switchTo().window(windowsID.get(i));
            Driver.getDriver().close();
        }
        switchToParent();
    }



//    public static void main(String[] args) {
//        Driver.getDriver().get("https://demoqa.com/browser-windows");
//        WebElement newTab = Driver.getDriver().findElement(By.id("tabButton"));
//        for (int i = 0; i < 3; i++){
//            newTab.click();
//        }
//    }
}
