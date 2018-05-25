package service;

import java.util.List;

import dao.EquipamentoDAO;
import model.Equipamento;

public class EquipamentoService {
	
	EquipamentoDAO ed = new EquipamentoDAO();

	public void criar(Equipamento eq){
		ed.cadastrar(eq);
	}
	
	public List<Equipamento> listar(){
		return ed.listar();
	}

}
