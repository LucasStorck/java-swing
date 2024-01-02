package viewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Agencia;
import model.ModelException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFCodigo;
	private JTextField tFBairro;
	private JTextField tFCidade;
	private JTextField tFUf;
	private JanelaContaCorrente janelaConta;
	private JButton btnContaCorrente;

	public JanelaAgencia() {
		setBackground(Color.WHITE);
		setFont(new Font("Tahoma", Font.PLAIN, 16));
		setTitle("Agência");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbCodigo = new JLabel("Código:");
		lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCodigo.setBounds(22, 29, 45, 13);
		contentPane.add(lbCodigo);
		
		tFCodigo = new JTextField();
		tFCodigo.setBounds(77, 27, 96, 19);
		contentPane.add(tFCodigo);
		tFCodigo.setColumns(10);
		
		tFBairro = new JTextField();
		tFBairro.setBounds(77, 56, 96, 19);
		contentPane.add(tFBairro);
		tFBairro.setColumns(10);
		
		JLabel lbBairro = new JLabel("Bairro:");
		lbBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbBairro.setBounds(22, 59, 45, 13);
		contentPane.add(lbBairro);
		
		tFCidade = new JTextField();
		tFCidade.setBounds(77, 85, 96, 19);
		contentPane.add(tFCidade);
		tFCidade.setColumns(10);
		
		JLabel lbCidade = new JLabel("Cidade:");
		lbCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCidade.setBounds(22, 88, 45, 13);
		contentPane.add(lbCidade);
		
		tFUf = new JTextField();
		tFUf.setBounds(77, 114, 96, 19);
		contentPane.add(tFUf);
		tFUf.setColumns(10);
		
		JLabel lbUf = new JLabel("UF:");
		lbUf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbUf.setBounds(22, 117, 45, 13);
		contentPane.add(lbUf);
		
		JButton btnOk = new JButton("Confirmar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = tFCodigo.getText();
				String bairro = tFBairro.getText();
				String cidade = tFCidade.getText();
				String uf = tFUf.getText();
				
				Agencia a;
				
				try {
					a = new Agencia(codigo, bairro, cidade, uf);
				}catch(ModelException me) {
					JOptionPane.showMessageDialog(btnOk, "ERRO: " + me.getMessage());
					return;
				}
				
				JOptionPane.showMessageDialog(btnOk, a);
				btnContaCorrente.setEnabled(true);
				tFCodigo.setEnabled(false);
				tFCidade.setEnabled(false);
				tFUf.setEnabled(false);
				tFBairro.setEnabled(false);
			}
		});
		btnOk.setBounds(77, 157, 85, 21);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(189, 157, 85, 21);
		contentPane.add(btnCancelar);
		
		JButton btnContaCorrente = new JButton("Conta Corrente");
		btnContaCorrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(janelaConta == null || !janelaConta.isVisible()) {
					janelaConta = new JanelaContaCorrente();
					janelaConta.setVisible(true);
				}
			}
		});
		btnContaCorrente.setBounds(135, 188, 85, 21);
		contentPane.add(btnContaCorrente);
	}
}
