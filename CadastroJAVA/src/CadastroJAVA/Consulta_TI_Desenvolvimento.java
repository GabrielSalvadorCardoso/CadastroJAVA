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
public class Consulta_TI_Desenvolvimento extends JFrame{
	private JLabel mens0, code, alerta;
	private JTextField codigo;
	private JButton enviar = new JButton("ENVIAR");
	private Handler listener = new Handler();
	private File arquivo;
	private Scanner ler;
	private String texto;
	protected Consulta_TI_Desenvolvimento(){
		super("Consulta T.I.\\Desenvolvimento");
		setSize(280,300);
		setVisible(true);
		setResizable(false);
		setLayout(new FlowLayout());
		
		mens0 = new JLabel("Informe o codigo do funcionario abaixo");
		code = new JLabel("Codigo: ");
		alerta = new JLabel();
		codigo = new JTextField(7);
		
		enviar.addActionListener(listener);
		
		add(mens0);
		add(code);
		add(codigo);
		add(enviar);
		add(alerta);
	}
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==enviar){
				if(codigo.getText().equals("")){
					alerta.setText("Preencha o campo CODIGO");
				}else{
					new Dados();
				}
			}
		}		
	}
	
	private class Dados{
		Dados(){
			ler();
			exibir();
			fechar();
		}
		
		public void ler(){
			try{
				texto = "";
				ler = new Scanner(new File("C:\\CadastroJAVA\\TI\\Desenvolvimento\\"+codigo.getText()+".txt"));
				while(ler.hasNext()){
					texto += ler.nextLine() + "\r\n";
				}
			}catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "Codigo nao existe");
				texto = "Sem informacoes";
			}			
		}
		
		public void exibir(){
			JOptionPane.showMessageDialog(null, texto);
		}
		
		public void fechar(){
			ler.close();
		}
	}	
}
