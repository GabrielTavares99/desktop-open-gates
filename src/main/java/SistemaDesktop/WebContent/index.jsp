<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Gerenciador de empresas</title>
    <style>
        <%@ include file="WEB-INF/paginas/estilo.css"%>
    </style>
</head>
<body>

<h1>OPEN GATES</h1>
<c:choose>
    <c:when test="${request.getParameter('badCredentials')==true}">
        BAD CREDENTIALS
        ${request.getParameter('badCredentials') = false}
        <br />
    </c:when>
    <c:otherwise>
        pizzas.
        <br />
    </c:otherwise>
</c:choose>
<img src="images/open-gates-logo.png">
<form action="login?tarefa=FazerLogin" method="post">
    Email: <input type="text" name="email">
    <a href="redefinicao-senha?service=form-envio-email-redefinicao">Esqueci minha senha!</a>
    Senha: <input type="text" name="senha">
    <input type="submit" value="Entrar">
</form>
</body>
</html>