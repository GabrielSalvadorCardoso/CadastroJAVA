package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Principal extends JFrame{
	private JButton cons, cad;
	private JLabel mens0 = new JLabel("Informe abaixo o que deseja fazer");
	private Handler listener = new Handler();
	protected Principal(){
		super("CadastroJAVA");
		setSize(300,300);
		setVisible(true);
		setResizable(false);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(Index.EXIT_ON_CLOSE);
		
		cons = new JButton("CONSULTA");
		cad = new JButton("CADASTRO");
		cad.addActionListener(listener);
		cons.addActionListener(listener);
		
		add(mens0);
		add(cons);
		add(cad);
	}
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==cons){
				new Consulta_Index();
			}
			if(evento.getSource()==cad){
				new Index();
			}
		}		
	}	
}
