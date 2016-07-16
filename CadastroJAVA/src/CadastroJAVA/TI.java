package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
public class TI extends JFrame{
	JLabel mens0 = new JLabel("Escolha uma das subdivisoes de T.I.");
	JButton suporte, redes, desenv, voltar;
	Handler listener = new Handler();
	TI(){
		super("Cadastro TI");
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(300,300);		
				
		suporte = new JButton("SUPORTE");
		desenv = new JButton("DESENVOLVIMENTO");
		redes = new JButton("REDES");
		voltar = new JButton("VOLTAR");
		
		suporte.addActionListener(listener);
		redes.addActionListener(listener);
		desenv.addActionListener(listener);
		voltar.addActionListener(listener);
		
		add(mens0);
		add(suporte);
	    add(redes);
	    add(desenv);
	    add(voltar);
	}
	
	private class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==suporte){
				new Suporte();
			}
			if(evento.getSource()==desenv){
				JOptionPane.showMessageDialog(null, "Falta implementar esta classe");
			}
			if(evento.getSource()==redes){
				JOptionPane.showMessageDialog(null, "Falta implementar esta classe");
			}
			if(evento.getSource()==voltar){
				//Index.montar(true);
			}
		}
		
	}
	
}
