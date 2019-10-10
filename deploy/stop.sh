#!/usr/bin/env bash
# Script to stop the application
PID_PATH="/home/ubuntu/bad-api/application.pid"
if [ ! -f "$PID_PATH" ]; then
   echo "STOP - Process Id FilePath($PID_PATH) Not found with application.pid : using grep  "
   sudo kill $(ps aux | grep bad-api | grep -v 'grep' | awk '{print $2}')
else
pid=`cat $PID_PATH`
       echo "STOP - Stopping app wih pid $pid"
       sudo kill $pid;
       echo "STOP - Stopped app with PID:$pid..."
       sleep 10
fi
