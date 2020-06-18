import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 财务自用面板  四
 */
public class FreedomPanel extends JPanel {
    JTextField jTextField1,jTextField2,jTextField3,jTextField4,jTextField5,jTextField6;
    JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6;
    JButton jButton1,jButton2;
    public FreedomPanel(){
        //第一行
        jTextField1 = new JTextField(20);
        jLabel1 = new JLabel("    本金：        ");
        JLabel jLabel11 = new JLabel("元");
        this.add(jLabel1);
        this.add(jTextField1);
        this.add(jLabel11);

        //第二行
        jTextField2 = new JTextField(20);
        jLabel2 = new JLabel("月定投：        ");
        JLabel jLabel22 = new JLabel("元");
        this.add(jLabel2);
        this.add(jTextField2);
        this.add(jLabel22);

        //第三行
        jTextField3 = new JTextField(20);
        jLabel3 = new JLabel(" 年化收益：  ");
        JLabel jLabel33 = new JLabel("%");
        this.add(jLabel3);
        this.add(jTextField3);
        this.add(jLabel33);

        //第四行
        jTextField6 = new JTextField(20);
        jLabel6 = new JLabel(" 月支出：       ");
        JLabel jLabel66 = new JLabel("元");
        this.add(jLabel6);
        this.add(jTextField6);
        this.add(jLabel66);


        //第五行
        jButton1 = new JButton("计算");
        JLabel jLabel = new JLabel("                       ");
        jButton2 = new JButton("清空");
        JLabel jLabel3 = new JLabel("                             ");
        this.add(jButton1);
        this.add(jLabel);
        this.add(jButton2);
        this.add(jLabel3);


        //第六行
        jTextField4 = new JTextField(20);
        jLabel4 = new JLabel("月均获得收益：");
        JLabel jLabel44 = new JLabel("元");
        this.add(jLabel4);
        this.add(jTextField4);
        this.add(jLabel44);

        //第七行
        jTextField5 = new JTextField(20);
        jLabel5 = new JLabel("财务自由时间：");
        JLabel jLabel45 = new JLabel("年");
        this.add(jLabel5);
        this.add(jTextField5);
        this.add(jLabel45);

        //给计算按钮添加点击事件
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = jTextField1.getText();
                String s2 = jTextField2.getText();
                String s3 = jTextField3.getText();
                String s4 = jTextField6.getText();
                float benjin = Float.parseFloat(s1);
                float dingtoujine = Float.parseFloat(s2);
                float nianhuashouyi = Float.parseFloat(s3)/100;
                float yuezhichu = Float.parseFloat(s4);
                float a1 = dingtoujine * 12 * (1 + nianhuashouyi);
                int n =1;
                do{
                    double b = a1 * Math.pow(1 + nianhuashouyi, n);
                    // 定投金额
                    double c = (a1 - b) / (-nianhuashouyi);
                    // 本金金额
                    double d = benjin * Math.pow(1 + nianhuashouyi, n);
                    double sum = c + d;
                    double yueSum = sum * nianhuashouyi / 12;
                    if(yueSum>yuezhichu){
                        jTextField5.setText(n+"");
                        jTextField4.setText(yueSum+"");
                        break;
                    }
                    n++;
                }while(n>0);


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
                jTextField6.setText("");
            }
        });

    }

}
