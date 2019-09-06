import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 
public class SwingLoginExample {
	private static final String SwingLoginExample = null;
	private static JFrame frame;
	private static JButton loginButton;
	private static JTextField userText;
	private static JTextField city_idText; //: 1,//#����id
	private static JTextField warehouse_idText; // 45,#��Ʒ����ֿ�id
	private static JTextField delivery_area_idText; //12,#��������id��վ��id��
	private static JTextField company_idText; //3565362,#�̻����ŵ꣩id
	private static JTextField sale_area_idText;// 252,#������id
	private static JTextField sourceText;//; 22,#������Դ��0���� 99���˲��� 1���˵��� 22����
    public static void main(String[] args) {    
        // ���� JFrame ʵ��
        frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* ������壬��������� HTML �� div ��ǩ
         * ���ǿ��Դ��������岢�� JFrame ��ָ��λ��
         * ��������ǿ�������ı��ֶΣ���ť�����������
         */
        JPanel panel = new JPanel();    
        // ������
        frame.add(panel);
        /* 
         * �����û�����ķ����������������
         */
        placeComponents(panel);

        // ���ý���ɼ�
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* ���ֲ���������߲���������
         * ������ò���Ϊ null
         */
        panel.setLayout(null);

        // ���� JLabel
        
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /* 
         * �����ı��������û�����
         */
         userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        /* ������������������λ�á�
         * setBounds(x, y, width, height)
         * x �� y ָ�����Ͻǵ���λ�ã��� width �� height ָ���µĴ�С��
         */
        panel.add(userText);
        
        JLabel city_idLabel = new JLabel("����id:");
        city_idLabel.setBounds(10,80,80,25);
        panel.add(city_idLabel);
        city_idText= new JTextField(20); //: 1,//#����id
        city_idText.setBounds(100,80,165,25);
        panel.add(city_idText);
        
        JLabel warehouse_idLabel = new JLabel("��Ʒ����ֿ�id");
        warehouse_idLabel.setBounds(10,110,80,25);
        panel.add(warehouse_idLabel);
        
    	warehouse_idText= new JTextField(20); // 45,#��Ʒ����ֿ�id
    	warehouse_idText.setBounds(100,110,165,25);
         panel.add(warehouse_idText);
         
         JLabel delivery_area_idLabel = new JLabel("��������id");
         delivery_area_idLabel.setBounds(10,140,80,25);
         panel.add(delivery_area_idLabel);
    	delivery_area_idText= new JTextField(20); //12,#��������id��վ��id��
    	delivery_area_idText.setBounds(100,140,165,25);
    	panel.add(delivery_area_idText);
    	
    	JLabel company_idTextLabel = new JLabel("�̻����ŵ꣩id");
    	company_idTextLabel.setBounds(10,170,80,25);
        panel.add(company_idTextLabel);
    	
    	company_idText= new JTextField(20); //3565362,#�̻����ŵ꣩id
    	company_idText.setBounds(100,170,165,25);
         panel.add(company_idText);
    	
         JLabel sale_area_idTextLabel = new JLabel("������id:");
         sale_area_idTextLabel.setBounds(10,200,80,25);
         panel.add(sale_area_idTextLabel);
         
    	sale_area_idText= new JTextField(20);// 252,#������id
    	sale_area_idText.setBounds(100,200,165,25);
         panel.add(sale_area_idText);
         
         JLabel sourceLabel = new JLabel("������Դ:");
         sourceLabel.setBounds(10,230,80,25);
         panel.add(sourceLabel);
    	
    	sourceText= new JTextField(20);//; 22,#������Դ��0���� 99���˲��� 1���˵��� 22����
    	sourceText.setBounds(100,230,165,25);
         panel.add(sourceText);
    	
    	
        // ����������ı���
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /* 
         *�����������������ı���
         * �����������Ϣ���Ե�Ŵ��棬���ڰ�������İ�ȫ��
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // ������¼��ť
        loginButton = new JButton("login");
        loginButton.setBounds(280, 20, 80, 25);
        panel.add(loginButton);
        //ButtonClickListener bc=new ButtonClickListener();
        loginButton.addActionListener(new ButtonClickListener());
        

        //����һ�´����ϵ��¼�
       myEvent();
    }
    private static void myEvent()
    {
    	
		frame.addWindowListener(new WindowAdapter()//���ڼ���
        {
            public void windowClosing(WindowEvent e)
            {
                System.out.println("����ִ�йرգ�");
                System.exit(0);
            }
        });
        //�ð�ť�߱��رմ��ڵĹ���
		loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	Map map =new HashMap();
            	map.put("city_id" , city_idText.getText()); //: 1,//#����id
            	map.put("warehouse_id" , warehouse_idText.getText()); // 45,#��Ʒ����ֿ�id
            	map.put("delivery_area_id" , delivery_area_idText.getText()); //12,#��������id��վ��id��
            	map.put("company_id" , company_idText.getText()); //3565362,#�̻����ŵ꣩id
            	map.put("sale_area_id" , sale_area_idText.getText());// 252,#������id
            	map.put("1111", "2222");
            	String str=userText.getText();
            	String city_id = city_idText.getText(); //: 1,//#����id
            	String warehouse_id = warehouse_idText.getText(); // 45,#��Ʒ����ֿ�id
            	String delivery_area_id = delivery_area_idText.getText(); //12,#��������id��վ��id��
            	String company_id = company_idText.getText(); //3565362,#�̻����ŵ꣩id
            	String sale_area_id = sale_area_idText.getText();// 252,#������id
            	String sourceText;//; 22,#������Դ��0���� 99���˲��� 1���˵��� 22����
                System.out.println(sale_area_id);
                 //System.exit(0);
            }
        });
    }
     private static class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           
        	System.exit(0);

        }
    }
}
