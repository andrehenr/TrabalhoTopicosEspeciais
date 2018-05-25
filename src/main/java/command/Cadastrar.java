package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Equipamento;
import service.EquipamentoService;

public class Cadastrar implements Command {

	@Override
	public void go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		EquipamentoService es = new EquipamentoService();

		Equipamento eq = new Equipamento();
		eq.setNome(request.getParameter("nome"));
		eq.setTipo(request.getParameter("tipo"));
		eq.setPeso(Double.parseDouble(request.getParameter("peso")));
		es.criar(eq);
		request.setAttribute("equipamento", eq);
		RequestDispatcher rd = request.getRequestDispatcher("ExibeEquipamentoCadastrado.jsp");
		rd.forward(request, response);

	}

}
