import java.util.Hashtable;

public class hashTable implements WordSet {
    Hashtable<String, String> arbol = new Hashtable<String, String>();
    public boolean prueba;
   
    @Override
    public void add(Word objeto) {
        String put = arbol.put(objeto.getWord(),objeto.getType());
    }
    @Override
    public Word get(Word palabraNew) {
        arbol.containsValue(palabraNew.getWord());
        prueba=arbol.containsKey(palabraNew.getWord());
        if(prueba==true){
            Word palabra=new Word();
            palabra.setWord(palabraNew.getWord());
            palabra.setType(arbol.get(palabraNew.getWord()));
            return palabra;
        }else{
            return null;
        }
      }
}