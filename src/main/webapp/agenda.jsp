<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="model.JavaBeans"%>
 <%@ page import="java.util.ArrayList"%>
<%
  ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>)
  request.getAttribute("contatos");
for(int i=0; i<lista.size(); i++){
	out.println(lista.get(i).getIdcon());
	out.println(lista.get(i).getNome());
	out.println(lista.get(i).getFone());
	out.println(lista.get(i).getEmail());
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="styles.css">
</head>
<body>
<h1>Agenda de contatos</h1>
<a href="novo.html" class="botao1">Novo Contato</a>
</body>
</html>