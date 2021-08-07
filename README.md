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
6. Verify a message dispalyed “Bad email or password.”
  

  

    
    

    








   


   
