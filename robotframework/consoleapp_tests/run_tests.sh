#!/bin/bash

wget https://github.com/DawidFrost/TAU-12c-repozytorium/raw/master/RobotFramework/figury_moje/main.cpp
g++ -Wall -g -o shapes main.cpp 
chmod +x shapes

python -m robot test_shapes.robot
