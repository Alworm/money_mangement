package refactor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        MyJFrame myJFrame = new Main().new MyJFrame();
    }
    /**
     * 定投选项卡
     */
    class Invest extends JPanel{
        JTextField jTextField1,jTextField2,jTextField3,jTextField4;
        JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel11,jLabel22,jLabel33,jLabel44,jLabel132;
        JButton jButton1,jButton2;
        public Invest(){
            //投资时长
            jTextField1 = new JTextField(20);
            jLabel1 = new JLabel("   投资时长：  ");
            jLabel11 = new JLabel("年");
            this.add(jLabel1);this.add(jTextField1);this.add(jLabel11);
            //年化收益率
            jTextField2 = new JTextField(20);
            jLabel2 = new JLabel("年化收益率：");
            jLabel22 = new JLabel("%");
            this.add(jLabel2);this.add(jTextField2);this.add(jLabel22);
            //每月存入
            jTextField3 = new JTextField(20);
            jLabel3 = new JLabel(" 每月存入：     ");
            jLabel33 = new JLabel("元");
            this.add(jLabel3);this.add(jTextField3);this.add(jLabel33);
            //投资收益(年)
            jTextField4 = new JTextField(20);
            jLabel4 = new JLabel(" 投资收益(年)：");
            jLabel44 = new JLabel("元");
            this.add(jLabel4);this.add(jTextField4);this.add(jLabel44);
            /*设置计算按钮和清空按钮*/
            jButton1 = new JButton("计算");
            jButton1.setBackground(new Color(0x4387AF));
            jLabel132 = new JLabel("                       ");
            jButton2 = new JButton("清空");
            jButton2.setBackground(new Color(0xAF4F1C));
            JLabel jLabel3 = new JLabel("                       ");
            this.add(jButton1);this.add(jLabel132);this.add(jButton2);this.add(jLabel3);
            /**给按钮添加点击事件*/
            jButton1.addActionListener(new MyListener1());
            //给清空按钮添加点击事件
            jButton2.addActionListener(new MyListener2());
        }

        /**
         * 声明内部类implements 接口，以实现创建事件
         */
        class MyListener1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                float money = Float.parseFloat(jTextField1.getText())*12;
                float per = Float.parseFloat(jTextField2.getText());
                int year = Integer.parseInt(jTextField3.getText());
                float q = 1 + per / 100;
                double qn = Math.pow(q, year);
                double x = (1 - qn) / (1 - q);
                double last = money * q * x;
                jTextField4.setText(last+"");
            }
        }

        /**
         * 声明内部类implements 接口，以实现创建事件
         */
        class MyListener2 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("");jTextField2.setText("");jTextField3.setText("");jTextField4.setText("");
            }
        }

    }
    /**
     * 受益选项卡
     */
    class ShouYi extends JPanel{
        JTextField jTextField1,jTextField2,jTextField3,jTextField4,jTextField5;
        JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5;
        JButton jButton1,jButton2;
        public ShouYi(){
            //买入价格
            jTextField1 = new JTextField(20);
            jLabel1 = new JLabel("    买入价格：");
            JLabel jLabel11 = new JLabel("元");
            this.add(jLabel1);this.add(jTextField1);this.add(jLabel11);
            //卖出价格行
            jTextField2 = new JTextField(20);
            jLabel2 = new JLabel("卖出价格：    ");
            JLabel jLabel22 = new JLabel("元");
            this.add(jLabel2);this.add(jTextField2);this.add(jLabel22);
            //持有年限
            jTextField3 = new JTextField(20);
            jLabel3 = new JLabel(" 持有年限：    ");
            JLabel jLabel33 = new JLabel("年");
            this.add(jLabel3);this.add(jTextField3);this.add(jLabel33);
            //设置计算按钮和清空按钮
            jButton1 = new JButton("计算");
            jButton1.setBackground(new Color(0x4387AF));
            JLabel jLabel = new JLabel("                       ");
            jButton2 = new JButton("清空");
            jButton2.setBackground(new Color(0xAF4F1C));
            JLabel jLabel3 = new JLabel("                             ");
            this.add(jButton1);this.add(jLabel);this.add(jButton2);this.add(jLabel3);
            //总收益率
            jTextField4 = new JTextField(20);
            jLabel4 = new JLabel(" 总收益率：    ");
            JLabel jLabel44 = new JLabel("%");
            this.add(jLabel4);this.add(jTextField4);this.add(jLabel44);
            //年化收益率行
            jTextField5 = new JTextField(20);
            jLabel5 = new JLabel(" 年化收益率：");
            JLabel jLabel45 = new JLabel("%");
            this.add(jLabel5);this.add(jTextField5);this.add(jLabel45);
            //下面是给按钮添加点击事件
            jButton1.addActionListener(new MyListener1());
            //给清空按钮添加点击事件
            jButton2.addActionListener(new MyListener2());
        }

        class MyListener1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取每个输入框的内容
                //讲字符串类型转化为float类型和int类型
                float i = Float.parseFloat(jTextField1.getText());
                float j = Float.parseFloat(jTextField2.getText());
                int z = Integer.parseInt(jTextField3.getText());
                float v = (j - i) / i * 100;
                //给总收益赋值
                jTextField4.setText(v+"");
                double v1 = Math.pow(j / i, 1 / z) - 1;
                jTextField5.setText(v1*100+"");
            }
        }
        class MyListener2 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("");jTextField2.setText("");jTextField3.setText("");jTextField4.setText("");jTextField5.setText("");
            }
        }
    }
    /**
     * 最终受益选项卡
     */
    class FinalPanel extends JPanel{
        JTextField jTextField1,jTextField2,jTextField3,jTextField4;
        JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel11,jLabel22,jLabel33,jLabel41,jLabel42,jLabel44;
        JButton jButton1,jButton2;
        public FinalPanel(){
            //本金行
            jTextField1 = new JTextField(20);
            jLabel1 = new JLabel("       本金：      ");
            jLabel11 = new JLabel("元");
            //年化收益率行
            jTextField2 = new JTextField(20);
            jLabel2 = new JLabel("年化收益率：");
            jLabel22 = new JLabel("%");
            //投资年限行
            jTextField3 = new JTextField(20);
            jLabel3 = new JLabel(" 投资年限：     ");
            jLabel33 = new JLabel("年");
            //设置计算按钮和清空按钮
            jButton1 = new JButton("计算");
            jButton1.setBackground(new Color(0x4387AF));
            jLabel41 = new JLabel("                       ");
            jButton2 = new JButton("清空");
            jButton2.setBackground(new Color(0xAF4F1C));
            jLabel42 = new JLabel("                       ");
            //第四行
            jTextField4 = new JTextField(20);
            jLabel4 = new JLabel("        最终收益：     ");
            jLabel44 = new JLabel("元");
            //添加到容器中
            this.add(jLabel1);this.add(jTextField1);this.add(jLabel11);this.add(jLabel2);this.add(jTextField2);
            this.add(jLabel22);this.add(jLabel3);this.add(jTextField3);this.add(jLabel33);this.add(jButton1);
            this.add(jLabel41);this.add(jButton2);this.add(jLabel42);this.add(jLabel4);this.add(jTextField4);this.add(jLabel44);
            //给 计算 按钮添加点击事件
            jButton1.addActionListener(new MyListener1());
            //给清空按钮添加点击事件
            jButton2.addActionListener(new MyListener2());
        }
        class MyListener1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                float i = Float.parseFloat(jTextField1.getText());
                float j = Float.parseFloat(jTextField2.getText());
                int z = Integer.parseInt(jTextField3.getText());
                double v = i * Math.pow(1 + j / 100, z);
                jTextField4.setText(v+"");
            }
        }
        class MyListener2 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("");jTextField2.setText("");jTextField3.setText("");jTextField4.setText("");
            }
        }

    }
    /**
    JFrame容器，作为最终的容器
     */
    class MyJFrame extends JFrame{
        JTabbedPane jtbp; //定义选项卡
        FinalPanel finalPanel; //定义最终受益
        ShouYi shouYi;//定义收益率
        Invest invest;//定义定投
        CaiWu caiWu;//定义财务自用计算
        public MyJFrame(){
            finalPanel = new FinalPanel();
            shouYi = new ShouYi();
            invest = new Invest();
            caiWu = new CaiWu();
            //创建选项卡
            jtbp=new JTabbedPane();
            //创建四个面板
            jtbp.add("最终受益",finalPanel);
            jtbp.add("收益率",shouYi);
            jtbp.add("定投",invest);
            jtbp.add("财务自由计算",caiWu);
            //添加组件
            this.add(jtbp);//添加选项卡窗格到容器
            //设置界面的标题
            this.setTitle("常用理财计算器");
            //设置界面大小
            this.setSize(400, 500);
            //设置界面初始位置
            this.setLocation(800, 300);
            //关闭
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }
    /**
     * 财务选项卡
     */
    class CaiWu extends JPanel{
        JTextField jTextField1,jTextField2,jTextField3,jTextField4,jTextField5,jTextField6;
        JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6,jLabel11;
        JButton jButton1,jButton2;
        public CaiWu(){
            //本金
            jTextField1 = new JTextField(20);
            jLabel1 = new JLabel("    本金：        ");
            jLabel11 = new JLabel("元");
            //添加到容器中
            this.add(jLabel1);this.add(jTextField1);this.add(jLabel11);
            //月定投
            jTextField2 = new JTextField(20);
            jLabel2 = new JLabel("月定投：        ");
            JLabel jLabel22 = new JLabel("元");
            this.add(jLabel2);this.add(jTextField2);this.add(jLabel22);
            //年化受益
            jTextField3 = new JTextField(20);
            jLabel3 = new JLabel(" 年化收益：  ");
            JLabel jLabel33 = new JLabel("%");
            this.add(jLabel3);this.add(jTextField3);this.add(jLabel33);
            //月支出
            jTextField6 = new JTextField(20);
            jLabel6 = new JLabel(" 月支出：       ");
            JLabel jLabel66 = new JLabel("元");
            this.add(jLabel6);this.add(jTextField6);this.add(jLabel66);
            //设置计算按钮，和清空按钮
            jButton1 = new JButton("计算");
            jButton1.setBackground(new Color(0x4387AF));
            JLabel jLabel = new JLabel("                       ");
            jButton2 = new JButton("清空");
            jButton2.setBackground(new Color(0xAF4F1C));
            JLabel jLabel3 = new JLabel("                             ");
            this.add(jButton1);this.add(jLabel);this.add(jButton2);this.add(jLabel3);
            //月均获得收益
            jTextField4 = new JTextField(20);
            jLabel4 = new JLabel("月均获得收益：");
            JLabel jLabel44 = new JLabel("元");
            this.add(jLabel4);this.add(jTextField4);this.add(jLabel44);
            //财务自由时间
            jTextField5 = new JTextField(20);
            jLabel5 = new JLabel("财务自由时间：");
            JLabel jLabel45 = new JLabel("年");
            this.add(jLabel5);this.add(jTextField5);this.add(jLabel45);
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



}
