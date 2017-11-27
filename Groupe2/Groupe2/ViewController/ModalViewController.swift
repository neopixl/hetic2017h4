//
//  ModalViewController.swift
//  Groupe2
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

protocol ModalViewControllerDelegate {
    func youShouldCloseMe(modal: ModalViewController)
}

class ModalViewController: UIViewController {

    @IBOutlet weak var closeButton: UIButton!
    
    var delegate: ModalViewControllerDelegate?
    
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
        
        if let vraiDelegate = delegate {
            vraiDelegate.youShouldCloseMe(modal: self)
        }
    }
    
}
