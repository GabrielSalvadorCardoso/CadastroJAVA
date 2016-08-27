package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class TI_Redes extends JFrame{
	private File dir;
	private Formatter arquivo;
	private String texto;
	private JLabel mens0, name, code, alerta, sal, hor, sexo;
	private JTextField nome, codigo, salario, carga_h;
	private JRadioButton fem, masc;
	private ButtonGroup g1 = new ButtonGroup();
	private JButton enviar = new JButton("ENVIAR");
	private JCheckBox conf = new JCheckBox("Confirmo as informacoes acima");
	private Handler listener = new Handler();
	private Tratador ouvinte = new Tratador();
	
	protected TI_Redes(){
		super("Cadastro T.I.\\Redes");
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(445,300);
		setResizable(false);
		
		mens0 = new JLabel("Informe seu dados abaixo e clique em 'ENVIAR' quando tiver terminado");
		name = new JLabel("Nome:");
		code = new JLabel("Codigo:");
		sal = new JLabel("Salario:");
		hor = new JLabel("Carga Horaria:");
		sexo = new JLabel("Sexo:");
		alerta = new JLabel();
		nome = new JTextField(20);
		carga_h = new JTextField(3);
		salario = new JTextField(5);
		codigo = new JTextField(7);
		masc = new JRadioButton("Masc");
		fem = new JRadioButton("Fem");
		
		enviar.setEnabled(false);
		g1.add(masc);
		g1.add(fem);
		
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
		//confirmação
		add(conf);
		add(enviar);
		add(alerta);
				
	}
/////////////////////////////////PARTE TRATAMENTO DE JComponents/////////////////////////////////////////////////	
	private class Handler implements ItemListener{		
		@Override
		public void itemStateChanged(ItemEvent evento) {
			texto = "";
			if(masc.isSelected()){
				texto = "Masculino";
			}
			if(fem.isSelected()){
				texto = "Feminino";
			}
			if(conf.isSelected()){
				enviar.setEnabled(true);
			}else{
				enviar.setEnabled(false);
			}	
		}		
	}
///////////////////////////////////////PARTE TRATAMENTO DE BOTÕES/////////////////////////////////////////////////	
	private class Tratador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==enviar){//se algum dos campos estiver vazio a mensagem é exibida
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
	private class Dados implements Implementador{
		@Override
		public void exec_metodos() {
			cria_diretorio();
			cria_arquivo();
			edita_arquivo();
			fecha_arquivo();
		}

		@Override
		public void cria_diretorio() {
			try{
				dir = new File("C:\\CadastroJAVA\\TI\\Redes");
				dir.mkdirs();
			}catch(Exception e){
				System.err.println("Nao e possivel criar o diretotio");
			}
		}

		@Override
		public void cria_arquivo() {
			try{
				arquivo = new Formatter("C:\\CadastroJAVA\\TI\\Redes\\"+codigo.getText()+".txt");
			}catch(FileNotFoundException ex){
				JOptionPane.showMessageDialog(null, "Diretorio inesistente ou inacessivel");
			}
		}

		@Override
		public void edita_arquivo() {
			try{
				arquivo.format("Nome: "+nome.getText()+"\r\nCodigo: "+codigo.getText()+
						"\r\nSalario: "+salario.getText()+"\r\nCarga Horaria(diaria): "+carga_h.getText()+
						"\r\nSexo: "+texto);
				JOptionPane.showMessageDialog(null, "Arquivo salvo em:\n'C:\\CadastroJAVA\\TI\\Redes\\'");
			}catch(SecurityException e){
				JOptionPane.showMessageDialog(null, "Impossivel alterar arquivo");
			}			
		}

		@Override
		public void fecha_arquivo() {
			arquivo.close();		
		}		
	}	
}
