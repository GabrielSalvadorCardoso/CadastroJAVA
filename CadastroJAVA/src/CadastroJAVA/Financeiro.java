package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Financeiro extends JFrame{
	private JLabel mens0 = new JLabel("Escolha uma das subdivisoes de Financeiro");
	private JButton plan, aud, tes;
	private Handler listener = new Handler();
	protected Financeiro(){
		super("Cadastro Financeiro");
		setLayout(new FlowLayout());
		setSize(300,300);
		setResizable(false);
		setVisible(true);
		
		plan = new JButton("PLANEJAMENTO");
		aud = new JButton("AUDITORIA");
		tes = new JButton("TESOURARIA");
		
		plan.addActionListener(listener);
		aud.addActionListener(listener);
		tes.addActionListener(listener);
		
		add(mens0);
		add(plan);
		add(tes);
		add(aud);
	}
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==plan){
				//new Financeiro_Planejamento()
			}
			if(evento.getSource()==aud){
				//new Financeiro_Auditoria()
			}
			if(evento.getSource()==tes){
				//new Financeiro_Tesouraria();
			}
		}				
	}	
}
