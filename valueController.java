public class valueController{

    double saldo;

    double getSaldo(){
        return saldo;
    }

    boolean setSaldo(double valor){
        if(valor>0){
            this.saldo = this.saldo+=valor;
            return true;
        }else{
            return false;
        }
    }

    boolean setRemoveValue(double valor){
        if(valor > 0){
            this.saldo = this.saldo-=valor;
            return true;
        }else{
            return false;
        }
    }
}