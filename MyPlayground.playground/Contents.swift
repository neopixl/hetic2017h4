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










class Product {
    var title = "Mon produit"
    var price = 10
    
    init() {
        
    }
}

class CheckoutManger {
    var productList = [Product]()
    
    func add(product: Product) {
        productList.append(product)
    }
    
    func getSum() -> Int {
        return productList.reduce(0, { (previousResult, product) -> Int in
            return previousResult + product.price
        })
    }
    
}

class CheckoutMangerSingle {
    
    static let shared: CheckoutMangerSingle = {
        return CheckoutMangerSingle()
    }()
    
    private init() {
        
    }
    
    var productList = [Product]()
    
    func add(product: Product) {
        productList.append(product)
    }
    
    func getSum() -> Int {
        return productList.reduce(0, { (previousResult, product) -> Int in
            return previousResult + product.price
        })
    }
    
}




let checkoutManager = CheckoutManger()
checkoutManager.add(product: Product())
checkoutManager.add(product: Product())
checkoutManager.add(product: Product())
checkoutManager.getSum()



































let checkoutMangerTwo = CheckoutManger()
checkoutMangerTwo.add(product: Product())
checkoutMangerTwo.add(product: Product())
checkoutMangerTwo.getSum()









let checkoutMangerSingle = CheckoutMangerSingle.shared
checkoutMangerSingle.add(product: Product())
checkoutMangerSingle.add(product: Product())
checkoutMangerSingle.add(product: Product())
checkoutMangerSingle.getSum()




























let checkoutMangerSingleTwo = CheckoutMangerSingle.shared
checkoutMangerSingleTwo.add(product: Product())
checkoutMangerSingleTwo.add(product: Product())

checkoutMangerSingleTwo.getSum()





















