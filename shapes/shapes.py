#!/usr/bin/env python3

import sys

def detect_triangle(a, b, c):

    if (a + b <= c) or (a + c <= b) or (b + c <= a): 
        return "nierozpoznano"
    else:
        if a == b == c:
            return "trojkat rownoboczny"
        elif a == b or a == c or b == c:
            return "trojkat rownoramienny"
        else:
            return "trojkat roznoramienny" 


def detect_quadrangle(a, b, c, d):
    if max(a, b, c, d) > (a + b + c + d - max(a, b, c, d)):
        return "nierozpoznano"
    elif a == b == c == d: 
        return "kwadrat" 
    elif a == b and c == d: 
        return "prostokat"
    elif a == d and c == b: 
        return "prostokat"          
    elif a == c and d == b: 
        return "prostokat"
    return "czworobok"


if __name__ == '__main__':

    args = [float(x) for x in sys.argv[1:]]

    if (len(args) == 3):
        print(detect_triangle(args[0], args[1], args[2]))
    elif (len(args) == 4):
        print(detect_quadrangle(args[0], args[1], args[2], args[3]))
    else:
        print('nierozpoznano')
