#! /bin/bash
echo starting h2 config server 
echo url is jdbc:h2:file:~/.h2/bantrip\;AUTO_SERVER=TRUE\;DB_CLOSE_DELAY=-1\;DB_CLOSE_ON_EXIT=FALSE

cd h2

mvn exec:java

cd ..
