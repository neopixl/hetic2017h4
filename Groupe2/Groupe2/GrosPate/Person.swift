//
//  Person.swift
//  Groupe2
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import Foundation


class Animal {
    let name = ""
    
    private func testPrivate() {
        print("testPrivate")
    }
    
    fileprivate func testFilePrivate() {
        print("testFilePrivate")
    }
    
    internal func testInternal() {
        print("testInternal")
    }
    
    func testInternal2() {
        print("testInternal")
    }
    
    public func testPublic() {
        print("testPublic")
    }
    
    open func testOpen() {
        print("testOpen")
    }
}

class Pokemon : Animal {
    override fileprivate func testFilePrivate() {
        print("testFilePrivate Pokemon")
    }
}



enum Gender {
    case male
    case female
}

class Person {
    var firstname = ""
    var lastname = ""
    var gender = Gender.male
    var age = 30
    
    
    func testLet() {
        // firstname = "Florian" --> Ne fonctionne pas car 'let'
        lastname = "ALONSO"
    }
    
    func testOptionnel() {
        var string = "Salut"
        var index = 0
        
        //string = nil --> Ne fonctionne pas car pas optionnel
        //index = nil --> Ne fonctionne pas car pas optionnel
        
        let stringOptionnel: String? = nil
        var indexOptionnel: Int? = 0
        indexOptionnel = nil
        
        
        if indexOptionnel != nil {
            //indexOptionnel = indexOptionnel + 1 --> Ne marche pas car la valeur peu etre nulle
        }
        
        // 'if var' ou 'if let'
        if var maValue = indexOptionnel {
            maValue = maValue + 1
            indexOptionnel = maValue
            print("C'est Good")
        } else {
            print("C'est NIL")
        }
    }
    
    func fill_SolutionOne(lastname: String?, firstname: String?) {
        if let vraiLastname = lastname {
            self.lastname = vraiLastname
        }
        
        
        if let vraiFirstname = firstname {
            self.firstname = vraiFirstname
        }
    }
    
    func fill_SolutionTwo(lastname: String?, firstname: String?) {
        if let vraiLastname = lastname,
            let vraiFirstname = firstname {
            
            self.lastname = vraiLastname
            self.firstname = vraiFirstname
        }
    }
    
    func fill_SolutionThree(lastname: String?, firstname: String?) {
        guard let vraiLastname = lastname,
            let vraiFirstname = firstname else {
                
            return
        }
        
        self.lastname = vraiLastname
        self.firstname = vraiFirstname
    }
    
    func testArray() {
        var arrayStrings: [String] = [] // Ici j'initialise un tableau vide
        var arrayStrings2 = ["salut", "hey", "lol"] // Ici j'initialise un tableau plein
        
        arrayStrings.append("ma nouvelle string")
        arrayStrings2.append("ma nouvelle string 2")
        
        
        var arrayIntInArrayInt: [[Int]] = []
        var arrayIntInArrayInt2 = [[10, 10, 10], [1, 1, 1,], [6, 6, 6]]
        
        
        arrayIntInArrayInt.append([3,3])
        arrayIntInArrayInt2.append([3,3])
        
        arrayStrings.reverse()
        
    }
    
    
    func testDico() {
        var dicoStrings: [String: String] = [:] // Ici j'initialise un dico vide
        
        var dicoStrings2 = [
            "Hey": "yo",
            "LOL": "ROFLMAO",
            "Youpe": "hey"
        ] // Ici j'initialise un dico plein
        
        
        dicoStrings["New"] = "value"
        dicoStrings2["New"] = "value"
    }
    
    
    func testLoop() {
        
        print("Boucle de 0 a 5 compris")
        for i in 0...5 {
            print("\(i)")
        }
        
        print("Boucle de 0 a 5 non compris")
        for i in 0..<5 {
            print("\(i)")
        }
        
        
        
        let intArray = [1,2,3,4,5,6,7]
        // Option 1
        for i in 0 ..< intArray.count {
            let value = intArray[i]
            print("\(value)")
        }
        
        // Option 2
        for value in intArray {
            print("\(value)")
        }
    }
    
    
    func testSwitchCase() {
        
        let monInt = 2
        switch monInt {
        case 1:
            print("1")
        case 2:
            print("OUI")
        default:
            print("NON")
        }
        
        
        let monString = "a"
        switch monString {
        case "a", "b":
            print("OUI")
        default:
            print("NON")
        }
        
        
        switch self.gender {
        case .male:
            print("MALE")
        case .female:
            print("FEMALE")
        }
        
    }
    
    func calculateYears() -> Int {
        let now = Date()
        let calendar = Calendar.current
        let yearsComponenent = calendar.dateComponents([.year], from: now)
        let years = yearsComponenent.year ?? 0
        
        return years - self.age
    }
    
    
    
    func testOther () {
        
        var monIntList: [Int]? = nil
        
        var monIntListAvecOptionel: [Int?] = [1,2, nil, 4]
        
        var awesome: [Int?]? = [1,2,3,4,nil,123,nil]
        awesome = nil
        
        
        var offDoom: [[[Int?]]?] = []
        
    }
    
    
    func testOther2() {
        var delegate: ModalViewControllerDelegate? = nil
        let controller = ModalViewController()
        
        if let vraiDelegate = delegate {
            vraiDelegate.youShouldCloseMe(modal: controller)
        }
        
        delegate?.youShouldCloseMe(modal: controller)
    }
    
    
    func testOptionExlamation() {
        var optInt: Int? = 3
        optInt = nil
        
        let result: Int! = optInt?.distance(to: 3) // ---> zero
        let _ = result.advanced(by: 1)
        
        
        var optIntExlamation: Int! = 3
        let _ = optIntExlamation.advanced(by: 3)
        
        optIntExlamation = nil
        let _ = optIntExlamation.advanced(by: 3)
        
    }
    
    
    
    
    
    
    
}
