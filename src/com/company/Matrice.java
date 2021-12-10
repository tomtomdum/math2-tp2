package com.company;

import java.util.Scanner;

public class Matrice {


    Scanner sc = new Scanner(System.in);

    //modification d'un �l�ment d'une matrice
    public void modifierMatrice(double[][] matrice) {

        System.out.println("saisir le numero de la ligne de l'element a modifier: ");
        int x = sc.nextInt() - 1;
        System.out.println("saisir le numero de la colonne de l'element a modifier: ");
        int y = sc.nextInt() - 1;
        System.out.println("saisir la nouvelle valeur");
        int val = sc.nextInt();
        matrice[x][y] = val;
    }

    //m�thode pour additionner la matrice matrice1+matrice2
    public double[][] additionnerMatrice(double[][] matrice1, double[][] matrice2) { // fonctionne
        double[][] matriceResultat = new double[matrice1.length][matrice1[0].length];
        if (matrice1.length == matrice2.length && matrice1[0].length == matrice2[0].length) { // les matrice qu'on additionne doivent avoir le meme format
            for (int i = 0; i < matrice1.length; i++) {
                for (int j = 0; j < matrice1[0].length; j++) {
                    matriceResultat[i][j] = matrice1[i][j] + matrice2[i][j];
                }

            }
            return matriceResultat;
        } else {
            System.out.println("Impossible d'effectuer l'operation, vos matrice n'ont pas le meme format");
            return null;
        }

    }

    //calculer produit scalaire
    public double[][] FaireProduitScalaire(double scalaire, double[][] matrice) {
        double[][] matriceResultat = new double[matrice.length][matrice[0].length];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                matriceResultat[i][j] = scalaire * matrice[i][j];
            }
        }
        return matriceResultat;
    }

    //Ici on reproduit les �tapes de multiplication que l'on ferait � la main
    //on commence par 1,1 * 1,1 + 1,2 * 2,1
    //ensuite         2,1 * 1,1 + 2,2 * 2,1
    //on se rend donc compte que il faut multiplier matrice1[i][k]*matrice2[k][j];
    public double[][] faireProduitMatriciel(double[][] matrice1, double[][] matrice2) {
        double[][] matriceResultat = new double[matrice1.length][matrice2[0].length]; // une multiplication donne la row de la premiere matrice et la colonne de la deuxieme
        if (matrice1[0].length == matrice2.length) { // les matrice qu'on additionne doivent avoir le meme format
            for (int i = 0; i < matrice1.length; i++) { // deplacement row matrice 1
                for (int j = 0; j < matrice2[0].length; j++) {// deplacement colonne matrice 2
                    for (int k = 0; k < matrice2.length; k++) { //on se rend donc compte que il faut multiplier matrice1[i][k]*matrice2[k][j];
                        matriceResultat[i][j] += matrice1[i][k] * matrice2[k][j];
                    }
                }
            }
            return matriceResultat;
        }
        return null;// matrices mauvais format
    }

    public void fairePlusieurProduitMatriciel(double[][] matrice1, double[][] matrice2) {
        double[][] matriceResultat = new double[matrice1.length][matrice2[0].length]; // une multiplication donne la row de la premiere matrice et la colonne de la deuxieme
        if (matrice1[0].length == matrice2.length) { // les matrice qu'on additionne doivent avoir le meme format
            for (int i = 0; i < matrice1.length; i++) { // deplacement row matrice 1
                for (int j = 0; j < matrice2[0].length; j++) {// deplacement colonne matrice 2
                    for (int k = 0; k < matrice2.length; k++) { //on se rend donc compte que il faut multiplier matrice1[i][k]*matrice2[k][j];
                        matriceResultat[i][j] += matrice1[i][k] * matrice2[k][j];
                    }
                }
            }
            printMatrice(matriceResultat);
            System.out.println("Voulez vous rajouter une matrice a multiplier? Tapez 1 pour oui ou et 2 pour non.");
            Scanner scan = new Scanner(System.in);
            int option;
            option = scan.nextInt();


            if (option == 1) {
                while (option == 1) {
                    System.out.println("Veuillez saisir votre matrice:");
                    System.out.print("Saisir le nombre de lignes de la matrice: ");
                    Scanner sc = new Scanner(System.in);
                    int i = sc.nextInt();
                    System.out.print("Saisir le nombre de colonnes de la matrice: ");
                    int j = sc.nextInt();

                    double[][] matrice3 = new double[i][j];
                    for (int a = 0; a < i; a++) {
                        for (int b = 0; b < j; b++) {
                            System.out.print(String.format("Rentrez le chiffre de votre choix a la position[%d][%d] : ", a + 1, b + 1));
                            matrice3[a][b] = sc.nextInt();
                        }
                    }
                    printMatrice(faireProduitMatriciel(matriceResultat, matrice3));
                    System.out.println("Voulez vous continuer? Tapez 1 pour oui et 2 pour non.");
                    option = scan.nextInt();
                    if (option == 2) {
                        option =2;
                        System.out.println("Au revoir");
                    }
                }
            }
        }
    }

    // cette m�thode on l'�x�cute � chaque fois qu'on veut afficher notre matrice
    public void printMatrice(double[][] matriceResultat) {

        for (int i = 0; i < matriceResultat.length; i++) {

            for (int j = 0; j < matriceResultat[0].length; j++) {
                System.out.print(matriceResultat[i][j] + "\t");
            }
            System.out.println();
        }

    }

    //la matrice est triangulaire?
    // retourne true si elle est triangulaire sup�rieur
    public Boolean estTriangulaireSupp(double[][] matrice) {
        for (int i = 1; i < matrice.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrice[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    // retourne true si elle est traingulaire inf�rieur
    public Boolean estTriangulaireInf(double[][] matrice) {
        for (int i = 0; i < matrice[0].length; i++) {
            for (int j = i + 1; j < matrice[0].length; j++) {
                if (matrice[i][j] != 0)
                    return false;
            }
        }
        return true;

    }

    // on utilise le r�sultat de la trace d'une matrice traiangulairte pour d�terminer si elle est stricte ou pas
    // on utilise Math.abs pour calculer  en utilisant la valeur absolue de chaque �l�ment,
    // notre fonction va retourner 0 si tout les �l�ments de la diagonale sont =0
    public double calculerTracePourTriangulaire(double[][] matrice) {
        double trace = 0;
        if (estCarree(matrice)) {
            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[0].length; j++) {
                    if (i == j) {
                        trace += Math.abs(matrice[i][j]);
                    }
                }
            }
            return trace;
        }
        return trace;
    }

    //retourner true si la matrice est triangulaire tout d�pend du choix de l'utilisateur
    public Boolean matriceTriangulaire(double[][] matrice, int choix1, int choix2) {
        if (estCarree(matrice)) {
            if (choix1 == 1 && choix2 == 0) {
                if (estTriangulaireSupp(matrice))
                    return true;
                else return false;
            }
            if (choix1 == 2 && choix2 == 0) {
                if (estTriangulaireInf(matrice))
                    return true;
                else return false;

            }
            if (choix1 == 1 && choix2 == 1) {
                if (estTriangulaireSupp(matrice) && calculerTracePourTriangulaire(matrice) == 0)
                    return true;
                else return false;
            }
            if (choix1 == 2 && choix2 == 1) {
                if (estTriangulaireInf(matrice) && calculerTracePourTriangulaire(matrice) == 0)
                    return true;
                else return false;

            }


        } else System.out.println("impossible de verifier car la matrice n'est pas carreee");
        return false;
    }

    // trace matrice
    public double calculerTrace(double[][] matrice) {
        double trace = 0;
        if (estCarree(matrice)) {
            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[0].length; j++) {
                    if (i == j) { // on veut que i == j (la diagonale)
                        trace += matrice[i][j];
                    }
                }
            }
            return trace;
        }
        return trace;
    }

    //matrice transpos�e
    public double[][] transposerLaMatrice(double[][] matrice) {
        double[][] matriceResultat = new double[matrice.length][matrice[0].length];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                matriceResultat[j][i] = matrice[i][j];
            }
        }
        return matriceResultat;
    }


    public boolean estCarree(double[][] matrice) {
        if (matrice[0].length == matrice.length) { // nombre row == nb colonnes
            return true;
        } else return false;
    }

    //cofacteur
    // on l'utilise pour calculer le det
    public void matriceCofacteur(double[][] matrice, double[][] cof, int ix, int iy, int n) {
        int i = 0, j = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (x != ix && y != iy) {
                    cof[i][j++] = matrice[x][y];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    // determinant
    public double determinant(double[][] matrice, int n) {
        double determinantDeLaMatrice = 0;
        double[][] cofacteurs = new double[matrice.length][matrice.length];
        double signe = 1;
        if (n == 1)
            return matrice[0][0];
        for (int i = 0; i < n; i++) {
            matriceCofacteur(matrice, cofacteurs, 0, i, n);
            determinantDeLaMatrice += signe * matrice[0][i] * determinant(cofacteurs, n - 1);
            signe = -signe;
        }
        return determinantDeLaMatrice;
    }

    //comatrice
    public double[][] comatrice(double[][] matrice) {
        double[][] comatrice = new double[matrice.length][matrice.length];
        double signe = 1;
        double[][] matriceTemp = new double[matrice.length][matrice.length];

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                matriceCofacteur(matrice, matriceTemp, i, j, matrice.length);
                if ((i + j) % 2 == 0)
                    signe = 1;
                else signe = -1;
                comatrice[j][i] = (signe) * (determinant(matriceTemp, matrice.length - 1));
            }
        }
        return comatrice;
    }

    public boolean estReguliere(double[][] matrice) {
        double det = determinant(matrice, matrice.length);
        if (det != 0) {
            return true;
        } else return false;
    }

    //matrice inverse
    public double[][] matriceInverse(double[][] matrice) {
        double[][] MatriceInverse = new double[0][];
        if (estReguliere(matrice)) {
            double determinantDeLaMatrice = determinant(matrice, matrice.length);
            MatriceInverse = new double[matrice.length][matrice.length];
            double[][] comatrice = new double[matrice.length][matrice.length];
            comatrice = comatrice(matrice);

            //on a inverse(A) = comatrice(A)/det(A)
            for (int i = 0; i < matrice.length; i++)
                for (int j = 0; j < matrice.length; j++)
                    MatriceInverse[i][j] = comatrice[i][j] / determinantDeLaMatrice;
        } else System.out.println("impossible de calculer car la matrice est singuliere ");
        return MatriceInverse;
    }

    // a utiliser pour faire la m�thode jacobi
    public double[][] diagonale(double[][] matrice) {
        double[][] diagonale = new double[matrice.length][matrice[0].length];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (i == j)
                    diagonale[i][j] = matrice[i][j];
                else
                    diagonale[i][j] = 0;
            }
        }
        return diagonale;
    }


    public double[][] triangulaireInf(double[][] matrice) {
        double[][] partieInferieure = new double[matrice.length][matrice[0].length];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (i > j)
                    partieInferieure[i][j] = matrice[i][j];
                else
                    partieInferieure[i][j] = 0;
            }
        }

        return partieInferieure;
    }

    public double[][] triangulaireSup(double[][] matrice) {
        double[][] partieSuperieure = new double[matrice.length][matrice[0].length];
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (i < j)
                    partieSuperieure[i][j] = matrice[i][j];
                else
                    partieSuperieure[i][j] = 0;
            }
        }

        return partieSuperieure;
    }

    public boolean estDominanteDiagonaleSuperieure(double[][] matrice) {

        double magnitude = 0;
        double somme = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                if (i == j) {
                    magnitude += Math.abs(matrice[i][j]);
                } else {
                    somme += Math.abs(matrice[i][j]);
                }
            }
        }

        return (magnitude > somme);
    }
}


