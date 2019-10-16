package template.quiz2D;

import java.awt.Color;

import framework.RWT.RWTContainer;
import framework.RWT.RWTFrame3D;
import framework.RWT.RWTVirtualController;
import framework.gameMain.SimpleScenarioGame;
import framework.model3D.Universe;
import framework.scenario.Event;
import framework.scenario.ScenarioState;
import framework.view3D.Camera3D;

public class TemplateQuizGame extends SimpleScenarioGame {
	private RWTFrame3D frame;
	public int playerHP = 100;// �v���C���[��HP�錾
	public int enemyHP = 20;

	//�V�i���I�̏�����
	@Override
	public void init(Universe universe, Camera3D camera) {
		// �V�i���I�̐ݒ�
		if(enemyHP > 0 && playerHP > 0) {
		setScenario("data\\TemplateQuiz\\scenario.xml");
		container.setScenario(scenario);
		scenario.fire("�J�n");
		}
	}

	@Override
	public RWTFrame3D createFrame3D() {
		frame = new RWTFrame3D();
		frame.setSize(1280, 720);
		frame.setTitle("Template for 2D Quiz Game");
		frame.setBackground(Color.BLACK);
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
		((QuizGameContainer)container).showOption(n, option);
	}

	@Override
	public void action(String action, Event event, ScenarioState nextState) {

		// �V�i���I�i�s�ɂ�鐢�E�ւ̍�p�������ɏ���
		if (action.equals("right")) {
			enemyHP -= 10;
		} else if (action.equals("wrong")) {
			playerHP -= 10;
		}

		if(enemyHP<=0) {
			System.out.println("���Ȃ��̏���");
		}
		if(playerHP<=0) {
			System.out.println("���Ȃ��̂܂�");
		}

		//debug
		System.out.println("pHP "+playerHP);
		System.out.println("eHP "+enemyHP);
	}

	/**
	 * �Q�[���̃��C��
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		TemplateQuizGame game = new TemplateQuizGame();
		game.setFramePolicy(5, 33, false); //�����͕ς��Ȃ�
		game.start(); //�Q�[���͂���

	}

}
