//MainStudent
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import org.hibernate.*;
//import org.hibernate.cfg.*;

class MainStudent extends JFrame{
Container c;
JButton btnAdd, btnView, btnUpdate, btnDelete;
MainStudent()
{
c = getContentPane();
c.setLayout(new FlowLayout());
btnAdd = new JButton("Add");
btnView = new JButton("View");
btnUpdate = new JButton("Update");
btnDelete = new JButton("Delete");
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

ActionListener a1 = (ae) -> {
AddStudent a = new AddStudent();
dispose();
};
btnAdd.addActionListener(a1);

ActionListener a2 = (ae) -> {
ViewStudent v = new ViewStudent();
dispose();
};
btnView.addActionListener(a2);

ActionListener a3 = (ae) -> {
UpdateStudent u = new UpdateStudent();
dispose();
};
btnUpdate.addActionListener(a3);

ActionListener a4 = (ae) -> {
DeleteStudent d = new DeleteStudent();
dispose();
};
btnDelete.addActionListener(a4);

setTitle(".Student Management.");
setSize(280,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

class DbHandler{

//Add
public void addStudent(int Sid, String Sname , int Smarks){

Connection con = null;
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
"system","abc123");

String sql = "insert into NewStudent values(?,?,?)";
PreparedStatement pst = con.prepareStatement(sql);
pst.setInt(1,Sid);
pst.setString(2,Sname);
pst.setInt(3,Smarks);
int result = pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),result + " Record inserted.");
pst.close();

}
catch(SQLException te){
JOptionPane.showMessageDialog(new JDialog()," This record already exists!!");
}
catch(Exception ae){
JOptionPane.showMessageDialog(new JDialog()," Plz Enter Proper Values");
}
finally{
try{
if(con!=null)
	con.close();
}
catch(SQLException se){

}
}
}

//View
public String viewStudent(){

Connection con =null;
StringBuffer sb = new StringBuffer();

try{

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
"system","abc123");

Statement stmt = con.createStatement();
String sql = "select* from NewStudent order by Sid";//change
ResultSet rs = stmt.executeQuery(sql);

while(rs.next())
{
int Sid = rs.getInt(1);
String Sname = rs.getString(2);
int Smarks = rs.getInt(3);
sb.append("Student Id: "+Sid+" Name: "+Sname+" Marks: "+Smarks+"\n");
}
stmt.close();
}
catch(Exception ve){
JOptionPane.showMessageDialog(new JDialog(),"View Issues...");
}


finally{
try{
if(con!=null)
	con.close();
}
catch(SQLException sv){

}
return sb.toString();
}
}

//Delete
public void deleteStudent(int Sid){

Connection con = null;
try{

int op = JOptionPane.showConfirmDialog(new JDialog() , "Do you really want to delete ");
if(op == JOptionPane.YES_OPTION)
{

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
"system","abc123");

String sql = "delete from NewStudent where SID=?";
PreparedStatement pst = con.prepareStatement(sql);
pst.setInt(1,Sid);
int r = pst.executeUpdate();

if(r==1)
	JOptionPane.showMessageDialog(new JDialog() , r+" Row Deleted");	
	
else
	JOptionPane.showMessageDialog(new JDialog() , "But This Record doesnot exists!!");
}
}//If block ends

catch(Exception de){
JOptionPane.showMessageDialog(new JDialog() , "Delete Issues..");

}

finally{
try{
if(con!=null)
	con.close();
}
catch(SQLException sv){
}
}//try block ends 
}//method ends


//Update
public void updateStudent(int Sid, String Sname, int Smarks){

Connection con = null;
try{

int op = JOptionPane.showConfirmDialog(new JDialog() , "Do you really want to Update ");
if(op == JOptionPane.YES_OPTION)
{

DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
"system","abc123");


String sql = "update NewStudent set SNAME=?, SMARKS=? where SID=? ";
PreparedStatement pst = con.prepareStatement(sql);
pst.setString(1,Sname);
pst.setInt(2,Smarks);
pst.setInt(3,Sid);
int r = pst.executeUpdate();

if(r==1)
	JOptionPane.showMessageDialog(new JDialog(), r+" Row Updated");
else
	JOptionPane.showMessageDialog(new JDialog() , "But This Record doesnot exists!!");
}
}//if block ends

catch(Exception ue){
JOptionPane.showMessageDialog(new JDialog() , " Update Issues..");
}

finally{
try{
if(con!=null)
	con.close();
}
catch(SQLException uv){
}
}
}//try block ends

}//method ends
