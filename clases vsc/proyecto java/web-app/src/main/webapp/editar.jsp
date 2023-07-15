<%@ page import="ar.com.codoacodo23069.Producto" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="styles.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <section>
                    <h1>Editar Articulo</h1>
                    <% 
                    //bajo el dato del request, que guardo el controller
                    Producto producto = (Producto)request.getAttribute("producto");
                    %>
                    <form method="post" action="<%=request.getContextPath()%>/EditarController?id=<%=producto.getId()%>">
                        <div class="mb-3">
                            <label for="nombre" 
                                class="form-label">Nombre</label>
                            <input name="nombre" 
                                type="text" 
                                class="form-control" 
                                id="nombre"
                                placeholder="Nombre"
                                maxlength="50">
                        </div>
                        <div class="mb-3">
                            <label for="precio" 
                                class="form-label">Precio
                            </label>
                            <input name="precio" 
                                type="number" 
                                class="form-control" 
                                id="precio">
                        </div>
                        <!-- <div class="mb-3">
                            <label for="imagen" 
                                class="form-label">Imagen
                            </label>
                            <input name="imagen" 
                                type="text" 
                                class="form-control" 
                                id="imagen">
                        </div> -->
                        <!-- <div class="mb-3">
                            <label for="codigo" 
                                class="form-label">Codigo
                            </label>
                            <input name="codigo" 
                                type="text" 
                                class="form-control" 
                                id="codigo" 
                                maxlength="7">
                        </div> -->
                        <div class="mb-3">
                            <label for="autor" 
                                class="form-label">Autor
                            </label>
                            <input name="autor" 
                                type="text" 
                                class="form-control" 
                                id="autor" 
                                maxlength="50">
                        </div>
                        <!-- <div class="mb-3">
                            <label for="autor" 
                                class="form-label">Fecha
                            </label>
                            <input name="fecha" 
                                type="text" 
                                class="form-control" 
                                id="autor" 
                                maxlength="50">
                        </div> -->
                        <button class="btn btn-primary">
                            Editar
                        </button>
                    </form>
                </section>
            </div>
        </div>
        <jsp:include page="scripts.jsp"></jsp:include>
</body>

</html>