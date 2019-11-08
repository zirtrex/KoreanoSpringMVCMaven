<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Eliminar Equipo</title>
        <link rel="stylesheet" href="<c:url value='/css/uikit.min.css'/>" />
        <script src="<c:url value='/js/uikit.min.js'/>"></script>
        <script src="<c:url value='/js/uikit-icons.min.js'/>"></script>     
    </head>
    <body>
        <div class="uk-container uk-container-expand">
            <h1 class="uk-text-primary uk-margin-top uk-margin-bottom">Eliminar equipo</h1>
            <a href = "<c:url value = "index.htm"/>">volver</a>
            <hr/>
            <c:if test="${message ne null }">
                <div class="uk-alert-danger" uk-alert>
                    <c:out value = "${message}"/>
                </div>
            </c:if>
            <c:if test="${message eq null }">
                <form:form action="eliminar-equipo.htm"  commandName="equipo" modelAttribute="equipo" cssClass="uk-form-stacked">
                    <form:errors path="*" element="div" cssClass="uk-alert uk-alert-danger" />
                    <div class="uk-margin">
                        <div class="uk-form-controls">
                            <form:hidden path="codEquipo" cssClass="uk-input" />
                            <form:errors path="codEquipo" element="div" cssClass="uk-alert-danger" />
                        </div>
                    </div>

                    <div class="uk-margin">
                        <p>Esta seguro de eliminar el equipo con id: <c:out value="${equipo.codEquipo}" /> </p>
                    </div>
                    <div>
                        <form:button name="submit" type="submit" class="uk-button uk-button-danger">Eliminar</form:button>
                    </div>                
                </form:form>
            </c:if>
        </div>       
    </body>
</html>