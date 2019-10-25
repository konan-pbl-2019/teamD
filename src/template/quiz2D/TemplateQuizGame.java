package template.quiz2D;

import java.awt.Color;

import framework.RWT.RWTContainer;
import framework.RWT.RWTFrame3D;
import framework.RWT.RWTVirtualController;
import framework.audio.BGM3D;
import framework.audio.Sound3D;
import framework.gameMain.SimpleScenarioGame;
import framework.model3D.Universe;
import framework.scenario.Event;
import framework.scenario.ScenarioState;
import framework.view3D.Camera3D;

public class TemplateQuizGame extends SimpleScenarioGame {
	private RWTFrame3D frame;
	private int playerHP=100;// プレイヤーのHP宣言
	private int enemyHP=100;

	private int enemyBeatNumber=0;



	// sound setting
	Sound3D bgm = BGM3D.registerBGM("data\\otoSozai\\stories.wav");
	Sound3D rightSE = new Sound3D("data\\otoSozai\\wave_Quiz-Correct_Answer02-1 (online-audio-converter.com).wav");
	Sound3D wrongSE = new Sound3D("data\\otoSozai\\wav_Quiz-Wrong_Buzzer01-1 (online-audio-converter.com).wav");

	// シナリオの初期化
	@Override
	public void init(Universe universe, Camera3D camera) {

		// シナリオの設定
		if (enemyHP > 0 && playerHP > 0) {
			setScenario("data\\TemplateQuiz\\scenario.xml");
			container.setScenario(scenario);
			scenario.fire("開始");
		}

	}

	@Override
	public RWTFrame3D createFrame3D() {
		frame = new RWTFrame3D();
		frame.setSize(2516, 1440);
		frame.setTitle("TeamD : Quiz Game");
		frame.setBackground(Color.WHITE);
		return frame;
	}

	@Override
	protected RWTContainer createRWTContainer() {
		container = new QuizGameContainer();
		return container;
	}

	@Override
	public void progress(RWTVirtualController virtualController, long interval) {
	}

	@Override
	public void showOption(int n, String option) {
		((QuizGameContainer) container).showOption(n, option);
	}

	@Override
	public void action(String action, Event event, ScenarioState nextState) {

		// シナリオ進行による世界への作用をここに書く
//		QuizGameContainer qgc = new QuizGameContainer();
//		qgc.HP(playerHP, enemyHP);




		if (action.equals("right")) {
			rightSE.play(); // se play(volume)

			enemyHP -= 10;
		} else if (action.equals("wrong")) {
			wrongSE.play(); // se

			playerHP -= 10;
		}

		if (enemyHP <= 0) {
			System.out.println("あなたの勝ち");
			enemyHP = 100;
			((QuizGameContainer) container).nextEnemy();

			enemyBeatNumber++;
			if(enemyBeatNumber>=2)
			{
				((QuizGameContainer) container).gameClearShow();
			}
//			scenario.fire("you win");
		}
		if (playerHP <= 0) {
			System.out.println("あなたのまけ");
			scenario.go("終了");

			((QuizGameContainer) container).retire();
		}

		((QuizGameContainer) container).playerHPShow(playerHP);
		((QuizGameContainer) container).enmeyHPShow(enemyHP);

		// debug
//		System.out.println("pHP "+playerHP);
//		System.out.println("eHP "+enemyHP);

		// bgm play
		BGM3D.playBGM(bgm);
	}

	/**
	 * ゲームのメイン
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		TemplateQuizGame game = new TemplateQuizGame();
		game.setFramePolicy(5, 33, false); // こいつは変えない
		game.start(); // ゲームはじめ

	}

}
