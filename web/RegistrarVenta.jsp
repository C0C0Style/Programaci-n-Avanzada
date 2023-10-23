<%-- 
    Document   : RegistrarVenta
    Created on : 8/10/2023, 6:27:40 p. m.
    Author     : torre
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>VENTAS</title>
    <style>
        @media print{
            .parte01,.btn,.accion{
                display: none;
            }
        }
    </style>
  </head>
  <body>
      <div class="d-flex">
          <div class="col-lg-4-5 parte01">
              <div class="card">
                  <form action="Controlador?menu=NuevaVenta" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos del Cliente</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="Codigo">
                                <input type="submit" name="accion" value="Buscar Cliente" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombresclientes" value="${c.getNom()}" class="form-control" placeholder="Nombre Cliente">
                            </div>    
                        </div>
                        <div class="form-group">
                            <label>Datos Productos</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="codigoproducto" value="${producto.getId()}" class="form-control" placeholder="Codigo" >
                                <input type="submit" name="accion" value="Buscar Producto" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombproducto" value="${producto.getNom()}" class="form-control" placeholder="Datos Producto" class="form-control">
                            </div>    
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6 d-flex">
                                <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="$/.0.00" >

                            </div>
                            <div class="col-sm-3">
                                <input type="number" name="cant" value="1" class="form-control" placeholder="" class="form-control">
                            </div> 
                            <div class="col-sm-3">
                                <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock" class="form-control">
                            </div> 
                        </div>
                        <div class="form-group">
                            <input type="submit" name="accion" value="Agregar" class="btn btn-outline-info">
                        </div>
                    </div>
                  </form>
              </div>
          </div>
          <div class="col-sm-7">
              <div class="card">
                  <div class="card-body">
                      <div class="d-flex col-sm-5 ml-auto">
                          <label>No.Serie: </label>
                        <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                      </div>
                      <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lista" items="${lista}">
                                    <tr>
                                        <td>${lista.getItem()}</td>
                                        <td>${lista.getIdproducto()}</td>
                                        <td>${lista.getDescripcionp()}</td>
                                        <td>${lista.getPrecio()}</td>
                                        <td>${lista.getCantidad()}</td>
                                        <td>${lista.getSubtotal()}</td>
                                        <td class="d-flex">
                                            <a class="btn btn-warning" href="#"> Editar</a>
                                            <a class="btn btn-danger" href="#" style="margin-left: 10px">Delete</a> 
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                  </div>
                  <div class="card-footer d-flex">
                      <div class="col-sm-6">
                          <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()"class="btn btn-success">Generar Venta</a>
                          <a href="Controlador?menu=NuevaVenta&accion=default" class="btn btn-danger">Cancelar</a>   
                      </div>
                      <div class="col-sm-3 ml-auto">
                        <input type="text" name="txtTotal" value="$. ${totalpagar}0" class="form-control">
                      </div>
                  </div>
                  
              </div>
              
          </div>
      </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>
