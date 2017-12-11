//
//  MovieTableViewCell.swift
//  MyMovieList
//
//  Created by Glibert Axel on 11/09/14.
//  Copyright (c) 2014 Neopixl. All rights reserved.
//

import UIKit

class MovieTableViewCell: UITableViewCell {

    @IBOutlet weak var labelTitle: UILabel!
    @IBOutlet weak var labelScore: UILabel!
        
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    //display the current movie in the cell
    func setMovie(_ movie:Movie)
    {
        labelTitle.text=movie.title;
        labelScore.text="\(movie.rank!)"
    }

}
