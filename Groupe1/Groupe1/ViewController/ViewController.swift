//
//  ViewController.swift
//  Groupe1
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        let animaux = Animaux()
        // animaux.testPrivate() --> Ne fonctionne pas car private
        //animaux.testFilePrivate() --> --> Ne fonctionne pas car private
        animaux.testInternal()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if segue.identifier == "modal" {
            
            let destination = segue.destination
            if let modalControler = destination as? ModalViewController {
                modalControler.delegate = self
            }
            
        } else if segue.identifier == "push" {
            
            let destination = segue.destination
            if let secondController = destination as? SecondViewController {
                secondController.message = "Hey, salut touuuuus le monde"
                secondController.person = Person(lastname: "ALONSO")
            }
        }
    }

}


extension ViewController: ModalViewControllerDelegate {
    func shouldCloseMyself(modal: ModalViewController) {
         // Fait la meme chose mais n'execute pas de code apres la fermeture
         // modal.dismiss(animated: true, completion: nil)
         
         modal.dismiss(animated: true) {
            print("C'est OK")
         }
    }
}

