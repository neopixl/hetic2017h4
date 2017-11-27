//
//  ModalViewController.swift
//  Groupe2
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
        
        closeButton.setTitle("Fermer", for: UIControlState.normal)
        closeButton.setTitle("TAP", for: UIControlState.highlighted)
        
        closeButton.setTitleColor(UIColor.red, for: .normal)
        closeButton.setTitleColor(.green, for: .highlighted)
        
    }

    @IBAction func didTapOnClose(_ sender: Any) {
        print("CLOSE")
        
        // self.dismiss(animated: true, completion: nil)
        // N'execute pas de code lorsque c'est fini
        
        self.dismiss(animated: true) {
            print("C'est OK")
        }
    }
    
}
