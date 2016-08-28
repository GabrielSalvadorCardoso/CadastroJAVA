package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class RH extends JFrame {
	private JLabel mens0 = new JLabel("Escolha uma das subdivisoes de R.H.");
	private JButton ger, ana, dir;
	private Handler listener = new Handler();
	protected RH(){
		super("Cadastro R.H.");
		setVisible(true);
		setSize(280,300);
		setLayout(new FlowLayout());
		setResizable(false);
		
		ger = new JButton("GERENCIA");
		ana = new JButton("ANALISTA");
		dir = new JButton("DIRETORIA");
		
		ger.addActionListener(listener);
		ana.addActionListener(listener);
		dir.addActionListener(listener);
		
		add(mens0);
		add(ana);
		add(ger);
		add(dir);
	}
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==ger){
				//new RH_Gerencia();
			}
			if(evento.getSource()==ana){
				//new RH_Analista();
			}
			if(evento.getSource()==dir){
				//new RH_Gerencia();
			}
		}		
	}	
}
