//
//  SerieTableViewCell.swift
//  Groupe2
//
//  Created by Florian ALONSO on 12/4/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

class SerieTableViewCell: UITableViewCell {
    
    @IBOutlet weak var leftLabel: UILabel!
    @IBOutlet weak var rightLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        
        leftLabel.numberOfLines = 1
        leftLabel.textColor = UIColor.purple
        leftLabel.font = UIFont.boldSystemFont(ofSize: 16)
        
        rightLabel.numberOfLines = 1
        rightLabel.textColor = UIColor.darkGray
        rightLabel.font = UIFont.italicSystemFont(ofSize: 14)
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func setup(withTheSerie serie: Serie) {
        
        self.leftLabel.text = serie.title
        
        self.rightLabel.text = "\(serie.score)"
    }

}
