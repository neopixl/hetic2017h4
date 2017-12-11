//
//  ViewController.swift
//  Groupe2
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit
import Firebase

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        let animal = Animal()
        // animal.testPrivate() --> Cette methode est privée
        // animal.testFilePrivate() --> Cette methode est privée
        animal.testInternal()
        animal.testPublic()
        
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "modal" {
            
            let title = "FirstModal"
            
            Analytics.logEvent(AnalyticsEventSelectContent, parameters: [
                AnalyticsParameterItemID: "id-\(title)" as NSObject,
                AnalyticsParameterItemName: title as NSObject,
                AnalyticsParameterContentType: "cont" as NSObject
                ])
            
            let destination = segue.destination
            if let modalController = destination as? ModalViewController {
                
                modalController.delegate = self
                
            }
        }
    }

}


extension ViewController: ModalViewControllerDelegate {
    
    func youShouldCloseMe(modal: ModalViewController) {
        
        modal.dismiss(animated: true) {
            print("C'est fermé")
        }
        
        //modal.dismiss(animated: true, completion: nil)
        //modal.dismiss(animated: true)
    }
}

