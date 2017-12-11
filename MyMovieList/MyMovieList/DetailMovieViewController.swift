//
//  DetailMovieViewController.swift
//  MyMovieList
//
//  Created by Glibert Axel on 19/11/15.
//  Copyright © 2015 Neopixl. All rights reserved.
//

import UIKit

class DetailMovieViewController: UIViewController {

    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var scoreLabel: UILabel!
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var dateLabel: UILabel!
    var movie:Movie?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        

        // Do any additional setup after loading the view.
        if let mov = movie {
            self.title = mov.title
            self.titleLabel.text = mov.title
            self.scoreLabel.text = String(format: "%.2f", mov.popularity)
            self.dateLabel.text = mov.releaseDate
            if let imgUrl = mov.imageUrl {
                self.imageView.imageFromURL(imgUrl)
            }
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
