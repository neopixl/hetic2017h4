//
//  SerieViewController.swift
//  Groupe2
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
        
        var serie = Serie(withTheTitle: "The Walking Dead The Walking Dead The Walking Dead The Walking Dead", andAScoreOf: 4.2)
        self.serieList.append(serie)
        
        serie = Serie(withTheTitle: "Rick and Morty", andAScoreOf: 4.5)
        self.serieList.append(serie)
        
        serie = Serie(withTheTitle: "Game of thrones", andAScoreOf: 2.5)
        self.serieList.append(serie)
        
        serie = Serie(withTheTitle: "Stranger things", andAScoreOf: 3.8)
        self.serieList.append(serie)
        
        serie = Serie(withTheTitle: "L'attaque des titans", andAScoreOf: 3.9)
        self.serieList.append(serie)
    }

}

extension SerieViewController : UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return serieList.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "serieCell")
        if let serieCell = cell as? SerieTableViewCell {
            
            let index = indexPath.row
            let serie = self.serieList[index]
            
            serieCell.setup(withTheSerie: serie)
            
            return serieCell
        }
        
        return UITableViewCell()
    }
}


extension SerieViewController : UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        // Deselection la cellule car ce n'est pas automatique
        tableView.deselectRow(at: indexPath, animated: false)
        
        let index = indexPath.row
        let serie = self.serieList[index]
        
        
        // Crée un alerte controlleur vide
        let alertController = UIAlertController(title: "Tap sur serie", message: serie.title, preferredStyle: .alert)
        
        // Ajout de l'action cancel, pour pouvoir fermer la popup
        let actionCancel = UIAlertAction(title: "Cancel", style: .cancel)
        alertController.addAction(actionCancel)
        
        // Affiche la popup
        self.present(alertController, animated: true)
        
    }
    
}









