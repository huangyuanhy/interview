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
	 JTextField adressFieldText;//住址  
	 JTextField zhuanyeTextField;//所学专业  
	 JTextField schoolJTextField;//毕业院校  
	 JTextField filenameJTextField;//文件名  
	 JTextField oldFieldText;//年龄  
	 JComboBox zhengzhi;//政治面貌  
	 JList bookListBox;//所选课程  
	 JComboBox year,month,day;  
	 JCheckBox chb1,chb2,chb3,chb4,chb5,chb6,chb7;//爱好  
	 JScrollPane bookScrollPane;  
	 JFileChooser fc=new JFileChooser();//创建文件对话框对象  
	 public Resume(){  
	  container=this.getContentPane();  
	  this.setTitle("个人简历设计窗口");//设置标题  
	  //container.setBackground(Color(100,200,300));  
	  container=this.getContentPane();//获取默认的内容窗格  
	  container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));//设计布局格式  
	    
	       
	     py=new JPanel();  
	  py.setLayout(new FlowLayout(FlowLayout.CENTER));  
	     //py.setBackground(Color.black);  
	  JLabel reIDLable=new JLabel ("个人简历");  
	  Font font=new Font(null,Font.BOLD,32);  
	  reIDLable.setFont(font);  
	  //reIDLable.setForeground(Color.red);  
	     py.add(reIDLable);  
	     
	  container.add(py);  
	    
	  py2=new JPanel();  
	  py2.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel nameIDLable=new JLabel ("姓名：");  
	  nameFieldText=new JTextField(20);  
	  JLabel sexLable=new JLabel ("             性别：");  
	  men=new JRadioButton("男");  
	  wonmen=new JRadioButton("女");  
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
	  JLabel birthdayLable=new JLabel ("生日：");  
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
	    
	  JLabel yearbirthdayLable=new JLabel ("  年   ");  
	  JLabel monthbirthdayLable=new JLabel ("  月   ");  
	  JLabel daybirthdayLable=new JLabel ("  日   ");  
	  JLabel oldbirthdayLable=new JLabel (" 年龄:");  
	    
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
	  JLabel adressLable=new JLabel ("住址：");  
	  adressFieldText=new JTextField(35);  
	  //adressFieldText.setForeground(Color.red);  
	    
	  py4.add(adressLable);  
	  py4.add(adressFieldText);  
	  container.add(py4);  
	    
	  py5=new JPanel();  
	  py5.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel zhengzhiLable=new JLabel ("政治面貌：");  
	  zhengzhi=new JComboBox();  
	  zhengzhi.addItem("团员");  
	  zhengzhi.addItem("党员");  
	  zhengzhi.addItem("群众");  
	  zhengzhi.addItem("其他民主党派");  
	  py5.add(zhengzhiLable);  
	  py5.add(zhengzhi);  
	  zhengzhi.setEditable(false);  
	    
	  JLabel courseLable=new JLabel("       所选课程：");  
	  //JPanel bottomPanel;  
	  bookListBox=new JList();  
	  String data[]={"Java程序设计","VB.net程序设计","网页制作","Flash动画制作","SQL数据库","英语","物理"};  
	  bookListBox.setListData(data);  
	  bookListBox.setVisibleRowCount(4);  
	  bookScrollPane=new JScrollPane(bookListBox);  
	  py5.add(courseLable);  
	  py5.add(bookScrollPane);  
	  container.add(py5);  
	     
	  py6=new JPanel();  
	  py6.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel zhuanyeLable=new JLabel("所学专业：");  
	  zhuanyeTextField=new JTextField(33);  
	  py6.add(zhuanyeLable);  
	  py6.add(zhuanyeTextField);  
	  container.add(py6);  
	    
	  py7=new JPanel();  
	  py7.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel  hobbyLabel=new JLabel("爱好:");  
	  chb1=new JCheckBox("唱歌");  
	  chb2=new JCheckBox("跳舞");  
	  chb3=new JCheckBox("乒乓球");  
	  chb4=new JCheckBox("足球");  
	  chb5=new JCheckBox("篮球");  
	  chb6=new JCheckBox("乐器 ");  
	  chb7=new JCheckBox("表演");  
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
	  JLabel schoolLabel=new JLabel("毕业院校：");  
	  schoolJTextField=new JTextField(33);  
	  py8.add(schoolLabel);  
	  py8.add(schoolJTextField);  
	  container.add(py8);  
	    
	  py9=new JPanel();  
	  py9.setLayout(new FlowLayout(FlowLayout.LEFT));  
	  JLabel filenameLabel=new JLabel("文件名： ");  
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
	  button1=new JButton("提交   ");  
	     button2=new JButton("保存   ");  
	  button3=new JButton("退出    ");  
	  button4=new JButton("清空    ");  
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
	   
	  /*JDialog dialog=new JDialog(MainFrame,"个人简历",true); 
	  container=dialog.getContentPane(); 
	  //container.setLayout(new GridLayout(2,3));*/  
	    
	  //  
	  JMenuBar menuBar=new JMenuBar();//创建菜单栏  
	  buildMainMenu(menuBar);//自定义组建菜单的方法  
	  this.setJMenuBar(menuBar);//把菜单栏挂到该窗口上  
	  this.show(true);//显示窗口  
	  this.setSize(490,650);//设置窗口大小  
	    
	   
	 }  
	   
	 //public void actionPerformed(ActionEvent e){  
	 class button1Listenner implements ActionListener  
	 {  
	  public void actionPerformed(ActionEvent arg0) {  
	   
	  String str1="姓名：";  
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
	   dataContent.append("性别：男\n");  
	  else  
	   dataContent.append("性别：女\n");  
	  String str7=oldFieldText.getText();  
	  dataContent.append("年龄："+str7+"\n");  
	  String str6;  
	  str6=zhengzhi.getSelectedItem().toString();  
	  dataContent.append("政治面貌："+str6+"\n");  
	  //////////////////  
	  dataContent.append("所选课程：");  
	  Object[]da;  
	  da=bookListBox.getSelectedValues();  
	  int i;  
	  for( i=0;i<da.length;i++)  
	  {  
	   dataContent.append("《"+da[i].toString()+"》");  
	  }  
	  dataContent.append("\n");  
	//////////////////  
	    
	  if(str2!=null&&!str2.equals(""))  
	   dataContent.append("住址："+str2+"\n");  
	    
	  if(str3!=null&&!str3.equals(""))  
	   dataContent.append("所学专业："+str3+"\n");  
	  dataContent.append("爱好：");  
	  if(chb1.isSelected()==true)  
	   dataContent.append("唱歌    ");  
	  if(chb2.isSelected()==true)  
	   dataContent.append("跳舞    ");  
	  if(chb3.isSelected()==true)  
	   dataContent.append("乒乓球    ");  
	  if(chb4.isSelected()==true)  
	   dataContent.append("足球    ");  
	  if(chb5.isSelected()==true)  
	   dataContent.append("篮球    ");  
	  if(chb6.isSelected()==true)  
	   dataContent.append("乐器    ");  
	  if(chb7.isSelected()==true)  
	   dataContent.append("表演    ");  
	  dataContent.append("\n");  
	    
	  if(str4!=null&&!str4.equals(""))  
	   dataContent.append("毕业院校："+str4+"\n");  
	    
	  if(str5!=null&&!str5.equals(""))  
	   dataContent.append("文件名："+str5+"\n");  
	    
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
	  JMenu fileMenu=new JMenu("文件(F)");//文件菜单的创建  
	  JMenuItem exitMenuItem=new JMenuItem("退出");  
	  JMenuItem saveMenuItem=new JMenuItem("保存");  
	  JMenuItem clerMenuItem=new JMenuItem("清空");  
	  JMenuItem getMenuItem=new JMenuItem("提交");  
	 /*为事件注册，对ActionEvent事件作出处理*/  
	  exitMenuItem.addActionListener((ActionListener) new ExitActionListener());  
	  saveMenuItem.addActionListener(new button2ActionListener());  
	  clerMenuItem.addActionListener(new button4Listenner());  
	  getMenuItem.addActionListener(new button1Listenner());  
	  fileMenu.add(getMenuItem);  
	  fileMenu.add(saveMenuItem);  
	  fileMenu.add(clerMenuItem);  
	  fileMenu.add(exitMenuItem);//把退出菜单项添加到菜单上  
	  menuBar.add(fileMenu);//文件菜单添加到菜单栏上  
	    
	    
	  /*颜色*/  
	  JMenu colorMunu=new JMenu("颜色(C)");  
	  colorMunu.setMnemonic(KeyEvent.VK_C);  
	  JMenuItem greenMenuItem=new JMenuItem("绿色");   
	  greenMenuItem.addActionListener(new greenActionListener());  
	  JMenuItem redMenuItem=new JMenuItem("红色");   
	  redMenuItem.addActionListener(new redActionListener());  
	  JMenuItem yellowMenuItem=new JMenuItem("黄色");   
	  yellowMenuItem.addActionListener(new yellowActionListener());  
	  JMenuItem yuanlaiMenuItem=new JMenuItem("原色");   
	  yuanlaiMenuItem.addActionListener(new yuanlaiActionListener());  
	  colorMunu.add(greenMenuItem);  
	  colorMunu.add(redMenuItem);  
	  colorMunu.add(yellowMenuItem);  
	  colorMunu.add(yuanlaiMenuItem);  
	  menuBar.add(colorMunu);  
	  /*帮之菜单的创建*/  
	  JMenu helpMunu=new JMenu("帮助(H)");  
	  helpMunu.setMnemonic(KeyEvent.VK_H);  
	  JMenuItem aboutMenuItem=new JMenuItem("关于");   
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
	    String text = dataContent.getText().replaceAll("\n", "\r\n");//ta为文本框  
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
	 /*文件菜单中退出菜单项的事件监听者*/  
	 class  ExitActionListener implements ActionListener{  
	  
	  public void actionPerformed(ActionEvent event){  
	   dispose();  
	   System.exit(0);  
	  }  
	 }  
	 class AboutActionListener implements ActionListener{  
	  public void actionPerformed(ActionEvent event){  
	   String msg="作品 ：个人简历窗口\n厂家：郑州轻工业学院\n制作者：计通计科10-01   陈东东\n生产日期：2012年5月18日\n";  
	   String title="个人简历";  
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
