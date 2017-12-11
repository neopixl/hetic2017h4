//
//  Movie.swift
//  MyMovieList
//
//  Created by Glibert Axel on 18/11/15.
//  Copyright © 2015 Neopixl. All rights reserved.
//

class Movie {
    
    var title:String!
    var popularity:Float!
    var imageUrl:String?
    var releaseDate:String?
    
    //http://image.tmdb.org/t/p/w500
    
    init(title:String, popularity:Float, imageUrl:String?) {
        self.title = title
        self.popularity = popularity
        self.imageUrl = imageUrl
    }
    
    init(dictionary:Dictionary<String, AnyObject>) {
        self.title = dictionary["original_title"] as! String
        self.popularity = dictionary["popularity"] as! Float
        if let backdropPath = dictionary["backdrop_path"] as? String {
            self.imageUrl = "http://image.tmdb.org/t/p/w500\(backdropPath)"
        }
        self.releaseDate = dictionary["release_date"] as? String
    }
    
    
    
    
    
    
    

}
