package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Customer luke = new Customer("Luke", "Brandt", "12345 First St.", "83709", "2228567894");
        luke.setDivision(divisionRepository.findAll().get(1));
        customerRepository.save(luke);

        Customer steve = new Customer("Steve", "Jobs", "4745 Main St.", "55555", "2247874894");
        steve.setDivision(divisionRepository.findAll().get(2));
        customerRepository.save(steve);

        Customer jane = new Customer("Jane", "Hart", "789 Sumpter way", "44444", "8728564564");
        jane.setDivision(divisionRepository.findAll().get(6));
        customerRepository.save(jane);

        Customer bruce = new Customer("Bruce", "Campbell", "7345 Dark Dr.", "16665", "9876551234");
        bruce.setDivision(divisionRepository.findAll().get(11));
        customerRepository.save(bruce);

        Customer lola = new Customer("Lola", "Gold", "56878 Wolf Ave", "98745", "1245687456");
        lola.setDivision(divisionRepository.findAll().get(5));
        customerRepository.save(lola);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of customers: " + customerRepository.count());
    }
}
