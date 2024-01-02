package viewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Banco;
import model.ModelException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaBanco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFCnpj;
	private JTextField tFNome;
	private JTextField tFCodigo;
	private JanelaAgencia janelaAgencia;
	private JButton btnAgencia;

	public JanelaBanco() {
		setTitle("Banco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbCnpj = new JLabel("CNPJ:");
		lbCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCnpj.setBounds(10, 32, 45, 13);
		contentPane.add(lbCnpj);
		
		tFCnpj = new JTextField();
		tFCnpj.setBounds(55, 30, 96, 19);
		contentPane.add(tFCnpj);
		tFCnpj.setColumns(10);
		
		tFNome = new JTextField();
		tFNome.setBounds(55, 59, 96, 19);
		contentPane.add(tFNome);
		tFNome.setColumns(10);
		
		tFCodigo = new JTextField();
		tFCodigo.setBounds(55, 88, 96, 19);
		contentPane.add(tFCodigo);
		tFCodigo.setColumns(10);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbNome.setBounds(10, 62, 45, 13);
		contentPane.add(lbNome);
		
		JLabel lbCodigo = new JLabel("Código:");
		lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCodigo.setBounds(10, 91, 45, 13);
		contentPane.add(lbCodigo);
		
		JButton btnOk = new JButton("Confirmar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj = tFCnpj.getText();
				String nome = tFNome.getText();
				String codigo = tFCodigo.getText();

				Banco b;

				try {
					b = new Banco(cnpj, nome, codigo);
				} catch (ModelException me) {
					JOptionPane.showMessageDialog(btnOk, "ERRO:" + me.getMessage());
					return;
				}
				JOptionPane.showMessageDialog(btnOk, b);
				btnAgencia.setEnabled(true);
				tFCnpj.setEnabled(false);
				tFNome.setEnabled(false);
				tFCodigo.setEnabled(false);
			}
		});
		btnOk.setBounds(55, 135, 85, 21);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(164, 135, 85, 21);
		contentPane.add(btnCancelar);
		
		JButton btnAgencia = new JButton("Agência");
		btnAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janelaAgencia == null || !janelaAgencia.isVisible()) {
					janelaAgencia = new JanelaAgencia();
					janelaAgencia.setVisible(true);
				}
			}
		});
		btnAgencia.setBounds(116, 166, 85, 21);
		contentPane.add(btnAgencia);
	}

}
