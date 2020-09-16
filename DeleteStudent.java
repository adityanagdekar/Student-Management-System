//DeleteStudent
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteStudent extends JFrame{
Container c;
JButton btnDelete,btnBack;
JLabel lblSid;
JTextField txtSid;

DeleteStudent(){
c = getContentPane();
c.setLayout(new FlowLayout());
btnDelete = new JButton("Delete");
btnBack = new JButton("Back");
lblSid = new JLabel("Enter Student Id ");
txtSid = new JTextField(20);

c.add(lblSid);
c.add(txtSid);
c.add(btnDelete);
c.add(btnBack);

ActionListener a1  = (ae) -> {
MainStudent m = new MainStudent();
dispose();
};
btnBack.addActionListener(a1);


ActionListener a2  = (ae) -> {

try{
int Sid = Integer.parseInt(txtSid.getText());
if(Sid>0){
	new Music().music1();
	new DbHandler().deleteStudent( Sid);
	txtSid.setText("");
	txtSid.requestFocus();
}
else{
	new Music().music2();
	JOptionPane.showMessageDialog(new JDialog(),"Enter a valid Student Id");
	txtSid.setText("");
	txtSid.requestFocus();
}
}

catch(NumberFormatException nfe){
new Music().music2();
JOptionPane.showMessageDialog(new JDialog(),"Enter a valid Student Id");//
txtSid.setText("");
txtSid.requestFocus();	
}
};
btnDelete.addActionListener(a2);

setTitle("Delete Student");
setSize(280,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}
