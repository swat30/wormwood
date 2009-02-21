#!/bin/bash
mkdir bin
find ./*/*.java -exec javac -d bin {} \;
find *.java -exec javac -d bin {} \;
