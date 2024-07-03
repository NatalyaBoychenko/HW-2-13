package org.example.service;

import org.example.dao.PlanetDao;
import org.example.model.Planet;

public class PlanetCrudService {

    PlanetDao planetDao = new PlanetDao();

    public void savePlanet(Planet planet){
        planetDao.save(planet);
    }

    public Planet findPlanetById(String id){
        return planetDao.findById(id);
    }

    public void updatePlanet(String id, Planet planet){
        planetDao.update(id, planet);
    }

    public void deletePlanet(String id){
        planetDao.delete(id);
    }
}
