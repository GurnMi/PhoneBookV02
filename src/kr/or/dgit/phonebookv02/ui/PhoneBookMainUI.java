package kr.or.dgit.phonebookv02.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.phonebookv02.ctrl.PhoneControl;

public class PhoneBookMainUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static final String[] COL_NAMES={"번호","이름","주소","전화번호"};
	private PhoneControl phoneControl;
	
	
	
	public PhoneBookMainUI() {
		phoneControl = new PhoneControl();
		
		
		setTitle("연락처 관리 앱");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		PhonePanel pPhone = new PhonePanel();
		contentPane.add(pPhone, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		 model = new DefaultTableModel(getDatas(), PhoneBookMainUI.COL_NAMES);
		table = new JTable(model);
		
			
		scrollPane.setViewportView(table);
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem reMenuItem = new JMenuItem("수정");
		reMenuItem.addActionListener(relistener);
		popMenu.add(reMenuItem);
		
	}
	private Object[][] getDatas(){
		return phoneControl.showPhones();
	}
	
	ActionListener relistener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int selRow = table.getSelectedRow();
			
			PhonePanel.setTfName((String)model.getValueAt(selRow,1));
			PhonePanel.tfTel.setText((String)model.getValueAt(selRow,3));
			PhonePanel.tfAddr.setText((String)model.getValueAt(selRow,2));
		}
	};
	private DefaultTableModel model;
}
