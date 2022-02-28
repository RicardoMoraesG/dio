/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dio.base;

import java.math.BigDecimal;

/**
 *
 * @author Daniel Hatanaka, aulas DIO.
 * @version 1.0.0
 * @see BigDecimal
 * @since Release 1.0.0
 */
public class Order {

    //representa o código do pedido
    private final String code;
    private final BigDecimal totalValue;

    private String[] items;//uma lista.

    /**
     * Construtor da classe.
     *
     * @param code Código do pedido
     * @param totalValue Valor Total.
     */
    public Order(String code, BigDecimal totalValue) {
        this.code = code;
        this.totalValue = totalValue;

    }

    //Outros Métodos
    /**
     * Exibe o código.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.code;
    }

    /**
     * Calcula as taxas de acordo com o valor total do pedido. Se o pedido for
     * maior que R$100,00 uma taxa é cobrada.
     *
     * @return Valor total do pedido com as taxas.
     * @throws RuntimeException se o valor d pedido for negativo.
     */
    public BigDecimal calculateFee() throws RuntimeException {
        if (this.totalValue.signum() < 0) {
            throw new RuntimeException("O pedido não pode ter valor negativo");
        }
        if (this.totalValue.compareTo(new BigDecimal("100")) > 100) {
            return this.totalValue.multiply(new BigDecimal("0.99"));
        }
        return this.totalValue;
    }

    /**
     * Estrutura de condição utilizando if/else
     *
     * @return
     */
    /*
    public double calculateFee(){
        if(this.totalValue > 100) {
            return this.totalValue * 0.99;
        }else {
            return this.totalValue;
        }
    }
     */
 /*
    No caso do switch deve ser inteiro

    public int calculateFeee() {
        switch(totalValue){
            case 100:
                return totalValue * 0.99;
            case 200:
                return totalValue *1.99;
            default:
                return totalValue;
        }
    }*/
    /**
     * Estrutura de repetição. while Percorre uma lista.
     */
    /*
    public void printItems(){
        int i = 0;
        while (i < items.length) {
            System.out.println(items[i]);
            i++;
        }
    }
     */
    /**
     * Estrutura de repetição com do-while
     */
    /*
    public void printItems() {
        int i = 0;
        do {
            System.out.println(items[i]);
            i++;
        } while (i < items.length);
    }
     */
    /**
     * Estrutura de repetição com for
     */
    /*
    public void printlItems(){
        for (int i =0; i < items.length; i++) {
            System.out.println(items);
        }
    }
     */
    /**
     * Estrutura de repetição com enhanced for
     */
    public void printlItems() {
        for (String i : items) {//atribui cada item da lista ao 'i', até finalizar.
            System.out.println(i);
        }
    }
}
