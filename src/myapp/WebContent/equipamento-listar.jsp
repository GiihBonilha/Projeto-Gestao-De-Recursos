<table>
    <thead>
        <tr>
            <th>Número de Tombo</th>
            <th>Equipamento</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Ações</th>
        </tr>
    </thead>
    <tbody>
        <%
            EquipamentoDAO dao = new EquipamentoDAO();
            List<Equipamento> equipamentos = dao.listar(); // Chama o método do DAO
            for (Equipamento equipamento : equipamentos) {
        %>
        <tr>
            <td><%= equipamento.getNumeroTombo() %></td>
            <td><%= equipamento.getEquipamento() %></td>
            <td><%= equipamento.getMarca() %></td>
            <td><%= equipamento.getModelo() %></td>
            <td>
                <a href="equipamento-consultar.jsp?id=<%= equipamento.getId() %>">Consultar</a>
                <a href="equipamento-alterar.jsp?id=<%= equipamento.getId() %>">Alterar</a>
                <a href="equipamento-excluir.jsp?id=<%= equipamento.getId() %>">Excluir</a>
            </td>
        </tr>
        <% } %>
    </tbody>
</table>