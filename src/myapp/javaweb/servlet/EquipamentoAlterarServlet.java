package myapp.servlet;

import myapp.dao.EquipamentoDAO;
import myapp.model.Equipamento;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EquipamentoAlterarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String numeroTombo = request.getParameter("numeroTombo");
        String equipamento = request.getParameter("equipamento");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");

        Equipamento equipamentoAlterado = new Equipamento();
        equipamentoAlterado.setId(id);
        equipamentoAlterado.setNumeroTombo(numeroTombo);
        equipamentoAlterado.setEquipamento(equipamento);
        equipamentoAlterado.setMarca(marca);
        equipamentoAlterado.setModelo(modelo);

        try {
            EquipamentoDAO dao = new EquipamentoDAO();
            dao.alterar(equipamentoAlterado);  // Chama o método para alterar o equipamento no banco
            response.sendRedirect("equipamento-listar.jsp");  // Redireciona para a página de listagem
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
