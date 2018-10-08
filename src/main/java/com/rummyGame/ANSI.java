package com.rummyGame;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ANSI extends Applet
{
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.drawString("Hello", 20, 20);
	}

}
