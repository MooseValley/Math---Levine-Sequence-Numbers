echo off
cls

:STARTCOMPILE
echo Create the Manifest file:
echo Main-Class: LevineSequenceNumbers >MANIFEST.MF
echo .

REM "javac.exe" "*.java"
"C:\Program Files\AdoptOpenJDK\jdk-8.0.275.1-hotspot\bin\javac.exe" *.java

echo .
echo Build the JAR file:
REM "jar.exe" cfm "LevineSequenceNumbers.jar" MANIFEST.MF *.class
"C:\Program Files\AdoptOpenJDK\jdk-8.0.275.1-hotspot\bin\jar.exe" cfm "LevineSequenceNumbers.jar" MANIFEST.MF *.class

REM
del /q *.class

:END
echo .
echo Finished!
pause