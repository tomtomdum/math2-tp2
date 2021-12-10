package com.company;
import java.util.ArrayList;

public class Systeme {
    Matrice matrix= new Matrice();

    public void trouverXParCramer(double[][] matrice, double[][] matriceB){
        double [][]matriceTemp = new double[matrice.length][matrice.length];
        //utilis� pour copier la matrice dans matrice temp
        for(int i =0; i < matrice.length; i++){
            for (int j =0; j < matrice[0].length; j++){
                matriceTemp[i][j] = matrice[i][j];
            }
        }

        double detMatrice = matrix.determinant(matrice, matrice.length);
        double detMatriceTemp =0;
        ArrayList<Double> resultats = new ArrayList<Double>();
        for(int j =0; j<matrice.length; j++){
            for(int ii =0; ii < matrice.length; ii++){
                for (int jj =0; jj < matrice[0].length; jj++){
                    matriceTemp[ii][jj] = matrice[ii][jj];
                }
            }

            for (int i =0 ; i < matrice.length ; i++){
                matriceTemp[i][j] = matriceB[i][0];
            }
            detMatriceTemp = matrix.determinant(matriceTemp, matriceTemp.length);
            System.out.println((detMatriceTemp/detMatrice));
            resultats.add((detMatriceTemp/detMatrice));
        }
    }

    public void trouverXParInversionMatricielle(double[][] matrice, double[][] matriceB) {
        double[][] resultat = new double[matrice.length][0];
        matrice = matrix.matriceInverse(matrice);
        resultat = matrix.faireProduitMatriciel(matrice, matriceB);

        matrix.printMatrice(resultat);
    }
    // trouver x par jacobi

    public void trouverXparJacobi(double[][]matrice1 ,double[][] matrice2, double epsilon) {
        //est strictement dominante diagonalement? si non on ARRETE
        if (!matrix.estDominanteDiagonaleSuperieure(matrice1))
            System.err.println("impossible de calculer x par jacobi car la matrice n'est pas strictement dominante diagonalement");
        else {
        }
        double[][] d = matrix.diagonale(matrice1);
        double[][] l = matrix.triangulaireInf(matrice1);
        double[][] u = matrix.triangulaireSup(matrice1);
        double[][] lxu = matrix.additionnerMatrice(l,u);
        double[][] xKplusUn = new double[matrice1.length][1];
        double[][] xK = new double[matrice1.length][1];
        boolean condition = true;
        boolean condition2=true;
        while (condition) {
            condition=condition2;

            for (int i = 0;i < matrice1.length;i++) {
                double resultat = 0;

                for (int j = 0; j < matrice1.length;j++) {
                    resultat += xK[j][0] * lxu[i][j];
                }
                resultat = (matrice2[i][0] - resultat) / d[i][i];
                xKplusUn[i][0]= resultat;
                if (epsilon * -1 > resultat - xK[i][0] || resultat - xK[i][0] > epsilon) {
                    condition2 = false;
                }
            }
            xK =xKplusUn;
        }
        matrix.printMatrice(xKplusUn);

    }

}