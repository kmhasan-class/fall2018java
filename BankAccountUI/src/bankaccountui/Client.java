/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountui;

import java.time.LocalDate;

/**
 *
 * @author kmhasan
 */
public class Client {
    private int id;
    private Name name;
    private LocalDate dob;

    public Client(int id, Name name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setName(Name name) {
        this.name = name;
    }    
}
