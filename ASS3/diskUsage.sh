#!/bin/bash

hostname="pratik-devadhe-HP-Laptop-15-fc0xxx"
partition="/home"
treshold=1

Usage=$(df -h "$partition" | awk 'NR==2 {gsub("%",""); print $5}')

echo "$Usage"
