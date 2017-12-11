//
//  UrlManager.swift
//  MyMovieList
//
//  Created by Glibert Axel on 19/11/15.
//  Copyright © 2015 Neopixl. All rights reserved.
//

import Foundation

class UrlManager {
    
    //http://api.themoviedb.org/3/search/movie?api_key=c1ac741d5dd740f9861e794c5363b0c2&query=alien
    
    static let apiKey = "c1ac741d5dd740f9861e794c5363b0c2"
    static let baseUrl = "http://api.themoviedb.org"
    static let baseApiSearchPath = "/3/search/movie"
    
    static func urlForSearch(_ filter:String) -> String {
        
        if let encodedFilter = filter.addingPercentEncoding(withAllowedCharacters: .urlHostAllowed) {
            return "\(baseUrl)\(baseApiSearchPath)?api_key=\(apiKey)&query=" + encodedFilter
        } else {
            return "\(baseUrl)\(baseApiSearchPath)?api_key=\(apiKey)&query="
        }
        
    }
    
}
