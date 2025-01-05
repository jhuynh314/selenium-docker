package com.jhuynh14.pages.flightreservation;

import com.jhuynh14.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {

    @FindBy(id = "oneway")
    private WebElement oneWayRadioButton;

    @FindBy(id = "twoway")
    private WebElement twoWayRadioButton;

    @FindBy(id = "passengers")
    private WebElement passengerSelect;

    @FindBy(id = "depart-from")
    private WebElement departFromSelect;

    @FindBy(id = "arrive-in")
    private WebElement arriveInSelect;

    @FindBy(id="search-flights")
    private WebElement searchFlightsButton;

    public FlightSearchPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchFlightsButton));
        return this.searchFlightsButton.isDisplayed();
    }

    public void selectOneWay(){
        this.oneWayRadioButton.click();
    }

    public void selectRoundTrip(){
        this.twoWayRadioButton.click();
    }

    public void selectPassengers(String numOfPassengers){
        Select passengers = new Select(this.passengerSelect);
        passengers.selectByValue(numOfPassengers);
    }

    public void searchFlights(){
        Actions actions = new Actions(driver);
        actions.moveToElement(this.searchFlightsButton);
        actions.perform();
        this.searchFlightsButton.click();
    }
}
