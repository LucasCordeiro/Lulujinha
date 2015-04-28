
package controller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author LucasAugustoCordeiro
 */

//This is the Command Pattern
public interface Controller {
    //
    //command pattern defaut method
    public void execute();
    //
    //method to initialize the controller
    public void init(HttpServletRequest request);
    //
    //get return pagege method
    public String getReturnPage();
            
}
