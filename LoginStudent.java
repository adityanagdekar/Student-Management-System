//LoginStudent

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginStudent extends JFrame{
Container c;
JButton btnLogin;
JTextField txtSUsername;
JLabel lblSPass, lblSUsername;
JPasswordField pfSPass;


public LoginStudent(){
c = getContentPane();
c.setLayout(new FlowLayout());
btnLogin = new JButton("Login");
lblSPass = new JLabel("Password ");
lblSUsername = new JLabel("Username ");
pfSPass = new JPasswordField(20);
pfSPass.setEchoChar('*');
txtSUsername = new JTextField(20);

c.add(lblSUsername);
c.add(txtSUsername);
c.add(lblSPass);
c.add(pfSPass);
c.add(btnLogin);





ActionListener a1 = (ae) -> {

try{
String Username = txtSUsername.getText();
String Pass = pfSPass.getText();

String User="rex";
String Password = "abc123";
if((Username.equals(User)) && (Pass.equals(Password)))
{
	new Music().music1();
	MainStudent m = new MainStudent();
	dispose();
}
else{
	new Music().music2();
	JOptionPane.showMessageDialog(new JDialog(),"Plz enter Proper Data");
	txtSUsername.setText("");
	pfSPass.setText("");
	txtSUsername.requestFocus();
}
}
catch(NumberFormatException nfe){

new Music().music2();
JOptionPane.showMessageDialog(new JDialog(),"Invalid inputs");
	txtSUsername.setText("");
	pfSPass.setText("");
	txtSUsername.requestFocus();

}
};
btnLogin.addActionListener(a1);

setTitle("Login Student");
setSize(280,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

public static void main(String []args){
LoginStudent k =new LoginStudent();


}

}