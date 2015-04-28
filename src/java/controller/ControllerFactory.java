/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author LucasAugustoCordeiro
 */
public class ControllerFactory {
    
    public static final Controller getControllerByClass(Class actionClass) {
        try {
            //
            //Create controller throw the gave class
            Controller controller = (Controller) actionClass.newInstance();
            //
            //return class created
            return controller;
        }
        catch (java.lang.InstantiationException | IllegalAccessException | ClassCastException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }
    
    public static final Controller getControllerByFullClassName(String className) {
        try {
            //
            //create the full name of the class
            String name = "controller.impl."+className+"Controller";
            //
            //get the class instance by the name
            Class actionClass = Class.forName(name);
            //
            //return class created throw the previus method
            return getControllerByClass(actionClass);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }
    
}
