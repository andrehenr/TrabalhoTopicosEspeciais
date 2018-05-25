package dao;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import factory.FabricaDeConexao;
import model.Equipamento;

public class EquipamentoDAO {
	public void cadastrar(Equipamento eq){
		String cmd = "INSERT into equipamentos (nome,tipo,peso) VALUES(? ,? ,?)";
		try(Connection connection = FabricaDeConexao.getConnection();
			PreparedStatement st = connection.prepareStatement(cmd);){
			st.setString(1, (new String(eq.getNome().getBytes("ISO-8859-1"),"UTF-8")));
			st.setString(2, (new String(eq.getTipo().getBytes("ISO-8859-1"),"UTF-8")));
			st.setDouble(3, eq.getPeso());
			st.execute();
			String cmd2 = "SELECT LAST_INSERT_ID() AS id";
			PreparedStatement st2 = connection.prepareStatement(cmd2);
			ResultSet rs = st2.executeQuery();
			if(rs.next()){
				eq.setId(rs.getInt("id"));
			}
			
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public List<Equipamento> listar(){
		String cmd = "SELECT * FROM equipamentos";
		List<Equipamento> lista = new LinkedList<>();
		try(Connection connection = FabricaDeConexao.getConnection();
			PreparedStatement st = connection.prepareStatement(cmd);){
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Equipamento eq = new Equipamento();
				eq.setId(rs.getInt("id"));
				eq.setNome(rs.getString("nome"));
				eq.setTipo(rs.getString("tipo"));
				eq.setPeso(rs.getDouble("peso"));
				lista.add(eq);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
