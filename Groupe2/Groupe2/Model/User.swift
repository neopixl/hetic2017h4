//
//  User.swift
//  Groupe2
//
//  Created by Florian ALONSO on 12/4/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import Foundation
import SwiftyJSON

class User {
    var firstname: String
    var lastname: String
    var phone: String
    var email: String
    var pictureUrl: String
    
    init(json: JSON) {
        self.firstname = json["name"]["first"].stringValue
        self.lastname = json["name"]["last"].stringValue
        self.phone = json["phone"].stringValue
        self.email = json["email"].stringValue
        
        self.pictureUrl = json["picture"]["medium"].stringValue
    }
}

