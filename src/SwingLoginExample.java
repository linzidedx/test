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
	private static JTextField city_idText; //: 1,//#城市id
	private static JTextField warehouse_idText; // 45,#商品出库仓库id
	private static JTextField delivery_area_idText; //12,#配送区域id（站区id）
	private static JTextField company_idText; //3565362,#商户（门店）id
	private static JTextField sale_area_idText;// 252,#售卖区id
	private static JTextField sourceText;//; 22,#订单来源（0美菜 99美菜补货 1美菜到家 22美鲜
    public static void main(String[] args) {    
        // 创建 JFrame 实例
        frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();    
        // 添加面板
        frame.add(panel);
        /* 
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /* 
         * 创建文本域用于用户输入
         */
         userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        panel.add(userText);
        
        JLabel city_idLabel = new JLabel("城市id:");
        city_idLabel.setBounds(10,80,80,25);
        panel.add(city_idLabel);
        city_idText= new JTextField(20); //: 1,//#城市id
        city_idText.setBounds(100,80,165,25);
        panel.add(city_idText);
        
        JLabel warehouse_idLabel = new JLabel("商品出库仓库id");
        warehouse_idLabel.setBounds(10,110,80,25);
        panel.add(warehouse_idLabel);
        
    	warehouse_idText= new JTextField(20); // 45,#商品出库仓库id
    	warehouse_idText.setBounds(100,110,165,25);
         panel.add(warehouse_idText);
         
         JLabel delivery_area_idLabel = new JLabel("配送区域id");
         delivery_area_idLabel.setBounds(10,140,80,25);
         panel.add(delivery_area_idLabel);
    	delivery_area_idText= new JTextField(20); //12,#配送区域id（站区id）
    	delivery_area_idText.setBounds(100,140,165,25);
    	panel.add(delivery_area_idText);
    	
    	JLabel company_idTextLabel = new JLabel("商户（门店）id");
    	company_idTextLabel.setBounds(10,170,80,25);
        panel.add(company_idTextLabel);
    	
    	company_idText= new JTextField(20); //3565362,#商户（门店）id
    	company_idText.setBounds(100,170,165,25);
         panel.add(company_idText);
    	
         JLabel sale_area_idTextLabel = new JLabel("售卖区id:");
         sale_area_idTextLabel.setBounds(10,200,80,25);
         panel.add(sale_area_idTextLabel);
         
    	sale_area_idText= new JTextField(20);// 252,#售卖区id
    	sale_area_idText.setBounds(100,200,165,25);
         panel.add(sale_area_idText);
         
         JLabel sourceLabel = new JLabel("订单来源:");
         sourceLabel.setBounds(10,230,80,25);
         panel.add(sourceLabel);
    	
    	sourceText= new JTextField(20);//; 22,#订单来源（0美菜 99美菜补货 1美菜到家 22美鲜
    	sourceText.setBounds(100,230,165,25);
         panel.add(sourceText);
    	
    	
        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /* 
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // 创建登录按钮
        loginButton = new JButton("login");
        loginButton.setBounds(280, 20, 80, 25);
        panel.add(loginButton);
        //ButtonClickListener bc=new ButtonClickListener();
        loginButton.addActionListener(new ButtonClickListener());
        

        //加载一下窗体上的事件
       myEvent();
    }
    private static void myEvent()
    {
    	
		frame.addWindowListener(new WindowAdapter()//窗口监听
        {
            public void windowClosing(WindowEvent e)
            {
                System.out.println("窗体执行关闭！");
                System.exit(0);
            }
        });
        //让按钮具备关闭窗口的功能
		loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	Map map =new HashMap();
            	map.put("city_id" , city_idText.getText()); //: 1,//#城市id
            	map.put("warehouse_id" , warehouse_idText.getText()); // 45,#商品出库仓库id
            	map.put("delivery_area_id" , delivery_area_idText.getText()); //12,#配送区域id（站区id）
            	map.put("company_id" , company_idText.getText()); //3565362,#商户（门店）id
            	map.put("sale_area_id" , sale_area_idText.getText());// 252,#售卖区id
            	map.put("1111", "2222");
            	String str=userText.getText();
            	String city_id = city_idText.getText(); //: 1,//#城市id
            	String warehouse_id = warehouse_idText.getText(); // 45,#商品出库仓库id
            	String delivery_area_id = delivery_area_idText.getText(); //12,#配送区域id（站区id）
            	String company_id = company_idText.getText(); //3565362,#商户（门店）id
            	String sale_area_id = sale_area_idText.getText();// 252,#售卖区id
            	String sourceText;//; 22,#订单来源（0美菜 99美菜补货 1美菜到家 22美鲜
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
