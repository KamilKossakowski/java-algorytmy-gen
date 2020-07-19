package rat2;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
 class al
{	static Scanner odczyt = new Scanner(System.in); 
	static Random rand = new Random();
	static int ilx[][];//a|b|d|m
	static int tab[][];
	static int tab1[][];
	static int tao[][];
	static double tab2[][];
	static double fu[];
	static int licz_os,xn,m=0;
	static void t_t_arg_fun () throws IOException 
			{   System.out.println("Podaj iloœæ chromosomów");
				licz_os=odczyt.nextInt();
				System.out.println("Podaj iloœæ argumentów w funkcji");
			    xn=odczyt.nextInt();
				al.ilx=new int[xn][4];
				for(int i=0;i<xn;i++)
					{
					System.out.println("Podaj przedzia³ w jakim poszukujesz x"+(i+1));
					System.out.println("(a,b)"+"\n"+" a=");
					ilx[i][0]=odczyt.nextInt();
					System.out.println("b=");
					ilx[i][1]=odczyt.nextInt();
					System.out.println("Podaj dok³adnoœæ z jak¹ poszukujesz x"+(i+1));
					ilx[i][2]=odczyt.nextInt();
					ilx[i][3]=al.dwekbin(i,ilx[i][2]);
					}
					
					
			}
	static int dwekbin(int i,int d)
			{	int m=0;
				int b=ilx[i][1];
				int a=ilx[i][0];
		  		double abs=(b-a)*Math.pow(10,d);
				while (abs>=Math.pow(2,m)) {m++;}
				return m;
			}
	static void losuj2 ()
	{		
			for(int k=0;k<(xn);k++) 
			
			{   m+=ilx[k][3];}
				al.tab= new int[licz_os][m];
				al.tao= new int[licz_os][m];
				for(int i=0;i<(licz_os);i++) 
				   {
					for(int j=0;j<(m);j++) 
						{
						tab[i][j]=rand.nextInt(2);
						}
					}	
				for(int i=0;i<(licz_os);i++) 
				   {
					for(int j=0;j<(m);j++) 
						{
						tao[i][j]=tab[i][j];
						}
					}
	}
		static void tran2do10() 
	{	al.tab1=new int[xn][licz_os];
		
		for(int i=0;i<(licz_os);i++)
			{int ol = 0;
			for(int k=0;k<xn;k++) 
				{
				int j=0;
					int h=ilx[k][3]-1;
					for(j=ol;j<(m);j++) 
						{	
							tab1[k][i]+=tab[i][j]*Math.pow(2,h);
							h--;
							if (h<0) 
							{
								ol=j;
								j=99999;
							}
						}
				}
					
				}
			}
	
	static void standar()
	{
		al.tab2= new double[xn][licz_os];
		for(int i=0;i<(licz_os);i++) 
		   {
				for(int k=0;k<(xn);k++) {
		   
						tab2[k][i]=(double)ilx[k][0]+(((ilx[k][1]-ilx[k][0])*tab1[k][i])/(Math.pow(2,ilx[k][3])-1));
						
				}
		   }
	}
	static void funk() 
		{
		al.fu= new double[licz_os];
		int an=10*xn;
		for(int i=0;i<(licz_os);i++) 
		   {
			for(int k=0;k<(xn);k++) 
				{
				fu[i]+=tab2[k][i]*tab2[k][i]-10*Math.cos(20*Math.PI*tab2[k][i]);
				}
			fu[i]+=an;
			System.out.println("F"+i+"(x...x)="+fu[i]+"\n");
		   }
		}
	static void wloncz() 
		{
		al.tran2do10();
		al.standar();
		al.funk();
		}
}
 class reprod
 {
	 static Scanner odczyt = new Scanner(System.in);
	 static Random rand = new Random();
		static int g;
	 static double wyg[];
	 static double wyf[][];
	 static double winra[];
	 static double winran[];
	 static double winr[];
	 static double winrmin[];
	 static double wintubez[];
	 static double wintuzz[];
	 static int licz_os_r;
	 static double r;
	 static void wybiesznafirst() 
	 {	 System.out.println("Wybie¿ metodê wyboru kolejnego osobnika do reprodukcji");
		 System.out.println("1.metoda maximum ruletka");
		 System.out.println("2.metoda minimum ruletka");
		 System.out.println("3.metoda maximum rankingowa");
		 System.out.println("4.metoda minimum rankingowa");
		 System.out.println("5.metoda maximum turniejowa bezzwracania");
		 System.out.println("6.metoda minimum turniejowa bezzwracania");
		 System.out.println("7.metoda maximum turniejowa ze zwracaniem");
		 System.out.println("8.metoda minimum turniejowa ze zwracaniem");
		 System.out.println("podaj numer metody");
		 g=odczyt.nextInt();
	 }
	 static void wybierz() 
	 {		
		 reprod.przepisz();
		 switch (reprod.g) 
		 {
		    case 1:reprod.rulet();break;
		    case 2:reprod.ruletmin();break;
		    case 3:reprod.ranki();break;
		    case 4:reprod.rankimin();break;
		    case 5:reprod.turniejbez(0);break;
		    case 6:reprod.turniejbez(1);break;
		    case 7:reprod.turniejzz(0);break;
		    case 8:reprod.turniejzz(1);break;
		 }
	 }
	 static void przepisz()
 		{
 		reprod.licz_os_r=al.licz_os;
 		reprod.wyf= new double[licz_os_r][licz_os_r];
 		reprod.wyg= new double[licz_os_r];
 		for(int i=0;i<(licz_os_r);i++) 
		   {
 			if(al.fu[i]>0) 
 			{   wyf[i][1]=i;
 				wyf[i][0]=al.fu[i];
 			}
		   if(al.fu[i]<0)
		   {
			   wyf[i][0]=0;
			   wyf[i][1]=i;  
		   }
		   
		   }
 		
 		}
	 static void ruletmin()
		{
		double p_i[][]=new double[licz_os_r][licz_os_r];
		double g_i[][]=new double[licz_os_r][licz_os_r];
		reprod.winrmin=new double[licz_os_r];
		int dopasowanie=0;
		int gp=0;
		for(int i=0;i<(licz_os_r);i++) 
		   {
		   dopasowanie+=reprod.wyf[i][0];
		   }
		
		for(int i=0;i<(licz_os_r);i++) 
		   {
		   p_i[i][0]=(wyf[i][0]/dopasowanie);
		   p_i[i][0]=(1-p_i[i][0])/(licz_os_r-1);
		   p_i[i][1]=wyf[i][1];
		   
		   }
		for(int i=0;i<licz_os_r;i++) 
			{
			gp=i;
			for(int j=0;j<gp;j++) 
				{
				g_i[i][0]+=p_i[j][0];
				}
			g_i[i][1]=p_i[i][1];
			}
		for(int i=0;i<(licz_os_r);i++)
			{
			r=rand.nextInt(101);
			for(int j=0;j<(licz_os_r);j++)
				{
				if((r/100)>g_i[j][0]) 
					{
					winrmin[i]=g_i[j][1];
					reprod.wyg[i]=winrmin[i];
					}
				}
			}
			
		}
	 static void rulet()
 		{
 		double p_i[][]=new double[licz_os_r][licz_os_r];
 		double g_i[][]=new double[licz_os_r][licz_os_r];
 		reprod.winr=new double[licz_os_r];
 		int dopasowanie=0;
 		int gp=0;
 		for(int i=0;i<(licz_os_r);i++) 
		   {
		   dopasowanie+=reprod.wyf[i][0];
		   }
 		
 		for(int i=0;i<(licz_os_r);i++) 
		   {
		   p_i[i][0]=wyf[i][0]/dopasowanie;
		   p_i[i][1]=wyf[i][1];
		   
		   }
 		for(int i=0;i<licz_os_r;i++) 
 			{
 			gp=i;
 			for(int j=0;j<gp;j++) 
 				{
 				g_i[i][0]+=p_i[j][0];
 				
 				}
 			g_i[i][1]=p_i[i][1];
 			
 			}
 		for(int i=0;i<(licz_os_r);i++)
 			{
 			r=rand.nextInt(101);
 			for(int j=0;j<(licz_os_r);j++)
 				{
 				if((r/100)>g_i[j][0]) 
 					{
 					winr[i]=g_i[j][1];
 					reprod.wyg[i]=winr[i];
 					}
 				}
 				
 			}
 			
 		}
	 static void ranki() 
	 	{
		 reprod.winra=new double[licz_os_r];
		 double wyf1[][]= new double[licz_os_r][licz_os_r];
		 int h[]=new int[licz_os_r];
		 	double temp;
		 	for(int i=0; i<licz_os_r; i++)
				{
		 		wyf1[i][0]=wyf[i][0];
				wyf1[i][1]=wyf[i][1];
				}
	 		for(int j=0; j<licz_os_r;j++)
	 			{
	 			
	 			for(int i=0; i<licz_os_r-1; i++)
	 				{
	 					if(wyf1[i][0]>wyf1[i+1][0])
	 						{
	 						temp = wyf1[i+1][0];
	 						wyf1[i+1][0] = wyf1[i][0];
	 						wyf1[i][0]= temp;
	 						temp = wyf1[i+1][1];
	 						wyf1[i+1][1] = wyf1[i][1];
	 						wyf1[i][1]= temp;
	 						}
	 				}
	 			}
	 		for(int i=0;i<licz_os_r;i++) 
				{
	 			h[i]=rand.nextInt(licz_os_r);
	 			
				}
	 		for(int i=0;i<licz_os_r;i++) 
				{int g;
	 			g=rand.nextInt(h[i]+1);
	 			winra[i]=wyf1[g][1];
	 			reprod.wyg[i]=winra[i];
				}
	 	}
	 static void rankimin() 
	 	{
		 reprod.winran=new double[licz_os_r];
		 double wyf1[][]= new double[licz_os_r][licz_os_r];
		 int h[]=new int[licz_os_r];
		 	double temp;
		 	for(int i=0; i<licz_os_r; i++)
				{
		 		wyf1[i][0]=wyf[i][0];
				wyf1[i][1]=wyf[i][1];
				}
	 		for(int j=0; j<licz_os_r;j++)
	 			{
	 			
	 			for(int i=0; i<licz_os_r-1; i++)
	 				{
	 					if(wyf1[i][0]<wyf1[i+1][0])
	 						{
	 						temp = wyf1[i+1][0];
	 						wyf1[i+1][0] = wyf1[i][0];
	 						wyf1[i][0]= temp;
	 						temp = wyf1[i+1][1];
	 						wyf1[i+1][1] = wyf1[i][1];
	 						wyf1[i][1]= temp;
	 						}
	 				}
	 			}
	 		for(int i=0;i<licz_os_r;i++) 
 				{
	 			h[i]=rand.nextInt(licz_os_r);
	 			
 				}
	 		for(int i=0;i<licz_os_r;i++) 
 				{int g;
	 			g=rand.nextInt(h[i]+1);
	 			winran[i]=wyf1[g][1];
	 			reprod.wyg[i]=winran[i];
	 		
 				}
	 	}
	 static void turniejbez(int y)
	 	{
		 reprod.wintubez=new double[licz_os_r];
		 double h[][]=new double[3][2];
		 int t[]=new int[licz_os_r];
		 int b[]=new int[3];
		 int n=0;
		
		 for(int i=0;i<licz_os_r;i++) 
			{
			 for(int ko=0;ko<licz_os_r;ko++) 
				{t[ko]=ko;}
			 for(int j=0;j<3;j++) 
			 	{
				 n=rand.nextInt(licz_os_r);
				 if(t[n]<0) {j--;}
				 else {b[j]=t[n];t[n]=-1;} 
			 	}
			 for(int j=0;j<3;j++) 
			 	{
				 h[j][0]=wyf[b[j]][0];
				 h[j][1]=wyf[b[j]][1];
			 	}
			 	double temp;
			 	for(int j=0; j<3;j++)
			 	{
		 			for(int s=0; s<2;s++)
		 				{
		 					if(h[s][0]<h[s+1][0])
		 						{
		 						temp = h[s+1][0];
		 						h[s+1][0] = h[s][0];
		 						h[s][0]= temp;
		 						temp = h[s+1][1];
		 						h[s+1][1] =h[s][1];
		 						h[s][1]= temp;
		 						
		 						}
		 				}
		 			}
		 		wintubez[i]=h[0][1];
		 		if(y==0) 
		 		{
		 			reprod.wyg[i]=wintubez[i];
		 		}
		 		if(y==1) 
		 		{
		 			reprod.wyg[i]=h[2][1];
		 		}
		 	
			}	
	 	}
	 static void turniejzz(int y)
	 	{
		 reprod.wintuzz=new double[licz_os_r];
		 int b[]=new int[3];
		 double h[][]=new double[3][2];
		 for(int i=0;i<licz_os_r;i++) 
			{
			 	for(int j=1;j<3;j++) 
			 	{
			 		b[j]=rand.nextInt(licz_os_r);
			 	}
			 	for(int j=1;j<3;j++) 
			 	{
			 		h[j][0]=wyf[b[j]][0];
			 		h[j][1]=wyf[b[j]][1];
			 	}
			 	double temp;
			 	for(int g=0; g<2;g++)
			 		{
		 			for(int s=0; s<3;s++)
		 				{
		 					if(h[g][0]<h[g+1][0])
		 						{
		 						temp = h[g+1][0];
		 						h[g+1][0] = h[g][0];
		 						h[g][0]= temp;
		 						temp = h[g+1][1];
		 						h[g+1][1] =h[g][1];
		 						h[g][1]= temp;
		 						
		 						}
		 				}
		 			}
			 	if(y==0) 
		 		{
		 			reprod.wyg[i]=h[0][1];
		 		}
		 		if(y==1) 
		 		{
		 			reprod.wyg[i]=h[2][1];
		 		}
		 		wintuzz[i]=h[0][1];
		 		

			}
		 
	 	}
 }
 class opereta
 {
	 static Random rand = new Random();
	 static Scanner odczyt = new Scanner(System.in); 
	 static double pn;
	 static int holow;
	 static int licz_os_op=al.licz_os;
	 static int tam[][]=new int[al.licz_os][al.m];
	 static int r[]=new int[al.m];
	 static int typow[][]=new int[al.licz_os][al.m];
	 static void mutlubinwer() 
	 	{
		 for(int i=0;i<(al.licz_os);i++) 
		   {
			for(int j=0;j<(al.m);j++) 
				{
				opereta.tam[i][j]=al.tab[(int) reprod.wyg[i]][j];
				}
		   }
	 	}
static void mutacja() 
	 		{
	int hal;
		holow=0;
			
		 			for(int i=0;i<al.licz_os;i++) 
		 			{
		 				for(int j=0;j<al.m;j++) 
			 			{
		 					r[j]=rand.nextInt(101);
		 					
			 			}
		 				for(int j=0;j<al.m;j++) 
			 			{
		 				if(r[j]<pn) {holow++;j=j+al.m;
		 				}
			 			}
		 				hal=holow;
			 		for(int j=0;j<al.m;j++) 
			 			{
			 			
			 			if(r[j]<pn&&holow>0) 
			 				{
			 				typow[holow-1][j]=al.tab[(int) reprod.wyg[i]][j];
			 					if(al.tab[(int) reprod.wyg[i]][j]==1) 
			 					{
			 						tam[i][j]=0;
			 						typow[holow-1][j]=0;
			 					}
			 					if(al.tab[(int) reprod.wyg[i]][j]==0) 
			 					{
			 					tam[i][j]=1;
			 					typow[holow-1][j]=1;
			 					}
			 				
			 				}
			 			}holow=hal;
		 			}
		 		
	 			}
static void inwersja() 
	 	{
				holow=0;
			 for(int i=0;i<al.licz_os;i++) 
	 			{
				 
				 int r=rand.nextInt(101);
		 			if(r<pn)
		 			{   
		 				for(int j=0;j<al.m;j++) 
				 		{		
				 			opereta.typow[holow][j]=al.tab[(int) reprod.wyg[i]][j];
				 		}
		 				int pi=rand.nextInt(al.m-1);
		 				int ki=rand.nextInt(al.m-1);
		 				if(pi>ki) 
		 				{
		 					int tep=pi;
		 					pi=ki;
		 					ki=tep;
		 				}
		 				int tymcz[]=new int[ki-pi+1];
		 				int p=0;
		 				for(int j=pi;j<ki+1;j++) 
			 			{
		 					tymcz[p]=al.tab[(int) reprod.wyg[i]][j];
		 					p++;
			 			}
		 				p--;
		 				for(int j=pi;j<ki+1;j++) 
			 			{
		 					opereta.typow[holow][j]=tymcz[p];
		 					tam[i][j]=tymcz[p];
		 					p--;
			 			}
			 			holow++;
		 			}

	 			}
			 
			 
	 	}
 static void krzyzowankowielo() 
 {	holow=0;
	 int b[]=new int[al.licz_os];//prawdopodobienstwo dla osobnikow
	 int b1[]=new int[al.licz_os];//czy krzyzowanko?
	 
	 int ij=0;//iloœæ osobników krzy¿owanych
	 for(int i=0;i<al.licz_os;i++) 
	 {
		 b[i]=rand.nextInt(101);
		 b1[i]=0;
		 if(b[i]<pn) 
		 {
			ij++; 
			b1[i]=1;
		 }
	 }
	 
	 if(Math.floorMod(ij, 2)!=0 && ij!=0) 
	 {
		 if(ij>al.licz_os/2||ij==al.licz_os) 
		 {
			ij--;
			for(int t=0;t>0;t++) 
			{
				int j=rand.nextInt(al.licz_os+1);
				if(b1[j]==1) 
				{
					b1[j]=0;
					t=-2;
				}
			}
		}else 
		{
			ij++;
			for(int t=0;t>0;t++) 
			{
				int j=rand.nextInt(al.licz_os+1);
				if(b1[j]==0) 
				{
					b1[j]=1;
					t=-2;
				}
			}
		}
	 }
	 int kl=0;int[][] b2=new int[ij+1][2];
	 for(int i=0;i<al.licz_os;i++) 
	 {
		if(b1[i]==1) 
		{
			b2[kl][0]=i;
			b2[kl][1]=rand.nextInt(1001);
			kl++;
		}
	 }
	 kl--;
	int temp;
	 for(int j=0; j<kl;j++)
	 	{
			for(int s=0; s<kl-1;s++)
				{
					if(b2[s][1]<b2[s+1][1])
						{
						temp = b2[s+1][0];
						b2[s+1][0] = b2[s][0];
						b2[s][0]= temp;
						temp = b2[s+1][1];
						b2[s+1][1] =b2[s][1];
						b2[s][1]= temp;
						
						}
				}
			} //losowe przetasowanie urzytkownikow
	 
	 int gw=rand.nextInt(al.m);//ilosc zmian
	 gw++;
	//tabela lokalizacji zmian
	 int t[]=new int[gw];
	 int sp;
	 for(int j=0;j<gw;j++) 
		 	{
		 	sp=j;
			 t[j]=rand.nextInt(al.m);
			 if(sp!=0) 
			 {
			 for(int i=0;i<sp-1;i++)
				 if(t[j]==t[i]) 
				 {
					i=j;
					j--;
					
				 }	 
		 	}
			 }

	 for(int i=0;i<gw;i++) 
	 	{
		 for(int j=0;j<gw-1;j++) 
	 			{if(t[j]>t[j+1]) {
	 				temp =  t[j+1];
	 				 t[j+1] = t[j];
	 				 t[j]= temp;
	 			}
	 			}
	 			}
	 int trzon=0;
	 int kto=1;
	 for(int i=0;i<kl/2;i=i+2) 
		 {
			 for(int j=0;j<al.m;j++) 
			 {
				 if(trzon<gw) {
					 if(t[trzon]==j) {
						 trzon++;	 
					 kto*=-1;
					  }}
				 if(kto==1) {
					 opereta.tam[b2[i][0]][j]=   al.tab[(int) reprod.wyg[b2[i][0]]][j];
					 opereta.tam[b2[i+1][0]][j]= al.tab[(int) reprod.wyg[b2[i+1][0]]][j];
				 }
				 if(kto==-1) {
					 opereta.tam[b2[i][0]][j]= al.tab[(int) reprod.wyg[b2[i+1][0]]][j];  
					 opereta.tam[b2[i+1][0]][j]= al.tab[(int) reprod.wyg[b2[i][0]]][j];
				 }
			 } 
			 kto=1;trzon=0; 
		 }
	 for(int i=0;i<kl/2;i=i+2) 
	 {
		 for(int j=0;j<al.m;j++) 
		 {
			 opereta.typow[holow][j]=opereta.tam[b2[i][0]][j];
			 opereta.typow[holow+1][j]=opereta.tam[b2[i+1][0]][j];
		 }
		 holow=holow+2;
	 }
 }
 static void krzyzowankonogi() 
 {
	 int b[]=new int[al.licz_os];//prawdopodobienstwo dla osobnikow
	 int b1[]=new int[al.licz_os];//czy krzyzowanko?
	 int ij=0;//iloœæ osobników krzy¿owanych
	 for(int i=0;i<al.licz_os;i++) 
	 {
		 b[i]=rand.nextInt(101);
		 b1[i]=0;
		 if(b[i]<pn) 
		 {
			ij++; 
			b1[i]=1;
		 }
	 }
	 
	 if(Math.floorMod(ij, 2)!=0 && ij!=0) 
	 {
		 if(ij>al.licz_os/2||ij==al.licz_os) 
		 {
			ij--;
			for(int t=0;t>0;t++) 
			{
				int j=rand.nextInt(al.licz_os+1);
				if(b1[j]==1) 
				{
					b1[j]=0;
					t=-2;
				}
			}
		}else 
		{
			ij++;
			for(int t=0;t>0;t++) 
			{
				int j=rand.nextInt(al.licz_os+1);
				if(b1[j]==0) 
				{
					b1[j]=1;
					t=-2;
				}
			}
		}
	 }
	 int kl=0;int[][] b2=new int[ij+1][2];
	 for(int i=0;i<al.licz_os;i++) 
	 {
		if(b1[i]==1) 
		{
			b2[kl][0]=i;
			b2[kl][1]=rand.nextInt(1001);
			kl++;
		}
	 }
	 kl--;
	int temp;
	 for(int j=0; j<kl;j++)
	 	{
			for(int s=0; s<kl-1;s++)
				{
					if(b2[s][1]<b2[s+1][1])
						{
						temp = b2[s+1][0];
						b2[s+1][0] = b2[s][0];
						b2[s][0]= temp;
						temp = b2[s+1][1];
						b2[s+1][1] =b2[s][1];
						b2[s][1]= temp;
						
						}
				}
			} //losowe przetasowanie urzytkownikow
	 
	 int gw=1;//ilosc zmian
	 //tabela lokalizacji zmian
	 int t[]=new int[gw];
	 int sp;
	 for(int j=0;j<gw;j++) 
		 	{
		 	sp=j;
			 t[j]=rand.nextInt(al.m);
			 if(sp!=0) 
			 {
			 for(int i=0;i<sp-1;i++)
				 if(t[j]==t[i]) 
				 {
					i=j;
					j--;
					
				 }	 
		 	}
			 }

	 for(int i=0;i<gw;i++) 
	 	{
		 for(int j=0;j<gw-1;j++) 
	 			{if(t[j]>t[j+1]) {
	 				temp =  t[j+1];
	 				 t[j+1] = t[j];
	 				 t[j]= temp;
	 			}
	 			}
	 			}
	 int trzon=0;
	 int kto=1;
	 for(int i=0;i<kl/2;i=i+2) 
		 {
			 for(int j=0;j<al.m;j++) 
			 {
				 if(trzon<gw) {
					 if(t[trzon]==j) {
						 trzon++;	 
					 kto*=-1;
					  }}
				 if(kto==1) {
					 opereta.tam[b2[i][0]][j]=   al.tab[(int) reprod.wyg[b2[i][0]]][j];
					 opereta.tam[b2[i+1][0]][j]= al.tab[(int) reprod.wyg[b2[i+1][0]]][j];
				 }
				 if(kto==-1) {
					 opereta.tam[b2[i][0]][j]= al.tab[(int) reprod.wyg[b2[i+1][0]]][j];  
					 opereta.tam[b2[i+1][0]][j]= al.tab[(int) reprod.wyg[b2[i][0]]][j];
				 }
			 } 
			 kto=1;trzon=0; 
		 }
	 
 }
 static void krzyzowankorece() 
 {
	 int b[]=new int[al.licz_os];//prawdopodobienstwo dla osobnikow
	 int b1[]=new int[al.licz_os];//czy krzyzowanko?
	 int ij=0;//iloœæ osobników krzy¿owanych
	 for(int i=0;i<(al.licz_os);i++) 
	   {
		for(int j=0;j<(al.m);j++) 
			{
			opereta.tam[i][j]=al.tab[i][j];
			}
	   }
	 for(int i=0;i<al.licz_os;i++) 
	 {
		 b[i]=rand.nextInt(101);
		 b1[i]=0;
		 if(b[i]<pn) 
		 {
			ij++; 
			b1[i]=1;
		 }
	 }
	 
	 if(Math.floorMod(ij, 2)!=0 && ij!=0) 
	 {
		 if(ij>al.licz_os/2||ij==al.licz_os) 
		 {
			ij--;
			for(int t=0;t>0;t++) 
			{
				int j=rand.nextInt(al.licz_os+1);
				if(b1[j]==1) 
				{
					b1[j]=0;
					t=-2;
				}
			}
		}else 
		{
			ij++;
			for(int t=0;t>0;t++) 
			{
				int j=rand.nextInt(al.licz_os+1);
				if(b1[j]==0) 
				{
					b1[j]=1;
					t=-2;
				}
			}
		}
	 }
	 int kl=0;int[][] b2=new int[ij+1][2];
	 for(int i=0;i<al.licz_os;i++) 
	 {
		if(b1[i]==1) 
		{
			b2[kl][0]=i;
			b2[kl][1]=rand.nextInt(1001);
			kl++;
		}
	 }
	 kl--;
	int temp;
	 for(int j=0; j<kl;j++)
	 	{
			for(int s=0; s<kl-1;s++)
				{
					if(b2[s][1]<b2[s+1][1])
						{
						temp = b2[s+1][0];
						b2[s+1][0] = b2[s][0];
						b2[s][0]= temp;
						temp = b2[s+1][1];
						b2[s+1][1] =b2[s][1];
						b2[s][1]= temp;
						
						}
				}
			} //losowe przetasowanie urzytkownikow
	 
	 int gw=2;//ilosc zmian
	//tabela lokalizacji zmian
	 int t[]=new int[gw];
	 int sp;
	 for(int j=0;j<gw;j++) 
		 	{
		 	sp=j;
			 t[j]=rand.nextInt(al.m);
			 if(sp!=0) 
			 {
			 for(int i=0;i<sp-1;i++)
				 if(t[j]==t[i]) 
				 {
					i=j;
					j--;
					
				 }	 
		 	}
			 }

	 for(int i=0;i<gw;i++) 
	 	{
		 for(int j=0;j<gw-1;j++) 
	 			{if(t[j]>t[j+1]) {
	 				temp =  t[j+1];
	 				 t[j+1] = t[j];
	 				 t[j]= temp;
	 			}
	 			}
	 			}
	 int trzon=0;
	 int kto=1;
	 for(int i=0;i<kl/2;i=i+2) 
		 {
			 for(int j=0;j<al.m;j++) 
			 {
				 if(trzon<gw) {
					 if(t[trzon]==j) {
						 trzon++;	 
					 kto*=-1;
					  }}
				 if(kto==1) {
					 opereta.tam[b2[i][0]][j]=   al.tab[(int) reprod.wyg[b2[i][0]]][j];
					 opereta.tam[b2[i+1][0]][j]= al.tab[(int) reprod.wyg[b2[i+1][0]]][j];
				 }
				 if(kto==-1) {
					 opereta.tam[b2[i][0]][j]= al.tab[(int) reprod.wyg[b2[i+1][0]]][j];  
					 opereta.tam[b2[i+1][0]][j]= al.tab[(int) reprod.wyg[b2[i][0]]][j];
				 }
			 } 
			 kto=1;trzon=0; 
		 }
	
 }
 static void krzyzowankorownomierne() 
	 {
	 holow=0;
	 for(int i=0;i<(al.licz_os);i++) 
	   {
		for(int j=0;j<(al.m);j++) 
			{
			opereta.tam[i][j]=al.tab[i][j];
			}
	   }
	 int b[]=new int[al.licz_os];//prawdopodobienstwo dla osobnikow
	 int b1[]=new int[al.licz_os];//czy krzyzowanko?
	 int ij=0;//iloœæ osobników krzy¿owanych
	 for(int i=0;i<al.licz_os;i++) 
	 {
		 b[i]=rand.nextInt(101);
		 b1[i]=0;
		 if(b[i]<pn) 
		 {
			ij++; 
			b1[i]=1;
		 }
	 }
	 
	 if(Math.floorMod(ij, 2)!=0 && ij!=0) 
	 {
		 if(ij>al.licz_os/2||ij==al.licz_os) 
		 {
			ij--;
			for(int t=0;t>0;t++) 
			{
				int j=rand.nextInt(al.licz_os+1);
				if(b1[j]==1) 
				{
					b1[j]=0;
					t=-2;
				}
			}
		}else 
		{
			ij++;
			for(int t=0;t>0;t++) 
			{
				int j=rand.nextInt(al.licz_os+1);
				if(b1[j]==0) 
				{
					b1[j]=1;
					t=-2;
				}
			}
		}
	 }
	 int kl=0;int[][] b2=new int[ij+1][2];
	 for(int i=0;i<al.licz_os;i++) 
	 {
		if(b1[i]==1) 
		{
			b2[kl][0]=i;
			b2[kl][1]=rand.nextInt(1001);
			kl++;
		}
	 }
	 kl--;
	int temp;
	 for(int j=0; j<kl;j++)
	 	{
			for(int s=0; s<kl-1;s++)
				{
					if(b2[s][1]<b2[s+1][1])
						{
						temp = b2[s+1][0];
						b2[s+1][0] = b2[s][0];
						b2[s][0]= temp;
						temp = b2[s+1][1];
						b2[s+1][1] =b2[s][1];
						b2[s][1]= temp;
						
						}
				}
			} //losowe przetasowanie urzytkownikow
	 	int[][]	wzurtab= new int[al.licz_os][al.m];
		for(int i=0;i<(al.licz_os);i++) 
		   {
			for(int j=0;j<(al.m);j++) 
				{
				wzurtab[i][j]=rand.nextInt(2);
				}
			}
		 for(int i=0;i<kl/2;i=i+2) 
		 {
			 for(int j=0;j<al.m;j++) 
			 {
				 
				 if(wzurtab[i][j]==0) {
					 opereta.tam[b2[i][0]][j]=   al.tab[(int) reprod.wyg[b2[i][0]]][j];
					 opereta.tam[b2[i+1][0]][j]= al.tab[(int) reprod.wyg[b2[i+1][0]]][j];
				 }
				 if(wzurtab[i][j]==1) {
					 opereta.tam[b2[i][0]][j]= al.tab[(int) reprod.wyg[b2[i+1][0]]][j]; 
					 opereta.tam[b2[i+1][0]][j]=  al.tab[(int) reprod.wyg[b2[i][0]]][j];

				 }
			 } 
		 }
		 for(int i=0;i<kl/2;i=i+2) 
		 {
			 for(int j=0;j<al.m;j++) 
			 {
				 opereta.typow[holow][j]=opereta.tam[b2[i][0]][j];
				 opereta.typow[holow+1][j]=opereta.tam[b2[i+1][0]][j];
			 }
			 holow=holow+2;
		 }
	 }
	 
 }
 class sukcesja
 {
	 static Random rand = new Random();
	 static Scanner odczyt = new Scanner(System.in); 
	 static double pn;
	 static int g;
	 static void wejdzmy()
	 {
		 System.out.println("Ile pokoleñ potomków ma obejmowaæ sukcejsja(bez rodzica)");
		g=odczyt.nextInt();
		 System.out.println("która sukcesja ciê interesuje?");
		 System.out.println("1:Sukcesja z ca³kowitym zastêpowaniem \n2:Sukcesja z czêœciowym zastêpowaniem losowo\n3:Sukcesja losowa\n4:Sukcesja elitarna\n5:Sukcesja usuwanie pod\n0:wolnoœæ");
		 System.out.println("podaj numer");
		 int h=odczyt.nextInt();
		 reprod.wybiesznafirst();
		 System.out.println(" podaj prawdopodobieñstwo(%) krzyzowanko w populacji");
		 opereta.pn=odczyt.nextDouble();
		 switch (h) 
		 	{
		    case 1:suk_cal_kow_zas();break;
		    case 2:suk_cze_wymiana();break;
		    case 3:suk_los();break;
		    case 4:suk_elit();break;
		    case 5:suk_usuwanie_pod();break;
		    case 0:break;
		 	}
	 }
	 static void suk_cal_kow_zas()
	 {
		 reprod.wybierz();
		 for(int l=0;l<g;l++) 
		 {
			 System.out.println("Pokolenie "+l+":");
			 opereta.mutlubinwer(); 
			 opereta.mutacja();
			 opereta.inwersja();
			 opereta.krzyzowankowielo();
			 for(int i=0;i<(al.licz_os);i++) 
			   {
				for(int j=0;j<(al.m);j++) 
					{
					al.tab[i][j]=opereta.tam[i][j];
					
					}
			   }
			 al.wloncz();
		 }
	 }
	 static void suk_cze_wymiana()
	 {
		 reprod.wybierz(); 
		 int ile;
		 System.out.println("Podaj prawdopodobieñstwo% zachowania osobników ");
		 ile=odczyt.nextInt();
		 int randomir[]=new int[al.licz_os];
		 int randomire[]=new int[al.licz_os*4];
		 int ile_zostanie_po=Math.floorDiv(al.licz_os*ile, 100);
		 int t[][]=new int[al.licz_os][al.licz_os];
		 for(int l=0;l<g;l++) 
		 {
			 System.out.println("Pokolenie "+l+":");
			 for(int i=0;i<(al.licz_os);i++) 
			   {
				t[i][0]=i;//to jest miejsce osobnika
				t[i][1]=i;//to jest liczbaporz¹tkuj¹ca
			   }
			 for(int i=0;i<al.licz_os;i++) 
			 {
				 randomir[i]=rand.nextInt(al.licz_os-i);				 
			 }
			
			 int ilosc=0;
			 int iloscm=0;
			 int ilosci=0;
			 int ilosckw=0;
			 int ilosckr=0;
			 reprod.wybierz();
			 opereta.mutlubinwer();
			 opereta.mutacja();
			 int tam_mut[][]=new int[opereta.holow][al.m];
			 for(int i=0;i<(opereta.holow);i++) 
			   {
				for(int j=0;j<(al.m);j++) 
					{
					tam_mut[i][j]=opereta.typow[i][j];
					}
			   }ilosc+=opereta.holow;
			   iloscm=opereta.holow;
			   opereta.mutlubinwer();
			   opereta.inwersja();
			 int tam_inw[][]=new int[opereta.holow][al.m];
			 for(int i=0;i<(opereta.holow);i++) 
			   {
				for(int j=0;j<(al.m);j++) 
					{
					tam_inw[i][j]=opereta.typow[i][j];
					}
			   }ilosc+=opereta.holow;
			   ilosci=opereta.holow;
			 opereta.mutlubinwer();
			 opereta.krzyzowankorownomierne();
			 int tam_krzruwo[][]=new int[opereta.holow][al.m];
			 for(int i=0;i<(opereta.holow);i++) 
			   {
				for(int j=0;j<(al.m);j++) 
					{
					tam_krzruwo[i][j]=opereta.typow[i][j];
					}
			   }ilosc+=opereta.holow;
			   ilosckr=opereta.holow;
			 opereta.mutlubinwer();
			 opereta.krzyzowankowielo();
			 int tam_krzwielo[][]=new int[opereta.holow][al.m];
			 for(int i=0;i<(opereta.holow);i++) 
			   {
				for(int j=0;j<(al.m);j++) 
					{
					tam_krzwielo[i][j]=opereta.typow[i][j];
					}
			   }ilosc+=opereta.holow;
			   ilosckw=opereta.holow;
			 int ti[][]=new int[ilosc][ilosc];
			 for(int i=0;i<(ilosc);i++) 
			   {
				ti[i][0]=i;//to jest miejsce osobnika
				ti[i][1]=i;//to jest liczbaporz¹tkuj¹ca
			   }
			 if(al.licz_os-ile_zostanie_po>ilosc) 
			 {
				 int ruz=al.licz_os-ile_zostanie_po-ilosc;
				 ile_zostanie_po+=ruz;
			 }
				 for(int i=0;i<(ile_zostanie_po);i++) 
				   {
					 t[randomir[i]][1]=99999;
					int temp;
					 	for(int p=0; p<al.licz_os;p++)
					 		{
				 			for(int s=0; s<al.licz_os-1;s++)
				 				{
				 					if(t[s][0]>t[s+1][0])
				 						{
				 						temp = t[s+1][0];
				 						t[s+1][0] = t[s][0];
				 						t[s][0]= temp;
				 						temp = t[s+1][1];
				 						t[s+1][1] =t[s][1];
				 						t[s][1]= temp;
				 						}
				 				}
				 			}
				   }//po tym tablica t sk³ada na pierwszych licz_os-ile_zostanie_po z wymienialnych chromosonów
				 int tam_oj[][]=new int[al.licz_os][al.m];
				 for(int i=0;i<(al.licz_os);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_oj[i][j]=al.tab[i][j];
						}
				   }
				 for(int i=ile_zostanie_po;i<(al.licz_os-ile_zostanie_po);i++) 
				   {
					 for(int j=0;j<(al.m);j++) 
						{
						tam_oj[i][j]=al.tab[t[i][0]][j];
						} 
				   }
			 for(int i=0;i<al.licz_os-ile_zostanie_po;i++) 
			 {
				 randomire[i]=rand.nextInt((ilosc)-i);	
			 }
			 for(int i=0;i<(al.licz_os-ile_zostanie_po);i++) 
			   {
				 ti[randomire[i]][1]=99999;
				 t[randomir[i]][1]=99999;
				 if(randomire[i]<iloscm)
				 {
					 for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=tam_mut[randomire[i]][j];
						} iloscm-=1;
				 }
				 if(randomire[i]<iloscm+ilosci&&randomire[i]>iloscm)
				 {
					 for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=tam_inw[randomire[i]-iloscm][j];
						} ilosci-=1;
				 }
				 if(randomire[i]<iloscm+ilosci+ilosckr&&randomire[i]>iloscm+ilosci)
				 {
					 for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=tam_krzruwo[randomire[i]-(iloscm+ilosci)][j];
						} ilosckr-=1;
				 }
				 if(randomire[i]<ilosc&&randomire[i]>ilosc-ilosckw)
				 {
					 for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=tam_krzwielo[randomire[i]-(ilosc-ilosckw)][j];
						} ilosckw-=1;
				 }
				int temp;
				 	for(int p=0; p<(ilosc);p++)
				 		{
			 			for(int s=0; s<ilosc-1;s++)
			 				{
			 					if(ti[s][0]<ti[s+1][0])
			 						{
			 						temp = ti[s+1][0];
			 						ti[s+1][0] = ti[s][0];
			 						ti[s][0]= temp;
			 						temp = ti[s+1][1];
			 						ti[s+1][1] =ti[s][1];
			 						ti[s][1]= temp;
			 						}
			 				}
			 			}}
				 	
			 al.wloncz();
		 } 
			 
		 }
		 static void suk_los()
		 {
			 reprod.wybierz();
			 for(int l=0;l<g;l++) 
				 {int ilosc=0;
				 int iloscm=0;
				 int ilosci=0;
				 int ilosckw=0;
				 int ilosckr=0;
				 int iloscoj=al.licz_os;
				 int tam_oj[][]=new int[al.licz_os][al.m];
				 for(int i=0;i<(al.licz_os);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_oj[i][j]=al.tab[i][j];
						}
				   }ilosc=al.licz_os;
				 System.out.println("Pokolenie "+l+":");
				 reprod.wybierz();
				 opereta.mutacja();
				 int tam_mut[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_mut[i][j]=opereta.typow[i][j];
						}
				   }
				 iloscm=opereta.holow;
				 ilosc=ilosc+opereta.holow;
				 opereta.inwersja();
				 int tam_inw[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_inw[i][j]=opereta.typow[i][j];
						}
				   }
				 ilosc=ilosc+opereta.holow;
				 ilosci=opereta.holow;
				 opereta.krzyzowankorownomierne();
				 int tam_krzruwo[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_krzruwo[i][j]=opereta.typow[i][j];
						}
				   }
				 ilosc=ilosc+opereta.holow;
				 ilosckr=opereta.holow;
				 opereta.krzyzowankowielo();
				 int tam_krzwielo[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_krzwielo[i][j]=opereta.typow[i][j];
						}
				   }
				 
				 ilosc=ilosc+opereta.holow;
				 ilosc=ilosc+al.licz_os;
				 ilosckw=opereta.holow;
				 int ti[][]=new int[ilosc][ilosc];
				 for(int i=0;i<(ilosc);i++) 
				   {
					ti[i][0]=i;//to jest miejsce osobnika
					ti[i][1]=i;//to jest liczbaporz¹tkuj¹ca
				   }
				 int randomir[]=new int[ilosc];
				 int randomire[]=new int[ilosc];
				 for(int i=0;i<al.licz_os;i++) 
				 {
					 randomire[i]=rand.nextInt((ilosc)-i);				 
				 }
				 for(int i=0;i<(al.licz_os);i++) 
				   {
					 ti[randomire[i]][1]=99999;
					 if(ti[randomire[i]][0]<iloscoj)
					 {
						 for(int j=0;j<(al.m);j++) 
							{
							 al.tab[i][j]=tam_oj[ti[randomire[i]][0]][j];
							}iloscoj-=1;
					 } 
					 if(ti[randomire[i]][0]<iloscoj+iloscm&&ti[randomire[i]][0]>iloscoj)
					 {
						 for(int j=0;j<(al.m);j++) 
							{
							al.tab[i][j]=tam_mut[ti[randomire[i]][0]-iloscoj][j];
							} iloscm-=1;
					 }
					 if(ti[randomire[i]][0]<iloscoj+iloscm+ilosci&&ti[randomire[i]][0]>iloscoj+iloscm)
					 {
						 for(int j=0;j<(al.m);j++) 
							{
							 al.tab[i][j]=tam_inw[ti[randomire[i]][0]-(iloscm+iloscoj)][j];
							} ilosci-=1;
					 }
					 if(ti[randomire[i]][0]<iloscoj+iloscm+ilosci+ilosckr&&ti[randomire[i]][0]>iloscoj+iloscm+ilosci)
					 {
						 for(int j=0;j<(al.m);j++) 
							{
							al.tab[i][j]=tam_krzruwo[ti[randomire[i]][0]-(iloscoj+iloscm+ilosci)][j];
							} ilosckr-=1;
					 }
					 if(ti[randomire[i]][0]<iloscoj+iloscm+ilosci+ilosckr+ilosckw&&ti[randomire[i]][0]>iloscoj+iloscm+ilosci+ilosckr)
					 {
						 for(int j=0;j<(al.m);j++) 
							{
							al.tab[i][j]=tam_krzwielo[ti[randomire[i]][0]-(iloscoj+iloscm+ilosci+ilosckr)][j];
							} ilosckw-=1;
					 }
					int temp;
					 	for(int p=0; p<(ilosc-i);p++)
					 		{
				 			for(int s=0; s<ilosc-i-1;s++)
				 				{
				 					if(ti[s][0]<ti[s+1][0])
				 						{
				 						temp = ti[s+1][0];
				 						ti[s+1][0] = ti[s][0];
				 						ti[s][0]= temp;
				 						temp = ti[s+1][1];
				 						ti[s+1][1] =ti[s][1];
				 						ti[s][1]= temp;
				 						}
				 				}
				 			}
					 	
				   }
				 
				 al.wloncz();
				 
				 
			 }
		 }
		 static void suk_elit()
		 {
			 reprod.wybierz();
			 int tam_tym[][]=new int[al.licz_os][al.m];
			 double til[][]=new double[al.licz_os*5][al.licz_os*5];
			 int ilosc=0;
			 int iloscm=0;
			 int ilosci=0;
			 int ilosckw=0;
			 int ilosckr=0;
			 int ile;
			 int a=0;
			 for(int l=0;l<g;l++) 
				 {ilosc=0;
				 System.out.println("Pokolenie "+l+" wyniki funkcji dla poszczegolnych czêœci operatorow genetycznych");
				 for(int i=0;i<(al.licz_os);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_tym[i][j]=al.tab[i][j];
						}
				   }
				 for(int i=al.licz_os;i<(al.licz_os*5);i++) 
				   {
					 til[i][0]=0;
				   }
				 for(int i=0;i<(al.licz_os);i++) 
				   {
					 til[i][0]=al.fu[i];
					 til[i][1]=i;
				   }ilosc+=al.licz_os;
				   int iloscoj=al.licz_os;
				 reprod.wybierz();
				 opereta.mutacja();
				 int tam_mut[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_mut[i][j]=opereta.typow[i][j];
						}
				   }
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=opereta.typow[i][j];
						}
				   }
				 al.wloncz();
				 ilosc+=opereta.holow;
				 for(int i=ilosc-opereta.holow;i<(ilosc);i++) 
				   {
					 til[i][0]=al.fu[a];
					 til[i][1]=i;
					 a+=1;
				   }a=0;
				  iloscm=opereta.holow;
				 opereta.inwersja();
				 int tam_inw[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_inw[i][j]=opereta.typow[i][j];
						}
				   }
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=opereta.typow[i][j];
						}
				   }
				 al.wloncz();
				 ilosc+=opereta.holow;
				 for(int i=ilosc-opereta.holow;i<(ilosc);i++) 
				 {
				 til[i][0]=al.fu[a];
				 til[i][1]=i;
				 a+=1;
			   }a=0;
				  ilosci=opereta.holow;
				 opereta.krzyzowankorownomierne();
				 int tam_krzruwo[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_krzruwo[i][j]=opereta.typow[i][j];
						}
				   }
				 for(int i=0;i<(al.licz_os);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=opereta.tam[i][j];
						}
				   }
				 al.wloncz();
				 ilosc+=opereta.holow;
				 for(int i=ilosc-opereta.holow;i<(ilosc);i++) 
				 {
				 til[i][0]=al.fu[a];
				 til[i][1]=i;
				 a+=1;
			   }a=0;
				  ilosckr=opereta.holow;
				 opereta.krzyzowankowielo();
				 int tam_krzwielo[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_krzwielo[i][j]=opereta.typow[i][j];
						}
				   }
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=opereta.typow[i][j];
						}
				   }
				 al.wloncz();
				 ilosc+=opereta.holow;
				 for(int i=ilosc-opereta.holow;i<(ilosc);i++) 
				 {
				 til[i][0]=al.fu[a];
				 til[i][1]=i;
				 a+=1;
			   }a=0;
				  ilosckw=opereta.holow;

					double temp;
					 	for(int p=0; p<(5*al.licz_os);p++)
					 		{
				 			for(int s=0; s<5*al.licz_os-1;s++)
				 				{
				 					if(til[s][0]<til[s+1][0])
				 						{
				 						temp = til[s+1][0];
				 						til[s+1][0] = til[s][0];
				 						til[s][0]= temp;
				 						temp = til[s+1][1];
				 						til[s+1][1] = til[s][1];
				 						til[s][1]= temp;
				 						}				 						}
				 				}
					 	for(int p=0; p<(5*al.licz_os);p++)
				 		{			 	
					 	System.out.println("Pokolenie "+til[p][0]+" "+til[p][1]);
				 		}
					 	System.out.println("Pokolenie "+l+":");
					 	for(int i=0;i<(al.licz_os);i++) 
						   
								{
						 if(til[i][1]<iloscoj)
							 {
							 for(int j=0;j<(al.m);j++) 
								{
								 al.tab[i][j]=tam_tym[(int)til[i][1]][j];
								 
								} 
								 }		
					 	 if(til[i][1]<iloscoj+iloscm&&til[i][1]>iloscoj)
						 {
							 for(int j=0;j<(al.m);j++) 
								{
								al.tab[i][j]=tam_mut[(int) til[i][1]-iloscoj][j];
								}
						 }
						 if(til[i][1]<iloscoj+iloscm+ilosci&&til[i][1]>iloscoj+iloscm)
						 {
							 for(int j=0;j<(al.m);j++) 
								{
								 al.tab[i][j]=tam_inw[(int)til[i][1]-(iloscoj+iloscm)][j];
								} 
						 }
						 if(til[i][1]<iloscoj+iloscm+ilosci+ilosckr&&til[i][1]>iloscoj+iloscm+ilosci)
						 {
							 for(int j=0;j<(al.m);j++) 
								{
								al.tab[i][j]=tam_krzruwo[(int)til[i][1]-(iloscoj+iloscm+ilosci)][j];
								} 
						 }
						 if(til[i][1]<iloscoj+iloscm+ilosci+ilosckr+ilosckw&&til[i][1]>iloscoj+iloscm+ilosci+ilosckr)
						 {
							 for(int j=0;j<(al.m);j++) 
								{
								al.tab[i][j]=tam_krzwielo[(int) (til[i][1]-(iloscoj+iloscm+ilosci+ilosckr))][j];
								} 
						 }   }
					 	al.wloncz();
				 }
				 
			 }
		 
		 static void suk_usuwanie_pod()
		 {
			 reprod.wybierz();
			 int tam_tym[][]=new int[al.licz_os][al.m];
			 double til[][]=new double[al.licz_os*5][al.licz_os*5];
			 int ilosc=0;
			 int iloscm=0;
			 int ilosci=0;
			 int ilosckw=0;
			 int ilosckr=0;
			 int ile;
			 int a=0;

			 for(int l=0;l<g;l++) 
				 {ilosc=0;
				 for(int i=0;i<(al.licz_os);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_tym[i][j]=al.tab[i][j];
						}
				   }
				 for(int i=al.licz_os;i<(al.licz_os*5);i++) 
				   {
					 til[i][0]=0;
				   }
				 for(int i=0;i<(al.licz_os);i++) 
				   {
					 til[i][0]=al.fu[i];
					 til[i][1]=i;
				   }ilosc+=al.licz_os;
				   int iloscoj=al.licz_os;
				 reprod.wybierz();
				 opereta.mutacja();
				 int tam_mut[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_mut[i][j]=opereta.typow[i][j];
						}
				   }
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=opereta.typow[i][j];
						}
				   }
				 al.wloncz();
				 ilosc+=opereta.holow;
				 for(int i=ilosc-opereta.holow;i<(ilosc);i++) 
				   {
					 til[i][0]=al.fu[a];
					 til[i][1]=i;
					 a+=1;
				   }a=0;
				  iloscm=opereta.holow;
				 opereta.inwersja();
				 int tam_inw[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_inw[i][j]=opereta.typow[i][j];
						}
				   }
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=opereta.typow[i][j];
						}
				   }
				 al.wloncz();
				 ilosc+=opereta.holow;
				 for(int i=ilosc-opereta.holow;i<(ilosc);i++) 
				 {
				 til[i][0]=al.fu[a];
				 til[i][1]=i;
				 a+=1;
			   }a=0;
				  ilosci=opereta.holow;
				 opereta.krzyzowankorownomierne();
				 int tam_krzruwo[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_krzruwo[i][j]=opereta.typow[i][j];
						}
				   }
				 for(int i=0;i<(al.licz_os);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=opereta.tam[i][j];
						}
				   }
				 al.wloncz();
				 ilosc+=opereta.holow;
				 for(int i=ilosc-opereta.holow;i<(ilosc);i++) 
				 {
				 til[i][0]=al.fu[a];
				 til[i][1]=i;
				 a+=1;
			   }a=0;
				  ilosckr=opereta.holow;
				 opereta.krzyzowankowielo();
				 int tam_krzwielo[][]=new int[opereta.holow][al.m];
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						tam_krzwielo[i][j]=opereta.typow[i][j];
						}
				   }
				 for(int i=0;i<(opereta.holow);i++) 
				   {
					for(int j=0;j<(al.m);j++) 
						{
						al.tab[i][j]=opereta.typow[i][j];
						}
				   }
				 al.wloncz();
				 ilosc+=opereta.holow;
				 for(int i=ilosc-opereta.holow;i<(ilosc);i++) 
				 {
				 til[i][0]=al.fu[a];
				 til[i][1]=i;
				 a+=1;
			   }a=0;
				  ilosckw=opereta.holow;
			
					double temp;
					 	for(int p=0; p<(5*al.licz_os);p++)
					 		{
				 			for(int s=0; s<5*al.licz_os-1;s++)
				 				{
				 					if(til[s][0]<til[s+1][0])
				 						{
				 						temp = til[s+1][0];
				 						til[s+1][0] = til[s][0];
				 						til[s][0]= temp;
				 						temp = til[s+1][1];
				 						til[s+1][1] = til[s][1];
				 						til[s][1]= temp;
				 						}				 						}
				 				}
				 			
					 	double ti[][]=new double[ilosc][ilosc];	
					 	for(int p=0; p<(ilosc)-1;p++)
				 		{
					 		ti[p][0]=Math.sqrt(Math.pow(til[p][0]-til[p+1][0],2));
					 		ti[p][1]=til[p][1];
				 		}
					 	for(int p=0; p<(ilosc);p++)
				 		{
			 			for(int s=0; s<ilosc-1;s++)
			 				{
			 					if(ti[s][0]>ti[s+1][0])
			 						{
			 						temp = ti[s+1][0];
			 						ti[s+1][0] = ti[s][0];
			 						ti[s][0]= temp;
			 						temp = ti[s+1][1];
			 						ti[s+1][1] = ti[s][1];
			 						ti[s][1]= temp;
			 						}				 						}
			 				}

					 	System.out.println("Pokolenie "+l+":");
					 	for(int i=0;i<(al.licz_os);i++) 
						   
								{
								al.fu[i]=ti[i][0];
								
						 if(ti[i][1]<iloscoj)
							 {
							 for(int j=0;j<(al.m);j++) 
								{
								 al.tab[i][j]=tam_tym[(int)ti[i][1]][j];
								} 
								 }		
					 	 if(ti[i][1]<iloscoj+iloscm&&ti[i][1]>iloscoj)
						 {
							 for(int j=0;j<(al.m);j++) 
								{
								al.tab[i][j]=tam_mut[(int) ti[i][1]-iloscoj][j];
								}
						 }
						 if(ti[i][1]<iloscoj+iloscm+ilosci&&ti[i][1]>iloscoj+iloscm)
						 {
							 for(int j=0;j<(al.m);j++) 
								{
								 al.tab[i][j]=tam_inw[(int)ti[i][1]-(iloscoj+iloscm)][j];
								}
						 }
						 if(ti[i][1]<iloscoj+iloscm+ilosci+ilosckr&&ti[i][1]>iloscoj+iloscm+ilosci)
						 {
							 for(int j=0;j<(al.m);j++) 
								{
								al.tab[i][j]=tam_krzruwo[(int)ti[i][1]-(iloscoj+iloscm+ilosci)][j];
								}
						 }
						 if(ti[i][1]<iloscoj+iloscm+ilosci+ilosckr+ilosckw&&ti[i][1]>iloscoj+iloscm+ilosci+ilosckr)
						 {
							 for(int j=0;j<(al.m);j++) 
								{
								al.tab[i][j]=tam_krzwielo[(int) (ti[i][1]-(iloscoj+iloscm+ilosci+ilosckr))][j];
								}
						 }   }
					 	 
					 	
					 	al.wloncz(); 
			 }
			 }
		 }
public class rat2 
{

	public static void main(String[] args) throws IOException
	{	
		
		al.t_t_arg_fun();
		al.losuj2();
		al.wloncz();
		sukcesja.wejdzmy();
		
	}

}
