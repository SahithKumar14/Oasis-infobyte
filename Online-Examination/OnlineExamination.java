import java.lang.Exception; 
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 
import java.util.TimerTask;
import java.util.Timer; 

class Login extends JFrame implements ActionListener  
{   
    JPanel newPanel; 
    JButton button1;  
    JLabel userIdLabel, passwordLabel;  
    final JTextField  textField1, textField2;  
    Login()  
    {     
        userIdLabel = new JLabel();  
        userIdLabel.setText("    Username :");      
        textField1 = new JTextField(17);      
        passwordLabel = new JLabel();  
        passwordLabel.setText("    Password :");        
        textField2 = new JPasswordField(10);     
        button1 = new JButton("   SUBMIT   ");  
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userIdLabel);     
        newPanel.add(textField1);  
        newPanel.add(passwordLabel);    
        newPanel.add(textField2);   
        newPanel.add(button1);          
        add(newPanel, BorderLayout.CENTER);  
        button1.addActionListener(this);    
        setTitle("Login Form ");         
    }   
    public void actionPerformed(ActionEvent actionEvent)     
    {  
        String userIdValue = textField1.getText();        
        String passwordValue = textField2.getText();       
        if(!passwordValue.equals(""))
            new OnlineTestBegin(userIdValue); 
        else{
            textField2.setText("Enter Password");
            actionPerformed(actionEvent);
        }
    }     
}  
class OnlineTestBegin extends JFrame implements ActionListener  
{  
    JRadioButton jb[]=new JRadioButton[6]; 
    JLabel label;  
    JLabel label1;   
    JButton button1,button2,log;  
    ButtonGroup buttonGroup;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];  
    Timer timer = new Timer();  
    OnlineTestBegin(String s)  
    {      
        super(s); 
        label=new JLabel();
        label1 = new JLabel();  
        add(label);
        add(label1);  
        buttonGroup=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            buttonGroup.add(jb[i]);  
        }  
        button1=new JButton("Save and Next");  
        button2=new JButton("Save for later");  
        button1.addActionListener(this);  
        button2.addActionListener(this);  
        add(button1);add(button2);  
        set();  
        label.setBounds(30,40,450,20);
        label1.setBounds(20,20,450,20);
        jb[0].setBounds(50,80,250,20);  
        jb[1].setBounds(50,110,250,20);  
        jb[2].setBounds(50,140,250,20);  
        jb[3].setBounds(50,170,250,20);  
        button1.setBounds(95,240,140,30);  
        button2.setBounds(270,240,150,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(1000,650);     
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 100;
            public void run() {  
                label1.setText("Time left: " + i);
                i--;   
                if (i < 0) {
                    timer.cancel();
                    label1.setText("Time Out");                     
                } 
            }
        }, 0, 1000);        
    }  
    public void actionPerformed(ActionEvent e)  
    {          
        if(e.getSource()==button1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                button1.setEnabled(false);  
                button2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Save for later"))  
        {  
            JButton bk=new JButton("Review"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                button2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Review"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"Score ="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            label.setText("Que1: Who is known as father of java programming language?");  
            jb[0].setText("charles Babbage");jb[1].setText("James Gosling");jb[2].setText("M.P.Java");jb[3].setText("Blais Pascal");   
        }  
        if(current==1)  
        {  
            label.setText("Que2: What are the top Java Features?");  
            jb[0].setText("Platform Independent");jb[1].setText("Object-Oriented");jb[2].setText("Secured");jb[3].setText("All of the above");  
        }  
        if(current==2)  
        {  
            label.setText("Que3: Which of the following is not an OOPS concept in java?");  
            jb[0].setText("Inheritance");jb[1].setText("Polymorphism");jb[2].setText("Encapsulation");jb[3].setText("Compilation");  
    
        }  
        if(current==3)  
        {  
            label.setText("Que4: Exception created by try block is caught in which block.?");  
            jb[0].setText("catch");jb[1].setText("throw");jb[2].setText("final");jb[3].setText("thrown");  
        }  
        if(current==4)  
        {  
            label.setText("Que5: Where is system class defined?");  
            jb[0].setText("java.lang.package");jb[1].setText("java.util.package ");jb[2].setText("java.lo.package");jb[3].setText("None");  
       
               }  
        if(current==5)  
        {  
            label.setText("Que6: Identify the infinite loop?");  
            jb[0].setText("for(;;)");jb[1].setText("for()i=0;j<1;i--");jb[2].setText("for(int=0;i++)");jb[3].setText("if(All of the above)");  
        }  
        if(current==6)  
        {  
            label.setText("Que9: The class at the top of exception class is....?");  
            jb[0].setText("ArithmeticException");jb[1].setText("Throwable");jb[2].setText("Object");jb[3].setText("Console");  
       
        }  
        if(current==7)  
        {  
            label.setText("Que7: Which is used to find and fix bugs in the Java programs. ");  
            jb[0].setText("JVM");jb[1].setText("JRE");jb[2].setText("JDK");  
                        jb[3].setText("JDB");          
        }  
        if(current==8)  
        {  
            label.setText("Que8: Which of the following is not a Java features?");  
            jb[0].setText("Dynamic");jb[1].setText("Architecture Neutral");jb[2].setText("Use of pointers");  
                        jb[3].setText("Object-oriented"); 
        }  
        if(current==9)  
        {  
            label.setText("Que10: Which provides runtime enviroment for java byte code to be executed?");  
            jb[0].setText("JDK");jb[1].setText("JVM");jb[2].setText("JRE");  
                        jb[3].setText("JAVAC");  
        }  
        label.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[3].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[3].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[2].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }    
} 
class OnlineExamination  
{  
    public static void main(String args[])  
    {  
        try  
        {  
            Login form = new Login();  
            form.setSize(500,300);  
            form.setVisible(true);  
        }  
        catch(Exception e)  
        {     
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
} 
