package enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyStore extends BaseTest{
    final String url = "https://www.google.com";
    final String urlMystore = "https://automationpractice.com/index.php";
    private WebDriver _childWebDriver = getWebDriver(WebDriverType.CHROME);

    @Test
    public void testVerificarText1(){
        _childWebDriver.get(urlMystore);
        WebElement women = _childWebDriver.findElement(By.cssSelector("a.sf-with-ul"));
        women.click();
        String text = _childWebDriver.findElement(By.cssSelector("#center_column > div.content_scene_cat > div > div > div > p:nth-child(2)")).getText();
        String requiredText ="This category includes all the basics of your wardrobe and much more:";
        Assert.assertEquals(text,requiredText );
        String text2 = _childWebDriver.findElement(By.cssSelector("#center_column > div.content_scene_cat > div > div > div > p:nth-child(3)")).getText();
        String requiredText2 ="shoes, accessories, printed t-shirts, feminine dresses, women's jeans!";
        Assert.assertEquals(text2,requiredText2 );
        String text3 = _childWebDriver.findElement(By.cssSelector("span.heading-counter")).getText();
        String requiredText3 ="There are 7 products.";
        Assert.assertEquals(text3,requiredText3 );




    }


}
