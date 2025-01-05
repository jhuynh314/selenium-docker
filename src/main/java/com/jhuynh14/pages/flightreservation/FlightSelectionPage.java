package com.jhuynh14.pages.flightreservation;

import com.jhuynh14.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FlightSelectionPage extends AbstractPage {

    @FindBy(name="departure-flight")
    private List<WebElement> departureFlightsOptions;

    @FindBy(name="arrival-flight")
    private List<WebElement> arrivalFlightsOptions;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightsButton;

    public FlightSelectionPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmFlightsButton));
        return this.confirmFlightsButton.isDisplayed();
    }

    public void selectFlights(){
        int random1 = ThreadLocalRandom.current().nextInt(0,departureFlightsOptions.size());
        int random2 = ThreadLocalRandom.current().nextInt(0,arrivalFlightsOptions.size());
        this.departureFlightsOptions.get(random1).click();
        this.arrivalFlightsOptions.get(random2).click();
    }

    public void confirmFlights(){
        Actions actions = new Actions(driver);
        actions.moveToElement(this.confirmFlightsButton);
        actions.perform();
        this.confirmFlightsButton.click();
    }
}
