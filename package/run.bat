@echo off
start java -jar login-0.0.1-SNAPSHOT.jar
start cmd /k "cd dist && http-server"

