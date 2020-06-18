import javax.swing.*;

public class JPane extends JFrame {
    //定义组件
    JTabbedPane jtbp; //定义选项卡
    EndPanel endPanel;
    YieldPanel yieldPanel;
    InvestmentPanel investmentPanel;
    FreedomPanel freedomPanel;

    public JPane(){
        endPanel = new EndPanel();
        yieldPanel = new YieldPanel();
        investmentPanel = new InvestmentPanel();
        freedomPanel = new FreedomPanel();

        //创建组件
        jtbp=new JTabbedPane();	//创建选项卡
        jtbp.add("最终受益",endPanel);	//创建四个面板
        jtbp.add("收益率",yieldPanel);
        jtbp.add("定投",investmentPanel);
        jtbp.add("财务自由计算",freedomPanel);

        //添加组件
        this.add(jtbp);//添加选项卡窗格到容器

        //设置界面属性
        this.setTitle("常用理财计算器");		//设置界面标题
        this.setSize(380, 500);				//设置界面像素
        this.setLocation(200, 200);			//设置界面初始位置
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置虚拟机和界面一同关闭
//        this.setResizable(false);// 设置不能修改窗口大小
        this.setVisible(true);
    }
}
