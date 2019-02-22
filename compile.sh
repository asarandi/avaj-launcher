#!/usr/bin/env bash
find . -iname "*.java" > sources.list
javac @sources.list
