/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author LucasAugustoCordeiro
 */
public abstract class AbstractController implements Controller {
    
    private HttpServletRequest request;
    protected String returnPage;
    //
    //set request of the controller at initialization
    @Override
    public void init(HttpServletRequest request) {
        this.setRequest(request);
    }
    //
    //get page of return
    @Override
    public String getReturnPage(){
        return returnPage;
    }
    //
    //set page of return
    public void setReturnPage(String page) {
        returnPage = page;
    }
    //
    //set another request
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    //
    //get request
    public HttpServletRequest getRequest() {
        return request;
    }

    
}
