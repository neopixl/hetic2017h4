//
//  DatabaseGrosPate.swift
//  Groupe2
//
//  Created by Florian ALONSO on 12/11/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import Foundation
import UIKit
import CoreData

class DatabaseGrosPate {
 
    func addObjectInDatabase() {
        let appDelegate = UIApplication.shared as! AppDelegate
        let persitentContainer = appDelegate.persistentContainer!
        let databaseContext = persitentContainer.viewContext
        
        
        let etudiant = Etudiant(context: databaseContext)
        etudiant.niveau = 4
        etudiant.nom = "Florian"
        etudiant.dateNaissance = Date()
        
        
        do {
            var monCodeDeTest = 0 // Code d'exemple pour le do catch
            
            try databaseContext.save()
            
            monCodeDeTest += 1 // Code d'exemple pour le do catch
            
        } catch let error {
            print("\(error)")
        }
    }
    
    func getObjectInDatabase() {
        let appDelegate = UIApplication.shared as! AppDelegate
        let databaseContext = appDelegate.persistentContainer.viewContext
        
        
        // Crée une request vide
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Cour")
        
        // Filtre la request
        request.predicate = NSPredicate(format: "niveau > 2")
        
        // Trie la request
        let sortDescriptor = NSSortDescriptor(key: "nom", ascending: true)
        request.sortDescriptors = [sortDescriptor]
        
        
        do {
            let courListMayBeNull = try? databaseContext.fetch(request)
            
            print("\(courListMayBeNull?.count)")
        }
    }
    
    func deleteObjectInDatabase() {
        let appDelegate = UIApplication.shared as! AppDelegate
        let databaseContext = appDelegate.persistentContainer.viewContext
        
        
        // Crée une request vide
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Cour")
        // Filtre la request
        request.predicate = NSPredicate(format: "niveau == 1")
        
        do {
            let courListMayBeNull = try? databaseContext.fetch(request)
            
            
            if let courList = courListMayBeNull as? [Cour] {
                // Ici il y'a bien une valeur dans courList
                
                
                // Je parcour tous mes cours pour les supprimer
                for cour in courList {
                    try? databaseContext.delete(cour)
                }
                
                try? databaseContext.save()
            }
            
        }
    }
    
    func updateObjectInDatabase() {
        let appDelegate = UIApplication.shared as! AppDelegate
        let databaseContext = appDelegate.persistentContainer.viewContext
        
        
        // Crée une request vide
        let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Etudiant")
        // Filtre la request
        request.predicate = NSPredicate(format: "nom == %@ AND niveau == %d", "Florian ALONSO", 2)
        
        do {
            let etudiantListMayBeNull = try? databaseContext.fetch(request)
            
            
            if let etudiantList = etudiantListMayBeNull as? [Etudiant],
                etudiantList.count > 0 {
                // Ici y'a bien une valeur dans etudiantList
                
                let florian = etudiantList[0]
                florian.niveau = 5
                
                try? databaseContext.save()
                
            }
            
            
        }
        
    }
    
    func exempleDutilisationDeThread() {
        // ICI JE SUIS SUR LE MAIN THREAD
        
        DispatchQueue.global().async {
            
            // ICI JE SUIS SUR UN THREAD SECONDAIRE
            
            let appDelegate = UIApplication.shared as! AppDelegate
            let databaseContext = appDelegate.persistentContainer.viewContext
            let request = NSFetchRequest<NSFetchRequestResult>(entityName: "Cour")
            request.predicate = NSPredicate(format: "niveau > 2")
            let sortDescriptor = NSSortDescriptor(key: "nom", ascending: true)
            request.sortDescriptors = [sortDescriptor]
            
            do {
                let courListMayBeNull = try? databaseContext.fetch(request)
                print("\(courListMayBeNull?.count)")
            }
            
            // ICI JE SUIS TOUJOURS SUR UN THREAD SECONDAIRE
            
            
            
            DispatchQueue.main.async {
                
                // ICI JE SUIS SUR LE MAIN THREAD
                
                let label = UILabel()
                label.text = "Sauvegarde success"
            }
            
            
            
        }
    }
    
    func exempleDutilisationDeThreadSimplifier() {
        // ICI JE SUIS SUR LE MAIN THREAD
        DispatchQueue.global().async {
            
            // ICI JE SUIS SUR UN THREAD SECONDAIRE
            self.getObjectInDatabase()
            
            DispatchQueue.main.async {
                
                // ICI JE SUIS SUR LE MAIN THREAD
                let label = UILabel()
                label.text = "Sauvegarde success"
            }
        }
    }
    
    
}
