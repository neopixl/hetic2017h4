//
//  Movie.swift
//  MyMovieList
//
//  Created by Glibert Axel on 11/09/14.
//  Copyright (c) 2014 Neopixl. All rights reserved.
//

import UIKit

class Movie: NSObject {
    
    var title:String!
    var rank:Int!
    
    init(title:String, rank:Int) {
        self.title = title
        self.rank = rank
    }
}
