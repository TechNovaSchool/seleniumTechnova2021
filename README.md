08.03.21
Selenium - automation tool for testing UI. .jar files (library)
- create a new project using maven and add dependencies
- download from the selenium official website
In order to connect selenium with a browser we are using driver
  Maven is a build automation tool, it helps to create and manage the project
  
pom.xml it allows us to add and manage our dependencies

WebDriverManager.firefoxdriver().setup(); line to setup browser

driver.manage().window().maximize(); will maximize browser window

driver.close(); - will close the browser

<a href="www.test.com"> My test website </a>

1. linkText from example above driver.findElement(By.linkText("My test website")).click();
  - works only for links
  - how do you know this is a link? it has <a> anchor tag

2. name --> ex. driver.findElement(By.name("q"));
   - it looks for the value of the name attribute
   - it finds and return a WebElement with the matching attribute name
    
3. className
-this locator is looking for class attribute value
   - it doesn't have to be unique
    -it will return first matching class value

4. id
- 99% id is an unique attribute
-
   
5.partialLinkText
-from example above driver.findElement(By.linkText("My test")).click();
-similar to java contains

6.tagName
-this is looking for a tag name example <h2>, <a>

7.cssSelector
8.xpath
   

NoSuchElementException it happens when driver was not able to find webElement or slow internet
ElementNotInteractableException

1. Open a Chrome browser
2. Go to https://google.com
3. Click Gmail from top right
4. Verify element contains Expected <Gmail>
5. Go back to Google by using back() command
6. Verify title contains "Google"
7. Go back to Gmail using forward button
8. Verify title contains Expected Gmail

Task #4
1. Open Chrome browser
2. Go to google.com
3. Write "apple" in search box
4. Click google search button or Enter
5. Verify title it should contain a word "apple"

sendKeys("apple") -- send characters to the field (example search)
Keys.   --> using keyboard commands
ENTER
Tab

Task #5 -- Basic login authentication
1. Open a Chrome browser
2. Go to : http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Verify title equals -->expected "Web orders Login"
4. Enter username : Tester
5. Enter Password: test
6. Click "Sign In" button
7. Verify title equals --> expected Web Orders
