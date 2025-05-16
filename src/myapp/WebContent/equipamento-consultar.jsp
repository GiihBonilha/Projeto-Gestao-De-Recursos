<%
    String id = request.getParameter("id");
    Equipamento equipamento = new Equipamento();
    EquipamentoDAO dao = new EquipamentoDAO();
    equipamento = dao.consultar(Long.parseLong(id));  // Chama o método para consultar um equipamento

    if (equipamento != null) {
%>
    <h1>Detalhes do Equipamento</h1>
    <p>Número de Tombo: <%= equipamento.getNumeroTombo() %></p>
    <p>Equipamento: <%= equipamento.getEquipamento() %></p>
    <p>Marca: <%= equipamento.getMarca() %></p>
    <p>Modelo: <%= equipamento.getModelo() %></p>
<%  } else { %>
    <p>Equipamento não encontrado.</p>
<% } %>