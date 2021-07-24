#!/bin/bash

./mvnw package
sudo docker build -t move-items .
sudo docker run -it --rm \
	-v "/home/consiste/thorsysMigra/":"/home/consiste/thorsysMigra/" \
	move-items --name move-items-container 
