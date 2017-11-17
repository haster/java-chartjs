#!/bin/bash

set -e

function getVersion {
    eval mvn help:evaluate  -Dexpression=project.version 2> /dev/null | grep '^[0-9]\+\.'
}

function checkLocaleWijzigingen {
        echo -n "Controleren op lokale wijzigingen..."
        CHANGES=`git status --porcelain | wc -l`
        if [ $CHANGES -gt 0 ]
        then
                echo ""
                show_error "ERROR: Release kan niet gebouwd worden: er zijn nog lokale wijzigingen"
                echo -en "\033[0;31m"
                git status
                echo -en "\033[0m"
                exit 1
        fi
        echo " Geen lokale wijzigingen gevonden"
        echo ""
}

function show_error {
        echo -e "\033[0;31m$*\033[0m"
}


checkLocaleWijzigingen

CURRENT_SNAPSHOT_VERSION=$(getVersion)
#echo "Current version is: ${CURRENT_SNAPSHOT_VERSION}"
CURRENT_VERSION=`expr $CURRENT_SNAPSHOT_VERSION : '\(.*\)-SNAPSHOT'`

if [ "" == "$CURRENT_VERSION" ]
then
        show_error "ERROR: Huidige versie is geen SNAPSHOT versie: $CURRENT_SNAPSHOT_VERSION"
        exit 1
fi

export MAVEN_OPTS="-Xmx1024m -Xms512m"

echo "Release van $CURRENT_VERSION"

mvn release:prepare release:perform -Prelease -e -B -ff || {
        show_error "ERROR: Release build faalde!"
        exit 1
}

