package com.example.edison.tabla;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public void order(int mat[][], int n, int m) {
        int t;
        for (int i = 0; i < n; i++) {//ordena la matriz de abajo hacia arriba
            for (int j = 0; j < m; j++) {
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        if (mat[i][j] < mat[x][y]) {
                            t = mat[i][j];
                            mat[i][j] = mat[x][y];
                            mat[x][y] = t;
                        }
                    }
                }
            }
        }
    }

    public static void intercambio(int lista[]){

        //Usamos un bucle anidado
        for(int i=0;i<(lista.length-1);i++){
            for(int j=i+1;j<lista.length;j++){
                if(lista[i]>lista[j]){
                    //Intercambiamos valores
                    int variableauxiliar=lista[i];
                    lista[i]=lista[j];
                    lista[j]=variableauxiliar;

                }
            }
        }
    }


    public static void intercambioPalabras(String lista[]){

        //Usamos un bucle anidado
        for(int i=0;i<(lista.length-1);i++){
            for(int j=i+1;j<lista.length;j++){
                if(lista[i].compareToIgnoreCase(lista[j])>0){
                    //Intercambiamos valores
                    String variableauxiliar=lista[i];
                    lista[i]=lista[j];
                    lista[j]=variableauxiliar;

                }
            }
        }
    }


    public int frecuencia(int anchura, int ini_rg, int[] vec){
        //int auchura=4;
        int vl=ini_rg;
        int aux[]= new int[anchura];
        for (int i = 0; i < aux.length; i++) {
            aux[i]=vl;
            vl++;
        }

        for (int i = 0; i < aux.length; i++) {
            System.out.println("--"+aux[i]);
        }
        //int []a={19,19,20,23,27,28};
        int []a=vec;
        int fa=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < aux.length; j++) {
                if (a[i]==aux[j]) {
                    //System.out.println("vec"+a[i]+"rang"+aux[j]);
                    fa++;
                }
            }
        }
        System.out.println("frecuancia"+fa);

        return fa;
    }

    public static String contarRepeticiones(int[] M) {
        String r = "";
        int maximaVecesQueSeRepite = 0;
        int moda = 0;
        for (int i = 0; i < M.length; i++) {
            int vecesQueSeRepite = 0;
            for (int j = 0; j < M.length; j++) {
                if (M[i] == M[j]) {
                    vecesQueSeRepite++;
                }
            }
            if (vecesQueSeRepite > maximaVecesQueSeRepite) {
                moda = M[i];
                maximaVecesQueSeRepite = vecesQueSeRepite;
            }
        }

        r="Moda=" + moda + "con" + maximaVecesQueSeRepite + " repeticiones";

        return r;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final TextView valorSuma = (TextView)findViewById(R.id.txtValorSuma);
        //final TextView nombre = (TextView)findViewById(R.id.txtNombre);
        final TextView valor= (TextView)findViewById(R.id.txtnum);
        final TextView txtResul= (TextView)findViewById(R.id.txaResDNA);
        final TextView txtResulDA= (TextView)findViewById(R.id.txaResDA);
        //final TextView txtCal= (TextView)findViewById(R.id.txtCal);

        Button agregar =(Button)findViewById(R.id.btnAgregar);
        //Button sumar = (Button)findViewById(R.id.btnSumar);
        //Button promedio=(Button)findViewById(R.id.btnPromedio);
        Button DNA=(Button)findViewById(R.id.btnCalDNA);
        Button DA=(Button)findViewById(R.id.btnCalDA);

        final TableLayout lista = (TableLayout)findViewById(R.id.tbllista);
        //lista.set
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String [] cadena;
                cadena = new String[]{valor.getText().toString()};
                TableRow row= new TableRow(getBaseContext());
                TextView textView;
                for (int i=0;i<1;i++){
                    textView = new TextView(getBaseContext());
                    textView.setGravity(Gravity.CENTER_VERTICAL);
                    textView.setPadding(15,15,15,15);
                    textView.setBackgroundResource(R.color.colorPrimary);
                    textView.setText(cadena[i]);
                    textView.setTextColor(Color.YELLOW);
                    row.addView(textView);
                }
                lista.addView(row);



            }
        });


        DNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double rowContent = 0;
                double contFilas=0;
                ////////Aritmrtica///////
                double sumMArt=0;
                double medArit=0;
                ///////Armonica////////
                double sumMA=0;
                double medArm=0;
                ////////Geometrica////////
                double mulMgeo=1;
                double medGeo=0;
                ////////Cuadratica///////
                double mulMCua=0;
                double medCua=0;
                ////////Desviacion Media///
                double sumX=0;
                double desvMed=0;
                double auxCua=0;

                ////////Grafico///


                for (int i = 0; i < lista.getChildCount(); i++) {
                    TableRow row = (TableRow) lista.getChildAt(i);
                    for (int j = 0; j < row.getChildCount(); j++) {
                        TextView currentCell = (TextView) row.getChildAt(j);
                        rowContent = Double.parseDouble(currentCell.getText().toString());
                        sumMArt=sumMArt+rowContent;
                        sumMA=sumMA+(1/rowContent);
                        mulMgeo=mulMgeo*rowContent;
                        mulMCua+=(rowContent*rowContent);
                        System.out.println("---->>>>>>>>>>>"+mulMCua);
                        //sumX=sumX+Math.abs(rowContent-medArit);
                        contFilas++;
                    }
                }
                ///MEDIA ARITMETICA
                medArit=sumMArt/contFilas;
                ///MEDIA ARMONICA
                medArm=(contFilas)/sumMA;
                ///MEDIA GEOMETRICA

                medGeo=Math.pow(mulMgeo,(1/contFilas));

                ///MEDIA CUADRATICA
                System.out.println("----------------------------acummm geo"+mulMCua);
                medCua=Math.sqrt(mulMCua/contFilas);
                System.out.println("-------------------------med Geo"+medCua);
                ///////////////////////////////////////////////////////////////////////////////////
                for (int i = 0; i < lista.getChildCount(); i++) {
                    TableRow row = (TableRow) lista.getChildAt(i);
                    for (int j = 0; j < row.getChildCount(); j++) {
                        TextView currentCell = (TextView) row.getChildAt(j);
                        rowContent = Double.parseDouble(currentCell.getText().toString());
                        sumX=sumX+Math.abs(rowContent-medArit);
                        System.out.println("----"+sumX);
                        //contFilas++;
                    }
                }


                ///DESVIACION MEDIA
                desvMed=sumX/contFilas;
                /////MEDIANA

                int c= (int)contFilas;
                int aux[]= new int[c];
                int val;
                for (int i = 0; i < lista.getChildCount(); i++) {
                    TableRow row = (TableRow) lista.getChildAt(i);
                    for (int j = 0; j < row.getChildCount(); j++) {
                        TextView currentCell = (TextView) row.getChildAt(j);
                        rowContent = Double.parseDouble(currentCell.getText().toString());
                        val= (int)rowContent;
                        aux[j]=val;
                        System.out.println("vallll  "+val);
                        System.out.println("ooooooool  "+aux[j]);
                        intercambio(aux);
                        //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa"+aux[j]);
                        //contFilas++;
                    }
                }

                int totF= (int)contFilas;
                int mediana=0;
                int med_vc=0;
                if(contFilas%2==0){
                    System.out.println(contFilas+" es par");
                    mediana=(totF+1)/2;
                    med_vc=aux[mediana];
                }else{
                    System.out.println(contFilas+" es impar");
                    mediana=(totF)/2;
                    med_vc=aux[mediana];
                }
                /////MODA
                String mod="";
                mod=contarRepeticiones(aux);
                txtResul.setMovementMethod(new ScrollingMovementMethod());
                txtResul.setText("DATOS NO AGRUPADOS"+
                        "\n"+" M.Aritmetica>: "+medArit+
                        "\n"+" M.Armonica>: "+medArm+
                        "\n"+" M.Geometrica>: "+medGeo+
                        "\n"+" M.Cuadratica>: "+medCua+
                        "\n"+" D.Media>: "+desvMed+
                        "\n"+" Moda>: "+mod+
                        "\n"+" Mediana>: "+med_vc
                );
                //GRAFICO DE PASTEL










                //CUARTILES, DECILES, PERCENTILES


            }
        });

        DA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double rowContent = 0;
                double contFilas=0;

                for (int i = 0; i < lista.getChildCount(); i++) {
                    TableRow row = (TableRow) lista.getChildAt(i);
                    for (int j = 0; j < row.getChildCount(); j++) {
                        TextView currentCell = (TextView) row.getChildAt(j);
                        rowContent = Double.parseDouble(currentCell.getText().toString());
                        contFilas++;
                    }
                }

                /////////////////////////////
                int c= (int)contFilas;
                int aux[]= new int[c];
                int val;
                for (int i = 0; i < lista.getChildCount(); i++) {
                    TableRow row = (TableRow) lista.getChildAt(i);
                    for (int j = 0; j < row.getChildCount(); j++) {
                        TextView currentCell = (TextView) row.getChildAt(j);
                        rowContent = Double.parseDouble(currentCell.getText().toString());
                        val= (int)rowContent;
                        aux[j]=val;
                        System.out.println("vallll  "+val);
                        System.out.println("ooooooool  "+aux[j]);
                        intercambio(aux);
                        //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa"+aux[j]);
                        //contFilas++;
                    }
                }
                String order="";
                for (int i = 0; i < aux.length; i++) {
                    System.out.print(""+aux[i]+",");
                    order+=aux[i]+",";

                }
                System.out.println("-----------------"+order);
                ////////////

                ///////////
                int vmin= aux[0];
                System.out.println("miiiiiiiiiiin"+vmin);
                int vmax= aux[c-1];
                System.out.println("maaaaaaaaaaaaaaxxxxx"+vmax);
                ///////DATOS AGRUPADOS
                int rango=vmax-vmin;
                double rg =vmax-vmin;
                System.out.println("rangoooo"+rango);
                double clase=Math.sqrt(contFilas);
                System.out.println("claseeee sin ren"+clase);
                int cla= (int)Math.round( clase);
                System.out.println("claasee finnnn"+cla);
                double anchura=  rg/cla;
                System.out.println("anchura sin redon"+anchura);
                int anch=(int)Math.round( anchura);
                System.out.println("achura  okkkkk"+anch);
                //////////////

                /////////////
                String clases="";
                String cl_vi="";
                String cl_vf="";
                String fa_tb="";
                int []vec_vmin= new int[cla];
                int []vec_vmax= new int[cla];
                int []vec_fa = new int[cla];
                int fa=0;
                int cla1=1;
                int clin=vmin;
                int clfn= vmin + (anch - 1);
                for (int i = 0; i < cla; i++) {
                    cl_vi+=clin+"-";
                    vec_vmin[i]=clin;
                    //for (int k=0; k<aux.length;k++){
                    fa=frecuencia(anch,clin,aux);
                    vec_fa[i]=fa;
                    System.out.println("vect--"+vec_fa[i]);
                    System.out.println("inicio:"+clin+"frec--"+frecuencia(anch,clin,aux));
                    fa_tb+=fa+",";
                    //}
                    clin=clin+anch;

                }


                for (int i = 0; i < cla; i++) {
                    clases+=cla1+"-";
                    cla1++;
                }

                for (int i = 0; i < cla; i++) {
                    cl_vf+=clfn+"-";
                    vec_vmax[i]=clfn;
                    clfn = clfn + anch;
                }
            /////////////////vectores de datos
                //////////////////fa
                int fa_acu=0;
                int num_frec=0;
                for (int i = 0; i < vec_fa.length; i++) {
                    System.out.println("vector de frecencia:"+vec_fa[i]);
                    fa_acu+=vec_fa[i];
                    num_frec+=vec_fa[i];
                }
                String datCla="";
                for (int i = 0; i < vec_fa.length; i++) {
                    System.out.print("vector de valores in:"+vec_vmin[i]+"-");
                    System.out.print("vector de valores fin:"+vec_vmax[i]);
                    System.out.println("");
                    datCla+= (i+1)+")"+vec_vmin[i]+"-"+vec_vmax[i]+" ";
                }
                //////////////fi
                double []fi= new double [cla];
                String fidat="";
                for (int i = 0; i < fi.length; i++) {
                    fi[i]=(vec_vmin[i]+vec_vmax[i])/2;
                    fidat+=fi[i]+"- ";
                    System.out.println("vector de FIIIIIII :"+fi[i]);
                }

                ///////////////////fr
                int []fr= new int [cla];
                int totF= (int)contFilas;
                System.out.println("N: "+totF);
                String frdat="";
                for (int i = 0; i < fr.length; i++) {
                    fr[i]=(vec_fa[i]*100)/totF;
                    frdat+=fr[i]+"%- ";
                    System.out.println("vector de fr :"+fr[i]);
                }
                //////////////////fa*fi
                double []faxfi= new double [cla];
                double mediaArit=0;
                double SumMArit=0;
                for (int i = 0; i < faxfi.length; i++) {
                    faxfi[i]=vec_fa[i]*fi[i];
                    SumMArit+=faxfi[i];
                    System.out.println("vector de fa*fi :"+faxfi[i]);
                }
                System.out.println("suuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuumaaaaa aritmetica"+SumMArit);
                mediaArit=SumMArit/totF;
                //mediaArit=SumMArit/num_frec;
                System.out.println("Media Aritmetica DA: "+mediaArit);
                //////////////////fa*lg(fi)
                double []fa_lgfi= new double [cla];
                double mediaGeoAux=0;
                double mediaGeo=0;
                double SumGeo=0;
                for (int i = 0; i < fa_lgfi.length; i++) {
                    fa_lgfi[i]=vec_fa[i]* Math.log10(fi[i]);
                    System.out.println("mulllllllllllllllllllll"+vec_fa[i]+"*"+Math.log10(fi[i])+"="+fa_lgfi[i]);
                    SumGeo+=fa_lgfi[i];
                    System.out.println("vector de fa*Log(fi) :"+fa_lgfi[i]);
                }
                mediaGeoAux=SumGeo/totF;
                mediaGeo=(Math.pow(10,mediaGeoAux));
                System.out.println("Media Geometrica DA: "+mediaGeo+">>"+(Math.pow(10,mediaGeo)));
                //////////////////fa/fi
                double mediaArm=0;
                double SumArm=0;
                double []fa_dv_fi= new double [cla];
                for (int i = 0; i < fa_dv_fi.length; i++) {
                    fa_dv_fi[i]=vec_fa[i]/(fi[i]);
                    SumArm+=fa_dv_fi[i];
                    System.out.println("vector de fa/fi :"+fa_dv_fi[i]);
                }
                mediaArm=totF/SumArm;
                System.out.println("Media Armonica DA: "+mediaArm);
                //////////////////fi2*fa
                double []fi2xfa= new double [cla];
                double mediaCua=0;
                double SumCua=0;
                for (int i = 0; i < fi2xfa.length; i++) {
                    fi2xfa[i]=Math.pow(fi[i],2)*vec_fa[i];
                    SumCua+=fi2xfa[i];
                    System.out.println("vector de fi2*fa :"+fi2xfa[i]);
                }
                mediaCua=Math.sqrt((SumCua)/totF);
                System.out.println("Media Cuadratica DA: "+mediaCua);
                //////////////////fa*|fi-x|
                double []faxfix= new double [cla];
                double desMedia=0;
                double SumDesv=0;
                for (int i = 0; i < faxfix.length; i++) {
                    faxfix[i]=vec_fa[i]*(Math.abs(fi[i]-mediaArit));
                    SumDesv+=faxfix[i];
                    System.out.println("vector de fa*|fi-x| :"+faxfix[i]);
                }
                desMedia=SumDesv/totF;
                System.out.println("Desviacion Media  DA: "+desMedia);




                txtResulDA.setMovementMethod(new ScrollingMovementMethod());
                txtResulDA.setText("DATOS  AGRUPADOS"+
                        "\n"+"Numeros Ordenados>:"+order+"max"+vmax+"min"+vmin+
                        "\n"+"Clases>:"+datCla+
                        //"\n"+"Cla_Min>:"+cl_vi+
                        //"\n"+"Cla_Max>:"+cl_vf+
                        "\n"+"  Rango>:"+rango+
                        "  Clase>: "+cla+
                        "  Anchura>: "+anch+
                        "\n"+"Fa>:"+fa_tb+"Fr>:"+frdat+"Fi>:"+fidat+
                        "\n"+" M.Aritmetica>: "+mediaArit+
                        "\n"+" M.Armonica>: "+mediaArm+
                        "\n"+" M.Geometrica>: "+mediaGeo+
                        "\n"+" M.Cuadratica>: "+mediaCua+
                        "\n"+" D.Media>: "+desMedia
                );
                //txtResulDA.setText(order);
            }
        });






    }

    public void  presentar_DNA(View view){

        Intent i = new Intent(this, DNA.class);

        startActivity(i);

    }
}
