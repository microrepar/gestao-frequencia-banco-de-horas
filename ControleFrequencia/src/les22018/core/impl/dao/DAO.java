package les22018.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les22018.core.util.ConnectionFactory;
import les22018.dominio.EntidadeDominio;
import les22018.dominio.Jornada;

public class DAO implements IDAO {

	@Override
	public void salvar(EntidadeDominio entidade) {
		System.out.println("chamada de DAO");
		
		//cast da Peça
        Jornada j = (Jornada) entidade;
        //fazendo conexão com Factory
        Connection con = ConnectionFactory.getConnection();
        //criando statemment
        PreparedStatement stmt = null;
        //comando SQL a ser feito
        String sql = "INSERT INTO jornada(cargaHoraria) VALUES(?)";
        //determinando valores a serem encontrados no banco de dados
        try {
            //comando inserido no SGBD
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, j.getCargaHoraria());
            stmt.executeUpdate();
            System.out.println("Salvo com sucesso");
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
            //JOptionPane.showMessageDialog(null, "Erro ao salvar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		//fazendo conexão com Factory
        Connection con = ConnectionFactory.getConnection();
        //criando statemment
        PreparedStatement stmt = null;
        //criando result de dados obtidos de banco de dados
        ResultSet rs = null;
        //criando list de dados lidos
        List<EntidadeDominio> jornadas = new ArrayList<>();
        //cast de Peca
        Jornada j = (Jornada) entidade;
        //comando SQL a ser feito
        String sql = "SELECT * FROM jornada WHERE idJornada = ?";
        try {
            //comando inserido no SGBD
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Integer.toString(j.getId()));
            
            rs = stmt.executeQuery();
            //lendo vários dados
            while (rs.next()) {
                j = new Jornada();
                j.setId(rs.getInt("idJornada"));
                j.setCargaHoraria(rs.getDouble("cargaHoraria"));
                System.out.println("id: "+j.getId()+" jornada: "+ j.getCargaHoraria());
                jornadas.add(j);
            }
        } catch (SQLException ex) {
            System.out.println("falha de leitura");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        //retornando dados lidos
        return jornadas;
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

}
