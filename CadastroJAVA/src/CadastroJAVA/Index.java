package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class Index extends JFrame{
	private JLabel mens0 = new JLabel("Escolha abaixo o profissional a ser cadastrado");
	private JButton ti, rh, fin, admin;
	private Handler listener = new Handler(); 
	
	protected Index(){		
		super("Cadastro");
		setLayout(new FlowLayout());
		setSize(300,300);
		setVisible(true);
		setResizable(false);
		
		ti = new JButton("T.I.");
		rh = new JButton("R.H.");
		fin = new JButton("FINANCEIRO");
		admin = new JButton("ADMINISTRATIVO");
				
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
}
