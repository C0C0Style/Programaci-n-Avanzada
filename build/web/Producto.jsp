<%-- 
    Document   : Producto
    Created on : 8/10/2023, 6:27:21 p. m.
    Author     : torre
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Coco</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  </head>
  <body>
   <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <form action="Controlador?menu=Producto" method="POST">
                            <div class="form-group mb-3">
                                <label>Nombres</label>
                                <input type="text" value="${producto.getNom()}" name="txtNombres" class="form-control">
                            </div>
                            <div class="form-group mb-3">
                                <label>Precios</label>
                                <input type="text" value="${producto.getPrecio()}" name="txtPrecios" class="form-control">
                            </div>
                            <div class="form-group mb-3">
                                <label>Stock</label>
                                <input type="text" value="${producto.getStock()}" name="txtStock" class="form-control">
                            </div>
                            <div class="form-group mb-3">
                                <label>Estado</label>
                                <input type="text" value="${producto.getEstado()}" name="txtEstado" class="form-control">
                            </div>
                            <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRES</th>
                            <th>PRECIO</th>
                            <th>STOCK</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pr" items="${productos}">
                            <tr>
                                <td>${pr.getId()}</td>
                                <td>${pr.getNom()}</td>
                                <td>${pr.getPrecio()}</td>
                                <td>${pr.getStock()}</td>
                                <td>${pr.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pr.getId()}"> Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${pr.getId()}">Delete</a> 
                                </td>
                            </tr>
                       </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
