package starting.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import starting.controller.ExitController;
import starting.controller.MouseHandler;
import starting.controller.ResetController;
import starting.controller.SelectNodeController;
import starting.controller.SwapController;
import starting.model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class TrianglePuzzleApp extends JFrame {

	private JPanel contentPane;
	JLabel playerScoreLabel ;
	Model model;
	TrianglePuzzleDrawer panel;
	JLabel playerMovesLabel;
	JButton btnSwap;
	 JButton btnUnselectAll;
	 JPanel VictoryPane;
	
	public TrianglePuzzleDrawer getPanel() { return panel; }

	/**
	 * Create the frame.
	 */
	public TrianglePuzzleApp(Model model) {
		
		this.model = model;
		setTitle("Triangle Puzzle Application -- CS509");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new TrianglePuzzleDrawer(model);
		
		// connects mouse events...
		
		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent me) {
				new SelectNodeController(model, TrianglePuzzleApp.this).NodeClick(me.getPoint());
			}
		});

		

		
		 btnSwap = new JButton("Swap Edges");
		btnSwap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SwapController(TrianglePuzzleApp.this, model).swap();
			
			}
		});
		
		 btnUnselectAll = new JButton("Unselect All");
		btnUnselectAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectNodeController(model, TrianglePuzzleApp.this).UnselectAll();
			
			}
		});
	
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, TrianglePuzzleApp.this).process();
			}
		});
		
		JLabel lblMoves = new JLabel("Moves:");
		
		JLabel lblScore = new JLabel("Score:");
		
	      playerMovesLabel = new JLabel("0");
		
		 playerScoreLabel = new JLabel("0");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnUnselectAll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSwap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMoves)
							.addGap(18)
							.addComponent(playerMovesLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblScore)
							.addGap(18)
							.addComponent(playerScoreLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves)
								.addComponent(playerMovesLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblScore)
								.addComponent(playerScoreLabel))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnUnselectAll)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSwap)
								.addComponent(btnReset))))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	
	}
	
	public JLabel getScore() {
		return this.playerScoreLabel;
	}
	
	public void setScore(int s) {
		this.playerScoreLabel.setText(Integer.toString(s));
	}
	
	public JLabel getPlayerMovesLabel() {
		return this.playerMovesLabel;
	}
	
	public void setPlayerMovesLabel(int m) {
		this.playerMovesLabel.setText(Integer.toString(m));
	}

	public JButton getBtnSwapButton() {
		// TODO Auto-generated method stub
		return  this.btnSwap;
	}

	public JButton getBtnUnselectAllButton() {
		// TODO Auto-generated method stub
		return this.btnUnselectAll;
	}
}
