# Steam_tests

Test Cases:<br/>
===================1=====================<br/>
Step 1: Navigate to main page	Main   
  Expected: page is open
  
Step 2:	Scroll and open Privacy Policy	
  Expected:
    Privacy Policy page is opened in new tab
    Switch language elements list displayed.
    Supported languages: English, Spanish, French, German, Italian, Russian, Japanese, Portuguese, Brazilian.
    
Step 3: Check Policy revision year
  Expected:
    Policy revision signed in the current year
    
 ===================2=====================
 
Step 1:	Navigate to main page	
  Expected: Main page is open
  
Step 2:	Open Community Market page (move pointer to COMMUNITY and then in dropdown click MARKET) 
  Expected: Community Market page is open 
  
Step 3:	Click 'Show advanced options' in the right menu
  Expected: 'SEARCH COMMUNITY MARKET' window is open
  
Step 4: Enter next parameters in the search form: 
  Games field - choose 'Dota 2'
  Hero dropdown - choose 'Lifestealer'
  Rarity column - choose checkbox 'Immortal'
  In Search field type 'golden'
  
Step 5:	Click on 'Search' button	
  Expected: 
    Filters 'Dota 2', 'Lifestealer', 'Immortal', 'golden' have appeared on the page.
    Top 5 results contain word 'Golden' in their names.

Step 6:	 Delete filters 'golden' and 'Dota 2' by clicking on cross sign	
  Expected: Both filters are removed
  
Step 7: Click on first item in the list
  Expected:
    Item's page is open
    Item's data (game, hero, rarity, search keyword) are equals to the ones set in step #4
    Item's name equals to its' name from previous page




