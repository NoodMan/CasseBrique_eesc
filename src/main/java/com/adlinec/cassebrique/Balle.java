package com.adlinec.cassebrique;

import java.awt.*;
import java.util.ArrayList;

public class Balle {

    // instance / création de la class Balle
    protected int x;
    protected int y;
    protected Color couleur;
    protected int vitesseHorizontal;
    protected int vitesseVertical;
    protected int diametre;
    protected int diametreReflet;
    protected int decalageReflet;

//pour la création des points
    protected Balle[] listePoints = new Balle[10];

    protected long indexFrame = 0;


    public Balle(int x, int y, Color couleur, int vitesseHorizontal, int vitesseVertical, int diametre) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
        this.vitesseHorizontal = vitesseHorizontal == 0 ? 1 : vitesseHorizontal;
        this.vitesseVertical = vitesseVertical == 0 ? 1 : vitesseVertical;
        this.setDiametre(diametre);
    }

//pour la creation des points derriere la balle
    public Balle(int x, int y) {
        this.x = x;
        this.y = y;
        this.couleur = Color.BLACK;
        this.setDiametre(5);
    }

    public void deplacer() {
        x += vitesseHorizontal;
        y += vitesseVertical;
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x, y, diametre, diametre);
        dessin.setColor(Color.WHITE);
        dessin.fillOval(
                x + decalageReflet,
                y + decalageReflet,
                diametreReflet,
                diametreReflet
        );
    }
//pour dessiner les points
//    public void dessinerPoints(Graphics2D dessin) {
//        indexFrame ++;
//
//        if(indexFrame % 10 == 0){
//            listePoints.add(new Balle(x, y));
//        }
//        for(Balle point : listePoints) {
//            point.dessiner(dessin);
//        }
//    }

// pour dessiner les points autre version
//    private int indexPoint = 0;
    public void dessinerPoints(Graphics2D dessin) {
        indexFrame++;

        if (indexFrame % 10 == 0) {

//            if(indexFrame > 100) {
//                listePoints.remove(listePoints.get(0));
//            }

            int indexPoint = (int)(indexFrame / 10) % 10;

            if (indexFrame <= 100) {
                listePoints[indexPoint] = new Balle(x, y);
            } else {
                listePoints[indexPoint].setX(x);
                listePoints[indexPoint].setY(y);
            }

//            indexPoint++;
//            if (indexPoint == 10) {
//                indexPoint = 0;
//            }
        }

        for (Balle point : listePoints) {
            if (point != null) {
                point.dessiner(dessin);
            }
        }
    }


    public void testCollision(int largeurEcran, int hauteurEcran) {

        if (x < 0 || x > largeurEcran - diametre) {
            inverseVitesseHorizontal();
        }

        if (y < 0 || y > hauteurEcran - diametre) {
            inverseVitesseVertical();
        }

    }

    ;

    public void inverseVitesseVertical() {
        vitesseVertical *= -1;
    }

    public void inverseVitesseHorizontal() {
        vitesseHorizontal *= -1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getVitesseHorizontal() {
        return vitesseHorizontal;
    }

    public void setVitesseHorizontal(int vitesseHorizontal) {
        this.vitesseHorizontal = vitesseHorizontal;
    }

    public int getVitesseVertical() {
        return vitesseVertical;
    }

    public void setVitesseVertical(int vitesseVertical) {
        this.vitesseVertical = vitesseVertical;
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
        this.diametreReflet = (int) (diametre * 0.3f);
        this.decalageReflet = (int) (diametre * 0.2f);
    }

    public int getDiametreReflet() {
        return diametreReflet;
    }

    public int getDecalageReflet() {
        return decalageReflet;
    }

}
