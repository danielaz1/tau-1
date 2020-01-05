*** Settings ***
Documentation     A test suite with a single test for valid login and logout.
...
...               This test has a workflow that is created using keywords in
...               the imported resource file.
Resource          resource.robot

*** Test Cases ***
Valid Login and Logout
    Open Browser To Login Page
    Input Username    test999888@test.pl
    Input Password    password123
    Submit Credentials
    Welcome Page Should Be Open
    Logout Action
    Logout Page Should Be Open
    [Teardown]    Close Browser
