//
//  GrantedViewController.swift
//  Groupe1
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

class GrantedViewController: UIViewController {

    @IBOutlet weak var grantedLabel: UILabel!
    var email = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        grantedLabel.text = "Bravo \(email) !!!!"
    }

}
