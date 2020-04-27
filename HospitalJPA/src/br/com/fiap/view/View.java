package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.dao.HospitalDAO;
import br.com.fiap.dao.impl.FuncionarioDAOImpl;
import br.com.fiap.dao.impl.HospitalDAOImpl;
import br.com.fiap.entities.Endereco;
import br.com.fiap.entities.Especialidade;
import br.com.fiap.entities.Funcionario;
import br.com.fiap.entities.Genero;
import br.com.fiap.entities.Hospital;
import br.com.fiap.entities.Paciente;

public class View {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
		EntityManager manager = factory.createEntityManager(); 
		
		HospitalDAO dao = new HospitalDAOImpl(manager);
		
		
		Endereco endereco = new Endereco(06756000, "Rua Equador, 90");
		
		Hospital hospital = new Hospital(123456, "Hospital X", Especialidade.GERAL, endereco);
		
		List<Paciente> pac = new ArrayList<Paciente>();
		pac.add(new Paciente(654321, "Lana Lopes", Genero.FEMININO, Calendar.getInstance(), null));
		pac.add(new Paciente(172345, "Ian Almeida", Genero.MASCULINO, 
				new GregorianCalendar(2018, Calendar.APRIL, 10), new GregorianCalendar(2018, Calendar.MAY, 10) ));
		pac.add(new Paciente(921654, "Rebecca Freitas", Genero.FEMININO, Calendar.getInstance(), null));
		
		Funcionario func = new Funcionario(12345678, "Celia Santos", 
				new GregorianCalendar(2010, Calendar.JANUARY, 20), Genero.FEMININO, "Neurocirgurgiã", 15.000, pac); 		
				
//		hospital.addFunc(new Funcionario(12345678, "Celia Santos", 
//				new GregorianCalendar(2010, Calendar.JANUARY, 20), Genero.FEMININO, "Neurocirgurgiã", 15.000, func.getPaciente()));
//
//		hospital.addFunc(new Funcionario(12345678, "Ana Almeida", 
//				new GregorianCalendar(2015, Calendar.NOVEMBER, 05), Genero.FEMININO, "Cardiologista", 10.000));
		hospital.addFunc(func);
		
		
		
		try {
			dao.create(hospital);
			dao.commit();
			System.out.println("Cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar!");
		}
		
		manager.close();
		factory.close();
	}

}
