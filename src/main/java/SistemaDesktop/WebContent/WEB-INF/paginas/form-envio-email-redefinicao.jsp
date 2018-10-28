<%--
  Created by IntelliJ IDEA.
  User: gabriel
  Date: 28/10/18
  Time: 03:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Redefinição de Senha</h1>
<h2>BLA BLÁ BLÁ BLÁ</h2>
    <form action="redefinicao-senha?tarefa=EnviarEmailCodigoRedefinicao" method="post">
        <label>EMAIL*</label>
        <input type="email" name="email">
        <input type="submit" value="Enviar Código">
        <form action="/" method="get">
            <input type="submit" value="Cancelar">
        </form>
    </form>

</body>
</html>
