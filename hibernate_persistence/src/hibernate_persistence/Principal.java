package hibernate_persistence;


import dao.ContatoDAO;
import dao.ContatoJPADAO;
import dao.DisciplinaDAO;
import dao.DisciplinaJPADAO;

public class Principal {
	public static void main(String[] args) {
		ContatoDAO cDao = new ContatoJPADAO();
		DisciplinaDAO dDao = new DisciplinaJPADAO();
		//TelefoneDAO tDao = new TelefoneJPADAO();
		//EnderecoDAO eDao = new EnderecoJPADAO();
		
		Aluno a1 = new Aluno(0, "sergio", "sergio@gmail.com", null, null, "111");
		Aluno a2 = new Aluno(0, "maike", "maike@gmail.com", null, null, "1");
		Aluno a3 = new Aluno(0, "yago", "yago@gmail.com", null, null, "3");
		
		Disciplina d1 = new Disciplina(0, "paa", 64);
		Disciplina d2 = new Disciplina(0, "persistencia", 64);
		Disciplina d3 = new Disciplina(0, "automatos", 64);
		
		a1.getDisciplinas().add(d1);
		a1.getDisciplinas().add(d2);
		a1.getDisciplinas().add(d3);
		d1.getAlunos().add(a1);
		d1.getAlunos().add(a2);
		d1.getAlunos().add(a3);
		
		cDao.beginTransaction();
		cDao.save(a1);
		
		dDao.beginTransaction();
		dDao.save(d1);
		
		
		
//		Contato c = new Contato("Rodrigo", "rodrilindo@hothot.com", null, new ArrayList<>());
//		cDao.beginTransaction();
//		cDao.save(c);
//		cDao.commit();
//		
//		c.getTelefones().add(new Telefone("88", "123456789", c));
//		c.getTelefones().add(new Telefone("11", "123456789", c));
//		c.getTelefones().add(new Telefone("13", "123456789", c));
//		c.getTelefones().add(new Telefone("77", "123456789", c));
//		c.getTelefones().add(new Telefone("21", "123456789", c));
//		
//		cDao.beginTransaction();
//		cDao.save(c);
//		cDao.commit();
//		
//		Endereco end = new Endereco("Rua 75", 75, null);
//		Contato cont = new Contato("Anderson", "andin@gmail.com", end, new ArrayList<>());
//		end.setContato(cont);
//		
//		cDao.beginTransaction();
//		cDao.save(cont);
//		cDao.commit();
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction = manager.getTransaction();
//		try {
//			transaction.begin();
//			manager.persist(new Contato("Anderson", "a_hto@hotline.com"));
//			manager.persist(new Contato("Isaac", "isaacdasgatinhas@yahoo.com.br"));
//			manager.persist(new Contato("Wendell", "wendell@gmail.com"));
//			transaction.commit();
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//		}finally {
//			manager.close();
//		}
	}
}