package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class ADM extends JFrame{
	private JLabel mens0 = new JLabel("Escolha uma das subdivissoes administrativas");
	private JButton ger, sec, pres;
	private Handler listener = new Handler();
	protected ADM(){
		super("Cadastro Administracao;");
		setLayout(new FlowLayout());
		setSize(300,300);
		setVisible(true);
		setResizable(false);
		
		ger = new JButton("GERENTE");
		sec = new JButton("SECRETARIO(A)");
		pres = new JButton("PRESIDENTE");
		
		ger.addActionListener(listener);
		sec.addActionListener(listener);
		pres.addActionListener(listener);
		
		add(mens0);
		add(ger);
		add(sec);
		add(pres);
		
	}
	
	private class Handler implements ActionListener{
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
