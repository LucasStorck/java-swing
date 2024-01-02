package viewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JanelaBanco janelaBanco;

	public JanelaPrincipal() {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBanco = new JButton("Banco");
		btnBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaBanco == null || !janelaBanco.isVisible()) {
					janelaBanco = new JanelaBanco();
					janelaBanco.setVisible(true);
				}
			}
		});
		btnBanco.setBounds(89, 112, 85, 21);
		contentPane.add(btnBanco);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnSair.setBounds(198, 112, 85, 21);
		contentPane.add(btnSair);
	}

}
