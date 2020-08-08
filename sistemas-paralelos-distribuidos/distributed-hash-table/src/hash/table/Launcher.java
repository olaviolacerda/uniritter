package hash.table;

import java.awt.*;
import java.io.*;

import javax.swing.*;

import hash.table.Machine;

public class Launcher {
	public static void main(String[] args) {
		Launcher launcher = new Launcher();
		launcher.showgui();
	}

	private JFrame win;
	private JTextField classname_field;
	private JFileChooser dirname_chooser, machinefile_chooser;

	private void launch() {
		win.setVisible(false);

		OutputWindow owin = new OutputWindow();

		File cp = dirname_chooser.getSelectedFile();
		File machinefile = machinefile_chooser.getSelectedFile();
		String classname = classname_field.getText();

		Machine[] machines = Machine.parseFile(machinefile.toPath());
		if (machines == null) {
			owin.text_area.append("ERRO!!! Não conseguiu ler o arquivo " + machinefile);
			return;
		}

		int nprocs = machines.length;

		owin.text_area.append("Lançando " + nprocs + "\ncp=" + cp + "\nclass=" + classname + "\n\n");

		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		classpath = cp + ";" + classpath;

		try {
			Thread[] threads = new Thread[nprocs];

			for (int i = 0; i < nprocs; i++) {
				Machine m = machines[i];
				ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, classname,
						new Integer(m.id).toString(), machinefile.toString());

				String procname = "Processo " + m.id + "(" + m.alias + ")";

				Runnable r = () -> {
					try {
						Process proc = builder.start();

						StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), procname + " ERROR",
								owin.text_area);

						StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), procname + " OUTPUT",
								owin.text_area);

						// start gobblers
						outputGobbler.start();
						errorGobbler.start();

						proc.waitFor();
						java.awt.EventQueue.invokeLater(() -> {
							owin.text_area.append(procname + " retornou " + proc.exitValue() + "\n");
						});
					} catch (IOException ex) {
						System.out.println("FUUUUU" + ex);
						java.awt.EventQueue.invokeLater(() -> {
							owin.text_area.append("FUUUUU" + ex + "\n");
						});
					} catch (InterruptedException ex) {
						System.out.println("Interrupted");
						java.awt.EventQueue.invokeLater(() -> {
							owin.text_area.append("Interrupted: " + ex.toString() + "\n");
						});
					}
				};

				threads[i] = new Thread(r);
				threads[i].start();
			}

			new Thread(() -> {
				for (int i = 0; i < nprocs; i++)
					try {
						threads[i].join();
					} catch (Exception e) {
					}
				// System.exit(0);
			}).start();

		} catch (Exception e) {
			System.out.println("exception: " + e);
		}
	}

	public void showgui() {
		this.win = new JFrame("Lançador Paralelo");

		win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel vpanel = new JPanel();
		GroupLayout l = new GroupLayout(vpanel);
		vpanel.setLayout(l);

		l.setAutoCreateGaps(true);
		l.setAutoCreateContainerGaps(true);

		JLabel machinefile_label = new JLabel("Machine File");
		this.machinefile_chooser = new JFileChooser();
		machinefile_chooser.setDialogTitle("Machine File");
		machinefile_chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		machinefile_chooser.setCurrentDirectory(new File("."));
		JButton machinefile_chooser_btn = new JButton("Machine File...");
		machinefile_chooser_btn.addActionListener(e -> {
			machinefile_chooser.showOpenDialog(win);
		});

		JButton launchbtn = new JButton("Lançar");
		launchbtn.addActionListener(e -> {
			this.launch();
		});

		this.classname_field = new JTextField();
		classname_field.setToolTipText("nome.da.minha.classe");
		classname_field.setText("hash.table.Main");
		JLabel classname_label = new JLabel("Classname");

		this.dirname_chooser = new JFileChooser();
		dirname_chooser.setDialogTitle("Classpath");
		dirname_chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		dirname_chooser.setCurrentDirectory(new File("."));

		JButton dirname_btn = new JButton("Selecionar...");
		dirname_btn.addActionListener(e -> {
			dirname_chooser.showOpenDialog(win);
		});

		JLabel cp_label = new JLabel("Classpath");

		/*
		 * 
		 * - |--------------||------------------| |---------------| | |
		 * machinefile_lab machinefile_btn - | classname_label classname_entry
		 * launch_btn - | classpath_btn -
		 * 
		 * 
		 */

		l.setHorizontalGroup(l.createSequentialGroup()
				.addGroup(l.createParallelGroup().addComponent(machinefile_label).addComponent(classname_label)
						.addComponent(cp_label))
				.addGroup(l.createParallelGroup().addComponent(machinefile_chooser_btn).addComponent(classname_field)
						.addComponent(dirname_btn))
				.addComponent(launchbtn));
		l.setVerticalGroup(l.createSequentialGroup()
				.addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(machinefile_label)
						.addComponent(machinefile_chooser_btn).addComponent(launchbtn))
				.addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(classname_label)
						.addComponent(classname_field))
				.addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(cp_label)
						.addComponent(dirname_btn)));

		win.add(vpanel);
		win.pack();

		win.setVisible(true);

	}

}

class OutputWindow {

	public JFrame run_win;
	public JTextArea text_area;
	public JScrollPane spane;

	public OutputWindow() {
		run_win = new JFrame("Execução");

		text_area = new JTextArea(20, 80);
		text_area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

		spane = new JScrollPane(text_area);

		run_win.add(spane);
		run_win.setSize(600, 800);
		run_win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		run_win.setVisible(true);
	}
}

class StreamGobbler extends Thread {

	InputStream is;
	String type;
	JTextArea ta;

	public StreamGobbler(InputStream is, String type, JTextArea ta) {
		this.is = is;
		this.type = type;
		this.ta = ta;
	}

	@Override
	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String str = line;
				java.awt.EventQueue.invokeLater(() -> {
					ta.append("[" + type + "] " + str + "\n");
				});
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
