package servlets;

import controller.Controller;
import controller.ControllerFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LucasAugustoCordeiro
 */

@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class FrontControllerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String controller = "";
            //
            //get button name
            String buttonName = request.getParameter("control");
            //
            //verify what class we need to call
            if(buttonName == null || buttonName.equals("index"))
                controller = "Index";
            else{
                if(buttonName.equals("Cadastrar-se"))
                    controller = "Cadastro";
                if(buttonName.equals("Entrar"))
                    controller = "Entrar";
                if(buttonName.equals("Completar"))
                    controller = "Cadastro";
                if(buttonName.equals("Boleto"))
                    controller = "Boleto";
                if(buttonName.equals("Comprar"))
                    controller = "Compra";
                if(buttonName.equals("loggout"))
                    controller = "Loggout";
                if(buttonName.equals("paypal"))
                    controller = "PayPal";
                if(buttonName.equals("cancel"))
                    controller = "Cancel";
            }
                
            //
            //create controller by class name
            Controller control = ControllerFactory.getControllerByFullClassName(controller);
            //
            //initialize controler with request
            control.init(request);
            //
            //execute Command method (execute())
            control.execute();
            //
            //get RequestDispatcher with the controller page
            RequestDispatcher rd = getServletContext().getRequestDispatcher(control.getReturnPage());
            //
            //forward the request dispatcher
            rd.forward(request, response);
        }catch(Exception e){
            System.out.println("Erro on the servlet; " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
