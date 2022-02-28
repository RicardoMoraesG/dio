
package com.dio;

import com.dio.base.Order;//importa a classe.

public class MyFirstProgram {




    public static void main(String[]args){

        Order order = new Order("code1234",100.000);
        System.out.println(order.toString() + " Valor: " + order.calculateFee());
    }

}
