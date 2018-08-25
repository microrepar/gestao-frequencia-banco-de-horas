package les22018.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les22018.core.util.ConnectionFactory;
import les22018.dominio.EntidadeDominio;
import les22018.dominio.Funcionario;
import les22018.dominio.Jornada;

public class DAOFuncionario implements IDAO {

	@Override
	public void salvar(EntidadeDominio entidade) {
		System.out.println("chamada de DAO");
		
		//cast da Peça
		Funcionario f = (Funcionario) entidade;
        
        //fazendo conexão com Factory
        Connection con = ConnectionFactory.getConnection();
        //criando statemment
        PreparedStatement stmt = null;
        //comando SQL a ser feito
        String sql = "INSERT INTO funcionario(fun_nome,fun_matricula,fun_pisPasep,fun_cargo) VALUES(?,?,?,?)";
        //determinando valores a serem encontrados no banco de dados
        try {
            //comando inserido no SGBD
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setLong(2, f.getMatricula());
            stmt.setString(3, f.getPisPasep());
            stmt.setString(4, f.getCargo());
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
        List<EntidadeDominio> funcionarios = new ArrayList<>();
        //cast de Peca
        Funcionario f = (Funcionario) entidade;
        //comando SQL a ser feito
        String sql = "SELECT * FROM funcionario WHERE fun_cargo = ?";
        try {
            //comando inserido no SGBD
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getCargo());
            
            rs = stmt.executeQuery();
            //lendo vários dados
            while (rs.next()) {
            	f = new Funcionario();
            	f.setNome(rs.getString("fun_nome"));
            	f.setMatricula(rs.getLong("fun_matricula"));
            	f.setPisPasep(rs.getString("fun_pisPasep"));
            	f.setCargo(rs.getString("fun_cargo"));
                funcionarios.add(f);
                
            }
        } catch (SQLException ex) {
            System.out.println("falha de leitura");
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        //retornando dados lidos
        return funcionarios;
	}

	@Override
	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}

}
