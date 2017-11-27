//
//  LoginViewController.swift
//  Groupe1
//
//  Created by Florian ALONSO on 11/27/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {
    @IBOutlet weak var titleLabel: UILabel!
    
    @IBOutlet weak var emailTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    @IBOutlet weak var connectionButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        titleLabel.textColor = UIColor(red: 10/255, green: 10/255, blue: 10/255, alpha: 1)
        titleLabel.font = UIFont.boldSystemFont(ofSize: 15)
        
        connectionButton.setTitleColor(UIColor.green, for: .normal)
        connectionButton.setTitleColor(UIColor.lightGray, for: .disabled)
        connectionButton.isEnabled = false
        connectionButton.titleLabel?.font = UIFont.boldSystemFont(ofSize: 20)
        
        emailTextField.font = UIFont.italicSystemFont(ofSize: 15)
        emailTextField.placeholder = "Email"
        emailTextField.textColor = UIColor.gray
        emailTextField.keyboardType = .emailAddress
        emailTextField.delegate = self
        
        passwordTextField.font = UIFont.italicSystemFont(ofSize: 15)
        passwordTextField.placeholder = "Password"
        passwordTextField.textColor = UIColor.gray
        passwordTextField.keyboardType = .default
        passwordTextField.isSecureTextEntry = true
        passwordTextField.delegate = self
    }
    
    func calculateButtonState() {
        // cette fonction as pour but de savoir si les 2 champs son remplie
        let emailOptionnel = emailTextField.text
        let passwordOptionnel = passwordTextField.text
        
        var buttonShouldBeActivated: Bool
        if let email = emailOptionnel,
            let password = passwordOptionnel,
            !email.isEmpty,
            !password.isEmpty {
            
            buttonShouldBeActivated = true
        } else {
            buttonShouldBeActivated = false
        }
        connectionButton.isEnabled = buttonShouldBeActivated
    }
    
    @IBAction func didTapOnLogin(_ sender: Any) {
        if let controller = self.storyboard?.instantiateViewController(withIdentifier: "granted") as? GrantedViewController {
            
            
            // Ici le controlleur existe
            controller.email = emailTextField.text ?? ""
            self.navigationController?.pushViewController(controller, animated: true)
            
        }
    }
    
}

extension LoginViewController: UITextFieldDelegate {
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return false
    }
    
    func textFieldDidEndEditing(_ textField: UITextField, reason: UITextFieldDidEndEditingReason) {
        calculateButtonState()
    }
}
