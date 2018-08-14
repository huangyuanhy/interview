package resume;


	import javax.swing.*;  
	  
	import java.awt.*;  
	import java.awt.event.*;  
	import java.io.BufferedWriter;  
	import java.io.File;  
	import java.io.FileWriter;  
	import java.io.IOException;  
	  
	  
	public class Resume extends JFrame implements ActionListener {  
	 private static final Frame MainFrame = null;  
	 private static final ActionListener AboutActionListener = null;  
	 Container container;  
	 JPanel py,py2,py3,py4,py5,py6,py7,py8,py9,py10,py11;  
	 JTextField nameFieldText;  
	 JTextArea dataContent;  
	 JButton button1,button2,button3;  
	 JButton button4;  
	 ButtonGroup sexGroup;  
	 JRadioButton men;  
	 JRadioButton wonmen;  
	 JTextField adressFieldText;//סַ  
	 JTextField zhuanyeTextField;//��ѧרҵ  
	 JTextField schoolJTextField;//��ҵԺУ  
	 JTextField filenameJTextField;//�ļ���  
	 JTextField oldFieldText;//����  
	 JComboBox zhengzhi;//������ò  
	 JList bookListBox;//��ѡ�γ�  
	 JComboBox year,month,day;  
	 JCheckBox chb1,chb2,chb3,chb4,chb5,chb6,chb7;//����  
	 JScrollPane bookScrollPane;  
	 JFileChooser fc=new JFileChooser();//�����ļ��Ի������  
	 public Resume(){  
	  container=this.getContentPane();  
	  this.setTitle("���˼�����ƴ���");//���ñ���  
	  //container.setBackground(Color(100,200,300));  
	  container=this.getContentPane();//��ȡĬ�ϵ����ݴ���  
	  container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));//��Ʋ��ָ�ʽ  
	    
	       
	     py=new JPanel();  
	  py.setLayout(new FlowLayout(FlowLayout.CENTER));  
	     //py.setBackground(Color.black);  
	  JLabel reIDLable=new JLabel ("���˼���");  
	  Font font=new Font(null,Font.BOLD,32);  
	  reIDLable.setFont(font);  
	  //reIDLable.setForeground(Color.red);  
	     py.add(reIDLable);  
	     
	  container.add(py);  
	    
	  py2=new JPanel();  
	  py2.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel nameIDLable=new JLabel ("������");  
	  nameFieldText=new JTextField(20);  
	  JLabel sexLable=new JLabel ("             �Ա�");  
	  men=new JRadioButton("��");  
	  wonmen=new JRadioButton("Ů");  
	     sexGroup=new ButtonGroup();  
	  sexGroup.add(men);  
	  sexGroup.add(wonmen);  
	  men.setSelected(true);  
	  py2.add(nameIDLable);  
	  py2.add(nameFieldText);  
	  py2.add(sexLable);  
	  py2.add(men);  
	  py2.add(wonmen);  
	  container.add(py2);  
	  
	   
	  py3=new JPanel();  
	  py3.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel birthdayLable=new JLabel ("���գ�");  
	  year=new JComboBox();  
	  int i;  
	  for(i=1900;i<=2012;i++)  
	  {  
	   year.addItem(new Integer(i));  
	  }  
	  year.addActionListener(new oddActionListener());  
	  year.addActionListener(new ymActionListener());  
	  month=new JComboBox();  
	  for(i=1;i<=12;i++)  
	  {  
	   month.addItem(new Integer(i));  
	  }  
	  day=new JComboBox();  
	  for(i=1;i<=31;i++)  
	    {  
	   day.addItem(new Integer(i));  
	  }  
	  month.addActionListener(new ymActionListener());  
	    
	  JLabel yearbirthdayLable=new JLabel ("  ��   ");  
	  JLabel monthbirthdayLable=new JLabel ("  ��   ");  
	  JLabel daybirthdayLable=new JLabel ("  ��   ");  
	  JLabel oldbirthdayLable=new JLabel (" ����:");  
	    
	   oldFieldText=new JTextField(4);  
	   oldFieldText.setEditable(false);  
	   oldFieldText.setText("113");  
	    
	  py3.add(birthdayLable);  
	  py3.add(year);  
	  py3.add(yearbirthdayLable);  
	  py3.add(month);  
	  py3.add(monthbirthdayLable);  
	  py3.add(day);  
	  py3.add(daybirthdayLable);  
	  py3.add(oldbirthdayLable);  
	  py3.add(oldFieldText);  
	  container.add(py3);   
	    
	  py4=new JPanel();  
	  py4.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel adressLable=new JLabel ("סַ��");  
	  adressFieldText=new JTextField(35);  
	  //adressFieldText.setForeground(Color.red);  
	    
	  py4.add(adressLable);  
	  py4.add(adressFieldText);  
	  container.add(py4);  
	    
	  py5=new JPanel();  
	  py5.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel zhengzhiLable=new JLabel ("������ò��");  
	  zhengzhi=new JComboBox();  
	  zhengzhi.addItem("��Ա");  
	  zhengzhi.addItem("��Ա");  
	  zhengzhi.addItem("Ⱥ��");  
	  zhengzhi.addItem("������������");  
	  py5.add(zhengzhiLable);  
	  py5.add(zhengzhi);  
	  zhengzhi.setEditable(false);  
	    
	  JLabel courseLable=new JLabel("       ��ѡ�γ̣�");  
	  //JPanel bottomPanel;  
	  bookListBox=new JList();  
	  String data[]={"Java�������","VB.net�������","��ҳ����","Flash��������","SQL���ݿ�","Ӣ��","����"};  
	  bookListBox.setListData(data);  
	  bookListBox.setVisibleRowCount(4);  
	  bookScrollPane=new JScrollPane(bookListBox);  
	  py5.add(courseLable);  
	  py5.add(bookScrollPane);  
	  container.add(py5);  
	     
	  py6=new JPanel();  
	  py6.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel zhuanyeLable=new JLabel("��ѧרҵ��");  
	  zhuanyeTextField=new JTextField(33);  
	  py6.add(zhuanyeLable);  
	  py6.add(zhuanyeTextField);  
	  container.add(py6);  
	    
	  py7=new JPanel();  
	  py7.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel  hobbyLabel=new JLabel("����:");  
	  chb1=new JCheckBox("����");  
	  chb2=new JCheckBox("����");  
	  chb3=new JCheckBox("ƹ����");  
	  chb4=new JCheckBox("����");  
	  chb5=new JCheckBox("����");  
	  chb6=new JCheckBox("���� ");  
	  chb7=new JCheckBox("����");  
	  py7.add(hobbyLabel);  
	  py7.add(chb1);  
	  py7.add(chb2);  
	  py7.add(chb3);  
	  py7.add(chb4);  
	  py7.add(chb5);  
	  py7.add(chb6);  
	  py7.add(chb7);  
	  container.add(py7);  
	    
	  py8=new JPanel();  
	  py8.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel schoolLabel=new JLabel("��ҵԺУ��");  
	  schoolJTextField=new JTextField(33);  
	  py8.add(schoolLabel);  
	  py8.add(schoolJTextField);  
	  container.add(py8);  
	    
	  py9=new JPanel();  
	  py9.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel filenameLabel=new JLabel("�ļ����� ");  
	  filenameJTextField=new JTextField(34);  
	  py9.add(filenameLabel);  
	  py9.add(filenameJTextField);  
	  container.add(py9);  
	    
	    
	  py11=new JPanel();  
	  py11.setLayout(new BorderLayout());  
	  dataContent=new JTextArea();  
	  dataContent.setEditable(false);  
	  dataContent.setSize(50, 50);  
	  JScrollPane scrollPane=new JScrollPane(dataContent);scrollPane.setSize(200, 200);  
	  scrollPane.setViewportView(dataContent);  
	  scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	  scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	    
	  py11.add(scrollPane);//,BorderLayout.CENTER);  
	  container.add(py11);  
	    
	    
	  py10=new JPanel();  
	  py10.setLayout(new FlowLayout());  
	  button1=new JButton("�ύ   ");  
	     button2=new JButton("����   ");  
	  button3=new JButton("�˳�    ");  
	  button4=new JButton("���    ");  
	  py10.add(button1);  
	  py10.add(button2);  
	  py10.add(button3);  
	  py10.add(button4);  
	  container.add(py10);  
	    
	    
	    
	  ///////  
	  button1.addActionListener(new button1Listenner());  
	  button2.addActionListener(new button2ActionListener());  
	  button3.addActionListener(new button3Listenner());  
	  button4.addActionListener(new button4Listenner());  
	  this.setVisible(true);  
	   
	  /*JDialog dialog=new JDialog(MainFrame,"���˼���",true); 
	  container=dialog.getContentPane(); 
	  //container.setLayout(new GridLayout(2,3));*/  
	    
	  //  
	  JMenuBar menuBar=new JMenuBar();//�����˵���  
	  buildMainMenu(menuBar);//�Զ����齨�˵��ķ���  
	  this.setJMenuBar(menuBar);//�Ѳ˵����ҵ��ô�����  
	  this.show(true);//��ʾ����  
	  this.setSize(490,650);//���ô��ڴ�С  
	    
	   
	 }  
	   
	 //public void actionPerformed(ActionEvent e){  
	 class button1Listenner implements ActionListener  
	 {  
	  public void actionPerformed(ActionEvent arg0) {  
	   
	  String str1="������";  
	  String str2="";  
	  String str;  
	    
	  str=nameFieldText.getText();  
	  str1+=str;  
	    
	  str1+="\n";  
	     str2=adressFieldText.getText();  
	  String str3=zhuanyeTextField.getText();  
	  String str4=schoolJTextField.getText();  
	  String str5=filenameJTextField.getText();  
	  if(str!=null&&!str.equals(""))  
	  dataContent.setText(str1);  
	    
	  if(men.isSelected())  
	   dataContent.append("�Ա���\n");  
	  else  
	   dataContent.append("�Ա�Ů\n");  
	  String str7=oldFieldText.getText();  
	  dataContent.append("���䣺"+str7+"\n");  
	  String str6;  
	  str6=zhengzhi.getSelectedItem().toString();  
	  dataContent.append("������ò��"+str6+"\n");  
	  //////////////////  
	  dataContent.append("��ѡ�γ̣�");  
	  Object[]da;  
	  da=bookListBox.getSelectedValues();  
	  int i;  
	  for( i=0;i<da.length;i++)  
	  {  
	   dataContent.append("��"+da[i].toString()+"��");  
	  }  
	  dataContent.append("\n");  
	//////////////////  
	    
	  if(str2!=null&&!str2.equals(""))  
	   dataContent.append("סַ��"+str2+"\n");  
	    
	  if(str3!=null&&!str3.equals(""))  
	   dataContent.append("��ѧרҵ��"+str3+"\n");  
	  dataContent.append("���ã�");  
	  if(chb1.isSelected()==true)  
	   dataContent.append("����    ");  
	  if(chb2.isSelected()==true)  
	   dataContent.append("����    ");  
	  if(chb3.isSelected()==true)  
	   dataContent.append("ƹ����    ");  
	  if(chb4.isSelected()==true)  
	   dataContent.append("����    ");  
	  if(chb5.isSelected()==true)  
	   dataContent.append("����    ");  
	  if(chb6.isSelected()==true)  
	   dataContent.append("����    ");  
	  if(chb7.isSelected()==true)  
	   dataContent.append("����    ");  
	  dataContent.append("\n");  
	    
	  if(str4!=null&&!str4.equals(""))  
	   dataContent.append("��ҵԺУ��"+str4+"\n");  
	    
	  if(str5!=null&&!str5.equals(""))  
	   dataContent.append("�ļ�����"+str5+"\n");  
	    
	 }  
	 }  
	 class button3Listenner implements ActionListener{  
	  
	  @Override  
	  public void actionPerformed(ActionEvent arg0) {  
	   // TODO Auto-generated method stub  
	   dispose();  
	   System.exit(0);  
	     
	  }  
	    
	 }  
	   
	   
	   
	 private void buildMainMenu(JMenuBar menuBar) {   
	  // TODO Auto-generated method stub  
	  JMenu fileMenu=new JMenu("�ļ�(F)");//�ļ��˵��Ĵ���  
	  JMenuItem exitMenuItem=new JMenuItem("�˳�");  
	  JMenuItem saveMenuItem=new JMenuItem("����");  
	  JMenuItem clerMenuItem=new JMenuItem("���");  
	  JMenuItem getMenuItem=new JMenuItem("�ύ");  
	 /*Ϊ�¼�ע�ᣬ��ActionEvent�¼���������*/  
	  exitMenuItem.addActionListener((ActionListener) new ExitActionListener());  
	  saveMenuItem.addActionListener(new button2ActionListener());  
	  clerMenuItem.addActionListener(new button4Listenner());  
	  getMenuItem.addActionListener(new button1Listenner());  
	  fileMenu.add(getMenuItem);  
	  fileMenu.add(saveMenuItem);  
	  fileMenu.add(clerMenuItem);  
	  fileMenu.add(exitMenuItem);//���˳��˵�����ӵ��˵���  
	  menuBar.add(fileMenu);//�ļ��˵���ӵ��˵�����  
	    
	    
	  /*��ɫ*/  
	  JMenu colorMunu=new JMenu("��ɫ(C)");  
	  colorMunu.setMnemonic(KeyEvent.VK_C);  
	  JMenuItem greenMenuItem=new JMenuItem("��ɫ");   
	  greenMenuItem.addActionListener(new greenActionListener());  
	  JMenuItem redMenuItem=new JMenuItem("��ɫ");   
	  redMenuItem.addActionListener(new redActionListener());  
	  JMenuItem yellowMenuItem=new JMenuItem("��ɫ");   
	  yellowMenuItem.addActionListener(new yellowActionListener());  
	  JMenuItem yuanlaiMenuItem=new JMenuItem("ԭɫ");   
	  yuanlaiMenuItem.addActionListener(new yuanlaiActionListener());  
	  colorMunu.add(greenMenuItem);  
	  colorMunu.add(redMenuItem);  
	  colorMunu.add(yellowMenuItem);  
	  colorMunu.add(yuanlaiMenuItem);  
	  menuBar.add(colorMunu);  
	  /*��֮�˵��Ĵ���*/  
	  JMenu helpMunu=new JMenu("����(H)");  
	  helpMunu.setMnemonic(KeyEvent.VK_H);  
	  JMenuItem aboutMenuItem=new JMenuItem("����");   
	  aboutMenuItem.addActionListener(new AboutActionListener());  
	  helpMunu.add(aboutMenuItem);  
	  menuBar.add(helpMunu);  
	    
	    
	    
	 }  
	  class button4Listenner implements ActionListener{  
	  
	   @Override  
	   public void actionPerformed(ActionEvent e) {  
	    // TODO Auto-generated method stub  
	    String str;  
	    str="";  
	    dataContent.setText(str);  
	    nameFieldText.setText("");  
	    adressFieldText.setText("");  
	    zhuanyeTextField.setText("");  
	    schoolJTextField.setText("");  
	    filenameJTextField.setText("");  
	    chb1.setSelected(false);  
	    chb2.setSelected(false);  
	    chb3.setSelected(false);  
	    chb4.setSelected(false);  
	    chb5.setSelected(false);  
	    chb6.setSelected(false);  
	    chb7.setSelected(false);  
	   }  
	     
	  }  
	    
	 public class button2ActionListener implements ActionListener  
	 {  
	  
	  @Override  
	  public void actionPerformed(ActionEvent e) {  
	   // TODO Auto-generated method stub  
	    int select=fc.showSaveDialog(button2);  
	    String text = dataContent.getText().replaceAll("\n", "\r\n");//taΪ�ı���  
	;  
	             try{  
	              File file=fc.getSelectedFile();  
	                 FileWriter fw = new FileWriter(file);  
	                 BufferedWriter bw = new BufferedWriter(fw);  
	                 bw.write(text);  
	                 bw.close();  
	             }catch(IOException ex){  
	                 ex.printStackTrace();  
	             }  
	         }  
	  
	    
	 }  
	 public class ymActionListener implements ActionListener  
	 {  
	  
	  @Override  
	  public void actionPerformed(ActionEvent arg0) {  
	   // TODO Auto-generated method stub  
	   int []days={0,31,28,31,30,31,30,31,31,30,31,30,31};  
	   Integer years,months;  
	   years=(Integer)year.getSelectedItem();  
	   months=(Integer)month.getSelectedItem();  
	   if(years.intValue()%4==0&&years.intValue()%100!=0 || years.intValue()%400==0 )  
	   {  
	    days[2]=29;  
	   }  
	   else days[2]=28;  
	   int i;  
	   day.removeAllItems();  
	   for(i=1;i<=days[months.intValue()];i++)  
	   {  
	    day.addItem(new Integer(i));  
	   }  
	  }  
	    
	 }  
	 public class oddActionListener implements ActionListener  
	 {  
	  
	  @Override  
	  public void actionPerformed(ActionEvent arg0) {  
	   // TODO Auto-generated method stub  
	   Integer a;  
	   int i;  
	   a=(Integer)year.getSelectedItem();  
	   i=a.intValue();  
	   i=2013-i;  
	   a=new Integer(i);  
	   oldFieldText.setText(a.toString());  
	  }  
	    
	 }  
	 class greenActionListener implements ActionListener{  
	  
	  @Override  
	  public void actionPerformed(ActionEvent e) {  
	   // TODO Auto-generated method stub  
	   py.setBackground(Color.green);  
	   py.setBackground(Color.green);  
	   py2.setBackground(Color.green);  
	   py3.setBackground(Color.green);  
	   py4.setBackground(Color.green);  
	   py5.setBackground(Color.green);  
	   py6.setBackground(Color.green);  
	   py7.setBackground(Color.green);  
	   py8.setBackground(Color.green);  
	   py9.setBackground(Color.green);  
	   py10.setBackground(Color.green);  
	   py11.setBackground(Color.green);  
	   nameFieldText.setBackground(Color.green);  
	   men.setBackground(Color.green);  
	   wonmen.setBackground(Color.green);  
	   year.setBackground(Color.green);  
	   month.setBackground(Color.green);  
	   day.setBackground(Color.green);  
	   oldFieldText.setBackground(Color.green);  
	   adressFieldText.setBackground(Color.green);  
	   zhengzhi.setBackground(Color.green);  
	   bookListBox.setBackground(Color.green);  
	   bookScrollPane.setBackground(Color.green);  
	   zhuanyeTextField.setBackground(Color.green);  
	   chb1.setBackground(Color.green);  
	   chb2.setBackground(Color.green);  
	   chb3.setBackground(Color.green);  
	   chb4.setBackground(Color.green);  
	   chb5.setBackground(Color.green);  
	   chb6.setBackground(Color.green);  
	   chb7.setBackground(Color.green);  
	   schoolJTextField.setBackground(Color.green);  
	   filenameJTextField.setBackground(Color.green);  
	   dataContent.setBackground(Color.green);  
	   button1.setBackground(Color.green);  
	   button2.setBackground(Color.green);  
	   button3.setBackground(Color.green);  
	   button4.setBackground(Color.green);  
	     
	  }  
	  
	    
	 }  
	 class redActionListener implements ActionListener{  
	  
	  @Override  
	  public void actionPerformed(ActionEvent e) {  
	   // TODO Auto-generated method stub  
	   py.setBackground(Color.red);  
	   py2.setBackground(Color.red);  
	   py3.setBackground(Color.red);  
	   py4.setBackground(Color.red);  
	   py5.setBackground(Color.red);  
	   py6.setBackground(Color.red);  
	   py7.setBackground(Color.red);  
	   py8.setBackground(Color.red);  
	   py9.setBackground(Color.red);  
	   py10.setBackground(Color.red);  
	   py11.setBackground(Color.red);  
	   nameFieldText.setBackground(Color.red);  
	   men.setBackground(Color.red);  
	   wonmen.setBackground(Color.red);  
	   year.setBackground(Color.red);  
	   month.setBackground(Color.red);  
	   day.setBackground(Color.red);  
	   oldFieldText.setBackground(Color.red);  
	   adressFieldText.setBackground(Color.red);  
	   zhengzhi.setBackground(Color.red);  
	   bookListBox.setBackground(Color.red);  
	   bookScrollPane.setBackground(Color.red);  
	   zhuanyeTextField.setBackground(Color.red);  
	   chb1.setBackground(Color.red);  
	   chb2.setBackground(Color.red);  
	   chb3.setBackground(Color.red);  
	   chb4.setBackground(Color.red);  
	   chb5.setBackground(Color.red);  
	   chb6.setBackground(Color.red);  
	   chb7.setBackground(Color.red);  
	   schoolJTextField.setBackground(Color.red);  
	   filenameJTextField.setBackground(Color.red);  
	   dataContent.setBackground(Color.red);  
	   button1.setBackground(Color.red);  
	   button2.setBackground(Color.red);  
	   button3.setBackground(Color.red);  
	   button4.setBackground(Color.red);  
	     
	  }  
	    
	 }  
	 class yellowActionListener implements ActionListener{  
	  
	  @Override  
	  public void actionPerformed(ActionEvent e) {  
	   // TODO Auto-generated method stub  
	   py.setBackground(Color.yellow);  
	   py2.setBackground(Color.yellow);  
	   py3.setBackground(Color.yellow);  
	   py4.setBackground(Color.yellow);  
	   py5.setBackground(Color.yellow);  
	   py6.setBackground(Color.yellow);  
	   py7.setBackground(Color.yellow);  
	   py8.setBackground(Color.yellow);  
	   py9.setBackground(Color.yellow);  
	   py10.setBackground(Color.yellow);  
	   py11.setBackground(Color.yellow);  
	   nameFieldText.setBackground(Color.yellow);  
	   men.setBackground(Color.yellow);  
	   wonmen.setBackground(Color.yellow);  
	   year.setBackground(Color.yellow);  
	   month.setBackground(Color.yellow);  
	   day.setBackground(Color.yellow);  
	   oldFieldText.setBackground(Color.yellow);  
	   adressFieldText.setBackground(Color.yellow);  
	   zhengzhi.setBackground(Color.yellow);  
	   bookListBox.setBackground(Color.yellow);  
	   bookScrollPane.setBackground(Color.yellow);  
	   zhuanyeTextField.setBackground(Color.yellow);  
	   chb1.setBackground(Color.yellow);  
	   chb2.setBackground(Color.yellow);  
	   chb3.setBackground(Color.yellow);  
	   chb4.setBackground(Color.yellow);  
	   chb5.setBackground(Color.yellow);  
	   chb6.setBackground(Color.yellow);  
	   chb7.setBackground(Color.yellow);  
	   schoolJTextField.setBackground(Color.yellow);  
	   filenameJTextField.setBackground(Color.yellow);  
	   dataContent.setBackground(Color.yellow);  
	   button1.setBackground(Color.yellow);  
	   button2.setBackground(Color.yellow);  
	   button3.setBackground(Color.yellow);  
	   button4.setBackground(Color.yellow);  
	     
	  }  
	    
	 }  
	 class yuanlaiActionListener implements ActionListener{  
	  
	    
	  
	  @Override  
	  public void actionPerformed(ActionEvent e) {  
	   // TODO Auto-generated method stub  
	   py.setBackground(Color(238,238,238));  
	   py.setBackground(Color(238,238,238));  
	   py2.setBackground(Color(238,238,238));  
	   py3.setBackground(Color(238,238,238));  
	   py4.setBackground(Color(238,238,238));  
	   py5.setBackground(Color(238,238,238));  
	   py6.setBackground(Color(238,238,238));  
	   py7.setBackground(Color(238,238,238));  
	   py8.setBackground(Color(238,238,238));  
	   py9.setBackground(Color(238,238,238));  
	   py10.setBackground(Color(238,238,238));  
	   py11.setBackground(Color(238,238,238));  
	   nameFieldText.setBackground(Color(238,238,238));  
	   men.setBackground(Color(238,238,238));  
	   wonmen.setBackground(Color(238,238,238));  
	   year.setBackground(Color(238,238,238));  
	   month.setBackground(Color(238,238,238));  
	   day.setBackground(Color(238,238,238));  
	   oldFieldText.setBackground(Color(238,238,238));  
	   adressFieldText.setBackground(Color(238,238,238));  
	   zhengzhi.setBackground(Color(238,238,238));  
	   bookListBox.setBackground(Color(238,238,238));  
	   bookScrollPane.setBackground(Color(238,238,238));  
	   zhuanyeTextField.setBackground(Color(238,238,238));  
	   chb1.setBackground(Color(238,238,238));  
	   chb2.setBackground(Color(238,238,238));  
	   chb3.setBackground(Color(238,238,238));  
	   chb4.setBackground(Color(238,238,238));  
	   chb5.setBackground(Color(238,238,238));  
	   chb6.setBackground(Color(238,238,238));  
	   chb7.setBackground(Color(238,238,238));  
	   schoolJTextField.setBackground(Color(238,238,238));  
	   filenameJTextField.setBackground(Color(238,238,238));  
	   dataContent.setBackground(Color(238,238,238));  
	   button1.setBackground(Color(238,238,238));  
	   button2.setBackground(Color(238,238,238));  
	   button3.setBackground(Color(238,238,238));  
	   button4.setBackground(Color(238,238,238));  
	     
	  }  
	  
	  private java.awt.Color Color(int i, int j, int k) {  
	   // TODO Auto-generated method stub  
	   return null;  
	  }  
	  
	    
	 }  
	 /*�ļ��˵����˳��˵�����¼�������*/  
	 class  ExitActionListener implements ActionListener{  
	  
	  public void actionPerformed(ActionEvent event){  
	   dispose();  
	   System.exit(0);  
	  }  
	 }  
	 class AboutActionListener implements ActionListener{  
	  public void actionPerformed(ActionEvent event){  
	   String msg="��Ʒ �����˼�������\n���ң�֣���ṤҵѧԺ\n�����ߣ���ͨ�ƿ�10-01   �¶���\n�������ڣ�2012��5��18��\n";  
	   String title="���˼���";  
	   JOptionPane.showMessageDialog(container, msg,title,JOptionPane.INFORMATION_MESSAGE);  
	  }  
	 }  
	 public static void main(String[] args){  
	  new Resume();  
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}  
	  
	}
