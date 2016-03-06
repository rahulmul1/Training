@Echo off
cd C:\Users\rahaggar\DevTools\TrainingProject\myproject
cmd /C mvn clean install -Dmaven.test.skip=true -PautoInstallPackage
