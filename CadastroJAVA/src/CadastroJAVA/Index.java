package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class Index extends JFrame{
	JLabel mens0 = new JLabel("Escolha abaixo o profissional a ser cadastrado");
	JButton ti = new JButton("T.I.");
	JButton rh = new JButton("R.H.");
	JButton fin = new JButton("FINANCEIRO");
	JButton admin = new JButton("ADINISTRATIVO");
	Handler listener = new Handler(); 
	
	Index(){		
		super("Cadastro");
		setLayout(new FlowLayout());
		setSize(300,300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(Index.EXIT_ON_CLOSE);
		
		ti.addActionListener(listener);
		admin.addActionListener(listener);
		fin.addActionListener(listener);
		rh.addActionListener(listener);
		
		add(mens0);
		add(ti);
		add(rh);
		add(fin);
		add(admin);
	}
	
	private class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==ti){
				new TI();
				//hab_des(false);
			}
			if(evento.getSource()==rh){
				JOptionPane.showMessageDialog(null, "Falta implementar esta classe");
			}
			if(evento.getSource()==fin){
				JOptionPane.showMessageDialog(null, "Falta implementar esta classe");
			}
			if(evento.getSource()==admin){
				new ADM();
			}
		}		
	}
	
	public void hab_des(boolean x){
		setEnabled(x);
	}
	
}
