package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public void saveContract(Contract contract) {


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            Vehicle vehicle = contract.getVehicle();

            String base = String.format("%s|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f\n",
            contract instanceof SalesContract ? "SALE" : "LEASE",
            contract.getDate(),
            contract.getCustomerName(),
            contract.getCustomerEmail(),
            vehicle.getVin(),
            vehicle.getYear(),
            vehicle.getMake(),
            vehicle.getModel(),
            vehicle.getVehicleType(),
            vehicle.getColor(),
            vehicle.getOdometer(),
            vehicle.getPrice()
            );

            String Line;
            if (contract instanceof SalesContract) {
                SalesContract sc = (SalesContract) contract;
                Line = base + String.format("|%.2f|%.2f", sc.getTotalPrice(), sc.getMonthlyPayment());
            } else {
                LeaseContract lc = (LeaseContract) contract;
                Line = base + String.format("|%.2f|%.2f", lc.getTotalPrice(), lc.getMonthlyPayment());
            }

            bufferedWriter.write(Line + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Error, Please try again.", e);
        }
    }
}
