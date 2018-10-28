<%--
  Created by IntelliJ IDEA.
  User: gabriel
  Date: 28/10/18
  Time: 02:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Redefinição de Senha</h1>
<form action="redefinicao-senha?tarefa=RedefinirSenha" method="post">
    <label>Senha Atual</label>
    <input type="password" name="senhaAtual">
    <label>Nova Senha</label>
    <input type="password" name="novaSenha">
    <label>Repita nova senha</label>
    <input type="password" name="novaSenhaConfirmacao">
    <input type="submit" value="Redefinir">
</form>
</body>
</html>
