import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 最终受益面板  一
 */
public class EndPanel extends JPanel {
    JTextField jTextField1,jTextField2,jTextField3,jTextField4;
    JLabel jLabel1,jLabel2,jLabel3,jLabel4;
    JButton jButton1,jButton2;
    public EndPanel(){
        //第一行
        jTextField1 = new JTextField(20);
        jLabel1 = new JLabel("       本金：      ");
        JLabel jLabel11 = new JLabel("元");
        this.add(jLabel1);
        this.add(jTextField1);
        this.add(jLabel11);

        //第二行
        jTextField2 = new JTextField(20);
        jLabel2 = new JLabel("年化收益率：");
        JLabel jLabel22 = new JLabel("%");
        this.add(jLabel2);
        this.add(jTextField2);
        this.add(jLabel22);

        //第三行
        jTextField3 = new JTextField(20);
        jLabel3 = new JLabel(" 投资年限：     ");
        JLabel jLabel33 = new JLabel("年");
        this.add(jLabel3);
        this.add(jTextField3);
        this.add(jLabel33);

        //第四行
        jButton1 = new JButton("计算");
        JLabel jLabel = new JLabel("                       ");
        jButton2 = new JButton("清空");
        JLabel jLabel3 = new JLabel("                       ");

        this.add(jButton1);
        this.add(jLabel);
        this.add(jButton2);
        this.add(jLabel3);


        //第四行
        jTextField4 = new JTextField(20);
        jLabel4 = new JLabel(" 最终收益：     ");
        JLabel jLabel44 = new JLabel("元");
        this.add(jLabel4);
        this.add(jTextField4);
        this.add(jLabel44);

        //给 计算 按钮添加点击事件
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String benjin = jTextField1.getText();
                String shouyi = jTextField2.getText();
                String touzi = jTextField3.getText();
                float i = Float.parseFloat(benjin);
                float j = Float.parseFloat(shouyi);
                int z = Integer.parseInt(touzi);
                double v = i * Math.pow(1 + j / 100, z);
                jTextField4.setText(v+"");
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
            }
        });

    }




}
