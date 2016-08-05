package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class ADM extends JFrame{
	JLabel mens0 = new JLabel("Escolha uma das subdivissoes administrativas");
	JButton ger = new JButton("GERENTE");
	JButton sec = new JButton("SECRETARIO(A)");
	JButton pres = new JButton("PRESIDENTE");
	Handler listener = new Handler();
	ADM(){
		super("Cadastro Administracao;");
		setLayout(new FlowLayout());
		setSize(300,300);
		setVisible(true);
		setResizable(false);
		
		ger.addActionListener(listener);
		sec.addActionListener(listener);
		pres.addActionListener(listener);
		
		add(mens0);
		add(ger);
		add(sec);
		add(pres);
		
	}
	
	class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==ger){			
				new ADM_Gerencia();
			}
			if(evento.getSource()==sec){			
				
			}
			if(evento.getSource()==pres){			
	
			}
		}		
	}	
}
