#!/usr/bin/env groovy

import org.apache.commons.lang.StringUtils

def call(int occurence) {
    def logs = currentBuild.rawBuild.getLog(1000000).join('\n')
    int count = StringUtils.countMatches(logs, 'WARNING')
    if (count > occurence) {
        currentBuild.result = 'UNSTABLE'
    }
    println "##### WARNING(s) = " + toString(count) + " #####"
}