/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import sys.util.NumberToWords;

/**
 *
 * @author Luis Felipe Cantero
 */
public class FacturaLetra {
     private double totalVenta;
    private String totalEnLetras;

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
        this.totalEnLetras = NumberToWords.convert((long) totalVenta); // Convierte el total a letras
    }

    public String getTotalEnLetras() {
        return totalEnLetras;
    }
}
