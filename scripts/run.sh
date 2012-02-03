#!/bin/sh

#
# Script for running JBSC
#

PROJECT_DIR=/home/michal/Nauka/magisterka/jbsc/JavaBytecodeStaticChecker/

cd $PROJECT_DIR

mvn clean

mvn assembly:assembly
cd target/
java -jar JavaBytecodeStaticChecker-1.0-SNAPSHOT-jar-with-dependencies.jar

