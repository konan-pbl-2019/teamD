//memo
//OtoLogic

package template.quiz2D;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTBar;
import framework.RWT.RWTButton;
import framework.RWT.RWTImage;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;
import framework.RWT.RWTWidget;
import framework.gameMain.BaseScenarioGameContainer;

/**
 * �N�C�Y�Q�[���p���
 *
 * @author Nitta
 *
 */
public class QuizGameContainer extends BaseScenarioGameContainer {

	// ��ʃT�C�Y
	private int windowSizeX = 2516;
	private int windowSizeY = 1440;

	//	private RWTImage playerHpBar = new RWTImage("data\\sozai\\playerHPBar.png");
	//	private RWTImage enemyHpBar = new RWTImage("data\\sozai\\enemyHPBar.png");

	//	private int playerHpStatus = 100, enemyHpStatus = 100;

	//	Graphics g;

	private RWTBar playerHpBar = new RWTBar(100, 100);
	private RWTBar enemyHpBar = new RWTBar(100, 100);

	// enemy
	RWTImage enemy1 = new RWTImage("data\\sozai\\animalSinger.png");
	RWTImage enemy2 = new RWTImage("data\\sozai\\heisei.png");

	//gameover
	private RWTImage gameover = new RWTImage("data\\sozai\\GameOver.png");
	//gameclear
		private RWTImage gameClear = new RWTImage("data\\sozai\\GameClear.png");

	private RWTButton[] optionButtons = new RWTButton[4];

	public QuizGameContainer() {
		super();
	}

	//HP
	//	public void HPSet(int nowPlayerHpStatus,int nowEnemyHpStatus) {
	//		playerHpStatus = nowPlayerHpStatus;
	//		enemyHpStatus = nowEnemyHpStatus;
	//
	//
	////		addWidget(playerHpBar); // �v���C���[HP�̕\��
	////		addWidget(enemyHpBar); // enemy HP�̕\��
	//
	////		System.out.println("php "+playerHpStatus);
	////		System.out.println("ehp "+enemyHpStatus);
	//
	//	}

	@Override
	public void build(GraphicsConfiguration gc) {
		super.build(gc);

		//////////
		// �摜�̕\��
		//////////

		// �w�i
		RWTImage backGround = new RWTImage("data\\sozai\\TSU853_yuusyanoikutewo_TP_V.jpg");
		backGround.setSize(windowSizeX, windowSizeY);
		backGround.setRelativePosition(0, -0.35f);

		// ����{�[�h
		RWTImage questionBoard = new RWTImage("data\\sozai\\questionBoard.png");
		questionBoard.setRelativePosition(-0.02f, 0f);
		questionBoard.setSize(windowSizeX - 500, windowSizeY - 500); // �ύX�����

		// �����̃{�[�h
		RWTImage answerBoard = new RWTImage("data\\sozai\\answerBoard.png");
		answerBoard.setSize(windowSizeX - 600, windowSizeY - 400); // �ύX�����

		// HPbar �v���C���[
		RWTImage playerHp = new RWTImage("data\\sozai\\playerHP.png");
		playerHp.setSize(windowSizeX - 740, windowSizeY - 400); // �ύX�����
		playerHp.setRelativePosition(-0.242f, -0.215f);

		////		// HP �v���C���[
		//		RWTImage playerHpBar = new RWTImage("data\\sozai\\playerHPBar.png");
		////		playerHpBar.setSize(500, 200); // �ύX�����
		////		playerHpBar.setRelativePosition(0.085f, 0.52f);
		//		playerHpBar.setSize(5 * TemplateQuizGame.playerHP, 200); // �ύX�����
		//		playerHpBar.setRelativePosition(0.085f, 0.52f);

		// HPbar �G�l�~�[
		RWTImage enemyHp = new RWTImage("data\\sozai\\enemyHP.png");
		enemyHp.setSize(windowSizeX - 740, windowSizeY - 400); // �ύX�����
		enemyHp.setRelativePosition(0.05f, -0.025f);

		////		// HP �G�l�~�[
		//		RWTImage enemyHpBar = new RWTImage("data\\sozai\\enemyHPBar.png");
		////		enemyHpBar.setSize(500, 200); // �ύX�����
		////		enemyHpBar.setRelativePosition(0.678f, 0.52f);
		//		enemyHpBar.setSize(5 * TemplateQuizGame.enemyHP, 200); // �ύX�����
		//		enemyHpBar.setRelativePosition(0.678f, 0.52f);

		// player
		RWTImage player = new RWTImage("data\\sozai\\toka_yuusya.png");
		player.setSize(500, 500); // �ύX�����
		player.setRelativePosition(0.01f, 0.04f);

		//enemy
		enemy1.setSize(450, 450); // �ύX�����
		enemy1.setRelativePosition(0.775f, 0.07f);

		//enemy
		enemy2.setSize(450, 450); // �ύX�����
		enemy2.setRelativePosition(0.775f, 0.07f);
		enemy2.setVisible(false);

		addWidget(questionBoard); // ����̃{�[�h�\��

		//playerHP�o�[����
		playerHpBar.setColor(Color.GREEN);
		playerHpBar.setRelativePosition(0.084f, 0.525f);
		playerHpBar.setRelativeSize(0.265f, 0.05f);

		//enemyHP�o�[����
		enemyHpBar.setColor(Color.BLUE);
		enemyHpBar.setRelativePosition(0.653f, 0.525f);
		enemyHpBar.setRelativeSize(0.265f, 0.05f);

		//		addWidget(playerHp); // �v���C���[HP�̕\��
		//		addWidget(playerHpBar); // �v���C���[HP�̕\��
		//		addWidget(enemyHp); // enemy HP�̕\��
		//		addWidget(enemyHpBar); // enemy HP�̕\��

		//		// HP draws
		//		addWidget(playerHpBar); // �v���C���[HP�̕\��
		//		addWidget(enemyHpBar); // enemy HP�̕\��

		addWidget(player); // player�̕\��
		addWidget(enemy1); //enemy1

		addWidget(enemy2);//enemy2

		canvas.setRelativePosition(0.0f, 0.0f); // 3D�\�����̍���[
		canvas.setRelativeSize(0.0f, 0.5f);// 3D�\�����̃T�C�Y
		addCanvas(canvas);

		dialog.setRelativePosition(0.265f, 0.2f); // �_�C�A���O�̍���[
		dialog.setFont(new Font("E", Font.PLAIN, 9)); // �����̃t�H���g
		dialog.setColor(Color.white); // �����̐F
		addWidget(dialog);

		Font f = new Font("", Font.PLAIN, 30);
		optionButtons[0] = new RWTButton("1");
		optionButtons[0].setFont(f);
		// optionButtons[0].setRelativePosition(0.25f, 0.6f);
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

		addWidgetOnBack(answerBoard); // �����̃{�[�h�\��
		addWidgetOnBack(backGround); // �w�i�\��

		addWidget(playerHpBar); //
		addWidget(enemyHpBar);
		addWidget(playerHp); // �v���C���[HP�̕\��
		addWidget(enemyHp); // enemy HP�̕\��

		//�悤�킩���-> �킩����(^��^)/
		//		RWTBar bar = new RWTBar(100, 100);
		//		bar.setColor(Color.blue);

		//HP(playerHpStatus,enemyHpStatus);
		// draw(g);

		//gameover
		//RWTImage gameover = new RWTImage("data\\sozai\\GameOver.png");
		gameover.setSize(2000, 1200);
		gameover.setVisible(false);
		addWidget(gameover);

		gameClear.setSize(2000, 1200);
		gameClear.setVisible(false);
		addWidget(gameClear);

		repaint();

		//debug
		//		System.out.println(TemplateQuizGame.playerHP+" "+TemplateQuizGame.enemyHP);

	}

	/*// max player HP is 100. enemyHP too.
	public void HP(int playerHP, int enemyHP) {


		// HP �v���C���[
		// RWTImage playerHpBar = new RWTImage("data\\sozai\\playerHPBar.png");
		playerHpBar.setSize(5 * playerHP, 200); // �ύX�����
		playerHpBar.setRelativePosition(0.085f, 0.52f);

		// HP �G�l�~�[
		// RWTImage enemyHpBar = new RWTImage("data\\sozai\\enemyHPBar.png");
		enemyHpBar.setSize(5 * enemyHP, 200); // �ύX�����
		enemyHpBar.setRelativePosition(0.678f, 0.52f);

		//System.out.println("OK");

		System.out.println(playerHP+" "+ enemyHP);



		addWidget(playerHpBar); // �v���C���[HP�̕\��
		addWidget(enemyHpBar); // enemy HP�̕\��



		try {
			System.out.println("���s");
			repaint();
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	//		playerHpBar.repaint();


	}
	*/

	// ��`��\�����悤�Ƃ���
	//	public void draw(Graphics g) {
	//		// ��`
	//		// (x1,y1,x2,y2,paint) ����̍��W(x1,y1), �E���̍��W(x2,y2)
	//		// canvas.drawRect(100,200,100, 200, paint);
	//		// �F�̐ݒ�
	//		g.setColor(Color.WHITE);
	//		// �w��͈͓h��Ԃ�
	//		g.fillRect(100, 200, 100, 200);
	//		g.setColor(Color.BLACK);
	//
	//	}

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

	//*****HP�o�[�֘A*****
	public void playerHPShow(int HPValue) {

		playerHpBar.setValue(HPValue);
		System.out.println("php :" + HPValue);

	}

	public void enmeyHPShow(int HPValue) {
		enemyHpBar.setValue(HPValue);
		System.out.println("ehp :" + HPValue);

	}

	//�Q�[���I�[�o�[�̕\��
	public void retire() {
		gameover.setVisible(true);

	}

	//gameclear �̉��
	public void gameClearShow()
	{
		gameClear.setVisible(true);
	}

	//���̓G�\���ƑO�̓G������
	public void nextEnemy()
	{
		enemy1.setVisible(false);
		enemy2.setVisible(true);
	}

}
