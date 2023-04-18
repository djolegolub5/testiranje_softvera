package testing;


import org.easymock.EasyMock;
import org.easymock.Mock;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.runners.MethodSorters;

import FileExceptions.BadFileException;
import Player.Computer;
import Player.Person;
import Player.Player;
import Ship.ShipCount;
import Structure.Gridline;
import igra.Game;
import igra.MainFrame;
//import igra.Splash;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IgraTest {

	private static Game game=new Game();
	private static MainFrame mainFrame=MainFrame.getMainFrame();
	
	
	@BeforeEach
	public void before() {
		
	}
	
	@AfterEach
	public void after() throws IOException {
		mainFrame.endGame=false;
		String fajl="5;1;1;r\r\n"
				+ "4;1;9;r\r\n"
				+ "3;1;2;d\r\n"
				+ "2;3;4;r\r\n"
				+ "2;8;3;d\r\n"
				+ "1;4;6;0\r\n"
				+ "1;8;8;0\r\n"
				+ "\r\n"
				+ ". . . . . . . . . \r\n"
				+ ". O O O O O . . . \r\n"
				+ ". O . . . . . . . \r\n"
				+ ". O . . . . . O . \r\n"
				+ ". O . O O . . O . \r\n"
				+ ". . . . . . . . . \r\n"
				+ ". . . . O . . . . \r\n"
				+ ". . . . . . . . . \r\n"
				+ ". . . . . . . O . \r\n"
				+ ". O O O O . . . .\r\n"
				+ "\r\n"
				+ "1x 5\r\n"
				+ "1x 4\r\n"
				+ "1x 3\r\n"
				+ "2x 2\r\n"
				+ "2x 1\r\n"
				+ "";
        File file1=new File("src/ships.txt");
        FileWriter fw1;
			fw1 = new FileWriter(file1);
	        BufferedWriter out1 = new BufferedWriter(fw1);
	        out1.append(fajl);
	        out1.flush();
	        fw1.close();
	        out1.close();
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources="/ulaz.csv")
	@Order(1)
	public void firstTest(String x, String y) throws InterruptedException {
		
		mainFrame.startMain(x, y);
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				ActionEvent actionEvent=new ActionEvent(mainFrame, i+j, Integer.toString(j)+Integer.toString(i));
				mainFrame.actionPerformed(actionEvent);
				//Thread.sleep(50);
			}
		}
		Assert.assertTrue(mainFrame.endGame);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources="/ulaz1.csv")
	@Order(2)
	public void secondTest(String x, String y) throws InterruptedException {
		
		mainFrame.startMain(x, y);
		for (int i=9;i>=0;i--) {
			for (int j=0;j<10;j++) {
				ActionEvent actionEvent=new ActionEvent(mainFrame, i+j, Integer.toString(i)+Integer.toString(j));
				mainFrame.actionPerformed(actionEvent);
				//Thread.sleep(10);
			}
		}
		Assert.assertTrue(mainFrame.endGame);
		
	}
	
	@Test
	@Order(3)
	public void thirdTest() throws InterruptedException {
		Boolean[][] matrica=new Boolean[10][10];
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				matrica[i][j]=false;
			}
		}
		Random random=new Random();
		Game.main(null);
		while (!mainFrame.endGame) {
			int x=random.nextInt(10);
			int y=random.nextInt(10);
			while (matrica[x][y]) {
				x=random.nextInt(10);
				y=random.nextInt(10);
			}
			matrica[x][y]=true;
			ActionEvent actionEvent=new ActionEvent(mainFrame, x+y, Integer.toString(x)+Integer.toString(y));
			mainFrame.actionPerformed(actionEvent);
			Thread.sleep(50);
		}
		Assert.assertTrue(mainFrame.endGame);

	}

	@Test
	@Order(4)
	public void fourthTest() throws IOException {
		
		File file = new File("src/ships.txt");
        File rename = new File("aaa.txt");
        file.renameTo(rename);
        
        Game.main(null);

        file=new File("aaa.txt");
        rename=new File("src/ships.txt");
        file.renameTo(rename);

	}
	
	
	 @ParameterizedTest
	 @CsvFileSource(resources="/ulaz2.csv")
	 @Order(5)
	 public void fifthTest(String x, String y) throws IOException {
		 
		 	StringBuffer buffer = new StringBuffer();
			File file = new File("src/ships.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
		         buffer.append(sc.nextLine()+System.lineSeparator());
			}
			String fajl=buffer.toString();
			String fajlMod=fajl.replace(x,y);

			FileWriter fw = new FileWriter(file);
	        BufferedWriter out = new BufferedWriter(fw);
	        out.append(fajlMod);
	        out.flush();
	   
	        
	        Game.main(null);
	  
	        sc.close();
	        fw.close();
	        out.close();
	        
	  
	 }
	 
	 
	 @Test
	 @Order(6)
	 public void sixthTest() {
		 
		 Player p=new Computer("test");
		 Gridline gL=p.gridlineMine();
		 Boolean test=false;
		 if (gL!=null)test=true;
		 Assert.assertTrue(test);
		 
	 }
	 
	 
	 
	 @Test
	 @Order(7)
	 public void firstMockShipCount() {
		 
		 ShipCountTest sct=EasyMock.createMock(ShipCountTest.class);
		 EasyMock.expect(sct.destroyedUpdate()).andReturn(-1);
		 EasyMock.replay(sct);
		 
		 Assert.assertEquals(-1, sct.destroyedUpdate());
		 EasyMock.verify(sct);
		 
	 }
	 
	 @Test
	 @Order(8)
	 public void secondMockShipCount() {
		 ShipCountTest sct=EasyMock.createMock(ShipCountTest.class);
		 EasyMock.expect(sct.allDestroyed()).andReturn(false);
		 EasyMock.replay(sct);
		 
		 Assert.assertEquals(false, sct.allDestroyed());
		 EasyMock.verify(sct);
	 }
	 
	 @Test
	 @Order(9)
	 public void firstMockGridline() {
		 
		 GridlineTest glt=EasyMock.createMock(GridlineTest.class);
		 EasyMock.expect(glt.shot(5, 5)).andReturn(false);
		 EasyMock.replay(glt);
		 
		 Assert.assertFalse(glt.shot(5, 5));
		 EasyMock.verify(glt);
		 
		 
	 }
	 
	 @Test
	 @Order(10)
	 public void secondMockGridline() {
		 
		 GridlineTest glt=EasyMock.createMock(GridlineTest.class);
		 EasyMock.expect(glt.checkBlock(5, 5)).andReturn(".");
		 EasyMock.replay(glt);
		 
		 Assert.assertEquals(glt.checkBlock(5, 5),".");
		 EasyMock.verify(glt);
		 
		 
	 }
	 
	 @Test
	 @Order(11)
	 public void thirdMockGridline() {
		 
		 GridlineTest glt=EasyMock.createMock(GridlineTest.class);
		 EasyMock.expect(glt.checkShot(5, 5)).andReturn(true);
		 EasyMock.replay(glt);
		 
		 Assert.assertEquals(glt.checkShot(5, 5),true);
		 EasyMock.verify(glt);
		 
		 
	 }
	 
	 @Test
	 @Order(12)
	 public void firstMockPerson() throws IOException, BadFileException {
		 
		 
		 	StringBuffer buffer = new StringBuffer();
			File file = new File("src/ships.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
		         buffer.append(sc.nextLine()+System.lineSeparator());
			}
			String fajl=buffer.toString();
			String fajlMod=fajl.replace("r","w");

			FileWriter fw = new FileWriter(file);
	        BufferedWriter out = new BufferedWriter(fw);
	        out.append(fajlMod);
	        out.flush();
	   
	        PersonTest pt=EasyMock.createMock(PersonTest.class);
	        EasyMock.expect(pt.createGridMine()).andThrow(new BadFileException(2));
	        EasyMock.replay(pt);
			 
	        BadFileException exception = Assert.assertThrows(BadFileException.class, () -> pt.createGridMine());
	        Assert.assertEquals(exception.toString(),"FileExceptions.BadFileException");
			EasyMock.verify(pt);
	        
	  
	        sc.close();
	        fw.close();
	        out.close();
		 
		 
	 }
	 

	 
	 @Test
	 @Order(13)
	 public void secondMockPerson() {
		 PersonTest pt=EasyMock.createMock(PersonTest.class);
	        EasyMock.expect(pt.gridlineMine()).andReturn(new Gridline(10,10));
	        EasyMock.replay(pt);
	        Assert.assertNotEquals(null, pt.gridlineMine());
			EasyMock.verify(pt);
	 }
	 
}
