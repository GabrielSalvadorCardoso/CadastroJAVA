package CadastroJAVA;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class Suporte extends JFrame{
	JLabel mens0 = new JLabel("Informe seu dados abaixo e clique em 'ENVIAR' quando tiver terminado");
	JButton enviar = new JButton("ENVIAR");
	JCheckBox conf = new JCheckBox("Confirmo as informacoes acima");
	Handler listener = new Handler();
	Tratador ouvinte = new Tratador();
	protected Suporte(){
		super("Cadastro T.I.\\Suporte");
		setLayout(new FlowLayout());
		setSize(470,300);
		setVisible(true);
		
		enviar.setEnabled(false);	//o botão 'enviar'	só será habilitado se a caixa de checagem estiver ativa
		conf.addItemListener(listener);
		enviar.addActionListener(ouvinte);
		
		add(mens0);
		add(conf);
		add(enviar);
	}
	
	private class Handler implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent evento) {
			if(conf.isSelected()){
				enviar.setEnabled(true);
			}else{
				enviar.setEnabled(false);
			}
		}		
	}
	
	private class Tratador implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==enviar){
				JOptionPane.showMessageDialog(null, "Os dados do cadastro estao em:\n'C:\\Arquivos de Programas'");
			}
		}
		
	}
	
}
