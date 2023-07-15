<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="styles.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div>
        <h1>Bienvenido</h1>
        <div class="d-grid gap-2 col-6 mx-auto">
            <button class="btn btn-lg btn-primary" type="button"><a href="/web-app/nuevo.jsp">Nuevo Producto</a></button>

            <button class="btn btn-lg btn-primary" type="button"><a href="/web-app/ListadoProductosController">Listado de Productos</a></button>
          </div>
    </div>

    <jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>