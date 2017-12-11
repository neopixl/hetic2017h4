//
//  ResultTableViewCell.swift
//  MyMovieList
//
//  Created by Glibert Axel on 12/09/14.
//  Copyright (c) 2014 Neopixl. All rights reserved.
//

import UIKit

class ResultTableViewCell: UITableViewCell {
    
    @IBOutlet weak var movieImage: UIImageView!
    @IBOutlet weak var movieTitleLabel: UILabel!
    @IBOutlet weak var moviePopularityLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func setResult(_ result:Movie)
    {
        movieTitleLabel.text=result.title
        moviePopularityLabel.text=String(format:"%.2f", result.popularity!)
        //remove the image (needed if cell is reused from cache)
        movieImage.image=nil
        //if backdrop_path is set, load url from the url
        if let imageUrl = result.imageUrl
        {
            movieImage.imageFromURL(imageUrl)
        }
    }

    
    
    
    
    
    
    
    
    
}
