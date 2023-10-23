/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Config.GenerarSerie;
import Modelo.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author torre
 */
public class Controlador extends HttpServlet {
    
    EmpleadoDAO edao=new EmpleadoDAO();
    Empleado em=new Empleado();
    ClienteDAO cdao=new ClienteDAO();
    Cliente cl=new Cliente();
    ProductoDAO pdao=new ProductoDAO();
    Producto pr=new Producto();
    int ide;
    
    Venta v=new Venta();
    List<Venta>lista=new ArrayList();
    int item,cant,cod;
    String descripcion,numeroserie;
    double precio,subtotal,totalpagar;
    VentaDAO vdao=new VentaDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String menu=request.getParameter("menu");
            String accion=request.getParameter("accion");
            
            if (menu.equals("Empleado")) {
                switch (accion){
                    case "Listar":
                        List lista=edao.listar();
                        request.setAttribute("empleados", lista);
                        break;
                    case "Agregar":
                        String dni=request.getParameter("txtDni");
                        String nom=request.getParameter("txtNombres");
                        String tel=request.getParameter("txtTelefono");
                        String est=request.getParameter("txtEstado");
                        String user=request.getParameter("txtUsuario");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                            ide=Integer.parseInt(request.getParameter("id"));
                            Empleado e=edao.listarId(ide);
                            request.setAttribute("empleado", e);
                            request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1=request.getParameter("txtDni");
                        String nom1=request.getParameter("txtNombres");
                        String tel1=request.getParameter("txtTelefono");
                        String est1=request.getParameter("txtEstado");
                        String user1=request.getParameter("txtUsuario");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setUser(user1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        ide=Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            }
            if (menu.equals("Principal")) {
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            if (menu.equals("Cliente")) {
                switch (accion){
                    case "Listar":
                        List lista=cdao.listar();
                        request.setAttribute("clientes", lista);
                        break;
                    case "Agregar":
                        String dni=request.getParameter("txtDni");
                        String nom=request.getParameter("txtNombres");
                        String dir=request.getParameter("txtDireccion");
                        String est=request.getParameter("txtEstado");
                        
                        cl.setDni(dni);
                        cl.setNom(nom);
                        cl.setDir(dir);
                        cl.setEstado(est);
                        
                        cdao.agregar(cl);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                            ide=Integer.parseInt(request.getParameter("id"));
                            Cliente c=cdao.listarId(ide);
                            request.setAttribute("cliente", c);
                            request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1=request.getParameter("txtDni");
                        String nom1=request.getParameter("txtNombres");
                        String dir1=request.getParameter("txtDireccion");
                        String est1=request.getParameter("txtEstado");
                        cl.setDni(dni1);
                        cl.setNom(nom1);
                        cl.setDir(dir1);
                        cl.setEstado(est1);
                        cl.setId(ide);
                        cdao.actualizar(cl);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        ide=Integer.parseInt(request.getParameter("id"));
                        cdao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
            }
            if (menu.equals("Producto")) {
                switch (accion){
                    case "Listar":
                        List lista=pdao.listar();
                        request.setAttribute("productos", lista);
                        break;
                    case "Agregar":
                        String nom=request.getParameter("txtNombres");
                        String pre=request.getParameter("txtPrecios");
                        String sto=request.getParameter("txtStock");
                        String est=request.getParameter("txtEstado");
                        pr.setNom(nom);
                        pr.setPrecio(Double.valueOf(pre));
                        pr.setStock(Integer.parseInt(sto));
                        pr.setEstado(est);
                        pdao.agregar(pr);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                            ide=Integer.parseInt(request.getParameter("id"));
                            Producto p=pdao.listarId(ide);
                            request.setAttribute("producto", p);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String nom1=request.getParameter("txtNombres");
                        String pre1=request.getParameter("txtPrecios");
                        String sto1=request.getParameter("txtStock");
                        String est1=request.getParameter("txtEstado");
                        pr.setNom(nom1);
                        pr.setPrecio(Double.valueOf(pre1));
                        pr.setStock(Integer.parseInt(sto1));
                        pr.setEstado(est1);
                        pr.setId(ide);
                        pdao.actualizar(pr);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        ide=Integer.parseInt(request.getParameter("id"));
                        pdao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }
            if (menu.equals("NuevaVenta")) {
                switch (accion){
                    case "Buscar Cliente":
                        String dni=request.getParameter("codigocliente");
                        cl.setDni(dni);
                        cl=cdao.buscar(dni); 
                        request.setAttribute("c", cl);
                        request.setAttribute("nserie", numeroserie);
                        break;
                    case "Buscar Producto":
                        int id=Integer.parseInt(request.getParameter("codigoproducto"));                        
                        pr=pdao.listarId(id);
                        request.setAttribute("c", cl);
                        request.setAttribute("producto", pr);
                        request.setAttribute("lista", lista);
                        request.setAttribute("totalpagar", totalpagar);
                        request.setAttribute("nserie", numeroserie);
                        break;
                    case "Agregar":
                        request.setAttribute("c", cl);
                        totalpagar=0.0;
                        item=item+1;
                        cod=pr.getId();
                        descripcion=request.getParameter("nombproducto");
                        precio=Double.parseDouble(request.getParameter("precio"));
                        cant=Integer.parseInt(request.getParameter("cant"));
                        subtotal=precio*cant;
                        v=new Venta();
                        v.setItem(item);
                        v.setIdproducto(cod);
                        v.setDescripcionp(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cant);
                        v.setSubtotal(subtotal);
                        lista.add(v);
                        for (int i = 0; i < lista.size(); i++) {
                            totalpagar=totalpagar+lista.get(i).getSubtotal();  
                        }
                        request.setAttribute("nserie", numeroserie);
                        request.setAttribute("totalpagar", totalpagar);
                        request.setAttribute("lista", lista);
                        break;
                    case "GenerarVenta":
                        for (int i = 0; i < lista.size(); i++) {
                            Producto pr=new Producto();
                            int cantidad=lista.get(i).getCantidad();
                            int idproducto=lista.get(i).getIdproducto();
                            ProductoDAO aO=new ProductoDAO();
                            pr=aO.buscar(idproducto);
                            int sac=pr.getStock()-cantidad;
                            aO.actualizarStock(idproducto, sac);
                        }
                        v.setIdcliente(cl.getId());
                        v.setIdempleado(2);
                        v.setNserie(numeroserie);
                        v.setFecha("2019-06-14");
                        v.setMonto(totalpagar);
                        v.setEstado("1");
                        vdao.guardarVenta(v);
                        int idv=Integer.parseInt(vdao.idVentas());
                        for (int i = 0; i < lista.size(); i++) {
                            v=new Venta();
                            v.setId(idv);
                            v.setIdproducto(lista.get(i).getIdproducto());
                            v.setCantidad(lista.get(i).getCantidad());
                            v.setPrecio(lista.get(i).getPrecio());
                            vdao.guardarDetalleVentas(v);
                        }
                        break;
                    default:
                        v=new Venta();
                        lista=new ArrayList<>();
                        item=0;
                        totalpagar=0.0;
                           numeroserie = vdao.generarSerie();
                        if (numeroserie==null) {
                            
                            numeroserie="00000001";
                            request.setAttribute("nserie", numeroserie);
                        }
                        else{
                            int incrementar=Integer.parseInt(numeroserie);
                            GenerarSerie gs=new GenerarSerie();
                            numeroserie=gs.NumeroSerie(incrementar);
                            request.setAttribute("nserie", numeroserie);
                        }
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);                     
                }
                
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
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
