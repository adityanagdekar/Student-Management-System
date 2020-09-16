//UpdateStudent
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateStudent extends JFrame{
Container c;
JButton btnSave, btnBack;
JLabel lblSid, lblSname, lblSmarks;
JTextField txtSid, txtSname, txtSmarks;

UpdateStudent(){

c = getContentPane();
c.setLayout(new FlowLayout());
btnSave = new JButton("Save");
btnBack = new JButton("Back");
lblSid = new JLabel("Studnet Id ");
lblSname = new JLabel("Student Name ");
lblSmarks = new JLabel("Student Marks ");
txtSid = new JTextField(20);
txtSname = new JTextField(20);
txtSmarks = new JTextField(20);

c.add(lblSid);
c.add(txtSid);
c.add(lblSname);
c.add(txtSname);
c.add(lblSmarks);
c.add(txtSmarks);
c.add(btnSave);
c.add(btnBack);

ActionListener a1 = (ae) -> {
MainStudent m = new MainStudent();
dispose();
};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {

try{

int flag=0,t=0,j=0,k=0,l=0,rno=-10,marks=-10;
String Sid = txtSid.getText();
String Sname = txtSname.getText();
String Smarks = txtSmarks.getText();

if(Sid.length()==0){
	new Music().music2();
	JOptionPane.showMessageDialog(c,"Ivalid Student Id");
	txtSid.setText("");
	txtSid.requestFocus();
}
if(Smarks.length()==0){
	new Music().music2();
	JOptionPane.showMessageDialog(c,"Ivalid Student Marks");
	txtSmarks.setText("");
	txtSmarks.requestFocus();
}
if(Sname.length()==0 ){
	new Music().music2();
	JOptionPane.showMessageDialog(c,"Ivalid Student Name");
	txtSmarks.setText("");
	txtSmarks.requestFocus();
}

for(int i=0;i<Sid.length();i++)
{
	if(!Character.isDigit(Sid.charAt(i)))//change
	{
		l=1;
		break;
	}
}
	if(l==1 ||  Character.isWhitespace(Sid.charAt(0)))
	{
		new Music().music2();
		JOptionPane.showMessageDialog(c,"Ivalid Student Id");
		txtSid.setText("");
		txtSid.requestFocus();
	}
	else
	{
		rno=Integer.parseInt(Sid);
		if(rno<0)
		{
		t=1;
		new Music().music2();
		JOptionPane.showMessageDialog(c,"Ivalid Student Id");
		txtSid.setText("");
		txtSid.requestFocus();
		}
		
	}

for(int i=0;i<Smarks.length();i++)
{
	if(!Character.isDigit(Smarks.charAt(i)))//change
	{
		k=1;
		break;
	}
}
	if(k==1 ||  Character.isWhitespace(Smarks.charAt(0)))
	{
		new Music().music2();
		JOptionPane.showMessageDialog(c,"Invalid marks");
		txtSmarks.setText("");
		txtSmarks.requestFocus();	
	}
	else
	{
		marks=Integer.parseInt(Smarks);
		if((marks>100)||(marks<0))
		{
		t=1;
		new Music().music2();
		JOptionPane.showMessageDialog(c,"Invalid marks");
		txtSmarks.setText("");
		txtSmarks.requestFocus();
		}	
	}

if(Sname.length()<2)
{
	flag=1;
	t=1;
}

for(int i=0;i<Sname.length();i++)
{
	if(!Character.isLetter(Sname.charAt(i))&&(!Character.isWhitespace(Sname.charAt(i))))
	{
	flag=1;
	t=1;
	break;
	}
}
	
for(int i=0;i<Sname.length();i++)
{
	if(Character.isLetter(Sname.charAt(i)))
	j++;
}

if((flag==1)||(j==0))
{
	new Music().music2();
	JOptionPane.showMessageDialog(c,"Invalid Name");
	txtSname.setText("");
	txtSname.requestFocus();
}

if((t==0)&&(j>1)&&(l==0)&&(k==0))
{
	new Music().music1();
	DbHandler db = new DbHandler();
	db.updateStudent( rno,  Sname, marks);
	txtSid.setText("");
	txtSname.setText("");
	txtSmarks.setText("");
	txtSid.requestFocus();
}

}

catch(Exception nfe){
	new Music().music2();
	JOptionPane.showMessageDialog(new JDialog(),"Enter Valid Data ");//

}
};
btnSave.addActionListener(a2);

setTitle("Update Student");
setSize(280,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}

}