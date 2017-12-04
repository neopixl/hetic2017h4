//
//  GrantedViewController.swift
//  Groupe2
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

class GrantedViewController: UIViewController {

    @IBOutlet weak var grantedLabel: UILabel!
    
    var monEmail = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        grantedLabel.textColor = UIColor.blue
        grantedLabel.font = UIFont.systemFont(ofSize: 14)
        grantedLabel.text = "Hello \(monEmail) !!!!"
        
        
        UserManager.shared.getUserDetails()
    }
}
