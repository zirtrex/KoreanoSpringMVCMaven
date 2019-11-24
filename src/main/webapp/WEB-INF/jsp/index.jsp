<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipos</title>
        <link rel="stylesheet" href="<c:url value='/css/uikit.min.css'/>" />
        <script src="<c:url value='/js/uikit.min.js'/>"></script>
        <script src="<c:url value='/js/uikit-icons.min.js'/>"></script>
    </head>

    <body>
        <div class="uk-container uk-container-expand uk-margin-bottom">
            <h1 class="uk-text-primary uk-margin-top uk-margin-bottom">Listado de equipos</h1>
            <a id="agregar" href="<c:url value = "agregar-equipo.htm"/>" class="uk-button uk-button-default"><span uk-icon="plus"></span>Agregar Equipo</a>
            <hr/>
            <table class="uk-table uk-table-divider uk-table-striped uk-table-hover">
                <thead>
                    <tr>
                        <th>codEquipo</th>
                        <th>nombre</th>
                        <th>marca</th>
                        <th>modelo</th>
                        <th>placa</th>
                        <th>categoria</th>
                        <th>&nbsp;</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${equipos}" var="equipo">
                    <tr>
                        <td><c:out value="${equipo.codEquipo}"/></td>
                        <td><c:out value="${equipo.nombre}"/></td>
                        <td><c:out value="${equipo.marca}"/></td>
                        <td><c:out value="${equipo.modelo}"/></td>
                        <td><c:out value="${equipo.placa}"/></td>
                        <td><c:out value="${equipo.horometro}"/></td>
                        <td>
                            <a href="<c:url value="editar-equipo.htm?codEquipo=${equipo.codEquipo}"/>"><span uk-icon="pencil"></span>Editar</a>
                            <a href="<c:url value="eliminar-equipo.htm?codEquipo=${equipo.codEquipo}"/>"><span uk-icon="trash"></span>Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
