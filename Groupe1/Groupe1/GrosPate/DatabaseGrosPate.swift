//
//  DatabaseGrosPate.swift
//  Groupe1
//
//  Created by Florian ALONSO on 12/11/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import Foundation
import UIKit
import CoreData

class DatabaseGrosPate {
    
    
    func addInDatabase() {
        let appDelegate = UIApplication.shared as! AppDelegate
        let persistentContainer = appDelegate.persistentContainer!
        let databaseContext = persistentContainer.viewContext
        
        
        let etudian = Etudian(context: databaseContext)
        etudian.name = "Florian"
        etudian.dateNaissance = Date() // This is today
        
        
        do {
            var monCodeAvant = 0
            
            try databaseContext.save()
            
            monCodeAvant += 1
        } catch let error {
            print("\(error)")
        }
    }
    
    
    func getObjectInDatabase() {
        let appDelegate = UIApplication.shared as! AppDelegate
        let persistentContainer = appDelegate.persistentContainer!
        let databaseContext = persistentContainer.viewContext
        
        
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Cour")
        
        request.predicate = NSPredicate(format: "niveau > 3") // Ceci est le filtre de ma request
        
        let sortDescriptor = NSSortDescriptor(key: "nom", ascending: true) // Ceci est le trie
        request.sortDescriptors = [sortDescriptor] // Associe le trie avec la request
        
        do {
            
            let courList = try? databaseContext.fetch(request)
            print("\(courList?.count)")
            
        }
    }
    
    func deleteObjectInDatabase() {
        let appDelegate = UIApplication.shared as! AppDelegate
        let persistentContainer = appDelegate.persistentContainer!
        let databaseContext = persistentContainer.viewContext
        
        
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Cour")
        
        let monNiveau = 4
        request.predicate = NSPredicate(format: "niveau > %d", monNiveau) // Ceci est le filtre de ma request
        
        do {
            let courListMayBeNull = try? databaseContext.fetch(request)
            
            if let courList = courListMayBeNull as? [Cour] {
                // Ici on as verifier que des cours sont bien présent
                
                
                for cour in courList {
                    
                    databaseContext.delete(cour)
                    
                }
                
                try? databaseContext.save()
                
                
            } else {
                print("Il n'y a pas de cours")
            }
            
        }
        
    }
    
    
    func updateInDatabase() {
        let appDelegate = UIApplication.shared as! AppDelegate
        let persistentContainer = appDelegate.persistentContainer!
        let databaseContext = persistentContainer.viewContext
        
        
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Cour")
        request.predicate = NSPredicate(format: "nom == %@", "Kickstarting-iOS") // Ceci est le filtre de ma request
        
        
        do {
            let courListMayBeNil = try? databaseContext.fetch(request)
            
            if let courList = courListMayBeNil as? [Cour] {
                
                let monPremierCour = courList[0]
                monPremierCour.niveau = 5
                
                try? databaseContext.save()
                
            }
        }
    }
    
    
    func exempleDutilisatioNDeThread() {
        DispatchQueue.global().async {
            // This code will run on a other thread thant the main one.
            
            
            
            let appDelegate = UIApplication.shared as! AppDelegate
            let persistentContainer = appDelegate.persistentContainer!
            let databaseContext = persistentContainer.viewContext
            
            
            let etudian = Etudian(context: databaseContext)
            etudian.name = "Florian"
            etudian.dateNaissance = Date() // This is today
            
            
            do {
                var monCodeAvant = 0
                
                try databaseContext.save()
                
                monCodeAvant += 1
            } catch let error {
                print("\(error)")
            }
            
            
            DispatchQueue.main.async {
                // This code will run on the main thread.
                
                
                let button = UIButton()
                button.isEnabled = true
                
            }
            
            
        }
    }
    
    
}
