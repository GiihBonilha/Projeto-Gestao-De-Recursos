<%
    String id = request.getParameter("id");
    EquipamentoDAO dao = new EquipamentoDAO();
    Equipamento equipamento = dao.consultar(Long.parseLong(id));

    if (equipamento != null) {
%>
    <form method="POST" action="equipamento-alterar-servlet">
        <input type="hidden" name="id" value="<%= equipamento.getId() %>">
        <div>
            <label for="numeroTombo">Número de Tombo</label>
            <input type="text" id="numeroTombo" name="numeroTombo" value="<%= equipamento.getNumeroTombo() %>" required>
        </div>
        <div>
            <label for="equipamento">Equipamento</label>
            <input type="text" id="equipamento" name="equipamento" value="<%= equipamento.getEquipamento() %>" required>
        </div>
        <div>
            <label for="marca">Marca</label>
            <input type="text" id="marca" name="marca" value="<%= equipamento.getMarca() %>" required>
        </div>
        <div>
            <label for="modelo">Modelo</label>
            <input type="text" id="modelo" name="modelo" value="<%= equipamento.getModelo() %>" required>
        </div>
        <button type="submit">Alterar</button>
    </form>
<% } else { %>
    <p>Equipamento não encontrado.</p>
<% } %>