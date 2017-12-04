//
//  SerieViewController.swift
//  Groupe1
//
//  Created by Florian ALONSO on 12/4/17.
//  Copyright © 2017 Hetic. All rights reserved.
//

import UIKit

class SerieViewController: UIViewController {

    @IBOutlet weak var tableView: UITableView!
    
    var serieList = [Serie]()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        tableView.dataSource = self
        tableView.delegate = self
        
        var newSerie = Serie(withTheTitle: "The Walking Dead", andTheScore: 4.3)
        self.serieList.append(newSerie)
        
        newSerie = Serie(withTheTitle: "Rick and Morty", andTheScore: 5.0)
        self.serieList.append(newSerie)
        
        newSerie = Serie(withTheTitle: "Game of thrones", andTheScore: 4.9)
        self.serieList.append(newSerie)
        
        newSerie = Serie(withTheTitle: "The wire", andTheScore: 5.0)
        self.serieList.append(newSerie)
        
        newSerie = Serie(withTheTitle: "Breaking bad", andTheScore: 3.8)
        self.serieList.append(newSerie)
    }

}

extension SerieViewController : UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return serieList.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "serieCell")
        if let serieCell = cell as? SerieTableViewCell {
            
            let serie = self.serieList[indexPath.row]
            
            serieCell.setup(withSerie: serie)
            
            return serieCell
        }
        
        return UITableViewCell()
    }
    
}

extension SerieViewController : UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        // Deselectionne la ligne car ce n'est pas automatique
        tableView.deselectRow(at: indexPath, animated: false)
        
        // Recupère la serie
        let serie = self.serieList[indexPath.row]
        
        
        // Crée une popup qui affiche le nom
        let alertController = UIAlertController(title: "Tap sur serie", message: serie.title, preferredStyle: .alert)
        
        // Ajoute l'action de cancel pour pouvoir la fermer
        let cancelAction = UIAlertAction(title: "Cancel", style: .cancel)
        alertController.addAction(cancelAction)
        
        // Lance graphiquement la popup
        self.present(alertController, animated: true)
        
    }
}
