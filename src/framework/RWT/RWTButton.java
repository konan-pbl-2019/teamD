package framework.RWT;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * ボタンです。
 * @author Wataru
 *
 */
public class RWTButton extends RWTLabel implements RWTSelectableWidget {
	private float relativeX = 0.0f;
	private float relativeY = 0.0f;
	private float relativeWidth = 0.12f;
	private float relativeHeight = 0.06f;
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	private String label;


	public RWTButton(String s){
		label = s;
		setString(s);
	}

	@Override
	public void adjust(Component parent) {
		int sx = parent.getWidth();
		int sy = parent.getHeight();
		x = (int) (sx * relativeX);
		y = (int) (sy * relativeY);
		width = (int) (sx * relativeWidth);
		height = (int) (sy * relativeHeight);
	}

	//選択欄はここでいじくる
	@Override
	public void paint(Graphics g) {

		Font font = new Font("", Font.PLAIN, 50);

		// ログインボタンのデザイン
//		 //色の設定
//		g.setColor(Color.WHITE);
//		 //指定範囲塗りつぶし
//		g.fillRect(x+1, y+1, width, height);
		//g.setColor(Color.BLACK);
		 //指定範囲？に枠線？を描く
		//g.drawRect(x+1, y+1, width, height);
		g.setColor(Color.white);
		g.setFont(font);
		 //ボタン内に文字列をプリント
		//g.drawString(label, x+7, y+height-5);//(文字列,文字開始の左下のx座標,文字開始の左下のy座標)
		FontMetrics fm = g.getFontMetrics(font);
		int fh = fm.getHeight();
		int lineY = 0;
		for(int i = 0; i < strings.length; i++){
			if (strings[i] != null && strings[i].length() > 0) {
				g.drawString(strings[i], x + 20, y + height - 30 + lineY);
			}
			lineY += fh;
		}
//		g.drawString(label, x+20, y+height-30);//(文字列,文字開始の左下のx座標,文字開始の左下のy座標)

	}

	@Override
	public int getAbsoluteHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getAbsoluteWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public int getAbsoluteX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getAbsoluteY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setRelativePosition(float x, float y) {
		// TODO Auto-generated method stub
		relativeX = x;
		relativeY = y;
	}

	public void setRelativeWidth(float relativeWidth) {
		this.relativeWidth = relativeWidth;
	}

	public void setRelativeHeight(float relativeHeight) {
		this.relativeHeight = relativeHeight;
	}

	@Override
	public void deselected() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selected() {
		// TODO Auto-generated method stub

	}

	public void setLabel(String label){
		this.label = label;
		setString(label);
	}

	public String getLabel(){
		return label;
	}
}
