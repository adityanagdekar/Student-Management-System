//ViewStudent
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewStudent extends JFrame{
Container c;
JButton btnBack;
TextArea tsData;
JScrollPane scroll;

ViewStudent(){
c = getContentPane();
c.setLayout(new FlowLayout());
btnBack = new JButton("Back");
tsData = new TextArea(8,30);
scroll = new JScrollPane(tsData);
scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

c.add(tsData);
//c.add(scroll);
c.add(btnBack);


String Data = new DbHandler().viewStudent();
if(Data.length()==0){
	String msg = "Nothing To show here";
	tsData.setText(msg);
}
else{
tsData.setText(Data);
tsData.setEditable(false);
}


ActionListener a1 = (ae) -> {
MainStudent m = new MainStudent();
dispose();
};
btnBack.addActionListener(a1);

setTitle("Add Student");
setSize(280,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}