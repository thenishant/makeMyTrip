package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Calender {

    public void getDate(String date, List<WebElement> list) {
        String[] splitDate = date.split(" ");
        String day = splitDate[0];
        String month=splitDate[1]+" "+splitDate[2];
        list.size();
        List<WebElement> totalDays = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<WebElement> elements = list.get(0).findElements(By.id("com.makemytrip:id/calendar_day_row")).get(i).findElements(By.id("com.makemytrip:id/calendar_day"));
            totalDays.addAll(elements);
        }
        totalDays.get(Integer.parseInt(day)).click();
    }
}
