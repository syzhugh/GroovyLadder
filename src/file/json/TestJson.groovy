package file.json

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

void toJsonStr() {
    def json = JsonOutput.toJson(new JsonTempClass())
    println json
    println JsonOutput.prettyPrint(json)
}

void toObj() {
    def slurper = new JsonSlurper()
    def object = slurper.parseText(JsonOutput.toJson(new JsonTempClass()))
    def temp = (JsonTempClass) object
    println temp.list
}
