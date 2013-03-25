@echo off

set DIRPATH=%~dp0

call javac %DIRPATH%Player.java

call java Player

pause