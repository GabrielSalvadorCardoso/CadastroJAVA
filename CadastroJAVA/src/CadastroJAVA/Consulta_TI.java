package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Consulta_TI extends JFrame{
	JButton sup, redes, desenv;
	JLabel mens0;
	Handler listener = new Handler();
	Consulta_TI(){
		super("Consulta TI");
		setSize(300,300);
		setVisible(true);
		setResizable(true);
		setLayout(new FlowLayout());
		
		mens0 = new JLabel("Escolha uma das subdivisoes de T.I.");
		sup = new JButton("SUPORTE");
		redes = new JButton("REDES");
		desenv = new JButton("DESENVOLVIMENTO");
		
		sup.addActionListener(listener);
		redes.addActionListener(listener);
		desenv.addActionListener(listener);
		
		add(mens0);
		add(sup);
		add(redes);
		add(desenv);
	}
	
	class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==sup){
				new Consulta_TI_Suporte();
			}
			if(evento.getSource()==redes){
				//new Consulta_TI_Redes();
			}
			if(evento.getSource()==desenv){
				//new Consulta_TI_Desenvolvimento();
			}			
		}		
	}	
}
