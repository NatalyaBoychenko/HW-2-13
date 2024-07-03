package org.example;

import org.example.model.Client;
import org.example.model.Planet;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

        initDb();

        Client client = new Client();
        client.setName("Alonzo Hardin");
        Client updatedClient = new Client();
        updatedClient.setName("Wayne Wall");

        Planet planet = new Planet();
        planet.setId("UR");
        planet.setName("Uranus");

        Planet updatedPlanet = new Planet();
        updatedPlanet.setName("Uranus2024");

//        clientService.saveClient(client);
//        System.out.println("Client with id = 7 : " + clientService.findClientById(7L));
//        clientService.updateClient(11L, updatedClient);
//        clientService.deleteClient(11L);

        planetService.savePlanet(planet);
//        System.out.println("planet with id = JUP: " + planetService.findPlanetById("JUP"));
//        planetService.updatePlanet("UR", updatedPlanet);
//        planetService.deletePlanet("UR");
    }

    private static void initDb(){
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:./db", null, null)
                .load();

        flyway.migrate();
    }
}