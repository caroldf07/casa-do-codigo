<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${not empty empresa }">
Empresa ${ empresa } cadastrada com sucesso!
</c:if>
	<br> Lista de empresas:
	<br>
	<ul>
		<c:forEach items="${empresas }" var="empresa">
			<li>${empresa.nome }-criada em: <fmt:formatDate
					pattern="dd/MMM/yyyy" value="${empresa.dataCriacao }" /> <a
				href="/gerenciador/mostraEmpresa?id=${empresa.id }">alterar</a> <a
				href="/gerenciador/removeEmpresa?id=${empresa.id }">deletar</a>
			</li>
		</c:forEach>

	</ul>

</body>
</html>