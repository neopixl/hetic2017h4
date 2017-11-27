//
//  ModalViewController.swift
//  Groupe1
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

class ModalViewController: UIViewController {
    
    @IBOutlet weak var closeButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        closeButton.setTitleColor(UIColor.green,
                                  for: UIControlState.normal)
        closeButton.setTitleColor(UIColor.blue,
                                  for: UIControlState.highlighted)
        
        closeButton.setTitle("Fermer", for: .normal)
        closeButton.setTitle("Appuyer", for: .highlighted)
    }
    
    @IBAction func didTapOnClose(_ sender: Any) {
        print("Close")
        
        // Fait la meme chose mais n'execute pas de code apres la fermeture
        // self.dismiss(animated: true, completion: nil)
        
        self.dismiss(animated: true) {
            print("C'est OK")
        }
    }
    
}
