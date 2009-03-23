#!/bin/bash
mkdir ../bin/
javac -d ../bin *.java
javac -d ../bin .*/*.java
javac -d ../bin cmd/*.java
