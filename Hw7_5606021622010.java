import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Hw7_5606021622010 extends JFrame implements ActionListener{
     JLabel student_code = new JLabel("Enter student code");;
     JLabel student_name = new JLabel("Enter student name");
     JLabel student_score = new JLabel("Enter student score");
     JTextField code = new JTextField (20);
     JTextField name = new JTextField (20);
     JTextField score = new JTextField (20);
     JButton add_data = new JButton ("add data");
     JButton clear_data = new JButton ("clear data");
     JButton show_record = new JButton ("show record");
     JTextArea list = new JTextArea(20,30);
     JButton min = new JButton("Minimam score");
     JButton max = new JButton("Maximam score");
     JButton average = new JButton ("Average score");
     JLabel min_show = new JLabel ("Minimam score");
     JLabel max_show = new JLabel("Maximam score");
     JLabel average_show = new JLabel("Average score");
     JTextField min_score = new JTextField(20);
     JTextField max_score = new JTextField(20);
     JTextField average_score = new JTextField(20);
     
     public Hw7_5606021622010 () {
    	 super("Programe Student");
    	 Container c = getContentPane();
    	 setLayout(new FlowLayout());
    	 c.add(student_code);
    	 c.add(code);
    	 c.add(student_name);
    	 c.add(name);
    	 c.add(student_score);
    	 c.add(score);
    	 add_data.addActionListener(this);
    	 c.add(add_data);
    	 clear_data.addActionListener(this);
    	 c.add(clear_data);
    	 show_record.addActionListener(this);
    	 c.add(show_record);
    	 list.setEditable(false);
    	 c.add(list);
    	 min.addActionListener(this);
    	 c.add(min);
    	 max.addActionListener(this);
    	 c.add(max);
    	 average.addActionListener(this);
    	 c.add(average);
    	 c.add(min_show);
    	 min_score.setEditable(false);
    	 c.add(min_score);
    	 max_score.setEditable(false);
    	 c.add(max_show);
    	 c.add(max_score);
    	 c.add(average_show);
    	 average_score.setEditable(false);
    	 c.add(average_score);
    	 
     }
     
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add_data){
			addData(code.getText(), name.getText(),score.getText());
//			code.setText("");
//			name.setText("");
//			score.setText("");
		}
		if (e.getSource() == clear_data) {
			clearData();
		}
		if (e.getSource() == show_record) {
			String text = "Student record:" + (current + 1);
			JOptionPane.showMessageDialog(null, text);
		}
		if (e.getSource() == min){
			minimum();
		}
		if (e.getSource() == max) {
			maximum();
		}
		if (e.getSource() == average) {
			average();
		}
	}
	private String std_code[] = new String [50];
	private String std_name [] = new String [50];
	private String std_score[] = new String [50];
	private int count = 0;
	private int current = 0;
	public void addData (String code, String name, String score) {
		std_code[count] = code;
		std_name[count] = name;
		std_score[count] = score;
		String str = "";
		for (int i = 0; i <= count; i++) {
			 str = str + std_code[i] + "    " + std_name[i] + "    " + std_score[i] + "\n";
		}
		list.setText(str);
		current = count;
		count++;
	}
	
	public void clearData () {
		std_code = new String [50];
		std_name = new String [50];
		std_score = new String [50];
		list.setText("");
	}
	
	public void minimum(){
		int min = Integer.parseInt(std_score[0]);
		int index = 0;
		for (int i = 0; i <= current; i++) {
			if (min > Integer.parseInt(std_score[i])) {
				min = Integer.parseInt(std_score[i]);
				index = i;
			}
		}
		String str = std_code[index] + "   " + std_name[index] + "    " + std_score[index];
		min_score.setText(str);
	}
	
	public void maximum () {
		int max = Integer.parseInt(std_score[0]);
		int index = 0;
		for (int i = 0; i <= current; i++) {
			if (max < Integer.parseInt(std_score[i])) {
				max = Integer.parseInt(std_score[i]);
				index = i;
			}
		}
		String str = std_code[index] + "   " + std_name[index] + "    " + std_score[index];
		max_score.setText(str);
	}
	public void average () {
		float avg = 0;
		for(int i =0; i <= current; i++){
			avg = Integer.parseInt(std_score[i]) + avg;
		}
		avg = avg/current ;
		String str = "" + avg;
		average_score.setText(str);
	}
	public static void main (String [] args) {
		Hw7_5606021622010 c = new Hw7_5606021622010();
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setSize(400,800);
		c.setVisible(true);
	}
	
}
