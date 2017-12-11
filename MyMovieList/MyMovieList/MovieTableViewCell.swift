//
//  MovieTableViewCell.swift
//  MyMovieList
//
//  Created by Glibert Axel on 18/11/15.
//  Copyright © 2015 Neopixl. All rights reserved.
//

import UIKit

class MovieTableViewCell: UITableViewCell {

    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var scoreLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func setMovie(_ movie:Movie) {
        self.titleLabel.text = movie.title
        self.scoreLabel.text = String(format: "%.2f", movie.popularity)
    }

}
