//memo
//OtoLogic

package template.quiz2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTButton;
import framework.RWT.RWTImage;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;
import framework.RWT.RWTWidget;
import framework.gameMain.BaseScenarioGameContainer;

/**
 * クイズゲーム用画面
 * @author Nitta
 *
 */
public class QuizGameContainer extends BaseScenarioGameContainer {

	//画面サイズ
	private int windowSizeX = 2516;
	private int windowSizeY = 1440;

	Graphics g;

	private RWTButton[] optionButtons = new RWTButton[4];

	public QuizGameContainer() {
		super();
	}

	@Override
	public void build(GraphicsConfiguration gc) {
		super.build(gc);

		//////////
		//画像の表示
		//////////

		//背景
		RWTImage backGround = new RWTImage("data\\sozai\\TSU853_yuusyanoikutewo_TP_V.jpg");
		backGround.setSize(windowSizeX, windowSizeY);
		backGround.setRelativePosition(0, -0.35f);

		//質問ボード
		RWTImage questionBoard = new RWTImage("data\\sozai\\questionBoard.png");
		questionBoard.setSize(windowSizeX - 600, windowSizeY - 500); //変更するな

		//答えのボード
		RWTImage answerBoard = new RWTImage("data\\sozai\\answerBoard.png");
		answerBoard.setSize(windowSizeX - 600, windowSizeY - 400); //変更するな

		//HPbar プレイヤー
		RWTImage playerHpBar = new RWTImage("data\\sozai\\playerHP.png");
		playerHpBar.setSize(windowSizeX - 800, windowSizeY - 400); //変更するな
		playerHpBar.setRelativePosition(0.02f, -0.025f);

		//HPbar エネミー
		RWTImage enemyHpBar = new RWTImage("data\\sozai\\enemyHP.png");
		enemyHpBar.setSize(windowSizeX - 800, windowSizeY - 400); //変更するな
		enemyHpBar.setRelativePosition(0.08f, -0.025f);

		//エネミー
		RWTImage enemy = new RWTImage("data\\sozai\\toka_yuusya.png");
		enemy.setSize(500, 500); //変更するな
		enemy.setRelativePosition(0.01f, 0.04f);

		addWidget(questionBoard); //質問のボード表示

		addWidget(playerHpBar); //プレイヤーHPの表示
		addWidget(enemyHpBar); //エネミーHPの表示
		addWidget(enemy); //エネミーHPの表示

		canvas.setRelativePosition(0.0f, 0.0f); // 3D表示部の左上端
		canvas.setRelativeSize(0.0f, 0.5f);// 3D表示部のサイズ
		addCanvas(canvas);

		dialog.setRelativePosition(0.3f, 0.2f); // ダイアログの左上端
		dialog.setFont(new Font("E", Font.PLAIN, 10)); // 文字のフォント
		dialog.setColor(Color.white); // 文字の色
		addWidget(dialog);

		Font f = new Font("", Font.PLAIN, 30);
		optionButtons[0] = new RWTButton("1");
		optionButtons[0].setFont(f);
		//optionButtons[0].setRelativePosition(0.25f, 0.6f);
		optionButtons[0].setRelativePosition(0.17f, 0.67f);
		optionButtons[0].setRelativeHeight(0.1f);
		optionButtons[0].setRelativeWidth(0.3f);
		addSelectableWidget(optionButtons[0], 0, 0);

		optionButtons[1] = new RWTButton("2");
		optionButtons[1].setFont(f);
		optionButtons[1].setRelativePosition(0.52f, 0.67f);
		optionButtons[1].setRelativeHeight(0.1f);
		optionButtons[1].setRelativeWidth(0.3f);
		addSelectableWidget(optionButtons[1], 1, 0);

		optionButtons[2] = new RWTButton("3");
		optionButtons[2].setFont(f);
		optionButtons[2].setRelativePosition(0.17f, 0.83f);
		optionButtons[2].setRelativeHeight(0.1f);
		optionButtons[2].setRelativeWidth(0.3f);
		addSelectableWidget(optionButtons[2], 0, 1);

		optionButtons[3] = new RWTButton("4");
		optionButtons[3].setFont(f);
		optionButtons[3].setRelativePosition(0.52f, 0.83f);
		optionButtons[3].setRelativeHeight(0.1f);
		optionButtons[3].setRelativeWidth(0.3f);
		addSelectableWidget(optionButtons[3], 1, 1);

		addWidgetOnBack(answerBoard); //答えのボード表示
		addWidgetOnBack(backGround); //背景表示


		draw(g);

		repaint();
	}

	//矩形を表示しようとした
	public void draw(Graphics g) {
        // 矩形
        // (x1,y1,x2,y2,paint) 左上の座標(x1,y1), 右下の座標(x2,y2)
        //canvas.drawRect(100,200,100, 200, paint);
		 //色の設定
		g.setColor(Color.WHITE);
		 //指定範囲塗りつぶし
		g.fillRect(100, 200, 100, 200);
		g.setColor(Color.BLACK);

	}

	public void showOption(int n, String option) {
		optionButtons[n].setLabel(option);

	}

	@Override
	public void keyPressed(RWTVirtualKey key) {
		if (key.getVirtualKey() == RWTVirtualController.RIGHT) {
			cursorMoveRight();
		} else if (key.getVirtualKey() == RWTVirtualController.LEFT) {
			cursorMoveLeft();
		} else if (key.getVirtualKey() == RWTVirtualController.UP) {
			cursorMoveUp();
		} else if (key.getVirtualKey() == RWTVirtualController.DOWN) {
			cursorMoveDown();
		}
	}

	@Override
	public void keyReleased(RWTVirtualKey key) {
		if (key.getPlayer() == 0 && key.getVirtualKey() == RWTVirtualController.BUTTON_A) {
			RWTWidget selected = getSelectedWidget();
			for (int i = 0; i < 4; i++) {
				if (selected == optionButtons[i]) {
					scenario.fire(optionButtons[i].getLabel());
				}
			}
		}
	}

	@Override
	public void keyTyped(RWTVirtualKey key) {
	}
}
