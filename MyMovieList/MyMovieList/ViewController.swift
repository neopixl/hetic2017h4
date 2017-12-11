//
//  ViewController.swift
//  MyMovieList
//
//  Created by Glibert Axel on 11/09/14.
//  Copyright (c) 2014 Neopixl. All rights reserved.
//

import UIKit

class ViewController: UIViewController, NewMovieDelegate, UITableViewDataSource, UITableViewDelegate {
    
    @IBOutlet weak var tableViewMovie: UITableView!
    var newMovieViewController:NewMovieViewController?
    var dataMovie = [Movie]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?)
    {
        let segueIdentifier = "segueAddMovie"
        if segue.identifier == segueIdentifier
        {
            newMovieViewController = segue.destination as? NewMovieViewController
            newMovieViewController?.delegate = self
        }
    }
    
    func didAddNewMovie(_ movie: Movie?) {
        if let mov = movie {
            self.dataMovie.append(mov)
            self.tableViewMovie.reloadData()
        }
        newMovieViewController?.dismiss(animated: true, completion: nil)
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return dataMovie.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "movieCellIdentifier") as! MovieTableViewCell
        let movie = dataMovie[(indexPath as NSIndexPath).row]
        cell.setMovie(movie)
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let movie = dataMovie[(indexPath as NSIndexPath).row]
        let detailViewController = UIStoryboard(name: "Main", bundle: nil).instantiateViewController(withIdentifier: "detailMovieViewController") as? DetailMovieViewController
        detailViewController?.movie = movie
        if let viewController = detailViewController {
            self.navigationController?.pushViewController(viewController, animated: true)
        }
        
        
    }

}











