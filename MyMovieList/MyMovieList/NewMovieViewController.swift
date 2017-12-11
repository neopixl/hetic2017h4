//
//  NewMovieViewController.swift
//  MyMovieList
//
//  Created by Glibert Axel on 18/11/15.
//  Copyright © 2015 Neopixl. All rights reserved.
//

import UIKit
fileprivate func < <T : Comparable>(lhs: T?, rhs: T?) -> Bool {
  switch (lhs, rhs) {
  case let (l?, r?):
    return l < r
  case (nil, _?):
    return true
  default:
    return false
  }
}

fileprivate func > <T : Comparable>(lhs: T?, rhs: T?) -> Bool {
  switch (lhs, rhs) {
  case let (l?, r?):
    return l > r
  default:
    return rhs < lhs
  }
}


protocol NewMovieDelegate {
    func didAddNewMovie(_ movie:Movie?)
}

class NewMovieViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {
    
    let netManager = NetworkManager()

    @IBOutlet weak var titleTextField: UITextField!
    
    @IBOutlet weak var resultTableView: UITableView!
    
    var delegate:NewMovieDelegate?
    var searchResults:[Movie]?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func addMovieAction(_ sender: AnyObject)
    {
        if titleTextField.text?.characters.count > 0
        {
            //SearchCode
            netManager.searchMovie(titleTextField.text!, completionHandler: { (movies) -> Void in
                self.searchResults = movies
                self.resultTableView.reloadData()
            })
        }
        else
        {
            print("error")
        }
    }
    
    @IBAction func cancelAction(_ sender: AnyObject) {
        self.delegate?.didAddNewMovie(nil)
    }
    
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if let count = searchResults?.count {
            return count
        } else {
            return 0
        }
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "resultCellIdentifier") as! ResultTableViewCell
        let movie = searchResults![(indexPath as NSIndexPath).row]
        cell.setResult(movie)
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let movie = searchResults![(indexPath as NSIndexPath).row]
        self.delegate?.didAddNewMovie(movie)
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 60
    }
    
    
    
    
    
    
    
    
}
