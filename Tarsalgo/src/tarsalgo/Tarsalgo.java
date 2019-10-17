package tarsalgo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Tarsalgo
{
  public static void main(String[] args)
  {
    // 1. feladat
    Ember[] emberek = null;
    
    try
    {
      RandomAccessFile raf = new RandomAccessFile("ajto.txt","r");
      String sor;
      int db = 0;
      for( sor = raf.readLine(); sor != null; sor = raf.readLine() )
      {
        db++;
      }
      
      emberek = new Ember[db];
      raf.seek(0);
      db = 0;
      for( sor = raf.readLine(); sor != null; sor = raf.readLine() )
      {
        emberek[db] = new Ember(sor.split(" "));
        db++;
      }
      raf.close();
    }
    catch( IOException e )
    {
      System.out.println("HIBA");
    }
    
//    for( Ember e : emberek )
//    {
//      System.out.println(e);
//    }

    // 2. feladat
    System.out.println("2. feladat");
    System.out.println("Az elso belepo: "+emberek[0].getAzon());
    
    int hely = -1;
    for( int i = emberek.length-1; i >= 0; i-- )
    {
      if( !emberek[i].isBe() )
      {
        hely = i;
      }
    }
    
    if( hely != -1 )
    {
      System.out.println("Az utolso kilepo: "+emberek[hely].getAzon());
    }
    else
    {
      System.out.println("Senki nem ment ki a tarsalgobol.");
    }
    
    // 3. feladat
    int max = 0;
    for( int i = 0; i < emberek.length; i++ )
    {
      if( emberek[i].getAzon() > max )
      {
        max = emberek[i].getAzon();
      }
    }

    int[] darabok = new int[max+1];
    
    for( int i = 0; i < emberek.length; i++ )
    {
      darabok[emberek[i].getAzon()]++;
    }
    
    try
    {
      RandomAccessFile ki = new RandomAccessFile("athaladas.txt","rw");
      for( int i = 1; i < darabok.length; i++ )
      {
        ki.writeBytes(i+" "+darabok[i]+"\n");
      }
      ki.close();
    }
    catch( IOException e )
    {
      System.out.println("HIBA");
    }
    
    // 4. feladat
    System.out.println("4. feladat");
    
    int[] bent = new int[max+1];
    
    for( int i = 0; i < emberek.length; i++ )
    {
      if( emberek[i].isBe() )
      {
        bent[emberek[i].getAzon()]++;
      }
      else
      {
        bent[emberek[i].getAzon()]--;
      }
    }
    System.out.print("A vegen a tarsalgoban voltak: ");
    for( int i = 1; i < bent.length; i++ )
    {
      if( bent[i] > 0 )
      {
        System.out.print(i+" ");
      }
    }
    System.out.println();

    // 5. feladat
    System.out.println("5. feladat");

    int[] bentvannak = new int[emberek.length];
    
    int elozo = 0;
    for( int i = 0; i < emberek.length; i++ )
    {
      if( emberek[i].isBe() )
      {
        bentvannak[i] = elozo + 1;
      }
      else
      {
        bentvannak[i] = elozo - 1;
      }
      elozo = bentvannak[i];
    }
    
    max = 0;
    for( int i = 1; i < bentvannak.length; i++ )
    {
      if( bentvannak[i] > bentvannak[max] )
      {
        max = i;
      }
    }
    
    System.out.println("Peldaul: "+emberek[max].getOra()+":"+
        emberek[max].getPerc()+"-kor voltak a legtobben a tarsalgoban.");
    
    // 6. feladat
    System.out.println("6. feladat");
    System.out.print("Adja meg egy szemely azonositojat: ");
    Scanner sc = new Scanner(System.in);
    int azon = Integer.parseInt(sc.nextLine());

    // 7. feladat
    System.out.println("7. feladat");
    for( int i = 0; i < emberek.length; i++ )
    {
      if( emberek[i].getAzon() == azon )
      {
        if( emberek[i].isBe() )
        {
          System.out.print(emberek[i].getOra()+":"+
            emberek[i].getPerc()+"-");
        }
        else
        {
          System.out.println(emberek[i].getOra()+":"+
            emberek[i].getPerc());
        }
      }
    }
    System.out.println();
    
    // 8. feladat
    System.out.println("8. feladat");
    
    int osszeg = 0;
    int be = 0;
    int ki = 0;
    boolean bentvan = false;
    for( int i = 0; i < emberek.length; i++ )
    {
      if( emberek[i].getAzon() == azon )
      {
        if( emberek[i].isBe() )
        {
          be = emberek[i].getOra()*60+emberek[i].getPerc();
          bentvan = true;
        }
        else
        {
          osszeg += (emberek[i].getOra()*60+emberek[i].getPerc()) - be;
          bentvan = false;
        }
      }
    }
    
    // ha a legvegen nem jott ki, akkor az utolso bemenetel
    // es a 15:00 kozotti idot hozzaadjuk az ossz idejehez
    if( bentvan )
    {
      osszeg += (15*60)-be;
    }
    
    System.out.print("A(z) "+azon+". szemely osszesen "+osszeg+
      " percet volt bent");
    
    if( bentvan )
    {
      System.out.println(", a megfigyeles vegen a tarsalgoban volt.");
    }
    else
    {
      System.out.println(".");
    }
  }
}
