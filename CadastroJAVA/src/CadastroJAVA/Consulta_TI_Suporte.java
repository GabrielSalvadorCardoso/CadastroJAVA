package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Consulta_TI_Suporte extends JFrame{
	JLabel mens0, alerta;
	JTextField codigo;
	JButton enviar;
	Handler listener = new Handler();
	Scanner ler;
	String texto;
	Consulta_TI_Suporte(){
		super("Consulta T.I.\\Suporte");
		setSize(300,300);
		setResizable(true);
		setVisible(true);
		setLayout(new FlowLayout());
		
		mens0 = new JLabel("Informe o codigo do funcionario abaixo");
		alerta = new JLabel();
		codigo = new JTextField(7);
		enviar = new JButton("ENVIAR");
		
		enviar.addActionListener(listener);
		
		add(mens0);
		add(codigo);
		add(enviar);
		add(alerta);
	}
	
	class Handler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==enviar){
				if(codigo.getText().equals("")){
					alerta.setText("Preencha o campo codigo");
				}else{
					new Dados();
				}
			}
		}		
	}
	
	class Dados{
		Dados(){
			ler();
			exibir();
			fechar();
		}
		
		void ler(){
			texto = "";
			try{
				ler = new Scanner(new File("C:\\CadastroJAVA\\TI\\Suporte\\"+codigo.getText()+".txt"));
				while(ler.hasNext()){
					texto += ler.nextLine()+"\r\n";
				}
			}catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "Codigo nao existe");
				texto = "Sem informacoes";
			}
		}
		
		void exibir(){
			JOptionPane.showMessageDialog(null, texto);
		}
		
		void fechar(){
			ler.close();
		}
		
	}
	
}
