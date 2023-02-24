@echo on
set MAVEN_HOME= C:\Development\maven\apache-maven-3.8.6
set JAVA_HOME = C:\Users\Alex\.jdks\openjdk-18.0.1.1
set PATH=%PATH%;%MAVEN_HOME%\bin;
set PATH=%PATH%;%JAVA_HOME%\bin;
rem call mvn clean install
rem call mvn clean install
docker compose down
rem docker image rm demo
rem docker image build -t demo:latest .
docker compose up -d