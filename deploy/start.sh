#!/usr/bin/env bash
echo 'START - Setting exe rights to bad-api.jar'
sudo mv /home/ubuntu/bad-api/target/bad-api.jar /home/ubuntu/bad-api/bad-api.jar
sudo rm -rf /home/ubuntu/bad-api/target/
sudo chmod 777 /home/ubuntu/bad-api/bad-api.jar
echo 'START - Running application in background '
sudo nohup java -jar /home/ubuntu/bad-api/bad-api.jar > /dev/null 2>&1 &