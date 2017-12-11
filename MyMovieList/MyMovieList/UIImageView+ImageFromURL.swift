//
//  UIImageView+ImageFromURL.swift
//  MyMovieList
//
//  Created by Glibert Axel on 12/09/14.
//  Copyright (c) 2014 Neopixl. All rights reserved.
//

import UIKit

extension UIImageView
{
    func imageFromURL(_ url:String)
    {

        let url = URL(string: url)
        DispatchQueue.global().async {
            let data = try? Data(contentsOf: url!) //make sure your image in this url does exist, otherwise unwrap in a if let check / try-catch
            DispatchQueue.main.async {
                self.image = UIImage(data: data!)
            }
        }

    }
}
