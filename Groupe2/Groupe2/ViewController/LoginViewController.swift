//
//  LoginViewController.swift
//  Groupe2
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {

    @IBOutlet weak var titleLabel: UILabel!
    
    @IBOutlet weak var emailTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    @IBOutlet weak var connexionButton: UIButton!

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        titleLabel.textColor = UIColor.black
        titleLabel.font = UIFont.boldSystemFont(ofSize: 20)
        titleLabel.text = "Connectez vous :"
        
        connexionButton.titleLabel?.font = UIFont.boldSystemFont(ofSize: 20)
        connexionButton.setTitle("Connexion", for: .normal)
        connexionButton.setTitleColor(UIColor.green, for: .normal)
        
        connexionButton.setTitleColor(UIColor.lightGray, for: .disabled)
        connexionButton.isEnabled = false
        
        
        emailTextField.placeholder = "Email"
        emailTextField.textColor = UIColor.gray
        emailTextField.font = UIFont.italicSystemFont(ofSize: 16)
        emailTextField.keyboardType = .emailAddress
        emailTextField.delegate = self
        
        passwordTextField.placeholder = "Password"
        passwordTextField.textColor = UIColor.gray
        passwordTextField.font = UIFont.italicSystemFont(ofSize: 16)
        passwordTextField.keyboardType = .default
        passwordTextField.isSecureTextEntry = true
        passwordTextField.delegate = self
    }

    
    @IBAction func didTapOnLogin(_ sender: Any) {
        print("Tap on login")
        
        // Permet d'afficher un controlleur depuis le code
        
        let storyboard = self.storyboard
        let controller = storyboard?.instantiateViewController(withIdentifier: "granted")
        
        if let grantedController = controller as? GrantedViewController {
            
            grantedController.monEmail = emailTextField.text ?? ""
            
            self.navigationController?.pushViewController(grantedController, animated: true)
            
        }
    }
}

extension LoginViewController: UITextFieldDelegate {
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder() // Cache le clavier
        return false
    }
    
    func textFieldDidEndEditing(_ textField: UITextField, reason: UITextFieldDidEndEditingReason) {
        
        let emailOptionnel = emailTextField.text
        let passwrdOptionnel = passwordTextField.text
        
        if let vraiEmail = emailOptionnel,
            let vraiPassword = passwrdOptionnel {
            
            connexionButton.isEnabled = (vraiEmail.isEmpty == false && vraiPassword.isEmpty == false)
            
        } else {
            connexionButton.isEnabled = false
        }
    }
    
}
