//: Playground - noun: a place where people can play

import UIKit

func average(myArray: [Float]) -> Float
{
    var result:Float = 0
    for val in myArray
    {
        result += val
    }
    result = result / Float(myArray.count)
    return result
}

let values:[Float] = [1.5,1.2,3,7,1,2]
let result = average(myArray: values)






class Person {
    var firstname: String
    var lastname: String
    let birthday: Date
    
    init(firstname: String, lastname: String, birthday: Date) {
        self.firstname = firstname
        self.lastname = lastname
        self.birthday = birthday
    }
    
    func sayHello() {
        print("Hello I'm \(firstname)")
    }
    
    
}


let now = Date()
let person = Person(firstname: "Florian", lastname: "ALONSO", birthday: now)
person.sayHello()


