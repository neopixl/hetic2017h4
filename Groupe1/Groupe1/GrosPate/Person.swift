//
//  Person.swift
//  Groupe1
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import Foundation


enum Gender {
    case male
    case female
}


class Animaux {
    
    private func testPrivate() {
        // Priver dispo que dans cette classe
        print("testPrivate")
    }
    
    fileprivate func testFilePrivate() {
        // Priver dispo que dans cette classe
        // Et les sub classes
        print("testFilePrivate")
    }
    
    internal func testInternal() {
        // Public mais que a l'interieur de ce module
        print("testInternal")
    }
    
    public func testPublic() {
        // Public a tous le projets
        print("testInternal")
    }
    
    open func testOpen() {
        // Public a tous le projets
        // Et surcharge possible
        print("testInternal")
    }
}

class Pokemon : Animaux {
    override fileprivate func testFilePrivate() {
        print("testFilePrivate POKEMON")
    }
}



class Person {
    var firstname = ""
    var lastname: String
    var gender = Gender.male
    
    
    init(lastname: String) {
        self.lastname = lastname
    }
    
    
    func test() {
        var index = 0
        //index = nil ---> Ne fonctionne pas car pas optionnel
        
        var string = "Salut"
        //string = nil ---> Ne fonctionne pas car pas optionnel
        
        
        var stringOptionnel: String? = nil
        var indexOptionnel: Int? = nil
        indexOptionnel = 3
        
        
        if indexOptionnel != nil {
            //indexOptionnel = indexOptionnel + 1 --> Ne fonctionne pas car la valeur est toujours optionnelle
            print("Il n'est pas nil")
        }
        
        
        if var maValue = indexOptionnel {
            maValue += 1
            //maValue++ --> Le ++ ou -- est interdie en Swift
            indexOptionnel = maValue
            print("Il n'est pas nil")
        } else {
            print("Il est nil")
        }
    }
    
    func fillSolutionUn(lastname: String?, firstname: String?) {
        if let vraiLastname = lastname {
            self.lastname = vraiLastname
        }
        
        if let vraiFirstname = firstname {
            self.firstname = vraiFirstname
        }
    }
    
    func fillSolutionDeux(lastname: String?, firstname: String?) {
        if let vraiLastname = lastname,
            let vraiFirstname = firstname {
            self.lastname = vraiLastname
            self.firstname = vraiFirstname
        }
    }
    
    func fillSolutionTrois(lastname: String?, firstname: String?) {
        guard let vraiLastname = lastname,
            let vraiFirstname = firstname else {
            return
        }
        self.lastname = vraiLastname
        self.firstname = vraiFirstname
    }
    
    func testArray() {
        var arrayString: [String] = [] // Ici je créer un tableau vide
        
        print("\(arrayString.count)") // Ca vaut 0
        arrayString.append("Salut")
        arrayString[0] = "Hey"
        arrayString.remove(at: 0)
        arrayString.reverse()
        
        let personListOptinnel: [Person]? = [] // Ici tous mon tableau est option
        var personOptionList: [Person?] = [] // Ici les valeurs sont option
        personOptionList.append(nil)
        
        let preFillArrayString = ["Salut", "Hey"]
    }
    
    func testDico() {
        var dicoString = [
            "MaCles1": "Valuer1",
            "MaCles2": "Valuer2",
            "MaCles3": "Valuer3"
        ]
        
        let dicoStringEmpty: [String: String] = [:]
        
        dicoString["MaCles1"] = "newValue"
        dicoString["MaCles4"] = "Valuer4"
        dicoString.removeValue(forKey: "MaCles4")
    }
    
    func testLoop() {
        // Loop de 0 a 5 compris
        for i in 0...5 {
            print("\(i)")
        }
        
        // Loop de 0 a 5 non compris
        for i in 0..<5 {
            print("\(i)")
        }
        
        // Loop de 5 a 0 compris
        for i in (0...5).reversed() {
            print("\(i)")
        }
        
        
        
        let intArray = [1,2,3,4,5,6,7]
        for i in 0..<intArray.count {
            let value = intArray[i]
            print("\(value)")
        }
        
        for value in intArray {
            print("\(value)")
        }
    }
    
    func switchCase() {
        let value = 2
        switch value {
        case 0:
            print("NON")
        case 2:
            print("OUI")
        default:
            print("NON")
        }
        
        let char = "a"
        switch char {
        case "a":
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
    
}
