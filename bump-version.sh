#!/bin/bash

TRAVIS_COMMIT_MESSAGE="[MAJOR] Test message"

if [[ $TRAVIS_COMMIT_MESSAGE == "[MAJOR]"* ]]; then
  newVersion="\${parsedVersion.nextMajorVersion}.0.0"
elif [[ $TRAVIS_COMMIT_MESSAGE == "[MINOR]"* ]]; then
  newVersion="\${parsedVersion.majorVersion}.\${parsedVersion.nextMinorVersion}.0"
elif [[ $TRAVIS_COMMIT_MESSAGE == "[FIX]"* ]]; then
  newVersion="\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.nextIncrementalVersion}"
else
  exit 1
fi

./mvnw \
  versions:set -DnewVersion="$project_version"

./mvnw \
  build-helper:parse-version \
  versions:set -DnewVersion="$newVersion"
