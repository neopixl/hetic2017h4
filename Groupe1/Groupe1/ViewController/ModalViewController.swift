//
//  ModalViewController.swift
//  Groupe1
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

protocol ModalViewControllerDelegate {
    func shouldCloseMyself(modal: ModalViewController)
}

class ModalViewController: UIViewController {
    
    @IBOutlet weak var closeButton: UIButton!
    
    var delegate: ModalViewControllerDelegate?
    
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
        
        if let monDelegate = delegate {
            monDelegate.shouldCloseMyself(modal: self)
        }
    }
    
}
