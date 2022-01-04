#!/bin/bash
# created at 2022-01-03 by Tony ZHU
#

# source profile 
source ~/.bash_profile

# run with diff args 
case $1 in
    start)
        echo "Starting application "$0" at $(date +'%F %T')"
        echo "----------------------------------------------"
        echo "  "
        java -Dfile.encoding=UTF-8 -jar ../lib/kafka2mysql-1.0.jar --spring.config.location=../conf/application.properties &

        if [ $? -ne 0 ]; then 
            echo "application "$0" started successfully !"
        else 
            echo "application "$0" started failed with return code $? !"
        fi 
        ;;
    stop)
        ps -ef|grep lib/kafka2mysql-1.0 |grep -v grep |awk '{print $2}'  | sed -e "s/^/kill -9 /g" | sh -
        sleep 3
        echo "application "$0" stoppped successfully !"
        ;;
    restart)
        "$0" stop
        sleep 3
        "$0" start
        ;;
    status)  ps -ef|grep lib/kafka2mysql-1.0.jar*
        ;;
    *)
    echo "Example: lpservice.sh [start|stop|restart|status]" ;;
esac


# script end here ....
#