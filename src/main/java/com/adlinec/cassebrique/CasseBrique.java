package com.adlinec.cassebrique;

import javax.swing.*;
import java.awt.*;

public class CasseBrique extends Canvas {

    public CasseBrique() throws InterruptedException {
        JFrame fenetre = new JFrame("Casse brique");

//On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();

//On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(500, 500));
        setBounds(0, 0, 500, 500);

//On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal
        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();

//On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        this.setFocusable(false);
        demarrer();
    }

    public void demarrer() throws InterruptedException {

        long indexFrame = 0;
//grace à la class Balle
        Balle balle = new Balle(
                250,
                250,
                Color.CYAN,
                4,
                -6,
                50
        );

        while (true) {
            indexFrame++;
//pour recupere la zone de dessin
            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

//pour delete dessin
            dessin.setColor(Color.WHITE);
            dessin.fillRect(0, 0, 500, 500);

//on dessin la balle grace à la class balle
            balle.deplacer();
            dessin.setColor(balle.getCouleur());
            dessin.fillOval(
                    balle.getX(),
                    balle.getY(),
                    balle.getDiametre(),
                    balle.getDiametre());
            dessin.setColor(Color.WHITE);
            dessin.fillOval(
                    balle.getX() + balle.getDecalageReflet(),
                    balle.getY() + balle.getDecalageReflet(),
                    balle.getDiametreReflet(),
                    balle.getDiametreReflet()
            );

            if(balle.getX() < 0 || balle.getX() > 500 - balle.getDiametre()) {
                balle.inverseVitesseHorizontal();
            }

            if(balle.getY() < 0 || balle.getY() > 500 - balle.getDiametre()) {
                balle.inverseVitesseVertical();
            }

//on dis que le dessin est fini
            dessin.dispose();
//pour afficher le dessin
            getBufferStrategy().show();

//pour verifier si indexFrame tourne bien
//            System.out.println(indexFrame);

//pour raffraichir le jeu
            Thread.sleep(1000 / 60);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new CasseBrique();
    }
}


//-------------------------------------------------------------------------------

                     //ON CREE UNE BALLE SANS LA CLASS BALLE

// on definit l'emplacement de depart
//        int xBalle = 250;
//        int yBalle = 250;
//        int vitesseHorizontalBalle = -2;
//        int vitesseVerticalBalle = -4;
//
//        int diametreBalle = 50;
//        int diametreRefletBalle = 50 * 30 / 100;
//        // ou alors : int diametreRefletBalle = 50 * 0.3f;
//        int decalageReflet = diametreBalle * 20 / 100;
// on assigne une couleur
//            dessin.setColor(Color.MAGENTA);
//            xBalle += vitesseHorizontalBalle;
//            yBalle += vitesseVerticalBalle;



//// mouvement de la balle de droite a gauche
//            if (xBalle < 0 || xBalle > 500 - diametreBalle) {
//                vitesseHorizontalBalle *= -1;
//                //vitesseHorizontalBalle = vitesseHorizontalBalle * -1
//            }
////mouvement de la balle rebond parois
//            if (yBalle <0 || yBalle > 500 - diametreBalle) {
//                vitesseVerticalBalle *= -1;
//            }

// desinner rebond parois
            //dessin.fillOval(xBalle, yBalle, diametreBalle, diametreBalle);
//on dessine la balle dans la balle
//            dessin.setColor(Color.WHITE);
//            dessin.fillOval(
//                    xBalle + decalageReflet,
//                    yBalle + decalageReflet,
//                    diametreRefletBalle,
//                    diametreRefletBalle
//            );


//            dessin.fillOval((int) indexFrame, 250, 30, 30);
//            dessin.fillOval(xBalle, 250, 30, 30);
//on dessine un oval center
            //dessin.fillOval(250, 250, 30, 30); //balle fixe

//on dis que le dessin est fini
            // dessin.dispose();
//pour afficher le dessin
            // getBufferStrategy().show();

//pour verifier si indexFrame tourne bien
            // System.out.println(indexFrame);


//pour raffraichir le jeu
            //Thread.sleep(1000 / 60);

//-------------------------------------------------------------------------------

                    // CREATION BOITE AVEC BOUTON ET CASSE A COCHER

//import javax.swing.*;

//public class CasseBrique extends JFrame {

//    public CasseBrique(){
//
//        setSize(500, 500);
//        //    or    this.setSize(500, 500);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //pour fermer la fenetre et arreter son proccessus
//
////partie rose
//        JPanel panneau = new JPanel(); // equivalent HTML DIV
//        setContentPane(panneau); //partie rose où seront ajouté les composants
//
//        JButton bouton = new JButton("Click me 🙂"); //pour crée un bouton
//        panneau.add(bouton); // pour afficher le bouton
//
//        JCheckBox checkBox = new JCheckBox("Choose me !?"); //pour crée casse à cocher
//        panneau.add(checkBox); // pour afficher la fenetre
//
////toujours à la fin
//        setVisible(true);
//
//    }

//    public static void main(String[] args) {
//        new CasseBrique();
//    }
//}

//-------------------------------------------------------------------------------------------
