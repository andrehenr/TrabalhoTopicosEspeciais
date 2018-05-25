package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Equipamento;
import service.EquipamentoService;

public class Listar implements Command {

	@Override
	public void go(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EquipamentoService es = new EquipamentoService();
		List<Equipamento> listaequipamentos = es.listar();
		request.setAttribute("lista",listaequipamentos);
		RequestDispatcher rd = request.getRequestDispatcher("ListarEquipamentos.jsp");
		rd.forward(request, response);
		
	}

	

}
