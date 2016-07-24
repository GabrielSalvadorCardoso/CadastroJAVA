package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.util.Formatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class TI_Suporte extends JFrame{
	JLabel mens0 = new JLabel("Informe seu dados abaixo e clique em 'ENVIAR' quando tiver terminado");
	JLabel name = new JLabel("Nome:");
	JLabel code = new JLabel("Codigo:");
	JLabel sal = new JLabel("Salario:");
	JLabel hor = new JLabel("Carga Horaria:");
	JLabel sexo = new JLabel("Sexo:");
	JLabel alerta = new JLabel();
	JTextField nome = new JTextField(20);
	JTextField carga_h = new JTextField(3);
	JTextField salario = new JTextField(5);
	JTextField codigo = new JTextField(7);
	JRadioButton masc = new JRadioButton("Masc");
	JRadioButton fem = new JRadioButton("Fem");	
	JButton enviar = new JButton("ENVIAR");
	JCheckBox conf = new JCheckBox("Confirmo as informacoes acima");
	Handler listener = new Handler();
	Tratador ouvinte = new Tratador();	
	ButtonGroup g1 = new ButtonGroup();
	String texto;
	Formatter arquivo;
	File pasta;
	
	protected TI_Suporte(){
		super("Cadastro T.I.\\Suporte");
		setLayout(new FlowLayout());
		setSize(445,300);
		setVisible(true);
		setResizable(false);

		g1.add(fem);
		g1.add(masc);
		
		enviar.setEnabled(false);	//o botão 'enviar'	só será habilitado se a caixa de checagem estiver ativa
		conf.addItemListener(listener);
		masc.addItemListener(listener);
		fem.addItemListener(listener);
		enviar.addActionListener(ouvinte);
		
		add(mens0);
		//nome
		add(name);
		add(nome);
		//codigo
		add(code);
		add(codigo);
		//salario
		add(sal);
		add(salario);
		//carga horaria
		add(hor);
		add(carga_h);
		//sexo
		add(sexo);
		add(masc);
		add(fem);
		//confirmar
		add(conf);
		add(enviar);
		//alerta
		add(alerta);
	}
	
/////////////////////////////////PARTE TRATAMENTO DE JComponents/////////////////////////////////////////////////	
	private class Handler implements ItemListener {		
		@Override		
		public void itemStateChanged(ItemEvent evento) {
			texto = "";			
			if(fem.isSelected()){
				texto = "Feminino";
			}
			else 
				if(masc.isSelected()){
					texto = "Masculino";
			}
			
			if(conf.isSelected()){
				enviar.setEnabled(true);
			}else{
				enviar.setEnabled(false);
			}
		}		
	}	
///////////////////////////////////////PARTE TRATAMENTO DE BOTÕES/////////////////////////////////////////////////	
	private class Tratador implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==enviar){
				if(nome.getText().equals("") || codigo.getText().equals("") ||
				salario.getText().equals("") || carga_h.getText().equals("")){
					alerta.setText("Por favor, preencha todos os campos");	
				}else{
					new Dados().exec_metodos();
				}
			}
		}
	}
/////////////////////////////PARTE DE CRIAÇÃO DE DIRETORIOS E ARQUIVOS///////////////////////////////////////
	class Dados implements Implementador {
		@Override
		public void exec_metodos() {
			cria_diretorio();
			cria_arquivo();
			edita_arquivo();
			fecha_arquivo();
		}
		
		@Override
		public void cria_diretorio() {
			pasta = new File("C:\\CadastroJAVA\\TI\\Suporte\\");
			pasta.mkdirs();
		}

		@Override
		public void cria_arquivo() {
			try{
				arquivo = new Formatter("C:\\CadastroJAVA\\TI\\Suporte\\"+codigo.getText()+".txt");
			}catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "Diretorio inacessivel ou inesistente");
			}
		}

		@Override
		public void edita_arquivo() {
			try{
				arquivo.format("Nome: "+nome.getText()+"\r\n"+"Codigo: "+codigo.getText()+
				"\r\n"+"Salario: "+salario.getText()+"\r\n"+"Carga Horaria(diaria): "+carga_h.getText()+
				"\r\n"+"Sexo: "+texto);
				JOptionPane.showMessageDialog(null, "Arquivo salvo em:\n'C:\\CadastroJAVA\\TI\\Suporte'");
			}catch(SecurityException s){
				JOptionPane.showMessageDialog(null, "Impossivel alterar arquivo");
			}
		}

		@Override
		public void fecha_arquivo() {
			arquivo.close();		
		}		
	}
}


