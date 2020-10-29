public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    
    private int numeroBilletesVendidos;
    private boolean premio;
    private int maximo;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premioDe, int maximoDe) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        premio = premioDe;
        maximo = maximoDe;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
         if (numeroBilletesVendidos < maximo){
            if (cantidadIntroducida > 0) {
                    balanceClienteActual = balanceClienteActual + cantidadIntroducida;
                }
                else {
                    System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
                }  
         }  
         else{
            System.out.println("Se ha superado el limite de billetes vendidos");
         }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
            
        if (numeroBilletesVendidos < maximo){
        
            if (cantidadDeDineroQueFalta <= 0 ) { 
                    System.out.println("##################");
                    System.out.println("# Billete de tren:");
                    System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                    System.out.println("# " + precioBillete + " euros.");
                    System.out.println("##################");
                    if (premio == true) {
                        System.out.println("tiene un " + precioBillete * 10.00 / 100.00 +"  $ de descuento del coste del ");         
                        System.out.println("billete para compras en el comercio que elijas");
                    }
                    else{ // Simula la impresion de un billete
                        System.out.println();         
                    }  
                    totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                    balanceClienteActual = balanceClienteActual - precioBillete;
                    numeroBilletesVendidos = numeroBilletesVendidos + 1;
                    
                }
                else {
                    System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                            
                } 
            } 
            else {
                System.out.println("Se ha superado el limite de billetes vendidos");
            }
            
            
                      
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    public int vaciarDineroDeLaMaquina() {
        int totalDineroExtraido= -1;
        if (balanceClienteActual == 0){
           totalDineroExtraido = totalDineroAcumulado;
           totalDineroAcumulado = 0; 
        }
        else {
            System.out.println("no se puede extraer el dinero porque");
            System.out.println("hay una operacion en curso");
            
        }
        return totalDineroExtraido;
    }

    public int getNumeroBilletesVendidos(){
        return numeroBilletesVendidos;
    }
    
    public void imprimeNumeroBilletesVendidos(){
    
        System.out.println(numeroBilletesVendidos);
    
    }




}