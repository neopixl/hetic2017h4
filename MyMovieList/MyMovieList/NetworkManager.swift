//
//  File.swift
//  MyMovieList
//
//  Created by Glibert Axel on 19/11/15.
//  Copyright © 2015 Neopixl. All rights reserved.
//

import Foundation
import Alamofire

class NetworkManager {
    
    func searchMovie(_ filter:String, completionHandler:@escaping (_ movies:[Movie]?) -> Void ){
        Alamofire.request(UrlManager.urlForSearch(filter))
        .responseJSON { response in

            switch response.result {
            case .success:
       
                if let json = response.result.value as? [String: Any] {

                    
                    if let resultsDictionary = json["results"] as? [Dictionary<String, AnyObject>] {
                        var movieArray = [Movie]()
                        for movieData in resultsDictionary {
                            let movie = Movie(dictionary: movieData)
                            movieArray.append(movie)
                        }
                        completionHandler(movieArray)
                    } else {
                        completionHandler(nil)
                    }
 
                    
                }
                
            case .failure(let error):
                print("error : \(error)")
                completionHandler(nil)
                
            }

        }
    }
    
}
