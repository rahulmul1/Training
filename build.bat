@Echo off
cd C:\Users\rahaggar\DevTools\TrainingProject\mytrainingproject
cmd /C mvn clean install -Dmaven.test.skip=true -PautoInstallPackage
