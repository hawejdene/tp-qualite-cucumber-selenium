package refunds;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
public class StepDefinitions {

   private String refunds;
   private Item item = new Item();

    @Given("^: the item is hardware bought (\\d+) day ago in good condition$")
    public void the_item_is_hardware_bought_day_ago_in_good_condition(int days) throws Exception {
        item.setBoughtAt(days);
        item.setGoodCondition(true);
        item.setType("hardware");
    }

    @When("^: ask for refund$")
    public void ask_for_refund() throws Exception {
        if (item.getType().equals("hardware")) {
            if ((item.getBoughtAt() < 7) && (item.getGoodCondition())) refunds = "repare";
            else refunds = "refuse";
        }
         else if (item.getType().equals("clothes")){
            if ((item.getBoughtAt() < 7) && (!item.isSales()) && (item.getGoodCondition())) refunds = "accepted";
            else refunds = "refuse";
        } else refunds = "not in our shop";
        }

    @Then("^: refund repare$")
    public void refund_repare() throws Exception {
        assertEquals(refunds, "repare");
    }

    @Given("^: the item is hardware bought (\\d+) day ago in bad condition$")
    public void the_item_is_hardware_bought_day_ago_in_bad_condition(int days) throws Exception {
        item.setBoughtAt(days);
        item.setGoodCondition(false);
        item.setType("hardware");
    }

    @Then("^: refund refused$")
    public void refund_refused() throws Exception {
        assertEquals(refunds, "refuse");
    }

    @Given("^: the item is clothes  bought (\\d+) day ago in good condition during normal days$")
    public void the_item_is_clothes_bought_day_ago_in_good_condition_during_normal_days(int days) throws Exception {
        item.setBoughtAt(days);
        item.setGoodCondition(true);
        item.setType("clothes");
        item.setSales(false);
    }
    @Then("^: refund accepted$")
    public void refund_accepted() throws Exception {
        assertEquals(refunds, "accepted");
    }

    @Given("^: the item is clothes  bought (\\d+) day ago in good condition during sales days$")
    public void the_item_is_clothes_bought_day_ago_in_good_condition_during_sales_days(int days) throws Exception {
        item.setBoughtAt(days);
        item.setGoodCondition(true);
        item.setType("clothes");
        item.setSales(true);
    }

    @Given("^: the item is clothes  bought (\\d+) day ago in bad condition during normal days$")
    public void the_item_is_clothes_bought_day_ago_in_bad_condition_during_normal_days(int days) throws Exception {
        item.setBoughtAt(days);
        item.setGoodCondition(false);
        item.setType("clothes");
        item.setSales(false);
    }

    @Given("^: the item is clothes  bought (\\d+) day ago in bad condition during sales days$")
    public void the_item_is_clothes_bought_day_ago_in_bad_condition_during_sales_days(int days) throws Exception {
        item.setBoughtAt(days);
        item.setGoodCondition(false);
        item.setType("clothes");
        item.setSales(true);
    }

}
