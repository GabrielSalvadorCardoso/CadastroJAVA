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
public class ADM_Gerencia extends JFrame{
	private JLabel mens0, name, cod, sal, hor, sexo, alerta;
	private JTextField nome, codigo, salario, carga_h;
	private JRadioButton masc, fem;
	private JCheckBox conf = new JCheckBox("Confirmo as informacoes acima");
	private ButtonGroup g1 = new ButtonGroup();
	private JButton enviar = new JButton("ENVIAR");
	private Handler listener = new Handler();
	private Tratador ouvinte = new Tratador();
	private String texto;
	private File dir;
	private Formatter arquivo;
	protected ADM_Gerencia(){
		super("Cadastro Administracao\\Gerencia");
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(445,300);
		setResizable(false);
		
		mens0 = new JLabel("Informe seus dados abaixo e clique em 'ENVIAR' quando tiver terminado");
		name = new JLabel("Nome:");
		cod = new JLabel("Codigo:");
		sal = new JLabel("Salario:");
		hor = new JLabel("Carga Horaria:");
		sexo = new JLabel("Sexo:");
		alerta = new JLabel();
		
		nome = new JTextField(20);
		codigo = new JTextField(7);
		salario = new JTextField(5);
		carga_h = new JTextField(3);
		
		masc = new JRadioButton("Masc");
		fem = new JRadioButton("Fem");
		
		g1.add(fem);
		g1.add(masc);
		fem.addItemListener(listener);
		masc.addItemListener(listener);
		conf.addItemListener(listener);
		enviar.addActionListener(ouvinte);
		enviar.setEnabled(false);
		
		add(mens0);
		add(name);
		add(nome);
		add(cod);
		add(codigo);
		add(sal);
		add(salario);
		add(hor);
		add(carga_h);
		add(sexo);
		add(masc);
		add(fem);
		add(conf);
		add(enviar);
		add(alerta);
	}
/////////////////////////////////PARTE TRATAMENTO DE JComponents/////////////////////////////////////////////////
	private class Handler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			texto = "";
			if(conf.isSelected()){
				enviar.setEnabled(true);
			}else{
				enviar.setEnabled(false);
			}
			if(masc.isSelected()){
				texto = "Masculino";
			}
			if(fem.isSelected()){
				texto = "Feminino";
			}
		}		
	}
///////////////////////////////////////PARTE TRATAMENTO DE BOTÕES/////////////////////////////////////////////////	/
	private class Tratador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource()==enviar){
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
	private class Dados implements Implementador {
		@Override
		public void exec_metodos() {
		cria_diretorio();
		cria_arquivo();
		edita_arquivo();
		fecha_arquivo();
	}

	@Override
	public void cria_diretorio() {
			dir = new File("C:\\CadastroJAVA\\Administracao\\Gerencia");
			dir.mkdirs();		
	}

	@Override
	public void cria_arquivo() {
		try{
			arquivo = new Formatter("C:\\CadastroJAVA\\Administracao\\Gerencia\\"+codigo.getText()+".txt");
		}catch(FileNotFoundException ex){
			JOptionPane.showMessageDialog(null, "Diretorio inesistente ou inacessivel");
		}		
	}

	@Override
	public void edita_arquivo() {
		try{
			arquivo.format("Nome: "+nome.getText()+"\r\nCodigo: "+
			codigo.getText()+"\r\nSalario: "+salario.getText()+
			"\r\nCarga Horaria: "+carga_h.getText()+"\r\nSexo: "+texto);
			JOptionPane.showMessageDialog(null, "Arquivo salvo em:\n'C:\\CadastroJAVA\\Administracao\\Gerencia\\'");
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
