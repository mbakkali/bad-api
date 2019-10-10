#!/usr/bin/env bash
cd /home/ubuntu
echo "BEFORE-INSTALL - Deleting bad-api repository ..."
sudo rm -rf bad-api
echo "BEFORE-INSTALL - Deleted bad-api repository with success"
echo "BEFORE-INSTALL - Deleting codedeploy *-cleanup file ..."
sudo rm -rf /opt/codedeploy-agent/deployment-root/deployment-instructions/*-cleanup
echo "BEFORE-INSTALL - Deleted codedeploy *-cleanup file with success"