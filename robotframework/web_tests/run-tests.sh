#!/bin/bash

export PATH=$PATH:../

python -m robot valid_login.robot invalid_login.robot sign_in_and_out.robot
