/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.ausiasmarch.authajaxcalculator;

/**
 *
 * @author Elliot
 */
public class Operacion {
    private int op1;
    private int op2;
    private String operacion;

    public Operacion(int op1, int op2, String operacion) {
        this.op1 = op1;
        this.op2 = op2;
        this.operacion = operacion;
    }

    public int getOp1() {
        return op1;
    }

    public void setOp1(int op1) {
        this.op1 = op1;
    }

    public int getOp2() {
        return op2;
    }

    public void setOp2(int op2) {
        this.op2 = op2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
}
