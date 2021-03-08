#!/bin/bash


#Program name: Baseball Diamond Runner
#Author: Quentin May
#Email: quentinemay@gmail.com, quentinemay@csu.fullerton.edu
#File name: run.sh

#Purpose: This program simulates a runner running at constant speed around a baseball diamond.
#Base test system: Linux system with Bash shell and openjdk-14-jdk

echo Remove old byte-code files if any exist
rm *.class

echo View list of source files
ls -l *.java

echo Compile main.java
javac main.java

echo Compile AppUI.java
javac AppUI.java

echo Compile Computations.java
javac Computations.java

echo Compile Quad.java
javac Quad.java

echo Execute the Baseball Diamond Runner
java main.java

echo End of execution.