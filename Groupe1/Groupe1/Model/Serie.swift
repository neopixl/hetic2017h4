//
//  Serie.swift
//  Groupe1
//
//  Created by Florian ALONSO on 12/4/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import Foundation

class Serie {
    let title: String
    var score: Float
    
    init(withTheTitle newTitle: String, andTheScore newScore: Float) {
        self.title = newTitle
        self.score = newScore
    }
}
