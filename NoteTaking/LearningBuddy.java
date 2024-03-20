/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package learningbuddy;

import learningbuddy.NoteTaking.NoteTaking; // Import the NoteTaking class

/**
 *
 * @author LeePakLok
 */
public class LearningBuddy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Using lambda expression to simplify the code
        java.awt.EventQueue.invokeLater(() -> {
            new NoteTaking().setVisible(true);
        });
    }
}
