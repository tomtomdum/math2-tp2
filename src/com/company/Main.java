package com.company;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        System.out.println("***VERSION FINALE***");

        // Demande � l'utilisateur de saisir la matrice 1:
        System.out.println("Bienvenue");
        System.out.println("-----------------------------------------");
        System.out.println("Veuillez saisir votre premiere matrice:");
        System.out.print("Saisir le nombre de lignes de la premiere matrice: ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.print("Saisir le nombre de colonnes de la premiere matrice: ");
        int j = sc.nextInt();
        //Remplir la premiere matrice:

        double[][] matrice1 = new double[i][j];
        for (int a = 0; a< i; a++) {
            for (int b = 0; b < j; b++) {
                System.out.print(String.format("Rentrez le chiffre de votre choix à la position[%d][%d] : ", a+1, b+1));
                matrice1[a][b] = sc.nextInt();
            }
        }

        System.out.println();

        // Demande � l'utilisateur de saisir la matrice 2:
        System.out.println("-----------------------------------------");
        System.out.println("Veuillez saisir votre seconde matrice:");
        System.out.print("Saisir le nombre de lignes de la deuxieme matrice: ");

        int p = sc.nextInt();
        System.out.print("Saisir le nombre de colonnes de la deuxieme matrice: ");
        int m = sc.nextInt();

        //Remplir la seconde matrice:
        double[][] matrice2 = new double[p][m];
        for (int a = 0; a< p; a++) {
            for (int b = 0; b < m; b++) {
                System.out.print(String.format("Rentrez le chiffre de votre choix à la position[%d][%d] : ", a+1, b+1));
                matrice2[a][b] = sc.nextInt();
            }
        }
        System.out.println("----------------------------------------- \n\r");
        //affichage de la matrice 1
        Matrice matrice=new Matrice();
        Systeme systeme= new Systeme();
        System.out.println("matrice1: ");
        matrice.printMatrice(matrice1);
        //affichage de la matrice 2
        System.out.println("matrice2: ");
        matrice.printMatrice(matrice2);
        System.out.println("-----------------------------------------\n\r");
        // demande � l'utilisateur de modifier n �lements de la matrice de son choix
        System.out.println(">>>>>>>>>>>>>voulez vous modifier un element d'une matrices?\n\r 1:oui \n\r 2:non ");
        int r=sc.nextInt();
        while (r==1) {
            System.out.println("veuillez saisir le numero de la matrice sur laquelle vous voulez effectuer les modifications \n\r 1:matrice 1 \n\r 2:matrice 2");
            int rep=sc.nextInt();
            matrice.printMatrice(matriceChoisie(rep,matrice1,matrice2));
            matrice.modifierMatrice(matriceChoisie(rep,matrice1,matrice2));
            System.out.println("modification effectuee avec succes");
            System.out.println("voulez vous modifier un autre element d'une matrices?\n\r 1:oui \n\r 2:non ");
            r=sc.nextInt();
        }
        //on choisi la matrice sur laquelle on veut �ffectuer les op�rations
        //si l'utilsateur saisie  1:
        //le produit matriciel sera matrice1 x matrice2
        //si l'utilisateur saisie 2:
        //le produit matriciel sera matrice2 x matrice1
        System.out.println("-----------------------------------------\n\r");
        System.out.println("veuillez saisir le numero de la matrice sur laquelle vous voulez effectuer les operations \n\r 1:matrice 1 \n\r 2:matrice 2");
        int rep=sc.nextInt();
        //addition de la matrice 1 + matrice 2
        System.out.println(">>>>>>>>>>>>> addition de la matrice 1 + matrice 2:");
        matrice.printMatrice(matrice.additionnerMatrice(matrice1, matrice2));
        System.out.println("----------------------------------------- \n\r");
        // produit scalaire d'un entier ps x matrice de notre choix
        System.out.println(">>>>>>>>>>>>>produit scalaire:\n\r");
        System.out.println("saisir un nombre pour faire le produit scalaire :");
        int ps=sc.nextInt();
        matrice.printMatrice(matrice.FaireProduitScalaire(ps,matriceChoisie(rep,matrice1,matrice2)));
        System.out.println("----------------------------------------- \n\r");
        // calcul le produit matriciel entre les deux matrices ,attention!  le r�sultat d�pend de la matrice choisie pour �ffectuer les op�rations
        System.out.println(">>>>>>>>>>>>>produit matriciel");
        matrice.fairePlusieurProduitMatriciel(matriceChoisie(rep,matrice1,matrice2),matriceChoisie(rep,matrice2,matrice1));
        System.out.println("----------------------------------------- \n\r");
        //return true si la matrice choisie est carr�e
        System.out.println(">>>>>>>>>>>>>la matrice est carree? : \n\r "+matrice.estCarree(matriceChoisie(rep,matrice1,matrice2)));
        System.out.println("----------------------------------------- \n\r");
        System.out.println(">>>>>>>>>>>>>calculer trace: "+matrice.calculerTrace(matriceChoisie(rep,matrice1,matrice2)));
        System.out.println("----------------------------------------- \n\r");
        System.out.println(">>>>>>>>>>>>>determinant: ");
        System.out.println(matrice.determinant(matriceChoisie(rep,matrice1,matrice2),matriceChoisie(rep,matrice1,matrice2).length));
        System.out.println("----------------------------------------- \n\r");
        System.out.println(">>>>>>>>>>>>>matrice transposee:");
        matrice.printMatrice(matrice.transposerLaMatrice(matriceChoisie(rep,matrice1,matrice2)));
        System.out.println("----------------------------------------- \n\r");
        //l'utilisateur peut v�rifier si:
        //la matrice est triangulaire sup�rieur
        //la matrice est traingulaire inf�rieur
        //la matrice est triangulaire sup�rieur stricte
        //la matrice est triangulaire inf�rieur stricte
        System.out.println(">>>>>>>>>>>>>matrice triangulaire:");
        System.out.println("voulez vous verifier si la matrice est triangulaire supperieur ou inferrieur ?,");
        System.out.println("Saisir : \n\r 1: pour verifier si elle est triangulaire supperieur \n\r 2:  pour verifier si elle est triangulaire inferieur ");
        System.out.println(">>>");
        int choix1=sc.nextInt();
        if(choix1==1) {
            if (matrice.matriceTriangulaire(matriceChoisie(rep,matrice1,matrice2),1,0)) {
                System.out.println("Oui, la matrice est triangulaire superieur");
                System.out.println("voulez vous verifier si la matrice est triangulaire superieur STRICTE ? \n\r 1:oui \n\r 2:non");
                System.out.println(">>>");
                int choix2=sc.nextInt();
                if (choix2==1 && matrice.matriceTriangulaire(matriceChoisie(rep,matrice1,matrice2),1,1))
                    System.out.println("Oui,la matrice est triangulaire superieur stricte");
                else System.out.println("la matrice est trangulaire superieur mais non stricte");
            }
            else System.out.println("la matrice n'est pas triangulaire superieur");
        }
        if(choix1==2) {
            if (matrice.matriceTriangulaire(matriceChoisie(rep,matrice1,matrice2),2,0)) {
                System.out.println("Oui, la matrice est triangulaire inferieur");
                System.out.println("voulez vous verifier si la matrice est triangulaire inferieur STRICTE ? \n\r 1: oui \n\r 2:non");
                System.out.println(">>>");
                int choix2=sc.nextInt();
                if (choix2==1 && matrice.matriceTriangulaire(matriceChoisie(rep,matrice1,matrice2),2,1))
                    System.out.println("Oui,la matrice est triangulaire inferieur stricte");
                else System.out.println("la matrice est trangulaire inferieur mais non stricte");
            }
            else System.out.println("la matrice n'est pas triangulaire inferieur");
        }

        System.out.println("----------------------------------------- \n\r");
        System.out.println(">>>>>>>>>>>>>la comatrice: ");
        matrice.printMatrice(matrice.comatrice(matriceChoisie(rep,matrice1,matrice2)));
        System.out.println("----------------------------------------- \n\r");
        //retourne true si la matrice est r�guli�re
        System.out.println(">>>>>>>>>>>>>la matrice est reguliere:\n\r "+ matrice.estReguliere(matriceChoisie(rep,matrice1,matrice2)));
        System.out.println("----------------------------------------- \n\r");
        System.out.println(">>>>>>>>>>>>>la matrice inverse: ");
        matrice.printMatrice(matrice.matriceInverse(matriceChoisie(rep,matrice1,matrice2)));
        System.out.println("----------------------------------------------------------SYSTEMES D'EQUATIONS LINEAIRES-----------------------------------------------------------");
        System.out.println("veuillez saisir la matrice de "+matriceChoisie(rep,matrice1,matrice2).length +" lignes (matrice B)" );
        double[][] matrice3 = new double[matriceChoisie(rep,matrice1,matrice2).length][1];
        for (int a = 0; a< matriceChoisie(rep,matrice1,matrice2).length; a++) {

            System.out.print(String.format("Rentrez le chiffre de votre choix à la position[%d][%d] : ", a+1, 1));
            matrice3[a][0] = sc.nextInt();
        }
        System.out.println("Le systeme d'equations est le suivant:\n\r");
        System.out.println("_______________________________________________________");
        affichageSystem(matriceChoisie(rep,matrice1,matrice2),matrice3);
        System.out.println("_______________________________________________________");
        System.out.println("");
        System.out.println("trouvons X en appliquant differentes methodes:");

        System.out.println(">>>>>>>>>>>>>Cramer: ");
        systeme.trouverXParCramer(matriceChoisie(rep,matrice1,matrice2),matrice3);
        System.out.println("----------------------------------------- \n\r");

        System.out.println(">>>>>>>>>>>>>inversion matriciel:\n\r ");
        systeme.trouverXParInversionMatricielle(matriceChoisie(rep,matrice1,matrice2),matrice3);
        System.out.println(">>>>>>>>>>>>>Jacobi: \n\r");
        systeme.trouverXparJacobi(matriceChoisie(rep,matrice1,matrice2),matrice3,0.1);
        System.out.println("----------------------------------------- \n\r");

    }
    public static double[][] matriceChoisie(int x,double[][] matrice1, double[][] matrice2){
        if (x==1)
            return matrice1;
        if (x==2)
            return matrice2;


        return null;
    }
    public static void affichageSystem(double[][] matrice1, double[][] matrice2){
        String[] equationList = new String[matrice1.length];
        for (int i =0; i < matrice1.length; i++){
            equationList[i]="";
        }
        for(int i =0; i < matrice1.length; i++){

            for (int j =0; j < matrice1[0].length; j++){
                equationList[i]+= String.valueOf(matrice1[i][j]) + "x"+ String.valueOf(j+1)+" + ";
            }
        }

        for (int i =0; i < matrice1.length; i++){
            equationList[i] = equationList[i].substring(0, equationList[i].length()-2);
            equationList[i]+= "= " +String.valueOf(matrice2[i][0]);
        }
        for (int i =0; i < matrice1.length; i++){
            System.out.println(equationList[i]);
            System.out.println("");
        }

    }

}
