package template.quiz2D;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class paint {






		    static int w = 800, h = 600;

		    public static void main(String[] args) {
		        run();
		    }

		    public static void run() {
		        // JFrame�̃C���X�^���X�𐶐�
		        JFrame frame = new JFrame("���G�����A�v��");
		        // �E�B���h�E�������v���O�������I������
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        // �E�B���h�E�̃T�C�Y�E�����ʒu
		        frame.setSize(w, h);
		        frame.setLocationRelativeTo(null);
		        // setBounds(x, y, w, h);

		        // PaintCanvas�̃C���X�^���X�𐶐�
		        PaintCanvas canvas = new PaintCanvas();

		        // �t���[���ɒǉ�
		        JPanel pane = new JPanel();
		        frame.getContentPane().add(pane, BorderLayout.CENTER);
		        JPanel paneB = new JPanel();
		        frame.getContentPane().add(paneB, BorderLayout.NORTH);

		        canvas.setPreferredSize(new Dimension(w, h));
		        pane.add(canvas);

		        /* �ǉ��@�\ */
		        // �S����
		        JButton clear = new JButton("CLEAR");
		        clear.addActionListener(new ClearListener(canvas));
		        paneB.add(clear);

		        // ���̑�������
		        JSlider slider = new JSlider(1, 50, 1); // �ŏ��l�A�ő�l�A�����l
		        slider.addChangeListener(new SliderListener(canvas)); // ���荞�ݏ����p
		        paneB.add(slider);

		        // ���̐F�ύX
		        String[] combodata = { "BLACK", "RED", "BLUE", "GREEN" };
		        JComboBox combo = new JComboBox(combodata);
		        combo.addActionListener(new ComboListener(canvas));
		        paneB.add(combo);

		        // �E�B���h�E��\��
		        frame.setVisible(true);
		    }

		    // �L�����o�X�N���X
		    static class PaintCanvas extends Canvas implements MouseListener,
		            MouseMotionListener {

		        // �`����e��ێ�����BufferedImage
		        private BufferedImage cImage = null;
		        // cImage�ɕ`�悷�邽�߂̃C���X�^���X
		        private Graphics2D g2d;

		        // ���̊J�n���W�E�I�����W
		        private int x, y, xx, yy;
		        // �`�惂�[�h�n�q�����S�����[�h
		        private int type;
		        // ���̑���
		        public int width = 1;
		        // ���̐F
		        public Color c = Color.black;

		        public PaintCanvas() {
		            // ���W��������
		            x = -1;
		            y = -1;
		            xx = -1;
		            yy = -1;
		            type = 0;

		            // MouseListener�EMouseMotionListener��ݒ�
		            addMouseListener(this);
		            addMouseMotionListener(this);

		            // �L�����o�X�̔w�i�𔒂ɐݒ�
		            setBackground(Color.white);
		            // �`����e��ێ�����BufferedImage�𐶐�
		            cImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		            g2d = (Graphics2D) cImage.getGraphics();
		            // BufferedImage�̔w�i�����ɂ���
		            g2d.setColor(Color.WHITE);
		            g2d.fillRect(0, 0, w, h);

		            // �`��
		            repaint();
		        }

		        // �L�����o�X���N���A
		        public void clear() {
		            g2d.setColor(Color.WHITE);
		            g2d.fillRect(0, 0, w, h);
		            repaint();
		        }

		        // ���̑����ύX
		        public void setStroke(int n) {
		            width = n;
		        }

		        // ���̐F�ύX
		        public void setColorCombo(String color) {
		            if (color.equals("BLACK")) {
		                c = Color.black;
		            } else if (color.equals("RED")) {
		                c = Color.red;
		            } else if (color.equals("BLUE")) {
		                c = Color.blue;
		            } else if (color.equals("GREEN")) {
		                c = Color.green;
		            } 
		        }

		        public void paint(Graphics g) {
		            // �`�惂�[�h�i������`��j
		            if (type == 1) {
		                if (x >= 0 && y >= 0 && xx >= 0 && yy >= 0) {
		                    BasicStroke stroke = new BasicStroke(width,
		                            BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		                    g2d.setStroke(stroke);
		                    g2d.setColor(c);
		                    g2d.drawLine(xx, yy, x, y);
		                }
		                // �����S�����[�h
		            } else if (type == 2) {
		                if (x >= 0 && y >= 0 && xx >= 0 && yy >= 0) {
		                    // ���[���ۂ������ɐݒ�
		                    BasicStroke stroke = new BasicStroke(50.0f,
		                            BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		                    g2d.setStroke(stroke);
		                    g2d.setColor(Color.white);
		                    g2d.drawLine(xx, yy, x, y);
		                }
		            }

		            // �`����e���L�����o�X�ɂ����f
		            g.drawImage(cImage, 0, 0, null);
		        }

		        @Override
		        public void mouseDragged(MouseEvent e) {
		            // ������Ă���{�^�������m
		            if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
		                // ���{�^���N���b�N�@�i�`�惂�[�h�j
		                type = 1;
		            }
		            if ((e.getModifiers() & MouseEvent.BUTTON2_MASK) != 0) {
		                // �����{�^���N���b�N
		            }
		            if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
		                // �E�{�^���N���b�N�@�i�����S�����[�h�j
		                type = 2;
		            }

		            // �ߋ��̍��W���J�n���W�ɐݒ�
		            xx = x;
		            yy = y;

		            // �V�������W���I�����W�ɐݒ�
		            Point point = e.getPoint();
		            x = point.x;
		            y = point.y;

		            // �ĕ`��
		            repaint();
		        }

		        @Override
		        public void mouseMoved(MouseEvent e) {
		            // �h���b�O���I����������W��������
		            x = -1;
		            y = -1;
		            xx = -1;
		            yy = -1;
		            type = 0;
		        }

		        @Override
		        public void mouseClicked(MouseEvent e) {
		        }

		        @Override
		        public void mousePressed(MouseEvent e) {
		            Point point = e.getPoint();
		            x = point.x;
		            y = point.y;
		        }

		        @Override
		        public void mouseReleased(MouseEvent e) {
		        }

		        @Override
		        public void mouseEntered(MouseEvent e) {
		        }

		        @Override
		        public void mouseExited(MouseEvent e) {
		        }

		    }

		    // �N���A�{�^���p
		    static class ClearListener implements ActionListener {

		        PaintCanvas canvas;

		        public ClearListener(PaintCanvas canvas) {
		            super();
		            this.canvas = canvas;
		        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		            canvas.clear();
		        }

		    }

		    // �X���C�_�[�p
		    static class SliderListener implements ChangeListener {

		        PaintCanvas canvas;

		        public SliderListener(PaintCanvas canvas) {
		            super();
		            this.canvas = canvas;
		        }

		        @Override
		        public void stateChanged(ChangeEvent e) {
		            JSlider source = (JSlider) e.getSource();
		            int fps = (int) source.getValue();
		            canvas.setStroke(fps);
		        }

		    }

		    // �R���{�{�b�N�X�p
		    static class ComboListener implements ActionListener {

		        PaintCanvas canvas;

		        public ComboListener(PaintCanvas canvas) {
		            super();
		            this.canvas = canvas;
		        }

		        @Override
		        public void actionPerformed(ActionEvent e) {
		            JComboBox source = (JComboBox) e.getSource();
		            String color = (String) source.getSelectedItem();
		            canvas.setColorCombo(color);
		        }

		    }

		}




