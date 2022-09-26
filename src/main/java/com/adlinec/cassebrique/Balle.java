package com.adlinec.cassebrique;

import java.awt.*;

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


    public Balle(int x, int y, Color couleur, int vitesseHorizontal, int vitesseVertical, int diametre) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
        this.vitesseHorizontal = vitesseHorizontal;
        this.vitesseVertical = vitesseVertical;
        this.setDiametre(diametre);
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
        this.diametreReflet = (int)(diametre * 0.3f);
        this.decalageReflet = (int)(diametre * 0.2f);
    }

    public int getDiametreReflet() {
        return diametreReflet;
    }

    public int getDecalageReflet() {
        return decalageReflet;
    }

}
