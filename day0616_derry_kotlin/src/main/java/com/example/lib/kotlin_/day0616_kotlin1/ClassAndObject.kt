package com.example.lib.kotlin_.day0616_kotlin1

class ClassAndObject {

    constructor(id: Int) {

    }

    //次构造
    constructor(id: Int, name: String) : this(id) {

    }

    //次构造
    constructor(id: Int, sex: Char) : this(id) {

    }

    //次构造
    constructor() : this(33) {

    }

}

fun main() {

}