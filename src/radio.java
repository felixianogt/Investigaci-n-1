/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlosmartinez
 */
public interface radio {
    
     public void setEstado(boolean Estado);
    
    public boolean getEstado();                          
    
    public int getAMFM();
    
    public void setAMFM(int banda);
    
    public void sintonizar(boolean ud);
    
    public void guardar(int pos);
    
    public void memoria(int pos);
    
    public double getEmisora();
    
}
