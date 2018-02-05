package menu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Menu_view extends Frame implements ActionListener, WindowListener{
	
	private MenuBar mb;
	private Menu graph;
	private MenuItem graph1, graph2;
	private Panel cardPanel,card1,card2;
	
	public Menu_view(){
		addWindowListener(this);
		setTitle("Menu");
		//���j���[�̍쐬
		mb = new MenuBar();
		graph = mb.add(new Menu("Graph")); //���j���[�o�[�ɕ\��
		graph1 = graph.add(new MenuItem("Graph1")); //���j���[�ɕ\��
		graph2 = graph.add(new MenuItem("Graph2"));
		setMenuBar(mb);
		//�J�[�h�p�l���̗��p
		cardPanel = new Panel();
		cardPanel.setLayout(new CardLayout());
		card1 = new Panel();
		card2 = new Panel();
		//card1�ɃO���t�̐ݒ�
		DefaultCategoryDataset data1 = new DefaultCategoryDataset();
		
		data1.addValue(300, "USA", "2005");
		data1.addValue(500, "USA", "2006");
		data1.addValue(120, "USA", "2007");

	    JFreeChart chart1 = 
	      ChartFactory.createLineChart("Import Volume",
	                                   "Year",
	                                   "Ton",
	                                   data1,
	                                   PlotOrientation.VERTICAL,
	                                   true,
	                                   false,
	                                   false);

	    ChartPanel cpanel1 = new ChartPanel(chart1);
	    card1.add(cpanel1, BorderLayout.CENTER);
	  //card2�ɃO���t�̐ݒ�
	    DefaultCategoryDataset data2 = new DefaultCategoryDataset();
		
	    data2.addValue(200, "China", "2005");
	    data2.addValue(400, "China", "2006");
	    data2.addValue(320, "China", "2007");

	    JFreeChart chart2 = 
	      ChartFactory.createLineChart("Import Volume",
	                                   "Year",
	                                   "Ton",
	                                   data2,
	                                   PlotOrientation.VERTICAL,
	                                   true,
	                                   false,
	                                   false);

	    ChartPanel cpanel2 = new ChartPanel(chart2);
	    card2.add(cpanel2, BorderLayout.CENTER);
		//�J�[�h�𔽉f
		cardPanel.add(card1,"Card1");
		cardPanel.add(card2,"Card2");
		add(cardPanel);
		//Listener�̐ݒ�
		graph1.addActionListener(this);
		graph2.addActionListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CardLayout cardlayout = (CardLayout)(cardPanel.getLayout());
		
		if(e.getSource() == graph1) {
			setBackground(Color.red);
			cardlayout.show(cardPanel,"Card1");
		}else if(e.getSource() == graph2) {
			setBackground(Color.blue);
			cardlayout.show(cardPanel,"Card2");
		}
		
	}
	
}
