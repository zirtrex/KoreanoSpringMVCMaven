<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Agregar Equipo</title>
        <link rel="stylesheet" href="<c:url value='/css/uikit.min.css'/>" />
        <script src="<c:url value='/js/uikit.min.js'/>"></script>
        <script src="<c:url value='/js/uikit-icons.min.js'/>"></script>     
    </head>
    <body>
        <div class="uk-container uk-container-expand">
            <h1 class="uk-text-primary uk-margin-top uk-margin-bottom">Agregar equipo</h1>
            <a href = "<c:url value = "index.htm"/>">volver</a>
            <hr/>
            <c:if test="${message ne null }">
                <div class="uk-alert-danger" uk-alert>
                    <c:out value = "${message}"/>
                </div>
            </c:if>
            <form:form action="procesar-equipo.htm"  commandName="equipo" modelAttribute="equipo" cssClass="uk-form-stacked">
                <div class="uk-margin">
                    <form:label path="nombre">Nombre: </form:label> 
                    <div class="uk-form-controls">
                        <form:input path="nombre" cssClass="uk-input" />
                        <form:errors path="nombre" element="div" cssClass="uk-alert-danger" />
                    </div>
                </div>
		<div class="uk-margin">
                    <form:label path="marca">Marca: </form:label>
                    <div class="uk-form-controls">
                        <form:input path="marca" cssClass="uk-input"/>
                        <form:errors path="marca" element="div" cssClass="uk-alert-danger"/>
                    </div>
                </div>
                <div class="uk-margin">
                    <form:label path="marca">Modelo: </form:label>
                    <div class="uk-form-controls">
                        <form:input path="modelo" cssClass="uk-input"/>
                        <form:errors path="modelo" element="div" cssClass="uk-alert-danger"/>
                    </div>
                </div>
                <div>
                    <form:button name="submit" type="submit" class="uk-button uk-button-primary">Guardar</form:button>
                </div>                
            </form:form>
            <c:if test="${equipoIn ne null }">
                <p>Nombre:  <c:out value = "${equipoIn.nombre}"/><p>
                <p>Marca  <c:out value = "${equipoIn.marca}"/><p>
                <p>Modelo  <c:out value = "${equipoIn.modelo}"/><p>
            </c:if>
        </div>       
    </body>
</html>