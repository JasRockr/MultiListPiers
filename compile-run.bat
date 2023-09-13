@echo off

@REM Set encoding to UTF-8
chcp 65001 > nul

echo Compilación en curso...
javac -encoding UTF-8 Main.java

if errorlevel 1 (
    echo Ha ocurrido un error durante la compilación.
    pause
    exit /b 1
)

echo El programa se ha compilado correctamente.

echo Ejecución del programa en curso...
java -Dfile.encoding=UTF-8 Main

if errorlevel 1 (
    echo Ha ocurrido un error durante la ejecución.
    pause
    exit /b 1
)

echo Se ha completado la ejecución correctamente.
:: pause
timeout 5