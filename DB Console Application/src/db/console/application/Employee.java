/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.console.application;

import java.time.LocalDate;

/**
 *
 * @author kmhasan
 */
public class Employee {
    private String sin;
    private String name;
    private String phone;
    private LocalDate hiringDate;

    public Employee(String sin, String name, String phone, LocalDate hiringDate) {
        this.sin = sin;
        this.name = name;
        this.phone = phone;
        this.hiringDate = hiringDate;
    }

    public String getSin() {
        return sin;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    @Override
    public String toString() {
        return "Employee{" + "sin=" + sin + ", name=" + name + ", phone=" + phone + ", hiringDate=" + hiringDate + '}';
    }
    
    
}
