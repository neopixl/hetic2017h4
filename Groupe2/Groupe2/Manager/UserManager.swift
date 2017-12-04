//
//  UserManager.swift
//  Groupe2
//
//  Created by Florian ALONSO on 12/4/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

class UserManager {
    
    static let shared: UserManager = {
        return UserManager()
    }()
    
    private init() {
        
    }
    
    func getUserDetails() {
        let parameters = ["result": "1"]
        
        let headers = ["Hetic-Groupe": "2"]
        
        let url = "https://randomuser.me/api/"
        
        Alamofire
            .request(url,
                     method: .get,
                     parameters: parameters,
                     encoding: URLEncoding.default,
                     headers: headers)
            .responseJSON { (response) in
                
                switch response.result {
                case .success(let data):
                    
                    let json = JSON(data)
                    let code = json["info"]["results"].intValue
                    
                    print("Nombre de resultats : \(code)")
                    
                    break
                case .failure(let error):
                    
                    print("Fail \(error)")
                    
                    break
                }
        }
        
        
        
    }
}
