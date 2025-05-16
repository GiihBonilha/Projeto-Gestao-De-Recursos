package myapp.javaweb.servlet;

import myapp.dao.EquipamentoDAO;
import myapp.model.Equipamento;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EquipamentoCadastrarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numeroTombo = request.getParameter("numeroTombo");
        String equipamento = request.getParameter("equipamento");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");

        Equipamento novoEquipamento = new Equipamento();
        novoEquipamento.setNumeroTombo(numeroTombo);
        novoEquipamento.setEquipamento(equipamento);
        novoEquipamento.setMarca(marca);
        novoEquipamento.setModelo(modelo);

        try {
            EquipamentoDAO dao = new EquipamentoDAO();
            dao.inserir(novoEquipamento);  // Chama o método do DAO para inserir no banco
            response.sendRedirect("equipamento-listar.jsp");  // Redireciona para a página de listagem após salvar
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}