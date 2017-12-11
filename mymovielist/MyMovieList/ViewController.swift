//
//  ViewController.swift
//  MyMovieList
//
//  Created by Glibert Axel on 11/09/14.
//  Copyright (c) 2014 Neopixl. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDataSource{
    @IBOutlet weak var textFieldMovie: UITextField!
    @IBOutlet weak var textFieldScore: UITextField!

    @IBOutlet weak var tableViewMovies: UITableView!
    
    //identifier for the tableViewCell
    let movieCellIdentifier = "myMovieCellIdentifier"
    
    //segue identifier for the detail view
    let segueMovieDetailIdentifier = "segueMovieDetail"
    
    var movies:[Movie] = [Movie]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func btnAdd(_ sender: AnyObject) {
        
        //test for empty title
        if (textFieldMovie.text!.isEmpty == true)
        {
            print("Le titre du film est vide.")
            
            //create a alert with the error message
            let alert = UIAlertController(title: "Erreur", message: "Le titre du film est vide.", preferredStyle: UIAlertControllerStyle.alert)
            alert.addAction(UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: nil))
            //show the alert
            self.present(alert, animated: true, completion: nil)
        }
        else
        {
            //check if the score is valid
            if let score = Int(textFieldScore.text!)
            {
                //create a new movie object with title and rank
                let movie = Movie(title: textFieldMovie.text!,rank: score)
                //add the new movie object to the movie list
                movies.append(movie)
                

                //update the table view (new object added at position X) with animation
                tableViewMovies.insertRows(at: [IndexPath(row: movies.count-1, section: 0)], with: UITableViewRowAnimation.top)
            }
            else
            {
                //create a alert with the error message
                print("Le score du film est vide ou invalide.")
                let alert = UIAlertController(title: "Erreur", message: "Le score du film est vide ou invalid", preferredStyle: UIAlertControllerStyle.alert)
                alert.addAction(UIAlertAction(title: "Ok", style: UIAlertActionStyle.default, handler: nil))
                //show the alert
                self.present(alert, animated: true, completion: nil)
            }
        }
    }
    
    //MARK: UITableViewDataSource Methods
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return movies.count;
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableViewMovies.dequeueReusableCell(withIdentifier: movieCellIdentifier) as! MovieTableViewCell
        
        cell.setMovie(movies[(indexPath as NSIndexPath).row])
        return cell
    }
    
    //MARK: Segue
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        //vérification de l'identifiant
        if(segue.identifier==segueMovieDetailIdentifier)
        {
            //get the view who'll be displayed
            let detailViewController = segue.destination as! DetailMovieViewController
            
            //get the index of the selected row
            let index = (tableViewMovies.indexPathForSelectedRow! as NSIndexPath).row
            
            //get the movie at the selected position
            let selectedMovie = movies[index]
            
            //give the selecte movie to the destination View
            detailViewController.movie=selectedMovie
        }
    }

}

