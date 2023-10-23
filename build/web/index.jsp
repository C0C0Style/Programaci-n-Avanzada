<%-- 
    Document   : index
    Created on : 8/10/2023, 12:40:42 p. m.
    Author     : torre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4 col-lg-4">
    <div class="card col-sm-10">
        <div class="card-body">
            <form class="form-sign" action="Validar" method="POST">
                <div class="form-group text-center mb-4">
                    <h3>Login</h3>
                    <img src="img/Logo.png" alt="70" width="250"/>
                    <label class="mt-2">Bienvenidos al sistema</label>
                </div>
                <div class="form-group mb-3">
                    <label>Usuario:</label>
                    <input type="text" name="txtuser" class="form-control">
                </div>
                <div class="form-group mb-3">
                    <label>Password:</label>
                    <input type="password" name="txtpass" class="form-control">
                </div>
                <div class="d-grid gap-2">
                    <input type="submit" name="accion" value="Ingresar" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>

