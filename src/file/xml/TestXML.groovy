package file.xml

import groovy.xml.MarkupBuilder

/*
* xml
* */

def file = new File("./in.xml")
// result为最外层标签
result = new XmlSlurper().parseText(file.text)

/*
* 1. xml解析
* */

void testParseXml() {
    //取属性
    println result.food[0].@id
    //取childNode
    println result.food[0].name
}

/**
 * 1.1 遍历取值
 */

void testTravelsal() {
    def list = []
    result.food.each {
        list.add(it.type)
    }
    println list
}

/*
* 1.2 深度优先
* */

void testDepth() {
    println result.depthFirst().findAll {
        String str = it.calories.text()
        return str.isNumber() && str.toInteger() > 700
    }
    println result.'**'.findAll {
        String str = it.price.text()
        return str.isNumber() && str.toBigDecimal() > 6
    }
}

/*
* 1.3 广度优先
* */

void testBreadth() {
    println result.children().findAll {
        String str = it.calories.text()
        return str.isNumber() && str.toInteger() > 700
    }.collect {
        it.price
    }
    println result.'*'.findAll {
        String str = it.price.text()
        return str.isNumber() && str.toBigDecimal() > 6
    }.collect {
        it.calories
    }
}

/*
* 2. xml生成
* */

void testGenerateXml() {
    def writer = new FileWriter('./outLangs.xml')
    def markupBuilder = new MarkupBuilder(writer)
    markupBuilder.list(count: '3') {
        lang(name: 'java', feature: 'static')
        lang(name: 'groovy', feature: 'dynamic')
        lang(name: 'js', feature: 'dynamic')
    }
    writer.flush()
    writer.close()
}


class Basket {
    int count = 2
    def fruits = [
            new Fruit(type: 'apple', color: 'red'),
            new Fruit(type: 'banana', color: 'yellow'),
    ]
}

class Fruit {
    String type
    String color
}

void testGenerateXml2() {
    def writer = new FileWriter('./outFruits.xml')
    def markupBuilder = new MarkupBuilder(writer)

    def basket = new Basket()
    markupBuilder.basket(count: basket.count) {
        basket.fruits.each {
            fruit(type: it.type, color: it.color)
        }
    }

    writer.flush()
    writer.close()
}
