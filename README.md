Practicing    knowledge of Selenium with TestNG using clothing web shop. 

This is a demo shop for testing automation scripts.




   [![Watch the video](https://img.youtube.com/vi/1HJ_Dg9aY8U/hqdefault.jpg)](https://www.youtube.com/watch?v=1HJ_Dg9aY8U)


### Test Plan for Clothing Shop Website

### 1. Test Plan Overview

• Project Name: Magento Shop Website

• Test Objective: To verify that the clothing shop website is functioning correctly in all aspects such as navigation, user interaction, shopping cart, checkout, and payment processing.

• Testing Tool: Selenium WebDriver, Java, TestNG.

• Test Type: Functional, UI, Usability Testing.

• Test Environment: Latest version of Chrome.

### 2. Scope of Testing
   
• In-Scope:

Functional testing of the website's main features: navigation, login, product browsing, search functionality, shopping cart, checkout process.

Usability testing for a smooth shopping experience.

• Out-of-Scope:

Third-party integrations outside the website (e.g., payment gateway failures).

Backend database validation.

### 3. Test Strategy

• Test Approach: Manual test automation with Selenium WebDriver, Java and TestNG applying the Page Object Model for maintainable test scripts.

• Testing Levels:

Unit Testing: Testing individual components like search functionality.

Integration Testing: Ensuring multiple components work together (e.g., adding items to the cart and proceeding to checkout).

End-to-End Testing: Verifying the full user experience from browsing to completing a purchase.

### 4. Test Cases
   
Here is a list of test cases for the website:

##### Test Case 1: Verify User Login with Empty User Email Field (or Empty Password Field)

Objective: Verify that users can not log in when user email field or password field is empty.

• Preconditions: User is on a home page.

• Test Steps:

 1. Enter valid email in the user email field (or leave empty).

 2. Enter valid password in the password field (or leave empty).

 3. Click on the "Sign In" button.

 4. Verify that empty field shows error message and log in is not successful.
    
• Expected Result: The user should not be logged in.

##### Test Case 2: Verify User Login with Invalid Credentials

Objective: Verify that users can not log in with invalid credentials.

• Preconditions: User is on a login page.

• Test Steps:

 1. Enter invalid email in the user email field.

 2. Enter incorrect password in the password field.

 3. Click on the "Sign In" button.

 4. Verify that the user is informed with the error message, that log in was not successful.
    
• Expected Result: The user should not be logged in.

##### Test Case 3: Verify User Login with Valid Credentials

Objective: Verify that users can successfully log in with valid credentials.

• Preconditions: User is on a login page.

• Test Steps:

 1. Enter a valid email in the user email field.

 2. Enter the correct password in the password field.

 3. Click on the "Sign In" button.

 4. Verify that the user is redirected to the homepage or dashboard.
    
• Expected Result: The user should be successfully logged in and redirected to the homepage or dashboard.

##### Test Case 4: Verify Product Details Page

• Objective: Verify that the product detail page shows correct information.

• Preconditions: User is on a product home page.

• Test Steps:

   1.	Click on a product.

   2.	Verify that the product detail page opens with the correct information (product name, size options, price and color).
      
• Expected Result: All information about the product should be displayed correctly.

##### Test Case 5: Verify Product Search

• Objective: Verify that the search functionality works correctly.

• Preconditions: User is on the homepage.

• Test Steps:

   1.	Enter a product name ("watch", "top", "jacket") into the search bar.

   2.	Click the "Search" button.

   3.	Verify that the search results display relevant products.
      
• Expected Result: Relevant products matching the search term should be displayed.

##### Test Case 6: Verify Navigation Menu (will be tested and added later)

• Objective: Verify that the main navigation menu is displayed and the links navigate to the correct pages.

• Preconditions: User is on the homepage.

• Test Steps:

   1.	Open the homepage.

   2.	Click on each menu item ("What's new", "Sign In", "Create an Account", "Search").

   3.	Verify that each link redirects to the correct page.
      
• Expected Result: All links should redirect to the corresponding pages without errors.
