package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Principal extends JFrame{
	JButton cons, cad;
	JLabel mens0 = new JLabel("Informe abaixo o que deseja fazer");
	Handler listener = new Handler();
	Principal(){
		super("CadastroJAVA");
		setSize(300,300);
		setVisible(true);
		setResizable(false);
		setLayout(new FlowLayout());
		
		cons = new JButton("CONSULTA");
		cad = new JButton("CADASTRO");
		cad.addActionListener(listener);
		cons.addActionListener(listener);
		
		add(mens0);
		add(cons);
		add(cad);
	}
	
	class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==cons){
				//new Consulta_Index();
			}
			if(evento.getSource()==cad){
				new Index();
			}
		}		
	}	
}
