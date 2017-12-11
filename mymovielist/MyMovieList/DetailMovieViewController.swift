//
//  DetailMovieViewController.swift
//  MyMovieList
//
//  Created by Glibert Axel on 11/09/14.
//  Copyright (c) 2014 Neopixl. All rights reserved.
//

import UIKit

class DetailMovieViewController: UIViewController {
    @IBOutlet weak var labelTitle: UILabel!
    @IBOutlet weak var labelRank: UILabel!
    
    var movie:Movie?{
        didSet{
            displayMovie()
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        displayMovie()
        self.title = "Détails"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    //display the current movie
    func displayMovie()
    {
        if let currentMovie = self.movie
        {
            if let label = self.labelTitle {
                label.text = currentMovie.title
            }
            if let label = self.labelRank {
                label.text = String(format: "%d", currentMovie.rank!)
            }
            
           
        }
    }

}
