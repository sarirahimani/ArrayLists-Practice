package project;
import java.util.ArrayList;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class spaceshipTester2 extends JFrame implements ActionListener{
private boolean flag;
	private JLabel radLabel,sNumLabel,heightLabel,matLabel, typeLabel,destLabel,numPLabel,sNumLabelR,heightLabelR,matLabelR,froLabel,file;
	private JTextField SNumInput,heightInput,timeInput,radInput,numPInput,SNumInputR,heightInputR;
	private JPanel inPanel1,outPanel1,mainPanel,inPanel2,outPanel2;
	private JButton enter,enter2,enterFile;
	private JTextArea SSoutput,Routput;
	private JRadioButton typeOne,typeTwo,dest1,dest2,dest3,dest4,dest5,dest6,mat1,mat2,mat3,frover1,frover2,frover3,mat1R,mat2R,mat3R;
	private String sNum; 
	private ButtonGroup buttons,buttons2,buttons3,buttons4,buttons5;
	private double height; 
	private int material;
	private int dest; 
	private int numPass;
	private boolean success;
	private double radius;
	String out1,out2;
	private String sNumR; 
	private double heightR; 
	private int materialR; 
	private int i;
	private Scanner fileIn=null;
	private PrintWriter fileOut=null;
	int frover;

	private spaceship[] ss=new spaceship[20];
	private ArrayList<rover> rov=new ArrayList<rover>();

	public spaceshipTester2(){



		typeOne=new JRadioButton("Manned Spaceship");
		typeTwo=new JRadioButton("Unmanned Spaceship");
		buttons=new ButtonGroup();
		buttons.add(typeOne);
		buttons.add(typeTwo);
		
		dest1=new JRadioButton("Moon");
		dest2=new JRadioButton("Mars");
		dest3=new JRadioButton("Venus");
		dest4=new JRadioButton("Jupiter");
		dest5=new JRadioButton("Saturn");
		dest6=new JRadioButton("Titan");
		buttons2=new ButtonGroup();
		buttons2.add(dest1);
		buttons2.add(dest2);
		buttons2.add(dest3);
		buttons2.add(dest4);
		buttons2.add(dest5);
		buttons2.add(dest6);
		
		mat1=new JRadioButton("Metal Alloy");
		mat2=new JRadioButton("Aluminium");
		mat3=new JRadioButton("Titanium");
		buttons3=new ButtonGroup();
		buttons3.add(mat1);
		buttons3.add(mat2);
		buttons3.add(mat3);

		//create widgets, add action listeners and initialize variables

		sNumLabel = new JLabel("Enter serial Number:");
		heightLabel = new JLabel("Enter height:");
		matLabel = new JLabel("Enter material:");
		radLabel = new JLabel("Enter radius:");
		typeLabel = new JLabel("Enter type of spaceship:");
		destLabel = new JLabel("Enter destination:");
		numPLabel = new JLabel("Enter number of passengers:");
		file = new JLabel("Click to enter file:");

		enter=new JButton("Enter!");
		enter.addActionListener(this);
		enterFile=new JButton("Enter file");
		enterFile.addActionListener(this);
		numPInput = new JTextField(15);
		numPInput.addActionListener(this);
		
		SNumInput = new JTextField(15);
		SNumInput.addActionListener(this);
		
		radInput = new JTextField(15);
		radInput.addActionListener(this);
		
		heightInput = new JTextField(15);
		heightInput.addActionListener(this);

		timeInput = new JTextField(15);
		timeInput.addActionListener(this);
		//set panel layouts
		
		inPanel1 = new JPanel();
		inPanel1.setLayout(new GridLayout(25,5));

		outPanel1 = new JPanel();
		outPanel1.setLayout(new FlowLayout());

		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());

		SSoutput=new JTextArea(10,30);


		//place panels and widgets
		inPanel1.add(file);
		inPanel1.add(enterFile);
		inPanel1.add(typeLabel);
		inPanel1.add(typeOne);
		inPanel1.add(typeTwo);
		inPanel1.add(numPLabel);
		inPanel1.add(numPInput);
		inPanel1.add(sNumLabel);
		inPanel1.add(SNumInput);
		inPanel1.add(heightLabel);
		inPanel1.add(heightInput);
		inPanel1.add(matLabel);
		inPanel1.add(mat1);
		inPanel1.add(mat2);
		inPanel1.add(mat3);
		inPanel1.add(destLabel);
		inPanel1.add(dest1);
		inPanel1.add(dest2);
		inPanel1.add(dest3);
		inPanel1.add(dest4);
		inPanel1.add(dest5);
		inPanel1.add(dest6);
		inPanel1.add(radLabel);
		inPanel1.add(radInput);
		inPanel1.add(enter);


		outPanel1.add(new JScrollPane(SSoutput));

		mainPanel.add(inPanel1);
		mainPanel.add(outPanel1);
		this.add(mainPanel);



		//for rovers

		frover1=new JRadioButton("Atmospheric Analysis");
		frover2=new JRadioButton("Sample Collection");
		frover3=new JRadioButton("Surface Analysis");
		buttons5=new ButtonGroup();
		buttons5.add(frover1);
		buttons5.add(frover2);
		buttons5.add(frover3);
		
		mat1R=new JRadioButton("Metal Alloy");
		mat2R=new JRadioButton("Aluminium");
		mat3R=new JRadioButton("Titanium");
		buttons4=new ButtonGroup();
		buttons4.add(mat1);
		buttons4.add(mat2);
		buttons4.add(mat3);

		//create widgets, add action listeners and initialize variables

		sNumLabelR = new JLabel("Enter serial Number:");
		heightLabelR = new JLabel("Enter height:");
		matLabelR= new JLabel("Enter material:");
		froLabel=new JLabel("Enter Function of rover:");
		
		enter2=new JButton("Enter!");
		enter2.addActionListener(this);

		SNumInputR = new JTextField(15);
		SNumInputR.addActionListener(this);

		heightInputR = new JTextField(15);
		heightInputR.addActionListener(this);

		//set panel layouts
		inPanel2 = new JPanel();
		inPanel2.setLayout(new GridLayout(25,5));

		outPanel2 = new JPanel();
		outPanel2.setLayout(new FlowLayout());

		Routput=new JTextArea(10,30);


		//place panels and widgets

		inPanel2.add(froLabel);
		inPanel2.add(frover1);
		inPanel2.add(frover2);
		inPanel2.add(frover3);
		inPanel2.add(sNumLabelR);
		inPanel2.add(SNumInputR);
		inPanel2.add(heightLabelR);
		inPanel2.add(heightInputR);
		inPanel2.add(matLabelR);
		inPanel2.add(mat1R);
		inPanel2.add(mat2R);
		inPanel2.add(mat3R);
		inPanel2.add(enter2);


		outPanel2.add(new JScrollPane(Routput));

		mainPanel.add(inPanel2);
		mainPanel.add(outPanel2);
		this.add(mainPanel);

	flag=true;


	}


	public void actionPerformed(ActionEvent actEvent) {
		
	
			try {
				if(flag==true) {
				JFileChooser chooser=new JFileChooser();
				chooser.showOpenDialog(null);
				fileIn=new Scanner(chooser.getSelectedFile());
				chooser.showSaveDialog(null);
				fileOut=new PrintWriter(chooser.getSelectedFile());
				flag=false;
			}
				if(actEvent.getSource()==enter) {

					spaceship.setNumSS();
					
					sNum=SNumInput.getText();
					char[] arr=sNum.toCharArray();
					if(!(Character.isLetter(arr[1]) && Character.isLetter(arr[2]) && Character.isLetter(arr[0]) && arr[3]=='-' && Character.isDigit(arr[4]) && Character.isDigit(arr[5]) && Character.isDigit(arr[6]))) {
						JOptionPane.showMessageDialog( null,"Serial Number is invalid I will set it to XXX-123");
						sNum="XXX-123";
					}
					
					String inH=heightInput.getText();
					height=Double.parseDouble(inH);
					if(height<80 || height>110) {
						JOptionPane.showMessageDialog( null,"Height is invalid I will set it to 90m" );			
						height=90;
					}
					
					String inR=radInput.getText();
					radius=Double.parseDouble(inR);
					if(radius<10 || radius>15) {
						JOptionPane.showMessageDialog( null,"Radius is invalid I will set it to 12m" );			
						radius=12;
					}
					
					
					if(mat1.isSelected()) {
						material=1;
					}if(mat2.isSelected()) {
						material=2;
					}if(mat3.isSelected()) {
						material=3;
					}if(dest1.isSelected()) {
						dest=1;
					}if(dest2.isSelected()) {
						dest=2;
					}if(dest3.isSelected()) {
						dest=3;
					}if(dest4.isSelected()) {
						dest=4;
					}if(dest5.isSelected()) {
						dest=5;
					}if(dest6.isSelected()) {
						dest=6;
					}
					if(typeOne.isSelected()) {
							String inPass=numPInput.getText();
							numPass=Integer.parseInt(inPass);
							if(numPass<1 || numPass>5) {
								JOptionPane.showMessageDialog( null,"Number of Passengers is invalid I will set it to 2" );			
								numPass=2;
							}
				
						ss[spaceship.getNumSS()]= new mannedS(radius,sNum,material,dest,numPass,height);
						

					}
					if(typeTwo.isSelected()) {
						ss[spaceship.getNumSS()]= new unmannedS(radius, sNum, height, material, dest);
					}
					ss[spaceship.getNumSS()].setWeight();
					ss[spaceship.getNumSS()].setCost();
					ss[spaceship.getNumSS()].setVelocity();
					ss[spaceship.getNumSS()].setDurmiss();
					/*if() {
						success=true;
					}else {
						success=false;
					}*/

					out1="\n"+"The spaceship "+spaceship.getNumSS()+" stats are:\n"+"Weight: "+ss[spaceship.getNumSS()].getWeight()+
							"\n"+"Cost: "+ss[spaceship.getNumSS()].getCost()+"\n"+"Velocity: "+ss[spaceship.getNumSS()].getVelocity()+
							"\n"+"Duration of mission: "+ss[spaceship.getNumSS()].getDurmiss();
					SSoutput.append(out1);
					fileOut.append(out1);
				
				}else if (actEvent.getSource()==enter2) {
					rover.addNumRovers();
					if(i>=4) {
					i=0;
					}
			if(i<4) {
				i++;
			}
					
						sNumR=SNumInputR.getText();
						char[] arr2=sNumR.toCharArray();
						if(!(Character.isLetter(arr2[1]) && Character.isLetter(arr2[2]) && Character.isLetter(arr2[0]) && arr2[3]=='-' && Character.isDigit(arr2[4]) && Character.isDigit(arr2[5]) && Character.isDigit(arr2[6]))) {
							JOptionPane.showMessageDialog( null,"Serial Number is invalid I will set it to XXX-123");
							sNumR="XXX-123";
						}
					
					
					try {
					String inHR=heightInputR.getText();
					heightR=Double.parseDouble(inHR);
					}catch(IllegalArgumentException ex) {
						JOptionPane.showMessageDialog( null,"Height is invalid I will set it to 2m" );			
						heightR=2;
					}


					if(mat1R.isSelected()) {
						materialR=1;

					}if(mat2R.isSelected()) {
						materialR=2;

					}if(mat3R.isSelected()) {
						materialR=3;
					}if(frover1.isSelected()) {
						frover=1;

					}if(frover2.isSelected()) {
						frover=2;

					}if(mat3.isSelected()) {
						frover=3;
					}


					rov.add(new rover(sNumR, heightR, materialR, frover));
					rover[] roverIn=new rover[5];

					roverIn[i]=rov.get(rover.numRovers);
					roverIn[i].calculateWeight();
					roverIn[i].calculateCost();

					if(i==4 && fileIn!=null) {
						for(int j=0;j<5;j++) {
							for(int n=1;n<5;n++) {
								if(roverIn[j].equals(roverIn[n])) {
									while(fileIn.hasNextLine()) {
										String data=fileIn.nextLine();
										String info[]=data.split("=");
										if(info[0]=="sNum") {
											sNumR=info[1];
										}if(info[0]=="height") {
											heightR=Double.parseDouble(info[1]);
										}if(info[0]=="material") {
											materialR=Integer.parseInt(info[1]);
										}if(info[0]=="frover") {
											frover=Integer.parseInt(info[1]);
										}
									}
								}



							}
						}
						fileOut.append("There were two rovers that were equal so it was set to the default values");
						Routput.append("There were two rovers that were equal so it was set to the default values");
					}

					out2="\n"+"The rover stats are:\n"+"Weight: "+roverIn[i].getWeight()+
							"\n"+"Cost: "+roverIn[i].getCost()+"\n";
					Routput.append(out2);
				
						fileOut.append(out2);
					
					if(typeOne.isSelected()) {
						((mannedS)ss[spaceship.getNumSS()]).setRovers(roverIn[i],i);

					}
					if(typeTwo.isSelected()) {
						((mannedS)ss[spaceship.getNumSS()]).setRovers(roverIn[i],i);
					}

					i++;
				}
				
				}catch(FileNotFoundException notFound) {

					JOptionPane.showMessageDialog( null,"File not found" );
				
			}	finally{
				fileOut.close();
				fileIn.close();
			}
			
				
				

			
			


	}




	public static void main(String[] args) {


		spaceshipTester gui = new spaceshipTester();
		gui.setVisible(true); 
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		gui.setSize(2000,1000);  
		gui.setTitle("Space Mission Builder"); 
     

	}

}

































package project;
import java.util.ArrayList;


import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class spaceshipTester extends JFrame implements ActionListener{

	private JLabel radLabel,sNumLabel,heightLabel,matLabel, typeLabel,destLabel,numPLabel,sNumLabelR,heightLabelR,matLabelR,froLabel,file;
	private JTextField SNumInput,heightInput,timeInput,radInput,numPInput,SNumInputR,heightInputR;
	private JPanel inPanel1,outPanel1,mainPanel,inPanel2,outPanel2;
	private JButton enter,enter2,enterFile;
	private JTextArea SSoutput,Routput;
	private JRadioButton typeOne,typeTwo,dest1,dest2,dest3,dest4,dest5,dest6,mat1,mat2,mat3,frover1,frover2,frover3,mat1R,mat2R,mat3R;
	private String sNum; 
	private ButtonGroup buttons,buttons2,buttons3,buttons4,buttons5;
	private double height; 
	private int material;
	private int dest; 
	private int numPass;
	private boolean success;
	private double radius;
	String out1,out2;
	private String sNumR; 
	private double heightR; 
	private int materialR; 
	private int i;
	private Scanner fileIn=null;
	private PrintWriter fileOut=null;
	int frover;

	private spaceship[] ss=new spaceship[20];
	private ArrayList<rover> rov=new ArrayList<rover>();

	public spaceshipTester(){



		typeOne=new JRadioButton("Manned Spaceship");
		typeTwo=new JRadioButton("Unmanned Spaceship");
		buttons=new ButtonGroup();
		buttons.add(typeOne);
		buttons.add(typeTwo);
		
		dest1=new JRadioButton("Moon");
		dest2=new JRadioButton("Mars");
		dest3=new JRadioButton("Venus");
		dest4=new JRadioButton("Jupiter");
		dest5=new JRadioButton("Saturn");
		dest6=new JRadioButton("Titan");
		buttons2=new ButtonGroup();
		buttons2.add(dest1);
		buttons2.add(dest2);
		buttons2.add(dest3);
		buttons2.add(dest4);
		buttons2.add(dest5);
		buttons2.add(dest6);
		
		mat1=new JRadioButton("Metal Alloy");
		mat2=new JRadioButton("Aluminium");
		mat3=new JRadioButton("Titanium");
		buttons3=new ButtonGroup();
		buttons3.add(mat1);
		buttons3.add(mat2);
		buttons3.add(mat3);

		//create widgets, add action listeners and initialize variables

		sNumLabel = new JLabel("Enter serial Number:");
		heightLabel = new JLabel("Enter height:");
		matLabel = new JLabel("Enter material:");
		radLabel = new JLabel("Enter radius:");
		typeLabel = new JLabel("Enter type of spaceship:");
		destLabel = new JLabel("Enter destination:");
		numPLabel = new JLabel("Enter number of passengers:");
		file = new JLabel("Click to enter file:");

		enter=new JButton("Enter!");
		enter.addActionListener(this);
		enterFile=new JButton("Enter file");
		enterFile.addActionListener(this);
		numPInput = new JTextField(15);
		numPInput.addActionListener(this);
		
		SNumInput = new JTextField(15);
		SNumInput.addActionListener(this);
		
		radInput = new JTextField(15);
		radInput.addActionListener(this);
		
		heightInput = new JTextField(15);
		heightInput.addActionListener(this);

		timeInput = new JTextField(15);
		timeInput.addActionListener(this);
		//set panel layouts
		
		inPanel1 = new JPanel();
		inPanel1.setLayout(new GridLayout(25,5));

		outPanel1 = new JPanel();
		outPanel1.setLayout(new FlowLayout());

		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());

		SSoutput=new JTextArea(10,30);


		//place panels and widgets
		inPanel1.add(file);
		inPanel1.add(enterFile);
		inPanel1.add(typeLabel);
		inPanel1.add(typeOne);
		inPanel1.add(typeTwo);
		inPanel1.add(numPLabel);
		inPanel1.add(numPInput);
		inPanel1.add(sNumLabel);
		inPanel1.add(SNumInput);
		inPanel1.add(heightLabel);
		inPanel1.add(heightInput);
		inPanel1.add(matLabel);
		inPanel1.add(mat1);
		inPanel1.add(mat2);
		inPanel1.add(mat3);
		inPanel1.add(destLabel);
		inPanel1.add(dest1);
		inPanel1.add(dest2);
		inPanel1.add(dest3);
		inPanel1.add(dest4);
		inPanel1.add(dest5);
		inPanel1.add(dest6);
		inPanel1.add(radLabel);
		inPanel1.add(radInput);
		inPanel1.add(enter);


		outPanel1.add(new JScrollPane(SSoutput));

		mainPanel.add(inPanel1);
		mainPanel.add(outPanel1);
		this.add(mainPanel);



		//for rovers

		frover1=new JRadioButton("Atmospheric Analysis");
		frover2=new JRadioButton("Sample Collection");
		frover3=new JRadioButton("Surface Analysis");
		buttons5=new ButtonGroup();
		buttons5.add(frover1);
		buttons5.add(frover2);
		buttons5.add(frover3);
		
		mat1R=new JRadioButton("Metal Alloy");
		mat2R=new JRadioButton("Aluminium");
		mat3R=new JRadioButton("Titanium");
		buttons4=new ButtonGroup();
		buttons4.add(mat1);
		buttons4.add(mat2);
		buttons4.add(mat3);

		//create widgets, add action listeners and initialize variables

		sNumLabelR = new JLabel("Enter serial Number:");
		heightLabelR = new JLabel("Enter height:");
		matLabelR= new JLabel("Enter material:");
		froLabel=new JLabel("Enter Function of rover:");
		
		enter2=new JButton("Enter!");
		enter2.addActionListener(this);

		SNumInputR = new JTextField(15);
		SNumInputR.addActionListener(this);

		heightInputR = new JTextField(15);
		heightInputR.addActionListener(this);

		//set panel layouts
		inPanel2 = new JPanel();
		inPanel2.setLayout(new GridLayout(25,5));

		outPanel2 = new JPanel();
		outPanel2.setLayout(new FlowLayout());

		Routput=new JTextArea(10,30);


		//place panels and widgets

		inPanel2.add(froLabel);
		inPanel2.add(frover1);
		inPanel2.add(frover2);
		inPanel2.add(frover3);
		inPanel2.add(sNumLabelR);
		inPanel2.add(SNumInputR);
		inPanel2.add(heightLabelR);
		inPanel2.add(heightInputR);
		inPanel2.add(matLabelR);
		inPanel2.add(mat1R);
		inPanel2.add(mat2R);
		inPanel2.add(mat3R);
		inPanel2.add(enter2);


		outPanel2.add(new JScrollPane(Routput));

		mainPanel.add(inPanel2);
		mainPanel.add(outPanel2);
		this.add(mainPanel);

	


	}


	public void actionPerformed(ActionEvent actEvent) {
		
		if(actEvent.getSource()==enterFile) {
			try {
				
				JFileChooser chooser=new JFileChooser();
				chooser.showOpenDialog(null);
				fileIn=new Scanner(chooser.getSelectedFile());
				chooser.showSaveDialog(null);
				fileOut=new PrintWriter(chooser.getSelectedFile());
				}catch(FileNotFoundException notFound) {

					JOptionPane.showMessageDialog( null,"File not found" );
				
				
			}	
		}	
				
				if(actEvent.getSource()==enter) {

					spaceship.setNumSS();
					
					sNum=SNumInput.getText();
					char[] arr=sNum.toCharArray();
					if(!(Character.isLetter(arr[1]) && Character.isLetter(arr[2]) && Character.isLetter(arr[0]) && arr[3]=='-' && Character.isDigit(arr[4]) && Character.isDigit(arr[5]) && Character.isDigit(arr[6]))) {
						JOptionPane.showMessageDialog( null,"Serial Number is invalid I will set it to XXX-123");
						sNum="XXX-123";
					}
					
					String inH=heightInput.getText();
					height=Double.parseDouble(inH);
					if(height<80 || height>110) {
						JOptionPane.showMessageDialog( null,"Height is invalid I will set it to 90m" );			
						height=90;
					}
					
					String inR=radInput.getText();
					radius=Double.parseDouble(inR);
					if(radius<10 || radius>15) {
						JOptionPane.showMessageDialog( null,"Radius is invalid I will set it to 12m" );			
						radius=12;
					}
					
					
					if(mat1.isSelected()) {
						material=1;
					}if(mat2.isSelected()) {
						material=2;
					}if(mat3.isSelected()) {
						material=3;
					}if(dest1.isSelected()) {
						dest=1;
					}if(dest2.isSelected()) {
						dest=2;
					}if(dest3.isSelected()) {
						dest=3;
					}if(dest4.isSelected()) {
						dest=4;
					}if(dest5.isSelected()) {
						dest=5;
					}if(dest6.isSelected()) {
						dest=6;
					}
					if(typeOne.isSelected()) {
							String inPass=numPInput.getText();
							numPass=Integer.parseInt(inPass);
							if(numPass<1 || numPass>5) {
								JOptionPane.showMessageDialog( null,"Number of Passengers is invalid I will set it to 2" );			
								numPass=2;
							}
						System.out.println(radius);
						System.out.println(sNum);
						System.out.println(material);
						System.out.println(dest);
						System.out.println(numPass);
						System.out.println(height);
						ss[spaceship.getNumSS()]= new mannedS(radius,sNum,material,dest,numPass,height);
						

					}
					if(typeTwo.isSelected()) {
						ss[spaceship.getNumSS()]= new unmannedS(radius, sNum, height, material, dest);
					}
					ss[spaceship.getNumSS()].setWeight();
					ss[spaceship.getNumSS()].setCost();
					ss[spaceship.getNumSS()].setVelocity();
					ss[spaceship.getNumSS()].setDurmiss();
					/*if() {
						success=true;
					}else {
						success=false;
					}*/

					out1="\n"+"The spaceship "+spaceship.getNumSS()+" stats are:\n"+"Weight: "+ss[spaceship.getNumSS()].getWeight()+
							"\n"+"Cost: "+ss[spaceship.getNumSS()].getCost()+"\n"+"Velocity: "+ss[spaceship.getNumSS()].getVelocity()+
							"\n"+"Duration of mission: "+ss[spaceship.getNumSS()].getDurmiss();
					SSoutput.append(out1);
					fileOut.append(out1);
					fileOut.close();
				}else if (actEvent.getSource()==enter2) {
					rover.addNumRovers();
					if(i>=4) {
					i=0;
					}
			if(i<4) {
				i++;
			}
					
						sNumR=SNumInputR.getText();
						char[] arr2=sNumR.toCharArray();
						if(!(Character.isLetter(arr2[1]) && Character.isLetter(arr2[2]) && Character.isLetter(arr2[0]) && arr2[3]=='-' && Character.isDigit(arr2[4]) && Character.isDigit(arr2[5]) && Character.isDigit(arr2[6]))) {
							JOptionPane.showMessageDialog( null,"Serial Number is invalid I will set it to XXX-123");
							sNumR="XXX-123";
						}
					
					
					try {
					String inHR=heightInputR.getText();
					heightR=Double.parseDouble(inHR);
					}catch(IllegalArgumentException ex) {
						JOptionPane.showMessageDialog( null,"Height is invalid I will set it to 2m" );			
						heightR=2;
					}


					if(mat1R.isSelected()) {
						materialR=1;

					}if(mat2R.isSelected()) {
						materialR=2;

					}if(mat3R.isSelected()) {
						materialR=3;
					}if(frover1.isSelected()) {
						frover=1;

					}if(frover2.isSelected()) {
						frover=2;

					}if(mat3.isSelected()) {
						frover=3;
					}


					rov.add(new rover(sNumR, heightR, materialR, frover));
					rover[] roverIn=new rover[5];

					roverIn[i]=rov.get(rover.numRovers);
					roverIn[i].calculateWeight();
					roverIn[i].calculateCost();

					if(i==4 && fileIn!=null) {
						for(int j=0;j<5;j++) {
							for(int n=1;n<5;n++) {
								if(roverIn[j].equals(roverIn[n])) {
									while(fileIn.hasNextLine()) {
										String data=fileIn.nextLine();
										String info[]=data.split("=");
										if(info[0]=="sNum") {
											sNumR=info[1];
										}if(info[0]=="height") {
											heightR=Double.parseDouble(info[1]);
										}if(info[0]=="material") {
											materialR=Integer.parseInt(info[1]);
										}if(info[0]=="frover") {
											frover=Integer.parseInt(info[1]);
										}
									}
								}



							}
						}
						fileOut.append("There were two rovers that were equal so it was set to the default values");
						Routput.append("There were two rovers that were equal so it was set to the default values");
					}

					out2="\n"+"The rover stats are:\n"+"Weight: "+roverIn[i].getWeight()+
							"\n"+"Cost: "+roverIn[i].getCost()+"\n";
					Routput.append(out2);
				
						fileOut.append(out2);
					
					if(typeOne.isSelected()) {
						((mannedS)ss[spaceship.getNumSS()]).setRovers(roverIn[i],i);

					}
					if(typeTwo.isSelected()) {
						((mannedS)ss[spaceship.getNumSS()]).setRovers(roverIn[i],i);
					}

					i++;
				}

				
				
				System.out.println("here");
				fileOut.close();
				fileIn.close();
			


	}




	public static void main(String[] args) {


		spaceshipTester gui = new spaceshipTester();
		gui.setVisible(true); 
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		gui.setSize(2000,1000);  
		gui.setTitle("Space Mission Builder"); 
     

	}

}

























package project;
/*
 * Author: Sahara Karima Mosin Rahimani

 * The spaceship tester class contains
 * one GUI that is responsible of receiving 
 * the user input. The input received is
 * checked and if it is not within the acceptable
 * range the user is alerted using the JOptionPane
 * and sets the variable to a default value. 
 * 
 * Once it receives the user input the spaceshipTester
 * class calculates all the stats of the spaceship and their
 * respective rovers. (Each spaceship has five rovers)
 * Which are all displayed in the GUI and the latest stats 
 * of the latest spaceship is saved in a file(output.txt). 
 */


import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class spaceshipTester extends JFrame implements ActionListener{

	private JLabel radLabel,sNumLabel,heightLabel,matLabel, typeLabel,destLabel,numPLabel,sNumLabelR,heightLabelR,matLabelR,froLabel;
	private JTextField SNumInput,heightInput,timeInput,radInput,numPInput,SNumInputR,heightInputR;
	private JPanel inPanel1,outPanel1,mainPanel,inPanel2,outPanel2;
	private JButton enter,enter2;
	private JTextArea SSoutput,Routput;
	private JRadioButton typeOne,typeTwo,dest1,dest2,dest3,dest4,dest5,dest6,mat1,mat2,mat3,frover1,frover2,frover3,mat1R,mat2R,mat3R;
	private String sNum; 
	private ButtonGroup buttons,buttons2,buttons3,buttons4,buttons5;
	private double height; 
	private int material;
	private int dest; 
	private int numPass;
	private boolean success;
	private double radius;
	String out1,out2;
	private String sNumR; 
	private double heightR; 
	private int materialR; 
	private int i;
	private PrintWriter fileOut=null;
	int frover;
	private rover[] roverIn=new rover[5];
	private spaceship[] ss=new spaceship[20];
	private ArrayList<rover> rov=new ArrayList<rover>();

	public spaceshipTester(){

		for(int s=0;s<5;s++) {
			roverIn[s]=null;
		}

		typeOne=new JRadioButton("Manned Spaceship");
		typeTwo=new JRadioButton("Unmanned Spaceship");
		buttons=new ButtonGroup();
		buttons.add(typeOne);
		buttons.add(typeTwo);

		dest1=new JRadioButton("Moon");
		dest2=new JRadioButton("Mars");
		dest3=new JRadioButton("Venus");
		dest4=new JRadioButton("Jupiter");
		dest5=new JRadioButton("Saturn");
		dest6=new JRadioButton("Titan");
		buttons2=new ButtonGroup();
		buttons2.add(dest1);
		buttons2.add(dest2);
		buttons2.add(dest3);
		buttons2.add(dest4);
		buttons2.add(dest5);
		buttons2.add(dest6);

		mat1=new JRadioButton("Metal Alloy");
		mat2=new JRadioButton("Aluminium");
		mat3=new JRadioButton("Titanium");
		buttons3=new ButtonGroup();
		buttons3.add(mat1);
		buttons3.add(mat2);
		buttons3.add(mat3);


		sNumLabel = new JLabel("Enter serial Number:");
		heightLabel = new JLabel("Enter height:");
		matLabel = new JLabel("Enter material:");
		radLabel = new JLabel("Enter radius:");
		typeLabel = new JLabel("Enter type of spaceship:");
		destLabel = new JLabel("Enter destination:");
		numPLabel = new JLabel("Enter number of passengers:");


		enter=new JButton("Enter!");
		enter.addActionListener(this);

		numPInput = new JTextField(15);
		numPInput.addActionListener(this);

		SNumInput = new JTextField(15);
		SNumInput.addActionListener(this);

		radInput = new JTextField(15);
		radInput.addActionListener(this);

		heightInput = new JTextField(15);
		heightInput.addActionListener(this);

		timeInput = new JTextField(15);
		timeInput.addActionListener(this);
		

		inPanel1 = new JPanel();
		inPanel1.setLayout(new GridLayout(25,5));

		outPanel1 = new JPanel();
		outPanel1.setLayout(new FlowLayout());

		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());

		SSoutput=new JTextArea(10,30);



		inPanel1.add(typeLabel);
		inPanel1.add(typeOne);
		inPanel1.add(typeTwo);
		inPanel1.add(numPLabel);
		inPanel1.add(numPInput);
		inPanel1.add(sNumLabel);
		inPanel1.add(SNumInput);
		inPanel1.add(heightLabel);
		inPanel1.add(heightInput);
		inPanel1.add(matLabel);
		inPanel1.add(mat1);
		inPanel1.add(mat2);
		inPanel1.add(mat3);
		inPanel1.add(destLabel);
		inPanel1.add(dest1);
		inPanel1.add(dest2);
		inPanel1.add(dest3);
		inPanel1.add(dest4);
		inPanel1.add(dest5);
		inPanel1.add(dest6);
		inPanel1.add(radLabel);
		inPanel1.add(radInput);
		inPanel1.add(enter);


		outPanel1.add(new JScrollPane(SSoutput));

		mainPanel.add(inPanel1);
		mainPanel.add(outPanel1);
		this.add(mainPanel);



	

		frover1=new JRadioButton("Atmospheric Analysis");
		frover2=new JRadioButton("Sample Collection");
		frover3=new JRadioButton("Surface Analysis");
		buttons5=new ButtonGroup();
		buttons5.add(frover1);
		buttons5.add(frover2);
		buttons5.add(frover3);

		mat1R=new JRadioButton("Metal Alloy");
		mat2R=new JRadioButton("Aluminium");
		mat3R=new JRadioButton("Titanium");
		buttons4=new ButtonGroup();
		buttons4.add(mat1);
		buttons4.add(mat2);
		buttons4.add(mat3);

	

		sNumLabelR = new JLabel("Enter serial Number:");
		heightLabelR = new JLabel("Enter height:");
		matLabelR= new JLabel("Enter material:");
		froLabel=new JLabel("Enter Function of rover:");

		enter2=new JButton("Enter!");
		enter2.addActionListener(this);

		SNumInputR = new JTextField(15);
		SNumInputR.addActionListener(this);

		heightInputR = new JTextField(15);
		heightInputR.addActionListener(this);

	
		inPanel2 = new JPanel();
		inPanel2.setLayout(new GridLayout(25,5));

		outPanel2 = new JPanel();
		outPanel2.setLayout(new FlowLayout());

		Routput=new JTextArea(10,30);




		inPanel2.add(froLabel);
		inPanel2.add(frover1);
		inPanel2.add(frover2);
		inPanel2.add(frover3);
		inPanel2.add(sNumLabelR);
		inPanel2.add(SNumInputR);
		inPanel2.add(heightLabelR);
		inPanel2.add(heightInputR);
		inPanel2.add(matLabelR);
		inPanel2.add(mat1R);
		inPanel2.add(mat2R);
		inPanel2.add(mat3R);
		inPanel2.add(enter2);


		outPanel2.add(new JScrollPane(Routput));

		mainPanel.add(inPanel2);
		mainPanel.add(outPanel2);
		this.add(mainPanel);




	}


	public void actionPerformed(ActionEvent actEvent) {


		try {

			JFileChooser chooser=new JFileChooser();




			if(actEvent.getSource()==enter) {
				if(i==5) {
					i=0;
					spaceship.setNumSS();
				}
				chooser.showSaveDialog(null);
				fileOut=new PrintWriter(chooser.getSelectedFile());


				sNum=SNumInput.getText();
				char[] arr=sNum.toCharArray();
				if(!(Character.isLetter(arr[1]) && Character.isLetter(arr[2]) && Character.isLetter(arr[0]) && arr[3]=='-' && Character.isDigit(arr[4]) && Character.isDigit(arr[5]) && Character.isDigit(arr[6]))) {
					JOptionPane.showMessageDialog( null,"Serial Number is invalid I will set it to XXX-123");
					sNum="XXX-123";
				}

				String inH=heightInput.getText();
				height=Double.parseDouble(inH);
				if(height<80 || height>110) {
					JOptionPane.showMessageDialog( null,"Height is invalid I will set it to 90m" );			
					height=90;
				}

				String inR=radInput.getText();
				radius=Double.parseDouble(inR);
				if(radius<10 || radius>15) {
					JOptionPane.showMessageDialog( null,"Radius is invalid I will set it to 12m" );			
					radius=12;
				}


				if(mat1.isSelected()) {
					material=1;
				}if(mat2.isSelected()) {
					material=2;
				}if(mat3.isSelected()) {
					material=3;
				}if(dest1.isSelected()) {
					dest=1;
				}if(dest2.isSelected()) {
					dest=2;
				}if(dest3.isSelected()) {
					dest=3;
				}if(dest4.isSelected()) {
					dest=4;
				}if(dest5.isSelected()) {
					dest=5;
				}if(dest6.isSelected()) {
					dest=6;
				}
				if(typeOne.isSelected()) {
					String inPass=numPInput.getText();
					numPass=Integer.parseInt(inPass);
					if(numPass<1 || numPass>5) {
						JOptionPane.showMessageDialog( null,"Number of Passengers is invalid I will set it to 2" );			
						numPass=2;
					}

					ss[spaceship.getNumSS()]= new mannedS(radius,sNum,material,dest,numPass,height);


				}
				if(typeTwo.isSelected()) {
					ss[spaceship.getNumSS()]= new unmannedS(radius, sNum, height, material, dest);
				}
				ss[spaceship.getNumSS()].setWeight();
				ss[spaceship.getNumSS()].setCost();
				ss[spaceship.getNumSS()].setVelocity();
				ss[spaceship.getNumSS()].setDurmiss();
				if(ss[spaceship.getNumSS()].getCost()>1E3 && ss[spaceship.getNumSS()].getCost()<1E10 ) {
					success=true;
				}else {
					success=false;
				}

				out1="\n"+"The spaceship "+spaceship.getNumSS()+" stats are:\n"+"Weight: "+ss[spaceship.getNumSS()].getWeight()+
						"\n"+"Cost: "+ss[spaceship.getNumSS()].getCost()+"\n"+"Velocity: "+ss[spaceship.getNumSS()].getVelocity()+
						"\n"+"Duration of mission: "+ss[spaceship.getNumSS()].getDurmiss()+" Success: "+success;
				SSoutput.append(out1);
				fileOut.println(out1);

			}else if (actEvent.getSource()==enter2) {





				sNumR=SNumInputR.getText();
				char[] arr2=sNumR.toCharArray();
				if(!(Character.isLetter(arr2[1]) && Character.isLetter(arr2[2]) && Character.isLetter(arr2[0]) && arr2[3]=='-' && Character.isDigit(arr2[4]) && Character.isDigit(arr2[5]) && Character.isDigit(arr2[6]))) {
					JOptionPane.showMessageDialog( null,"Serial Number is invalid I will set it to XXX-123");
					sNumR="XXX-123";
				}


				try {
					String inHR=heightInputR.getText();
					heightR=Double.parseDouble(inHR);
				}catch(IllegalArgumentException ex) {
					JOptionPane.showMessageDialog( null,"Height is invalid I will set it to 2m" );			
					heightR=2;
				}


				if(mat1R.isSelected()) {
					materialR=1;

				}if(mat2R.isSelected()) {
					materialR=2;

				}if(mat3R.isSelected()) {
					materialR=3;
				}if(frover1.isSelected()) {
					frover=1;

				}if(frover2.isSelected()) {
					frover=2;

				}if(mat3.isSelected()) {
					frover=3;
				}


				rov.add(new rover(sNumR, heightR, materialR, frover));


				roverIn[i]=rov.get(rover.numRovers);
				roverIn[i].calculateWeight();
				roverIn[i].calculateCost();


				out2="\n"+"The rover stats are:\n"+"Weight: "+roverIn[i].getWeight()+
						"\n"+"Cost: "+roverIn[i].getCost()+"\n";
				Routput.append(out2);

				if(typeOne.isSelected()) {
					System.out.println(spaceship.getNumSS());
					((mannedS)ss[spaceship.getNumSS()]).setRovers(roverIn[i],i);

				}
				if(typeTwo.isSelected()) {
					((mannedS)ss[spaceship.getNumSS()]).setRovers(roverIn[i],i);
				}
				if(i<=4) {

					i++;
					System.out.println(i);
				}
				rover.addNumRovers();

			}

		}catch(FileNotFoundException notFound) {

			JOptionPane.showMessageDialog( null,"File not found" );

		}finally{
			if(fileOut!=null)
				fileOut.close();

		}


}




	public static void main(String[] args) {


		spaceshipTester gui = new spaceshipTester();
		gui.setVisible(true); 
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		gui.setSize(2000,1000);  
		gui.setTitle("Space Mission Builder"); 


	}

}



