package CadastroJAVA;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Consulta_Index extends JFrame{
	private JLabel mens0;
	private JButton ti, rh, adm, fin;
	private Handler listener = new Handler();
	protected Consulta_Index(){
		setTitle("Consulta");
		setSize(300,300);
		setVisible(true);
		setResizable(false);
		setLayout(new FlowLayout());
		
		mens0 = new JLabel("Escolha abaixo o profissional a ser consultado");
		ti = new JButton("T.I.");
		rh = new JButton("R.H");
		fin = new JButton("FINANCEIRO");
		adm = new JButton("ADMINISTRATIVO");
		
		ti.addActionListener(listener);
		rh.addActionListener(listener);
		fin.addActionListener(listener);
		adm.addActionListener(listener);
		
		add(mens0);
		add(ti);
		add(rh);
		add(fin);
		add(adm);
	}
	
	private class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==ti){
				new Consulta_TI();
			}
			if(evento.getSource()==rh){
				JOptionPane.showMessageDialog(null, "Classe nao implementada");
			}
			if(evento.getSource()==fin){
				JOptionPane.showMessageDialog(null, "Classe nao implementada");
			}
			if(evento.getSource()==adm){
				JOptionPane.showMessageDialog(null, "Classe nao implementada");
			}
		}		
	}	
}
