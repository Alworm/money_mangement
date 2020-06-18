import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 收益率面板  二
 */
public class YieldPanel extends JPanel {
    JTextField jTextField1,jTextField2,jTextField3,jTextField4,jTextField5;
    JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5;
    JButton jButton1,jButton2;
    public YieldPanel(){
        //第一行
        jTextField1 = new JTextField(20);
        jLabel1 = new JLabel("    买入价格：");
        JLabel jLabel11 = new JLabel("元");
        this.add(jLabel1);
        this.add(jTextField1);
        this.add(jLabel11);

        //第二行
        jTextField2 = new JTextField(20);
        jLabel2 = new JLabel("卖出价格：    ");
        JLabel jLabel22 = new JLabel("元");
        this.add(jLabel2);
        this.add(jTextField2);
        this.add(jLabel22);

        //第三行
        jTextField3 = new JTextField(20);
        jLabel3 = new JLabel(" 持有年限：    ");
        JLabel jLabel33 = new JLabel("年");
        this.add(jLabel3);
        this.add(jTextField3);
        this.add(jLabel33);

        //第四行
        jButton1 = new JButton("计算");
        JLabel jLabel = new JLabel("                       ");
        jButton2 = new JButton("清空");
        JLabel jLabel3 = new JLabel("                             ");
        this.add(jButton1);
        this.add(jLabel);
        this.add(jButton2);
        this.add(jLabel3);


        //第四行
        jTextField4 = new JTextField(20);
        jLabel4 = new JLabel(" 总收益率：    ");
        JLabel jLabel44 = new JLabel("%");
        this.add(jLabel4);
        this.add(jTextField4);
        this.add(jLabel44);

        //第四行
        jTextField5 = new JTextField(20);
        jLabel5 = new JLabel(" 年化收益率：");
        JLabel jLabel45 = new JLabel("%");
        this.add(jLabel5);
        this.add(jTextField5);
        this.add(jLabel45);

        //上面是布局
        //下面是给按钮添加点击事件

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取每个输入框的内容
                String benjin = jTextField1.getText();
                String shouyi = jTextField2.getText();
                String touzi = jTextField3.getText();
                //讲字符串类型转化为float类型和int类型
                float i = Float.parseFloat(benjin);
                float j = Float.parseFloat(shouyi);
                int z = Integer.parseInt(touzi);
                //计算
                float v = (j - i) / i * 100;
                //给总收益赋值
                jTextField4.setText(v+"");

                double v1 = Math.pow(j / i, 1 / z) - 1;
                jTextField5.setText(v1*100+"");

            }
        });


        //给清空按钮添加点击事件
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
            }
        });
    }
}
