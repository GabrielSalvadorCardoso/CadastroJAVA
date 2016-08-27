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
public class TI_Desenvolvimento extends JFrame{
	private JLabel mens0, name, code, alerta, sal, hor, sexo;
	private JTextField nome, codigo, salario, carga_h;
	private JCheckBox conf = new JCheckBox("Confirmo as informacoes acima");
	private JRadioButton masc, fem;
	private JButton enviar = new JButton("ENVIAR");
	private ButtonGroup g1 = new ButtonGroup();
	private String texto;
	private Handler listener = new Handler();
	private Tratador ouvinte = new Tratador();
	private File dir;
	private Formatter arquivo;
	
	protected TI_Desenvolvimento(){
		super("Cadastro T.I.\\Desenvolvimento");
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
		
		g1.add(masc);
		g1.add(fem);
		enviar.setEnabled(false);
		
		conf.addItemListener(listener);
		masc.addItemListener(listener);
		fem.addItemListener(listener);
		enviar.addActionListener(ouvinte);
		
		add(mens0);
		add(name);
		add(nome);
		add(code);
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
///////////////////////////////////////PARTE TRATAMENTO DE BOTÕES/////////////////////////////////////////////////	/
	private class Tratador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==enviar){
				if(nome.getText().equals("") || codigo.getText().equals("") ||
				salario.getText().equals("") || carga_h.getText().equals("")){
					alerta.setText("Por favor, preencha todos os campos");
				}else{
					new Dados().exec_metodos();;
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
			dir = new File("C:\\CadastroJAVA\\TI\\Desenvolvimento");
			dir.mkdirs();
		}

		@Override
		public void cria_arquivo() {
			try {
				arquivo = new Formatter("C:\\CadastroJAVA\\TI\\Desenvolvimento\\"+codigo.getText()+".txt");
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Diretorio inesistente ou inacessivel");
			}
		}

		@Override
		public void edita_arquivo() {
			try{
				arquivo.format("Nome: "+nome.getText()+"\r\nCodigo: "+codigo.getText()+"\r\nSalario: "+
				salario.getText()+"\r\nCarga Horaria(diaria): "+carga_h.getText()+"\r\nSexo: "+texto);
				JOptionPane.showMessageDialog(null, "Arquivo salvo em:\nC:\\CadastroJAVA\\TI\\Desenvolvimento\\");
			}catch(SecurityException i){
				JOptionPane.showMessageDialog(null, "Impossivel alterar arquivo");
			}
		}

		@Override
		public void fecha_arquivo() {
			arquivo.close();
		}		
	}	
}
