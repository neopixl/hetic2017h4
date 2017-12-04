//
//  UserManager.swift
//  Groupe1
//
//  Created by Florian ALONSO on 12/4/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

class UserManager {
    
    typealias UserCompletion = (_ user: User?) -> Void
    
    static let shared: UserManager = {
      return UserManager()
    }()
    
    private init() {
        
    }
    
    func getUserDetails(completionHandler: @escaping UserCompletion) {
        let url = "https://randomuser.me/api/"
        
        let parameters = ["results" : "1"]
        
        let headers = ["Hetic-Groupe" : "1"]
        
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
                    let resultNumber = json["info"]["results"].intValue
                    print("Nombre de resultats : \(resultNumber)")
                    
                    let resultsJsonList = json["results"].arrayValue
                    if resultsJsonList.isEmpty == false {
                        let userJson = resultsJsonList[0]
                        let user = User(json: userJson)
                        print("Mon user : \(user.firstname)")
                        
                        // The user exists
                        completionHandler(user)
                    } else {
                        // the user do not exist
                        completionHandler(nil)
                    }
                    
                    break
                case .failure(let error):
                    print("Internet request FAILED : \(error)")
                    
                    completionHandler(nil)
                    
                    break
                }
        }
    }
}
