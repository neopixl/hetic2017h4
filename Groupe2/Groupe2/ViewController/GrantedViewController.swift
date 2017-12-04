//
//  GrantedViewController.swift
//  Groupe2
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit
import Alamofire
import AlamofireImage

class GrantedViewController: UIViewController {

    @IBOutlet weak var grantedLabel: UILabel!
    @IBOutlet weak var pictureImageView: UIImageView!
    @IBOutlet weak var firstnameLabel: UILabel!
    @IBOutlet weak var lastnameLabel: UILabel!
    @IBOutlet weak var phoneLabel: UILabel!
    @IBOutlet weak var emailLabel: UILabel!
    
    var monEmail = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        grantedLabel.textColor = UIColor.blue
        grantedLabel.font = UIFont.systemFont(ofSize: 14)
        grantedLabel.text = "Hello \(monEmail) !!!!"
        
        
        self.setup(fromUser: nil)
        UserManager.shared.getUserDetails { (userOpt) in
            
            self.setup(fromUser: userOpt)
            
        }
    }
    
    func setup(fromUser userOpt: User?) {
        if let user = userOpt {
            
            self.grantedLabel.text = "STATUS : SUCCESS"
            
            self.firstnameLabel.text = "Firstname : \(user.firstname)"
            self.lastnameLabel.text = "Lastname : \(user.lastname)"
            self.phoneLabel.text = "Phone : \(user.phone)"
            self.emailLabel.text = "Email : \(user.email)"
            
            Alamofire
                .request(user.pictureUrl)
                .responseImage(completionHandler: { (response) in
                    
                    if let monImage = response.result.value {
                        self.pictureImageView.image = monImage
                    }
                    
                })
            
            
        } else {
            
            self.grantedLabel.text = "STATUS : ERROR"
            
            self.firstnameLabel.text = "Firstname :"
            self.lastnameLabel.text = "Lastname :"
            self.phoneLabel.text = "Phone :"
            self.emailLabel.text = "Email :"
        }
    }
}
