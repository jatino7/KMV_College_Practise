package com.o7solutions.kmv_college_practise.Kotlin_Practise


data class Student (
    var name: String ?= null,
    var age: Int ?= 0,
    var id: String ?= null
)

fun main() {


    var listOfNumber = arrayListOf<Int>(1,3,5,6)

    var listOfStudent = arrayListOf<Student>()

    listOfStudent.add(Student("Jatin",22,"2102786"))
    listOfStudent.add(Student("Harcharan",22,"2102784"))


    for(i in listOfStudent) {
        println(i.name)
    }

//    listOfNumber.add(12)
//    listOfNumber.add(23)
//    listOfNumber.add(45)





    println(listOfNumber.size)


//    listOfNumber.clear()

    if(listOfNumber.isEmpty()) {
        println("List is empty")
    } else {
        println("List is not empty")
    }

    for(i in listOfNumber.reversed()) {
        println(i)
    }

//    var ans = sumOfNNaturalNumbers(5)
//    println(ans)

}


fun sumOfNNaturalNumbers(num: Int): Int {


//    Base Condition
    if(num == 1) {

        return num
    }

//  recursive expression
    return num + sumOfNNaturalNumbers(num - 1)



}