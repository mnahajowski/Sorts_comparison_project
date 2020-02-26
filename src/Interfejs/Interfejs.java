package Interfejs;

import java.util.Scanner;

import com.sun.org.apache.xpath.internal.axes.OneStepIterator;

import Sorts.*;

import java.util.Random;
import java.util.Arrays;
public class Interfejs {
	
	int []tab;
	private final int CYCLES = 101;
	
	//liczba cykli nie jest uzywana dla pojedynczego ciagu, jest istotna gdy ciagow jest 100, czyli przy czesci badawczej, dla czesci pokazowe mozna ja wykomentowac
	
	public Interfejs() {
		/*--------------------------------------------
		 * Dla czesci badawczej nastepne 4 linie kodu nalezy wykomentowac
		 * -------------------------------------------
		 */
		
		System.out.println("Witamy, prosze wybrac alogrytm sortowania \n");
		System.out.println("1.Quicksort");
		System.out.println("2.Shellsort");
		System.out.println("3.Merge Sort");
		this.starting();
	}
	public void starting() {
		
		/* -------------------------------------------------
		 * Dla czesci badawczej nastepne dwie linie kodu nalezy wykomentowac
		 * -------------------------------------------------
		 */
		
		Scanner scanner = new Scanner(System.in);
		int sc1 = scanner.nextInt();
		
		System.out.println("Proszę wybrać stopien poczatkowego posortowania ciagu");
		System.out.println("1.W pełni losowy \n2.Posortowany w 50% \n3.W pełni posortowany \n4.Posortowany odwrotnie\n");
		
		
		Scanner scanner2 = new Scanner(System.in);
		int sc2 = scanner2.nextInt();
		
		System.out.println("Prosze wybrac dlugosc ciagu tekstowego");
		System.out.println("1.100 tys \n2.500 tys \n3.1 mln \n4.2mln");
		
		Scanner scanner3 = new Scanner(System.in);
		int sc3 = scanner3.nextInt();
		
		/*  ---------------------------------------------
		 * Dwie kolejne struktury switch case sa istotne dla ciagu pokazowego, dla czesci badawczej nalezy je wykomentowac
		 * */
		switch(sc3) {
		
		case 1:
			random_ciag(100000);
			break;
		
		case 2:
			random_ciag(500000);
			break;
		
		case 3:
			random_ciag(1000000);
			break;

		case 4:
			random_ciag(2000000);
			break;
			
		default:
			random_ciag(100000);
			break;
		}
		
	//	show();
		
		// TO JEST DOBRZE DLA POJEDZYNCZEGO WYNIKU-----------------------------------------------
		
		switch(sc1) {
		
		case 1:
			qs_sort(sc2);
			break;
		case 2:
			shell_sort(sc2);
			break;
		case 3:
			merge_sort(sc2);
			break;
		default:
			qs_sort(sc2);
		}
		

		
		/*
		
			--------------------------------------------------------
			TA CZESC KODU PONIZEJ JEST UZYWAA TYLKO DLA CZESCI BADAWCZEJ, LICZBA CYKLI OKRESLA ILE ROZNYCH CIAGOW SORTUJEMY
			KAZDY CIAG JEST SORTOWANY NA 3 SPOSOBY, QUICKSORT, SHELLSORT, MERGESORT
			DLA CZESCI POKAZOWEJ PONIŻSZA PĘTLA FOR POWINNA BYC WYKOMENTOWANA
		
		*/
		/*
		for(int i = 0; i < CYCLES; i++) {
			switch(sc3) {
			
			case 1:
				random_ciag(100000);
				break;
			
			case 2:
				random_ciag(500000);
				break;
			
			case 3:
				random_ciag(1000000);
				break;

			case 4:
				random_ciag(2000000);
				break;
				
			default:
				random_ciag(100000);
				break;
			}
			*/
		/*
			qs_sort(sc2);
			shell_sort(sc2);
			merge_sort(sc2);
		*/
			
		//	qs_sort_pivoty(sc2);
			
		//	shell_sort_gaps(sc2);
	//		System.out.println();
	//	}
		

	}
	
	//generowanej randomowego ciagu liczbowego o zadanej dlugosci 
	public void random_ciag(int length) {
		
		Random gen = new Random();
		tab = new int[length];
		for(int i = 0; i < length; i++) {
			tab[i] = gen.nextInt(100000); 
		}
	}
	//first half domyslnie robiony w quicksorcie
	public void first_half_sort(int [] tab2) {
		
		qs_2 ob1 = new qs_2(false);
		ob1.halfSort(tab2);
	}
	//quicksort
	public void qs_sort(int sc2) {
		
	
		int [] temp = new int[tab.length];
		System.arraycopy(tab, 0, temp, 0, tab.length);
		double start, end;
		qs_2 ob1 = new qs_2(false);
		
		
	switch(sc2) {
	
			case 2:

				first_half_sort(temp);
				start = System.nanoTime();
				ob1.sort(temp);
				end = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				
				
				break;
			
			case 3:
				ob1.sort(temp);
				start = System.nanoTime();
				ob1.sort(temp);
				end = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				break;
				
				
				
			case 4:

				sort_odwrot(temp, 0, temp.length - 1);
				
				start = System.nanoTime();
				ob1.sort(temp);
				end = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				break;
				// w defaulcie jest dla wszystkich i dla 1, jest w pelni losowy
			default:

				
				start = System.nanoTime();
				ob1.sort(temp);
				end = System.nanoTime();
				System.out.print((end -start)/1000000 + " ");
				break;
				
			}
	//System.out.println(test(temp));
		}
	
	public void qs_sort_pivoty(int sc2) {
		int [] temp = new int[tab.length];
		System.arraycopy(tab, 0, temp, 0, tab.length);
		int [] temp2 = new int[tab.length];
		System.arraycopy(tab, 0, temp2, 0, tab.length);
		
		double start1, end1, start2, end2;
		qs_2 ob = new qs_2(false);
		qs_2 ob2 = new qs_2(true);
		
		
		switch(sc2) {
		
		case 2:
			first_half_sort(temp);
			first_half_sort(temp2);
			start1 = System.nanoTime();
			ob.sort(temp);
			end1 = System.nanoTime();
			start2 = System.nanoTime();
			ob2.sort(temp2);
			end2 = System.nanoTime();
			
			System.out.print((end1 -start1)/1000000+ " ");
			System.out.print((end2 -start2)/1000000+ " ");
			
			break;
		
		case 3:
			ob.sort(temp);
			ob.sort(temp2);
			start1 = System.nanoTime();
			ob.sort(temp);
			end1 = System.nanoTime();
			start2 = System.nanoTime();
			ob2.sort(temp2);
			end2 = System.nanoTime();		
			
			System.out.print((end1 -start1)/1000000+ " ");
			System.out.print((end2 -start2)/1000000 + " ");
			break;
			
			
			
		case 4:
			sort_odwrot(temp, 0, temp.length - 1);
			sort_odwrot(temp2, 0, temp2.length - 1);
			
			
			start1 = System.nanoTime();
			ob.sort(temp);
			end1 = System.nanoTime();
			start2 = System.nanoTime();
			ob2.sort(temp2);
			end2 = System.nanoTime();
			
			
			System.out.print((end1 -start1)/1000000 + " ");
			System.out.print((end2 -start2)/1000000+ " ");

			break;
			// w defaulcie jest dla wszystkich i dla 1, jest w pelni losowy
		default:
			start1 = System.nanoTime();
			ob.sort(temp);
			end1 = System.nanoTime();
			start2 = System.nanoTime();
			ob2.sort(temp2);
			end2 = System.nanoTime();
			
			System.out.print((end1 -start1)/1000000 + " ");
			System.out.print((end2 -start2)/1000000+ " ");

			break;
			
		}
	}
	
	//shell sort
	public void shell_sort_gaps(int sc2) {

		
		int [] temp = new int[tab.length];
		System.arraycopy(tab, 0, temp, 0, tab.length);
		int [] temp2 = new int[tab.length];
		System.arraycopy(tab, 0, temp2, 0, tab.length);
		int [] temp3 = new int[tab.length];
		System.arraycopy(tab, 0, temp3, 0, tab.length);
		double start, end, start2, end2, start3, end3;
		Shells ob = new Shells();
	switch(sc2) {
			case 2:
				first_half_sort(temp);
				
				start = System.nanoTime();
				ob.sort(temp); 
				end = System.nanoTime();
				start2 = System.nanoTime();
				ob.sort2(temp2);
				end2 = System.nanoTime();
				start3 = System.nanoTime();
				ob.sort3(temp3);
				end3 = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				System.out.print((end2 -start2)/1000000+ " ");
				System.out.print((end3 -start3)/1000000+ " ");
				break;
			
			case 3:
				ob.sort(temp);
				ob.sort(temp2);
				ob.sort(temp3);

				start = System.nanoTime();
				ob.sort(temp); 
				end = System.nanoTime();
				start2 = System.nanoTime();
				ob.sort2(temp2);
				end2 = System.nanoTime();
				start3 = System.nanoTime();
				ob.sort3(temp3);
				end3 = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				System.out.print((end2 -start2)/1000000+ " ");
				System.out.print((end3 -start3)/1000000 + " ");
				break;
				
			case 4:
				sort_odwrot(temp, 0, temp.length - 1);
				sort_odwrot(temp2, 0, temp2.length - 1);
				sort_odwrot(temp3, 0, temp3.length - 1);
				
				
				start = System.nanoTime();
				ob.sort(temp);
				end = System.nanoTime();
				start2 = System.nanoTime();
				ob.sort2(temp2);
				end2 = System.nanoTime();
				start3 = System.nanoTime();
				ob.sort3(temp3);
				end3 = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				System.out.print((end2 -start2)/1000000+ " ");
				System.out.print((end3 -start3)/1000000+ " ");
				break;
				// w deafulcie jest dla 1 i dla wszystkich zupelnie losowy
			default:
				start = System.nanoTime();
				ob.sort(temp);
				end = System.nanoTime();
				start2 = System.nanoTime();
				ob.sort2(temp2);
				end2 = System.nanoTime();
				start3 = System.nanoTime();
				ob.sort3(temp3);
				end3 = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				System.out.print((end2 -start2)/1000000+ " ");
				System.out.print((end3 -start3)/1000000+ " ");
				break;
			}
		}

	public void shell_sort(int sc2) {
		int [] temp = new int[tab.length];
		System.arraycopy(tab, 0, temp, 0, tab.length);
		double start, end;
		Shells ob = new Shells();
	switch(sc2) {
			case 2:
				first_half_sort(temp);
				start = System.nanoTime();
				ob.sort(temp);
				end = System.nanoTime();
				System.out.print((end -start)/1000000 + " ");
				break;
			
			case 3:
				ob.sort(temp);
				start = System.nanoTime();
				ob.sort(temp);
				end = System.nanoTime();
				System.out.print((end - start)/1000000+ " ");
				break;
				
			case 4:
				sort_odwrot(temp, 0, temp.length - 1);
				start = System.nanoTime();
				ob.sort(temp);
				end = System.nanoTime();
				System.out.print((end - start)/1000000 + " ");
				break;
				// w deafulcie jest dla 1 i dla wszystkich zupelnie losowy
			default:
				start = System.nanoTime();
				ob.sort(temp);
				end = System.nanoTime();
				System.out.print((end - start)/1000000 + " ");
				break;
			}
	}
	
// merge sort
	public void merge_sort(int sc2) {

		
		int [] temp = new int[tab.length];
		System.arraycopy(tab, 0, temp, 0, tab.length);
		double start, end;
		MergeSort ob = new MergeSort();
	switch(sc2) {
			
			case 2:
				first_half_sort(temp);

				start = System.nanoTime();
				ob.sort(tab, 0, temp.length - 1);
				end = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				break;
			
			case 3:
				ob.sort(temp, 0, temp.length - 1);
				start = System.nanoTime();
				ob.sort(temp, 0, temp.length-1);
				end = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				break;
				
			case 4:
				sort_odwrot(temp, 0, temp.length - 1);
				start = System.nanoTime();
				ob.sort(temp, 0, temp.length - 1);
				end = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				break;
				//w defaulcie i w 1 jest w pelni losowy
			default:
				start = System.nanoTime();
				ob.sort(temp, 0, temp.length - 1);
	//			ob.sort(tab, left, right);
				end = System.nanoTime();
				System.out.print((end -start)/1000000+ " ");
				break;
			}
		}

//sortowanie odwrotne (oparte na quicksorcie)
		public void sort_odwrot(int tab2[], int left, int right) {
			int i = left;
			int j = right;
			int pivot = tab2[(left+right)/2];
			
			do {
				while(tab2[i] > pivot)
					i++;
				while(tab2[j] < pivot)
					j--;
				if(i <=j) {
					int temp = tab2[i];
					tab2[i]= tab2[j];
					tab2[j]= temp;
					i++;
					j--;
					
				}
			}while(i <=j);
			
			if(left < j) sort_odwrot(tab2, left, j);
			if(right > i) sort_odwrot(tab2, i, right);
		}
	
	/*
	 * METODA WYSWIETLAJACA TABLICE (TESTUJACA)
	 */
	public void show(int [] tab) {
		for(int i = 0; i < tab.length; i++) {
			System.out.println(tab[i] + " " + i);
			
		}
	}
	
	/*
	 * FUNKCJA TESTUJACA CZY ELEMENT JEST WIEKSZY OD SWOJEGO POPRZEDNIKA
	 */
	
	public boolean test(int [] tab) {
		for(int i = 1; i < tab.length; i++) {
			if(tab[i] < tab[i-1])
				return false;
		}
	return true;
	}
	
	
}
