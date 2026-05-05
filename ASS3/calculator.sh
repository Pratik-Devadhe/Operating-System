#!/bin/bash

echo "Enter the first number : "
read a

echo "Enter the Second number : "
read b

echo "Enter the Operation : (+ - * / )"
read op

case $op in 
+)
result=$(($a + $b))
echo "Result : $result";;

-)
result=$(($a - $b))
echo "Result : $result";;

\*)
result=$(($a * $b))
echo "Result : $result";;

/)
result=$(($a / $b))
echo "Result : $result";;

*)
echo " Invalid operation";;

esac
