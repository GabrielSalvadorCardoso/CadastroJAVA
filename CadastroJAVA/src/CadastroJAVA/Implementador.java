package CadastroJAVA;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.JOptionPane;
public interface Implementador { 
	//esta classe tem o objetivo de agilizar a produ��o do projeto, facilitando a parte de cria��o de pastas e arquivos
	
	//"chama" os metodos
	void exec_metodos();
	
	//criar o diretorio em que ser�o depositados os arquivos com os dados dos funcionarios
	void cria_diretorio();
	
	//cria o arquivo com os dados do funcionario de Suporte
	void cria_arquivo();
	
	//escreve as informa��es(informadas de usuario via caixas de texto) no arquivo criado no metodo anterior
	void edita_arquivo();
	
	//fecha o arquivo
	void fecha_arquivo();
}

