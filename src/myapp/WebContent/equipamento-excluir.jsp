<%
    String id = request.getParameter("id");
    EquipamentoDAO dao = new EquipamentoDAO();
    try {
        dao.excluir(Long.parseLong(id)); // Exclui o equipamento do banco
        response.sendRedirect("equipamento-listar.jsp"); // Redireciona para a listagem
    } catch (Exception e) {
        e.printStackTrace();
    }
%>