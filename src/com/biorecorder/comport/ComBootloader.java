package com.biorecorder.comport;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComBootloader {
    private static CallBackManager callBackManager = new CallBackManager();

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Com port disconnect");
                callBackManager.onExit();
                System.exit(0);
            }
        });

            JButton button = new JButton("Start") ;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    callBackManager.startProgramming();
                }
            });
            frame.getContentPane().add(button);
            frame.pack();
            frame.setVisible(true);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
        }
    }