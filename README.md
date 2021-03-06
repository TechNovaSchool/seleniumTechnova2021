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

<a href="www.test.com">My test website</a>

Locators:

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
- 99% id is an attribute with unique value
-
   
5.partialLinkText
-from example above driver.findElement(By.linkText("My test")).click();
-similar to java contains

6.tagName
-this is looking for a tag name example <h2>, <a>

7.cssSelector
-element[attribute] => input[id]
-element[a='value'] =>input[id="global-enhancements-search-query"]
-element#value -->id attribute =>#global-enhancements-search-query
-element.value --> class attribute value => .clear

Navigating to the child element
">" using this sign to move down to the child element ex. div>dialog>div>button[name="123"];

8.xpath
 - We have two of types of xpath:
 - The absolute path and relative path
    -----
absolute 
is starting with a single /(slash)
-is not reliable, because it will break at any change in HTML structure

relative path
- starting with // (double slash)
- instead of starting from html, it will start from given point
- <//div> navigates to the very first <div> tag
- is more stable locator

1.//element[@attribute='value'] =>//*[@id="global-enhancements-search-query"]

2. //*[@attribute='value']  => //*[@id="global-enhancements-search-query"]
* star looks in all the web elements
. example of unique element -->(//h2)[] when we have more than 1 element
  
3. using contains:
//element[contains(@attribute, 'value')] =>//input[ contains(@data-id,'search-query')]
   
4. using text (exact text between opening and closing tag )
   
   <a class="gb_f" data-pid="23" href="https://mail.google.com/mail/&amp;ogbl" target="_top">Gmail</a>
   
   //a[.='Gmail']
navigation in xpath :
Parent to child --> //div/div[@role="status"] using "/" single slash
Child to Parent --> //div[@role="status"]/.. using "/.." single slash and two periods

   
  
   

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


-->getText(); will return a string element and allows us to do any string manipulations
-->getAttribute(); will return value of the html element attribute 
ex. driver.findElement(By.partialLinkText("Forgot")).getAttribute("href");

--> We can store a web-element in Object from selenium library
WebElement element = driver.findElement(By.partialLinkText("Forgot"));
element.getText();
element.click();

to open find line for locators:
Mac --> CMD+F
Win -->CTRL+F

1. Open a Chrome browser
2. Go to amazon.com
3. Enter any search term
4. Click on search button
5. Verify title
   use cssSelector
   
----------------------------------------
August 7

What is Selenium?
- tool to use to automate web-browsers/ UI
- set of jar files / or library

Why we are using Selenium?
- Is tool which open source
- multiple browser, different programing languages
- support multiple platforms

What is a web element ?
- Everything we can see on the web page
  (img, buttons, links)
  
What is a locator?
- syntax that help to find any web-element

What methods are using to locate a web-element ?
- findElement(By.anylocators);

How many locators do we know ?
- 8 locators
  - linkedText; 
    <a> anchor tag 
    is looking for exact text
  - partialLinkedText
    <a> 
    is looking just for partial text 
  - id
    -findElement(By.id)
    -has a unique value
    we can have a dynamic id ( ex.id= "global-enhancements-search-query-14313413134")
    
  - className
    we are using class attribute and its value (ex.class="wt-label-wt-screen-reader-only")
  - name
    we are using name attribute and its value (ex.name="search_query")
  - tagName
    We are using tags (ex. h2)
      
  - css
  - helps to move from parent to child one flow,
    -it has its own syntax 
    .wt-label-wt-screen-reader-only will return the locator
    #global-enhancements-search-query
    input[data-id*="search"] - using star(*)/($) to check for partial attribute value
    if your class value had a " " (space) in css just delete space and add . (period)
    ".wt-input-btn-group__btn global-enhancements-search-input-btn-group__btn"
    ".wt-input-btn-group__btn.global-enhancements-search-input-btn-group__btn"
    how to move from parent to child (>)

  - xpath
    -absolute
    starts with one slash (/)
    starts from the beginning of the HTML
    
  -relative
-starts with double slash (//)
  allows to move from child to parent //input[@name="q"]/..
  how to move from parent tp child one slash(/) //input[@name="q"]/div
  //a[.='Gmail'] using dot to locate by exact text 
  
For reference look into document i sent on slack 

Exception from Selenium
 - NoSuchElementException
Driver was not able to find this element on the page
  -StaleElementException - related to internet speed
   driver.navigate().refresh();


Pre-conditionsHave a array with names 3 -4 values



1. Open a Chrome browser
2. Go to http://a.testaddressbook.com/sign_in
3. Enter email using random of element of array adding @gmail.com at the end
4. Enter a dummy password
5. Click on sign in button
6. Verify a message displayed ???Bad email or password.???

What is the Maven ?
 -build automation tool
What is a build?
1. Create a folder
2. Java files
3. Create class
4. Compile the code
5. Test
6. Deploy


This will wait until apge is loaded 
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
this is implicit wait 
is not same thing as Thread.sleep(2000);  
   --> comes from java library
   --> stop (pause) the execution of the program

---------------------
Check-boxes allow to select multiple answers at the same time
Radio buttons allows to select only one

- is.Selected(); --> checks if the checkbox is selected and will return true/false. This a boolean value
- is.Enabled(); --> checks if the element is enabled to do any actions


Task#2
1. Open a chrome browser
2. Go to https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC
3. Enter any login
4. Enter any password
5. Add two amount from both accounts
6. Verify sum amount (hint use getText())


08.10 
Recap
isDisplayed(); => return true /false  
isEnabled();
isSelected();
- return a boolean;
- checkbox, radio buttons
  
  -driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  selenium
  -Thread.sleep(10000) java method
  
Maven
is build automation tool, allow us to manage our dependency 
Maven provide pom.xml file to keep all dependencies, using maven we create folder structure

---------------------
findElement() => WebElement
-exception:NoSuchElementException

findElements() => multiple WebElements
- exception --> It will not throw any exception
return an empty list

WebElement element = driver.findElement(By.id("id"));

List<WebElement> listElements = driver.findElements(By.id("id"));

Task FindElements

Task  #1 - Check all link on the page
1. Open Chrome browser
2. Go to https://www.technovaschool.com/
3. Count the number of the links on the web-page (expected 41)
4. Print out all the texts of the links on the page
5. Count the number of the links that doesn't have text (expected 19)


-----------------
DropDowns
To handle dropdown we use Select class

        <select name="carlist">
			<option value="honda">Honda</option>
			<option value="nissan" selected="selected">Nissan</option>
			<option value="ford">Ford</option>
		</select>

There are 2 ways to create dropdown :
1 - is using select tag
Step 1
We located the weblement of the dropdown
Step 2
We create a Select class from selenium library  and add dropdown element as a parametr

WebElement dropDown = driver.findElement(By.xpath("//select"));

Select select = new Select(dropDown);

Select select1 = new Select(driver.findElement(By.xpath("//select"));

Most used methods:
  ==>  select.selectByVisibleText(); takes string
select.selectByVisibleText("Honda");

  ==> select.byIndex(2); return Ford 
  ==>select.byValue(); takes string

  ==>select.getFirstSelectedOption();
  --Can be used to get default option on the select tag
  -- Can be used after we select an option

 ==>select.getOptions();
    return us a List<WebElement>
 ==>select.getAllSelectedOptions();
  --Can be used to get all selected option as a WebElement

  ==> select.deSelectAll();
 -- This method will deselect all selected values from dropdown
------------
Faker library
This library allows us to create fake data 

Faker faker = new Faker();
clear(); --> is a selenium method to clear value before set any new values using sendKeys.... workaround that:
"    quantity.clear();
quantity.sendKeys(Keys.BACK_SPACE,"someValue");"


============================================
08.14 
When attribute is changing a part of its value ex. below

<input id="ctl00_MainContent_fmwOrder_txtName">   </input> ---> static
id="65497894_ctl00_MainContent_fmwOrder_txtName" ---> Dynamic locator
id="tretdsfhs_ctl00_MainContent_fmwOrder_txtName"

---Css:
==> 
input[id*='MainContent']
input[id$='MainContent']

---xpath:
==>   //id[contains(text(),'t')] ---> //id[contains(text(),'ctl00_MainContent_fmwOrder_txtName')]
==>  //id[start-with(@attributeName, 'value')]
==>  //id[ends-with(@attributeName, 'value')]

Project structure:
Java 
  Selenium
  WebDriver manager
  faker library
  testNG

 WebElement message = driver.findElement(By.xpath("//div[@class=\"buttons_process\"]/strong"));
 if(message.isDisplayed()) {
 System.out.println("Test Pass");
}
 else {
 System.out.println("Test Fail");
}

Assertions

TestNG
Stands for Test Next Generation
it an open source library
is a UNIT test framework
it an improved version of jUnit, nUnit;

TestNg has more options for annotation compare to jUnit
---->
Annotations: 

1 - @Test -- Test automation allows us to create independent test
By default will select in alphabetical order

2- @BeforeClass
--This method will run before everything else in our class
---> driver instantiating 
---> ex .
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

3 @BeforeMethod
This method will run ONCE before each Test
is useful when we want to setup some conditions to each test

4    @AfterMethod
This will run after every test annotations
useful for ex:
driver.close();
driver.quit();
 5-  @AfterClass
This annotation will run after everything else in the class is done (run)

@BeforeClass
public void setUp()

5-  @AfterClass
public void tearDown()

Assertions:
-- Assertions are coming testng library
-- this is a method which allows us to do verification
Assert.assertEquals
   It takes 3 parameters
        --> actual value
        -->expected value
        -->message which will display on the console just in case if test failed

Ex: Assert.assertEquals(driver.getTitle(), "expected title", "message here")

Assert.assertTrue
This method will verify the boolean value :
Ex:
--isDisplayed();
--isEnabled();
--isSelected();
--"test".equals("test")

Assert.fail();
This method will verify if the condition will return FALSE, in this case it will pass the test

Task:
Task DeleteAll
1. Open a chrome browser
2. Go to :http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username : ???Tester???
4. Enter password: ???test???
5. Click on logon button
6. Click checkAll
7. Click ???Delete Selected???
8. Assert ???List of orders is empty. In order to add new order use  this link.??? text is displayed


---------
08.17
TestNG is a dependency, it allows to run the test
framework for unit testing
It allows us to run test using annotations
Why we are using TestNG?
Take advantage of build in methods, annotations

@Test
- to run independent test
- By default will select in alphabetical order

@BeforeClass
-to run something ONCE before class
@AfterClass
-to run something ONCE after class
@BeforeMethod /@AfterMethod
will run before and after each test

assert.True
---expected to the true result fot the boolean value
assert.False
---expected to the FALSE result fot the boolean value
assert.assertEquals

assert.assertNotEquals
=======================

Priority 

Default value is zero = (priority = 0)
The smaller number we have the earlier the test will run
we can have even negative numbers (priority = -1)

@Ignore

Is used to ignore test 
also we can just comment 
========================

Dependency
It will overwrite priority

dependsOnMethods will add the logic to which method we need to use first
ex:
@Test (priority = 0, dependsOnMethods = "secondTest")
public void firstTest() {
System.out.println("My first test");
}

    @Test (priority = 1)
    public void secondTest() {
        System.out.println("My second test");
    }

===================================
iFrame
HMTL inside of another HTML
Selenium can not focus at two HTML at the same time,
so if we want to perform any action we need to switch to another HTML

If we have an element in inner HTML we can not perform any actions before we switch our diver focus

WebElement iframe = driver.findElement()
driver.switchTo(iframe)


We can switch frames by index number
driver.switchTo.frame(0)

We can switch iframe by id value of this iframe
driver.switchTo.frame("idvalue");

======

Using this syntex to switch back to main iframe

driver.switchTo().parentFrame();
driver.switchTo().defaultContent();

------------------
---> Hardcoding 
- Input information is coming from the code (java classes)
- To avoid hardcoding in test data we used faker library
-ex:
  userName.sendKeys("Tester");
  password.sendKeys("test");
  -Test data is it should NEVER be hardcoded
  
To access test data/ configuration data we need to have a separate file outside of the code

Properties file:
// 1. Create a path for connection to out file
String path = "Configuration.properties";

        //2. We will create Properties object

        Properties properties = new Properties();

        //3. Open the file using FileInputStream

        FileInputStream file = new FileInputStream(path);

        //4. Load the properties to file into the properties object
        properties.load(file);

        //5. Read the values from the file using a method getProperty()

Driver Utility
- 1)It's easier to have code which we are using often inside of utility, so we do not need to retype
every time same code 
  
  -2) We always want to use same driver instance for our test


option+cmd+L

Headless browser - it's browser without GUI (Graphical user interface)
CLI - stand for command line interface



===========================================
08.21.21

What is a TestNG?
 - is an open source tool, allows us to run test independently 
 - is a UNIT test framework

@ Annotations
 ---> @Test --- run the test itself (method)
 ---> @BeforeClass --- run before everything inside of that class
 ---> AfterClass --- run after everything inside of that class
 ---> BeforeMethod --- run before every @Test annotations
 ---> AfterMethod --- run after every @Test annotations
-------
@Ignore
This will skip the test
or we can just comment the test //
-------------------
 Priority - @Test (priority = 1) (priority = -3) (priority = 0)
 Dependency - dependsOnMethods = "nameofanothermethod")
 Without any priority it will run in alphabetical order
-----------------------
 Assertions
  -AssertTrue
  -AssertFalse
 -->
isDisplayed
isSelected
isEnabled()
contains because will return a boolean value

  -AssertEquals (actual value, expected value,error message);

=============
 Alerts
-------
We know 2 types of alerts:
 -->HTML ALert
We locate this as a regular weblement and click or any actions on that alerts
 -->JavaScript Alerts
   -- Warning -- this a warning message before any action will be performed (we can only accept)
   -- Confimation - this pop up we can confirm or decline
   -- Prompt - this allows us to accept, decline, also to any message inputs

To handle alerts we create an object from alert class
Alert alert  = driver.switchTo().alert()
This a selenium library 
--------
iFrame
What is an iframe?
this is a HTML inside of another html (inner HMTL)
How we can handle iframe?
-using switTo().frame(0) //index
-using switTo().frame(webelement)
-using switTo().frame(idValue)

To move back to "main" HTML
--swithTo().parentFrame()
--swithTo().defaultFrame()

--------
Windows handle
getWindowsHandle() --- an unique value of our tab/windows also return value of the current tab of where is driver
getWindowsHandles() --- a set of value
---------------

Assertions
Assertions comes from Assert class and also we can call them hard assertions
Hard assertions will stop execution of the test
----
Soft Assertions
- this assertion will not stop the execution of the test
- it will record the result at the end of test 
- this methods are not static, so we need to create an object to use the method from that class

EX:
@Test
public void softAssertions() {
System.out.println("Test for soft assert is running");
softAssert = new SoftAssert();
softAssert.assertEquals(3,5,"This soft assert failed");
System.out.println("Test one is running");
softAssert.assertTrue(false);
System.out.println("Test for assert true");
}

    @AfterMethod
    public void tearDown(){
        softAssert.assertAll();
    }
In order to get the result from soft assertion we need to use assertAll();
We can combine soft and hard assertions, but be aware hard will stop the the line if the assertions fail

When we should we hard assertions and soft assertions?
Soft can be used for (ex. typos) something not super important in a whole flow of the test
if this assertions will fail it will not be a big problem

=============
POM 
Page object model design
POM - is NOT a framework, is a design pattern
1- We need to create a constructor in the class and call the method 
---> we are using PageFactory class for this
And we initialize connection between current java class webdriver

--> Every time you create a "PAGE" class for each page of your application 
you have to pass PageFactory.initElements() inside of the constructor.
--> Then we have to use @FindBy to locate WebElements
--> What comes with Page Object Model / What are the advantages of the Page Object Model (POM)
--> re-usability
--> easy to maintain
--> easy to manage/edit : if there are any small changes like locator being different 
we will know exactly which class to go and fix the issue

src
-->test
------->java
---------->pages
---------->tests
---------->Util
------->Config
------->pom.xml

What is POM? (Page Object Model Design)
--> We create separate pages for the WebElements, we keep webElements separate by pages
--> Creating a object from that page we can use any methods inside of our Page.(class with webelemetns)
=====================
08.24

SYNCHRONIZATION:
- Definition: Multiple things moving, operating at the same time.
- In our case, we are synchronizing our WebDriver and browser.
- Since our WebDriver goes faster than the browser, we need to apply different waits at different points in our program.
- If the browser and WebDriver is not synchronized, we will get different types of exceptions depending on situation.
  Such as: NoSuchElementException, ElementNotInteractableException etc..

What can we do to synchronize our code?
     1- Thread.sleep()
Understanding Thread.sleep();
        --> this method has nothing to do with webdriver, browser, or selenium.
        --> Thread.sleep() method comes straight from Java.
        --> Thread.sleep() is basically like a pause button for our program flow.
        --> It will stop the whole program flow for given duration without looking for ANY CONDITION AT ALL.
        --> It is not considered a good practice to use this in our code.
        --> We should avoid using it UNLESS WE HAVE TO.
    2- Implicit Wait
        --> by default it is 0
        --> every time findElement or findElements methods are used, if the webdriver can't locate the WebElement, implicit wait will be triggered.    
    --> we wet set it only once, and it will apply to that whole driver session

    3- Explicit Wait 
        --> Explicit wait is applied using WebDriverWait classes object.
        --> WebDriverWait comes from Selenium.
        --> Using WebDriverWait, we can wait until:
        ->element is visible
        ->element is displayed
        ->element is invisible
..
SYNTAX:
WebDriverWait wait = new WebDriverWait(driver, seconds);
wait.until(ExpectedConditions.visibilityOf(webElement));
-> this will be only applied once at the line that it is called.

==========================================
ACTIONS:
        -> Actions class comes from Selenium
        -> Actions class allows us to do advanced mouse and keyboard actions.
examples:
    -clickAndHold
    -dragAndDrop
    -moveToElement
    -contextClick (right click)

Syntax:
//1- Create the object of Actions class, and pass the driver instance into constructor
   Actions actions = new Actions(driver);

//2- Use the actions instance to get the Actions class methods.
actions.moveToElement()

//3- After using the method we MUST use .perform() method at the end to make your driver do these actions.
-> if you do not use .perform() it will not perform the methods used.

ex#1 :actions.moveToElement().perform();
ex#2 :actions.moveToElement();
actions.perform();






















































      <select name="carlist">
			<option value="honda">Honda</option>
			<option value="nissan" selected="selected">Nissan</option>
			<option value="ford">Ford</option>
		</select>


2 - could be used different tags ex (div)

When we have dropdown created using select tag 
In selenium we used "Select" class

When is created by any other tag and not select, the WebElement is handled as a regular web element





























  

  

    
    

    








   


   
