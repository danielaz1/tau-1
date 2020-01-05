*** Settings ***
Documentation     Test shapes.
...
...               This test has a workflow that is created using keywords in
...               the imported resource file.
Resource          resource.robot


*** Test Cases ***
Check Triangles     
    Run Shapes App And Test Triangle    1   2   3     nierozpoznano
    Run Shapes App And Test Triangle    1   1   1     trojkat rownoboczny
    Run Shapes App And Test Triangle    2   1   2     trojkat rownoramienny
    Run Shapes App And Test Triangle    5   4   3     trojkat roznoramienny
Check Quadrangles
    Run Shapes App And Test Quadrangle    1   2   3   10     nierozpoznano
    Run Shapes App And Test Quadrangle    1   1   1   1      kwadrat
    Run Shapes App And Test Quadrangle    2   1   2   1      prostokat
    Run Shapes App And Test Quadrangle    5   4   3   8      czworobok
