package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
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
	File dir;
	Formatter arquivo;
	String texto = "";
	JLabel mens0 = new JLabel("Informe seus dados abaixo e clique em 'ENVIAR' quando tiver terminado");
	JLabel name = new JLabel("Nome:");
	JLabel code = new JLabel("Codigo:");
	JLabel sal = new JLabel("Salario: ");
	JLabel hor = new JLabel("Carga Horaria:");
	JLabel sexo = new JLabel("Sexo:");
	JTextField nome = new JTextField(20);
	JTextField codigo = new JTextField(7);
	JTextField salario = new JTextField(5);
	JTextField carga_h = new JTextField(3);
	JRadioButton fem = new JRadioButton("Fem");
	JRadioButton masc = new JRadioButton("Masc");
	ButtonGroup g1 = new ButtonGroup();
	JButton enviar = new JButton("ENVIAR");
	JCheckBox conf = new JCheckBox("Confirmo as informacoes acima");
	Handler listener = new Handler();
	Tratador ouvinte = new Tratador();
	
	TI_Redes(){
		super("Cadastro T.I.\\Redes");
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(445,300);
		
		enviar.setEnabled(false);
		g1.add(masc);
		g1.add(fem);
		
		conf.addItemListener(listener);
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
				
	}
/////////////////////////////////PARTE TRATAMENTO DE JComponents/////////////////////////////////////////////////	
	class Handler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent evento) {
			if(masc.isSelected()){
				texto += "Masculino";
			}
			if(fem.isSelected()){
				texto += "Feminino";
			}
			if(conf.isSelected()){
				enviar.setEnabled(true);
			}			
		}
		
	}
///////////////////////////////////////PARTE TRATAMENTO DE BOTÕES/////////////////////////////////////////////////	
	class Tratador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==enviar){
				Dados d = new Dados();
				d.exec_metodos();
			}
		}
		
	}
/////////////////////////////PARTE DE CRIAÇÃO DE DIRETORIOS E ARQUIVOS///////////////////////////////////////
	class Dados implements Implementador{

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
			}catch(Exception ex){
				System.err.println("Nao e possivel criar arquivo");
			}
		}

		@Override
		public void edita_arquivo() {
			try{
				arquivo.format("Nome: "+nome.getText()+"\r\nCodigo: "+codigo.getText()+
						"\r\nSalario: "+salario.getText()+"\r\nCarga Horaria(diaria): "+carga_h.getText()+
						"\r\nSexo: "+texto);
				JOptionPane.showMessageDialog(null, "Arquivo salvo em:\n'C:\\CadastroJAVA\\TI\\Redes\\'");
			}catch(Exception e){
				System.err.println("Arquivo somente leitura");
			}			
		}

		@Override
		public void fecha_arquivo() {
			arquivo.close();		
		}		
	}	
}
