package dev.aditya.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.aditya.tilegame.display.Display;
import dev.aditya.tilegame.gfx.Assets;
import dev.aditya.tilegame.gfx.ImageLoader;
import dev.aditya.tilegame.gfx.SpriteSheet;
import dev.aditya.tilegame.input.KeyManager;
import dev.aditya.tilegame.state.GameState;
import dev.aditya.tilegame.state.State;

public class Game implements Runnable{
	private Display display;
	public int width,height;
	public String title;
	
	public Thread thread;
	public boolean running=false;
	
	private BufferStrategy bs;
	private Graphics g;
	//state
	
	private State gameState;
	
	//Input
	private KeyManager KeyManager;
	
	
	 public Game(String title,int width,int height)
	 {
		this.width=width;
		this.height=height;
		this.title=title;
		KeyManager=new KeyManager();
	 }
	 private void init()
	 {
		 display=new Display(title, width, height);
		Assets.init();
		display.getFrame().addKeyListener(KeyManager);
		gameState=new GameState(this);
		State.setStat(gameState);
	 }
	 private void tick()
	 {
		 KeyManager.tick();
		 if(State.getState()!=null)
			 State.getState().tick();
	 }
	 private void render()
	 {
		 bs=display.getCanvas().getBufferStrategy();
		 if(bs==null)
		 {
			 display.getCanvas().createBufferStrategy(3);
			 return;
		 }
		 g=bs.getDrawGraphics();
		 
		 //clear screen
		 g.clearRect(0, 0, width, height);
		 if(State.getState()!=null)
			 State.getState().render(g);
	
		
		 //end here
		 bs.show();
		 g.dispose();
	 }
	 public void run()
	 {
		 init();
		 
		 int fps=60;
		 double timePerTikc=1000000000/fps;
		 double delta=0;
		 long now;
		 long lastTime=System.nanoTime();
		 long timer=0;
		 int ticks=0;
		 while(running)
		 {
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerTikc;
			timer+=now-lastTime;
			lastTime=now;
			
			if(delta>=1){ 
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer>=1000000000)
			{
				System.out.println("Tricks and farme"+ ticks);
				ticks=0;
				timer=0;
				
			}
		 }
		 stop();
	 }
	 public KeyManager getKeyManager()
	 {
		 return KeyManager;
	 }
	 public synchronized void start()
	 {
		 if(running)
			 return;
		 running=true;
		 thread =new Thread(this);
		 thread.start();
	 }
	 public synchronized void stop()
	 {
		 if(!running)
			 return;
		 running=false;
		 try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 

}
