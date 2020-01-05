*** Settings ***
Documentation     A resource file with reusable keywords and variables.
...
...               The system specific keywords created here form our own
...               domain specific language. They utilize keywords provided
...               by the imported SeleniumLibrary.
Library           SeleniumLibrary

*** Variables ***
${BROWSER}          Firefox
${DELAY}            0
${VALID USER}       test999888@test.pl
${VALID PASSWORD}   password123
${LOGIN URL}      http://automationpractice.com/index.php?controller=authentication
${WELCOME URL}    http://automationpractice.com/index.php?controller=my-account 
${ERROR_URL}      http://automationpractice.com/index.php?controller=authentication
${LOGOUT PAGE}    http://automationpractice.com/index.php?controller=authentication&back=my-account
*** Keywords ***
Open Browser To Login Page
    Open Browser    ${LOGIN URL}    ${BROWSER}
    Maximize Browser Window
    Set Selenium Speed    ${DELAY}
    Login Page Should Be Open

Login Page Should Be Open
    Title Should Be    Login - My Store 

Go To Login Page
    Go To    ${LOGIN URL}
    Login Page Should Be Open

Input Username
    [Arguments]    ${username}
    Input Text    email    ${username}

Input Password
    [Arguments]    ${password}
    Input Text    passwd    ${password}

Submit Credentials
    Click Button    SubmitLogin

Welcome Page Should Be Open
    Location Should Be    ${WELCOME URL}
    Title Should Be    My account - My Store

Logout Action
    Click Link    http://automationpractice.com/index.php?mylogout=

Logout Page Should Be Open
    Location Should Be    ${LOGOUT PAGE}
    Title Should Be    Login - My Store