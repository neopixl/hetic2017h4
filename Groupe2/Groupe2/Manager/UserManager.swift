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
    
    typealias UserDetailCompletion = (_ userOpt: User?) -> Void
    
    static let shared: UserManager = {
        return UserManager()
    }()
    
    private init() {
        
    }
    
    func getUserDetails(completionHandler: @escaping UserDetailCompletion) {
        let url = "https://randomuser.me/api/"
        
        let parameters = ["results": "1"]
        
        let headers = ["Hetic-Groupe" : "2"]
        
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
                    let numberResults = json["info"]["results"].intValue
                    print("SUCCES : Number of results : \(numberResults)")
                    
                    let resultsJsonList = json["results"].arrayValue
                    if resultsJsonList.isEmpty == false {
                        
                        let firstUserJson = resultsJsonList[0]
                        
                        let user = User(json: firstUserJson)
                        completionHandler(user)
                        
                        
                    }
                    
                    break
                case .failure(let error):
                    print("INTERNET ERROR : \(error)")
                    
                    completionHandler(nil)
                    
                    break
                }
                
                
        }        
        
    }
}
