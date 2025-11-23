#!/bin/bash

dc_infra="docker-compose.yml"
dc_app="docker-compose-app.yml"

function buildapi() {
    cd bookmark-api || exit
    ./mvnw clean package -DskipTests
    cd ..
}

function start_infra() {
    echo "Starting infra docker containers..."
    docker-compose -f "${dc_infra}" up -d
}

function stop_infra() {
    echo "Stopping infra docker containers..."
    docker-compose -f "${dc_infra}" stop
}

function start() {
    echo "Starting all docker containers..."
    docker-compose -f "${dc_infra}" -f "${dc_app}" up -d
}

function stop() {
    echo "Stopping all docker containers..."
    docker-compose -f "${dc_infra}" -f "${dc_app}" stop
}

function restart() {
    stop
    sleep 3
    start
}

# Default action
action="start"

# Override action if user provided one
if [ $# -gt 0 ]; then
    action="$1"
fi

# Execute the function
eval "$action"
