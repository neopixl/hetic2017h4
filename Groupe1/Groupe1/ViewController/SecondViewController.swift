//
//  SecondViewController.swift
//  Groupe1
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {
    
    var message = ""
    var person: Person?
    @IBOutlet weak var monMessageLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        monMessageLabel.text = message
    }

}