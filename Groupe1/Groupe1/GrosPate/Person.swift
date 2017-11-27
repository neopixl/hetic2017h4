//
//  Person.swift
//  Groupe1
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import Foundation

class Person {
    var firstname = ""
    var lastname: String
    
    
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
}
