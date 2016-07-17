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
public class Suporte extends JFrame{
	JLabel mens0 = new JLabel("Informe seu dados abaixo e clique em 'ENVIAR' quando tiver terminado");
	JLabel name, code, sexo, sal, hor;
	JTextField nome, codigo, salario, carga_h;	
	JButton enviar = new JButton("ENVIAR");
	JCheckBox conf = new JCheckBox("Confirmo as informacoes acima");
	Handler listener = new Handler();
	Tratador ouvinte = new Tratador();
	JRadioButton fem, masc;
	ButtonGroup g1 = new ButtonGroup();
	String texto;
	Formatter arquivo;
	File pasta;
	protected Suporte(){
		super("Cadastro T.I.\\Suporte");
		setLayout(new FlowLayout());
		setSize(445,300);
		setVisible(true);
		
		masc = new JRadioButton("Masc");
		fem = new JRadioButton("Fem");
		nome = new JTextField(20);
		carga_h = new JTextField(3);
		salario = new JTextField(5);
		codigo = new JTextField(7);
		name = new JLabel("Nome:");
		code = new JLabel("Codigo:");
		sal = new JLabel("Salario:");
		hor = new JLabel("Carga Horaria:");
		sexo = new JLabel("Sexo");
		
		g1.add(fem);
		g1.add(masc);
		
		enviar.setEnabled(false);	//o botão 'enviar'	só será habilitado se a caixa de checagem estiver ativa
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
		//confirmar
		add(conf);
		add(enviar);
	}
	
	//classe para tratar eventos das Check Boxes e Radio Buttons 
	private class Handler implements ItemListener {		
		@Override		
		public void itemStateChanged(ItemEvent evento) {
			texto = "";
			if(fem.isSelected()){
				texto += "Feminino";
			}
			else 
				if(masc.isSelected()){
					texto += "Masculino";
			}
			
			if(conf.isSelected()){
				enviar.setEnabled(true);
			}else{
				enviar.setEnabled(false);
			}
		}		
	}
	//classe para tratar eventos dos botoes
	private class Tratador implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==enviar){
				diretorio();
				criar();
				inserir();
				fechar();
			}
		}
		//criar o diretorio em que serão depositados os arquivos referente aos funcionarios de Suporte
		void diretorio(){
			pasta = new File("C:\\CadastroJAVA\\Suporte\\");
			pasta.mkdirs();
		}
		//cria o arquivo com os dados do funcionario de Suporte
		void criar(){
			try{
				arquivo = new Formatter("C:\\CadastroJAVA\\Suporte\\000001.txt");
			}catch(FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "Arquivo nao pode ser criado");
			}
		}
		//escreve as informações(informadas de usuario via caixas de texto) no arquivo criado no metodo anterior
		void inserir(){
			try{
				arquivo.format("Nome: "+nome.getText()+"\r\n"+"Codigo: "+codigo.getText()+
				"\r\n"+"Salario: "+salario.getText()+"\r\n"+"Carga Horaria(diaria): "+carga_h.getText()+
				"\r\n"+"Sexo: "+texto);
				JOptionPane.showMessageDialog(null, "Arquivo salvo em:\n'C:\\CadastroJAVA\\Suporte'");
			}catch(SecurityException s){
				JOptionPane.showMessageDialog(null, "Arquivo somente leitura");
			}
		}
		//fecha o arquivo
		void fechar(){
			arquivo.close();
		}
		
	}
}
