#!/bin/sh

#
# Script for running JBSC
#

PROJECT_DIR=.

cd $PROJECT_DIR

mvn clean

mvn package
java -jar target/JavaBytecodeStaticChecker-1.0-SNAPSHOT.jar -cp target/lib/

