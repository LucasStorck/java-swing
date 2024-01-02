package viewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ContaCorrente;
import model.ModelException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaContaCorrente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFNumero;
	private JTextField tFAbertura;
	private JTextField tFNome;
	private JTextField tFSaldo;

	public JanelaContaCorrente() {
		setTitle("Conta Corrente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNumero = new JLabel("Número:");
		lbNumero.setBounds(15, 22, 45, 13);
		lbNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lbNumero);
		
		tFNumero = new JTextField();
		tFNumero.setBounds(69, 21, 96, 19);
		contentPane.add(tFNumero);
		tFNumero.setColumns(10);
		
		tFAbertura = new JTextField();
		tFAbertura.setBounds(69, 52, 96, 19);
		contentPane.add(tFAbertura);
		tFAbertura.setColumns(10);
		
		tFNome = new JTextField();
		tFNome.setBounds(69, 81, 96, 19);
		contentPane.add(tFNome);
		tFNome.setColumns(10);
		
		JLabel lbAbertura = new JLabel("Abertura:");
		lbAbertura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbAbertura.setBounds(15, 55, 45, 13);
		contentPane.add(lbAbertura);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbNome.setBounds(15, 83, 45, 13);
		contentPane.add(lbNome);
		
		tFSaldo = new JTextField();
		tFSaldo.setBounds(69, 110, 96, 19);
		contentPane.add(tFSaldo);
		tFSaldo.setColumns(10);
		
		JLabel lbSaldo = new JLabel("Saldo:");
		lbSaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbSaldo.setBounds(15, 113, 45, 13);
		contentPane.add(lbSaldo);
		
		JButton btnOk = new JButton("Confimar");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = tFNumero.getText();
				String diaAbertura = tFAbertura.getText();
				String nomeCorrentista = tFNome.getText();
				String aux = tFSaldo.getText();

				int saldo;
				try {
					saldo = Integer.parseInt(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btnOk, "O saldo deve conter dígitos numéricos!");
					return;
				}
				ContaCorrente cc;
				try {
					cc = new ContaCorrente(numero, diaAbertura, nomeCorrentista, saldo);
				} catch (ModelException me) {
					JOptionPane.showMessageDialog(btnOk, "ERRO: " + me.getMessage());
					return;
				}
				JOptionPane.showMessageDialog(btnOk, cc);
			}
		});
		btnOk.setBounds(69, 150, 85, 21);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(174, 150, 85, 21);
		contentPane.add(btnCancelar);
	}

}
