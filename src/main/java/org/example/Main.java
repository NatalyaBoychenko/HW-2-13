package org.example;

import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.service.TicketCrudService;
import org.flywaydb.core.Flyway;
import org.h2.table.Plan;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();
        TicketCrudService ticketService = new TicketCrudService();

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

        Planet venus = planetService.findPlanetById("VEN");
        Planet earth = planetService.findPlanetById("EA");
        Client savedClient = clientService.findClientById(1L);

        Ticket ticket = new Ticket();
        ticket.setClient(savedClient);
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setToPlanetId(venus);
        ticket.setFromPlanetId(earth);

        Ticket updatedTicket = new Ticket();
        updatedTicket.setClient(savedClient);
        ticket.setCreatedAt(LocalDateTime.now());
        updatedTicket.setFromPlanetId(venus);
        updatedTicket.setToPlanetId(earth);

//        clientService.saveClient(client);
//        System.out.println("Client with id = 7 : " + clientService.findClientById(7L));
//        clientService.updateClient(11L, updatedClient);
//        clientService.deleteClient(11L);

//        planetService.savePlanet(planet);
//        System.out.println("planet with id = JUP: " + planetService.findPlanetById("JUP"));
//        planetService.updatePlanet("UR", updatedPlanet);
//        planetService.deletePlanet("UR");

//        ticketService.saveTicket(ticket);
//        System.out.println("ticket with id = 2: " + ticketService.findTicketById(2L));
//        ticketService.updateTicket(3L, updatedTicket);
//        ticketService.deleteTicket(3L);

    }

    private static void initDb(){
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:./db", null, null)
                .load();

        flyway.migrate();
    }
}