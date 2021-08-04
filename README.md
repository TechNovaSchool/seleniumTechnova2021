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

NoSuchElementException it happens when driver was not able to find webElement or slow internet
  

  
  
